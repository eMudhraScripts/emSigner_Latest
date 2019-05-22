package Page_Factory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_AdminSettings extends pf_genericmethods {
	Basefunctions b = new Basefunctions();
	final static Logger log = Logger.getLogger(pf_AdminSettings.class);

	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-user icon-xs icon-rounded']") public WebElement username;

	@FindBy(how = How.XPATH, using = "//a[text()='Settings']") public WebElement settings;

	//Manage Department
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[7]/div[2]/a") public WebElement manageDept;

	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[5]/section/header/div/a") public WebElement createNewDept; 

	@FindBy(how = How.ID, using = "btnSaveDepartment") public WebElement saveBtn;
	@FindBy(how = How.XPATH, using = "//div[text()='Department Name is required.']") public WebElement withoutDeptSaveBtn;
	@FindBy(how = How.ID, using = "btncancel") public WebElement cancelBtn;
	@FindBy(how = How.ID, using = "txtDeptName") public WebElement txtDeptName;
	//success msg when dept is created
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'You are Done')]") public WebElement deptCreatedMsg;
	//ok button
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;

	@FindBy(how = How.ID, using = "btnSaveAccess") WebElement WFsaveBtn;
	//without selecting workflow,click on save button
	@FindBy(how = How.XPATH, using = "//div[text()='Please select WorkFlow']") public WebElement withoutWFSaveBtn;

	//@FindAll({@FindBy(how = How.XPATH, using = "//*[@id=\"jstree\"]")}) public List <WebElement> WFSearchList;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='jstree']/ul/li")}) public List<WebElement> WFSearchList;
	@FindBy(how = How.XPATH, using = "//*[@id=\"li_412_anchor\"]") WebElement workflowselection;
	//String workflowlist = "//div[@id='jstree']/ul/li[#DELIM#]/a";
	String wflist = "//section[@class='box']/div/div/div/div[3]/div/ul/li[#DELIM#]/a/i[1]";

	String Userwflist = "//section[@class='box']/div/div/div/div/div[4]/div/ul/li[#DELIM#]/a/i[1]";
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[2]") public WebElement searchBtn;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Access rights successfully')]") public WebElement WFSuccessMsg;

	//search with DepartmentName
	@FindBy(how = How.ID, using = "gs_DepartmentName") WebElement searchDepartmentName;
	//Edit department
	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[3]/ul/li[2]/a/i") public WebElement editDeptBtn;
	//edit dept- save button without changing the dept name  
	@FindBy(how = How.XPATH, using = "//div[text()='Department already exists']") public WebElement withoutEditSaveBtn;
	//edit dept- save button by changing the dept name
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Department details')]") public WebElement editSaveBtnMsg;
	//delete department   
	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[3]/ul/li[1]/a/i") public WebElement deleteDeptBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Are you sure')]") public WebElement deleteDeptMsg;
	//back button from maange department to settings page  
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[1]/div/div/h1/a/i") public WebElement manageDeptBackBtn;
	//Manage Users

	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[7]/div[3]/a") public WebElement manageUsers;

	@FindBy(how = How.ID, using = "btnCreateUser") WebElement createManageUser; 
	@FindBy(how = How.ID, using = "txtname") WebElement manageUserName; 
	@FindBy(how = How.ID, using = "Email_Id") WebElement manageUserEmailID; 
	@FindBy(how = How.ID, using = "Designation") WebElement manageUserDesignation; 
	@FindBy(how = How.ID, using = "Organization") WebElement manageUserOrganization; 
	@FindBy(how = How.ID, using = "DeptId") WebElement manageUserDeptId; 
	@FindBy(how = How.ID, using = "SignatureType") WebElement manageUserSignatureType; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"btnSave\"]") WebElement manageUserSaveBtn;
	//workflow success message	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'You are done! Access rights')]") public WebElement wfSuccessBtnMsg;
	//search user
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[2]") public WebElement searchUser;
	//search user name 
	@FindBy(how = How.ID, using = "gs_Name") WebElement searchUsername;
	//edit user
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkModify_\"]/i") public WebElement editUser;
	//edit user Save button
	@FindBy(how = How.ID, using = "btnUpdate") WebElement editUserSaveBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'User details updated')]") public WebElement editUserSaveBtnMsg;
	//delete user	
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkDelete_\"]/i") public WebElement deleteUser;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Do you really')]") public WebElement deleteUserMsg;
	//back button from maange user to settings page  
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[1]/div/div/h1/a/i") public WebElement manageUserBackBtn;
	@FindBy(how = How.ID, using = "msgcontent") WebElement createNewUserMsg;
	@FindBy(how = How.ID, using = "btnmsgcancel") WebElement btnmsgcancel;


	//Manage Workflows webelements

	@FindBy(how = How.ID, using = "btnaddgroup") public WebElement createNewWf;
	@FindBy(how = How.ID, using = "VerticalName") public WebElement wrkflowName;
	@FindBy(how = How.ID, using = "btnSaveVertical") public WebElement wrkflowNameSaveBtn;
	String wfselection1 = "//section[@class='box']/div/div[2]/div[3]/div/ul/li/a[text()='#DELIM#']";
	String wfSubselection = "//section[@class='box']/div/div[2]/div[3]/div/ul/li/a[text()='aa']/following-sibling::ul/li/a";
	@FindBy(how = How.ID, using = "btnpdfupload") public WebElement btnpdfupload;
	@FindBy(how = How.XPATH, using = "//div[@id='powerformDocuments']/ul/a/span") public WebElement createNewWfAddSign;
	@FindBy(how = How.XPATH, using = "//div[@class='documentContainment']/div/div") public WebElement signtr;
	@FindBy(how = How.XPATH, using = "//*[@id=\"sp_config_1\"]/i") public WebElement signSettng;
	//assigned to
	@FindBy(how = How.ID, using = "ddlSPSignatory") public WebElement asignSignTo;
	@FindBy(how = How.ID, using = "ddlPageSelection") public WebElement selectPage;


	@FindBy(how = How.XPATH, using = "//form[@id = 'frmappSettings']/div/div[7]/div[4]/a") public WebElement manageworkflows;
	@FindAll({@FindBy(how = How.XPATH, using = "//section[@class='box']/div/div[2]/div[3]/div/ul/li")}) public List<WebElement> workflowscount;
	String wfselection = "//section[@class='box']/div/div[2]/div[3]/div/ul/li[#DELIM#]/a/i";
	@FindBy(how = How.ID, using = "btnStep1Continue") public WebElement setupformtemplate;
	@FindBy(how = How.ID, using = "sample") public WebElement uploadpdf;

	@FindBy(how = How.ID, using = "btnpdfupload") public WebElement uploadpdf1;
	@FindBy(how = How.ID, using = "statusdiv") public WebElement uploadpdOverride;

	@FindBy(how = How.ID, using = "btnStep2Continue") public WebElement pdfsubmit;
	@FindBy(how = How.ID, using = "draggableDiv_1_1") public WebElement signatorybox;
	@FindBy(how = How.ID, using = "btnprofilesave") public WebElement activateworkflow;
	@FindAll({@FindBy(how= How.XPATH, using = "//div[@id='departmentaccess']/div/div/div[2]/div[2]/ul/li")}) public List<WebElement> Deptlist;
	String dpselection = "//div[@id='departmentaccess']/div/div/div[2]/div[2]/ul/li[#DELIM#]/input";
	@FindBy(how = How.ID, using = "btnSaveDepartments") public WebElement savebutn;
	@FindBy(how = How.XPATH, using = "//div[@class='alertWindow']/div[2]/div[2]/a") public WebElement okbutn;

	//create activity
	@FindBy(how = How.ID, using = "CreateVertical") public WebElement createActivity;
	//Rename
	@FindBy(how = How.ID, using = "RenameVertical") public WebElement renameWf;
	//Remove
	@FindBy(how = How.ID, using = "DeleteVertical") public WebElement removeWf;
	//bulk delete
	@FindBy(how = How.ID, using = "btnBulkDelet") public WebElement btnBulkDelet;
	//bulk delete msg
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Documents deleted')]") public WebElement btnBulkDeletmsg;


	// Flexiform elements 

	@FindBy(how = How.ID, using = "btnPowerFrom") public WebElement flexi;
	@FindBy(how = How.CLASS_NAME, using = "editContent") public WebElement confirmationpopup;
	@FindBy(how = How.XPATH, using = "//*[@id=\"btnModify\"]") public WebElement modify;
	@FindBy(how = How.XPATH, using = "//*[@id=\"btnOverride\"]") public WebElement override;
	@FindBy(how = How.XPATH, using = "//*[@id=\"btnEditPopmsgcancel\"]") public WebElement flexicancel;
	@FindBy(how = How.ID, using = "divworkflowname") public WebElement divworkflowname;
	@FindBy(how = How.ID, using = "btnClose") public WebElement btnClose;

	//Modify Flexiform elements

	@FindBy(how = How.ID, using = "addSignatory_1") public WebElement addsignatory;
	@FindBy(how = How.XPATH, using = "//*[@id=\"spanSignature\"]") public WebElement signbox;
	//		@FindBy(how = How.XPATH, using = "//form[@id='frmPowerform']/div[1]/section/div[2]/div/div/input") public WebElement activateflexiform;
	@FindBy(how = How.XPATH, using = "//*[@id=\"btnActivateWorkflow\"]") public WebElement activateflexiform;
	@FindAll({@FindBy(how = How.XPATH, using = "//section[@id='main-content']/div/div[2]/div/div[2]/div/div/ul/ul/li")}) public List<WebElement> signcount;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='singerContainer']/div/div/div/div/div")}) public List<WebElement> containercount;
	String boxvalue = "//div[@id='singerContainer']/div/div/div/div/div[#DELIM#]/span";
	String boxvalue1 = "//div[@id='singerContainer']/div/div/div/div/div[#DELIM#]";
	String boxsettings = "//div[@id='singerContainer']/div/div/div/div/div[#DELIM#]/div[1]/a[1]/i";
	@FindBy(how = How.ID, using ="ddlSPSignatory") public WebElement assignsignatory;
	@FindBy(how = How.ID, using = "btnConfigSave") public WebElement applybtn;
	@FindBy(how = How.ID, using = "btnConfigCancel") public WebElement cnclbtn;


	// Overide flexiform elements

	@FindBy(how = How.XPATH, using = "//form[@id='frmPowerform']/div[1]/div/ul/li") public WebElement uploaddocuments;
	//		@FindBy(how = How.ID, using = "statusdiv") public WebElement uploaddocuments;
	@FindBy(how = How.XPATH, using = "//div[@class='alertContent']/div[2]/a") public WebElement popupokbtn;
	@FindBy(how = How.XPATH, using = "//form[@id='frmPowerform']/div[1]/div/div/div/div[12]") public WebElement signbox1;
	@FindAll({@FindBy(how = How.XPATH, using = "//form[@id='frmPowerform']/div[1]/div/div/div/div")}) public List<WebElement> boxcount;
	@FindBy(how = How.ID, using = "signerContainment") public WebElement signercontainment;

	//back button from maange wf to settings page  
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[1]/div/div/h1/a/i") public WebElement manageWfBackBtn;
	//subscription

	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[7]/div[1]/a") public WebElement subscription;
	//subscription On
	@FindBy(how = How.XPATH, using = "//table[@id='ProfileTable']/tbody/tr/td[2]") public WebElement subscriptionOn;
	//Plan type
	@FindBy(how = How.XPATH, using = "//table[@id='ProfileTable']/tbody/tr/td[4]") public WebElement planType;
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/div/section/div/section/div/div[1]/h3") public WebElement expireMSg;
	//renew button 
	@FindBy(how = How.ID, using = "btnrenew") public WebElement renewBtn;
	//upgrade plan 
	@FindBy(how = How.ID, using = "butUpgrade") public WebElement upgradePlanBtn;
	//subscription details back button  
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/div/h2/a/i") public WebElement subDetailsBckBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Captcha\"]") public WebElement captcha; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"imgCaptcha\"]") public WebElement imgcaptcha;
	//purchase button  
	@FindBy(how = How.ID, using = "btnPurchase") public WebElement purchaseBtn;


	@FindBy(how = How.XPATH, using = "//*[@id=\"btnAdvrs1\"]") public WebElement advncdUpgradeBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"btnPrors1\"]") public WebElement professionalUpgradeBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"btnEssdlr\"]") public WebElement essentialUpgradeBtn;


	//Activity log
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[7]/div[9]/a") public WebElement activityLog;

	@FindBy(how = How.ID, using = "btnExport") public WebElement exportToExcelBtn;
	//back button from activity log to settings page  
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[1]/div/div/h1/a/i") public WebElement activityLogBckBtn;


	//Custom Status
	@FindBy(how = How.XPATH, using = "//form[@id = 'frmappSettings']/div/div[7]/div[10]/a") public WebElement customStatus;
	@FindBy(how = How.XPATH, using = "//form[@id='frmprofile']/div[3]/section/div/div/div/div[1]/div[2]//div[3]/a") public WebElement customStatusCancl;
	@FindBy(how = How.XPATH, using = "//form[@id='frmprofile']/div[3]/section/div/div/div/div/div[2]/div[3]/input[1]") public WebElement customStatusSave;
	@FindBy(how = How.XPATH, using = "//form[@id='frmprofile']/div[3]/section/div/div/div/div/div[2]/div[3]/input[2]") public WebElement customStatusUpdte;
	@FindBy(how = How.ID, using = "txtstatus") public WebElement txtstatus;
	@FindBy(how = How.ID, using = "msgcontent") public WebElement CSmsgcontent;
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[1]/div") public WebElement CSClear;
	@FindBy(how = How.XPATH, using = "//*[@id=\"pager_left\"]/table/tbody/tr/td[2]/div") public WebElement CStggleSearch;
	@FindBy(how = How.XPATH, using = "//table[@id='CustomGrid']/tbody/tr[2]/td[8]/ul/li[1]/a") public WebElement deleteCSBtn;
	@FindBy(how = How.XPATH, using = "//table[@id='CustomGrid']/tbody/tr[2]/td[8]/ul/li[2]/a") public WebElement editCSBtn;
	@FindBy(how = How.ID, using = "gs_Description") public WebElement gs_Description;
	@FindBy(how = How.XPATH, using = "//form[@id='frmprofile']/div/div/h1/a/i") public WebElement CSBAckBtn;

	//advance settings
	@FindBy(how = How.XPATH, using = "//form[@id = 'frmappSettings']/div/div[7]/div[11]/a") public WebElement advceSettings;
	@FindBy(how = How.ID, using = "btnAdd") public WebElement ASbtnAdd;
	@FindBy(how = How.ID, using = "txtdesc") public WebElement AStxtdesc;
	@FindBy(how = How.ID, using = "gs_Options") public WebElement ASgs_Options;
	@FindBy(how = How.ID, using = "dllOption") public WebElement ASdllOption;
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkModify_\"]/i") public WebElement ASEditBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkDelete_\"]/i") public WebElement ASDeleteBtn;
	@FindBy(how = How.ID, using = "btnUpdate") public WebElement btnUpdate;
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/div[1]/div/h1/a/i") public WebElement ASBAckBtn;

	@FindBy(how = How.ID, using = "spanTextbox") public WebElement spanTextbox;
	@FindBy(how = How.ID, using = "ddlTxtSignatory") public WebElement ddlTxtSignatory;
	@FindBy(how = How.ID, using = "txtTagName") public WebElement txtTagName;
	@FindBy(how = How.XPATH, using = "//div[@class='documentContainment']/div/div[2]") public WebElement textBox1;
	@FindBy(how = How.XPATH, using = "//div[@class='documentContainment']/div/div[3]") public WebElement textBox2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"txt_config_2\"]/i") public WebElement TxtsignSettng;
	@FindBy(how = How.XPATH, using = "//div[@class='documentContainment']/div/div[3]/div/a/i") public WebElement Txt2signSettng;
	
	public pf_AdminSettings(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void settings() throws Exception {
		cl_click(username);
		cl_click(settings);
		Thread.sleep(1000);

	}

	public void manageDeptcnclBtn(String scriptname, String sheetName) throws Exception {
		cl_click(manageDept);
		log.info("Manage Department page");
		Thread.sleep(1000);
		cl_click(createNewDept);
		cl_click(cancelBtn);
		String url=w.getCurrentUrl();
		log.info("URL found when cancel button is clicked: "+url);
		Utility.comparelogic(url,sheetName,scriptname);

	}

	public void saveBtnWithoutDept(String scriptname, String sheetName) throws Exception {
		cl_click(createNewDept);
		cl_click(saveBtn);
		String msg=withoutDeptSaveBtn.getText();
		Utility.comparelogic(msg,sheetName,scriptname);
		cl_click(okBtn);
		String deptName=Utility.getpropertydetails("ManageDepartmentName");
		cl_entertext(txtDeptName, deptName);
		cl_click(saveBtn);
		String exp="You are Done! New Department "+deptName+" successfully created";
		System.out.println("Manage Department creation message: "+exp);
		log.info("Manage dept is created"+exp);
		cl_click(okBtn);
		Thread.sleep(5000);

	}

	public void saveBtnWithoutWF(String scriptname, String sheetName) throws Exception {
		/*cl_click(WFsaveBtn);
		Thread.sleep(1000);
		String msg=withoutWFSaveBtn.getText();
		Utility.comparelogic(msg,sheetName,scriptname);
		cl_click(okBtn);
		Thread.sleep(3000);*/

		//		Work flows list check


		Random r = new Random();
		int randomValue = r.nextInt(WFSearchList.size());
		cl_click(b.w.findElement(By.xpath(wflist.replace("#DELIM#",String.valueOf(randomValue)))));
		System.out.println("randomValue" +randomValue);
		//WFSearchList.get(randomValue).click();
		Thread.sleep(2000);
		log.info("Manage Dept-Random workflow is selected");
		cl_click(WFsaveBtn);
		Thread.sleep(2000);
		String msg=WFSuccessMsg.getText();
		System.out.println("Workflow success message: "+msg);
		cl_click(okBtn);		
	}

	public void withoutEditSaveBtn(String scriptname, String sheetName) throws Exception {
		cl_click(searchBtn);
		String deptName=Utility.getpropertydetails("ManageDepartmentName");
		cl_entertext(searchDepartmentName, deptName);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		cl_click(editDeptBtn);
		cl_click(saveBtn);
		String msg=withoutEditSaveBtn.getText();
		Utility.comparelogic(msg,sheetName,scriptname);
		cl_click(okBtn);
	}

	public void changeDNameSaveBtn(String scriptname, String sheetName) throws Exception {
		txtDeptName.clear();
		String changeDname=Utility.getpropertydetails("ChangeManageDepartmentName");
		cl_entertext(txtDeptName, changeDname);
		cl_click(saveBtn);
		String msg=editSaveBtnMsg.getText();
		Utility.comparelogic(msg,sheetName,scriptname);
		cl_click(okBtn);		
	}

	public void deleteDeptBtn(String scriptname, String sheetName) throws Exception {
		cl_click(searchBtn);
		String deptName=Utility.getpropertydetails("ChangeManageDepartmentName");
		cl_entertext(searchDepartmentName, deptName);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		cl_click(deleteDeptBtn);
		String msg=deleteDeptMsg.getText();
		Utility.comparelogic(msg,sheetName,scriptname);
		cl_click(okBtn);
		Thread.sleep(2000);
		log.info("Manage department is deleted");
		cl_click(manageDeptBackBtn);
		log.info("Settings page is displayed");

	}


	public void createNewUser(String scriptname,String sheetname) throws Exception {
		cl_click(manageUsers);
		log.info("--Manage users page--");
		cl_click(createManageUser);
		try {
			String username=Utility.getpropertydetails("ManageUserName");
			cl_entertext(manageUserName, username);
			try {
				Select s=new Select(manageUserDeptId);
				s.selectByIndex(2);

//				Select s1=new Select(manageUserSignatureType);
//				s1.selectByIndex(2);
//				Thread.sleep(2000);
//				System.out.println(manageUserEmailID.isDisplayed());
				String userEmail=Utility.getpropertydetails("ManageUserEmail");
				cl_entertext(manageUserEmailID, userEmail);
				Thread.sleep(1000);
				String userComp=Utility.getpropertydetails("ManageUserCompany");
				cl_entertext(manageUserOrganization, userComp);
				Thread.sleep(1000);
				String userDesignation=Utility.getpropertydetails("ManageUserDesignation");
				cl_entertext(manageUserDesignation, userDesignation);
				Thread.sleep(2000);
				cl_click(manageUserSaveBtn);
				Thread.sleep(2000);
				String exp="You’re done! New user "+username+" successfully created";
				System.out.println("Manage Department creation message: "+exp);
				cl_click(okBtn);
				Thread.sleep(5000);

				Random r = new Random();
				int randomValue = r.nextInt(WFSearchList.size());
				cl_click(b.w.findElement(By.xpath(Userwflist.replace("#DELIM#",String.valueOf(randomValue)))));
				System.out.println("randomValue" +randomValue);
				//WFSearchList.get(randomValue).click();
				Thread.sleep(2000);
				log.info("Manage User-Random workflow is selected");
				cl_click(WFsaveBtn);
				Thread.sleep(2000);
				String msg= wfSuccessBtnMsg.getText();
				Utility.comparelogic(msg,sheetname,scriptname);
				cl_click(okBtn);
				Thread.sleep(2000);
				log.info("Manage User is created");
			}catch(Exception e) {
				System.out.println("Atleast one dept should be there");
				b.getScreenshot();
				cl_click(okBtn);
				cl_click(cancelBtn);
				cl_click(manageDeptBackBtn);
				log.info("Settings page is displayed");
				cl_click(manageUsers);
			}
		}catch(Exception e) {
			String msg=createNewUserMsg.getText();
			System.out.println("Create user msg: "+msg);
			cl_click(btnmsgcancel);
			Thread.sleep(2000);
			cl_click(manageDeptBackBtn);
			Thread.sleep(2000);
			log.info("Settings page is displayed");
		}
	}

	public void editsaveBtnUser(String scriptname, String sheetName) throws Exception {
		cl_click(searchUser);
		log.info("Search user to edit");
		String userName=Utility.getpropertydetails("ManageUserName");
		try {
			cl_entertext(searchUsername, userName);
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			cl_click(editUser);
			cl_click(editUserSaveBtn);
			String msg=editUserSaveBtnMsg.getText();
			Utility.comparelogic(msg,sheetName,scriptname);
			cl_click(okBtn);
		}catch(Exception e) {
			System.out.println("Searched user is not present");
		}

	}

	public void deleteuser(String scriptname, String sheetName) throws Exception {
		cl_click(searchUser);
		log.info("Search user to delete");
		String userName=Utility.getpropertydetails("ManageUserName");
		try {
			cl_entertext(searchUsername, userName);
			log.info("Searched Manage User:"+username);
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			cl_click(deleteUser);
			String msg=deleteUserMsg.getText();
			Utility.comparelogic(msg,sheetName,scriptname);
			cl_click(okBtn);
			Thread.sleep(2000);
			log.info("Deleted the Manage User");
			cl_click(manageUserBackBtn);
			log.info("Settings page is displayed");
		}catch(Exception e) {
			System.out.println("Searched user is not present");
			cl_click(manageUserBackBtn);
		}
	}

	public void create_manage_workflows(String wfname) throws Exception {
		et =  es.startTest("Create Workflow");
		Actions a = new Actions(w);
		cl_click(manageworkflows);
		log.info("Manage workflow Page is displayed");
		et.log(LogStatus.PASS,"Manage workflow is clicked- passed");
		cl_click(createNewWf);
		et.log(LogStatus.PASS,"Create new workflow is clicked- passed");
		cl_entertext(wrkflowName, wfname);
		try {
			cl_click(wrkflowNameSaveBtn);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Save button is clicked- passed");
			cl_click(okBtn);
			WebElement wf = b.w.findElement(By.xpath(wfselection1.replace("#DELIM#",String.valueOf(wfname))));
			JavascriptExecutor js = (JavascriptExecutor)w;
			js.executeScript("arguments[0].scrollIntoView();",wf);
			cl_click(wf);
			Thread.sleep(3000);
			et.log(LogStatus.PASS,"Created workflow is selected- passed");
			cl_click(flexi);
			Thread.sleep(3000);
			et.log(LogStatus.PASS,"Flexiform button is clicked- passed");
			String pdf=Utility.getpropertydetails("WrkPDF");
			cl_entertext(btnpdfupload, pdf);
			Thread.sleep(8000);
			et.log(LogStatus.PASS,"PDF is uploaded- passed");
			cl_click(createNewWfAddSign);
			et.log(LogStatus.PASS,"Add signatory is clicked- passed");
			a.dragAndDropBy(signbox, 348,11).build().perform();
			//		a.dragAndDrop(signbox,signercontainment).build().perform();;
			Thread.sleep(7000);
			a.moveToElement(signtr).build().perform();
			cl_click(signSettng);
			Thread.sleep(3000);
			cl_click(asignSignTo);
			Select s=new Select(asignSignTo);
			s.selectByIndex(1);
			Thread.sleep(2000);
			Select s1=new Select(selectPage);
			s1.selectByIndex(3);
			cl_click(applybtn);
			Thread.sleep(2000);
			cl_click(activateflexiform);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Activate Flexiform is clicked- passed");
			log.info("Activate Flexiform is clicked");
			cl_click(popupokbtn);
			et.log(LogStatus.PASS,"Popup ok button is clicked- passed");
		}catch(Exception e) {
			System.out.println("Message: "+divworkflowname.getText());
			cl_click(btnClose);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Workflow name already exists.message- passed");		
		}

	}

	public void manage_workflows() throws Exception {
		cl_click(username);
		cl_click(settings);
		Thread.sleep(1000);
		Actions a = new Actions(w);
		cl_click(manageworkflows);
		log.info("Manage workflow Page is displayed");
		et.log(LogStatus.PASS,"Manage workflow is clicked- passed");
		String wfname=Utility.getpropertydetails("WorkflowName");
		WebElement wf = b.w.findElement(By.xpath(wfselection1.replace("#DELIM#",String.valueOf(wfname))));
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",wf);
		cl_click(wf);	
		Thread.sleep(3000);
		cl_click(setupformtemplate);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Setup Form Template is clicked- passed");
		String file=Utility.getpropertydetails("PDF");
		cl_entertext(uploadpdf1, file);
		Thread.sleep(4000);
		log.info("PDF is uploaded");
		cl_click(pdfsubmit);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"PDF is submitted- passed");
		a.dragAndDrop(signatorybox, signercontainment).build().perform();
		cl_click(activateworkflow);
		Thread.sleep(3000);
		log.info("Activate workflow button is clicked");
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Activate Flexiform is clicked- passed");
		cl_click(savebutn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Save button is clicked- passed");
		cl_click(okbutn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Popup ok button is clicked- passed");
	}

	public void manage_workflowsActivity() throws Exception {
		cl_click(username);
		cl_click(settings);
		Thread.sleep(1000);
		cl_click(manageworkflows);
		Thread.sleep(3000);
		log.info("Manage workflow Page is displayed");
		et.log(LogStatus.PASS,"Manage workflow is clicked- passed");
		String wfname=Utility.getpropertydetails("WorkflowNameActivity");
		WebElement wf = b.w.findElement(By.xpath(wfselection1.replace("#DELIM#",String.valueOf(wfname))));
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",wf);
		cl_click(wf);
		Thread.sleep(2000);
		cl_click(removeWf);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Remove workflow button is clicked- passed");
		cl_click(btnBulkDelet);
		et.log(LogStatus.PASS,"Bulk delete button is clicked- passed");
		String msg=btnBulkDeletmsg.getText();
		System.out.println("Bulk Delete success msg: "+msg);
		cl_click(okBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Popup Ok button is clicked- passed");
	}

	public void manage_workflowsFlexiform() throws Exception {
		cl_click(username);
		cl_click(settings);
		Thread.sleep(1000);
		Actions a = new Actions(w);
		cl_click(manageworkflows);
		log.info("Manage workflow Page is displayed");
		et.log(LogStatus.PASS,"Manage workflow is clicked- passed");
		String wfname=Utility.getpropertydetails("FlexiWorkflowName");
		WebElement wf = b.w.findElement(By.xpath(wfselection1.replace("#DELIM#",String.valueOf(wfname))));
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",wf);
		cl_click(wf);
		Thread.sleep(2000);
		cl_click(flexi);
		et.log(LogStatus.PASS,"Flexiform button is clicked- passed");
		String inp1 = Utility.getpropertydetails("SetUpFlexi");
		try {
			if(inp1.equalsIgnoreCase("Modify"))
			{
				cl_click(modify);
				log.info("Modify button is clicked");
				Thread.sleep(10000);
				et.log(LogStatus.PASS,"Modify button is clicked- passed");
				cl_click(addsignatory);
				log.info("Signatory is added");
				Thread.sleep(3000);
				et.log(LogStatus.PASS,"Add signatory button is clicked- passed");
				int siz = signcount.size();
				Thread.sleep(2000);
				System.out.println("Total signatories: "+siz);
				//					a.dragAndDropBy(signbox, 348,11).build().perform();
				a.dragAndDrop(signbox,signercontainment).build().perform();;
				Thread.sleep(7000);
				et.log(LogStatus.PASS,"Drag and drop of signature- passed");
				log.info("Signature box is dragged");
				int siz1 = containercount.size();
				System.out.println("Containers : "+ siz1);
				for(int k=1;k<=siz1;k++) {
					System.out.println("k: "+k);
					//						int l=1;
					WebElement v = b.w.findElement(By.xpath(boxvalue.replace("#DELIM#",String.valueOf(k))));
					System.out.println("V : "+v);
					String sv = v.getAttribute("field_type");
					System.out.println("SV is : "+sv);
					if(sv.equalsIgnoreCase("Signature")) {

						WebElement v1 = b.w.findElement(By.xpath(boxvalue1.replace("#DELIM#",String.valueOf(k))));
						Thread.sleep(3000);
						JavascriptExecutor js1 = (JavascriptExecutor)w;
						js1.executeScript("arguments[0].scrollIntoView();",v1);
						a.moveToElement(v1).build().perform();
						Thread.sleep(3000);
						cl_click(b.w.findElement(By.xpath(boxsettings.replace("#DELIM#",String.valueOf(k)))));
						Thread.sleep(2000);
						String val=assignsignatory.getText();
						if(!val.startsWith("Signatory")) {
							Select se = new Select(assignsignatory);
							se.selectByIndex(k);
							Thread.sleep(5000);
							cl_click(applybtn);
						}else {
							cl_click(cnclbtn);
							Thread.sleep(3000);
						}
						//							l++;
						Thread.sleep(3000);
						log.info("Apply signature button is clicked");
					}
				}
				cl_click(activateflexiform);
				Thread.sleep(2000);
				et.log(LogStatus.PASS,"Activate Flexiform is clicked- passed");
				log.info("Activate Flexiform is clicked");
				cl_click(popupokbtn);
				Thread.sleep(1000);
				et.log(LogStatus.PASS,"Popup ok button is clicked- passed");

			}else {
				Thread.sleep(3000);
				cl_click(override);
				log.info("Override button is clicked");
				Thread.sleep(6000);
				et.log(LogStatus.PASS,"Override button is clicked- passed");
				String file=Utility.getpropertydetails("PDF");
				cl_entertext(uploadpdf1, file);
				Thread.sleep(7000);
				et.log(LogStatus.PASS,"File is uploaded- passed");
				log.info("Document is uploaded");
				int si = boxcount.size();
				System.out.println("Total box : "+si);
				a.dragAndDrop(signbox1, signercontainment).build().perform();;
				Thread.sleep(7000);
				cl_click(addsignatory);
				Thread.sleep(3000);
				et.log(LogStatus.PASS,"Add signatory is clicked- passed");
				int siz1 = containercount.size();
				System.out.println("Containers : "+ siz1);
				for(int k=1;k<=siz1;k++) {
					WebElement v = b.w.findElement(By.xpath(boxvalue.replace("#DELIM#",String.valueOf(k))));
					String sv = v.getAttribute("field_type");
					System.out.println("SV is : "+sv);
					if(sv.equalsIgnoreCase("Signature")) {
						WebElement v1 = b.w.findElement(By.xpath(boxvalue1.replace("#DELIM#",String.valueOf(k))));
						Thread.sleep(5000);
						a.moveToElement(v1).build().perform();
						Thread.sleep(3000);
						cl_click(b.w.findElement(By.xpath(boxsettings.replace("#DELIM#",String.valueOf(k)))));
						Thread.sleep(2000);
						Select se = new Select(assignsignatory);
						se.selectByIndex(1);
						Thread.sleep(5000);
						cl_click(applybtn);
						Thread.sleep(5000);
						log.info("Apply signature button is clicked");
						cl_click(activateflexiform);
						Thread.sleep(2000);
						et.log(LogStatus.PASS,"Activate Flexiform is clicked- passed");
						cl_click(popupokbtn);
						et.log(LogStatus.PASS,"Popup ok button is clicked- passed");
					}
				}
			}
		}catch(Exception e) {
			Thread.sleep(3000);
			cl_click(okBtn);
			Thread.sleep(3000);
			String file=Utility.getpropertydetails("PDF");
			cl_entertext(uploadpdf1, file);
			Thread.sleep(4000);
			Thread.sleep(3000);
			log.info("Document is uploaded");
			cl_click(addsignatory);
			a.dragAndDrop(signbox,signercontainment).build().perform();;
			Thread.sleep(7000);
			JavascriptExecutor js1 = (JavascriptExecutor)w;
			js1.executeScript("arguments[0].scrollIntoView();",signtr);
			a.moveToElement(signtr).build().perform();
			cl_click(signSettng);
			Thread.sleep(3000);
			cl_click(asignSignTo);
			Select s2=new Select(asignSignTo);
			s2.selectByIndex(1);
			Thread.sleep(2000);
			Select s3=new Select(selectPage);
			s3.selectByIndex(3);
			cl_click(applybtn);
			Thread.sleep(2000);
			cl_click(activateflexiform);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Activate Flexiform is clicked- passed");
			log.info("Activate Flexiform is clicked");
			cl_click(popupokbtn);
			et.log(LogStatus.PASS,"Popup ok button is clicked- passed");
		}
	}

	public void renew_subscription() throws Exception {	
		cl_click(subscription);
		Thread.sleep(2000);
		//		System.out.println("is present: "+expireMSg.isDisplayed());
		//		if(expireMSg.isDisplayed()) {
		//		String expreMsg=expireMSg.getText();
		//		System.out.println("Expire Message"+expreMsg);
		System.out.println("Subscription on: "+subscriptionOn.getText());
		String plantype=planType.getText();
		System.out.println("Plan Type: "+planType);
		String val=Utility.getpropertydetails("SubscriptionRenewORUpgrade");
		if(val.equalsIgnoreCase("Renew")) {
			System.out.println("Expire Message"+expireMSg.getText());
			cl_click(renewBtn);
			Thread.sleep(3000);
			System.out.println("captcha"+imgcaptcha.getAttribute("src"));
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the generated captcha");
			String inp1 = sc.next();
			cl_entertext(captcha, inp1);
			cl_click(purchaseBtn);
			Thread.sleep(3000);
			b.getScreenshot();

		}
		else if(val.equalsIgnoreCase("upgradePlan")){
			System.out.println("Expire Message"+expireMSg.getText());
			cl_click(upgradePlanBtn);
			Thread.sleep(3000);
			if(plantype.equalsIgnoreCase("Basic")) {
				cl_click(essentialUpgradeBtn);
				Thread.sleep(3000);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the generated captcha");
				String inp1 = sc.next();
				cl_entertext(captcha, inp1);
				cl_click(purchaseBtn);
				Thread.sleep(3000);
				b.getScreenshot();
			}else if(plantype.equalsIgnoreCase("Essential")) {
				cl_click(advncdUpgradeBtn);
				Thread.sleep(3000);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the generated captcha");
				String inp1 = sc.next();
				cl_entertext(captcha, inp1);
				cl_click(purchaseBtn);
				Thread.sleep(3000);
				b.getScreenshot();

			}else if(plantype.equalsIgnoreCase("Advanced")) {
				cl_click(professionalUpgradeBtn);
				Thread.sleep(3000);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the generated captcha");
				String inp1 = sc.next();
				cl_entertext(captcha, inp1);
				cl_click(purchaseBtn);
				Thread.sleep(3000);
				b.getScreenshot();
			}
		}
		else {
			b.getScreenshot();
			System.out.println("screenshot Taken");
			cl_click(subDetailsBckBtn);
			Thread.sleep(3000);
		}


		//		}
	}

	public void activity_log() throws Exception {
		cl_click(username);
		cl_click(settings);
		Thread.sleep(1000);
		cl_click(activityLog);
		Thread.sleep(4000);
		cl_click(exportToExcelBtn);
		Thread.sleep(3000);
		cl_click(activityLogBckBtn);

	}

	public void CustmStatusCancelCheck(String sheetName, String scriptname) throws Exception{
		cl_click(username);
		cl_click(settings);
		Thread.sleep(1000);
		cl_click(customStatus);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Custom Status is clicked- passed");
		log.info("Custom Status is clicked");
		cl_click(customStatusCancl);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Custom Status cancel button is clicked- passed");
		log.info("Custom Status cancel button is clicked");
		String url=w.getCurrentUrl();
		log.info("URL found when cancel button is clicked: "+url);
		Utility.comparelogic(url,sheetName,scriptname);

	}

	public void CustmStatusSaveCheck(String sheetName, String scriptname) throws Exception{
		cl_click(customStatus);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Custom Status is clicked- passed");
		cl_entertext(txtstatus, "demo");
		cl_click(customStatusSave);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Custom Status Save button is clicked- passed");
		String msg=CSmsgcontent.getText();
		cl_click(okBtn);
		Utility.comparelogic(msg,sheetName,scriptname);

	}

	public void CustmStatuseditCheck(String sheetName, String scriptname) throws Exception{
		cl_click(CStggleSearch);
		et.log(LogStatus.PASS,"Custom Status Toggle Search button is clicked- passed");
		cl_entertext(gs_Description, "demo");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		cl_click(editCSBtn);
		et.log(LogStatus.PASS,"Custom Status Edit button is clicked- passed");
		Thread.sleep(2000);
		cl_click(customStatusUpdte);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Custom Status Update button is clicked- passed");
		String msg=CSmsgcontent.getText();
		cl_click(okBtn);
		Utility.comparelogic(msg,sheetName,scriptname);


	}

	public void CustmStatusdeleteCheck(String sheetName, String scriptname) throws Exception{

		cl_click(CStggleSearch);
		cl_entertext(gs_Description, "demo");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		cl_click(deleteCSBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Custom Status Delete button is clicked- passed");
		String msg=CSmsgcontent.getText();
		cl_click(okBtn);
		Thread.sleep(3000);
		Utility.comparelogic(msg,sheetName,scriptname);
		cl_click(CSBAckBtn);
		et.log(LogStatus.PASS,"Custom Status Back button to Settings is clicked- passed");
	}

	public void AdvnceSetngAddCheck(String sheetName, String scriptname) throws Exception {
		cl_click(username);
		cl_click(settings);
		Thread.sleep(1000);
		cl_click(advceSettings);
		Select s=new Select(ASdllOption);
		s.selectByVisibleText("Enable LTV Signatures");
		Thread.sleep(1000);
		cl_entertext(AStxtdesc, "test");
		cl_click(ASbtnAdd);
		Thread.sleep(2000);
		String msg=CSmsgcontent.getText();
		cl_click(okBtn);
		Thread.sleep(1000);
		if(msg.contains("Details saved")) {
			Utility.comparelogic(msg,sheetName,scriptname);
		}else {
			System.out.println("Message: "+CSmsgcontent.getText());
		}

	}

	public void AdvnceSetngEditCheck(String sheetName, String scriptname) throws Exception {

		cl_click(CStggleSearch);
		cl_entertext(ASgs_Options, "Enable LTV Signatures");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		cl_click(ASEditBtn);
		et.log(LogStatus.PASS,"Advance Settings Edit button is clicked- passed");
		Thread.sleep(2000);
		cl_click(btnUpdate);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Advance Settings Update button is clicked- passed");
		String msg=CSmsgcontent.getText();
		cl_click(okBtn);
		Utility.comparelogic(msg,sheetName,scriptname);
	}

	public void AdvnceSetngDeleteCheck(String sheetName, String scriptname) throws Exception {
		cl_click(CStggleSearch);
		cl_entertext(ASgs_Options, "Enable LTV Signatures");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		cl_click(ASDeleteBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Advance Settings Delete button is clicked- passed");
		String msg=CSmsgcontent.getText();
		cl_click(okBtn);
		Thread.sleep(2000);
		Utility.comparelogic(msg,sheetName,scriptname);
		cl_click(ASBAckBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Advance Settings Back button to Settings is clicked- passed");

	}

	public void CreateWFExcel(String wfname,String name,String location) throws Exception {
		Actions a =new Actions(w);
		cl_click(manageworkflows);
		log.info("Manage workflow Page is displayed");
		et.log(LogStatus.PASS,"Manage workflow is clicked- passed");
		cl_click(createNewWf);
		et.log(LogStatus.PASS,"Create new workflow is clicked- passed");
		cl_entertext(wrkflowName, wfname);
		cl_click(wrkflowNameSaveBtn);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Save button is clicked- passed");
//		if(divworkflowname.isDisplayed()) {
//
//			System.out.println("Message: "+divworkflowname.getText());
//			cl_click(btnClose);
//			Thread.sleep(2000);
//			et.log(LogStatus.PASS,"Workflow name already exists.message- passed");		
//		}else {
			cl_click(okBtn);
			WebElement wf = b.w.findElement(By.xpath(wfselection1.replace("#DELIM#",String.valueOf(wfname))));
			JavascriptExecutor js = (JavascriptExecutor)w;
			js.executeScript("arguments[0].scrollIntoView();",wf);
			cl_click(wf);
			Thread.sleep(3000);
			et.log(LogStatus.PASS,"Created workflow is selected- passed");
			cl_click(flexi);
			Thread.sleep(3000);
			et.log(LogStatus.PASS,"Flexiform button is clicked- passed");
			String pdf=Utility.getpropertydetails("WrkPDF");
			cl_entertext(btnpdfupload, pdf);
			Thread.sleep(8000);
			et.log(LogStatus.PASS,"PDF is uploaded- passed");
			cl_click(createNewWfAddSign);
			et.log(LogStatus.PASS,"Add signatory is clicked- passed");
			a.dragAndDropBy(signbox, 348,11).build().perform();
			//		a.dragAndDrop(signbox,signercontainment).build().perform();;
			Thread.sleep(7000);
			a.moveToElement(signtr).build().perform();
			cl_click(signSettng);
			Thread.sleep(3000);
			Thread.sleep(3000);
			cl_click(asignSignTo);
			Select s=new Select(asignSignTo);
			s.selectByIndex(1);
			Thread.sleep(2000);
			Select s1=new Select(selectPage);
			s1.selectByIndex(3);
			cl_click(applybtn);
			Thread.sleep(2000);
			
			a.dragAndDropBy(spanTextbox, 250,11).build().perform();
			Thread.sleep(7000);
			a.dragAndDropBy(spanTextbox, 500,11).build().perform();
			Thread.sleep(7000);
			a.moveToElement(textBox1).build().perform();
			cl_click(TxtsignSettng);
			Thread.sleep(5000);
			Select s2=new Select(ddlTxtSignatory);
			s2.selectByIndex(1);
			Thread.sleep(2000);
			cl_entertext(txtTagName, name);
			cl_click(applybtn);
			Thread.sleep(2000);
			
//			a.dragAndDropBy(spanTextbox, 100,11).build().perform();
//			Thread.sleep(7000);
			a.moveToElement(textBox2).build().perform();
			cl_click(Txt2signSettng);
			Thread.sleep(5000);
			Select s3=new Select(ddlTxtSignatory);
			s3.selectByIndex(1);
			Thread.sleep(2000);
			cl_entertext(txtTagName, location);
			cl_click(applybtn);
			Thread.sleep(2000);
			
			cl_click(activateflexiform);
			Thread.sleep(6000);
			et.log(LogStatus.PASS,"Activate Flexiform is clicked- passed");
			log.info("Activate Flexiform is clicked");
			cl_click(popupokbtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Popup ok button is clicked- passed");
//		}

	}
}
