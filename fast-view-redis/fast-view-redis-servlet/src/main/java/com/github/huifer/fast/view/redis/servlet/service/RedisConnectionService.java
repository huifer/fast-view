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

package com.github.huifer.fast.view.redis.servlet.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 * @author huifer
 */
public interface RedisConnectionService {
	/**
	 * 是否启用redis
	 * @return true/ false
	 */
	boolean redis();

	/**
	 * 是否启用redis-cluster
	 * @return true/false
	 */
	boolean cluster();

	void handler(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
