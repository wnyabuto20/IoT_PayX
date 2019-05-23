# IoT_PayX
This project aims to initiate mobile money checkouts using RFID cards through Africa's Talking's payments API.
All the checkout information (phone numbers and checkout amounts) (Once read fron the card)are transmitted to the app using MQTT messaging.
The app is primarily an MQTT client that receives check out information before initiating checkouts using the payments API.
# How it works
Phone numbers and amounts read from cards and published as messages to a topic on Africa's Talking's MQTT server. 
The mqttClient code (subscribed to this message) receives the message and initiates a checkout through the checkout 
code which makes use of the payments SDK. 
The CallbackHost sets up a local host (on port 4567) through which Callbacks ( which are json objects) 
will be received once it is tunneled to the World Wide Web. The CallbackController transforms the jsons to Mpesa Objects. 
The publisher code publishes the payment status (success or failure) 
which is then received by an app and a response (green light for success, red light for failure ) is initiated on hardware.
