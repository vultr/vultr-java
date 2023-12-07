

# BackupSchedule

Backup schedule information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**enabled** | **Boolean** | Indicates if backup is enabled:  * true * false |  [optional] |
|**type** | **String** | Type of backup schedule:  |   | Value | Description | | - | ------ | ------------- | |   | daily | Back up once per day at &#x60;hour&#x60;. | |   | weekly | Back up once per week on &#x60;dow&#x60; at &#x60;hour&#x60;. | |   | monthly | Back up each month at &#x60;dom&#x60; at &#x60;hour&#x60;. | |   | daily\\_alt\\_even | Back up on even dates at &#x60;hour&#x60;. | |   | daily\\_alt\\_odd | Back up on odd dates at &#x60;hour&#x60;. | |  [optional] |
|**nextScheduledTimeUtc** | **String** | Time of next backup run in UTC. |  [optional] |
|**hour** | **Integer** | Scheduled hour of day in UTC. |  [optional] |
|**dow** | **Integer** | Day of week to run.  |   | Value | Description | | - | ------ | ------------- | |   | 1 | Sunday | |   | 2 | Monday | |   | 3 | Tuesday | |   | 4 | Wednesday | |   | 5 | Thursday | |   | 6 | Friday | |   | 7 | Saturday | |  [optional] |
|**dom** | **Integer** | Day of month to run. Use values between 1 and 28. |  [optional] |



