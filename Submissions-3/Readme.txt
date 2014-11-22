Group-13
========
JUnit Test Submission: According to the classes for which the code has been written, we have created Unit Tests using Mock Objects (Easy Mock). Interfaces with method declarations followed by mocktest class (following "createstrictmock" pattern to ensure that methos are invoked in the correct order ) have been created for all the classes for which the final code is to be written. The necessary jar files that are to be imported and added to the library have been added accordingly in the folder uploaded by the name "OOP Project EWallet". The codes are available in the src file. A description of the interfaces and their corresponding mocktest classes is as follows: 1. Login We have created 'LoginService','LoginServiceImpl'(Implementation),'LoginServiceTest','LoginWindow','LoginWindowTest', 'User', 'UserDAO' have been created to ensure proper opening of the Login Window and mock objects have been created to ensure a valid username/password. 2.'AuthIn' interface and 'AunthenticateTest' mock test to test the class 'Authenticate'. 3.'ConnectToDBInter' interface and 'MockConnectToDBTest' mock test to test the class 'ConnectToDB'. 4.'ForgotPwdInter' interface and 'MockForgotPwdTest' mock test to test the class 'ForgotPassword'. 5.'ProfileInter' interface and 'MockProfileTest' mock test to test the class 'Profile'. 6.'MailInter' interface and 'SendeMailMockTest' mock test to test the class 'SendeMail'.

Class used in the project:
User class: The base class that any user of the application extends in order to use it.
Admin class: Extends User class and is used to Add,Delete, Modify the Database of the application.
ConnectTODB class: Used to connect to the Oracle Database.
ForgotPassword Class: Used when a user has forgot his/her password. This emails a randomly generated password to the user's email address.
WriteLog class: This class writes all the errors that has occured while using the application to a text file for future reference.

The application uses Oracle Database and uses Oraclae JDBC:ODBC driver in order to connect to it.
It has to pre-installed on the server pc that runs the application and other clients will connect to it to access it.