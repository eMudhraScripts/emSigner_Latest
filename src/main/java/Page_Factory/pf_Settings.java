package Page_Factory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_Settings extends pf_genericmethods {
	//WebDriverWait wait; 
	final static Logger log = Logger.getLogger(pf_Settings.class);

	Basefunctions b = new Basefunctions();
	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-user icon-xs icon-rounded']") public WebElement username;

	@FindBy(how = How.XPATH, using = "//a[text()='Settings']") public WebElement settings; 
	//@FindBy(how = How.ID, using = "frmappSettings") public WebElement settingsPage;
	
	//My Profile  
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[3]/div[1]/a") public WebElement myProfile;
	//save button	
	@FindBy(how = How.ID, using = "btnUpdate") public WebElement saveBtn;
	//Save button message	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'User details')]") public WebElement saveBtnMsg;
	//ok button
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn; 
	//back button
	@FindBy(how = How.ID, using = "btncanceld") WebElement cancelBtn; 
		
	//mandatory fields 
	//Name
	@FindBy(how = How.ID, using = "Name") WebElement name;
	//Organization
	@FindBy(how = How.ID, using = "Organization") WebElement organization;
	//Designation
	@FindBy(how = How.ID, using = "Designation") WebElement designation;
	//Contact_Number
	@FindBy(how = How.ID, using = "Contact_Number") WebElement contact_Number;
	//address-country
	@FindBy(how = How.ID, using = "address-country") WebElement addressCountry;
	//Email
	@FindBy(how = How.ID, using = "Email_Id") WebElement emailIdTxtBox;
	@FindBy(how = How.XPATH, using = "//a[@id='btnmsgok']") public WebElement mandtryMsgokBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmprofile\"]/div[1]/div/h1/a/i") WebElement profileBackBtn;
	//port settings	
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[3]/div[3]/a") public WebElement portSettings;
	@FindBy(how = How.ID, using = "txtdefaultport") WebElement portNumber;
	//change port number
	@FindBy(how = How.ID, using = "txtPortNumber") WebElement changePortNumber;
	//update Btn
	@FindBy(how = How.ID, using = "btnTest") WebElement updateBtn;
	//update btn without entering change port number
	@FindBy(how = How.XPATH, using = "//div[text()='Please enter port number']") public WebElement blnkUpdateMsg;
	//update btn by entering change port number
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'emSigner service started successfully')]") public WebElement UpdateMsg;
	//success message
	@FindBy(how = How.XPATH, using = "//div[text()='Port number updated successfully']") public WebElement successMsg;

	//back button from port settings to settings page
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmsettings\"]/div[1]/div/h1/a/i") public WebElement portBackBtn;

	// Manage AUTHToken
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[7]/div[6]/a") public WebElement manageAuthToken;
	@FindBy(how = How.ID, using = "btngenerateAuthtoken") WebElement generateAuthToken;
	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[2]") public WebElement authToken;
	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[3]") public WebElement createdBy;
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"1\\\"]/td[4]") public WebElement datetime;
	//app name
	@FindBy(how = How.ID, using = "txtApp") WebElement appName;
	//link to privacy
	@FindBy(how = How.ID, using = "txtprivacy") WebElement txtprivacy;
	//link to Term of use
	@FindBy(how = How.ID, using = "txttermsofuse") WebElement txttermsofuse;
	//generate secret key
	@FindBy(how = How.ID, using = "btnSecretkey") WebElement btnSecretkey;
	//add button
	@FindBy(how = How.ID, using = "btnAdd") WebElement btnAdd;
	//toggle search in manage AuthToken
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[2]/div") public WebElement searchAuthToknBtn;
	//app name search
	@FindBy(how = How.ID, using = "gs_AppName") WebElement gs_AppName;
	//clear button
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[1]/div") public WebElement clearAuthToknBtn;
	
	//delete Authtoken
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkDelete\"]/i") WebElement deleteAuthToken;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Are you sure')]") public WebElement deleteTokenMsg;
	
	//edit authToken
	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[7]/ul/li/a/i") WebElement editAuthToken;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'App details')]") WebElement editAuthTokenMsg;
	
	//back button from manage Authtoken to settings page
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[1]/div/h1/a/i") public WebElement manageTtBackBtn;


	// Auto Delegate	
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[3]/div[4]/a") public WebElement autoDelegate;
	@FindBy(how = How.ID, using = "btnCreate") WebElement createDelegate;
	@FindBy(how = How.ID, using = "EmailID") WebElement emailID; 
	@FindBy(how = How.ID, using = "DelegateName") WebElement DelegateName;
	@FindBy(how = How.ID, using = "DelegateStartDate") WebElement DelegateStartDate;
	@FindBy(how = How.ID, using = "DelegateEndDate") WebElement DelegateEndDate;	
	@FindBy(how = How.ID, using = "Reason") WebElement Reason;
	@FindBy(how = How.ID, using = "btnSave") WebElement saveBtnAutoD;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Delegated successfully')]") public WebElement saveBtnAutoDMsg;
	//back button from auto delegate to settings page
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/div[1]/div/div/h1/a/i") public WebElement autoDBackBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Sorry!')]") public WebElement saveBtnAutoDExistMsg;
	
	//Manage adhoc users
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[3]/div[6]/a") public WebElement manageAdhocUsers;
	//@FindBy(how = How.ID, using = "btnAdhocUser") WebElement crteAdhocUser;
	@FindBy(how = How.XPATH, using = "//a[text()='Create New']") WebElement crteAdhocUser;
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmuser\"]/div[3]/section/div/div[3]/div[2]/div[3]/div[2]/a") WebElement createAdhocUserCncl;
	@FindBy(how = How.ID, using = "txtname") WebElement adhocUserName;
	@FindBy(how = How.XPATH, using = "//section[@class='box']/div/div[4]/div/div[2]/input[1]") WebElement saveBtnAdhocUser;
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmuser\"]/div[3]/section/div/div[3]/div[2]/div[3]/div[2]/a") WebElement cancelBtnAdhocUser;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'You’re done! New user')]") public WebElement saveBtnManageUserMsg;
	//search adhoc User
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[2]") WebElement searchAdhocUserBtn;
	//clear adhoc User
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[1]") WebElement clearAdhocUserBtn;
	//search email ID  
	@FindBy(how = How.XPATH, using = "//*[@id=\"gs_Email_Id\"]") WebElement searchAdhocUserEmail;
	//edit adhoc user	
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkModify_\"]/i") WebElement editAdhocUser;
	//edit adhoc user save btn msg	
	@FindBy(how = How.XPATH, using = "//div[text()='User details updated successfully']") public WebElement editAdhocSuccessMsg;
	//delete adhoc user 
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkDelete_\"]/i") WebElement deleteAdhocUser;
	@FindBy(how = How.XPATH, using = "//div[text()='Do you really want to delete ?']") public WebElement deleteAdhocUserMsg;
	//back button from auto delegate to settings page
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[1]/div/div/h1/a/i") public WebElement manageAdhocBackBtn;
	
	
	//validate signed file 
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[3]/div[9]/a") WebElement validateSignedFile;
	//@FindBy(how = How.XPATH, using = "//*[@id=\"stepContent1\"]/section/div[1]/div[2]/div[2]/span[1]/span[2]/input") WebElement selectFile; 
	
	@FindBy(how = How.CSS, using = "#statusdiv input#upload") WebElement selectFile; 
	@FindBy(how = How.ID, using = "Source") WebElement source; 
	//continue button
	@FindBy(how = How.XPATH, using = "//div[@class='button-group text-right']/input") WebElement continueBtn;
	//file name 
	@FindBy(how = How.ID, using = "lbldocument") WebElement fileName; 
	@FindBy(how = How.ID, using = "Pwd") WebElement password; 
	@FindBy(how = How.ID, using = "btnProcess") WebElement validateBtn;
	
	public pf_Settings(WebDriver driver){

		PageFactory.initElements(driver, this);
		//wait=new WebDriverWait(driver,50);
	}


	public void settings() throws Exception {
		cl_click(username);
		cl_click(settings);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Settings link present in Username is clicked- passed");
		log.info("Settings page is displayed");
	}


	public void myProfileNoEdit(String scriptname, String sheetName) throws Exception {
		cl_click(myProfile);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"My Profile present in Settings is clicked- passed");
		try {
		System.out.println("Name is: "+name.getAttribute("value"));
		System.out.println("Organization is: "+organization.getAttribute("value"));
		System.out.println("Designation is: "+designation.getAttribute("value"));
		System.out.println("Contact_Number is: "+contact_Number.getAttribute("value"));
		//System.out.println("AddressCountry is: "+addressCountry.getAttribute("value"));
		System.out.println("Email is: "+emailIdTxtBox.getAttribute("value"));
		System.out.println("Email Field is enabled: "+emailIdTxtBox.isEnabled());
		cl_click(saveBtn);
		log.info("Got the profile information");
		String msg=saveBtnMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Save button present in My Profile is clicked- passed");
		Utility.comparelogic(msg, sheetName, scriptname);	
		}catch(Exception e) {
			cl_click(mandtryMsgokBtn);
			System.out.println("Mandatory field is not filled");
			cl_click(profileBackBtn);
		}

	}


	public void myProfilecnclBtn(String scriptname, String sheetName) throws Exception {
		cl_click(myProfile);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"My Profile present in Settings is clicked- passed");
		cl_click(cancelBtn);
		log.info("Cancel Button is clicked");
		et.log(LogStatus.PASS,"Cancel button present in My Profile is clicked- passed");
		String url=w.getCurrentUrl();
		Utility.comparelogic(url,sheetName,scriptname);

	}

	public void portblankUpdateBtn(String scriptname, String sheetName) throws Exception {
		cl_click(portSettings);
		log.info("Port setting page is displayed");
		et.log(LogStatus.PASS,"Port Settings present in Settings is clicked- passed");
		System.out.println("Port number is: "+portNumber.getAttribute("value"));
		log.info("Port NUmber is: "+portNumber.getAttribute("value"));
		cl_click(updateBtn);
		String msg=blnkUpdateMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Update button present in Port Settings is clicked- passed");
		Utility.comparelogic(msg, sheetName, scriptname);		
	}

	public void portUpdateBtn(String scriptname, String sheetName) throws Exception {
		try {
		String portNumber=Utility.getpropertydetails("portNumber");
		log.info("New port Number is: "+portNumber);
		cl_entertext(changePortNumber, portNumber);
		et.log(LogStatus.PASS,"Port number is entered in change port number textbox- passed");
		cl_click(updateBtn);
		log.info("New port Number is updated");
		String msg=UpdateMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Update button is clicked after entering change port number- passed");
		Utility.comparelogic(msg, sheetName, scriptname);
		}catch(Exception e) {
			System.out.println("emsigner is working in different port number");
			Thread.sleep(2000);
			cl_click(okBtn);
			cl_click(portBackBtn);
			Thread.sleep(2000);
			log.info("Settings Page is displayed");
		}
	}


	public void portUpdateBtnsuccess(String scriptname, String sheetName) throws Exception {
		try {
		String msg=successMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(msg, sheetName, scriptname);		
		cl_click(portBackBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Back button present in Port Settings is clicked- passed");
		log.info("Settings Page is displayed");
		}catch(Exception e) {
			cl_click(okBtn);
			cl_click(portBackBtn);
			Thread.sleep(2000);
			log.info("Settings Page is displayed");
		}
		
	}


	public void generateToken() throws Exception {
		cl_click(manageAuthToken);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Manage AuthToken present in Admin Settings is clicked- passed");
		log.info("Manage AuthToken Page is displayed");
		cl_click(generateAuthToken);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Generate AuthToken is clicked- passed");
		log.info("AuthToken is generated");
		String name=Utility.getpropertydetails("ManageAuthAppName");
		cl_entertext(appName, name);
		et.log(LogStatus.PASS,"App name is entered- passed");
		String privacy=Utility.getpropertydetails("ManageAuthPrivacy");
		cl_entertext(txtprivacy, privacy);
		et.log(LogStatus.PASS,"Privacy is entered- passed");
		String termOfUse=Utility.getpropertydetails("ManageAuthTermOfUse");
		cl_entertext(txttermsofuse, termOfUse);
		et.log(LogStatus.PASS,"Term of use is entered- passed");
		cl_click(btnAdd);
		Thread.sleep(2000);
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Add button is clicked without generating secret key- passed");
		System.out.println("created AuthToken is: "+authToken.getText());
		System.out.println("created By: "+createdBy.getText());
		
		cl_click(generateAuthToken);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Generate AuthToken is clicked- passed");
		log.info("AuthToken is generated");
		cl_entertext(appName, name);
		et.log(LogStatus.PASS,"App name is entered- passed");
		cl_entertext(txtprivacy, privacy);	
		et.log(LogStatus.PASS,"Privacy is entered- passed");
		cl_entertext(txttermsofuse, termOfUse);
		et.log(LogStatus.PASS,"Term of use is entered- passed");
		cl_click(btnSecretkey);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Generate secret key button is clicked- passed");
		cl_click(btnAdd);
		Thread.sleep(2000);
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Add button is clicked by generating secret key- passed");
		System.out.println("created AuthToken is: "+authToken.getText());
		System.out.println("created By: "+createdBy.getText());
	}

	public void editAuthToken1(String scriptname, String sheetName) throws Exception {
		
		cl_click(searchAuthToknBtn);
		log.info("Toggle search button is clicked");
		et.log(LogStatus.PASS,"Search Authtoken button is clicked- passed");
		String name=Utility.getpropertydetails("ManageAuthAppName");
		cl_entertext(gs_AppName, name);
		Thread.sleep(2000);
		cl_click(clearAuthToknBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Clear Authtoken button is clicked- passed");
		cl_click(searchAuthToknBtn);
		cl_click(editAuthToken);
		log.info("Edit AuthToken");
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Edit Authtoken button is clicked- passed");
		cl_click(btnSecretkey);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Generate secret key button is clicked- passed");
		cl_click(saveBtn);
		String msg=editAuthTokenMsg.getText();
		Thread.sleep(1000);
		System.out.println(msg);
		cl_click(mandtryMsgokBtn);
		et.log(LogStatus.PASS,"Apply changes button is clicked- passed");
		Utility.comparelogic(msg, sheetName, scriptname);	
		Thread.sleep(2000);
		cl_click(manageTtBackBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Back button to settings page is clicked- passed");
		log.info("Settings Page is displayed");
	}
	
	public void deleteAuthToken(String scriptname, String sheetName) throws Exception {		
		cl_click(deleteAuthToken);
		log.info("AuthToken is deleted");
		String msg=deleteTokenMsg.getText();
		Utility.comparelogic(msg, sheetName, scriptname);	
		cl_click(okBtn);
		Thread.sleep(2000);
		cl_click(manageTtBackBtn);
		Thread.sleep(2000);
		log.info("Settings Page is displayed");
	}


	public void createAutoD() throws Exception {
		cl_click(autoDelegate);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Auto Delegate present in Settings is clicked- passed");
		log.info("Auto Delegate Page is displayed");
		cl_click(createDelegate);
		et.log(LogStatus.PASS,"Create Delegate button is clicked- passed");
		cl_click(cancelBtn);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Cancel button is clicked- passed");
		try {
		cl_click(createDelegate);
		et.log(LogStatus.PASS,"Create Delegate button is clicked- passed");
		String email=Utility.getpropertydetails("AutoDelegateEmailID");
		cl_entertext(emailID, email);
		et.log(LogStatus.PASS,"EmailID is entered- passed");
		String name=Utility.getpropertydetails("AutoDelegateName");
		cl_entertext(DelegateName, name);
		et.log(LogStatus.PASS,"Name is entered- passed");
		String startDate=Utility.getpropertydetails("AutoDelegateStartDate");
		((JavascriptExecutor)w).executeScript("document.getElementById('DelegateStartDate').setAttribute('value','"+startDate+"')");
		et.log(LogStatus.PASS,"Start Date is entered- passed");
		String endDate=Utility.getpropertydetails("AutoDelegateEndDate");
		((JavascriptExecutor)w).executeScript("document.getElementById('DelegateEndDate').setAttribute('value','"+endDate+"')");
		et.log(LogStatus.PASS,"End Date is entered- passed");
		Thread.sleep(2000);
		String reason=Utility.getpropertydetails("AutoDelegateReason");
		cl_entertext(Reason, reason);
		et.log(LogStatus.PASS,"Reason is entered- passed");
		cl_click(saveBtnAutoD);
		System.out.println("AutoDelegate successfull creation: "+saveBtnAutoDMsg.getText());
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Save button is clicked- passed");
		log.info("Auto Delegate is created");
		}catch(Exception e) {
			
			System.out.println("Already exist Message: "+saveBtnAutoDExistMsg.getText());
			et.log(LogStatus.PASS,"Aleady Exist- passed");
			cl_click(mandtryMsgokBtn);
			Thread.sleep(2000);
			cl_click(cancelBtn);
			Thread.sleep(2000);
		}
		cl_click(autoDBackBtn);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Back button to settings page is clicked- passed");
		log.info("Settings Page is displayed");
	}


	public void createAdhocUser() throws Exception {
		cl_click(manageAdhocUsers);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Adhoc User present in Settings is clicked- passed");
		log.info("Manage Adhoc Users Page is displayed");
		cl_click(crteAdhocUser);
		et.log(LogStatus.PASS,"Create Adhoc User button is clicked- passed");
		Thread.sleep(3000);
		cl_click(createAdhocUserCncl);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Cancel button is clicked- passed");
		cl_click(crteAdhocUser);
		et.log(LogStatus.PASS,"Create Adhoc user button is clicked- passed");
		String adhocUser=Utility.getpropertydetails("ManageAhocUserName");
		cl_entertext(adhocUserName, adhocUser);
		et.log(LogStatus.PASS,"Name is entered- passed");
		String email=Utility.getpropertydetails("ManageAhocUserEmailID");
		cl_entertext(emailIdTxtBox, email);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Email is entered- passed");
		//cl_click(saveBtnAdhocUser);
		try {
		cl_click(saveBtnAdhocUser);
		Thread.sleep(2000);
		log.info("Manage Adhoc User is created");
		System.out.println("Manage Adhoc user is created: "+saveBtnManageUserMsg.getText());
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Save button is clicked- passed");
		Thread.sleep(1000);
		}
		catch(Exception e) {
			cl_click(cancelBtnAdhocUser);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Cancel button is clicked- passed");
		}
	}


	public void editAdhocUser(String scriptname, String sheetName) throws Exception {
		cl_click(searchAdhocUserBtn);
		et.log(LogStatus.PASS,"Search button is clicked- passed");
		String email=Utility.getpropertydetails("ManageAhocUserEmailID");
		try {
		cl_entertext(searchAdhocUserEmail, email);
		log.info("Search Adhoc Users: "+email);
		et.log(LogStatus.PASS,"Searched user with emailId- passed");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		cl_click(editAdhocUser);
		et.log(LogStatus.PASS,"Edit button is clicked- passed");
		cl_click(saveBtn);
		String msg=editAdhocSuccessMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Save button is clicked after editing- passed");
		Utility.comparelogic(msg,sheetName,scriptname);	
		log.info("Adhoc User is edited");
		}catch(Exception e) {
			Thread.sleep(2000);
			cl_click(clearAdhocUserBtn);
			et.log(LogStatus.PASS,"Clear button is clicked- passed");
			Thread.sleep(2000);
			cl_click(searchAdhocUserBtn);
			et.log(LogStatus.PASS,"Search button is clicked- passed");
			System.out.println("Searched Adhoc user is not present");
		}
	}


	public void deleteAdhocUser(String scriptname, String sheetName) throws Exception {
		cl_click(searchAdhocUserBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Search button is clicked- passed");
		String email=Utility.getpropertydetails("ManageAhocUserEmailID");
		try {
		cl_entertext(searchAdhocUserEmail, email);
		et.log(LogStatus.PASS,"Searched user with emailId- passed");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		cl_click(deleteAdhocUser);
		String msg=deleteAdhocUserMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Delete button is clicked- passed");
		Utility.comparelogic(msg,sheetName,scriptname);
		Thread.sleep(2000);
		log.info("Adhoc User is deleted");
		}catch(Exception e) {
			System.out.println("Searched Adhoc user is not present");
			et.log(LogStatus.PASS,"Searched user is not present- passed");
		}
		cl_click(manageAdhocBackBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Back button to settings page is clicked- passed");
		log.info("Settings Page is displayed");
		
	}


	public void validateFile(String file,WebDriver driver) throws Exception {
		cl_click(validateSignedFile);
		Thread.sleep(3000);
//		cl_click(okBtn);
		JavascriptExecutor executor = (JavascriptExecutor)w;
		executor.executeScript("arguments[0].click();", selectFile);
//		
//		((JavascriptExecutor)w).executeScript("document.getElementById('source').setAttribute('value','"+file+"')");
//		Actions a=new Actions(driver);
//		String file1=Utility.getpropertydetails("SignedFile");
//		a.moveToElement(selectFile).click().sendKeys(file1);
//		Actions actions = new Actions(driver);
//
//		actions.moveToElement(selectFile).click().build().perform();
//		cl_click(selectFile);
//		cl_entertext(selectFile, file);
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\validfile.exe");
//		//log.info("Source folder path is passed successfully");
//		Thread.sleep(10000);
//		cl_click(continueBtn);
//		Thread.sleep(3000);
//		System.out.println("Name of the Signed file: "+fileName.getText());
		
	}
}
