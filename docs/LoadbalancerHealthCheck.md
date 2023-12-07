

# LoadbalancerHealthCheck

The health check object configuration. See [Load Balancer documentation](https://www.vultr.com/docs/vultr-load-balancers/#Load_Balancer_Configuration).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**protocol** | **String** | The protocol to use for health checks.  * HTTPS * HTTP * TCP |  [optional] |
|**port** | **Integer** | The port to use for health checks. |  [optional] |
|**path** | **String** | HTTP Path to check. Only applies if Protocol is HTTP or HTTPS. |  [optional] |
|**checkInterval** | **Integer** | Interval between health checks. |  [optional] |
|**responseTimeout** | **Integer** | Timeout before health check fails. |  [optional] |
|**unhealthyThreshold** | **Integer** | Number times a check must fail before becoming unhealthy. |  [optional] |
|**healthyThreshold** | **Integer** | Number of times a check must succeed before returning to healthy status. |  [optional] |



