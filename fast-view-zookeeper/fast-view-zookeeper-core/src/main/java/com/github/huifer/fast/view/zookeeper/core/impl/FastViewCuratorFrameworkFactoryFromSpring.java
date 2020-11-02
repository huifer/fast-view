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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.zookeeper.ZookeeperProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author huifer
 */
@Service("fastViewCuratorFrameworkFactoryFromSpring")
public class FastViewCuratorFrameworkFactoryFromSpring implements FastViewCuratorFrameworkFactory {

	@Autowired
	public ApplicationContext context;

	@Override
	public CuratorFramework factory(ZookeeperProperties properties, RetryPolicy retryPolicy) {
		return context.getBean(CuratorFramework.class);
	}
}
