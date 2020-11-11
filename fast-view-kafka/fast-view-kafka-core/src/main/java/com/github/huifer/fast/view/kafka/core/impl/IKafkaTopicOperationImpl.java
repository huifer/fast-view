/*
 *
 * Copyright 2020 HuiFer All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.huifer.fast.view.kafka.core.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.github.huifer.fast.view.kafka.core.api.IKafkaTopicOperation;
import com.github.huifer.fast.view.kafka.core.model.CreateTopicParam;
import com.github.huifer.fast.view.kafka.core.model.TopicPartitionVO;
import com.github.huifer.fast.view.kafka.core.model.TopicVO;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.DeleteTopicsOptions;
import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.PartitionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author huifer
 */
public class IKafkaTopicOperationImpl implements IKafkaTopicOperation {
	private static final Logger log = LoggerFactory.getLogger(IKafkaTopicOperationImpl.class);

	@Override
	public boolean createTopic(CreateTopicParam createTopicParam, AdminClient adminClient) {
		if (log.isDebugEnabled()) {
			log.debug("create topic param = [{}]", createTopicParam);
		}
		NewTopic newTopic = new NewTopic(createTopicParam.getName(),
				createTopicParam.getPartitionsNum(),
				createTopicParam.getReplicationFactor());

		CreateTopicsResult topics = adminClient.createTopics(Collections.singleton(newTopic));

		try {
			topics.all().get();
			return true;
		}
		catch (Exception e) {
			log.error("create kafka topic error . ", e);
		}

		return false;
	}

	@Override
	public boolean deleteTopic(String topic, AdminClient adminClient) {

		if (log.isDebugEnabled()) {
			log.debug("delete kafka topic param =[{}]", topic);
		}

		DeleteTopicsOptions deleteTopicsOptions = new DeleteTopicsOptions();
		deleteTopicsOptions.timeoutMs(5000);

		DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Collections.singletonList(topic), deleteTopicsOptions);

		try {
			deleteTopicsResult.all().get();
			return true;
		}
		catch (Exception e) {
			log.error("delete kafka topic error . ", e);
		}

		return false;
	}

	@Override
	public Map<String, TopicVO> getTopics(KafkaConsumer<byte[], byte[]> kafkaConsumer) {
		Set<String> topics = kafkaConsumer.listTopics().keySet();
		Map<String, TopicVO> result = new HashMap<>(topics.size());

		for (String topic : topics) {
			TopicVO topicInfo = topicInfo(topic, kafkaConsumer);
			result.put(topic, topicInfo);
		}
		return result;
	}

	@Override
	public TopicVO topicInfo(String topic, KafkaConsumer<byte[], byte[]> kafkaConsumer) {
		List<PartitionInfo> partitionInfos = kafkaConsumer.partitionsFor(topic);

		TopicVO topicVO = new TopicVO();
		topicVO.setName(topic);

		Map<Integer, TopicPartitionVO> partitions = new TreeMap<>();

		for (PartitionInfo partitionInfo : partitionInfos) {
			int partition = partitionInfo.partition();
			TopicPartitionVO topicPartitionVO = new TopicPartitionVO();
			topicPartitionVO.setId(partition);

			Set<Integer> inSyncReplicas = Arrays.stream(partitionInfo.inSyncReplicas())
					.map(Node::id)
					.collect(Collectors.toSet());
			Set<Integer> offlineReplicas = Arrays.stream(partitionInfo.offlineReplicas())
					.map(Node::id)
					.collect(Collectors.toSet());

			for (Node replica : partitionInfo.replicas()) {
				boolean isInSync = inSyncReplicas.contains(replica.id());
				boolean isInOffline = offlineReplicas.contains(replica.id());

				topicPartitionVO.addReplica(new TopicPartitionVO.PartitionReplica(
						replica.id(), isInSync, false, isInOffline)
				);
			}

			Node leader = partitionInfo.leader();
			if (leader != null) {
				topicPartitionVO
						.addReplica(new TopicPartitionVO.PartitionReplica(leader.id(), true, true, false));
			}
			partitions.put(partitionInfo.partition(), topicPartitionVO);
		}
		topicVO.setPartitionVOMap(partitions);


		return topicVO;
	}
}
