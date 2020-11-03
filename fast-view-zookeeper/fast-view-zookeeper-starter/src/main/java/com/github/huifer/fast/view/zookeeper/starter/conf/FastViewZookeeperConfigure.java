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

package com.github.huifer.fast.view.zookeeper.starter.conf;

import com.github.huifer.fast.view.common.conf.FastViewConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fast.view")
public class FastViewZookeeperConfigure extends FastViewConfig {

	private Zk zk;

	public Zk getZk() {
		return zk;
	}

	public void setZk(Zk zk) {
		this.zk = zk;
	}

	public static class Zk {
		private String urlMapping;

		public String getUrlMapping() {
			return urlMapping;
		}

		public void setUrlMapping(String urlMapping) {
			this.urlMapping = urlMapping;
		}
	}
}