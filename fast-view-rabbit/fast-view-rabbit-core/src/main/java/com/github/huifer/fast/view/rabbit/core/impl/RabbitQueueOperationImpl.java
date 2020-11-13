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

package com.github.huifer.fast.view.rabbit.core.impl;

import java.util.List;

import com.github.huifer.fast.view.rabbit.core.api.RabbitQueueOperation;
import com.rabbitmq.http.client.Client;
import com.rabbitmq.http.client.domain.QueueInfo;


/**
 *
 *
 * @author huifer
 */
public class RabbitQueueOperationImpl implements RabbitQueueOperation {
	/**
	 * 获取 queue 列表
	 */
	public List<QueueInfo> queues(Client client) {
		return client.getQueues();
	}

	/**
	 * 获取单个queue
	 */
	public Object queueQuery(Client client, String name) {
		return client.getQueue("/",name);
	}

//	public boolean deleteQueue(RabbitManagementTemplate rabbitManagementTemplate, String name) {
//		Queue queue = queueQuery(rabbitManagementTemplate, name);
//		if (queue != null) {
//			rabbitManagementTemplate.deleteQueue(queue);
//			return true;
//		}
//		return false;
//	}
//
//	public void execute(RabbitManagementTemplate rabbitManagementTemplate) {
//		List<Binding> bindings = rabbitManagementTemplate.getBindings();
//	}
}
