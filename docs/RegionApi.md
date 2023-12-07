# RegionApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listAvailablePlansRegion**](RegionApi.md#listAvailablePlansRegion) | **GET** /regions/{region-id}/availability | List available plans in region |
| [**listRegions**](RegionApi.md#listRegions) | **GET** /regions | List Regions |


<a id="listAvailablePlansRegion"></a>
# **listAvailablePlansRegion**
> ListAvailablePlansRegion200Response listAvailablePlansRegion(regionId, type)

List available plans in region

Get a list of the available plans in Region &#x60;region-id&#x60;. Not all plans are available in all regions.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.RegionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");

    RegionApi apiInstance = new RegionApi(defaultClient);
    String regionId = "regionId_example"; // String | The [Region id](#operation/list-regions).
    String type = "type_example"; // String | Filter the results by type.  | **Type** | **Description** | |----------|-----------------| | all | All available types | | vc2 | Cloud Compute | | vdc | Dedicated Cloud | | vhf | High Frequency Compute | | vhp | High Performance | | voc | All Optimized Cloud types | | voc-g | General Purpose Optimized Cloud | | voc-c | CPU Optimized Cloud | | voc-m | Memory Optimized Cloud | | voc-s | Storage Optimized Cloud | | vbm | Bare Metal | | vcg | Cloud GPU | 
    try {
      ListAvailablePlansRegion200Response result = apiInstance.listAvailablePlansRegion(regionId, type);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RegionApi#listAvailablePlansRegion");
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
| **regionId** | **String**| The [Region id](#operation/list-regions). | |
| **type** | **String**| Filter the results by type.  | **Type** | **Description** | |----------|-----------------| | all | All available types | | vc2 | Cloud Compute | | vdc | Dedicated Cloud | | vhf | High Frequency Compute | | vhp | High Performance | | voc | All Optimized Cloud types | | voc-g | General Purpose Optimized Cloud | | voc-c | CPU Optimized Cloud | | voc-m | Memory Optimized Cloud | | voc-s | Storage Optimized Cloud | | vbm | Bare Metal | | vcg | Cloud GPU |  | [optional] |

### Return type

[**ListAvailablePlansRegion200Response**](ListAvailablePlansRegion200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="listRegions"></a>
# **listRegions**
> ListRegions200Response listRegions(perPage, cursor)

List Regions

List all Regions at Vultr.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.RegionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");

    RegionApi apiInstance = new RegionApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListRegions200Response result = apiInstance.listRegions(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RegionApi#listRegions");
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

[**ListRegions200Response**](ListRegions200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

