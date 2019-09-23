package Page_Factory;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_form16SigningPage extends pf_genericmethods {

	Basefunctions b = new Basefunctions();
	final static Logger log = Logger.getLogger(pf_form16SigningPage.class);

	@FindBy(how = How.XPATH, using = "//*[text()='Form16 Signing']") WebElement form16Signing;
	@FindBy(how = How.ID, using = "step1Content") WebElement templtePage;
	@FindBy(how = How.ID, using = "btnpdfupload") WebElement createTempbutton;
	@FindBy(how = How.ID, using = "btncontinue") WebElement continuebutton;
	@FindBy(how = How.XPATH, using = "//div[@class='info']") WebElement continueMsg;
	//choose template dropdown
	@FindBy(how = How.ID, using = "ConfigViewModel_ddlProfile") WebElement choseTempDropdwn;

	//message while uploading doc other than pdf
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'NOTE:Only .PDF document(s)')]") WebElement uploadMessage;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	//check progress bar
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Preparing your document for')]") WebElement progressMsg;
	//check template setting
	@FindBy(how = How.CLASS_NAME, using = "box") WebElement tmplteSettingBox;
	//save button
	@FindBy(how = How.ID, using = "btnSave") WebElement saveBtn;
	//cancel button
	@FindBy(how = How.ID, using = "btncanceled") WebElement cnclBtn;
	@FindBy(how = How.XPATH, using ="//div[contains(text(),'Please Enter Document')]") WebElement saveBtnMsg;
	//select page dropdown
	@FindBy(how = How.ID, using = "ddlSelectpage") WebElement selectPage;

	//cross button in select drop down page

	@FindBy(how = How.ID, using = "DeleteSigners_1") WebElement crossSign;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Atleast one signatory')]") WebElement signatryMsg;
	//more signatories
	@FindBy(how = How.XPATH, using = "//*[@id=\"existingProfile\"]/span") WebElement moreSignatryBtn;
	@FindBy(how = How.ID, using = "DeleteSigners_2") WebElement crossSign2;
	@FindBy(how = How.ID, using = "msgcontent") WebElement crossSign2Msg;

	//doc successfully created
	@FindBy(how = How.ID, using = "objpdfconfigviewmodel_Profile") WebElement docName;

	@FindBy(how = How.ID, using = "msgcontent") WebElement alertMsg;	
	//browse doc page	
	@FindBy(how = How.XPATH, using = "//div[@class='row form-page top15']") WebElement browseDocPage;

	//browse doc continue btn  
	@FindBy(how = How.ID, using = "btncontinuenext") WebElement browseContinueBtn;
	@FindBy(how = How.XPATH, using = "//div[text()='Please select PartA Folder.']") WebElement browseContinueMsg;
	@FindBy(how = How.XPATH, using = "//div[text()='Please select PartB Folder.']") WebElement browseAContinueMsg;
	@FindBy(how = How.XPATH, using = "//div[text()='Please select destination folder']") WebElement browseABContinueMsg;
	@FindBy(how = How.XPATH, using = "//div[text()='Please upload CSV file format.']") WebElement browseABDContinueMsg;

	//part A folder
	@FindBy(how = How.ID, using = "btnFormA") WebElement partAFolder;
	//part B folder
	@FindBy(how = How.ID, using = "btnFormB") WebElement partBFolder;
	//Dest folder
	@FindBy(how = How.ID, using = "btnDest") WebElement destFolder;
	//csv folder
	@FindBy(how = How.ID, using = "btnfile") WebElement csvFolder;

	@FindBy(how = How.ID, using = "downloadFile") WebElement sampleCSV;
	//doc setting page	
	@FindBy(how = How.ID, using = "step3Content") WebElement docSetngPage;
	@FindBy(how = How.ID, using = "btnProcess") WebElement continueProcess;	
	@FindBy(how = How.ID, using = "btncancel") WebElement cancelBtn;

	//emailing option 	
	@FindBy(how = How.ID, using = "sendEmail") WebElement chckbxSndMail;
	@FindBy(how = How.ID, using = "rdemudhraconfig") WebElement rBtnemSignerSMTP;
	@FindBy(how = How.ID, using = "rdotherconfig") WebElement rBtnOtherSMTP;	
	@FindBy(how = How.XPATH, using = "//div[text()='Please enter Email Address']") WebElement processContinueMsg;
	@FindBy(how = How.ID, using = "From") WebElement fromAddress;
	@FindBy(how = How.ID, using = "Subject") WebElement subject;

	//sign option
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='sign-font-block']/ul/li")}) public List<WebElement> signs;	
	String sign = "//div[@class='innertab-panel']/div/ul/li[#DELIM#]/span[2]";

	public pf_form16SigningPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void form16Signing(String sheetName,String scriptname) throws Exception{
		log.info("--Form16_Signing Page--");
		log.info("Click on continue button without selecting/Creating template");
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",form16Signing);
		cl_click(form16Signing);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Form16 Signing is clicked- passed");
		cl_click(continuebutton);
		log.info("Continue button is clicked");
		String msg= continueMsg.getText();
		Thread.sleep(1000);
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Continue button without selecting/Creating template- passed");
		Utility.comparelogic(msg,sheetName,scriptname);
		log.info("Message displayed when Continue button is clicked: "+msg);
	}

	public void uploadPDF(String path,String sheetName, String scriptname) throws Exception {
		log.info("Upload PDF document");
		cl_entertext(createTempbutton,path);
		Thread.sleep(3000);
		et =  es.startTest("Form16 TC_ID: 3662");
		et.log(LogStatus.PASS,"Upload PDF File- passed");
		Boolean b=progressMsg.isDisplayed();
		if(b == true) {
			System.out.println("progress bar displayed: "+b);
			et =  es.startTest("Form16 TC_ID: 3665");
			et.log(LogStatus.PASS,"While uploading PDF file progress bar displayed- passed");
			log.info("Progress bar is displayed");
		}
		if(b == false) {
			log.info("Progress bar is not displayed");
			Basefunctions.getScreenshot();
			Assert.fail();
		}
		Thread.sleep(30000);
		cl_click(cnclBtn);
		et =  es.startTest("Form16 TC_ID: 3668");
		et.log(LogStatus.PASS,"Cancel button in template setting page is clicked- passed");
		log.info("Cancel button is clicked");
		Thread.sleep(3000);
		cl_entertext(createTempbutton,path);
		Thread.sleep(3000);
		log.info("PDF file is uploaded");
		et.log(LogStatus.PASS,"Upload PDF File- passed");

		cl_click(saveBtn);
		String saveMsg=saveBtnMsg.getText();
		Thread.sleep(2000);
		cl_click(okBtn);
		Utility.comparelogic(saveMsg,sheetName,scriptname);
		log.info("Msg when we upload PDF doc and click on save button"+saveMsg);
		et =  es.startTest("Form16 TC_ID: 3667");
		et.log(LogStatus.PASS,"Save Button in template setting page without temp Name- passed");
		Thread.sleep(2000);

	}

	public void uploadNonPDF(String path,String sheetName,String scriptname) throws Exception {
		log.info("Upload Non pdf document");
		cl_entertext(createTempbutton,path);
		String uploadMsg=uploadMessage.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Upload NonPDF File- passed");
		Utility.comparelogic(uploadMsg,sheetName,scriptname);
		log.info("Message when NON PDF file is uploaded: "+uploadMsg);
	}

	public void verifySelectPage(String sheetName,String scriptname) throws Exception {
		Select slctPge=new Select(selectPage);
		slctPge.selectByIndex(6);
		et =  es.startTest("Form16 TC_ID: 3680");
		et.log(LogStatus.PASS,"Select page dropdown 'PAGE level'- passed");
		Thread.sleep(2000);
		cl_click(moreSignatryBtn);
		et.log(LogStatus.PASS,"More Signatories button is clicked- passed");
		cl_click(crossSign2);
		String msg2=crossSign2Msg.getText();
		System.out.println("Msg when we press cross btn of signatory2: "+msg2);
		Thread.sleep(2000);
		cl_click(okBtn);
		et =  es.startTest("Form16 TC_ID: 3684");
		et.log(LogStatus.PASS,"Cross button present in Signatory 2 is clicked- passed");
		cl_click(crossSign);
		String msg=signatryMsg.getText();
		Thread.sleep(2000);
		cl_click(okBtn);
		Utility.comparelogic(msg,sheetName,scriptname);
		log.info("Message when signatory cross button is clicked: "+msg);
		et =  es.startTest("Form16 TC_ID: 3681");
		et.log(LogStatus.PASS,"Cross button  present in Signatory 1 is clicked- passed");
	}

	public void uploadDocument() throws Exception {
		String name=Utility.getpropertydetails("docTemplateName");
		System.out.println("Form16 document Template Name: "+name);
		cl_entertext(docName,name);
		et.log(LogStatus.PASS,"Document template name is entered- passed");
		cl_click(saveBtn);
		Thread.sleep(3000);
		String exp=alertMsg.getText();
		System.out.println("docCreationMsg: "+exp);
		cl_click(okBtn);
		et =  es.startTest("Form16 TC_ID: 3697");
		et.log(LogStatus.PASS,"Save button is clicked after entering doc template name- passed");
		if(exp.startsWith("Sorry!Template name")) {
			System.out.println("Screenshot Taken");
			b.getScreenshot();
			Assert.fail();
		}		
	}

	public void browseDocIsDisplayed() throws Exception {
		if(browseDocPage.isDisplayed()) {
			System.out.println("Browse documents is displayed");
			log.info("Browse document page is displayed");
		}else {
			log.info("Browse document page is not displayed");
			b.getScreenshot();
			Assert.fail();			
		}
	}

	public void browseContinue(String sheetName,String scriptname) throws Exception {
		log.info("Click on Continue button in browse doc page");
		cl_click(browseContinueBtn);
		Thread.sleep(1000);
		String browseCtnMsg=browseContinueMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(browseCtnMsg,sheetName,scriptname);
		log.info("Browse continue button without selecting a folder: "+browseCtnMsg);
		et =  es.startTest("Form16 TC_ID: 3699");
		et.log(LogStatus.PASS,"Continue button of Browse documents page wihtout selecting folder- passed");
	}

	public void browseAContinue(String sheetName,String scriptname) throws Exception {
		cl_click(partAFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\partAFolder\\new.exe");
		Thread.sleep(8000);
		cl_click(browseContinueBtn);
		Thread.sleep(1000);
		String browseCMsg=browseAContinueMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Continue button of Browse documents page by selecting only A folder- passed");
		Utility.comparelogic(browseCMsg,sheetName,scriptname);
		log.info("Browse continue button by selecting only A folder: "+browseCMsg);
	}

	public void browseABContinue(String sheetName,String scriptname) throws Exception {
		cl_click(partBFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\partBFolder\\new.exe");
		Thread.sleep(6000);
		cl_click(browseContinueBtn);
		Thread.sleep(1000);
		String browseABMsg=browseABContinueMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Continue button of Browse documents page by selecting A and B folder- passed");
		Utility.comparelogic(browseABMsg,sheetName,scriptname);
		log.info("Browse continue button by selecting A and B folder: "+browseABMsg);
	}

	public void browseABDestContinue(String sheetName,String scriptname) throws Exception {
		cl_click(destFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\Merge\\destfolder.exe");
		Thread.sleep(6000);
		cl_click(browseContinueBtn);
		Thread.sleep(1000);
		String browseDCMsg=browseABDContinueMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(browseDCMsg,sheetName,scriptname);
		log.info("Browse continue button by selecting A, B,dest folder: "+browseDCMsg);
		et =  es.startTest("Form16 TC_ID: 3702");
		et.log(LogStatus.PASS,"Continue button of Browse documents page by selecting A, B,dest folder- passed");
		Thread.sleep(2000);
		cl_click(sampleCSV);
		Thread.sleep(2000);
		et =  es.startTest("Form16 TC_ID: 3708");
		et.log(LogStatus.PASS," Sample CSV dwnld passed");
		cl_click(csvFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\csvFolder\\csvFile.exe");
		Thread.sleep(7000);
		cl_click(browseContinueBtn);
		et.log(LogStatus.PASS,"Continue button of Browse documents page by selecting A, B,dest,CSV folder- passed");
		if(docSetngPage.isDisplayed() == true) {
			System.out.println("doc setting page is displayed");
			et =  es.startTest("Form16 TC_ID: 3704");
			et.log(LogStatus.PASS,"Document settings page is displaed- passed");
		}
		else {
			log.info("Document setting page is not displayed");
			b.getScreenshot();
			Assert.fail();
		}

		Thread.sleep(5000);
		int ss = signs.size();
		Random r = new Random();
		int n = r.nextInt(ss);
		if(n==0) {
			n=n+1;
		}
		cl_click(w.findElement(By.xpath(sign.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(7000);
		log.info("Sign is picked");
		et.log(LogStatus.PASS,"Sign is picked- passed");
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",continueProcess);
		cl_click(continueProcess);
		Thread.sleep(20000);
		et.log(LogStatus.PASS,"Continue Process button is clicked- passed");
		b.getScreenshot();

	}

	public void chooseTemplate() throws Exception {
		log.info("--Form16_Signing Page--");
		log.info("Click on continue button by selecting template");
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",form16Signing);
		cl_click(form16Signing);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Form16 Signing is clicked- passed");
		Select s=new Select(choseTempDropdwn);
		String temp=Utility.getpropertydetails("docTemplateName");
		s.selectByVisibleText(temp);
		Thread.sleep(2000);
		cl_click(continuebutton);
		et.log(LogStatus.PASS,"Continue button is clicked after choosing template- passed");
		log.info("Continue button is clicked");
		cl_click(partAFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\partAFolder\\new.exe");
		Thread.sleep(8000);
		cl_click(partBFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\partBFolder\\new.exe");
		Thread.sleep(6000);
		cl_click(destFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\MergeChoseTemplte\\destfolder.exe");
		Thread.sleep(6000);
		cl_click(csvFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\csvFolder\\csvFile.exe");
		Thread.sleep(7000);
		cl_click(browseContinueBtn);
		et.log(LogStatus.PASS,"Continue button of Browse documents page by selecting A, B,dest,CSV folder- passed");
		Thread.sleep(5000);
		int ss = signs.size();
		Random r = new Random();
		int n = r.nextInt(ss);
		if(n==0) {
			n=n+1;
		}
		cl_click(w.findElement(By.xpath(sign.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(000);
		log.info("Sign is picked");
		et.log(LogStatus.PASS,"Sign is picked- passed");
		JavascriptExecutor js1 = (JavascriptExecutor)w;
		js1.executeScript("arguments[0].scrollIntoView();",continueProcess);
		cl_click(continueProcess);
		Thread.sleep(20000);
		et.log(LogStatus.PASS,"Continue Process button is clicked- passed");
		b.getScreenshot();
	}

	/*public void verifyemSignerSMTP(String fromAdd, String sbjct,String sheetName) throws Exception {
		cl_click(chckbxSndMail);

		if(!rBtnemSignerSMTP.isSelected()) {
			cl_click(rBtnemSignerSMTP);
			cl_click(continueProcess);
			String msg= processContinueMsg.getText();
			cl_click(okBtn);
			Utility.comparelogic(msg,sheetName);

			cl_entertext(fromAddress, fromAdd);
			cl_entertext(subject, sbjct);
			cl_click(continueProcess);
			String msg1= processContinueMsg.getText();		
			cl_click(okBtn);
			Utility.comparelogic(msg1,sheetName);
		}
	}

	public void verifyOtherSMTP(String sbjct,String sheetName) throws Exception {

		if(!rBtnOtherSMTP.isSelected()) {
			cl_click(rBtnOtherSMTP);
			cl_click(continueProcess);
			String msg= processContinueMsg.getText();	
			Utility.comparelogic(msg,sheetName);
			cl_click(okBtn);

			cl_entertext(subject, sbjct);
			cl_click(continueProcess);
			String msg1= processContinueMsg.getText();	
			Utility.comparelogic(msg1,sheetName);
			cl_click(okBtn);
		}
	}*/

}
