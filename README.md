# E2E test on https://www.uber.com/br/pt-br/
The following scenario is executed in this test:

- User signs in into uber website using his/her profile, fills 'pick up' and 'destination' fields and then confirms the request. An assertion verifies if the correct profile was loaded, then two more assertions assert that the correct addresses were chosen. Finally, a final assertion assures that the request for a driver was made.

## Requirements
- Java (configure environment variables).
- Maven (configure environment variables).
- Browser (chrome, opera or firefox. Drivers are already present on 'drivers' folder).
- Valid uber profile.
- An IDE.

## How to run the test
- Clone project.
- Fill the following fields on the Data.properties file: full-name, cell (with your cellphone number) and password (with your uber password). On this same file, the browser field accepts 3 options: chrome, firefox and opera.
- During the test, your IDE will request you to enter the sms code sent to your phone. This code MUST NOT be inserted into the browser, but through your IDE's console.
- Execute testng.xml file from your IDE.