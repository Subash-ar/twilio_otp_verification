# twilio_otp_verification
This project demonstrates how to implement OTP (One-Time Password) verification using Twilio's API. The OTP verification can be tested using Postman for API requests.

Features
OTP Generation: Generate a unique OTP and send it to a user's mobile number via SMS using Twilio.
OTP Verification: Validate the OTP entered by the user to authenticate their identity.
Postman Testing: Easily test the OTP generation and verification APIs using Postman.
Technologies Used
Spring Boot: Backend framework to build the REST API.
Twilio API: Third-party service for sending OTPs via SMS.
Postman: Tool for testing the APIs.

post --> http://localhost:8080/send_otp?phoneNumber=+******** // number
http://localhost:8080/verify-otp?phoneNumber=+*******&otp=*******  //number and otp



Configure Twilio:

Sign up for a Twilio account.
Obtain your Account SID, Auth Token, and a Twilio phone number.
Update these details in the application.properties file.
