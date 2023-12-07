

# UpdateNodepoolRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**nodeQuantity** | **Integer** | Number of instances in the NodePool. Minimum of 1 is required, but at least 3 is recommended. |  [optional] |
|**tag** | **String** | Tag for your node pool |  [optional] |
|**autoScaler** | **Boolean** | Option to use the auto scaler for your cluster. Default false. |  [optional] |
|**minNodes** | **Integer** | Auto scaler field for minimum nodes you want for your cluster. Default 1. |  [optional] |
|**maxNodes** | **Integer** | Auto scaler field for maximum nodes you want for your cluster. Default 1. |  [optional] |



