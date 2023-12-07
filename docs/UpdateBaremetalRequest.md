

# UpdateBaremetalRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**userData** | **String** | The user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) to attach to this instance. |  [optional] |
|**label** | **String** | The user-supplied label. |  [optional] |
|**tag** | **String** | Use &#x60;tags&#x60; instead. The user-supplied tag. |  [optional] |
|**osId** | **Integer** | If supplied, reinstall the instance using this [Operating System id](#operation/list-os). |  [optional] |
|**appId** | **Integer** | If supplied, reinstall the instance using this [Application id](#operation/list-applications). |  [optional] |
|**imageId** | **String** | If supplied, reinstall the instance using this [Application image_id](#operation/list-applications). |  [optional] |
|**enableIpv6** | **Boolean** | Enable IPv6.  * true |  [optional] |
|**attachVpc2** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpc2) to attach to this Bare Metal Instance. This parameter takes precedence over &#x60;enable_vpc2&#x60;. Please choose one parameter. |  [optional] |
|**detachVpc2** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpc2) to detach from this Bare Metal Instance. This parameter takes precedence over &#x60;enable_vpc2&#x60;. |  [optional] |
|**enableVpc2** | **Boolean** | If &#x60;true&#x60;, VPC 2.0 support will be added to the new server.  This parameter attaches a single VPC 2.0 netowrk. When no VPC 2.0 network exists in the region, it will be automatically created.  If there are multiple VPC 2.0 networks in the instance&#39;s region, use &#x60;attach_vpc2&#x60; instead to specify a VPC 2.0 network. |  [optional] |
|**tags** | **List&lt;String&gt;** | Tags to apply to the instance. |  [optional] |
|**userScheme** | **String** | Linux-only: The user scheme used for logging into this instance. The instance must be reinstalled for this change to take effect.  * root * limited |  [optional] |



