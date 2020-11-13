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

package com.github.huifer.view.sample.center;

import com.github.huifer.fast.view.center.client.core.beans.ConsumerBeans;
import com.github.huifer.fast.view.center.client.core.service.impl.ReadSpringBootConfigService;
import com.github.huifer.fast.view.center.client.enable.ann.EnableFastViewCenterClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 *
 *
 * @author huifer
 */

@SpringBootApplication
@Import(ConsumerBeans.class)
@EnableFastViewCenterClient(centerHostPort = "http://localhost:9010")
public class CenterSampleApp {
	private static final Logger log = LoggerFactory.getLogger(CenterSampleApp.class);

	@Autowired
	private ReadSpringBootConfigService springBootConfigService;

	public static void main(String[] args) {
		SpringApplication.run(CenterSampleApp.class, args);
	}

	@Bean
	public ApplicationRunner runner() {
		return args -> {
			System.out.println("启动成功");
		};

//		ApplicationRunner applicationRunner = (arguments) -> {
//			String s = springBootConfigService.readConfig();
//			Map<String, String> map = new HashMap<>();
//			map.put("data", s);
//			FastViewHttpClient.httpPost("http://localhost:9010/config/gather/allConfig", null, map);
//		};
//		return applicationRunner;
	}
}
