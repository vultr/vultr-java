# OsApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listOs**](OsApi.md#listOs) | **GET** /os | List OS |


<a id="listOs"></a>
# **listOs**
> ListOs200Response listOs(perPage, cursor)

List OS

List the OS images available for installation at Vultr.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");

    OsApi apiInstance = new OsApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500. 
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListOs200Response result = apiInstance.listOs(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OsApi#listOs");
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
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500.  | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListOs200Response**](ListOs200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

