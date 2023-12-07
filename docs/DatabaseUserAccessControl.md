

# DatabaseUserAccessControl

Access control settings for the database user (Redis engine type only).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**redisAclCategories** | **List&lt;String&gt;** | List of configured rules for command categories. |  [optional] |
|**redisAclChannels** | **List&lt;String&gt;** | List of configured publish/subscribe channel patterns. |  [optional] |
|**redisAclCommands** | **List&lt;String&gt;** | List of configured rules for individual commands. |  [optional] |
|**redisAclKeys** | **List&lt;String&gt;** | List of configured key access rules. |  [optional] |



