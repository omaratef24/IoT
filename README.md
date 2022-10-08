# IoT
This program providing back-end system for Vodafone shop 
for storing database devices and there status on the embedded DB

## Technical 
creating class for devices and Repository for the functions
and services class having the business

### How to Run 
* $ mvn install
* $ java -jar ./target/iot-0.0.1-SNAPSHOT.jar


### Task
a. Returns all devices in the warehouse that are waiting for activation.
`curl --location --request GET 'localhost:8080/api/devices?status=Waiting'`

b. Management endpoints that enable the shop manager to remove or update a device configuration status.
`curl --location --request PUT 'localhost:8080/api/devices/update' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":"1312326",
"status": "Active"
}'`


c. Returns an ordered result of devices available for sale.
`curl --location --request GET 'localhost:8080/api/devices?status=Active'`
