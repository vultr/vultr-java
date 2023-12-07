

# LoadbalancerForwardRulesInner

A forwarding rule object.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the forwarding rule. |  [optional] |
|**frontendProtocol** | **String** | The protocol on the Load Balancer to forward to the backend.  * HTTP * HTTPS * TCP |  [optional] |
|**frontendPort** | **Integer** | The port number on the Load Balancer to forward to the backend. |  [optional] |
|**backendPortocol** | **String** | The protocol destination on the backend server.  * HTTP * HTTPS * TCP |  [optional] |
|**backendPort** | **Integer** | The port number destination on the backend server.  |  [optional] |



