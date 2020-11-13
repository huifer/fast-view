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

package com.github.huifer.fast.view.center.core.repository;

import com.github.huifer.fast.view.center.core.model.RedisConfigEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 *
 *
 * @author huifer
 */
public interface RedisConfigRepository extends
		Repository<RedisConfigEntity, Integer>,
		CrudRepository<RedisConfigEntity, Integer>,
		JpaRepository<RedisConfigEntity, Integer>,
		PagingAndSortingRepository<RedisConfigEntity, Integer> {


	@Query("select r from RedisConfigEntity r where r.appId = :appId")
	RedisConfigEntity findByAppId(@Param(value = "appId") Integer appId);
}
