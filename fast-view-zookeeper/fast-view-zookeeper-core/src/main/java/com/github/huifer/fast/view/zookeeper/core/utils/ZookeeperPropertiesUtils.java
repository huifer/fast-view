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

package com.github.huifer.fast.view.zookeeper.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.github.huifer.fast.view.common.model.IpPort;

import org.springframework.cloud.zookeeper.ZookeeperProperties;

/**
 * spring zookeeper properties util.
 *
 * @author huifer
 */
public class ZookeeperPropertiesUtils {

	private ZookeeperPropertiesUtils() {
	}

	/**
	 * 获取 zookeeper properties 中 connection 列表
	 */
	public static List<String> getConnections(ZookeeperProperties zookeeperProperties) {
		String connectString = zookeeperProperties.getConnectString();
		return Arrays.stream(connectString.split(";")).collect(Collectors.toList());
	}

	/**
	 * 获取 zookeeper properties 中 connection 中的 ip port 列表
	 */
	public static List<IpPort> getIpPorts(ZookeeperProperties zookeeperProperties) {
		List<String> connections = getConnections(zookeeperProperties);
		List<IpPort> res = new ArrayList<>(connections.size());
		for (String connection : connections) {
			String[] split = connection.split(":");
			if (split.length == 2) {
				String ip = split[0];
				String port = split[1];
				res.add(new IpPort(ip, Integer.parseInt(port)));
			}
		}
		return res;
	}

}
