# zookeeper四字命令

## conf

```
clientPort=2181
secureClientPort=-1
dataDir=D:\dev_tool\zk\2181\version-2
dataDirSize=67109337
dataLogDir=D:\dev_tool\zk\2181\version-2
dataLogSize=67109337
tickTime=2000
maxClientCnxns=60
minSessionTimeout=4000
maxSessionTimeout=40000
clientPortListenBacklog=-1
serverId=0

```

## cons

```
 /127.0.0.1:61786[0](queued=0,recved=1,sent=0)
```





## crst

```
Connection stats reset.

```

## dump

```
SessionTracker dump:
Session Sets (0)/(0):
ephemeral nodes dump:
Sessions with Ephemerals (0):
Connections dump:
Connections Sets (1)/(2):
1 expire at Tue Nov 03 10:00:19 CST 2020:
	ip: /127.0.0.1:61857 sessionId: 0x0

```

## envi

```
Environment:
zookeeper.version=3.6.1--104dcb3e3fb464b30c5186d229e00af9f332524b, built on 04/21/2020 15:01 GMT
host.name=LAPTOP-D7DF36F6
java.version=1.8.0_252
java.vendor=Oracle Corporation
java.home=D:\Program Files\RedHat\java-1.8.0-openjdk-1.8.0.252-2\jre
java.class.path=D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\build\classes;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\build\lib\*;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\*;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\audience-annotations-0.5.0.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\commons-cli-1.2.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\commons-lang-2.6.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jackson-annotations-2.10.3.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jackson-core-2.10.3.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jackson-databind-2.10.3.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\javax.servlet-api-3.1.0.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jetty-http-9.4.24.v20191120.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jetty-io-9.4.24.v20191120.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jetty-security-9.4.24.v20191120.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jetty-server-9.4.24.v20191120.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jetty-servlet-9.4.24.v20191120.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jetty-util-9.4.24.v20191120.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\jline-2.11.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\json-simple-1.1.1.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\log4j-1.2.17.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\metrics-core-3.2.5.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\netty-buffer-4.1.48.Final.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\netty-codec-4.1.48.Final.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\netty-common-4.1.48.Final.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\netty-handler-4.1.48.Final.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\netty-resolver-4.1.48.Final.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\netty-transport-4.1.48.Final.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\netty-transport-native-epoll-4.1.48.Final.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\netty-transport-native-unix-common-4.1.48.Final.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\simpleclient-0.6.0.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\simpleclient_common-0.6.0.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\simpleclient_hotspot-0.6.0.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\simpleclient_servlet-0.6.0.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\slf4j-api-1.7.25.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\slf4j-log4j12-1.7.25.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\snappy-java-1.1.7.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\zookeeper-3.6.1.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\zookeeper-jute-3.6.1.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\lib\zookeeper-prometheus-metrics-3.6.1.jar;D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin\..\conf
java.library.path=D:\Program Files\RedHat\java-1.8.0-openjdk-1.8.0.252-2\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;D:\Program Files (x86)\NetSarang\Xshell 6\;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Windows\System32\OpenSSH\;C:\Program Files (x86)\NVIDIA Corporation\PhysX\Common;C:\Program Files\NVIDIA Corporation\NVIDIA NvDLISR;D:\Program Files\RedHat\java-1.8.0-openjdk-1.8.0.252-2\bin;D:\Program Files\RedHat\java-1.8.0-openjdk-1.8.0.252-2\jre\bin;D:\Go\bin;D:\Program Files (x86)\Gpg4win\..\GnuPG\bin;D:\Program Files\nodejs\;D:\Program Files\TortoiseSVN\bin;D:\Program Files\Git\cmd;C:\Users\admin\AppData\Local\Programs\Python\Python39\Scripts\;C:\Users\admin\AppData\Local\Programs\Python\Python39\;C:\Users\admin\AppData\Local\Microsoft\WindowsApps;D:\Programs\Microsoft VS Code\bin;C:\Users\admin\go\bin;D:\apache-maven-3.6.3-bin\apache-maven-3.6.3\bin;D:\dev_tool\gradle-5.6.4\bin;D:\Program Files\Vim\vim82;C:\Users\admin\AppData\Roaming\npm;D:\Ruby22-x64\bin;;.
java.io.tmpdir=C:\Users\admin\AppData\Local\Temp\
java.compiler=<NA>
os.name=Windows 10
os.arch=amd64
os.version=10.0
user.name=admin
user.home=C:\Users\admin
user.dir=D:\dev_tool\zk\apache-zookeeper-3.6.1-2181\bin
os.memory.free=96MB
os.memory.max=1783MB
os.memory.total=121MB


```

## ruok



```
imok
```

## srst

```
Server stats reset.

```





## srvr

```
Zookeeper version: 3.6.1--104dcb3e3fb464b30c5186d229e00af9f332524b, built on 04/21/2020 15:01 GMT
Latency min/avg/max: 0/0.0/0
Received: 1
Sent: 1
Connections: 1
Outstanding: 0
Zxid: 0x5c
Mode: standalone
Node count: 8

```

## stat

```
Zookeeper version: 3.6.1--104dcb3e3fb464b30c5186d229e00af9f332524b, built on 04/21/2020 15:01 GMT
Clients:
 /127.0.0.1:62000[0](queued=0,recved=1,sent=0)

Latency min/avg/max: 0/0.0/0
Received: 2
Sent: 2
Connections: 1
Outstanding: 0
Zxid: 0x5c
Mode: standalone
Node count: 8
```





## wchs

```
0 connections watching 0 paths
Total watches:0
```

## wchc

## wchp

## mntr

```
zk_version	3.6.1--104dcb3e3fb464b30c5186d229e00af9f332524b, built on 04/21/2020 15:01 GMT
zk_server_state	standalone
zk_ephemerals_count	0
zk_min_latency	0
zk_avg_latency	0.0
zk_num_alive_connections	1
zk_max_file_descriptor_count	-1
zk_outstanding_requests	0
zk_approximate_data_size	86
zk_znode_count	8
zk_open_file_descriptor_count	-1
zk_global_sessions	0
zk_local_sessions	0
zk_uptime	65612622
zk_last_client_response_size	-1
zk_max_latency	0
zk_packets_sent	6
zk_outstanding_tls_handshake	0
zk_packets_received	6
zk_max_client_response_size	-1
zk_connection_drop_probability	0.0
zk_watch_count	0
zk_min_client_response_size	-1
zk_proposal_count	0
zk_outstanding_changes_removed	0
zk_stale_requests_dropped	0
zk_large_requests_rejected	0
zk_connection_rejected	0
zk_sessionless_connections_expired	0
zk_looking_count	0
zk_dead_watchers_queued	0
zk_stale_requests	0
zk_connection_drop_count	0
zk_learner_proposal_received_count	0
zk_digest_mismatches_count	0
zk_dead_watchers_cleared	0
zk_response_packet_cache_hits	0
zk_bytes_received_count	24
zk_add_dead_watcher_stall_time	0
zk_request_throttle_wait_count	0
zk_response_packet_cache_misses	0
zk_ensemble_auth_success	0
zk_prep_processor_request_queued	0
zk_learner_commit_received_count	0
zk_stale_replies	0
zk_connection_request_count	0
zk_ensemble_auth_fail	0
zk_diff_count	0
zk_response_packet_get_children_cache_misses	0
zk_connection_revalidate_count	0
zk_quit_leading_due_to_disloyal_voter	0
zk_snap_count	0
zk_unrecoverable_error_count	0
zk_commit_count	0
zk_stale_sessions_expired	0
zk_response_packet_get_children_cache_hits	0
zk_sync_processor_request_queued	0
zk_outstanding_changes_queued	0
zk_request_commit_queued	0
zk_ensemble_auth_skip	0
zk_tls_handshake_exceeded	0
zk_revalidate_count	0
zk_avg_node_created_watch_count	0.0
zk_min_node_created_watch_count	0
zk_max_node_created_watch_count	0
zk_cnt_node_created_watch_count	0
zk_sum_node_created_watch_count	0
zk_avg_session_queues_drained	0.0
zk_min_session_queues_drained	0
zk_max_session_queues_drained	0
zk_cnt_session_queues_drained	0
zk_sum_session_queues_drained	0
zk_avg_write_commit_proc_req_queued	0.0
zk_min_write_commit_proc_req_queued	0
zk_max_write_commit_proc_req_queued	0
zk_cnt_write_commit_proc_req_queued	0
zk_sum_write_commit_proc_req_queued	0
zk_avg_connection_token_deficit	0.0
zk_min_connection_token_deficit	0
zk_max_connection_token_deficit	0
zk_cnt_connection_token_deficit	0
zk_sum_connection_token_deficit	0
zk_avg_read_commit_proc_req_queued	0.0
zk_min_read_commit_proc_req_queued	0
zk_max_read_commit_proc_req_queued	0
zk_cnt_read_commit_proc_req_queued	0
zk_sum_read_commit_proc_req_queued	0
zk_avg_node_deleted_watch_count	0.0
zk_min_node_deleted_watch_count	0
zk_max_node_deleted_watch_count	0
zk_cnt_node_deleted_watch_count	0
zk_sum_node_deleted_watch_count	0
zk_avg_startup_txns_load_time	0.0
zk_min_startup_txns_load_time	0
zk_max_startup_txns_load_time	0
zk_cnt_startup_txns_load_time	0
zk_sum_startup_txns_load_time	0
zk_avg_sync_processor_queue_size	0.0
zk_min_sync_processor_queue_size	0
zk_max_sync_processor_queue_size	0
zk_cnt_sync_processor_queue_size	0
zk_sum_sync_processor_queue_size	0
zk_avg_follower_sync_time	0.0
zk_min_follower_sync_time	0
zk_max_follower_sync_time	0
zk_cnt_follower_sync_time	0
zk_sum_follower_sync_time	0
zk_avg_prep_processor_queue_size	0.0
zk_min_prep_processor_queue_size	0
zk_max_prep_processor_queue_size	0
zk_cnt_prep_processor_queue_size	0
zk_sum_prep_processor_queue_size	0
zk_avg_fsynctime	0.0
zk_min_fsynctime	0
zk_max_fsynctime	0
zk_cnt_fsynctime	0
zk_sum_fsynctime	0
zk_avg_reads_issued_from_session_queue	0.0
zk_min_reads_issued_from_session_queue	0
zk_max_reads_issued_from_session_queue	0
zk_cnt_reads_issued_from_session_queue	0
zk_sum_reads_issued_from_session_queue	0
zk_avg_snapshottime	0.0
zk_min_snapshottime	0
zk_max_snapshottime	0
zk_cnt_snapshottime	0
zk_sum_snapshottime	0
zk_avg_startup_txns_loaded	0.0
zk_min_startup_txns_loaded	0
zk_max_startup_txns_loaded	0
zk_cnt_startup_txns_loaded	0
zk_sum_startup_txns_loaded	0
zk_avg_reads_after_write_in_session_queue	0.0
zk_min_reads_after_write_in_session_queue	0
zk_max_reads_after_write_in_session_queue	0
zk_cnt_reads_after_write_in_session_queue	0
zk_sum_reads_after_write_in_session_queue	0
zk_avg_requests_in_session_queue	0.0
zk_min_requests_in_session_queue	0
zk_max_requests_in_session_queue	0
zk_cnt_requests_in_session_queue	0
zk_sum_requests_in_session_queue	0
zk_avg_write_commit_proc_issued	0.0
zk_min_write_commit_proc_issued	0
zk_max_write_commit_proc_issued	0
zk_cnt_write_commit_proc_issued	0
zk_sum_write_commit_proc_issued	0
zk_avg_prep_process_time	0.0
zk_min_prep_process_time	0
zk_max_prep_process_time	0
zk_cnt_prep_process_time	0
zk_sum_prep_process_time	0
zk_avg_pending_session_queue_size	0.0
zk_min_pending_session_queue_size	0
zk_max_pending_session_queue_size	0
zk_cnt_pending_session_queue_size	0
zk_sum_pending_session_queue_size	0
zk_avg_time_waiting_empty_pool_in_commit_processor_read_ms	0.0
zk_min_time_waiting_empty_pool_in_commit_processor_read_ms	0
zk_max_time_waiting_empty_pool_in_commit_processor_read_ms	0
zk_cnt_time_waiting_empty_pool_in_commit_processor_read_ms	0
zk_sum_time_waiting_empty_pool_in_commit_processor_read_ms	0
zk_avg_commit_process_time	0.0
zk_min_commit_process_time	0
zk_max_commit_process_time	0
zk_cnt_commit_process_time	0
zk_sum_commit_process_time	0
zk_avg_dbinittime	0.0
zk_min_dbinittime	0
zk_max_dbinittime	0
zk_cnt_dbinittime	0
zk_sum_dbinittime	0
zk_avg_netty_queued_buffer_capacity	0.0
zk_min_netty_queued_buffer_capacity	0
zk_max_netty_queued_buffer_capacity	0
zk_cnt_netty_queued_buffer_capacity	0
zk_sum_netty_queued_buffer_capacity	0
zk_avg_election_time	0.0
zk_min_election_time	0
zk_max_election_time	0
zk_cnt_election_time	0
zk_sum_election_time	0
zk_avg_commit_commit_proc_req_queued	0.0
zk_min_commit_commit_proc_req_queued	0
zk_max_commit_commit_proc_req_queued	0
zk_cnt_commit_commit_proc_req_queued	0
zk_sum_commit_commit_proc_req_queued	0
zk_avg_sync_processor_batch_size	0.0
zk_min_sync_processor_batch_size	0
zk_max_sync_processor_batch_size	0
zk_cnt_sync_processor_batch_size	0
zk_sum_sync_processor_batch_size	0
zk_avg_node_children_watch_count	0.0
zk_min_node_children_watch_count	0
zk_max_node_children_watch_count	0
zk_cnt_node_children_watch_count	0
zk_sum_node_children_watch_count	0
zk_avg_write_batch_time_in_commit_processor	0.0
zk_min_write_batch_time_in_commit_processor	0
zk_max_write_batch_time_in_commit_processor	0
zk_cnt_write_batch_time_in_commit_processor	0
zk_sum_write_batch_time_in_commit_processor	0
zk_avg_read_commit_proc_issued	0.0
zk_min_read_commit_proc_issued	0
zk_max_read_commit_proc_issued	0
zk_cnt_read_commit_proc_issued	0
zk_sum_read_commit_proc_issued	0
zk_avg_concurrent_request_processing_in_commit_processor	0.0
zk_min_concurrent_request_processing_in_commit_processor	0
zk_max_concurrent_request_processing_in_commit_processor	0
zk_cnt_concurrent_request_processing_in_commit_processor	0
zk_sum_concurrent_request_processing_in_commit_processor	0
zk_avg_node_changed_watch_count	0.0
zk_min_node_changed_watch_count	0
zk_max_node_changed_watch_count	0
zk_cnt_node_changed_watch_count	0
zk_sum_node_changed_watch_count	0
zk_avg_sync_process_time	0.0
zk_min_sync_process_time	0
zk_max_sync_process_time	0
zk_cnt_sync_process_time	0
zk_sum_sync_process_time	0
zk_avg_startup_snap_load_time	0.0
zk_min_startup_snap_load_time	0
zk_max_startup_snap_load_time	0
zk_cnt_startup_snap_load_time	0
zk_sum_startup_snap_load_time	0
zk_avg_prep_processor_queue_time_ms	0.0
zk_min_prep_processor_queue_time_ms	0
zk_max_prep_processor_queue_time_ms	0
zk_cnt_prep_processor_queue_time_ms	0
zk_sum_prep_processor_queue_time_ms	0
zk_p50_prep_processor_queue_time_ms	0
zk_p95_prep_processor_queue_time_ms	0
zk_p99_prep_processor_queue_time_ms	0
zk_p999_prep_processor_queue_time_ms	0
zk_avg_close_session_prep_time	0.0
zk_min_close_session_prep_time	0
zk_max_close_session_prep_time	0
zk_cnt_close_session_prep_time	0
zk_sum_close_session_prep_time	0
zk_p50_close_session_prep_time	0
zk_p95_close_session_prep_time	0
zk_p99_close_session_prep_time	0
zk_p999_close_session_prep_time	0
zk_avg_read_commitproc_time_ms	0.0
zk_min_read_commitproc_time_ms	0
zk_max_read_commitproc_time_ms	0
zk_cnt_read_commitproc_time_ms	0
zk_sum_read_commitproc_time_ms	0
zk_p50_read_commitproc_time_ms	0
zk_p95_read_commitproc_time_ms	0
zk_p99_read_commitproc_time_ms	0
zk_p999_read_commitproc_time_ms	0
zk_avg_updatelatency	0.0
zk_min_updatelatency	0
zk_max_updatelatency	0
zk_cnt_updatelatency	0
zk_sum_updatelatency	0
zk_p50_updatelatency	0
zk_p95_updatelatency	0
zk_p99_updatelatency	0
zk_p999_updatelatency	0
zk_avg_local_write_committed_time_ms	0.0
zk_min_local_write_committed_time_ms	0
zk_max_local_write_committed_time_ms	0
zk_cnt_local_write_committed_time_ms	0
zk_sum_local_write_committed_time_ms	0
zk_p50_local_write_committed_time_ms	0
zk_p95_local_write_committed_time_ms	0
zk_p99_local_write_committed_time_ms	0
zk_p999_local_write_committed_time_ms	0
zk_avg_readlatency	0.0
zk_min_readlatency	0
zk_max_readlatency	0
zk_cnt_readlatency	0
zk_sum_readlatency	0
zk_p50_readlatency	0
zk_p95_readlatency	0
zk_p99_readlatency	0
zk_p999_readlatency	0
zk_avg_quorum_ack_latency	0.0
zk_min_quorum_ack_latency	0
zk_max_quorum_ack_latency	0
zk_cnt_quorum_ack_latency	0
zk_sum_quorum_ack_latency	0
zk_p50_quorum_ack_latency	0
zk_p95_quorum_ack_latency	0
zk_p99_quorum_ack_latency	0
zk_p999_quorum_ack_latency	0
zk_avg_om_commit_process_time_ms	0.0
zk_min_om_commit_process_time_ms	0
zk_max_om_commit_process_time_ms	0
zk_cnt_om_commit_process_time_ms	0
zk_sum_om_commit_process_time_ms	0
zk_p50_om_commit_process_time_ms	0
zk_p95_om_commit_process_time_ms	0
zk_p99_om_commit_process_time_ms	0
zk_p999_om_commit_process_time_ms	0
zk_avg_read_final_proc_time_ms	0.0
zk_min_read_final_proc_time_ms	0
zk_max_read_final_proc_time_ms	0
zk_cnt_read_final_proc_time_ms	0
zk_sum_read_final_proc_time_ms	0
zk_p50_read_final_proc_time_ms	0
zk_p95_read_final_proc_time_ms	0
zk_p99_read_final_proc_time_ms	0
zk_p999_read_final_proc_time_ms	0
zk_avg_commit_propagation_latency	0.0
zk_min_commit_propagation_latency	0
zk_max_commit_propagation_latency	0
zk_cnt_commit_propagation_latency	0
zk_sum_commit_propagation_latency	0
zk_p50_commit_propagation_latency	0
zk_p95_commit_propagation_latency	0
zk_p99_commit_propagation_latency	0
zk_p999_commit_propagation_latency	0
zk_avg_dead_watchers_cleaner_latency	0.0
zk_min_dead_watchers_cleaner_latency	0
zk_max_dead_watchers_cleaner_latency	0
zk_cnt_dead_watchers_cleaner_latency	0
zk_sum_dead_watchers_cleaner_latency	0
zk_p50_dead_watchers_cleaner_latency	0
zk_p95_dead_watchers_cleaner_latency	0
zk_p99_dead_watchers_cleaner_latency	0
zk_p999_dead_watchers_cleaner_latency	0
zk_avg_write_final_proc_time_ms	0.0
zk_min_write_final_proc_time_ms	0
zk_max_write_final_proc_time_ms	0
zk_cnt_write_final_proc_time_ms	0
zk_sum_write_final_proc_time_ms	0
zk_p50_write_final_proc_time_ms	0
zk_p95_write_final_proc_time_ms	0
zk_p99_write_final_proc_time_ms	0
zk_p999_write_final_proc_time_ms	0
zk_avg_proposal_ack_creation_latency	0.0
zk_min_proposal_ack_creation_latency	0
zk_max_proposal_ack_creation_latency	0
zk_cnt_proposal_ack_creation_latency	0
zk_sum_proposal_ack_creation_latency	0
zk_p50_proposal_ack_creation_latency	0
zk_p95_proposal_ack_creation_latency	0
zk_p99_proposal_ack_creation_latency	0
zk_p999_proposal_ack_creation_latency	0
zk_avg_proposal_latency	0.0
zk_min_proposal_latency	0
zk_max_proposal_latency	0
zk_cnt_proposal_latency	0
zk_sum_proposal_latency	0
zk_p50_proposal_latency	0
zk_p95_proposal_latency	0
zk_p99_proposal_latency	0
zk_p999_proposal_latency	0
zk_avg_om_proposal_process_time_ms	0.0
zk_min_om_proposal_process_time_ms	0
zk_max_om_proposal_process_time_ms	0
zk_cnt_om_proposal_process_time_ms	0
zk_sum_om_proposal_process_time_ms	0
zk_p50_om_proposal_process_time_ms	0
zk_p95_om_proposal_process_time_ms	0
zk_p99_om_proposal_process_time_ms	0
zk_p999_om_proposal_process_time_ms	0
zk_avg_sync_processor_queue_and_flush_time_ms	0.0
zk_min_sync_processor_queue_and_flush_time_ms	0
zk_max_sync_processor_queue_and_flush_time_ms	0
zk_cnt_sync_processor_queue_and_flush_time_ms	0
zk_sum_sync_processor_queue_and_flush_time_ms	0
zk_p50_sync_processor_queue_and_flush_time_ms	0
zk_p95_sync_processor_queue_and_flush_time_ms	0
zk_p99_sync_processor_queue_and_flush_time_ms	0
zk_p999_sync_processor_queue_and_flush_time_ms	0
zk_avg_propagation_latency	0.0
zk_min_propagation_latency	0
zk_max_propagation_latency	0
zk_cnt_propagation_latency	0
zk_sum_propagation_latency	0
zk_p50_propagation_latency	0
zk_p95_propagation_latency	0
zk_p99_propagation_latency	0
zk_p999_propagation_latency	0
zk_avg_server_write_committed_time_ms	0.0
zk_min_server_write_committed_time_ms	0
zk_max_server_write_committed_time_ms	0
zk_cnt_server_write_committed_time_ms	0
zk_sum_server_write_committed_time_ms	0
zk_p50_server_write_committed_time_ms	0
zk_p95_server_write_committed_time_ms	0
zk_p99_server_write_committed_time_ms	0
zk_p999_server_write_committed_time_ms	0
zk_avg_sync_processor_queue_time_ms	0.0
zk_min_sync_processor_queue_time_ms	0
zk_max_sync_processor_queue_time_ms	0
zk_cnt_sync_processor_queue_time_ms	0
zk_sum_sync_processor_queue_time_ms	0
zk_p50_sync_processor_queue_time_ms	0
zk_p95_sync_processor_queue_time_ms	0
zk_p99_sync_processor_queue_time_ms	0
zk_p999_sync_processor_queue_time_ms	0
zk_avg_sync_processor_queue_flush_time_ms	0.0
zk_min_sync_processor_queue_flush_time_ms	0
zk_max_sync_processor_queue_flush_time_ms	0
zk_cnt_sync_processor_queue_flush_time_ms	0
zk_sum_sync_processor_queue_flush_time_ms	0
zk_p50_sync_processor_queue_flush_time_ms	0
zk_p95_sync_processor_queue_flush_time_ms	0
zk_p99_sync_processor_queue_flush_time_ms	0
zk_p999_sync_processor_queue_flush_time_ms	0
zk_avg_write_commitproc_time_ms	0.0
zk_min_write_commitproc_time_ms	0
zk_max_write_commitproc_time_ms	0
zk_cnt_write_commitproc_time_ms	0
zk_sum_write_commitproc_time_ms	0
zk_p50_write_commitproc_time_ms	0
zk_p95_write_commitproc_time_ms	0
zk_p99_write_commitproc_time_ms	0
zk_p999_write_commitproc_time_ms	0
zk_avg_abc_read_per_namespace	0.0
zk_min_abc_read_per_namespace	0
zk_max_abc_read_per_namespace	0
zk_cnt_abc_read_per_namespace	0
zk_sum_abc_read_per_namespace	0
zk_avg_zookeeper_read_per_namespace	0.0
zk_min_zookeeper_read_per_namespace	0
zk_max_zookeeper_read_per_namespace	0
zk_cnt_zookeeper_read_per_namespace	0
zk_sum_zookeeper_read_per_namespace	0
zk_avg_services_read_per_namespace	0.0
zk_min_services_read_per_namespace	0
zk_max_services_read_per_namespace	0
zk_cnt_services_read_per_namespace	0
zk_sum_services_read_per_namespace	0
zk_avg_abc_write_per_namespace	0.0
zk_min_abc_write_per_namespace	0
zk_max_abc_write_per_namespace	0
zk_cnt_abc_write_per_namespace	0
zk_sum_abc_write_per_namespace	0
zk_avg_services_write_per_namespace	0.0
zk_min_services_write_per_namespace	0
zk_max_services_write_per_namespace	0
zk_cnt_services_write_per_namespace	0
zk_sum_services_write_per_namespace	0
```

