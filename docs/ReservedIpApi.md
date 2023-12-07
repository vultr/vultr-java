# ReservedIpApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**attachReservedIp**](ReservedIpApi.md#attachReservedIp) | **POST** /reserved-ips/{reserved-ip}/attach | Attach Reserved IP |
| [**convertReservedIp**](ReservedIpApi.md#convertReservedIp) | **POST** /reserved-ips/convert | Convert Instance IP to Reserved IP |
| [**createReservedIp**](ReservedIpApi.md#createReservedIp) | **POST** /reserved-ips | Create Reserved IP |
| [**deleteReservedIp**](ReservedIpApi.md#deleteReservedIp) | **DELETE** /reserved-ips/{reserved-ip} | Delete Reserved IP |
| [**detachReservedIp**](ReservedIpApi.md#detachReservedIp) | **POST** /reserved-ips/{reserved-ip}/detach | Detach Reserved IP |
| [**getReservedIp**](ReservedIpApi.md#getReservedIp) | **GET** /reserved-ips/{reserved-ip} | Get Reserved IP |
| [**listReservedIps**](ReservedIpApi.md#listReservedIps) | **GET** /reserved-ips | List Reserved IPs |
| [**patchReservedIpsReservedIp**](ReservedIpApi.md#patchReservedIpsReservedIp) | **PATCH** /reserved-ips/{reserved-ip} | Update Reserved IP |


<a id="attachReservedIp"></a>
# **attachReservedIp**
> attachReservedIp(reservedIp, attachReservedIpRequest)

Attach Reserved IP

Attach a Reserved IP to an compute instance or a baremetal instance - &#x60;instance_id&#x60;.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ReservedIpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ReservedIpApi apiInstance = new ReservedIpApi(defaultClient);
    String reservedIp = "reservedIp_example"; // String | The [Reserved IP id](#operation/list-reserved-ips)
    AttachReservedIpRequest attachReservedIpRequest = new AttachReservedIpRequest(); // AttachReservedIpRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.attachReservedIp(reservedIp, attachReservedIpRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReservedIpApi#attachReservedIp");
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
| **reservedIp** | **String**| The [Reserved IP id](#operation/list-reserved-ips) | |
| **attachReservedIpRequest** | [**AttachReservedIpRequest**](AttachReservedIpRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="convertReservedIp"></a>
# **convertReservedIp**
> GetReservedIp200Response convertReservedIp(convertReservedIpRequest)

Convert Instance IP to Reserved IP

Convert the &#x60;ip_address&#x60; of an existing [instance](#operation/list-instances) into a Reserved IP.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ReservedIpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ReservedIpApi apiInstance = new ReservedIpApi(defaultClient);
    ConvertReservedIpRequest convertReservedIpRequest = new ConvertReservedIpRequest(); // ConvertReservedIpRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetReservedIp200Response result = apiInstance.convertReservedIp(convertReservedIpRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReservedIpApi#convertReservedIp");
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
| **convertReservedIpRequest** | [**ConvertReservedIpRequest**](ConvertReservedIpRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetReservedIp200Response**](GetReservedIp200Response.md)

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

<a id="createReservedIp"></a>
# **createReservedIp**
> GetReservedIp200Response createReservedIp(createReservedIpRequest)

Create Reserved IP

Create a new Reserved IP. The &#x60;region&#x60; and &#x60;ip_type&#x60; attributes are required.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ReservedIpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ReservedIpApi apiInstance = new ReservedIpApi(defaultClient);
    CreateReservedIpRequest createReservedIpRequest = new CreateReservedIpRequest(); // CreateReservedIpRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetReservedIp200Response result = apiInstance.createReservedIp(createReservedIpRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReservedIpApi#createReservedIp");
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
| **createReservedIpRequest** | [**CreateReservedIpRequest**](CreateReservedIpRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetReservedIp200Response**](GetReservedIp200Response.md)

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

<a id="deleteReservedIp"></a>
# **deleteReservedIp**
> deleteReservedIp(reservedIp)

Delete Reserved IP

Delete a Reserved IP.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ReservedIpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ReservedIpApi apiInstance = new ReservedIpApi(defaultClient);
    String reservedIp = "reservedIp_example"; // String | The [Reserved IP id](#operation/list-reserved-ips).
    try {
      apiInstance.deleteReservedIp(reservedIp);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReservedIpApi#deleteReservedIp");
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
| **reservedIp** | **String**| The [Reserved IP id](#operation/list-reserved-ips). | |

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

<a id="detachReservedIp"></a>
# **detachReservedIp**
> detachReservedIp(reservedIp)

Detach Reserved IP

Detach a Reserved IP.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ReservedIpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ReservedIpApi apiInstance = new ReservedIpApi(defaultClient);
    String reservedIp = "reservedIp_example"; // String | The [Reserved IP id](#operation/list-reserved-ips)
    try {
      apiInstance.detachReservedIp(reservedIp);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReservedIpApi#detachReservedIp");
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
| **reservedIp** | **String**| The [Reserved IP id](#operation/list-reserved-ips) | |

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

<a id="getReservedIp"></a>
# **getReservedIp**
> GetReservedIp200Response getReservedIp(reservedIp)

Get Reserved IP

Get information about a Reserved IP.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ReservedIpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ReservedIpApi apiInstance = new ReservedIpApi(defaultClient);
    String reservedIp = "reservedIp_example"; // String | The [Reserved IP id](#operation/list-reserved-ips).
    try {
      GetReservedIp200Response result = apiInstance.getReservedIp(reservedIp);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReservedIpApi#getReservedIp");
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
| **reservedIp** | **String**| The [Reserved IP id](#operation/list-reserved-ips). | |

### Return type

[**GetReservedIp200Response**](GetReservedIp200Response.md)

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

<a id="listReservedIps"></a>
# **listReservedIps**
> ListReservedIps200Response listReservedIps(perPage, cursor)

List Reserved IPs

List all Reserved IPs in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ReservedIpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ReservedIpApi apiInstance = new ReservedIpApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListReservedIps200Response result = apiInstance.listReservedIps(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReservedIpApi#listReservedIps");
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

[**ListReservedIps200Response**](ListReservedIps200Response.md)

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

<a id="patchReservedIpsReservedIp"></a>
# **patchReservedIpsReservedIp**
> GetReservedIp200Response patchReservedIpsReservedIp(reservedIp, patchReservedIpsReservedIpRequest)

Update Reserved IP

Update information on a Reserved IP.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ReservedIpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ReservedIpApi apiInstance = new ReservedIpApi(defaultClient);
    String reservedIp = "reservedIp_example"; // String | The [Reserved IP id](#operation/list-reserved-ips).
    PatchReservedIpsReservedIpRequest patchReservedIpsReservedIpRequest = new PatchReservedIpsReservedIpRequest(); // PatchReservedIpsReservedIpRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetReservedIp200Response result = apiInstance.patchReservedIpsReservedIp(reservedIp, patchReservedIpsReservedIpRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReservedIpApi#patchReservedIpsReservedIp");
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
| **reservedIp** | **String**| The [Reserved IP id](#operation/list-reserved-ips). | |
| **patchReservedIpsReservedIpRequest** | [**PatchReservedIpsReservedIpRequest**](PatchReservedIpsReservedIpRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetReservedIp200Response**](GetReservedIp200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

