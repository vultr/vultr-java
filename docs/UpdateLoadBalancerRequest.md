

# UpdateLoadBalancerRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ssl** | [**CreateLoadBalancerRequestSsl**](CreateLoadBalancerRequestSsl.md) |  |  [optional] |
|**stickySession** | [**CreateLoadBalancerRequestStickySession**](CreateLoadBalancerRequestStickySession.md) |  |  [optional] |
|**forwardingRules** | [**List&lt;CreateLoadBalancerRequestForwardingRulesInner&gt;**](CreateLoadBalancerRequestForwardingRulesInner.md) | An array of forwarding rule objects. |  [optional] |
|**healthCheck** | [**UpdateLoadBalancerRequestHealthCheck**](UpdateLoadBalancerRequestHealthCheck.md) |  |  [optional] |
|**proxyProtocol** | **Boolean** | If &#x60;true&#x60;, you must configure backend nodes to accept Proxy protocol.  * true * false (Default) |  [optional] |
|**sslRedirect** | **Boolean** | If &#x60;true&#x60;, this will redirect all HTTP traffic to HTTPS. You must have an HTTPS rule and SSL certificate installed on the load balancer to enable this option.  * true * false |  [optional] |
|**http2** | **Boolean** | If &#x60;true&#x60;, this will enable HTTP2 traffic. You must have an HTTPS forwarding rule combo (HTTPS -&gt; HTTPS) to enable this option.  * true * false |  [optional] |
|**nodes** | **Integer** | The number of nodes to add to the load balancer (1-99), must be an odd number. This defaults to 1. |  [optional] |
|**balancingAlgorithm** | **String** | The balancing algorithm.  * roundrobin (default) * leastconn |  [optional] |
|**instances** | **List&lt;String&gt;** | Send the complete array of Instances IDs that should be attached to this Load Balancer. Instances will be attached or detached to match your array. For example, if Instances **X**, **Y**, and **Z** are currently attached, and you send [A,B,Z], then Instance **A** and **B** will be attached,  **X** and **Y** will be detached, and **Z** will remain attached. |  [optional] |
|**label** | **String** | The label for your Load Balancer |  [optional] |
|**privateNetwork** | **String** | Use &#x60;vpc&#x60; instead. ID of the private network you wish to use. If private_network is omitted it will default to the public network. |  [optional] |
|**vpc** | **String** | ID of the VPC you wish to use. If a VPC ID is omitted it will default to the public network. |  [optional] |
|**firewallRules** | [**List&lt;CreateLoadBalancerRequestFirewallRulesInner&gt;**](CreateLoadBalancerRequestFirewallRulesInner.md) | An array of firewall rule objects. |  [optional] |



