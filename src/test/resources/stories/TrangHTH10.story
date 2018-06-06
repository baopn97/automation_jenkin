Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify Invalid Password (TC_11) (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "VP.Input_Email" is filled with "ebankuser7"
And field "Next.Button_Submit" is clicked
Then field "VP.Input_Password" should be displayed
When field "VP.Input_Password" is filled with "Test@135"
And field "Login.Button_Submit" is clicked
Then field "Login.ErrorMess" should be displayed

Scenario: Verify Invalid Username (TC_13) (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "VP.Input_Email" is filled with "testauto"
And field "Next.Button_Submit" is clicked
Then field "VP.Input_Password" should be displayed
When field "VP.Input_Password" is filled with "Htht247@"
And field "Login.Button_Submit" is clicked
Then field "Login.ErrorMess" should be displayed

Scenario: Verify Invalid Username/Password (TC_12) (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "VP.Input_Email" is filled with "testauto"
And field "Next.Button_Submit" is clicked
Then field "VP.Input_Password" should be displayed
When field "VP.Input_Password" is filled with "gfdgfdg"
And field "Login.Button_Submit" is clicked
Then field "Login.ErrorMess" should be displayed

Scenario: Verify Password require to key-in (TC_17) (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "VP.Input_Email" is filled with "ebankuser37"
And field "Next.Button_Submit" is clicked
Then field "VP.Input_Password" should be displayed
When field "Login.Button_Submit" is clicked
Then field "Pass.ErrorLabel" should be displayed

Scenario: Verify Username require to key-in (TC_18) (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "Next.Button_Submit" is clicked
Then field "User.ErrorLabel" should be displayed

Scenario: Verify Language English (TC_8) (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
And field "Language_Dropdown" is clicked
And field "ENG_Language" is clicked
Then field "Next.Button_Submit" should be displayed
And field "ENG_Introduce_Link" should be displayed
And field "ENG_OldVer_Link" should be displayed
And field "ENG_Regis_Link" should be displayed
And field "ENG_Secur_Link" should be displayed

Scenario: Verify Language Vietnam (TC_9) (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
And field "Language_Dropdown" is clicked
And field "VN_Language" is clicked
Then field "Next.Button_Submit" should be displayed
And field "VN_Introduce_Link" should be displayed
And field "VN_OldVer_Link" should be displayed
And field "VN_Regis_Link" should be displayed
And field "VN_Secur_Link" should be displayed

Scenario: Verify Multi-Browser (TC_19) (Pending because page is loading and can not find element on Hompage)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "VP.Input_Email" is filled with "ebankuser7"
And field "Next.Button_Submit" is clicked
Then field "VP.Input_Password" should be displayed
When field "VP.Input_Password" is filled with "Htht247@"
And field "Login.Button_Submit" is clicked
Then field "Homepage" should be displayed
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp/home/mainPage.jsp#home" in browser
Then field "Login.HomePage_Link" should be displayed

Scenario : Login Username/Password (TC_10) (Pending because page is loading and can not find element on Hompage)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "VP.Input_Email" is filled with "ebankuser7"
And field "Next.Button_Submit" is clicked
Then field "VP.Input_Password" should be displayed
When field "VP.Input_Password" is filled with "Htht247@"
And field "Login.Button_Submit" is clicked
Then field "Homepage" should be displayed

Scenario: Verify navigate to Introducing VPBank hyperlink (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "VN_Introduce_Link" is clicked
Then field "Dialog" should be displayed

Scenario: Verify navigate to Use the old version hyperlink (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
!-- When open page "https://online.vpbank.com.vn/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "ENG_OldVer_Link" is clicked
And switch to tab "1"
Then field "OldVersion.Image_Popup" should be displayed

Scenario: Verify naviagte to Security Tips hyperlink (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "VN_Secur_Link" is clicked
Then field "Dialog" should be displayed

Scenario: Verify Language English (TC_8) (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
And field "Language_Dropdown" is clicked
And field "ENG_Language" is clicked
Then field "ENG_NextButton" should be displayed
And field "ENG_Introduce_Link" should be displayed
And field "ENG_OldVer_Link" should be displayed
And field "ENG_Regis_Link" should be displayed
And field "ENG_Secur_Link" should be displayed

Scenario: Verify navigate to Registration hyperlink (run ok)
Given application browser "Chrome" is set
When open page "https://10.37.16.244:8081/cb/pages/jsp-ns/login-cons.jsp" in browser
Then field "VP.Input_Email" should be displayed
When field "VN_Regis_Link" is clicked
Then open page "https://online.vpbank.com.vn/cb/pages/jsp-ns/self1.jsp#" in browser
