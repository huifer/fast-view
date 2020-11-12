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

import java.util.Properties;

import com.github.huifer.fast.view.kafka.core.api.IKafkaTopicOperation;
import com.github.huifer.fast.view.kafka.core.model.CreateTopicParam;
import com.github.huifer.fast.view.kafka.core.model.TopicVO;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Before;

/**
 *
 *
 * @author huifer
 */
public class IKafkaTopicOperationImplTest {
	public final String brokerUrl = "localhost:9092";

	KafkaConsumer<byte[], byte[]> consumer;

	IKafkaTopicOperation kafkaTopicOperation;

	private AdminClient adminClient;

	@Before
	public void initAdminClient() {
		Properties properties = new Properties();
		properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
		adminClient = AdminClient.create(properties);
		kafkaTopicOperation = new IKafkaTopicOperationImpl();


		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "kafkatest");
		props.put("enable.auto.commit", "true");
		props.put("auto.offset.reset", "earliest");
		props.put("auto.commit.interval.ms", "1000");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.BytesDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.BytesDeserializer");
		consumer = new KafkaConsumer<>(props);

	}

	@org.junit.Test
	public void createTopic() {
		CreateTopicParam createTopicParam = new CreateTopicParam();
		createTopicParam.setName("test");
		createTopicParam.setPartitionsNum(4);
		createTopicParam.setReplicationFactor((short) 1);

		boolean topic = kafkaTopicOperation.createTopic(createTopicParam, adminClient);
		if (topic) {
			TopicVO test = kafkaTopicOperation.topicInfo("test", consumer);
			assert test != null;
		}
	}

	@org.junit.Test
	public void deleteTopic() {
		boolean test = kafkaTopicOperation.deleteTopic("test", adminClient);
		if (test) {
			TopicVO t2 = kafkaTopicOperation.topicInfo("test", consumer);
			assert t2 == null;

		}
	}

	@org.junit.Test
	public void getTopics() {
	}

	@org.junit.Test
	public void topicInfo() {
	}
}