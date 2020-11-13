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

package com.github.huifer.fast.view.center.client.enable.selector;

import java.util.Map;

import com.github.huifer.fast.view.center.client.core.utils.FastViewCenterClientDataStore;
import com.github.huifer.fast.view.center.client.enable.ann.EnableFastViewCenterClient;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 *
 * @author huifer
 */
public class EnableFastViewCenterClientSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata annotationMetadata) {
		Map<String, Object> annotationAttributes = annotationMetadata
				.getAnnotationAttributes(EnableFastViewCenterClient.class.getName());

		String centerHostPort = (String) annotationAttributes.get("centerHostPort");
		FastViewCenterClientDataStore.setHostPort(centerHostPort);
		return new String[0];
	}
}
