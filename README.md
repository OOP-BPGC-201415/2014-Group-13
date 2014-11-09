Group-13
========
JUnit Test Submission:
According to the classes for which the code has been written, we have created Unit Tests using Mock Objects (Easy Mock). Interfaces with method declarations followed by mocktest class (following "createstrictmock" pattern to ensure that methos are invoked in the correct order ) have been created for all the classes for which the final code is to be written. 
The necessary jar files that are to be imported and added to the library have been added accordingly in the folder uploaded by the name "OOP Project EWallet". The codes are available in the src file. A description of the interfaces and their corresponding mocktest classes is as follows:
1. Login
  We have created 'LoginService','LoginServiceImpl'(Implementation),'LoginServiceTest','LoginWindow','LoginWindowTest', 'User',  'UserDAO' have been created to ensure proper opening of the Login Window and mock objects have been created to ensure a valid username/password.
2.'AuthIn' interface and 'AunthenticateTest' mock test to test the class 'Authenticate'.
3.'ConnectToDBInter' interface and 'MockConnectToDBTest' mock test to test the class 'ConnectToDB'.
4.'ForgotPwdInter' interface and 'MockForgotPwdTest' mock test to test the class 'ForgotPassword'.
5.'ProfileInter' interface and 'MockProfileTest' mock test to test the class 'Profile'.
6.'MailInter' interface and 'SendeMailMockTest' mock test to test the class 'SendeMail'.
