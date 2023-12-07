

# CreateNodepoolsRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**nodeQuantity** | **Integer** | Number of instances in this nodepool |  |
|**label** | **String** | Label for the nodepool. You cannot change the label after a nodepool is created. You cannot have duplicate node pool labels in the same cluster. |  |
|**plan** | **String** | Plan that this nodepool will use |  |
|**tag** | **String** | Tag for node pool |  [optional] |
|**autoScaler** | **Boolean** | Option to use the auto scaler with your cluster. Default false. |  [optional] |
|**minNodes** | **Integer** | Auto scaler field for minimum nodes you want for your cluster. Default 1. |  [optional] |
|**maxNodes** | **Integer** | Auto scaler field for maximum nodes you want for your cluster. Default 1. |  [optional] |



