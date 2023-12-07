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


import org.openapitools.client.model.CreateRegistryRequest;
import org.openapitools.client.model.ListRegistries200Response;
import org.openapitools.client.model.ListRegistryPlans200Response;
import org.openapitools.client.model.ListRegistryRegions200Response;
import org.openapitools.client.model.ListRegistryRepositories200Response;
import org.openapitools.client.model.Registry;
import org.openapitools.client.model.RegistryDockerCredentials;
import org.openapitools.client.model.RegistryKubernetesDockerCredentials;
import org.openapitools.client.model.RegistryRepository;
import org.openapitools.client.model.UpdateRegistryRequest;
import org.openapitools.client.model.UpdateRepositoryRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainerRegistryApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ContainerRegistryApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ContainerRegistryApi(ApiClient apiClient) {
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
     * Build call for createRegistry
     * @param createRegistryRequest  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createRegistryCall(CreateRegistryRequest createRegistryRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = createRegistryRequest;

        // create path and map variables
        String localVarPath = "/registry";

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
    private okhttp3.Call createRegistryValidateBeforeCall(CreateRegistryRequest createRegistryRequest, final ApiCallback _callback) throws ApiException {
        return createRegistryCall(createRegistryRequest, _callback);

    }

    /**
     * Create Container Registry
     * Create a new Container Registry Subscription
     * @param createRegistryRequest  (optional)
     * @return Registry
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public Registry createRegistry(CreateRegistryRequest createRegistryRequest) throws ApiException {
        ApiResponse<Registry> localVarResp = createRegistryWithHttpInfo(createRegistryRequest);
        return localVarResp.getData();
    }

    /**
     * Create Container Registry
     * Create a new Container Registry Subscription
     * @param createRegistryRequest  (optional)
     * @return ApiResponse&lt;Registry&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Registry> createRegistryWithHttpInfo(CreateRegistryRequest createRegistryRequest) throws ApiException {
        okhttp3.Call localVarCall = createRegistryValidateBeforeCall(createRegistryRequest, null);
        Type localVarReturnType = new TypeToken<Registry>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create Container Registry (asynchronously)
     * Create a new Container Registry Subscription
     * @param createRegistryRequest  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createRegistryAsync(CreateRegistryRequest createRegistryRequest, final ApiCallback<Registry> _callback) throws ApiException {

        okhttp3.Call localVarCall = createRegistryValidateBeforeCall(createRegistryRequest, _callback);
        Type localVarReturnType = new TypeToken<Registry>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for createRegistryDockerCredentials
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param expirySeconds The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 (optional)
     * @param readWrite Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createRegistryDockerCredentialsCall(String registryId, Integer expirySeconds, Boolean readWrite, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registry/{registry-id}/docker-credentials?expiry_seconds=0&read_write=false"
            .replace("{" + "registry-id" + "}", localVarApiClient.escapeString(registryId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (expirySeconds != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("expiry_seconds", expirySeconds));
        }

        if (readWrite != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("read_write", readWrite));
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
        return localVarApiClient.buildCall(basePath, localVarPath, "OPTIONS", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createRegistryDockerCredentialsValidateBeforeCall(String registryId, Integer expirySeconds, Boolean readWrite, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'registryId' is set
        if (registryId == null) {
            throw new ApiException("Missing the required parameter 'registryId' when calling createRegistryDockerCredentials(Async)");
        }

        return createRegistryDockerCredentialsCall(registryId, expirySeconds, readWrite, _callback);

    }

    /**
     * Create Docker Credentials
     * Create a fresh set of Docker Credentials for this Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param expirySeconds The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 (optional)
     * @param readWrite Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. (optional)
     * @return RegistryDockerCredentials
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public RegistryDockerCredentials createRegistryDockerCredentials(String registryId, Integer expirySeconds, Boolean readWrite) throws ApiException {
        ApiResponse<RegistryDockerCredentials> localVarResp = createRegistryDockerCredentialsWithHttpInfo(registryId, expirySeconds, readWrite);
        return localVarResp.getData();
    }

    /**
     * Create Docker Credentials
     * Create a fresh set of Docker Credentials for this Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param expirySeconds The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 (optional)
     * @param readWrite Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. (optional)
     * @return ApiResponse&lt;RegistryDockerCredentials&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<RegistryDockerCredentials> createRegistryDockerCredentialsWithHttpInfo(String registryId, Integer expirySeconds, Boolean readWrite) throws ApiException {
        okhttp3.Call localVarCall = createRegistryDockerCredentialsValidateBeforeCall(registryId, expirySeconds, readWrite, null);
        Type localVarReturnType = new TypeToken<RegistryDockerCredentials>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create Docker Credentials (asynchronously)
     * Create a fresh set of Docker Credentials for this Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param expirySeconds The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 (optional)
     * @param readWrite Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createRegistryDockerCredentialsAsync(String registryId, Integer expirySeconds, Boolean readWrite, final ApiCallback<RegistryDockerCredentials> _callback) throws ApiException {

        okhttp3.Call localVarCall = createRegistryDockerCredentialsValidateBeforeCall(registryId, expirySeconds, readWrite, _callback);
        Type localVarReturnType = new TypeToken<RegistryDockerCredentials>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for createRegistryKubernetesDockerCredentials
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param expirySeconds The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 (optional)
     * @param readWrite Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. (optional)
     * @param base64Encode Whether this YAML will be returned in a base64 encoded string for ease of downloading. If true, the response will be a base64 encoded string. Default is false. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createRegistryKubernetesDockerCredentialsCall(String registryId, Integer expirySeconds, Boolean readWrite, Boolean base64Encode, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registry/{registry-id}/docker-credentials/kubernetes?expiry_seconds=0&read_write=false&base64_encode=false"
            .replace("{" + "registry-id" + "}", localVarApiClient.escapeString(registryId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (expirySeconds != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("expiry_seconds", expirySeconds));
        }

        if (readWrite != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("read_write", readWrite));
        }

        if (base64Encode != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("base64_encode", base64Encode));
        }

        final String[] localVarAccepts = {
            "application/yaml"
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
        return localVarApiClient.buildCall(basePath, localVarPath, "OPTIONS", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createRegistryKubernetesDockerCredentialsValidateBeforeCall(String registryId, Integer expirySeconds, Boolean readWrite, Boolean base64Encode, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'registryId' is set
        if (registryId == null) {
            throw new ApiException("Missing the required parameter 'registryId' when calling createRegistryKubernetesDockerCredentials(Async)");
        }

        return createRegistryKubernetesDockerCredentialsCall(registryId, expirySeconds, readWrite, base64Encode, _callback);

    }

    /**
     * Create Docker Credentials for Kubernetes
     * Create a fresh set of Docker Credentials for this Container Registry Subscription and return them in a Kubernetes friendly YAML format
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param expirySeconds The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 (optional)
     * @param readWrite Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. (optional)
     * @param base64Encode Whether this YAML will be returned in a base64 encoded string for ease of downloading. If true, the response will be a base64 encoded string. Default is false. (optional)
     * @return RegistryKubernetesDockerCredentials
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public RegistryKubernetesDockerCredentials createRegistryKubernetesDockerCredentials(String registryId, Integer expirySeconds, Boolean readWrite, Boolean base64Encode) throws ApiException {
        ApiResponse<RegistryKubernetesDockerCredentials> localVarResp = createRegistryKubernetesDockerCredentialsWithHttpInfo(registryId, expirySeconds, readWrite, base64Encode);
        return localVarResp.getData();
    }

    /**
     * Create Docker Credentials for Kubernetes
     * Create a fresh set of Docker Credentials for this Container Registry Subscription and return them in a Kubernetes friendly YAML format
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param expirySeconds The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 (optional)
     * @param readWrite Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. (optional)
     * @param base64Encode Whether this YAML will be returned in a base64 encoded string for ease of downloading. If true, the response will be a base64 encoded string. Default is false. (optional)
     * @return ApiResponse&lt;RegistryKubernetesDockerCredentials&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<RegistryKubernetesDockerCredentials> createRegistryKubernetesDockerCredentialsWithHttpInfo(String registryId, Integer expirySeconds, Boolean readWrite, Boolean base64Encode) throws ApiException {
        okhttp3.Call localVarCall = createRegistryKubernetesDockerCredentialsValidateBeforeCall(registryId, expirySeconds, readWrite, base64Encode, null);
        Type localVarReturnType = new TypeToken<RegistryKubernetesDockerCredentials>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create Docker Credentials for Kubernetes (asynchronously)
     * Create a fresh set of Docker Credentials for this Container Registry Subscription and return them in a Kubernetes friendly YAML format
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param expirySeconds The seconds until these credentials expire. When set to 0, credentials do not expire. The default value is 0 (optional)
     * @param readWrite Whether these credentials will have only PULL access or PUSH access as well. If true these credentials can PUSH to repos in this registry. If false, these credentials can only PULL. Default is false. (optional)
     * @param base64Encode Whether this YAML will be returned in a base64 encoded string for ease of downloading. If true, the response will be a base64 encoded string. Default is false. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createRegistryKubernetesDockerCredentialsAsync(String registryId, Integer expirySeconds, Boolean readWrite, Boolean base64Encode, final ApiCallback<RegistryKubernetesDockerCredentials> _callback) throws ApiException {

        okhttp3.Call localVarCall = createRegistryKubernetesDockerCredentialsValidateBeforeCall(registryId, expirySeconds, readWrite, base64Encode, _callback);
        Type localVarReturnType = new TypeToken<RegistryKubernetesDockerCredentials>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteRegistry
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content - Successfully Deleted </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteRegistryCall(String registryId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registry/{registry-id}"
            .replace("{" + "registry-id" + "}", localVarApiClient.escapeString(registryId.toString()));

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
    private okhttp3.Call deleteRegistryValidateBeforeCall(String registryId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'registryId' is set
        if (registryId == null) {
            throw new ApiException("Missing the required parameter 'registryId' when calling deleteRegistry(Async)");
        }

        return deleteRegistryCall(registryId, _callback);

    }

    /**
     * Delete Container Registry
     * Deletes a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content - Successfully Deleted </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public void deleteRegistry(String registryId) throws ApiException {
        deleteRegistryWithHttpInfo(registryId);
    }

    /**
     * Delete Container Registry
     * Deletes a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content - Successfully Deleted </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> deleteRegistryWithHttpInfo(String registryId) throws ApiException {
        okhttp3.Call localVarCall = deleteRegistryValidateBeforeCall(registryId, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Delete Container Registry (asynchronously)
     * Deletes a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content - Successfully Deleted </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteRegistryAsync(String registryId, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteRegistryValidateBeforeCall(registryId, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteRepository
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content - Successfully Deleted </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteRepositoryCall(String registryId, String repositoryImage, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registry/{registry-id}/repository/{repository-image}"
            .replace("{" + "registry-id" + "}", localVarApiClient.escapeString(registryId.toString()))
            .replace("{" + "repository-image" + "}", localVarApiClient.escapeString(repositoryImage.toString()));

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
    private okhttp3.Call deleteRepositoryValidateBeforeCall(String registryId, String repositoryImage, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'registryId' is set
        if (registryId == null) {
            throw new ApiException("Missing the required parameter 'registryId' when calling deleteRepository(Async)");
        }

        // verify the required parameter 'repositoryImage' is set
        if (repositoryImage == null) {
            throw new ApiException("Missing the required parameter 'repositoryImage' when calling deleteRepository(Async)");
        }

        return deleteRepositoryCall(registryId, repositoryImage, _callback);

    }

    /**
     * Delete Repository
     * Deletes a Repository from a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content - Successfully Deleted </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public void deleteRepository(String registryId, String repositoryImage) throws ApiException {
        deleteRepositoryWithHttpInfo(registryId, repositoryImage);
    }

    /**
     * Delete Repository
     * Deletes a Repository from a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content - Successfully Deleted </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> deleteRepositoryWithHttpInfo(String registryId, String repositoryImage) throws ApiException {
        okhttp3.Call localVarCall = deleteRepositoryValidateBeforeCall(registryId, repositoryImage, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Delete Repository (asynchronously)
     * Deletes a Repository from a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> No Content - Successfully Deleted </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteRepositoryAsync(String registryId, String repositoryImage, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteRepositoryValidateBeforeCall(registryId, repositoryImage, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for listRegistries
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listRegistriesCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registries";

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
    private okhttp3.Call listRegistriesValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return listRegistriesCall(_callback);

    }

    /**
     * List Container Registries
     * List All Container Registry Subscriptions for this account
     * @return ListRegistries200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ListRegistries200Response listRegistries() throws ApiException {
        ApiResponse<ListRegistries200Response> localVarResp = listRegistriesWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * List Container Registries
     * List All Container Registry Subscriptions for this account
     * @return ApiResponse&lt;ListRegistries200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ListRegistries200Response> listRegistriesWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = listRegistriesValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<ListRegistries200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List Container Registries (asynchronously)
     * List All Container Registry Subscriptions for this account
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listRegistriesAsync(final ApiCallback<ListRegistries200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = listRegistriesValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<ListRegistries200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listRegistryPlans
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listRegistryPlansCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registry/plan/list";

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
    private okhttp3.Call listRegistryPlansValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return listRegistryPlansCall(_callback);

    }

    /**
     * List Registry Plans
     * List All Plans to help choose which one is the best fit for your Container Registry
     * @return ListRegistryPlans200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ListRegistryPlans200Response listRegistryPlans() throws ApiException {
        ApiResponse<ListRegistryPlans200Response> localVarResp = listRegistryPlansWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * List Registry Plans
     * List All Plans to help choose which one is the best fit for your Container Registry
     * @return ApiResponse&lt;ListRegistryPlans200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ListRegistryPlans200Response> listRegistryPlansWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = listRegistryPlansValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<ListRegistryPlans200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List Registry Plans (asynchronously)
     * List All Plans to help choose which one is the best fit for your Container Registry
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listRegistryPlansAsync(final ApiCallback<ListRegistryPlans200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = listRegistryPlansValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<ListRegistryPlans200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listRegistryRegions
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listRegistryRegionsCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registry/region/list";

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
    private okhttp3.Call listRegistryRegionsValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return listRegistryRegionsCall(_callback);

    }

    /**
     * List Registry Regions
     * List All Regions where a Container Registry can be deployed
     * @return ListRegistryRegions200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ListRegistryRegions200Response listRegistryRegions() throws ApiException {
        ApiResponse<ListRegistryRegions200Response> localVarResp = listRegistryRegionsWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * List Registry Regions
     * List All Regions where a Container Registry can be deployed
     * @return ApiResponse&lt;ListRegistryRegions200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ListRegistryRegions200Response> listRegistryRegionsWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = listRegistryRegionsValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<ListRegistryRegions200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List Registry Regions (asynchronously)
     * List All Regions where a Container Registry can be deployed
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listRegistryRegionsAsync(final ApiCallback<ListRegistryRegions200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = listRegistryRegionsValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<ListRegistryRegions200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listRegistryRepositories
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listRegistryRepositoriesCall(String registryId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registry/{registry-id}/repositories"
            .replace("{" + "registry-id" + "}", localVarApiClient.escapeString(registryId.toString()));

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
    private okhttp3.Call listRegistryRepositoriesValidateBeforeCall(String registryId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'registryId' is set
        if (registryId == null) {
            throw new ApiException("Missing the required parameter 'registryId' when calling listRegistryRepositories(Async)");
        }

        return listRegistryRepositoriesCall(registryId, _callback);

    }

    /**
     * List Repositories
     * List All Repositories in a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @return ListRegistryRepositories200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ListRegistryRepositories200Response listRegistryRepositories(String registryId) throws ApiException {
        ApiResponse<ListRegistryRepositories200Response> localVarResp = listRegistryRepositoriesWithHttpInfo(registryId);
        return localVarResp.getData();
    }

    /**
     * List Repositories
     * List All Repositories in a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @return ApiResponse&lt;ListRegistryRepositories200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ListRegistryRepositories200Response> listRegistryRepositoriesWithHttpInfo(String registryId) throws ApiException {
        okhttp3.Call localVarCall = listRegistryRepositoriesValidateBeforeCall(registryId, null);
        Type localVarReturnType = new TypeToken<ListRegistryRepositories200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List Repositories (asynchronously)
     * List All Repositories in a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listRegistryRepositoriesAsync(String registryId, final ApiCallback<ListRegistryRepositories200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = listRegistryRepositoriesValidateBeforeCall(registryId, _callback);
        Type localVarReturnType = new TypeToken<ListRegistryRepositories200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for readRegistry
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call readRegistryCall(String registryId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registry/{registry-id}"
            .replace("{" + "registry-id" + "}", localVarApiClient.escapeString(registryId.toString()));

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
    private okhttp3.Call readRegistryValidateBeforeCall(String registryId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'registryId' is set
        if (registryId == null) {
            throw new ApiException("Missing the required parameter 'registryId' when calling readRegistry(Async)");
        }

        return readRegistryCall(registryId, _callback);

    }

    /**
     * Read Container Registry
     * Get a single Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @return Registry
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public Registry readRegistry(String registryId) throws ApiException {
        ApiResponse<Registry> localVarResp = readRegistryWithHttpInfo(registryId);
        return localVarResp.getData();
    }

    /**
     * Read Container Registry
     * Get a single Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @return ApiResponse&lt;Registry&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Registry> readRegistryWithHttpInfo(String registryId) throws ApiException {
        okhttp3.Call localVarCall = readRegistryValidateBeforeCall(registryId, null);
        Type localVarReturnType = new TypeToken<Registry>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Read Container Registry (asynchronously)
     * Get a single Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call readRegistryAsync(String registryId, final ApiCallback<Registry> _callback) throws ApiException {

        okhttp3.Call localVarCall = readRegistryValidateBeforeCall(registryId, _callback);
        Type localVarReturnType = new TypeToken<Registry>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for readRegistryRepository
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call readRegistryRepositoryCall(String registryId, String repositoryImage, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/registry/{registry-id}/repository/{repository-image}"
            .replace("{" + "registry-id" + "}", localVarApiClient.escapeString(registryId.toString()))
            .replace("{" + "repository-image" + "}", localVarApiClient.escapeString(repositoryImage.toString()));

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
    private okhttp3.Call readRegistryRepositoryValidateBeforeCall(String registryId, String repositoryImage, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'registryId' is set
        if (registryId == null) {
            throw new ApiException("Missing the required parameter 'registryId' when calling readRegistryRepository(Async)");
        }

        // verify the required parameter 'repositoryImage' is set
        if (repositoryImage == null) {
            throw new ApiException("Missing the required parameter 'repositoryImage' when calling readRegistryRepository(Async)");
        }

        return readRegistryRepositoryCall(registryId, repositoryImage, _callback);

    }

    /**
     * Read Repository
     * Get a single Repository in a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @return RegistryRepository
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public RegistryRepository readRegistryRepository(String registryId, String repositoryImage) throws ApiException {
        ApiResponse<RegistryRepository> localVarResp = readRegistryRepositoryWithHttpInfo(registryId, repositoryImage);
        return localVarResp.getData();
    }

    /**
     * Read Repository
     * Get a single Repository in a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @return ApiResponse&lt;RegistryRepository&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<RegistryRepository> readRegistryRepositoryWithHttpInfo(String registryId, String repositoryImage) throws ApiException {
        okhttp3.Call localVarCall = readRegistryRepositoryValidateBeforeCall(registryId, repositoryImage, null);
        Type localVarReturnType = new TypeToken<RegistryRepository>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Read Repository (asynchronously)
     * Get a single Repository in a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call readRegistryRepositoryAsync(String registryId, String repositoryImage, final ApiCallback<RegistryRepository> _callback) throws ApiException {

        okhttp3.Call localVarCall = readRegistryRepositoryValidateBeforeCall(registryId, repositoryImage, _callback);
        Type localVarReturnType = new TypeToken<RegistryRepository>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateRegistry
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param updateRegistryRequest  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateRegistryCall(String registryId, UpdateRegistryRequest updateRegistryRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = updateRegistryRequest;

        // create path and map variables
        String localVarPath = "/registry/{registry-id}"
            .replace("{" + "registry-id" + "}", localVarApiClient.escapeString(registryId.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateRegistryValidateBeforeCall(String registryId, UpdateRegistryRequest updateRegistryRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'registryId' is set
        if (registryId == null) {
            throw new ApiException("Missing the required parameter 'registryId' when calling updateRegistry(Async)");
        }

        return updateRegistryCall(registryId, updateRegistryRequest, _callback);

    }

    /**
     * Update Container Registry
     * Update a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param updateRegistryRequest  (optional)
     * @return Registry
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public Registry updateRegistry(String registryId, UpdateRegistryRequest updateRegistryRequest) throws ApiException {
        ApiResponse<Registry> localVarResp = updateRegistryWithHttpInfo(registryId, updateRegistryRequest);
        return localVarResp.getData();
    }

    /**
     * Update Container Registry
     * Update a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param updateRegistryRequest  (optional)
     * @return ApiResponse&lt;Registry&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Registry> updateRegistryWithHttpInfo(String registryId, UpdateRegistryRequest updateRegistryRequest) throws ApiException {
        okhttp3.Call localVarCall = updateRegistryValidateBeforeCall(registryId, updateRegistryRequest, null);
        Type localVarReturnType = new TypeToken<Registry>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update Container Registry (asynchronously)
     * Update a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param updateRegistryRequest  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateRegistryAsync(String registryId, UpdateRegistryRequest updateRegistryRequest, final ApiCallback<Registry> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateRegistryValidateBeforeCall(registryId, updateRegistryRequest, _callback);
        Type localVarReturnType = new TypeToken<Registry>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateRepository
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @param updateRepositoryRequest  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateRepositoryCall(String registryId, String repositoryImage, UpdateRepositoryRequest updateRepositoryRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = updateRepositoryRequest;

        // create path and map variables
        String localVarPath = "/registry/{registry-id}/repository/{repository-image}"
            .replace("{" + "registry-id" + "}", localVarApiClient.escapeString(registryId.toString()))
            .replace("{" + "repository-image" + "}", localVarApiClient.escapeString(repositoryImage.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateRepositoryValidateBeforeCall(String registryId, String repositoryImage, UpdateRepositoryRequest updateRepositoryRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'registryId' is set
        if (registryId == null) {
            throw new ApiException("Missing the required parameter 'registryId' when calling updateRepository(Async)");
        }

        // verify the required parameter 'repositoryImage' is set
        if (repositoryImage == null) {
            throw new ApiException("Missing the required parameter 'repositoryImage' when calling updateRepository(Async)");
        }

        return updateRepositoryCall(registryId, repositoryImage, updateRepositoryRequest, _callback);

    }

    /**
     * Update Repository
     * Update a Repository in a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @param updateRepositoryRequest  (optional)
     * @return RegistryRepository
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public RegistryRepository updateRepository(String registryId, String repositoryImage, UpdateRepositoryRequest updateRepositoryRequest) throws ApiException {
        ApiResponse<RegistryRepository> localVarResp = updateRepositoryWithHttpInfo(registryId, repositoryImage, updateRepositoryRequest);
        return localVarResp.getData();
    }

    /**
     * Update Repository
     * Update a Repository in a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @param updateRepositoryRequest  (optional)
     * @return ApiResponse&lt;RegistryRepository&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<RegistryRepository> updateRepositoryWithHttpInfo(String registryId, String repositoryImage, UpdateRepositoryRequest updateRepositoryRequest) throws ApiException {
        okhttp3.Call localVarCall = updateRepositoryValidateBeforeCall(registryId, repositoryImage, updateRepositoryRequest, null);
        Type localVarReturnType = new TypeToken<RegistryRepository>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update Repository (asynchronously)
     * Update a Repository in a Container Registry Subscription
     * @param registryId The [Registry ID](#components/schemas/registry/properties/id). Which can be found by [List Registries](#operation/list-registries). (required)
     * @param repositoryImage The [Repository Image](#components/schemas/registry-repository/properties/image). Which can be found by [List Repositories](#operation/list-registry-repositories). (required)
     * @param updateRepositoryRequest  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Bad Request </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateRepositoryAsync(String registryId, String repositoryImage, UpdateRepositoryRequest updateRepositoryRequest, final ApiCallback<RegistryRepository> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateRepositoryValidateBeforeCall(registryId, repositoryImage, updateRepositoryRequest, _callback);
        Type localVarReturnType = new TypeToken<RegistryRepository>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
