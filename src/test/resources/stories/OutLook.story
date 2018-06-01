Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario : Login success with valid user
!-- Step 1
Given application browser "Chrome" is opened
!-- Step 2
When open page "https://outlook.office365.com/owa/" in browser
Then "Outlook.Input_EmailAddress" should be displayed
Then field "Outlook.Input_EmailAddress" is filled with "baopn@vpbank.com.vn"
