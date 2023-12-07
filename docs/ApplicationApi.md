# ApplicationApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listApplications**](ApplicationApi.md#listApplications) | **GET** /applications | List Applications |


<a id="listApplications"></a>
# **listApplications**
> ListApplications200Response listApplications(type, perPage, cursor)

List Applications

Get a list of all available Applications.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ApplicationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");

    ApplicationApi apiInstance = new ApplicationApi(defaultClient);
    String type = "type_example"; // String | Filter the results by type.  |   | Type | Description | | - | ------ | ------------- | |   | all | All available application types | |   | marketplace | Marketplace applications | |   | one-click | Vultr One-Click applications |
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListApplications200Response result = apiInstance.listApplications(type, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApplicationApi#listApplications");
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
| **type** | **String**| Filter the results by type.  |   | Type | Description | | - | ------ | ------------- | |   | all | All available application types | |   | marketplace | Marketplace applications | |   | one-click | Vultr One-Click applications | | [optional] |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListApplications200Response**](ListApplications200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

