

# Database

Managed Database information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the Managed Database. |  [optional] |
|**dateCreated** | **String** | The date this database was created. |  [optional] |
|**plan** | **String** | The name of the Managed Database plan. |  [optional] |
|**planDisk** | **Integer** | The size of the disk in GB (excluded for Redis engine types). |  [optional] |
|**planRam** | **Integer** | The amount of RAM in MB. |  [optional] |
|**planVcpus** | **Integer** | Number of vCPUs. |  [optional] |
|**planReplicas** | **Integer** | Number of replica nodes. |  [optional] |
|**region** | **String** | The [Region id](#operation/list-regions) where the Managed Database is located. |  [optional] |
|**databaseEngine** | **String** | The database engine type (MySQL, PostgreSQL, FerretDB + PostgreSQL, Redis). |  [optional] |
|**databaseEngineVersion** | **String** | The version number of the database engine in use. |  [optional] |
|**vpcId** | **String** | The ID of the [VPC Network](#operation/get-vpc) attached to the Managed Database. |  [optional] |
|**status** | **String** | The current status.  * Rebuilding * Rebalancing * Running |  [optional] |
|**label** | **String** | The user-supplied label for this managed database. |  [optional] |
|**tag** | **String** | The user-supplied tag for this managed database. |  [optional] |
|**dbname** | **String** | The default database name. |  [optional] |
|**ferretdbCredentials** | [**DatabaseFerretdbCredentials**](DatabaseFerretdbCredentials.md) |  |  [optional] |
|**host** | **String** | The public hostname for database connections, or private hostname if this managed database is attached to a VPC network. |  [optional] |
|**publicHost** | **String** | The public hostname for database connections. Only visible when the managed database is attached to a VPC network. |  [optional] |
|**user** | **String** | The default user configured on creation. |  [optional] |
|**password** | **String** | The default user&#39;s secure password generated on creation. |  [optional] |
|**port** | **String** | The assigned port for connecting to the Managed Database. |  [optional] |
|**maintenanceDow** | **String** | The chosen date of week for routine maintenance updates. |  [optional] |
|**maintenanceTime** | **String** | The chosen hour for routine maintenance updates. |  [optional] |
|**latestBackup** | **String** | The date for the latest backup stored on the Managed Database. |  [optional] |
|**trustedIps** | **List&lt;String&gt;** | A list of trusted IP addresses for connecting to this Managed Database (in CIDR notation). |  [optional] |
|**mysqlSqlModes** | **List&lt;String&gt;** | A list names of enabled SQL Modes for MySQL engine types only. |  [optional] |
|**mysqlRequirePrimaryKey** | **Boolean** | Configuration value for requiring table primary keys for MySQL engine types only. |  [optional] |
|**mysqlSlowQueryLog** | **Boolean** | Configuration value for slow query logging on the Managed Database for MySQL engine types only. |  [optional] |
|**mysqlLongQueryTime** | **Integer** | The number of seconds to denote a slow query when logging is enabled for MySQL engine types only. |  [optional] |
|**pgAvailableExtensions** | **List&lt;Object&gt;** | A list of objects containing names and versions (when applicable) of available extensions for PostgreSQL engine types only. |  [optional] |
|**redisEvictionPolicy** | **String** | The current configured data eviction policy for Redis engine types only. |  [optional] |
|**clusterTimeZone** | **String** | The configured time zone of the Managed Database in TZ database format. |  [optional] |
|**readReplicas** | **List&lt;Object&gt;** | A list of database objects containing details for all attached read-only replica nodes. |  [optional] |



