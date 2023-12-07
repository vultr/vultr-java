

# Baremetal

Bare Metal information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the Bare Metal instance. |  [optional] |
|**os** | **String** | The [Operating System name](#operation/list-os). |  [optional] |
|**ram** | **String** | Text description of the instances&#39; RAM. |  [optional] |
|**disk** | **String** | Text description of the instances&#39; disk configuration. |  [optional] |
|**mainIp** | **String** | The main IPv4 address. |  [optional] |
|**cpuCount** | **Integer** | Number of CPUs. |  [optional] |
|**region** | **String** | The [Region id](#operation/list-regions) where the instance is located. |  [optional] |
|**defaultPassword** | **String** | The default password assigned at deployment. Only available for ten minutes after deployment. |  [optional] |
|**dateCreated** | **String** | The date this instance was created. |  [optional] |
|**status** | **String** | The current status.  * active * pending * suspended |  [optional] |
|**netmaskV4** | **String** | The IPv4 netmask in dot-decimal notation. |  [optional] |
|**gatewayV4** | **String** | The IPv4 gateway address. |  [optional] |
|**plan** | **String** | The [Bare Metal Plan id](#operation/list-metal-plans) used by this instance. |  [optional] |
|**label** | **String** | The user-supplied label for this instance. |  [optional] |
|**tag** | **String** | Use &#x60;tags&#x60; instead. The user-supplied tag for this instance. |  [optional] |
|**osId** | **Integer** | The [Operating System id](#operation/list-os). |  [optional] |
|**appId** | **Integer** | The [Application id](#operation/list-applications). |  [optional] |
|**imageId** | **String** | The [Application image_id](#operation/list-applications). |  [optional] |
|**v6Network** | **String** | The IPv6 network size in bits. |  [optional] |
|**v6MainIp** | **String** | The main IPv6 network address. |  [optional] |
|**v6NetworkSize** | **Integer** | The IPv6 subnet. |  [optional] |
|**macAddress** | **Integer** | The MAC address for a Bare Metal server. |  [optional] |
|**tags** | **List&lt;String&gt;** | Tags to apply to the instance. |  [optional] |
|**userScheme** | **String** | The user scheme.  * root * limited |  [optional] |



