

# CreateKubernetesClusterRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**label** | **String** | The label for your Kubernetes cluster. |  [optional] |
|**region** | **String** | Region you want to deploy VKE in. See [Regions](#tag/region) for more information. |  |
|**version** | **String** | Version of Kubernetes you want to deploy. |  |
|**haControlplanes** | **Boolean** | Whether a highly available control planes configuration should be deployed * true * false (default) |  [optional] |
|**enableFirewall** | **Boolean** | Whether a [Firewall Group](#tag/firewall) should be deployed and managed by this cluster * true * false (default) |  [optional] |
|**nodePools** | [**List&lt;CreateKubernetesClusterRequestNodePoolsInner&gt;**](CreateKubernetesClusterRequestNodePoolsInner.md) |  |  [optional] |



