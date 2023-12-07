

# Instance

Instance information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the VPS Instance. |  [optional] |
|**os** | **String** | The [Operating System name](#operation/list-os). |  [optional] |
|**ram** | **Integer** | The amount of RAM in MB. |  [optional] |
|**disk** | **Integer** | The size of the disk in GB. |  [optional] |
|**mainIp** | **String** | The main IPv4 address. |  [optional] |
|**vcpuCount** | **Integer** | Number of vCPUs. |  [optional] |
|**region** | **String** | The [Region id](#operation/list-regions) where the Instance is located. |  [optional] |
|**defaultPassword** | **String** | The default password assigned at deployment. Only available for ten minutes after deployment. |  [optional] |
|**dateCreated** | **String** | The date this instance was created. |  [optional] |
|**status** | **String** | The current status.  * active * pending * suspended * resizing |  [optional] |
|**powerStatus** | **String** | The power-on status.  * running * stopped |  [optional] |
|**serverStatus** | **String** | The server health status.  * none * locked * installingbooting * ok |  [optional] |
|**allowedBandwidth** | **Integer** | Monthly bandwidth quota in GB. |  [optional] |
|**netmaskV4** | **String** | The IPv4 netmask in dot-decimal notation. |  [optional] |
|**gatewayV4** | **String** | The gateway IP address. |  [optional] |
|**v6Networks** | [**List&lt;InstanceV6NetworksInner&gt;**](InstanceV6NetworksInner.md) | An array of IPv6 objects. |  [optional] |
|**hostname** | **String** | The hostname for this instance. |  [optional] |
|**label** | **String** | The user-supplied label for this instance. |  [optional] |
|**tag** | **String** | Use &#x60;tags&#x60; instead. The user-supplied tag for this instance. |  [optional] |
|**internalIp** | **String** | The internal IP used by this instance, if set. Only relevant when a VPC is attached. |  [optional] |
|**kvm** | **String** | HTTPS link to the Vultr noVNC Web Console. |  [optional] |
|**osId** | **Integer** | The [Operating System id](#operation/list-os) used by this instance. |  [optional] |
|**appId** | **Integer** | The [Application id](#operation/list-applications) used by this instance. |  [optional] |
|**imageId** | **String** | The [Application image_id](#operation/list-applications) used by this instance. |  [optional] |
|**firewallGroupId** | **String** | The [Firewall Group id](#operation/list-firewall-groups) linked to this Instance. |  [optional] |
|**features** | **List&lt;String&gt;** | \&quot;auto_backups\&quot;, \&quot;ipv6\&quot;, \&quot;ddos_protection\&quot; |  [optional] |
|**plan** | **String** | A unique ID for the Plan. |  [optional] |
|**tags** | **List&lt;String&gt;** | Tags to apply to the instance. |  [optional] |
|**userScheme** | **String** | The user scheme.  * root * limited |  [optional] |



