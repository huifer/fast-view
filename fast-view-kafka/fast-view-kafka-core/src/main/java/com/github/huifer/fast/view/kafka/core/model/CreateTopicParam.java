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

package com.github.huifer.fast.view.kafka.core.model;

public class CreateTopicParam {
	/** topic 名称 */
	private String name;

	/** partitions 编号, 分区数量 <b>default value = 0 </b> */
	private Integer partitionsNum = 0;

	/** 副本数量 <b>default value = 0 </b> */
	private Short replicationFactor = 0;

	public CreateTopicParam() {
	}

	public CreateTopicParam(String name, Integer partitionsNum, Short replicationFactor) {
		this.name = name;
		this.partitionsNum = partitionsNum;
		this.replicationFactor = replicationFactor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPartitionsNum() {
		return partitionsNum;
	}

	public void setPartitionsNum(Integer partitionsNum) {
		this.partitionsNum = partitionsNum;
	}

	public Short getReplicationFactor() {
		return replicationFactor;
	}

	public void setReplicationFactor(Short replicationFactor) {
		this.replicationFactor = replicationFactor;
	}

	@Override
	public String toString() {
		return "CreateTopicParam{" +
				"name='" + name + '\'' +
				", partitionsNum=" + partitionsNum +
				", replicationFactor=" + replicationFactor +
				'}';
	}
}