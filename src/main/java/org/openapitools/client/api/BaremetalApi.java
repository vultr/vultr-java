/*
 * Vultr API
 * # Introduction  The Vultr API v2 is a set of HTTP endpoints that adhere to RESTful design principles and CRUD actions with predictable URIs. It uses standard HTTP response codes, authentication, and verbs. The API has consistent and well-formed JSON requests and responses with cursor-based pagination to simplify list handling. Error messages are descriptive and easy to understand. All functions of the Vultr customer portal are accessible via the API, enabling you to script complex unattended scenarios with any tool fluent in HTTP.  ## Requests  Communicate with the API by making an HTTP request at the correct endpoint. The chosen method determines the action taken.  | Method | Usage | | ------ | ------------- | | DELETE | Use the DELETE method to destroy a resource in your account. If it is not found, the operation will return a 4xx error and an appropriate message. | | GET | To retrieve information about a resource, use the GET method. The data is returned as a JSON object. GET methods are read-only and do not affect any resources. | | PATCH | Some resources support partial modification with PATCH, which modifies specific attributes without updating the entire object representation. | | POST | Issue a POST method to create a new object. Include all needed attributes in the request body encoded as JSON. | | PUT | Use the PUT method to update information about a resource. PUT will set new values on the item without regard to their current values. |  **Rate Limit:** Vultr safeguards the API against bursts of incoming traffic based on the request's IP address to ensure stability for all users. If your application sends more than 30 requests per second, the API may return HTTP status code 429.  ## Response Codes  We use standard HTTP response codes to show the success or failure of requests. Response codes in the 2xx range indicate success, while codes in the 4xx range indicate an error, such as an authorization failure or a malformed request. All 4xx errors will return a JSON response object with an `error` attribute explaining the error. Codes in the 5xx range indicate a server-side problem preventing Vultr from fulfilling your request.  | Response | Description | | ------ | ------------- | | 200 OK | The response contains your requested information. | | 201 Created | Your request was accepted. The resource was created. | | 202 Accepted | Your request was accepted. The resource was created or updated. | | 204 No Content | Your request succeeded, there is no additional information returned. | | 400 Bad Request | Your request was malformed. | | 401 Unauthorized | You did not supply valid authentication credentials. | | 403 Forbidden | You are not allowed to perform that action. | | 404 Not Found | No results were found for your request. | | 429 Too Many Requests | Your request exceeded the API rate limit. | | 500 Internal Server Error | We were unable to perform the request due to server-side problems. |  ## Meta and Pagination  Many API calls will return a `meta` object with paging information.  ### Definitions  | Term | Description | | ------ | ------------- | | **List** | The items returned from the database for your request (not necessarily shown in a single response depending on the **cursor** size). | | **Page** | A subset of the full **list** of items. Choose the size of a **page** with the `per_page` parameter. | | **Total** | The `total` attribute indicates the number of items in the full **list**.| | **Cursor** | Use the `cursor` query parameter to select a next or previous **page**. | | **Next** & **Prev** | Use the `next` and `prev` attributes of the `links` meta object as `cursor` values. |  ### How to use Paging  If your result **list** total exceeds the default **cursor** size (the default depends on the route, but is usually 100 records) or the value defined by the `per_page` query param (when present) the response will be returned to you paginated.  ### Paging Example  > These examples have abbreviated attributes and sample values. Your actual `cursor` values will be encoded alphanumeric strings.  To return a **page** with the first two plans in the List:      curl \"https://api.vultr.com/v2/plans?per_page=2\" \\       -X GET \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  The API returns an object similar to this:      {         \"plans\": [             {                 \"id\": \"vc2-1c-2gb\",                 \"vcpu_count\": 1,                 \"ram\": 2048,                 \"locations\": []             },             {                 \"id\": \"vc2-24c-97gb\",                 \"vcpu_count\": 24,                 \"ram\": 98304,                 \"locations\": []             }         ],         \"meta\": {             \"total\": 19,             \"links\": {                 \"next\": \"WxYzExampleNext\",                 \"prev\": \"WxYzExamplePrev\"             }         }     }  The object contains two plans. The `total` attribute indicates that 19 plans are available in the List. To navigate forward in the **list**, use the `next` value (`WxYzExampleNext` in this example) as your `cursor` query parameter.      curl \"https://api.vultr.com/v2/plans?per_page=2&cursor=WxYzExampleNext\" \\       -X GET       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  Likewise, you can use the example `prev` value `WxYzExamplePrev` to navigate backward.  ## Parameters  You can pass information to the API with three different types of parameters.  ### Path parameters  Some API calls require variable parameters as part of the endpoint path. For example, to retrieve information about a user, supply the `user-id` in the endpoint.      curl \"https://api.vultr.com/v2/users/{user-id}\" \\       -X GET \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  ### Query parameters  Some API calls allow filtering with query parameters. For example, the `/v2/plans` endpoint supports a `type` query parameter. Setting `type=vhf` instructs the API only to return High Frequency Compute plans in the list. You'll find more specifics about valid filters in the endpoint documentation below.      curl \"https://api.vultr.com/v2/plans?type=vhf\" \\       -X GET \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  You can also combine filtering with paging. Use the `per_page` parameter to retreive a subset of vhf plans.      curl \"https://api.vultr.com/v2/plans?type=vhf&per_page=2\" \\       -X GET \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  ### Request Body  PUT, POST, and PATCH methods may include an object in the request body with a content type of **application/json**. The documentation for each endpoint below has more information about the expected object.  ## API Example Conventions  The examples in this documentation use `curl`, a command-line HTTP client, to demonstrate useage. Linux and macOS computers usually have curl installed by default, and it's [available for download](https://curl.se/download.html) on all popular platforms including Windows.  Each example is split across multiple lines with the `\\` character, which is compatible with a `bash` terminal. A typical example looks like this:      curl \"https://api.vultr.com/v2/domains\" \\       -X POST \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\" \\       -H \"Content-Type: application/json\" \\       --data '{         \"domain\" : \"example.com\",         \"ip\" : \"192.0.2.123\"       }'  * The `-X` parameter sets the request method. For consistency, we show the method on all examples, even though it's not explicitly required for GET methods. * The `-H` lines set required HTTP headers. These examples are formatted to expand the VULTR\\_API\\_KEY environment variable for your convenience. * Examples that require a JSON object in the request body pass the required data via the `--data` parameter.  All values in this guide are examples. Do not rely on the OS or Plan IDs listed in this guide; use the appropriate endpoint to retreive values before creating resources. 
 *
 * The version of the OpenAPI document: 2.0
 * Contact: support@vultr.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.openapitools.client.model.AttachBaremetalsVpc2Request;
import org.openapitools.client.model.CreateBaremetal202Response;
import org.openapitools.client.model.CreateBaremetalRequest;
import org.openapitools.client.model.DetachBaremetalVpc2Request;
import org.openapitools.client.model.GetBandwidthBaremetal200Response;
import org.openapitools.client.model.GetBareMetalUserdata200Response;
import org.openapitools.client.model.GetBareMetalVnc200Response;
import org.openapitools.client.model.GetBareMetalsUpgrades200Response;
import org.openapitools.client.model.GetBaremetal200Response;
import org.openapitools.client.model.GetIpv4Baremetal200Response;
import org.openapitools.client.model.GetIpv6Baremetal200Response;
import org.openapitools.client.model.HaltBaremetalsRequest;
import org.openapitools.client.model.ListBaremetalVpc2200Response;
import org.openapitools.client.model.ListBaremetals200Response;
import org.openapitools.client.model.ReinstallBaremetalRequest;
import org.openapitools.client.model.UpdateBaremetalRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaremetalApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public BaremetalApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BaremetalApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for attachBaremetalsVpc2
     * @param baremetalId The [Bare Metal ID](#operation/list-baremetals). (required)
     * @param attachBaremetalsVpc2Request Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call attachBaremetalsVpc2Call(String baremetalId, AttachBaremetalsVpc2Request attachBaremetalsVpc2Request, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = attachBaremetalsVpc2Request;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/vpc2/attach"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call attachBaremetalsVpc2ValidateBeforeCall(String baremetalId, AttachBaremetalsVpc2Request attachBaremetalsVpc2Request, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling attachBaremetalsVpc2(Async)");
        }

        return attachBaremetalsVpc2Call(baremetalId, attachBaremetalsVpc2Request, _callback);

    }

    /**
     * Attach VPC 2.0 Network to Bare Metal Instance
     * Attach a VPC 2.0 Network to a Bare Metal Instance.
     * @param baremetalId The [Bare Metal ID](#operation/list-baremetals). (required)
     * @param attachBaremetalsVpc2Request Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public void attachBaremetalsVpc2(String baremetalId, AttachBaremetalsVpc2Request attachBaremetalsVpc2Request) throws ApiException {
        attachBaremetalsVpc2WithHttpInfo(baremetalId, attachBaremetalsVpc2Request);
    }

    /**
     * Attach VPC 2.0 Network to Bare Metal Instance
     * Attach a VPC 2.0 Network to a Bare Metal Instance.
     * @param baremetalId The [Bare Metal ID](#operation/list-baremetals). (required)
     * @param attachBaremetalsVpc2Request Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> attachBaremetalsVpc2WithHttpInfo(String baremetalId, AttachBaremetalsVpc2Request attachBaremetalsVpc2Request) throws ApiException {
        okhttp3.Call localVarCall = attachBaremetalsVpc2ValidateBeforeCall(baremetalId, attachBaremetalsVpc2Request, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Attach VPC 2.0 Network to Bare Metal Instance (asynchronously)
     * Attach a VPC 2.0 Network to a Bare Metal Instance.
     * @param baremetalId The [Bare Metal ID](#operation/list-baremetals). (required)
     * @param attachBaremetalsVpc2Request Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call attachBaremetalsVpc2Async(String baremetalId, AttachBaremetalsVpc2Request attachBaremetalsVpc2Request, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = attachBaremetalsVpc2ValidateBeforeCall(baremetalId, attachBaremetalsVpc2Request, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for createBaremetal
     * @param createBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createBaremetalCall(CreateBaremetalRequest createBaremetalRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = createBaremetalRequest;

        // create path and map variables
        String localVarPath = "/bare-metals";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createBaremetalValidateBeforeCall(CreateBaremetalRequest createBaremetalRequest, final ApiCallback _callback) throws ApiException {
        return createBaremetalCall(createBaremetalRequest, _callback);

    }

    /**
     * Create Bare Metal Instance
     * Create a new Bare Metal instance in a &#x60;region&#x60; with the desired &#x60;plan&#x60;. Choose one of the following to deploy the instance:  * &#x60;os_id&#x60; * &#x60;snapshot_id&#x60; * &#x60;app_id&#x60; * &#x60;image_id&#x60;  Supply other attributes as desired.
     * @param createBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return CreateBaremetal202Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public CreateBaremetal202Response createBaremetal(CreateBaremetalRequest createBaremetalRequest) throws ApiException {
        ApiResponse<CreateBaremetal202Response> localVarResp = createBaremetalWithHttpInfo(createBaremetalRequest);
        return localVarResp.getData();
    }

    /**
     * Create Bare Metal Instance
     * Create a new Bare Metal instance in a &#x60;region&#x60; with the desired &#x60;plan&#x60;. Choose one of the following to deploy the instance:  * &#x60;os_id&#x60; * &#x60;snapshot_id&#x60; * &#x60;app_id&#x60; * &#x60;image_id&#x60;  Supply other attributes as desired.
     * @param createBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return ApiResponse&lt;CreateBaremetal202Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CreateBaremetal202Response> createBaremetalWithHttpInfo(CreateBaremetalRequest createBaremetalRequest) throws ApiException {
        okhttp3.Call localVarCall = createBaremetalValidateBeforeCall(createBaremetalRequest, null);
        Type localVarReturnType = new TypeToken<CreateBaremetal202Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create Bare Metal Instance (asynchronously)
     * Create a new Bare Metal instance in a &#x60;region&#x60; with the desired &#x60;plan&#x60;. Choose one of the following to deploy the instance:  * &#x60;os_id&#x60; * &#x60;snapshot_id&#x60; * &#x60;app_id&#x60; * &#x60;image_id&#x60;  Supply other attributes as desired.
     * @param createBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createBaremetalAsync(CreateBaremetalRequest createBaremetalRequest, final ApiCallback<CreateBaremetal202Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = createBaremetalValidateBeforeCall(createBaremetalRequest, _callback);
        Type localVarReturnType = new TypeToken<CreateBaremetal202Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteBaremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteBaremetalCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteBaremetalValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling deleteBaremetal(Async)");
        }

        return deleteBaremetalCall(baremetalId, _callback);

    }

    /**
     * Delete Bare Metal
     * Delete a Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public void deleteBaremetal(String baremetalId) throws ApiException {
        deleteBaremetalWithHttpInfo(baremetalId);
    }

    /**
     * Delete Bare Metal
     * Delete a Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> deleteBaremetalWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = deleteBaremetalValidateBeforeCall(baremetalId, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Delete Bare Metal (asynchronously)
     * Delete a Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteBaremetalAsync(String baremetalId, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteBaremetalValidateBeforeCall(baremetalId, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for detachBaremetalVpc2
     * @param baremetalId The [bare-metal ID](#operation/list-baremetals). (required)
     * @param detachBaremetalVpc2Request Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call detachBaremetalVpc2Call(String baremetalId, DetachBaremetalVpc2Request detachBaremetalVpc2Request, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = detachBaremetalVpc2Request;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/vpc2/detach"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call detachBaremetalVpc2ValidateBeforeCall(String baremetalId, DetachBaremetalVpc2Request detachBaremetalVpc2Request, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling detachBaremetalVpc2(Async)");
        }

        return detachBaremetalVpc2Call(baremetalId, detachBaremetalVpc2Request, _callback);

    }

    /**
     * Detach VPC 2.0 Network from Bare Metal Instance
     * Detach a VPC 2.0 Network from an Bare Metal Instance.
     * @param baremetalId The [bare-metal ID](#operation/list-baremetals). (required)
     * @param detachBaremetalVpc2Request Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public void detachBaremetalVpc2(String baremetalId, DetachBaremetalVpc2Request detachBaremetalVpc2Request) throws ApiException {
        detachBaremetalVpc2WithHttpInfo(baremetalId, detachBaremetalVpc2Request);
    }

    /**
     * Detach VPC 2.0 Network from Bare Metal Instance
     * Detach a VPC 2.0 Network from an Bare Metal Instance.
     * @param baremetalId The [bare-metal ID](#operation/list-baremetals). (required)
     * @param detachBaremetalVpc2Request Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> detachBaremetalVpc2WithHttpInfo(String baremetalId, DetachBaremetalVpc2Request detachBaremetalVpc2Request) throws ApiException {
        okhttp3.Call localVarCall = detachBaremetalVpc2ValidateBeforeCall(baremetalId, detachBaremetalVpc2Request, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Detach VPC 2.0 Network from Bare Metal Instance (asynchronously)
     * Detach a VPC 2.0 Network from an Bare Metal Instance.
     * @param baremetalId The [bare-metal ID](#operation/list-baremetals). (required)
     * @param detachBaremetalVpc2Request Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call detachBaremetalVpc2Async(String baremetalId, DetachBaremetalVpc2Request detachBaremetalVpc2Request, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = detachBaremetalVpc2ValidateBeforeCall(baremetalId, detachBaremetalVpc2Request, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for getBandwidthBaremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBandwidthBaremetalCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/bandwidth"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getBandwidthBaremetalValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling getBandwidthBaremetal(Async)");
        }

        return getBandwidthBaremetalCall(baremetalId, _callback);

    }

    /**
     * Bare Metal Bandwidth
     * Get bandwidth information for the Bare Metal instance.&lt;br&gt;&lt;br&gt;The &#x60;bandwidth&#x60; object in a successful response contains objects representing a day in the month. The date is denoted by the nested object keys. Days begin and end in the UTC timezone. Bandwidth utilization data contained within the date object is refreshed periodically. We do not recommend using this endpoint to gather real-time metrics.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return GetBandwidthBaremetal200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public GetBandwidthBaremetal200Response getBandwidthBaremetal(String baremetalId) throws ApiException {
        ApiResponse<GetBandwidthBaremetal200Response> localVarResp = getBandwidthBaremetalWithHttpInfo(baremetalId);
        return localVarResp.getData();
    }

    /**
     * Bare Metal Bandwidth
     * Get bandwidth information for the Bare Metal instance.&lt;br&gt;&lt;br&gt;The &#x60;bandwidth&#x60; object in a successful response contains objects representing a day in the month. The date is denoted by the nested object keys. Days begin and end in the UTC timezone. Bandwidth utilization data contained within the date object is refreshed periodically. We do not recommend using this endpoint to gather real-time metrics.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;GetBandwidthBaremetal200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetBandwidthBaremetal200Response> getBandwidthBaremetalWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = getBandwidthBaremetalValidateBeforeCall(baremetalId, null);
        Type localVarReturnType = new TypeToken<GetBandwidthBaremetal200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Bare Metal Bandwidth (asynchronously)
     * Get bandwidth information for the Bare Metal instance.&lt;br&gt;&lt;br&gt;The &#x60;bandwidth&#x60; object in a successful response contains objects representing a day in the month. The date is denoted by the nested object keys. Days begin and end in the UTC timezone. Bandwidth utilization data contained within the date object is refreshed periodically. We do not recommend using this endpoint to gather real-time metrics.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBandwidthBaremetalAsync(String baremetalId, final ApiCallback<GetBandwidthBaremetal200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBandwidthBaremetalValidateBeforeCall(baremetalId, _callback);
        Type localVarReturnType = new TypeToken<GetBandwidthBaremetal200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getBareMetalUserdata
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBareMetalUserdataCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/user-data"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getBareMetalUserdataValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling getBareMetalUserdata(Async)");
        }

        return getBareMetalUserdataCall(baremetalId, _callback);

    }

    /**
     * Get Bare Metal User Data
     * Get the user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) for a Bare Metal.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return GetBareMetalUserdata200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public GetBareMetalUserdata200Response getBareMetalUserdata(String baremetalId) throws ApiException {
        ApiResponse<GetBareMetalUserdata200Response> localVarResp = getBareMetalUserdataWithHttpInfo(baremetalId);
        return localVarResp.getData();
    }

    /**
     * Get Bare Metal User Data
     * Get the user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) for a Bare Metal.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;GetBareMetalUserdata200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetBareMetalUserdata200Response> getBareMetalUserdataWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = getBareMetalUserdataValidateBeforeCall(baremetalId, null);
        Type localVarReturnType = new TypeToken<GetBareMetalUserdata200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get Bare Metal User Data (asynchronously)
     * Get the user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) for a Bare Metal.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBareMetalUserdataAsync(String baremetalId, final ApiCallback<GetBareMetalUserdata200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBareMetalUserdataValidateBeforeCall(baremetalId, _callback);
        Type localVarReturnType = new TypeToken<GetBareMetalUserdata200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getBareMetalVnc
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBareMetalVncCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/vnc"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getBareMetalVncValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling getBareMetalVnc(Async)");
        }

        return getBareMetalVncCall(baremetalId, _callback);

    }

    /**
     * Get VNC URL for a Bare Metal
     * Get the VNC URL for a Bare Metal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return GetBareMetalVnc200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public GetBareMetalVnc200Response getBareMetalVnc(String baremetalId) throws ApiException {
        ApiResponse<GetBareMetalVnc200Response> localVarResp = getBareMetalVncWithHttpInfo(baremetalId);
        return localVarResp.getData();
    }

    /**
     * Get VNC URL for a Bare Metal
     * Get the VNC URL for a Bare Metal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;GetBareMetalVnc200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetBareMetalVnc200Response> getBareMetalVncWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = getBareMetalVncValidateBeforeCall(baremetalId, null);
        Type localVarReturnType = new TypeToken<GetBareMetalVnc200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get VNC URL for a Bare Metal (asynchronously)
     * Get the VNC URL for a Bare Metal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBareMetalVncAsync(String baremetalId, final ApiCallback<GetBareMetalVnc200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBareMetalVncValidateBeforeCall(baremetalId, _callback);
        Type localVarReturnType = new TypeToken<GetBareMetalVnc200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getBareMetalsUpgrades
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param type Filter upgrade by type:  - all (applications, plans) - applications - os (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBareMetalsUpgradesCall(String baremetalId, String type, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/upgrades"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (type != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("type", type));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getBareMetalsUpgradesValidateBeforeCall(String baremetalId, String type, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling getBareMetalsUpgrades(Async)");
        }

        return getBareMetalsUpgradesCall(baremetalId, type, _callback);

    }

    /**
     * Get Available Bare Metal Upgrades
     * Get available upgrades for a Bare Metal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param type Filter upgrade by type:  - all (applications, plans) - applications - os (optional)
     * @return GetBareMetalsUpgrades200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public GetBareMetalsUpgrades200Response getBareMetalsUpgrades(String baremetalId, String type) throws ApiException {
        ApiResponse<GetBareMetalsUpgrades200Response> localVarResp = getBareMetalsUpgradesWithHttpInfo(baremetalId, type);
        return localVarResp.getData();
    }

    /**
     * Get Available Bare Metal Upgrades
     * Get available upgrades for a Bare Metal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param type Filter upgrade by type:  - all (applications, plans) - applications - os (optional)
     * @return ApiResponse&lt;GetBareMetalsUpgrades200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetBareMetalsUpgrades200Response> getBareMetalsUpgradesWithHttpInfo(String baremetalId, String type) throws ApiException {
        okhttp3.Call localVarCall = getBareMetalsUpgradesValidateBeforeCall(baremetalId, type, null);
        Type localVarReturnType = new TypeToken<GetBareMetalsUpgrades200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get Available Bare Metal Upgrades (asynchronously)
     * Get available upgrades for a Bare Metal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param type Filter upgrade by type:  - all (applications, plans) - applications - os (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBareMetalsUpgradesAsync(String baremetalId, String type, final ApiCallback<GetBareMetalsUpgrades200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBareMetalsUpgradesValidateBeforeCall(baremetalId, type, _callback);
        Type localVarReturnType = new TypeToken<GetBareMetalsUpgrades200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getBaremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBaremetalCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getBaremetalValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling getBaremetal(Async)");
        }

        return getBaremetalCall(baremetalId, _callback);

    }

    /**
     * Get Bare Metal
     * Get information for a Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return GetBaremetal200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public GetBaremetal200Response getBaremetal(String baremetalId) throws ApiException {
        ApiResponse<GetBaremetal200Response> localVarResp = getBaremetalWithHttpInfo(baremetalId);
        return localVarResp.getData();
    }

    /**
     * Get Bare Metal
     * Get information for a Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;GetBaremetal200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetBaremetal200Response> getBaremetalWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = getBaremetalValidateBeforeCall(baremetalId, null);
        Type localVarReturnType = new TypeToken<GetBaremetal200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get Bare Metal (asynchronously)
     * Get information for a Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBaremetalAsync(String baremetalId, final ApiCallback<GetBaremetal200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBaremetalValidateBeforeCall(baremetalId, _callback);
        Type localVarReturnType = new TypeToken<GetBaremetal200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getIpv4Baremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getIpv4BaremetalCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/ipv4"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getIpv4BaremetalValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling getIpv4Baremetal(Async)");
        }

        return getIpv4BaremetalCall(baremetalId, _callback);

    }

    /**
     * Bare Metal IPv4 Addresses
     * Get the IPv4 information for the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return GetIpv4Baremetal200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public GetIpv4Baremetal200Response getIpv4Baremetal(String baremetalId) throws ApiException {
        ApiResponse<GetIpv4Baremetal200Response> localVarResp = getIpv4BaremetalWithHttpInfo(baremetalId);
        return localVarResp.getData();
    }

    /**
     * Bare Metal IPv4 Addresses
     * Get the IPv4 information for the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;GetIpv4Baremetal200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetIpv4Baremetal200Response> getIpv4BaremetalWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = getIpv4BaremetalValidateBeforeCall(baremetalId, null);
        Type localVarReturnType = new TypeToken<GetIpv4Baremetal200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Bare Metal IPv4 Addresses (asynchronously)
     * Get the IPv4 information for the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getIpv4BaremetalAsync(String baremetalId, final ApiCallback<GetIpv4Baremetal200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = getIpv4BaremetalValidateBeforeCall(baremetalId, _callback);
        Type localVarReturnType = new TypeToken<GetIpv4Baremetal200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getIpv6Baremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getIpv6BaremetalCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/ipv6"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getIpv6BaremetalValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling getIpv6Baremetal(Async)");
        }

        return getIpv6BaremetalCall(baremetalId, _callback);

    }

    /**
     * Bare Metal IPv6 Addresses
     * Get the IPv6 information for the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return GetIpv6Baremetal200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public GetIpv6Baremetal200Response getIpv6Baremetal(String baremetalId) throws ApiException {
        ApiResponse<GetIpv6Baremetal200Response> localVarResp = getIpv6BaremetalWithHttpInfo(baremetalId);
        return localVarResp.getData();
    }

    /**
     * Bare Metal IPv6 Addresses
     * Get the IPv6 information for the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;GetIpv6Baremetal200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetIpv6Baremetal200Response> getIpv6BaremetalWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = getIpv6BaremetalValidateBeforeCall(baremetalId, null);
        Type localVarReturnType = new TypeToken<GetIpv6Baremetal200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Bare Metal IPv6 Addresses (asynchronously)
     * Get the IPv6 information for the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getIpv6BaremetalAsync(String baremetalId, final ApiCallback<GetIpv6Baremetal200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = getIpv6BaremetalValidateBeforeCall(baremetalId, _callback);
        Type localVarReturnType = new TypeToken<GetIpv6Baremetal200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for haltBaremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call haltBaremetalCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/halt"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call haltBaremetalValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling haltBaremetal(Async)");
        }

        return haltBaremetalCall(baremetalId, _callback);

    }

    /**
     * Halt Bare Metal
     * Halt the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public void haltBaremetal(String baremetalId) throws ApiException {
        haltBaremetalWithHttpInfo(baremetalId);
    }

    /**
     * Halt Bare Metal
     * Halt the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> haltBaremetalWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = haltBaremetalValidateBeforeCall(baremetalId, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Halt Bare Metal (asynchronously)
     * Halt the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call haltBaremetalAsync(String baremetalId, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = haltBaremetalValidateBeforeCall(baremetalId, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for haltBaremetals
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call haltBaremetalsCall(HaltBaremetalsRequest haltBaremetalsRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = haltBaremetalsRequest;

        // create path and map variables
        String localVarPath = "/bare-metals/halt";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call haltBaremetalsValidateBeforeCall(HaltBaremetalsRequest haltBaremetalsRequest, final ApiCallback _callback) throws ApiException {
        return haltBaremetalsCall(haltBaremetalsRequest, _callback);

    }

    /**
     * Halt Bare Metals
     * Halt Bare Metals.
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public void haltBaremetals(HaltBaremetalsRequest haltBaremetalsRequest) throws ApiException {
        haltBaremetalsWithHttpInfo(haltBaremetalsRequest);
    }

    /**
     * Halt Bare Metals
     * Halt Bare Metals.
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> haltBaremetalsWithHttpInfo(HaltBaremetalsRequest haltBaremetalsRequest) throws ApiException {
        okhttp3.Call localVarCall = haltBaremetalsValidateBeforeCall(haltBaremetalsRequest, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Halt Bare Metals (asynchronously)
     * Halt Bare Metals.
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call haltBaremetalsAsync(HaltBaremetalsRequest haltBaremetalsRequest, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = haltBaremetalsValidateBeforeCall(haltBaremetalsRequest, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for listBaremetalVpc2
     * @param baremetalId The [Bare Metal ID](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listBaremetalVpc2Call(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/vpc2"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listBaremetalVpc2ValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling listBaremetalVpc2(Async)");
        }

        return listBaremetalVpc2Call(baremetalId, _callback);

    }

    /**
     * List Bare Metal Instance VPC 2.0 Networks
     * List the VPC 2.0 networks for a Bare Metal Instance.
     * @param baremetalId The [Bare Metal ID](#operation/list-baremetals). (required)
     * @return ListBaremetalVpc2200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ListBaremetalVpc2200Response listBaremetalVpc2(String baremetalId) throws ApiException {
        ApiResponse<ListBaremetalVpc2200Response> localVarResp = listBaremetalVpc2WithHttpInfo(baremetalId);
        return localVarResp.getData();
    }

    /**
     * List Bare Metal Instance VPC 2.0 Networks
     * List the VPC 2.0 networks for a Bare Metal Instance.
     * @param baremetalId The [Bare Metal ID](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;ListBaremetalVpc2200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ListBaremetalVpc2200Response> listBaremetalVpc2WithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = listBaremetalVpc2ValidateBeforeCall(baremetalId, null);
        Type localVarReturnType = new TypeToken<ListBaremetalVpc2200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List Bare Metal Instance VPC 2.0 Networks (asynchronously)
     * List the VPC 2.0 networks for a Bare Metal Instance.
     * @param baremetalId The [Bare Metal ID](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listBaremetalVpc2Async(String baremetalId, final ApiCallback<ListBaremetalVpc2200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = listBaremetalVpc2ValidateBeforeCall(baremetalId, _callback);
        Type localVarReturnType = new TypeToken<ListBaremetalVpc2200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listBaremetals
     * @param perPage Number of items requested per page. Default is 100 and Max is 500.  (optional)
     * @param cursor Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listBaremetalsCall(Integer perPage, String cursor, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (perPage != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("per_page", perPage));
        }

        if (cursor != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("cursor", cursor));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listBaremetalsValidateBeforeCall(Integer perPage, String cursor, final ApiCallback _callback) throws ApiException {
        return listBaremetalsCall(perPage, cursor, _callback);

    }

    /**
     * List Bare Metal Instances
     * List all Bare Metal instances in your account.
     * @param perPage Number of items requested per page. Default is 100 and Max is 500.  (optional)
     * @param cursor Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). (optional)
     * @return ListBaremetals200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ListBaremetals200Response listBaremetals(Integer perPage, String cursor) throws ApiException {
        ApiResponse<ListBaremetals200Response> localVarResp = listBaremetalsWithHttpInfo(perPage, cursor);
        return localVarResp.getData();
    }

    /**
     * List Bare Metal Instances
     * List all Bare Metal instances in your account.
     * @param perPage Number of items requested per page. Default is 100 and Max is 500.  (optional)
     * @param cursor Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). (optional)
     * @return ApiResponse&lt;ListBaremetals200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ListBaremetals200Response> listBaremetalsWithHttpInfo(Integer perPage, String cursor) throws ApiException {
        okhttp3.Call localVarCall = listBaremetalsValidateBeforeCall(perPage, cursor, null);
        Type localVarReturnType = new TypeToken<ListBaremetals200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List Bare Metal Instances (asynchronously)
     * List all Bare Metal instances in your account.
     * @param perPage Number of items requested per page. Default is 100 and Max is 500.  (optional)
     * @param cursor Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listBaremetalsAsync(Integer perPage, String cursor, final ApiCallback<ListBaremetals200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = listBaremetalsValidateBeforeCall(perPage, cursor, _callback);
        Type localVarReturnType = new TypeToken<ListBaremetals200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for rebootBareMetals
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call rebootBareMetalsCall(HaltBaremetalsRequest haltBaremetalsRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = haltBaremetalsRequest;

        // create path and map variables
        String localVarPath = "/bare-metals/reboot";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call rebootBareMetalsValidateBeforeCall(HaltBaremetalsRequest haltBaremetalsRequest, final ApiCallback _callback) throws ApiException {
        return rebootBareMetalsCall(haltBaremetalsRequest, _callback);

    }

    /**
     * Reboot Bare Metals
     * Reboot Bare Metals.
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public void rebootBareMetals(HaltBaremetalsRequest haltBaremetalsRequest) throws ApiException {
        rebootBareMetalsWithHttpInfo(haltBaremetalsRequest);
    }

    /**
     * Reboot Bare Metals
     * Reboot Bare Metals.
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> rebootBareMetalsWithHttpInfo(HaltBaremetalsRequest haltBaremetalsRequest) throws ApiException {
        okhttp3.Call localVarCall = rebootBareMetalsValidateBeforeCall(haltBaremetalsRequest, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Reboot Bare Metals (asynchronously)
     * Reboot Bare Metals.
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call rebootBareMetalsAsync(HaltBaremetalsRequest haltBaremetalsRequest, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = rebootBareMetalsValidateBeforeCall(haltBaremetalsRequest, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for rebootBaremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call rebootBaremetalCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/reboot"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call rebootBaremetalValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling rebootBaremetal(Async)");
        }

        return rebootBaremetalCall(baremetalId, _callback);

    }

    /**
     * Reboot Bare Metal
     * Reboot the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public void rebootBaremetal(String baremetalId) throws ApiException {
        rebootBaremetalWithHttpInfo(baremetalId);
    }

    /**
     * Reboot Bare Metal
     * Reboot the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> rebootBaremetalWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = rebootBaremetalValidateBeforeCall(baremetalId, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Reboot Bare Metal (asynchronously)
     * Reboot the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call rebootBaremetalAsync(String baremetalId, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = rebootBaremetalValidateBeforeCall(baremetalId, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for reinstallBaremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param reinstallBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call reinstallBaremetalCall(String baremetalId, ReinstallBaremetalRequest reinstallBaremetalRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = reinstallBaremetalRequest;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/reinstall"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call reinstallBaremetalValidateBeforeCall(String baremetalId, ReinstallBaremetalRequest reinstallBaremetalRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling reinstallBaremetal(Async)");
        }

        return reinstallBaremetalCall(baremetalId, reinstallBaremetalRequest, _callback);

    }

    /**
     * Reinstall Bare Metal
     * Reinstall the Bare Metal instance using an optional &#x60;hostname&#x60;.   **Note:** This action may take some time to complete.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param reinstallBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return GetBaremetal200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public GetBaremetal200Response reinstallBaremetal(String baremetalId, ReinstallBaremetalRequest reinstallBaremetalRequest) throws ApiException {
        ApiResponse<GetBaremetal200Response> localVarResp = reinstallBaremetalWithHttpInfo(baremetalId, reinstallBaremetalRequest);
        return localVarResp.getData();
    }

    /**
     * Reinstall Bare Metal
     * Reinstall the Bare Metal instance using an optional &#x60;hostname&#x60;.   **Note:** This action may take some time to complete.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param reinstallBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return ApiResponse&lt;GetBaremetal200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetBaremetal200Response> reinstallBaremetalWithHttpInfo(String baremetalId, ReinstallBaremetalRequest reinstallBaremetalRequest) throws ApiException {
        okhttp3.Call localVarCall = reinstallBaremetalValidateBeforeCall(baremetalId, reinstallBaremetalRequest, null);
        Type localVarReturnType = new TypeToken<GetBaremetal200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Reinstall Bare Metal (asynchronously)
     * Reinstall the Bare Metal instance using an optional &#x60;hostname&#x60;.   **Note:** This action may take some time to complete.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param reinstallBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call reinstallBaremetalAsync(String baremetalId, ReinstallBaremetalRequest reinstallBaremetalRequest, final ApiCallback<GetBaremetal200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = reinstallBaremetalValidateBeforeCall(baremetalId, reinstallBaremetalRequest, _callback);
        Type localVarReturnType = new TypeToken<GetBaremetal200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for startBareMetals
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call startBareMetalsCall(HaltBaremetalsRequest haltBaremetalsRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = haltBaremetalsRequest;

        // create path and map variables
        String localVarPath = "/bare-metals/start";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call startBareMetalsValidateBeforeCall(HaltBaremetalsRequest haltBaremetalsRequest, final ApiCallback _callback) throws ApiException {
        return startBareMetalsCall(haltBaremetalsRequest, _callback);

    }

    /**
     * Start Bare Metals
     * Start Bare Metals.
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public void startBareMetals(HaltBaremetalsRequest haltBaremetalsRequest) throws ApiException {
        startBareMetalsWithHttpInfo(haltBaremetalsRequest);
    }

    /**
     * Start Bare Metals
     * Start Bare Metals.
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> startBareMetalsWithHttpInfo(HaltBaremetalsRequest haltBaremetalsRequest) throws ApiException {
        okhttp3.Call localVarCall = startBareMetalsValidateBeforeCall(haltBaremetalsRequest, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Start Bare Metals (asynchronously)
     * Start Bare Metals.
     * @param haltBaremetalsRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call startBareMetalsAsync(HaltBaremetalsRequest haltBaremetalsRequest, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = startBareMetalsValidateBeforeCall(haltBaremetalsRequest, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for startBaremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call startBaremetalCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}/start"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call startBaremetalValidateBeforeCall(String baremetalId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling startBaremetal(Async)");
        }

        return startBaremetalCall(baremetalId, _callback);

    }

    /**
     * Start Bare Metal
     * Start the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public void startBaremetal(String baremetalId) throws ApiException {
        startBaremetalWithHttpInfo(baremetalId);
    }

    /**
     * Start Bare Metal
     * Start the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> startBaremetalWithHttpInfo(String baremetalId) throws ApiException {
        okhttp3.Call localVarCall = startBaremetalValidateBeforeCall(baremetalId, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Start Bare Metal (asynchronously)
     * Start the Bare Metal instance.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call startBaremetalAsync(String baremetalId, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = startBaremetalValidateBeforeCall(baremetalId, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateBaremetal
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param updateBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateBaremetalCall(String baremetalId, UpdateBaremetalRequest updateBaremetalRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = updateBaremetalRequest;

        // create path and map variables
        String localVarPath = "/bare-metals/{baremetal-id}"
            .replace("{" + "baremetal-id" + "}", localVarApiClient.escapeString(baremetalId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "API Key" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateBaremetalValidateBeforeCall(String baremetalId, UpdateBaremetalRequest updateBaremetalRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'baremetalId' is set
        if (baremetalId == null) {
            throw new ApiException("Missing the required parameter 'baremetalId' when calling updateBaremetal(Async)");
        }

        return updateBaremetalCall(baremetalId, updateBaremetalRequest, _callback);

    }

    /**
     * Update Bare Metal
     * Update a Bare Metal instance. All attributes are optional. If not set, the attributes will retain their original values.  **Note:** Changing &#x60;os_id&#x60;, &#x60;app_id&#x60; or &#x60;image_id&#x60; may take a few extra seconds to complete.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param updateBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return GetBaremetal200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public GetBaremetal200Response updateBaremetal(String baremetalId, UpdateBaremetalRequest updateBaremetalRequest) throws ApiException {
        ApiResponse<GetBaremetal200Response> localVarResp = updateBaremetalWithHttpInfo(baremetalId, updateBaremetalRequest);
        return localVarResp.getData();
    }

    /**
     * Update Bare Metal
     * Update a Bare Metal instance. All attributes are optional. If not set, the attributes will retain their original values.  **Note:** Changing &#x60;os_id&#x60;, &#x60;app_id&#x60; or &#x60;image_id&#x60; may take a few extra seconds to complete.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param updateBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @return ApiResponse&lt;GetBaremetal200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetBaremetal200Response> updateBaremetalWithHttpInfo(String baremetalId, UpdateBaremetalRequest updateBaremetalRequest) throws ApiException {
        okhttp3.Call localVarCall = updateBaremetalValidateBeforeCall(baremetalId, updateBaremetalRequest, null);
        Type localVarReturnType = new TypeToken<GetBaremetal200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update Bare Metal (asynchronously)
     * Update a Bare Metal instance. All attributes are optional. If not set, the attributes will retain their original values.  **Note:** Changing &#x60;os_id&#x60;, &#x60;app_id&#x60; or &#x60;image_id&#x60; may take a few extra seconds to complete.
     * @param baremetalId The [Bare Metal id](#operation/list-baremetals). (required)
     * @param updateBaremetalRequest Include a JSON object in the request body with a content type of **application/json**. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accepted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateBaremetalAsync(String baremetalId, UpdateBaremetalRequest updateBaremetalRequest, final ApiCallback<GetBaremetal200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateBaremetalValidateBeforeCall(baremetalId, updateBaremetalRequest, _callback);
        Type localVarReturnType = new TypeToken<GetBaremetal200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
