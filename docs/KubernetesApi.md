# KubernetesApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createKubernetesCluster**](KubernetesApi.md#createKubernetesCluster) | **POST** /kubernetes/clusters | Create Kubernetes Cluster |
| [**createNodepools**](KubernetesApi.md#createNodepools) | **POST** /kubernetes/clusters/{vke-id}/node-pools | Create NodePool |
| [**deleteKubernetesCluster**](KubernetesApi.md#deleteKubernetesCluster) | **DELETE** /kubernetes/clusters/{vke-id} | Delete Kubernetes Cluster |
| [**deleteKubernetesClusterVkeIdDeleteWithLinkedResources**](KubernetesApi.md#deleteKubernetesClusterVkeIdDeleteWithLinkedResources) | **DELETE** /kubernetes/clusters/{vke-id}/delete-with-linked-resources | Delete VKE Cluster and All Related Resources |
| [**deleteNodepool**](KubernetesApi.md#deleteNodepool) | **DELETE** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id} | Delete Nodepool |
| [**deleteNodepoolInstance**](KubernetesApi.md#deleteNodepoolInstance) | **DELETE** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id}/nodes/{node-id} | Delete NodePool Instance |
| [**getKubernetesAvailableUpgrades**](KubernetesApi.md#getKubernetesAvailableUpgrades) | **GET** /kubernetes/clusters/{vke-id}/available-upgrades | Get Kubernetes Available Upgrades |
| [**getKubernetesClusters**](KubernetesApi.md#getKubernetesClusters) | **GET** /kubernetes/clusters/{vke-id} | Get Kubernetes Cluster |
| [**getKubernetesClustersConfig**](KubernetesApi.md#getKubernetesClustersConfig) | **GET** /kubernetes/clusters/{vke-id}/config | Get Kubernetes Cluster Kubeconfig |
| [**getKubernetesResources**](KubernetesApi.md#getKubernetesResources) | **GET** /kubernetes/clusters/{vke-id}/resources | Get Kubernetes Resources |
| [**getKubernetesVersions**](KubernetesApi.md#getKubernetesVersions) | **GET** /kubernetes/versions | Get Kubernetes Versions |
| [**getNodepool**](KubernetesApi.md#getNodepool) | **GET** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id} | Get NodePool |
| [**getNodepools**](KubernetesApi.md#getNodepools) | **GET** /kubernetes/clusters/{vke-id}/node-pools | List NodePools |
| [**listKubernetesClusters**](KubernetesApi.md#listKubernetesClusters) | **GET** /kubernetes/clusters | List all Kubernetes Clusters |
| [**recycleNodepoolInstance**](KubernetesApi.md#recycleNodepoolInstance) | **POST** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id}/nodes/{node-id}/recycle | Recycle a NodePool Instance |
| [**startKubernetesClusterUpgrade**](KubernetesApi.md#startKubernetesClusterUpgrade) | **POST** /kubernetes/clusters/{vke-id}/upgrades | Start Kubernetes Cluster Upgrade |
| [**updateKubernetesCluster**](KubernetesApi.md#updateKubernetesCluster) | **PUT** /kubernetes/clusters/{vke-id} | Update Kubernetes Cluster |
| [**updateNodepool**](KubernetesApi.md#updateNodepool) | **PATCH** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id} | Update Nodepool |


<a id="createKubernetesCluster"></a>
# **createKubernetesCluster**
> CreateKubernetesCluster201Response createKubernetesCluster(createKubernetesClusterRequest)

Create Kubernetes Cluster

Create Kubernetes Cluster

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    CreateKubernetesClusterRequest createKubernetesClusterRequest = new CreateKubernetesClusterRequest(); // CreateKubernetesClusterRequest | Request Body
    try {
      CreateKubernetesCluster201Response result = apiInstance.createKubernetesCluster(createKubernetesClusterRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#createKubernetesCluster");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createKubernetesClusterRequest** | [**CreateKubernetesClusterRequest**](CreateKubernetesClusterRequest.md)| Request Body | [optional] |

### Return type

[**CreateKubernetesCluster201Response**](CreateKubernetesCluster201Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="createNodepools"></a>
# **createNodepools**
> CreateNodepools201Response createNodepools(vkeId, createNodepoolsRequest)

Create NodePool

Create NodePool for a Existing Kubernetes Cluster

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    CreateNodepoolsRequest createNodepoolsRequest = new CreateNodepoolsRequest(); // CreateNodepoolsRequest | Request Body
    try {
      CreateNodepools201Response result = apiInstance.createNodepools(vkeId, createNodepoolsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#createNodepools");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |
| **createNodepoolsRequest** | [**CreateNodepoolsRequest**](CreateNodepoolsRequest.md)| Request Body | [optional] |

### Return type

[**CreateNodepools201Response**](CreateNodepools201Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="deleteKubernetesCluster"></a>
# **deleteKubernetesCluster**
> deleteKubernetesCluster(vkeId)

Delete Kubernetes Cluster

Delete Kubernetes Cluster

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    try {
      apiInstance.deleteKubernetesCluster(vkeId);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#deleteKubernetesCluster");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="deleteKubernetesClusterVkeIdDeleteWithLinkedResources"></a>
# **deleteKubernetesClusterVkeIdDeleteWithLinkedResources**
> deleteKubernetesClusterVkeIdDeleteWithLinkedResources(vkeId)

Delete VKE Cluster and All Related Resources

Delete Kubernetes Cluster and all related resources. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | 
    try {
      apiInstance.deleteKubernetesClusterVkeIdDeleteWithLinkedResources(vkeId);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#deleteKubernetesClusterVkeIdDeleteWithLinkedResources");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**|  | |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="deleteNodepool"></a>
# **deleteNodepool**
> deleteNodepool(vkeId, nodepoolId)

Delete Nodepool

Delete a NodePool from a Kubernetes Cluster

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    String nodepoolId = "nodepoolId_example"; // String | The [NodePool ID](#operation/get-nodepools).
    try {
      apiInstance.deleteNodepool(vkeId, nodepoolId);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#deleteNodepool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |
| **nodepoolId** | **String**| The [NodePool ID](#operation/get-nodepools). | |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="deleteNodepoolInstance"></a>
# **deleteNodepoolInstance**
> deleteNodepoolInstance(vkeId, nodepoolId, nodeId)

Delete NodePool Instance

Delete a single nodepool instance from a given Nodepool

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    String nodepoolId = "nodepoolId_example"; // String | The [NodePool ID](#operation/get-nodepools).
    String nodeId = "nodeId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      apiInstance.deleteNodepoolInstance(vkeId, nodepoolId, nodeId);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#deleteNodepoolInstance");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |
| **nodepoolId** | **String**| The [NodePool ID](#operation/get-nodepools). | |
| **nodeId** | **String**| The [Instance ID](#operation/list-instances). | |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getKubernetesAvailableUpgrades"></a>
# **getKubernetesAvailableUpgrades**
> GetKubernetesAvailableUpgrades200Response getKubernetesAvailableUpgrades(vkeId)

Get Kubernetes Available Upgrades

Get the available upgrades for the specified Kubernetes cluster.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    try {
      GetKubernetesAvailableUpgrades200Response result = apiInstance.getKubernetesAvailableUpgrades(vkeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#getKubernetesAvailableUpgrades");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |

### Return type

[**GetKubernetesAvailableUpgrades200Response**](GetKubernetesAvailableUpgrades200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getKubernetesClusters"></a>
# **getKubernetesClusters**
> CreateKubernetesCluster201Response getKubernetesClusters(vkeId)

Get Kubernetes Cluster

Get Kubernetes Cluster

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    try {
      CreateKubernetesCluster201Response result = apiInstance.getKubernetesClusters(vkeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#getKubernetesClusters");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |

### Return type

[**CreateKubernetesCluster201Response**](CreateKubernetesCluster201Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getKubernetesClustersConfig"></a>
# **getKubernetesClustersConfig**
> GetKubernetesClustersConfig200Response getKubernetesClustersConfig(vkeId)

Get Kubernetes Cluster Kubeconfig

Get Kubernetes Cluster Kubeconfig

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    try {
      GetKubernetesClustersConfig200Response result = apiInstance.getKubernetesClustersConfig(vkeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#getKubernetesClustersConfig");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |

### Return type

[**GetKubernetesClustersConfig200Response**](GetKubernetesClustersConfig200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getKubernetesResources"></a>
# **getKubernetesResources**
> GetKubernetesResources200Response getKubernetesResources(vkeId)

Get Kubernetes Resources

Get the block storage volumes and load balancers deployed by the specified Kubernetes cluster.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    try {
      GetKubernetesResources200Response result = apiInstance.getKubernetesResources(vkeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#getKubernetesResources");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |

### Return type

[**GetKubernetesResources200Response**](GetKubernetesResources200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getKubernetesVersions"></a>
# **getKubernetesVersions**
> GetKubernetesVersions200Response getKubernetesVersions()

Get Kubernetes Versions

Get a list of supported Kubernetes versions

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    try {
      GetKubernetesVersions200Response result = apiInstance.getKubernetesVersions();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#getKubernetesVersions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetKubernetesVersions200Response**](GetKubernetesVersions200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **404** | Not Found |  -  |

<a id="getNodepool"></a>
# **getNodepool**
> CreateNodepools201Response getNodepool(vkeId, nodepoolId)

Get NodePool

Get Nodepool from a Kubernetes Cluster

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    String nodepoolId = "nodepoolId_example"; // String | The [NodePool ID](#operation/get-nodepools).
    try {
      CreateNodepools201Response result = apiInstance.getNodepool(vkeId, nodepoolId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#getNodepool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |
| **nodepoolId** | **String**| The [NodePool ID](#operation/get-nodepools). | |

### Return type

[**CreateNodepools201Response**](CreateNodepools201Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getNodepools"></a>
# **getNodepools**
> GetNodepools200Response getNodepools(vkeId)

List NodePools

List all available NodePools on a Kubernetes Cluster

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    try {
      GetNodepools200Response result = apiInstance.getNodepools(vkeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#getNodepools");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |

### Return type

[**GetNodepools200Response**](GetNodepools200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="listKubernetesClusters"></a>
# **listKubernetesClusters**
> ListKubernetesClusters200Response listKubernetesClusters()

List all Kubernetes Clusters

List all Kubernetes clusters currently deployed

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    try {
      ListKubernetesClusters200Response result = apiInstance.listKubernetesClusters();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#listKubernetesClusters");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListKubernetesClusters200Response**](ListKubernetesClusters200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="recycleNodepoolInstance"></a>
# **recycleNodepoolInstance**
> recycleNodepoolInstance(vkeId, nodepoolId, nodeId)

Recycle a NodePool Instance

Recycle a specific NodePool Instance

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    String nodepoolId = "nodepoolId_example"; // String | The [NodePool ID](#operation/get-nodepools).
    String nodeId = "nodeId_example"; // String | Node ID
    try {
      apiInstance.recycleNodepoolInstance(vkeId, nodepoolId, nodeId);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#recycleNodepoolInstance");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |
| **nodepoolId** | **String**| The [NodePool ID](#operation/get-nodepools). | |
| **nodeId** | **String**| Node ID | |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="startKubernetesClusterUpgrade"></a>
# **startKubernetesClusterUpgrade**
> startKubernetesClusterUpgrade(vkeId, startKubernetesClusterUpgradeRequest)

Start Kubernetes Cluster Upgrade

Start a Kubernetes cluster upgrade.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    StartKubernetesClusterUpgradeRequest startKubernetesClusterUpgradeRequest = new StartKubernetesClusterUpgradeRequest(); // StartKubernetesClusterUpgradeRequest | Request Body
    try {
      apiInstance.startKubernetesClusterUpgrade(vkeId, startKubernetesClusterUpgradeRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#startKubernetesClusterUpgrade");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |
| **startKubernetesClusterUpgradeRequest** | [**StartKubernetesClusterUpgradeRequest**](StartKubernetesClusterUpgradeRequest.md)| Request Body | [optional] |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="updateKubernetesCluster"></a>
# **updateKubernetesCluster**
> updateKubernetesCluster(vkeId, updateKubernetesClusterRequest)

Update Kubernetes Cluster

Update Kubernetes Cluster

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    UpdateKubernetesClusterRequest updateKubernetesClusterRequest = new UpdateKubernetesClusterRequest(); // UpdateKubernetesClusterRequest | Request Body
    try {
      apiInstance.updateKubernetesCluster(vkeId, updateKubernetesClusterRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#updateKubernetesCluster");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |
| **updateKubernetesClusterRequest** | [**UpdateKubernetesClusterRequest**](UpdateKubernetesClusterRequest.md)| Request Body | [optional] |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="updateNodepool"></a>
# **updateNodepool**
> CreateNodepools201Response updateNodepool(vkeId, nodepoolId, updateNodepoolRequest)

Update Nodepool

Update a Nodepool on a Kubernetes Cluster

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KubernetesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    KubernetesApi apiInstance = new KubernetesApi(defaultClient);
    String vkeId = "vkeId_example"; // String | The [VKE ID](#operation/list-kubernetes-clusters).
    String nodepoolId = "nodepoolId_example"; // String | The [NodePool ID](#operation/get-nodepools).
    UpdateNodepoolRequest updateNodepoolRequest = new UpdateNodepoolRequest(); // UpdateNodepoolRequest | Request Body
    try {
      CreateNodepools201Response result = apiInstance.updateNodepool(vkeId, nodepoolId, updateNodepoolRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KubernetesApi#updateNodepool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **vkeId** | **String**| The [VKE ID](#operation/list-kubernetes-clusters). | |
| **nodepoolId** | **String**| The [NodePool ID](#operation/get-nodepools). | |
| **updateNodepoolRequest** | [**UpdateNodepoolRequest**](UpdateNodepoolRequest.md)| Request Body | [optional] |

### Return type

[**CreateNodepools201Response**](CreateNodepools201Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

