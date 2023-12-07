

# DbaasAvailableOptions

Managed Database PostgreSQL advanced configuration options.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | The name of the configuration option. |  [optional] |
|**type** | **String** | The type of the configuration option. * &#x60;int&#x60; * &#x60;float&#x60; * &#x60;bool&#x60; * &#x60;enum&#x60; |  [optional] |
|**enumerals** | **List&lt;String&gt;** | Valid enumerals for &#x60;enum&#x60; type configuration options only. |  [optional] |
|**minValue** | **Mixed** | The smallest value accepted for the configuration option. |  [optional] |
|**maxValue** | **Mixed** | The largest value accepted for the configuration option. |  [optional] |
|**altValues** | **List&lt;Mixed&gt;** | Any alternate value accepted for the configuration option. |  [optional] |
|**units** | **String** | The units associated with the configuration option. |  [optional] |



