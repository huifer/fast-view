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

package com.github.huifer.fast.view.zookeeper.core.model;

/** zookeeper 节点信息 */
public class ZkNodeInfo {

  /** zk stat */
  private ZkStat stat;
  /** 数据 */
  private String data;
  /**
   * * 节点类型:
   *
   * <ol>
   *   <li>持久化节点
   *   <li>临时节点
   * </ol>
   */
  private String type;

  public ZkNodeInfo(ZkStat stat, String data, String type) {
    this.stat = stat;
    this.data = data;
    this.type = type;
  }

  public ZkStat getStat() {
    return stat;
  }

  public void setStat(ZkStat stat) {
    this.stat = stat;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
