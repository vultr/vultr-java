

# Blockstorage

Block Storage information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the Block Storage. |  [optional] |
|**cost** | **Integer** | The monthly cost of this Block Storage. |  [optional] |
|**status** | **String** | The current status of this Block Storage.  * active |  [optional] |
|**sizeGb** | **Integer** | Size of the Block Storage in GB. |  [optional] |
|**region** | **String** | The [Region id](#operation/list-regions) where the Block Storage is located. |  [optional] |
|**attachedToInstance** | **String** | The [Instance id](#operation/list-instances) with this Block Storage attached. |  [optional] |
|**dateCreated** | **String** | The date this Block Storage was created. |  [optional] |
|**label** | **String** | The user-supplied label. |  [optional] |
|**mountId** | **String** | An ID associated with the instance, when mounted the ID can be found in /dev/disk/by-id prefixed with virtio. |  [optional] |



