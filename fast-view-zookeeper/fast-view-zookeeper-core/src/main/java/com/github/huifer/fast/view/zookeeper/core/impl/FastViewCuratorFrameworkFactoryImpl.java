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

package com.github.huifer.fast.view.zookeeper.core.impl;

import com.github.huifer.fast.view.zookeeper.core.api.FastViewCuratorFrameworkFactory;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;

import org.springframework.cloud.zookeeper.ZookeeperProperties;

/**
 *
 *
 * @author huifer
 */
public class FastViewCuratorFrameworkFactoryImpl implements FastViewCuratorFrameworkFactory {
	@Override
	public CuratorFramework factory(ZookeeperProperties properties, RetryPolicy retryPolicy) {

		org.apache.curator.framework.CuratorFrameworkFactory.Builder builder = org.apache.curator.framework.CuratorFrameworkFactory.builder();

		builder.connectString(properties.getConnectString());
		builder.sessionTimeoutMs((int) properties.getSessionTimeout().toMillis())
				.connectionTimeoutMs((int) properties.getConnectionTimeout().toMillis())
				.retryPolicy(retryPolicy);

		CuratorFramework curator = builder.build();

		curator.start();
		return curator;
	}
}
