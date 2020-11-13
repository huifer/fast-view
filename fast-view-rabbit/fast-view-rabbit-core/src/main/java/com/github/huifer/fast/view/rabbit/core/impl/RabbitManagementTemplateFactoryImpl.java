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

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.github.huifer.fast.view.rabbit.core.api.RabbitManagementTemplateFactory;
import com.rabbitmq.http.client.Client;

/**
 * RabbitManagementTemplateFactory impl
 *
 * @author huifer
 */
public class RabbitManagementTemplateFactoryImpl implements RabbitManagementTemplateFactory {
	@Override
	public Client factory(String uri, String username, String password) throws MalformedURLException, URISyntaxException {
		return new Client(
				uri,
				username,
				password
		);
	}
}
