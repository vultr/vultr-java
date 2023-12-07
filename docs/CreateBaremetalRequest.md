

# CreateBaremetalRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**region** | **String** | The [Region id](#operation/list-regions) to create the instance. |  |
|**plan** | **String** | The [Bare Metal plan id](#operation/list-metal-plans) to use for this instance. |  |
|**scriptId** | **String** | The [Startup Script id](#operation/list-startup-scripts) to use for this instance. |  [optional] |
|**enableIpv6** | **Boolean** | Enable IPv6.  * true |  [optional] |
|**sshkeyId** | **List&lt;String&gt;** | The [SSH Key id](#operation/list-ssh-keys) to install on this instance. |  [optional] |
|**userData** | **String** | The user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) for this Instance. |  [optional] |
|**label** | **String** | The user-supplied label. |  [optional] |
|**activationEmail** | **Boolean** | Notify by email after deployment.  * true * false (default) |  [optional] |
|**hostname** | **String** | The user-supplied hostname to use when deploying this instance. |  [optional] |
|**tag** | **String** | Use &#x60;tags&#x60; instead. The user-supplied tag. |  [optional] |
|**reservedIpv4** | **String** | The [Reserved IP id](#operation/list-reserved-ips) for this instance. |  [optional] |
|**osId** | **Integer** | If supplied, deploy the instance using this [Operating System id](#operation/list-os). |  [optional] |
|**snapshotId** | **String** | If supplied, deploy the instance using this [Snapshot ID](#operation/list-snapshots). |  [optional] |
|**appId** | **Integer** | If supplied, deploy the instance using this [Application id](#operation/list-applications). |  [optional] |
|**imageId** | **String** | If supplied, deploy the instance using this [Application image_id](#operation/list-applications). |  [optional] |
|**persistentPxe** | **Boolean** | Enable persistent PXE.  * true * false (default) |  [optional] |
|**attachVpc2** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpc2) to attach to this Bare Metal Instance. This parameter takes precedence over &#x60;enable_vpc2&#x60;. Please choose one parameter. |  [optional] |
|**detachVpc2** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpc2) to detach from this Bare Metal Instance. This parameter takes precedence over &#x60;enable_vpc2&#x60;. |  [optional] |
|**enableVpc2** | **Boolean** | If &#x60;true&#x60;, VPC 2.0 support will be added to the new server.  This parameter attaches a single VPC 2.0 netowrk. When no VPC 2.0 network exists in the region, it will be automatically created.  If there are multiple VPC 2.0 networks in the instance&#39;s region, use &#x60;attach_vpc2&#x60; instead to specify a VPC 2.0 network. |  [optional] |
|**tags** | **List&lt;String&gt;** | Tags to apply to the instance. |  [optional] |
|**userScheme** | **String** | Linux-only: The user scheme used for logging into this instance. By default, the \&quot;root\&quot; user is configured. Alternatively, a limited user with sudo permissions can be selected.  * root * limited |  [optional] |



