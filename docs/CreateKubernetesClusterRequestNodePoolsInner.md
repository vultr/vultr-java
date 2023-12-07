

# CreateKubernetesClusterRequestNodePoolsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**nodeQuantity** | **Integer** | Number of instances to deploy in this nodepool. Minimum of 1 node required, but at least 3 is recommended. |  |
|**label** | **String** | Label for this nodepool. You cannot change the label after a nodepool is created. You cannot have duplicate node pool labels in the same cluster. |  |
|**plan** | **String** | Plan you want this nodepool to use. Note: minimum plan must be $10 |  |
|**tag** | **String** | Tag for node pool |  [optional] |
|**autoScaler** | **Boolean** | Option to use the auto scaler with your cluster. Default false. |  [optional] |
|**minNodes** | **Integer** | Auto scaler field for minimum nodes you want for your cluster. Default 1. |  [optional] |
|**maxNodes** | **Integer** | Auto scaler field for maximum nodes you want for your cluster. Default 1. |  [optional] |



