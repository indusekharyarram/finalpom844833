Feature: http://examples.codecharge.com/TaskManager/Default.php
@TS_01
Scenario: Login to examples.codecharge.com/TaskManager/Default.php
Given launch the browser
When launch the application
When click on Administration
When enter username and password and click on login
Then assert true if it is navigating to next page

@TS_02
Scenario: Invalid Login to examples.codecharge.com/TaskManager/Default.php
Given launch the browser1
When launch the application1
When click on Administration1
When enter Invalid Credentials and click on login1
Then assert if it is displaying Error Message

@TS_03
Scenario: add Task in examples.codecharge.com/TaskManager/Default.php
Given open the application
When click on Administration2
When login with valid credentials
When click on add task
When enter all fields 
When select Start Date
When select End Date
When click on Add button
Then assert if added task is shown in task list table

@TS_04
Scenario: Search Task in Type
Given open the application7
When select task in Type
When click on Search
Then Assert if previously added task is in the table or not

@TS_05
Scenario: Sort the Task Table according to finish date
Given Open the application8
When click on finish date
Then Assert if finish date is as same as previously added task finish date

@TS_06
Scenario: print Type
Given open the web application
When select task in Type and search
When print the Displayed tasks
Then assert the tasks

@TS_07
Scenario: Add New Projects
Given sign in to the web application
When click on projects
When add new projects
When enter project title
When tap on add button
Then assert entered project is displayed in the project list

@TS_08
Scenario: Search Added Project
Given Signin to the application
When click on TasksList
When select project as Selenium Automation
When search for selenium automation
When add new task for Selenium Automation
When fill all the details and click on add button
When print added project task table
Then assert project as Selenium Automation

@TS_09
Scenario: Sort the task list according to Project assigned as priority HIGHEST
Given Login to the Application
When tap on TASK LIST
When select Priority as Highest
When Sort According to project
Then Assert sorted project

@TS_10
Scenario: print the tasklist according to the project sorted
Given Hold on Task Table
When PRINT Task_Table
Then Assert printed sort table

@TS_11
Scenario: Access to TaskManager
Given set Browser
When logon to the web application
Then assert logon

@TS_12
Scenario: click on employees
Given logon to application
When click on Add newEmployees
Then assert newEmployee

@TS_13
Scenario: add all the fields for the employee
Given add fields to the new Employee
When click on AddButton
Then assert employee list

@TS_14
Scenario: sort newly added Employee List
Given open employee List table
When sort employee according to employee email
Then assert sorted employee list
 
@Ts_15
Scenario: print the newly sorted employee list
Given open Employee table list
When print the sorted employee table list
Then asset the printed table

@TS_16
Scenario: Logout from the application
Given access the web application
When login to the web application
When logout from the webApplication
Then assert if application is logout



