Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario : Login success with valid user
!-- Step 1
Given application browser "Chrome" is set
!-- Step 2
When open page "https://online.vpbank.com.vn" in browser
Then field "Gmail.Input_Email" should be displayed
!-- Step 3
When field "Gmail.Input_Email" is filled with "baopn97@gmail.com"
And field "Gmail.Button_Submit" is clicked
Then field "Gmail.Input_Password" should be displayed
!-- Step 4
When field "Gmail.Input_Password" is filled with "ritocute"