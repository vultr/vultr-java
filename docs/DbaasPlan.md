

# DbaasPlan

Managed Database plan information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the plan. |  [optional] |
|**numberOfNodes** | **Integer** | The total number of nodes for this plan. |  [optional] |
|**type** | **String** | The type of plan this is. |  [optional] |
|**vcpuCount** | **Integer** | Number of vCPUs. |  [optional] |
|**ram** | **Integer** | The amount of RAM in MB. |  [optional] |
|**disk** | **Integer** | The size of the disk in GB (excluded for Redis engine types). |  [optional] |
|**monthlyCost** | **Integer** | The monthly cost of this Managed Database plan. |  [optional] |
|**supportedEngines** | **Object** | A list of key/value pairs with database engine types and boolean values. |  [optional] |
|**maxConnections** | **Object** | A list of key/value pairs with database engine types (excluding Redis) and integers of max connection values. |  [optional] |
|**locations** | **List&lt;String&gt;** | A list of available regions in which this plan is currently available. |  [optional] |



