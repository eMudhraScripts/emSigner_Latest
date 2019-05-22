package Page_Factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Utility;

public class pf_loginpage extends pf_genericmethods {
	
	final static Logger log = Logger.getLogger(pf_loginpage.class);
	@FindBy(how = How.CLASS_NAME, using = "btn-login") WebElement loginbutton;
	@FindBy(how = How.ID, using = "UserName") WebElement Usernamebox;
	@FindBy(how = How.ID, using = "Password") WebElement Passwordbox;
	@FindBy(how = How.ID, using = "btnLogin") WebElement Loginsubmit;
	@FindBy(how = How.XPATH, using = "//div[@class='validation-summary-errors']/ul/li") public WebElement msgerror; 

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Email ID')]") public WebElement EmailIDerror;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter')]") public WebElement PaswrdError;
	
	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-user icon-xs icon-rounded']") public WebElement username;
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']") public WebElement logoutBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"socialLoginForm\"]/form/div/div[1]/span") public WebElement emailErrCheck;
	@FindBy(how = How.XPATH, using = "//*[@id=\"socialLoginForm\"]/form/div/div[2]/span") public WebElement pwdErrCheck;
	
	public pf_loginpage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}


	
	public void logincredentials(String uname,String pass) throws Exception{
		//Thread.sleep(10000);
		cl_click(loginbutton);
		cl_entertext(Usernamebox, uname);
		cl_entertext(Passwordbox, pass);
		cl_click(Loginsubmit);
	}
	
	public void logout() throws Exception{
		Thread.sleep(1000);
		cl_click(username);
		Thread.sleep(1000);
		cl_click(logoutBtn);
		et.log(LogStatus.PASS,"Logout button is clicked- passed");
	}



	public void EmailErrCheck(String scriptname, String sheetName) throws Exception {
		cl_click(loginbutton);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Login button is clicked- passed");
		cl_click(Loginsubmit);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Submit button is clicked- passed");
		String msg=emailErrCheck.getText();
		et.log(LogStatus.PASS,"Email Error msg");
		log.info("Submit button without email "+msg);
		Utility.comparelogic(msg, sheetName, scriptname);
		
	}



	public void pwdErrCheck(String scriptname, String sheetName) throws Exception {
		Thread.sleep(1000);
		String msg=pwdErrCheck.getText();
		et.log(LogStatus.PASS,"pwd Error msg");
		log.info("Submit button without password "+msg);
		Utility.comparelogic(msg, sheetName, scriptname);
		
	}



	public void invalidEmailCheck(String un,String pwd,String scriptname, String sheetName) throws Exception {
		cl_entertext(Usernamebox, un);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Enter invalid EmailID");
		cl_entertext(Passwordbox, pwd);
		cl_click(Loginsubmit);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Submit button is clicked-passed");
		String msg=emailErrCheck.getText();
		log.info("Submit button with invalid emailID "+msg);
		Utility.comparelogic(msg, sheetName, scriptname);
		
	}

	public void invalidPwdCheck(String un,String pwd,String scriptname, String sheetName) throws Exception {
		Usernamebox.clear();
		Passwordbox.clear();
		cl_entertext(Usernamebox, un);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Enter valid EmailID");
		cl_entertext(Passwordbox, pwd);
		et.log(LogStatus.PASS,"Enter invalid passwrd");
		cl_click(Loginsubmit);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Submit button is clicked-passed");
		String msg=pwdErrCheck.getText();
		log.info("Submit button with invalid password "+msg);
		Utility.comparelogic(msg, sheetName, scriptname);
		
	}

}
