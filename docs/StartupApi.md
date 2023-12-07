# StartupApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createStartupScript**](StartupApi.md#createStartupScript) | **POST** /startup-scripts | Create Startup Script |
| [**deleteStartupScript**](StartupApi.md#deleteStartupScript) | **DELETE** /startup-scripts/{startup-id} | Delete Startup Script |
| [**getStartupScript**](StartupApi.md#getStartupScript) | **GET** /startup-scripts/{startup-id} | Get Startup Script |
| [**listStartupScripts**](StartupApi.md#listStartupScripts) | **GET** /startup-scripts | List Startup Scripts |
| [**updateStartupScript**](StartupApi.md#updateStartupScript) | **PATCH** /startup-scripts/{startup-id} | Update Startup Script |


<a id="createStartupScript"></a>
# **createStartupScript**
> GetStartupScript200Response createStartupScript(createStartupScriptRequest)

Create Startup Script

Create a new Startup Script. The &#x60;name&#x60; and &#x60;script&#x60; attributes are required, and scripts are base-64 encoded.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StartupApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    StartupApi apiInstance = new StartupApi(defaultClient);
    CreateStartupScriptRequest createStartupScriptRequest = new CreateStartupScriptRequest(); // CreateStartupScriptRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetStartupScript200Response result = apiInstance.createStartupScript(createStartupScriptRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StartupApi#createStartupScript");
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
| **createStartupScriptRequest** | [**CreateStartupScriptRequest**](CreateStartupScriptRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetStartupScript200Response**](GetStartupScript200Response.md)

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

<a id="deleteStartupScript"></a>
# **deleteStartupScript**
> deleteStartupScript(startupId)

Delete Startup Script

Delete a Startup Script.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StartupApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    StartupApi apiInstance = new StartupApi(defaultClient);
    String startupId = "startupId_example"; // String | The [Startup Script id](#operation/list-startup-scripts).
    try {
      apiInstance.deleteStartupScript(startupId);
    } catch (ApiException e) {
      System.err.println("Exception when calling StartupApi#deleteStartupScript");
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
| **startupId** | **String**| The [Startup Script id](#operation/list-startup-scripts). | |

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

<a id="getStartupScript"></a>
# **getStartupScript**
> GetStartupScript200Response getStartupScript(startupId)

Get Startup Script

Get information for a Startup Script.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StartupApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    StartupApi apiInstance = new StartupApi(defaultClient);
    String startupId = "startupId_example"; // String | The [Startup Script id](#operation/list-startup-scripts).
    try {
      GetStartupScript200Response result = apiInstance.getStartupScript(startupId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StartupApi#getStartupScript");
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
| **startupId** | **String**| The [Startup Script id](#operation/list-startup-scripts). | |

### Return type

[**GetStartupScript200Response**](GetStartupScript200Response.md)

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

<a id="listStartupScripts"></a>
# **listStartupScripts**
> ListStartupScripts200Response listStartupScripts(perPage, cursor)

List Startup Scripts

Get a list of all Startup Scripts.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StartupApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    StartupApi apiInstance = new StartupApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListStartupScripts200Response result = apiInstance.listStartupScripts(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StartupApi#listStartupScripts");
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

[**ListStartupScripts200Response**](ListStartupScripts200Response.md)

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

<a id="updateStartupScript"></a>
# **updateStartupScript**
> updateStartupScript(startupId, updateStartupScriptRequest)

Update Startup Script

Update a Startup Script. The attributes &#x60;name&#x60; and &#x60;script&#x60; are optional. If not set, the attributes will retain their original values. The &#x60;script&#x60; attribute is base-64 encoded. New deployments will use the updated script, but this action does not update previously deployed instances.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StartupApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    StartupApi apiInstance = new StartupApi(defaultClient);
    String startupId = "startupId_example"; // String | The [Startup Script id](#operation/list-startup-scripts).
    UpdateStartupScriptRequest updateStartupScriptRequest = new UpdateStartupScriptRequest(); // UpdateStartupScriptRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateStartupScript(startupId, updateStartupScriptRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling StartupApi#updateStartupScript");
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
| **startupId** | **String**| The [Startup Script id](#operation/list-startup-scripts). | |
| **updateStartupScriptRequest** | [**UpdateStartupScriptRequest**](UpdateStartupScriptRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

