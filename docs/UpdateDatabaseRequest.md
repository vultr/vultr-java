

# UpdateDatabaseRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**region** | **String** | The [Region id](#operation/list-regions) where the Managed Database is located. |  [optional] |
|**plan** | **String** | The [Plan id](#operation/list-database-plans) for this Managed Database. |  [optional] |
|**label** | **String** | A user-supplied label for this Managed Database. |  [optional] |
|**tag** | **String** | The user-supplied tag for this Managed Database. |  [optional] |
|**vpcId** | **String** | The [VPC id](#operation/list-vpcs) for this Managed Database. |  [optional] |
|**maintenanceDow** | **String** | The day of week for routine maintenance updates. * &#x60;monday&#x60; * &#x60;tuesday&#x60; * &#x60;wednesday&#x60; * &#x60;thursday&#x60; * &#x60;friday&#x60; * &#x60;saturday&#x60; * &#x60;sunday&#x60; |  [optional] |
|**maintenanceTime** | **String** | The preferred time (UTC) for routine maintenance updates to occur in 24-hour HH:00 format (e.g. &#x60;01:00&#x60;, &#x60;13:00&#x60;, &#x60;23:00&#x60;, etc.). |  [optional] |
|**clusterTimeZone** | **String** | The configured time zone for the Managed Database in TZ database format (e.g. &#x60;UTC&#x60;, &#x60;America/New_York&#x60;, &#x60;Europe/London&#x60;, etc.). |  [optional] |
|**trustedIps** | **List&lt;String&gt;** | A list of IP addresses allowed to access the Managed Database in CIDR notation (defaults to /32 if excluded). |  [optional] |
|**mysqlSqlModes** | **List&lt;String&gt;** | A list of SQL modes to enable on the Managed Database (MySQL engine type only). * &#x60;ALLOW_INVALID_DATES&#x60; * &#x60;ANSI&#x60; (Combination Mode) * &#x60;ANSI_QUOTES&#x60; * &#x60;ERROR_FOR_DIVISION_BY_ZERO&#x60; * &#x60;HIGH_NOT_PRECEDENCE&#x60; * &#x60;IGNORE_SPACE&#x60; * &#x60;NO_AUTO_VALUE_ON_ZERO&#x60; * &#x60;NO_DIR_IN_CREATE&#x60; * &#x60;NO_ENGINE_SUBSTITUTION&#x60; * &#x60;NO_UNSIGNED_SUBTRACTION&#x60; * &#x60;NO_ZERO_DATE&#x60; * &#x60;NO_ZERO_IN_DATE&#x60; * &#x60;ONLY_FULL_GROUP_BY&#x60; * &#x60;PIPES_AS_CONCAT&#x60; * &#x60;REAL_AS_FLOAT&#x60; * &#x60;STRICT_ALL_TABLES&#x60; * &#x60;STRICT_TRANS_TABLES&#x60; * &#x60;TIME_TRUNCATE_FRACTIONAL&#x60; * &#x60;TRADITIONAL&#x60; (Combination Mode) |  [optional] |
|**mysqlRequirePrimaryKey** | **Boolean** | Require a primary key for all tables on the Managed Database (MySQL engine type only). |  [optional] |
|**mysqlSlowQueryLog** | **Boolean** | Enable or disable slow query logging on the Managed Database (MySQL engine type only). |  [optional] |
|**mysqlLongQueryTime** | **Integer** | The number of seconds to denote a slow query when logging is enabled (MySQL engine type only). |  [optional] |
|**redisEvictionPolicy** | **String** | Set the data eviction policy for the Managed Database (Redis engine type only) |  [optional] |



