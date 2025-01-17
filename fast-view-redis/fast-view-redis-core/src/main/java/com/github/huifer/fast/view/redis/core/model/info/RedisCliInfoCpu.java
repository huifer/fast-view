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

package com.github.huifer.fast.view.redis.core.model.info;

public class RedisCliInfoCpu {
	private String usedCpuSys;

	private String usedCpuUser;

	private String usedCpuSysChildren;

	private String usedCpuUserChildren;

	public String getUsedCpuSys() {
		return usedCpuSys;
	}

	public void setUsedCpuSys(String usedCpuSys) {
		this.usedCpuSys = usedCpuSys;
	}

	public String getUsedCpuUser() {
		return usedCpuUser;
	}

	public void setUsedCpuUser(String usedCpuUser) {
		this.usedCpuUser = usedCpuUser;
	}

	public String getUsedCpuSysChildren() {
		return usedCpuSysChildren;
	}

	public void setUsedCpuSysChildren(String usedCpuSysChildren) {
		this.usedCpuSysChildren = usedCpuSysChildren;
	}

	public String getUsedCpuUserChildren() {
		return usedCpuUserChildren;
	}

	public void setUsedCpuUserChildren(String usedCpuUserChildren) {
		this.usedCpuUserChildren = usedCpuUserChildren;
	}
}
