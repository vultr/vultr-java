

# LoadbalancerGenericInfo

An object containing additional options.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**balancingAlgorithm** | **String** | The balancing algorithm.  * roundrobin (default) * leastconn |  [optional] |
|**sslRedirect** | **Boolean** | If &#x60;true&#x60;, this will redirect all HTTP traffic to HTTPS. You must have an HTTPS rule and SSL certificate installed on the load balancer to enable this option.  * true * false |  [optional] |
|**stickySessions** | [**LoadbalancerGenericInfoStickySessions**](LoadbalancerGenericInfoStickySessions.md) |  |  [optional] |
|**proxyProtocol** | **Boolean** | \&quot;If &#x60;true&#x60;, you must configure backend nodes to accept Proxy protocol. \\n\\n* true\\n* false (Default)\&quot; |  [optional] |
|**privateNetwork** | **String** | Use &#x60;vpc&#x60; instead. ID of the private network you wish to use. If private_network is omitted it will default to the public network. |  [optional] |
|**vpc** | **String** | ID of the VPC you wish to use. If a VPC ID is omitted it will default to the public network. |  [optional] |



