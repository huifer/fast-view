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

package com.github.huifer.fast.view.zookeeper.starter.runner;

import com.github.huifer.fast.view.zookeeper.core.api.FastViewCuratorFrameworkFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.zookeeper.ZookeeperProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *
 *
 * @author huifer
 */
@Component
public class FastZookeeperRunner implements CommandLineRunner {
	@Autowired
	private ApplicationContext context;

	@Autowired
	@Qualifier("fastViewCuratorFrameworkFactoryFromSpring")
	private FastViewCuratorFrameworkFactory fastViewCuratorFrameworkFactory;

	@Override
	public void run(String... args) throws Exception {

		ZookeeperProperties zookeeperProperties = context.getBean(ZookeeperProperties.class);
		if (zookeeperProperties != null) {
			String connectString = zookeeperProperties.getConnectString();
			if (!StringUtils.isEmpty(connectString)) {
				System.out.println("hello");
			}
		}

	}
}
