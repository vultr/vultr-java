

# UpdateAdvancedOptionsRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autovacuumAnalyzeScaleFactor** | **Float** | Accepted values: 0 - 1 |  [optional] |
|**autovacuumAnalyzeThreshold** | **Integer** | Accepted values: 0 - 2147483647 |  [optional] |
|**autovacuumFreezeMaxAge** | **Integer** | Accepted values: 200000000 - 1500000000 |  [optional] |
|**autovacuumMaxWorkers** | **Integer** | Accepted values: 1 - 20 |  [optional] |
|**autovacuumNaptime** | **Integer** | Accepted values: 1 - 86400 |  [optional] |
|**autovacuumVacuumCostDelay** | **Integer** | Accepted values: -1 - 100 |  [optional] |
|**autovacuumVacuumCostLimit** | **Integer** | Accepted values: -1 - 10000 |  [optional] |
|**autovacuumVacuumScaleFactor** | **Float** | Accepted values: 0 - 1 |  [optional] |
|**autovacuumVacuumThreshold** | **Integer** | Accepted values: 0 - 2147483647 |  [optional] |
|**bgwriterDelay** | **Integer** | Accepted values: 10 - 10000 |  [optional] |
|**bgwriterFlushAfter** | **Integer** | Accepted values: 0 - 2048 |  [optional] |
|**bgwriterLruMaxpages** | **Integer** | Accepted values: 0 - 1073741823 |  [optional] |
|**bgwriterLruMultiplier** | **Float** | Accepted values: 0 - 10 |  [optional] |
|**deadlockTimeout** | **Integer** | Accepted values: 500 - 1800000 |  [optional] |
|**defaultToastCompression** | **ModelEnum** | Accepted values: * &#x60;lz4&#x60; * &#x60;pglz&#x60; |  [optional] |
|**idleInTransactionSessionTimeout** | **Integer** | Accepted values: 0 - 604800000 |  [optional] |
|**jit** | **Boolean** | Accepted values: * &#x60;true&#x60; * &#x60;false&#x60; |  [optional] |
|**logAutovacuumMinDuration** | **Integer** | Accepted values: -1 - 2147483647 |  [optional] |
|**logErrorVerbosity** | **ModelEnum** | Accepted values: * &#x60;TERSE&#x60; * &#x60;DEFAULT&#x60; * &#x60;VERBOSE&#x60; |  [optional] |
|**logLinePrefix** | **ModelEnum** | Accepted values: * &#x60;&#39;pid&#x3D;%p,user&#x3D;%u,db&#x3D;%d,app&#x3D;%a,client&#x3D;%h &#39;&#x60; * &#x60;&#39;%t [%p]: [%l-1] user&#x3D;%u,db&#x3D;%d,app&#x3D;%a,client&#x3D;%h &#39;&#x60; * &#x60;&#39;%m [%p] %q[user&#x3D;%u,db&#x3D;%d,app&#x3D;%a] &#39;&#x60; |  [optional] |
|**logMinDurationStatement** | **Integer** | Accepted values: -1 - 86400000 |  [optional] |
|**maxFilesPerProcess** | **Integer** | Accepted values: 1000 - 4096 |  [optional] |
|**maxLocksPerTransaction** | **Integer** | Accepted values: 64 - 6400 |  [optional] |
|**maxLogicalReplicationWorkers** | **Integer** | Accepted values: 4 - 64 |  [optional] |
|**maxParallelWorkers** | **Integer** | Accepted values: 0 - 96 |  [optional] |
|**maxParallelWorkersPerGather** | **Integer** | Accepted values: 0 - 96 |  [optional] |
|**maxPredLocksPerTransaction** | **Integer** | Accepted values: 64 - 5120 |  [optional] |
|**maxPreparedTransactions** | **Integer** | Accepted values: 0 - 10000 |  [optional] |
|**maxReplicationSlots** | **Integer** | Accepted values: 8 - 64 |  [optional] |
|**maxStackDepth** | **Integer** | Accepted values: 2097152 - 6291456 |  [optional] |
|**maxStandbyArchiveDelay** | **Integer** | Accepted values: 1 - 43200000 |  [optional] |
|**maxStandbyStreamingDelay** | **Integer** | Accepted values: 1 - 43200000 |  [optional] |
|**maxWalSenders** | **Integer** | Accepted values: 20 - 64 |  [optional] |
|**maxWorkerProcesses** | **Integer** | Accepted values: 8 - 96 |  [optional] |
|**pgPartmanBgwInterval** | **Integer** | Accepted values: 3600 - 604800 |  [optional] |
|**pgPartmanBgwRole** | **String** | Maximum length: 64 characters |  [optional] |
|**pgStatStatementsTrack** | **ModelEnum** | Accepted values: * &#x60;all&#x60; * &#x60;top&#x60; * &#x60;none&#x60; |  [optional] |
|**tempFileLimit** | **Integer** | Accepted values: -1 - 2147483647 |  [optional] |
|**trackActivityQuerySize** | **Integer** | Accepted values: 1024 - 10240 |  [optional] |
|**trackCommitTimestamp** | **ModelEnum** | Accepted values: * &#x60;off&#x60; * &#x60;on&#x60; |  [optional] |
|**trackFunctions** | **ModelEnum** | Accepted values: * &#x60;all&#x60; * &#x60;pl&#x60; * &#x60;none&#x60; |  [optional] |
|**trackIoTiming** | **ModelEnum** | Accepted values: * &#x60;off&#x60; * &#x60;on&#x60; |  [optional] |
|**walSenderTimeout** | **Integer** | Accepted values: 0, 5000 - 10800000 |  [optional] |
|**walWriterDelay** | **Integer** | Accepted values: 10 - 200 |  [optional] |



