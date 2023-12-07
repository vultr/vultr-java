

# CreateLoadBalancerRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**region** | **String** | The [Region id](#operation/list-regions) to create this Load Balancer. |  |
|**balancingAlgorithm** | **String** | The balancing algorithm.  * roundrobin (default) * leastconn |  [optional] |
|**sslRedirect** | **Boolean** | If &#x60;true&#x60;, this will redirect all HTTP traffic to HTTPS. You must have an HTTPS rule and SSL certificate installed on the load balancer to enable this option.  * true * false |  [optional] |
|**http2** | **Boolean** | If &#x60;true&#x60;, this will enable HTTP2 traffic. You must have an HTTPS forwarding rule combo (HTTPS -&gt; HTTPS) to enable this option.  * true * false |  [optional] |
|**nodes** | **Integer** | The number of nodes to add to the load balancer (1-99), must be an odd number. This defaults to 1. |  [optional] |
|**proxyProtocol** | **Boolean** | If &#x60;true&#x60;, you must configure backend nodes to accept Proxy protocol.  * true * false (Default) |  [optional] |
|**healthCheck** | [**CreateLoadBalancerRequestHealthCheck**](CreateLoadBalancerRequestHealthCheck.md) |  |  [optional] |
|**forwardingRules** | [**List&lt;CreateLoadBalancerRequestForwardingRulesInner&gt;**](CreateLoadBalancerRequestForwardingRulesInner.md) | An array of forwarding rule objects. |  [optional] |
|**stickySession** | [**CreateLoadBalancerRequestStickySession**](CreateLoadBalancerRequestStickySession.md) |  |  [optional] |
|**ssl** | [**CreateLoadBalancerRequestSsl**](CreateLoadBalancerRequestSsl.md) |  |  [optional] |
|**label** | **String** | Label for your Load Balancer. |  [optional] |
|**instances** | **List&lt;String&gt;** | An array of instances IDs that you want attached to the load balancer. |  [optional] |
|**firewallRules** | [**List&lt;CreateLoadBalancerRequestFirewallRulesInner&gt;**](CreateLoadBalancerRequestFirewallRulesInner.md) | An array of firewall rule objects. |  [optional] |
|**privateNetwork** | **String** | Use &#x60;vpc&#x60; instead. ID of the private network you wish to use. If private_network is omitted it will default to the public network. |  [optional] |
|**vpc** | **String** | ID of the VPC you wish to use. If a VPC ID is omitted it will default to the public network. |  [optional] |



