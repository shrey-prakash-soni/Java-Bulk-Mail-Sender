
# Java Bulk Email Sender

A java project to send bulk emails(only Gmail account is accepted).

To send bulk emails from Gmail Account some steps need to be followed:

Step 1: Enable 2FA( Google Account -> Security -> Two Factor Authentication)

Step 2: Create App Password (This is necessary as Google has changed its policy from June,2022)

    Step 2.1: Select "Other" as category in Select Device Dropdown.
    Step 2.2: Give the name of the App Password "Java Mail".
    Step 2.3: Click on Generate Password (Must copy the generated password)

Step 3: After running the application, in password field use App Password.

And That's it, now you can send as many emails as you want (There is a cap limit set by Google so make sure don't send more than 100 emails in a day)

