# ContainerRegistryApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createRegistry**](ContainerRegistryApi.md#createRegistry) | **POST** /registry | Create Container Registry |
| [**createRegistryDockerCredentials**](ContainerRegistryApi.md#createRegistryDockerCredentials) | **OPTIONS** /registry/{registry-id}/docker-credentials?expiry_seconds&#x3D;0&amp;read_write&#x3D;false | Create Docker Credentials |
| [**createRegistryKubernetesDockerCredentials**](ContainerRegistryApi.md#createRegistryKubernetesDockerCredentials) | **OPTIONS** /registry/{registry-id}/docker-credentials/kubernetes?expiry_seconds&#x3D;0&amp;read_write&#x3D;false&amp;base64_encode&#x3D;false | Create Docker Credentials for Kubernetes |
| [**deleteRegistry**](ContainerRegistryApi.md#deleteRegistry) | **DELETE** /registry/{registry-id} | Delete Container Registry |
| [**deleteRepository**](ContainerRegistryApi.md#deleteRepository) | **DELETE** /registry/{registry-id}/repository/{repository-image} | Delete Repository |
| [**listRegistries**](ContainerRegistryApi.md#listRegistries) | **GET** /registries | List Container Registries |
| [**listRegistryPlans**](ContainerRegistryApi.md#listRegistryPlans) | **GET** /registry/plan/list | List Registry Plans |
| [**listRegistryRegions**](ContainerRegistryApi.md#listRegistryRegions) | **GET** /registry/region/list | List Registry Regions |
| [**listRegistryRepositories**](ContainerRegistryApi.md#listRegistryRepositories) | **GET** /registry/{registry-id}/repositories | List Repositories |
| [**readRegistry**](ContainerRegistryApi.md#readRegistry) | **GET** /registry/{registry-id} | Read Container Registry |
| [**readRegistryRepository**](ContainerRegistryApi.md#readRegistryRepository) | **GET** /registry/{registry-id}/repository/{repository-image} | Read Repository |
| [**updateRegistry**](ContainerRegistryApi.md#updateRegistry) | **PUT** /registry/{registry-id} | Update Container Registry |
| [**updateRepository**](ContainerRegistryApi.md#updateRepository) | **PUT** /registry/{registry-id}/repository/{repository-image} | Update Repository |


<a id="createRegistry"></a>
# **createRegistry**
> Registry createRegistry(createRegistryRequest)

Create Container Registry

Create a new Container Registry Subscription

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    CreateRegistryRequest createRegistryRequest = new CreateRegistryRequest(); // CreateRegistryRequest | 
    try {
      Registry result = apiInstance.createRegistry(createRegistryRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#createRegistry");
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
| **createRegistryRequest** | [**CreateRegistryRequest**](CreateRegistryRequest.md)|  | [optional] |

### Return type

[**Registry**](Registry.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | OK |  -  |
| **401** | Unauthorized |  -  |
| **422** | Bad Request |  -  |

<a id="createRegistryDockerCredentials"></a>
# **createRegistryDockerCredentials**
> RegistryDockerCredentials createRegistryDockerCredentials(registryId, expirySeconds, readWrite)

Create Docker Credentials

Create a fresh set of Docker Credentials for this Container Registry Subscription

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    String registryId = "registryId_example"; // String | The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries).
    Integer expirySeconds = 56; // Integer | The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0
    Boolean readWrite = true; // Boolean | Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false.
    try {
      RegistryDockerCredentials result = apiInstance.createRegistryDockerCredentials(registryId, expirySeconds, readWrite);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#createRegistryDockerCredentials");
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
| **registryId** | **String**| The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). | |
| **expirySeconds** | **Integer**| The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 | [optional] |
| **readWrite** | **Boolean**| Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. | [optional] |

### Return type

[**RegistryDockerCredentials**](RegistryDockerCredentials.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

<a id="createRegistryKubernetesDockerCredentials"></a>
# **createRegistryKubernetesDockerCredentials**
> RegistryKubernetesDockerCredentials createRegistryKubernetesDockerCredentials(registryId, expirySeconds, readWrite, base64Encode)

Create Docker Credentials for Kubernetes

Create a fresh set of Docker Credentials for this Container Registry Subscription and return them in a Kubernetes friendly YAML format

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    String registryId = "registryId_example"; // String | The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries).
    Integer expirySeconds = 56; // Integer | The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0
    Boolean readWrite = true; // Boolean | Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false.
    Boolean base64Encode = true; // Boolean | Whether this YAML will be returned in a base64 encoded string for ease of downloading. If true, the response will be a base64 encoded string. Default is false.
    try {
      RegistryKubernetesDockerCredentials result = apiInstance.createRegistryKubernetesDockerCredentials(registryId, expirySeconds, readWrite, base64Encode);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#createRegistryKubernetesDockerCredentials");
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
| **registryId** | **String**| The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). | |
| **expirySeconds** | **Integer**| The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 | [optional] |
| **readWrite** | **Boolean**| Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. | [optional] |
| **base64Encode** | **Boolean**| Whether this YAML will be returned in a base64 encoded string for ease of downloading. If true, the response will be a base64 encoded string. Default is false. | [optional] |

### Return type

[**RegistryKubernetesDockerCredentials**](RegistryKubernetesDockerCredentials.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/yaml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

<a id="deleteRegistry"></a>
# **deleteRegistry**
> deleteRegistry(registryId)

Delete Container Registry

Deletes a Container Registry Subscription

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    String registryId = "registryId_example"; // String | The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries).
    try {
      apiInstance.deleteRegistry(registryId);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#deleteRegistry");
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
| **registryId** | **String**| The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). | |

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
| **204** | No Content - Successfully Deleted |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

<a id="deleteRepository"></a>
# **deleteRepository**
> deleteRepository(registryId, repositoryImage)

Delete Repository

Deletes a Repository from a Container Registry Subscription

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    String registryId = "registryId_example"; // String | The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries).
    String repositoryImage = "repositoryImage_example"; // String | The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories).
    try {
      apiInstance.deleteRepository(registryId, repositoryImage);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#deleteRepository");
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
| **registryId** | **String**| The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). | |
| **repositoryImage** | **String**| The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). | |

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
| **204** | No Content - Successfully Deleted |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

<a id="listRegistries"></a>
# **listRegistries**
> ListRegistries200Response listRegistries()

List Container Registries

List All Container Registry Subscriptions for this account

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    try {
      ListRegistries200Response result = apiInstance.listRegistries();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#listRegistries");
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

[**ListRegistries200Response**](ListRegistries200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

<a id="listRegistryPlans"></a>
# **listRegistryPlans**
> ListRegistryPlans200Response listRegistryPlans()

List Registry Plans

List All Plans to help choose which one is the best fit for your Container Registry

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    try {
      ListRegistryPlans200Response result = apiInstance.listRegistryPlans();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#listRegistryPlans");
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

[**ListRegistryPlans200Response**](ListRegistryPlans200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **422** | Bad Request |  -  |

<a id="listRegistryRegions"></a>
# **listRegistryRegions**
> ListRegistryRegions200Response listRegistryRegions()

List Registry Regions

List All Regions where a Container Registry can be deployed

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    try {
      ListRegistryRegions200Response result = apiInstance.listRegistryRegions();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#listRegistryRegions");
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

[**ListRegistryRegions200Response**](ListRegistryRegions200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **422** | Bad Request |  -  |

<a id="listRegistryRepositories"></a>
# **listRegistryRepositories**
> ListRegistryRepositories200Response listRegistryRepositories(registryId)

List Repositories

List All Repositories in a Container Registry Subscription

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    String registryId = "registryId_example"; // String | The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries).
    try {
      ListRegistryRepositories200Response result = apiInstance.listRegistryRepositories(registryId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#listRegistryRepositories");
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
| **registryId** | **String**| The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). | |

### Return type

[**ListRegistryRepositories200Response**](ListRegistryRepositories200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

<a id="readRegistry"></a>
# **readRegistry**
> Registry readRegistry(registryId)

Read Container Registry

Get a single Container Registry Subscription

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    String registryId = "registryId_example"; // String | The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries).
    try {
      Registry result = apiInstance.readRegistry(registryId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#readRegistry");
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
| **registryId** | **String**| The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). | |

### Return type

[**Registry**](Registry.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

<a id="readRegistryRepository"></a>
# **readRegistryRepository**
> RegistryRepository readRegistryRepository(registryId, repositoryImage)

Read Repository

Get a single Repository in a Container Registry Subscription

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    String registryId = "registryId_example"; // String | The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries).
    String repositoryImage = "repositoryImage_example"; // String | The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories).
    try {
      RegistryRepository result = apiInstance.readRegistryRepository(registryId, repositoryImage);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#readRegistryRepository");
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
| **registryId** | **String**| The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). | |
| **repositoryImage** | **String**| The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). | |

### Return type

[**RegistryRepository**](RegistryRepository.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

<a id="updateRegistry"></a>
# **updateRegistry**
> Registry updateRegistry(registryId, updateRegistryRequest)

Update Container Registry

Update a Container Registry Subscription

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    String registryId = "registryId_example"; // String | The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries).
    UpdateRegistryRequest updateRegistryRequest = new UpdateRegistryRequest(); // UpdateRegistryRequest | 
    try {
      Registry result = apiInstance.updateRegistry(registryId, updateRegistryRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#updateRegistry");
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
| **registryId** | **String**| The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). | |
| **updateRegistryRequest** | [**UpdateRegistryRequest**](UpdateRegistryRequest.md)|  | [optional] |

### Return type

[**Registry**](Registry.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

<a id="updateRepository"></a>
# **updateRepository**
> RegistryRepository updateRepository(registryId, repositoryImage, updateRepositoryRequest)

Update Repository

Update a Repository in a Container Registry Subscription

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContainerRegistryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ContainerRegistryApi apiInstance = new ContainerRegistryApi(defaultClient);
    String registryId = "registryId_example"; // String | The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries).
    String repositoryImage = "repositoryImage_example"; // String | The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories).
    UpdateRepositoryRequest updateRepositoryRequest = new UpdateRepositoryRequest(); // UpdateRepositoryRequest | 
    try {
      RegistryRepository result = apiInstance.updateRepository(registryId, repositoryImage, updateRepositoryRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContainerRegistryApi#updateRepository");
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
| **registryId** | **String**| The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). | |
| **repositoryImage** | **String**| The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). | |
| **updateRepositoryRequest** | [**UpdateRepositoryRequest**](UpdateRepositoryRequest.md)|  | [optional] |

### Return type

[**RegistryRepository**](RegistryRepository.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Bad Request |  -  |

