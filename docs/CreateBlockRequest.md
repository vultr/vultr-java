

# CreateBlockRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**region** | **String** | The [Region id](#operation/list-regions) where the Block Storage will be created. |  |
|**sizeGb** | **Integer** | Size in GB may range between 10 and 40000, depending on the &#x60;block_type&#x60;. |  |
|**label** | **String** | The user-supplied label. |  [optional] |
|**blockType** | **String** | An optional parameter, that determines on the type of block storage volume that will be created. Soon to become a required parameter.  * &#x60;high_perf&#x60; from 10GB to 10,000GB * &#x60;storage_opt&#x60; from 40GB to 40,000GB |  [optional] |



