

# CreateUserRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**email** | **String** | The User&#39;s email address. |  |
|**name** | **String** | The User&#39;s name. |  |
|**password** | **String** | The User&#39;s password. |  |
|**apiEnabled** | **Boolean** | API access is permitted for this User.  * true (default) * false |  [optional] |
|**acls** | **List&lt;String&gt;** | An array of permissions granted.  * abuse * alerts * billing * dns * firewall * loadbalancer * manage\\_users * objstore * provisioning * subscriptions * subscriptions\\_view * support * upgrade |  [optional] |



