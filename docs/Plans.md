

# Plans

Plans for VPS instances.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the Plan. |  [optional] |
|**name** | **String** | The Plan name. |  [optional] |
|**vcpuCount** | **Integer** | The number of vCPUs in this Plan. |  [optional] |
|**ram** | **Integer** | The amount of RAM in MB. |  [optional] |
|**disk** | **Integer** | The disk size in GB. |  [optional] |
|**bandwidth** | **Integer** | The monthly bandwidth quota in GB. |  [optional] |
|**monthlyCost** | **Integer** | The monthly cost in US Dollars. |  [optional] |
|**type** | **String** | The plan type.  |   | Type | Description | | - | ------ | ------------- | |   | vc2 | Cloud Compute | |   | vhf | High Frequency Compute | |   | vdc | Dedicated Cloud | |  [optional] |
|**locations** | **List&lt;String&gt;** | An array of Regions where this plan is valid for use. |  [optional] |
|**diskCount** | **Integer** | The number of disks that this plan offers. |  [optional] |



