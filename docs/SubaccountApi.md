# SubaccountApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSubaccount**](SubaccountApi.md#createSubaccount) | **POST** /subaccounts | Create Sub-Account |
| [**listSubaccounts**](SubaccountApi.md#listSubaccounts) | **GET** /subaccounts | List Sub-Accounts |


<a id="createSubaccount"></a>
# **createSubaccount**
> CreateSubaccount201Response createSubaccount(createSubaccountRequest)

Create Sub-Account

Create a new subaccount.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SubaccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SubaccountApi apiInstance = new SubaccountApi(defaultClient);
    CreateSubaccountRequest createSubaccountRequest = new CreateSubaccountRequest(); // CreateSubaccountRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateSubaccount201Response result = apiInstance.createSubaccount(createSubaccountRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SubaccountApi#createSubaccount");
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
| **createSubaccountRequest** | [**CreateSubaccountRequest**](CreateSubaccountRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateSubaccount201Response**](CreateSubaccount201Response.md)

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

<a id="listSubaccounts"></a>
# **listSubaccounts**
> ListSubaccounts200Response listSubaccounts(perPage, cursor)

List Sub-Accounts

Get information about all sub-accounts for your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SubaccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SubaccountApi apiInstance = new SubaccountApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListSubaccounts200Response result = apiInstance.listSubaccounts(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SubaccountApi#listSubaccounts");
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

[**ListSubaccounts200Response**](ListSubaccounts200Response.md)

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

