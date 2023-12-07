

# CreateInstanceRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**region** | **String** | The [Region id](#operation/list-regions) where the Instance is located. |  |
|**plan** | **String** | The [Plan id](#operation/list-plans) to use when deploying this instance. |  |
|**osId** | **Integer** | The [Operating System id](#operation/list-os) to use when deploying this instance. |  [optional] |
|**ipxeChainUrl** | **String** | The URL location of the iPXE chainloader. |  [optional] |
|**isoId** | **String** | The [ISO id](#operation/list-isos) to use when deploying this instance. |  [optional] |
|**scriptId** | **String** | The [Startup Script id](#operation/list-startup-scripts) to use when deploying this instance. |  [optional] |
|**snapshotId** | **String** | The [Snapshot id](#operation/list-snapshots) to use when deploying the instance. |  [optional] |
|**enableIpv6** | **Boolean** | Enable IPv6.  * true |  [optional] |
|**disablePublicIpv4** | **Boolean** | Don&#39;t set up a public IPv4 address when IPv6 is enabled. Will not do anything unless &#x60;enable_ipv6&#x60; is also &#x60;true&#x60;.  * true |  [optional] |
|**attachPrivateNetwork** | **List&lt;String&gt;** | Use &#x60;attach_vpc&#x60; instead. An array of [Private Network ids](#operation/list-networks) to attach to this Instance. This parameter takes precedence over &#x60;enable_private_network&#x60;. Please choose one parameter. |  [optional] |
|**attachVpc** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpcs) to attach to this Instance. This parameter takes precedence over &#x60;enable_vpc&#x60;. Please choose one parameter. |  [optional] |
|**attachVpc2** | **List&lt;String&gt;** | An array of [VPC IDs](#operation/list-vpc2) to attach to this Instance. This parameter takes precedence over &#x60;enable_vpc2&#x60;. Please choose one parameter. |  [optional] |
|**label** | **String** | A user-supplied label for this instance. |  [optional] |
|**sshkeyId** | **List&lt;String&gt;** | The [SSH Key id](#operation/list-ssh-keys) to install on this instance. |  [optional] |
|**backups** | **String** | Enable automatic backups for the instance.  * enabled * disabled |  [optional] |
|**appId** | **Integer** | The [Application id](#operation/list-applications) to use when deploying this instance. |  [optional] |
|**imageId** | **String** | The [Application image_id](#operation/list-applications) to use when deploying this instance. |  [optional] |
|**userData** | **String** | The user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) to attach to this instance. |  [optional] |
|**ddosProtection** | **Boolean** | Enable DDoS protection (there is an additional charge for this).  * true * false |  [optional] |
|**activationEmail** | **Boolean** | Notify by email after deployment.  * true * false (default) |  [optional] |
|**hostname** | **String** | The hostname to use when deploying this instance. |  [optional] |
|**tag** | **String** | Use &#x60;tags&#x60; instead. The user-supplied tag. |  [optional] |
|**firewallGroupId** | **String** | The [Firewall Group id](#operation/list-firewall-groups) to attach to this Instance. |  [optional] |
|**reservedIpv4** | **String** | ID of the floating IP to use as the main IP of this server. |  [optional] |
|**enablePrivateNetwork** | **Boolean** | Use &#x60;enable_vpc&#x60; instead.  If &#x60;true&#x60;, private networking support will be added to the new server.  This parameter attaches a single network. When no network exists in the region, it will be automatically created.  If there are multiple private networks in the instance&#39;s region, use &#x60;attach_private_network&#x60; instead to specify a network. |  [optional] |
|**enableVpc** | **Boolean** | If &#x60;true&#x60;, VPC support will be added to the new server.  This parameter attaches a single VPC. When no VPC exists in the region, it will be automatically created.  If there are multiple VPCs in the instance&#39;s region, use &#x60;attach_vpc&#x60; instead to specify a network. |  [optional] |
|**enableVpc2** | **Boolean** | If &#x60;true&#x60;, VPC 2.0 support will be added to the new server.  This parameter attaches a single VPC 2.0 network. When no VPC 2.0 network exists in the region, it will be automatically created.  If there are multiple VPC 2.0 networks in the instance&#39;s region, use &#x60;attach_vpc2&#x60; instead to specify a network. |  [optional] |
|**tags** | **List&lt;String&gt;** | Tags to apply to the instance |  [optional] |
|**userScheme** | **String** | Linux-only: The user scheme used for logging into this instance. By default, the \&quot;root\&quot; user is configured. Alternatively, a limited user with sudo permissions can be selected.  * root * limited |  [optional] |



