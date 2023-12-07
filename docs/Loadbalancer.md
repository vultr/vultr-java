

# Loadbalancer

Load Balancer information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the Load Balancer. |  [optional] |
|**dateCreated** | **String** | Date this Load Balancer was created. |  [optional] |
|**region** | **String** | The [Region id](#operation/list-regions) where the Load Balancer is located. |  [optional] |
|**label** | **String** | The user-supplied label for this load-balancer. |  [optional] |
|**status** | **String** | The current status.  * active |  [optional] |
|**ipv4** | **String** | The IPv4 address of this Load Balancer. |  [optional] |
|**ipv6** | **String** | The IPv6 address of this Load Balancer. |  [optional] |
|**genericInfo** | [**LoadbalancerGenericInfo**](LoadbalancerGenericInfo.md) |  |  [optional] |
|**healthCheck** | [**LoadbalancerHealthCheck**](LoadbalancerHealthCheck.md) |  |  [optional] |
|**hasSsl** | **Boolean** | Indicates if this Load Balancer has an SSL certificate installed. |  [optional] |
|**http2** | **Boolean** | Indicates if this Load Balancer has HTTP2 enabled. |  [optional] |
|**nodes** | **Integer** | The number of nodes to add to the load balancer (1-99), must be an odd number. This defaults to 1. |  [optional] |
|**forwardRules** | [**List&lt;LoadbalancerForwardRulesInner&gt;**](LoadbalancerForwardRulesInner.md) | An array of forwarding rule objects. |  [optional] |
|**instances** | **List&lt;String&gt;** | Array of [Instance ids](#operation/list-instances) attached to this Load Balancer. |  [optional] |
|**firewallRules** | [**List&lt;LoadbalancerFirewallRulesInner&gt;**](LoadbalancerFirewallRulesInner.md) | An array of firewall rule objects. |  [optional] |



