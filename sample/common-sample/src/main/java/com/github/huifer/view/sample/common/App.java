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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;

import com.github.huifer.fast.view.common.Const;
import com.github.huifer.fast.view.common.conf.FastViewConfig;
import com.github.huifer.fast.view.common.servlet.ResourceServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 *
 * @author huifer
 */
@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Autowired private ApplicationContext context;

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
	}

	@Bean
	public ServletRegistrationBean commonServlet() {
		if (log.isDebugEnabled()) {
			log.debug("开始初始化common servlet");
		}
		ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
		servletServletRegistrationBean.setServlet(new ResourceServlet("/support/"));
		Map<String, String> initParams = new HashMap<>(10);
		FastViewConfig bean = context.getBean(FastViewConfig.class);


		if (bean != null && !bean.equals(new FastViewConfig())) {

			initParams.put(Const.PARAM_NAME_USERNAME, bean.getUsername());
			initParams.put(Const.PARAM_NAME_PASSWORD, bean.getPassword());

		}
		servletServletRegistrationBean.setInitParameters(initParams);
		servletServletRegistrationBean.addUrlMappings("/common/*");
		if (log.isDebugEnabled()) {
			log.debug("开始初始化common servlet 完成.");
		}
		return servletServletRegistrationBean;
	}

}
