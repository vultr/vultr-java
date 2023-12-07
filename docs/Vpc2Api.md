# Vpc2Api

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**attachVpc2Nodes**](Vpc2Api.md#attachVpc2Nodes) | **POST** /vpc2/{vpc-id}/nodes/attach | Attach nodes to a VPC 2.0 network |
| [**createVpc2**](Vpc2Api.md#createVpc2) | **POST** /vpc2 | Create a VPC 2.0 network |
| [**deleteVpc2**](Vpc2Api.md#deleteVpc2) | **DELETE** /vpc2/{vpc-id} | Delete a VPC 2.0 network |
| [**detachVpc2Nodes**](Vpc2Api.md#detachVpc2Nodes) | **POST** /vpc2/{vpc-id}/nodes/detach | Remove nodes from a VPC 2.0 network |
| [**getVpc2**](Vpc2Api.md#getVpc2) | **GET** /vpc2/{vpc-id} | Get a VPC 2.0 network |
| [**listVpc2**](Vpc2Api.md#listVpc2) | **GET** /vpc2 | List VPC 2.0 networks |
| [**listVpc2Nodes**](Vpc2Api.md#listVpc2Nodes) | **GET** /vpc2/{vpc-id}/nodes | Get a list of nodes attached to a VPC 2.0 network |
| [**updateVpc2**](Vpc2Api.md#updateVpc2) | **PUT** /vpc2/{vpc-id} | Update a VPC 2.0 network |


<a id="attachVpc2Nodes"></a>
# **attachVpc2Nodes**
> attachVpc2Nodes(vpcId, attachVpc2NodesRequest)

Attach nodes to a VPC 2.0 network

Attach nodes to a VPC 2.0 network.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Vpc2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    Vpc2Api apiInstance = new Vpc2Api(defaultClient);
    String vpcId = "vpcId_example"; // String | The [VPC ID](#operation/list-vpcs).
    AttachVpc2NodesRequest attachVpc2NodesRequest = new AttachVpc2NodesRequest(); // AttachVpc2NodesRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.attachVpc2Nodes(vpcId, attachVpc2NodesRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling Vpc2Api#attachVpc2Nodes");
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
| **vpcId** | **String**| The [VPC ID](#operation/list-vpcs). | |
| **attachVpc2NodesRequest** | [**AttachVpc2NodesRequest**](AttachVpc2NodesRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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
| **202** | accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="createVpc2"></a>
# **createVpc2**
> GetVpc2200Response createVpc2(createVpc2Request)

Create a VPC 2.0 network

Create a new VPC 2.0 network in a &#x60;region&#x60;. VPCs should use [RFC1918 private address space](https://tools.ietf.org/html/rfc1918):      10.0.0.0    - 10.255.255.255  (10/8 prefix)     172.16.0.0  - 172.31.255.255  (172.16/12 prefix)     192.168.0.0 - 192.168.255.255 (192.168/16 prefix) 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Vpc2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    Vpc2Api apiInstance = new Vpc2Api(defaultClient);
    CreateVpc2Request createVpc2Request = new CreateVpc2Request(); // CreateVpc2Request | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetVpc2200Response result = apiInstance.createVpc2(createVpc2Request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Vpc2Api#createVpc2");
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
| **createVpc2Request** | [**CreateVpc2Request**](CreateVpc2Request.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetVpc2200Response**](GetVpc2200Response.md)

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

<a id="deleteVpc2"></a>
# **deleteVpc2**
> deleteVpc2(vpcId)

Delete a VPC 2.0 network

Delete a VPC 2.0 network.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Vpc2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    Vpc2Api apiInstance = new Vpc2Api(defaultClient);
    String vpcId = "vpcId_example"; // String | The [VPC ID](#operation/list-vpcs).
    try {
      apiInstance.deleteVpc2(vpcId);
    } catch (ApiException e) {
      System.err.println("Exception when calling Vpc2Api#deleteVpc2");
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
| **vpcId** | **String**| The [VPC ID](#operation/list-vpcs). | |

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="detachVpc2Nodes"></a>
# **detachVpc2Nodes**
> detachVpc2Nodes(vpcId, detachVpc2NodesRequest)

Remove nodes from a VPC 2.0 network

Remove nodes from a VPC 2.0 network.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Vpc2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    Vpc2Api apiInstance = new Vpc2Api(defaultClient);
    String vpcId = "vpcId_example"; // String | The [VPC ID](#operation/list-vpcs).
    DetachVpc2NodesRequest detachVpc2NodesRequest = new DetachVpc2NodesRequest(); // DetachVpc2NodesRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.detachVpc2Nodes(vpcId, detachVpc2NodesRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling Vpc2Api#detachVpc2Nodes");
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
| **vpcId** | **String**| The [VPC ID](#operation/list-vpcs). | |
| **detachVpc2NodesRequest** | [**DetachVpc2NodesRequest**](DetachVpc2NodesRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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
| **202** | accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="getVpc2"></a>
# **getVpc2**
> GetVpc2200Response getVpc2(vpcId)

Get a VPC 2.0 network

Get information about a VPC 2.0 network.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Vpc2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    Vpc2Api apiInstance = new Vpc2Api(defaultClient);
    String vpcId = "vpcId_example"; // String | The [VPC ID](#operation/list-vpcs).
    try {
      GetVpc2200Response result = apiInstance.getVpc2(vpcId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Vpc2Api#getVpc2");
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
| **vpcId** | **String**| The [VPC ID](#operation/list-vpcs). | |

### Return type

[**GetVpc2200Response**](GetVpc2200Response.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listVpc2"></a>
# **listVpc2**
> ListVpc2200Response listVpc2(perPage, cursor)

List VPC 2.0 networks

Get a list of all VPC 2.0 networks in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Vpc2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    Vpc2Api apiInstance = new Vpc2Api(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListVpc2200Response result = apiInstance.listVpc2(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Vpc2Api#listVpc2");
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
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListVpc2200Response**](ListVpc2200Response.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listVpc2Nodes"></a>
# **listVpc2Nodes**
> GetVpc2200Response listVpc2Nodes(vpcId, perPage, cursor)

Get a list of nodes attached to a VPC 2.0 network

Get a list of nodes attached to a VPC 2.0 network.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Vpc2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    Vpc2Api apiInstance = new Vpc2Api(defaultClient);
    String vpcId = "vpcId_example"; // String | The [VPC ID](#operation/list-vpcs).
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      GetVpc2200Response result = apiInstance.listVpc2Nodes(vpcId, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Vpc2Api#listVpc2Nodes");
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
| **vpcId** | **String**| The [VPC ID](#operation/list-vpcs). | |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**GetVpc2200Response**](GetVpc2200Response.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="updateVpc2"></a>
# **updateVpc2**
> updateVpc2(vpcId, updateVpc2Request)

Update a VPC 2.0 network

Update information for a VPC 2.0 network.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Vpc2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    Vpc2Api apiInstance = new Vpc2Api(defaultClient);
    String vpcId = "vpcId_example"; // String | The [VPC ID](#operation/list-vpcs).
    UpdateVpc2Request updateVpc2Request = new UpdateVpc2Request(); // UpdateVpc2Request | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateVpc2(vpcId, updateVpc2Request);
    } catch (ApiException e) {
      System.err.println("Exception when calling Vpc2Api#updateVpc2");
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
| **vpcId** | **String**| The [VPC ID](#operation/list-vpcs). | |
| **updateVpc2Request** | [**UpdateVpc2Request**](UpdateVpc2Request.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

