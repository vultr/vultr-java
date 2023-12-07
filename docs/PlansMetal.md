

# PlansMetal

Plans for Bare Metal instances.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the Bare Metal Plan. |  [optional] |
|**cpuCount** | **Integer** | The number of CPUs in this Plan. |  [optional] |
|**cpuModel** | **String** | The CPU model type for this instance. |  [optional] |
|**cpuThreads** | **Integer** | The numner of supported threads for this instance. |  [optional] |
|**ram** | **Integer** | The amount of RAM in MB. |  [optional] |
|**disk** | **String** | The disk size in GB. |  [optional] |
|**bandwidth** | **Integer** | The monthly bandwidth quota in GB. |  [optional] |
|**locations** | **List&lt;String&gt;** | An array of Regions where this plan is valid for use. |  [optional] |
|**type** | **String** | The plan type.  * SSD |  [optional] |
|**monthlyCost** | **Integer** | The monthly cost in US Dollars. |  [optional] |
|**diskCount** | **Integer** | The number of disks that this plan offers. |  [optional] |



