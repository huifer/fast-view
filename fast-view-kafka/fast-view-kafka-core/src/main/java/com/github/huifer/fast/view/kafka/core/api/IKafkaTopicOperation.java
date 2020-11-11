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

package com.github.huifer.fast.view.kafka.core.api;

import java.util.Map;

import com.github.huifer.fast.view.kafka.core.model.CreateTopicParam;
import com.github.huifer.fast.view.kafka.core.model.TopicVO;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 *	 kafka topic operation
 *
 * @author huifer
 */
public interface IKafkaTopicOperation {

	/**
	 * 创建topic
	 *
	 * @param createTopicParam 创建topic的请求参数
	 * @return true 成功, false 失败
	 */
	boolean createTopic(CreateTopicParam createTopicParam,
			AdminClient adminClient);

	/**
	 * 删除 topic
	 *
	 * @param topic topic 名称
	 * @return true 成功, false 失败
	 */
	boolean deleteTopic(String topic, AdminClient adminClient);

	/**
	 * 获取topic信息
	 *
	 * @return key: topic name , value: topic 信息
	 */
	Map<String, TopicVO> getTopics(KafkaConsumer<byte[], byte[]> kafkaConsumer);

	/**
	 * 获取topic信息
	 *
	 * @param topic topic名称
	 * @return topic 信息
	 */
	TopicVO topicInfo(String topic, KafkaConsumer<byte[], byte[]> kafkaConsumer);
}
