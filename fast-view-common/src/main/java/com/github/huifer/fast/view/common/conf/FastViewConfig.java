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

package com.github.huifer.fast.view.common.conf;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.github.huifer.fast.view.common.Const.DEFAULT_PASSWORD;
import static com.github.huifer.fast.view.common.Const.DEFAULT_USERNAME;

/**
 *
 *
 * @author huifer
 */
@ConfigurationProperties(prefix = "fast.view")
public class FastViewConfig {

	/**
	 * 登录名
	 */
	private String username = DEFAULT_USERNAME;

	/**
	 * 密码
	 */
	private String password = DEFAULT_PASSWORD;

	private Ip ip = new Ip();


	public Ip getIp() {
		return ip;
	}

	public void setIp(Ip ip) {
		this.ip = ip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class Ip {
		/**
		 * 白名单
		 */
		private List<String> all;

		/**
		 * 黑名单
		 */
		private List<String> deny;

		public List<String> getAll() {
			return all;
		}

		public void setAll(List<String> all) {
			this.all = all;
		}

		public List<String> getDeny() {
			return deny;
		}

		public void setDeny(List<String> deny) {
			this.deny = deny;
		}
	}
}
