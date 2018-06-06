Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario : Login success with valid user
!-- Step 1
Given application browser "Chrome" is set
!-- Step 2
When open page "https://outlook.office365.com/owa/" in browser
Then field "Outlook.Input_EmailAddress" should be displayed
!-- Step 3
When field "Outlook.Input_EmailAddress" is filled with "baopn@vpbank.com.vn"
And field "Outlook.Button_Submit" is clicked
!-- Step 4
When field "Outlook.Input_Password" is filled with "Feralkun123!@#"
And field "Outlook.Button_Submit" is clicked
Then field "Outlook.Label_StaySignedIn" should be displayed
