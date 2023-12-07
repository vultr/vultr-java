

# VkeCluster

VKE Cluster

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | ID for the VKE cluster |  [optional] |
|**firewallGroupId** | **String** | The [Firewall Group id](#operation/list-firewall-groups) linked to this cluster. |  [optional] |
|**label** | **String** | Label for your cluster |  [optional] |
|**dateCreated** | **String** | Date of creation |  [optional] |
|**clusterSubnet** | **String** | IP range that your pods will run on in this cluster |  [optional] |
|**serviceSubnet** | **String** | IP range that services will run on this cluster |  [optional] |
|**ip** | **String** | IP for your Kubernetes Clusters Control Plane |  [optional] |
|**endpoint** | **String** | Domain for your Kubernetes Clusters Control Plane |  [optional] |
|**version** | **String** | Version of Kubernetes this cluster is running on |  [optional] |
|**region** | **String** | Region this Kubernetes Cluster is running in |  [optional] |
|**status** | **String** | Status for VKE cluster |  [optional] |
|**haControlplanes** | **Boolean** | Whether a highly available control planes configuration has been deployed * true * false (default) |  [optional] |
|**nodePools** | [**List&lt;Nodepools&gt;**](Nodepools.md) | NodePools in this cluster |  [optional] |



