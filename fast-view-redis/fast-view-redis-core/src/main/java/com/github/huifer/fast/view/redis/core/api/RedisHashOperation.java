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

package com.github.huifer.fast.view.redis.core.api;

import java.util.Map;

import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;


/**
 * redis 的 hash 数据类型操作
 * @author huifer
 * */
public interface RedisHashOperation extends IRedisOperationLabel {

	/**
	 * @param config redis 连接配置
	 * @param k 键
	 * @param field 小键
	 * @param v 值
	 */
	void add(RedisConnectionConfig config, String k, String field, String v);

	/**
	 * 获取 hash 数据
	 *
	 * @param config redis 连接配置
	 * @param k 键
	 * @return 值
	 */
	Map get(RedisConnectionConfig config, String k);

	/**
	 * 删除hash 的field
	 *
	 * @param config redis 连接配置
	 * @param k 键
	 * @param field 小键
	 */
	void del(RedisConnectionConfig config, String k, String field);

	/**
	 * 修改
	 * 	k下field中的value值
	 * @param config redis 连接配置
	 * @param k 键
	 * @param field 小键
	 * @param v 值
	 */
	void update(RedisConnectionConfig config, String k, String field, String v);

	/**
	 * 修改 field 的名称
	 * @param config   redis 连接配置
	 * @param k 键
	 * @param oldField 旧的小键
	 * @param newField 新的小键
	 * @param v 值
	 */
	void upAndSave(RedisConnectionConfig config, String k, String oldField, String newField, String v);
}
