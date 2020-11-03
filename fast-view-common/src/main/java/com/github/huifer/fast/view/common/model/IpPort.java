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

package com.github.huifer.fast.view.common.model;

import java.util.Objects;

/**
 *Ip Port
 *
 * @author huifer
 */
public class IpPort {
	private String ip;

	private int port;

	public IpPort() {
	}

	public IpPort(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IpPort ipPort = (IpPort) o;
		return port == ipPort.port &&
				Objects.equals(ip, ipPort.ip);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ip, port);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
