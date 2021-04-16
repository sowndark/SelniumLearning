Feature: login Checking

Scenario Outline: login with correct credentials

Given intialize the chrome browser
And landed to the "https://rahulshettyacademy.com/" page 
And click on the login button
When user login by entering mail <userName> and the password <password>
Then the user sucessfully logged "true"
And quit the browser

Examples:
|userName        | |password|
|test99@gmail.com| |123456  |
|test91@gmail.com| |1234567  |

