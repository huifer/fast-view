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

package com.github.huifer.view.sample.common;

import java.util.Map;

import javax.servlet.http.HttpServlet;

import com.github.huifer.view.common.conf.HfViewConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 *
 * @author huifer
 */
@SpringBootApplication
public class App {
	@Autowired
	private HfViewConfig hfViewConfig;

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
		Map<String, HttpServlet> beansOfType = run.getBeansOfType(HttpServlet.class);
		HfViewConfig bean = run.getBean(HfViewConfig.class);
		System.out.println();
	}

}
