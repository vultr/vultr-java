

# DatabaseUser

Managed Database user information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**username** | **String** | The username for the database user. |  [optional] |
|**password** | **String** | The password for the database user. |  [optional] |
|**encryption** | **String** | The password encryption for the database user (MySQL engine type only). * &#x60;Default (MySQL 8+)&#x60; * &#x60;Legacy (MySQL 5.x)&#x60; |  [optional] |
|**accessControl** | [**DatabaseUserAccessControl**](DatabaseUserAccessControl.md) |  |  [optional] |



