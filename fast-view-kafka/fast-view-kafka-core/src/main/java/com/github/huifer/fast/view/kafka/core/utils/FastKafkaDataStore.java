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

package com.github.huifer.fast.view.kafka.core.utils;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

import org.springframework.kafka.core.KafkaTemplate;

/**
 * kafka 数据
 *
 * @author huifer
 */
public class FastKafkaDataStore {

	public static AdminClient adminClient;

	public static KafkaConsumer<byte[], byte[]> kafkaConsumer;

	public static KafkaProducer<byte[], byte[]> kafkaProducer;

	public static KafkaTemplate kafkaTemplate;

	public static AdminClient getAdminClient() {
		return adminClient;
	}

	public static void setAdminClient(AdminClient adminClient) {
		FastKafkaDataStore.adminClient = adminClient;
	}

	public static KafkaConsumer<byte[], byte[]> getKafkaConsumer() {
		return kafkaConsumer;
	}

	public static void setKafkaConsumer(KafkaConsumer<byte[], byte[]> kafkaConsumer) {
		FastKafkaDataStore.kafkaConsumer = kafkaConsumer;
	}

	public static KafkaProducer<byte[], byte[]> getKafkaProducer() {
		return kafkaProducer;
	}

	public static void setKafkaProducer(KafkaProducer<byte[], byte[]> kafkaProducer) {
		FastKafkaDataStore.kafkaProducer = kafkaProducer;
	}

	public static KafkaTemplate getKafkaTemplate() {
		return kafkaTemplate;
	}

	public static void setKafkaTemplate(KafkaTemplate kafkaTemplate) {
		FastKafkaDataStore.kafkaTemplate = kafkaTemplate;
	}
}
