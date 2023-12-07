

# UpdateInstanceRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**appId** | **Integer** | Reinstall the instance with this [Application id](#operation/list-applications). |  [optional] |
|**imageId** | **String** | Reinstall the instance with this [Application image_id](#operation/list-applications). |  [optional] |
|**backups** | **String** | Enable automatic backups for the instance.  * enabled * disabled |  [optional] |
|**firewallGroupId** | **String** | The [Firewall Group id](#operation/list-firewall-groups) to attach to this Instance. |  [optional] |
|**enableIpv6** | **Boolean** | Enable IPv6.  * true |  [optional] |
|**osId** | **String** | Reinstall the instance with this [ISO id](#operation/list-isos). |  [optional] |
|**userData** | **String** | The user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) to attach to this instance. |  [optional] |
|**tag** | **String** | Use &#x60;tags&#x60; instead. The user-supplied tag. |  [optional] |
|**plan** | **String** | Upgrade the instance with this [Plan id](#operation/list-plans). |  [optional] |
|**ddosProtection** | **Boolean** | Enable DDoS Protection (there is an additional charge for this).  * true * false |  [optional] |
|**attachPrivateNetwork** | **List&lt;String&gt;** | Use &#x60;attach_vpc&#x60; instead. An array of [Private Network ids](#operation/list-networks) to attach to this Instance. This parameter takes precedence over &#x60;enable_private_network&#x60;. Please choose one parameter. |  [optional] |
|**attachVpc** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpcs) to attach to this Instance. This parameter takes precedence over &#x60;enable_vpc&#x60;. Please choose one parameter. |  [optional] |
|**attachVpc2** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpc2) to attach to this Instance. This parameter takes precedence over &#x60;enable_vpc2&#x60;. Please choose one parameter. |  [optional] |
|**detachPrivateNetwork** | **List&lt;String&gt;** | Use &#x60;detach_vpc&#x60; instead. An array of [Private Network ids](#operation/list-networks) to detach from this Instance. This parameter takes precedence over &#x60;enable_private_network&#x60;. |  [optional] |
|**detachVpc** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpcs) to detach from this Instance. This parameter takes precedence over &#x60;enable_vpc&#x60;. |  [optional] |
|**detachVpc2** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpc2) to detach from this Instance. This parameter takes precedence over &#x60;enable_vpc2&#x60;. |  [optional] |
|**enablePrivateNetwork** | **Boolean** | Use &#x60;enable_vpc&#x60; instead.  If &#x60;true&#x60;, private networking support will be added to the new server.  This parameter attaches a single network. When no network exists in the region, it will be automatically created.  If there are multiple private networks in the instance&#39;s region, use &#x60;attach_private_network&#x60; instead to specify a network. |  [optional] |
|**enableVpc** | **Boolean** | If &#x60;true&#x60;, VPC support will be added to the new server.  This parameter attaches a single VPC. When no VPC exists in the region, it will be automatically created.  If there are multiple VPCs in the instance&#39;s region, use &#x60;attach_vpc&#x60; instead to specify a VPC. |  [optional] |
|**enableVpc2** | **Boolean** | If &#x60;true&#x60;, VPC 2.0 support will be added to the new server.  This parameter attaches a single VPC 2.0 netowrk. When no VPC 2.0 network exists in the region, it will be automatically created.  If there are multiple VPC 2.0 networks in the instance&#39;s region, use &#x60;attach_vpc2&#x60; instead to specify a VPC 2.0 network. |  [optional] |
|**label** | **String** | The user supplied label. |  [optional] |
|**tags** | **List&lt;String&gt;** | Tags to apply to the instance. |  [optional] |
|**userScheme** | **String** | Linux-only: The user scheme used for logging into this instance. The instance must be reinstalled for this change to take effect.  * root * limited |  [optional] |



