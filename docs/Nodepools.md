

# Nodepools

NodePool

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The [NodePool ID](#operation/get-nodepools). |  [optional] |
|**dateCreated** | **String** | Date of creation |  [optional] |
|**label** | **String** | Label for nodepool |  [optional] |
|**tag** | **String** | Tag for node pool |  [optional] |
|**plan** | **String** | Plan used for nodepool |  [optional] |
|**status** | **String** | Status for nodepool |  [optional] |
|**nodeQuantity** | **Integer** | Number of nodes in nodepool |  [optional] |
|**nodes** | [**List&lt;NodepoolInstances&gt;**](NodepoolInstances.md) |  |  [optional] |
|**dateUpdated** | **String** | Date the nodepool was updated. |  [optional] |
|**autoScaler** | **Boolean** | Displays if the auto scaler is enabled or disabled for your cluster. |  [optional] |
|**minNodes** | **Integer** | Auto scaler field that displays the minimum nodes you want for your cluster. |  [optional] |
|**maxNodes** | **Integer** | Auto scaler field that displays the maximum nodes you want for your cluster. |  [optional] |



