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

package com.github.huifer.fast.view.center.common.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.github.huifer.fast.view.center.common.constant.HttpHeaderConstant;
import com.github.huifer.fast.view.center.common.constant.MediaType;
import org.apache.commons.lang3.StringUtils;

/**
 * http header
 */
public class Header {

	public static final Header EMPTY = Header.newInstance();

	private final Map<String, String> header;

	private final Map<String, List<String>> originalResponseHeader;

	private Header() {
		header = new LinkedHashMap<String, String>();
		originalResponseHeader = new LinkedHashMap<>();
		addParam(HttpHeaderConstant.CONTENT_TYPE, MediaType.APPLICATION_JSON);
		addParam(HttpHeaderConstant.ACCEPT_CHARSET, "UTF-8");
		addParam(HttpHeaderConstant.ACCEPT_ENCODING, "gzip");
	}

	public static Header newInstance() {
		return new Header();
	}

	public Header addAll(List<String> list) {
		if ((list.size() & 1) != 0) {
			throw new IllegalArgumentException("list size must be a multiple of 2");
		}
		for (int i = 0; i < list.size(); ) {
			String key = list.get(i++);
			if (StringUtils.isNotEmpty(key)) {
				header.put(key, list.get(i++));
			}
		}
		return this;
	}

	public Header addParam(String key, String value) {
		if (StringUtils.isNotBlank(key)) {
			header.put(key, value);
		}
		return this;
	}

	public Header setContentType(String contentType) {
		if (contentType == null) {
			contentType = MediaType.APPLICATION_JSON;
		}
		return addParam(HttpHeaderConstant.CONTENT_TYPE, contentType);
	}

	public Header build() {
		return this;
	}

	public String getValue(String key) {
		return header.get(key);
	}

	public Map<String, String> getHeader() {
		return header;
	}

	public Iterator<Map.Entry<String, String>> iterator() {
		return header.entrySet().iterator();
	}

}