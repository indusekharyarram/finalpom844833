package stepdefinition;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepdefinition {
	WebDriver driver;
/////TS_01
	@Given("^launch the browser$")
	public void launch_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@When("^launch the application$")
	public void launch_the_application() throws Throwable {
		driver.get("http://examples.codecharge.com/TaskManager/Default.php");
	}
	@When("^click on Administration$")
	public void click_on_Administration() throws Throwable {   //enter_username_and_password_and_click_on_login();
		driver.findElement(By.xpath("//img[@src='images/administration-button.gif']")).click();
	}

	@When("^enter username and password and click on login$")
	public void enter_username_and_password_and_click_on_login() throws Throwable {
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='DoLogin']")).click();
	}

	@Then("^assert true if it is navigating to next page$")
	public void assert_true_if_it_is_navigating_to_next_page() throws Throwable {
	   String a=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table[1]/tbody/tr/th")).getText();
	   Assert.assertEquals("Administraton",a);
	}
/////TS_02
	@Given("^launch the browser(\\d+)$")
	public void launch_the_browser(int arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@When("^launch the application(\\d+)$")
	public void launch_the_application(int arg1) throws Throwable {
		driver.get("http://examples.codecharge.com/TaskManager/Default.php");
	}
	@When("^click on Administration(\\d+)$")
	public void click_on_Administration(int arg1) throws Throwable {
		driver.findElement(By.xpath("//img[@src='images/administration-button.gif']")).click();
	}

	@When("^enter Invalid Credentials and click on login(\\d+)$")
	public void enter_Invalid_Credentials_and_click_on_login(int arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("cognizant");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("cognizant");
		driver.findElement(By.xpath("//input[@name='DoLogin']")).click();
	}

	@Then("^assert if it is displaying Error Message$")
	public void assert_if_it_is_displaying_Error_Message() throws Throwable {
		String b=driver.findElement(By.xpath("(//td[@colspan='2'])[1]")).getText();
		   Assert.assertEquals("Login or Password is incorrect.",b);
	}
/////TS_03
	@Given("^open the application$")
	public void open_the_application() throws Throwable  {
		launch_the_browser();
		launch_the_application();
		click_on_Administration();
		
	}

	@When("^login with valid credentials$")
	public void login_with_valid_credentials() throws Throwable {
		enter_username_and_password_and_click_on_login();
	}

	@When("^click on add task$")
	public void click_on_add_task() throws Throwable {
	    driver.findElement(By.xpath("(//img[@border='0'])[3]")).click();
	}

	@When("^enter all fields$")
	public void enter_all_fields() throws Throwable {
		
		driver.findElement(By.xpath("//input[@name='task_name']")).sendKeys("CTS");
	    driver.findElement(By.xpath("//textarea[@name='task_desc']")).sendKeys("Cognizant Technology and Solutions ");
	    driver.findElement(By.xpath("(//option[@value='1'])[1]")).click();
	    driver.findElement(By.xpath("(//option[@value='1'])[2]")).click();
	   driver.findElement(By.xpath("(//option[@value='1'])[3]")).click();
	   driver.findElement(By.xpath("(//option[@value='1'])[4]")).click();
	   driver.findElement(By.xpath("(//option[@value='16'])")).click(); 
	}
	@When("^select Start Date$")
	public void select_Start_Date() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/table[2]/tbody/tr[8]/td/a/img"))).click().build().perform();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		Set<String>allWindows=driver.getWindowHandles();
		for(String Window:allWindows)
		{
			System.out.println(Window);
			if(!parent.equalsIgnoreCase(Window))
			{
				driver.switchTo().window(Window);
			}
		}
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("/html/body/center/table/tbody/tr/td/table/tbody/tr[4]/td[3]/a"))).click().build().perform();
		driver.switchTo().window(parent);
	}
	@When("^select End Date$")
	public void select_End_Date() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/table[2]/tbody/tr[9]/td/a/img"))).click().build().perform();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		Set<String>allWindows=driver.getWindowHandles();
		for(String Window:allWindows)
		{
			System.out.println(Window);
			if(!parent.equalsIgnoreCase(Window))
			{
				driver.switchTo().window(Window);
			}
		}
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("/html/body/center/table/tbody/tr/td/table/tbody/tr[5]/td[6]/a"))).click().build().perform();
		driver.switchTo().window(parent);
	}

	@When("^click on Add button$")
	public void click_on_Add_button() throws Throwable {
		driver.findElement(By.xpath("//input[@name='Insert']")).click();
	    
	}
	@Then("^assert if added task is shown in task list table$")
	public void assert_if_added_task_is_shown_in_task_list_table() throws Throwable {
	   String c=driver.findElement(By.xpath("//a[text()='CTS']")).getText();
	   Assert.assertEquals("CTS", c);
	   }
/////TS_04
	@Given("^open the application7$")
	public void open_the_application7() throws Throwable {
		launch_the_browser();
		launch_the_application();
	}

	@When("^select task in Type$")
	public void select_task_in_Type() throws Throwable {
	    driver.findElement(By.xpath("(//option[@value='1'])[5]")).click();
	}

	@When("^click on Search$")
	public void click_on_Search() throws Throwable {
	    driver.findElement(By.xpath("//input[@name='DoSearch']")).click();
	}

	@Then("^Assert if previously added task is in the table or not$")
	public void assert_if_previously_added_task_is_in_the_table_or_not() throws Throwable {
		assert_if_added_task_is_shown_in_task_list_table();
	}
/////TS_05
	@Given("^Open the application8$")
	public void Open_the_application8() throws Throwable {
		launch_the_browser();
		launch_the_application();
	}

	@When("^click on finish date$")
	public void click_on_finish_date() throws Throwable {
		WebElement y=driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td/table[2]/tbody/tr[1]/td[8]/a"));
		Actions action=new Actions(driver);
		action.doubleClick(y);
		Thread.sleep(5000);
	}

	@Then("^Assert if finish date is as same as previously added task finish date$")
	public void Assert_if_finish_date_is_as_same_as_previously_added_task_finish_date() throws Throwable {
		String x=driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td/table[2]/tbody/tr[2]/td[8]")).getText();
		System.out.println(x);   
	}
	
/////TS_06
	@Given("^sign in to the web application$")
	public void sign_in_to_the_web_application() throws Throwable {
		launch_the_browser();
		launch_the_application();
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
	}

	@When("^click on projects$")
	public void click_on_projects() throws Throwable {
		driver.findElement(By.linkText("Projects")).click();
	   
	}

	@When("^add new projects$")
	public void add_new_projects() throws Throwable {
		driver.findElement(By.linkText("Add New Project")).click();
	}

	@When("^enter project title$")
	public void enter_project_title() throws Throwable {
		driver.findElement(By.name("project_name")).sendKeys("Selenium Automation");
	}

	@When("^tap on add button$")
	public void tap_on_add_button() throws Throwable {
	    driver.findElement(By.xpath("//input[@type='image'][1]")).click();
	}

	@Then("^assert entered project is displayed in the project list$")
	public void assert_entered_project_is_displayed_in_the_project_list() throws Throwable {
	    String s=driver.findElement(By.linkText("Selenium Automation")).getText();
	    Assert.assertEquals("Selenium Automation",s);
	}
	
	
/////TS_07
	@Given("^open the web application$")
	public void open_the_web_application() throws Throwable {
		launch_the_browser();
		launch_the_application();
	}

	@When("^select task in Type and search$")
	public void select_task_in_Type_and_search() throws Throwable {
		select_task_in_Type();
		click_on_Search();
	}

	@When("^print the Displayed tasks$")
	public void print_the_Displayed_tasks() throws Throwable {
		TakesScreenshot ts=((TakesScreenshot)driver);
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("src\\test\\resources\\print\\print1.jpg"));
	}

	/*@Then("^assert the tasks$")
	public void assert_the_tasks() throws Throwable {
		assert_if_added_task_is_shown_in_task_list_table();
	}*/
	
/////TS_08
	@Given("^Signin to the application$")
	public void signin_to_the_application() throws Throwable {
		launch_the_browser();
		launch_the_application();
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
	}
	@When("^click on TasksList$")
	public void click_on_TasksList() throws Throwable {
	    driver.findElement(By.xpath("(//img[@border='0'])[2]")).click();
	}
	@When("^select project as Selenium Automation$")
	public void select_project_as_Selenium_Automation() throws Throwable {
	   driver.findElement(By.xpath("(//option[@value='6'])[2]")).click();
	}
	@When("^search for selenium automation$")
	public void search_for_selenium_automation() throws Throwable {
	 driver.findElement(By.xpath("(//input[@name='DoSearch'])")).click();   
	}
	@When("^add new task for Selenium Automation$")
	public void add_new_task_for_Selenium_Automation() throws Throwable {
	    driver.findElement(By.linkText("Add New Task")).click();
	}
	@When("^fill all the details and click on add button$")
	public void fill_all_the_details_and_click_on_add_button() throws Throwable {
		driver.findElement(By.xpath("(//input[@maxlength='100'])")).sendKeys("Selenium");
	    driver.findElement(By.xpath("(//textarea[@cols='51'])")).sendKeys("Cognizant Technology and Solutions SELENIUM ");
	    driver.findElement(By.xpath("(//option[@value='6'])[1]")).click();
	    driver.findElement(By.xpath("(//option[@value='1'])[2]")).click();
	   driver.findElement(By.xpath("(//option[@value='1'])[3]")).click();
	   driver.findElement(By.xpath("(//option[@value='1'])[4]")).click();
	   driver.findElement(By.xpath("(//option[@value='16'])")).click();
	   driver.findElement(By.xpath("//input[@name='Insert']")).click();
	}
	@When("^print added project task table$")
	public void print_added_project_task_table() throws Throwable {
		TakesScreenshot st=((TakesScreenshot)driver);
		File Source=st.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File("src\\test\\resources\\print\\print2.jpg"));
	}

	/*@Then("^assert project as Selenium Automation$")
	public void assert_project_as_Selenium_Automation() throws Throwable {
	   String q=driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td/table[2]/tbody/tr[10]/td[3]")).getText();
	   Assert.assertEquals("HIGH",q);
	}*/
	
/////TS_09
	@Given("^Login to the Application$")
	public void login_to_the_Application() throws Throwable {
		launch_the_browser();
		launch_the_application();
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
	}
	@When("^tap on TASK LIST$")
	public void tap_on_TASK_LIST() throws Throwable {
	    driver.findElement(By.xpath("(//img[@border='0'])[2]")).click();
	}
	@When("^select Priority as Highest$")
	public void select_Priority_as_Highest() throws Throwable {
		driver.findElement(By.xpath("(//option[@value='1'])[3]")).click();
	}
	@When("^Sort According to project$")
	public void sort_According_to_project() throws Throwable {
		driver.findElement(By.xpath("(//input[@type='image'])")).click();
	   driver.findElement(By.linkText("Project")).click();
	}
	/*@Then("^Assert sorted project$")
	public void assert_sorted_project() throws Throwable {
	    
	}*/
	
/////TS_10
	@Given("^Hold on Task Table$")
	public void hold_on_Task_Table() throws Throwable {
		launch_the_browser();
		launch_the_application();
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
	}
	@When("^PRINT Task_Table$")
	public void print_Task_Table() throws Throwable {
		tap_on_TASK_LIST();
		select_Priority_as_Highest();
		sort_According_to_project();
		TakesScreenshot print=((TakesScreenshot)driver);
		File S=print.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(S, new File("src\\test\\resources\\print\\print3.jpg"));
	}
	/*@Then("^Assert printed sort table$")
	public void assert_printed_sort_table() throws Throwable {
	    
	}*/

/////TS_11
	@Given("^set Browser$")
	public void set_Browser() throws Throwable {
		launch_the_browser();
		launch_the_application();
	}
	@When("^logon to the web application$")
	public void logon_to_the_web_application() throws Throwable {
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
	}
	/*@Then("^assert logon$")
	public void assert_logon() throws Throwable {
	}*/

/////TS_12
	@Given("^logon to application$")
	public void logon_to_application() throws Throwable {
		launch_the_browser();
		launch_the_application();
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
	}
	@When("^click on Add newEmployees$")
	public void click_on_Add_newEmployees() throws Throwable {
	   driver.findElement(By.linkText("Employees")).click();
	   driver.findElement(By.linkText("Add New Employee")).click();
	}
	/*@Then("^assert newEmployee$")
	public void assert_newEmployee() throws Throwable {
	  
	}*/
	
/////TS_13
	@Given("^add fields to the new Employee$")
	public void add_fields_to_the_new_Employee() throws Throwable {
		launch_the_browser();
		launch_the_application();
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
		click_on_Add_newEmployees();
		driver.findElement(By.xpath("(//input[@maxlength='50'])[1]")).sendKeys("Employee");
		driver.findElement(By.xpath("(//input[@maxlength='50'])[2]")).sendKeys("admin@cognizant.com");
		driver.findElement(By.xpath("(//input[@maxlength='20'])[1]")).sendKeys("admin");
		driver.findElement(By.xpath("(//input[@maxlength='20'])[2]")).sendKeys("admin");
		driver.findElement(By.xpath("(//option[@value='2'])")).click();
	}
	@When("^click on AddButton$")
	public void click_on_AddButton() throws Throwable {
	   driver.findElement(By.xpath("(//input[@name='Insert'])")).click();
	}
	/*@Then("^assert employee list$")
	public void assert_employee_list() throws Throwable {
	    
	}*/
	
/////TS_14
	@Given("^open employee List table$")
	public void open_employee_List_table() throws Throwable {
		launch_the_browser();
		launch_the_application();
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
		click_on_Add_newEmployees();
		add_fields_to_the_new_Employee();
		click_on_AddButton();
	}
	@When("^sort employee according to employee email$")
	public void sort_employee_according_to_employee_email() throws Throwable {
	    driver.findElement(By.linkText("Email")).click();
	}
	/*@Then("^assert sorted employee list$")
	public void assert_sorted_employee_list() throws Throwable {
	    
	}*/
	
/////TS_15
	@Given("^open Employee table list$")
	public void open_Employee_table_list() throws Throwable {
		launch_the_browser();
		launch_the_application();
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
		driver.findElement(By.linkText("Employees")).click();
		sort_employee_according_to_employee_email();
	}
	@When("^print the sorted employee table list$")
	public void print_the_sorted_employee_table_list() throws Throwable {
		TakesScreenshot ms=((TakesScreenshot)driver);
		File origin=ms.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(origin, new File("src\\test\\resources\\print\\print3.jpg"));
	   	}
	/*@Then("^asset the printed table$")
	public void asset_the_printed_table() throws Throwable {
	   
	}*/
	
/////TS_16
	@Given("^access the web application$")
	public void access_the_web_application() throws Throwable {
		launch_the_browser();
	}
	@When("^login to the web application$")
	public void login_to_the_web_application() throws Throwable {
		launch_the_application();
		click_on_Administration();
		enter_username_and_password_and_click_on_login();
	}
	@When("^logout from the webApplication$")
	public void logout_from_the_webApplication() throws Throwable {
	   driver.findElement(By.xpath("(//a)[9]")).click();
	}
	
/*@Then("^assert if application is logout$")
	public void assert_if_application_is_logout() throws Throwable {
	    String u=driver.findElement(By.xpath("//th[text()='Login']")).getText();
	    Assert.assertEquals("Login",u);

}*/	
}
