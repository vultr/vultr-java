

# CreateVpcRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**region** | **String** | Create the VPC in this [Region id](#operation/list-regions). |  |
|**description** | **String** | A description of the VPC. |  [optional] |
|**v4Subnet** | **String** | The IPv4 VPC address. For example: 10.99.0.0&lt;br&gt;&lt;span style&#x3D;\&quot;color: red\&quot;&gt;If v4_subnet_mask is specified then v4_subnet is a required field.&lt;/span&gt; |  [optional] |
|**v4SubnetMask** | **Integer** | The number of bits for the netmask in CIDR notation. Example: 24&lt;br&gt;&lt;span style&#x3D;\&quot;color: red\&quot;&gt;If v4_subnet is specified then v4_subnet_mask is a required field.&lt;/span&gt; |  [optional] |



