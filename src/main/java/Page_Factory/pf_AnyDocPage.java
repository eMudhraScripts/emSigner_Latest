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
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_AnyDocPage extends pf_genericmethods {

	Basefunctions b = new Basefunctions();
	final static Logger log = Logger.getLogger(pf_AnyDocPage.class);

	@FindBy(how = How.XPATH, using = "//*[@id=\"TopMenu\"]/ul/li[1]/a/span") public WebElement dashboard;
	@FindBy(how = How.ID, using = "main-content") WebElement onlineSigngPage;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-menu-wrapper\"]/a[1]/span") WebElement AnyDoc;
	@FindBy(how = How.XPATH, using = "//*[@id=\"btnpdfupload\"]") WebElement uploadDoc; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"li_1\"]/span[1]") WebElement uploadDocNameSize;
	@FindBy(how = How.XPATH, using = "//span[text()='Uploaded']") WebElement uploaded; 
	@FindBy(how = How.ID, using = "btnStep1Continue") WebElement continueBtn;

	//title
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/div[1]/div/div/h1") WebElement titleOnlneSign;

	@FindBy(how = How.XPATH, using = " //div[@class='message-box']") WebElement msgBoxBelowReference; 

	//message while uploading doc other than pdf
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'NOTE:Only .PDF document(s)')]") WebElement uploadMessage;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	//message while uploading password protected PDF
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'You cannot upload')]") WebElement uploadPwPrctedMessage;
	//choose template 
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Choose Temp')]") WebElement chooseTemp;
	
	@FindBy(how = How.ID, using = "txtsearchProfileSearch") WebElement templateSearch;
	//@FindBy(how = How.XPATH, using = "//div[@class='Profiles']/ul/li") WebElement selecttemplateSearch;
	String selecttemplateSearch="//div[@class='Profiles']/ul/li/label[text()='#DELIM#']";
	@FindBy(how = How.ID, using = "template-selection") WebElement docTemplate;
	//back button 
	@FindBy(how = How.ID, using = "btntemplateCancel") WebElement backBtn;
	//comments
	
	@FindBy(how = How.ID, using = "comments") WebElement comments;
	@FindBy(how = How.ID, using = "txtcomment") WebElement txtcomment;
	@FindBy(how = How.ID, using = "btnpostTraker") WebElement btnpostTraker;
	@FindBy(how = How.XPATH, using = "//div[@id='docComments']/div/div/div[2]/div[3]/div/ul/li/div/span[3]/a[1]") WebElement editBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='docComments']/div/div/div[2]/div[3]/div/ul/li/div/span[3]/a[2]") WebElement deleteBtn;
	@FindBy(how = How.ID, using = "btnupdate") WebElement btnupdate;
	@FindBy(how = How.XPATH, using = "//div[@id='docComments']/div/div/div[1]/button") WebElement closeComment;
	
	//cross button beside signatory one  
	@FindBy(how = How.ID, using = "signatoryDelete_1") WebElement crossBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Atleast one')]") WebElement crossBtnMsg;

	@FindBy(how = How.XPATH, using = "//a[text()='Signatory  1']") WebElement addSign;
	//+ icon
	@FindBy(how = How.ID, using = "addnewsigner") WebElement plusIcon;
	//Select signing type page
	@FindBy(how = How.ID, using = "Step1Left") WebElement selectSignTypePage;
	//back button 
	@FindBy(how = How.ID, using = "btnadhocAddCancel") WebElement bckBtnAddNewSigner; 

	//first Radio button(ME)
	@FindBy(how = How.XPATH, using = "//*[@title='ME']") WebElement radioBtn;
	//apply button
	@FindBy(how = How.ID, using = "btnSignatorySave") WebElement applyBtn; 
	//Template Name
	@FindBy(how = How.XPATH, using = "//div[@id='docSignerRight']/div[1]/ul/li/ul/li/span/span/div/form/input") WebElement tempName;
	//alert msg if the template name alert exist	
	@FindBy(how = How.ID, using = "msgcontent") WebElement alertMsg;
	//save and continue button
	@FindBy(how = How.ID, using = "btnstep1") WebElement saveNCntnue;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please enter template name to  ')]") WebElement saveCntnueMsg;

	@FindBy(how = How.XPATH, using = "//span[text()='Add Signatory']") WebElement addSignatory;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"div-dsign\"]/label") public WebElement dsign;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='sign-font-block']/ul/li")}) public List<WebElement> signs;
	String si = "//div[@class='innertab-panel']/div/ul/li[#DELIM#]/span[2]";
	@FindBy(how = How.ID, using = "btnradiosign") WebElement signbutton;
	@FindBy(how = How.ID, using = "esignature") public WebElement esign;
	@FindBy(how = How.ID, using = "btnFinalSend") WebElement btnFinalSend;
	@FindBy(how = How.ID, using = "msgcontent") WebElement msgcontent;
	@FindBy(how = How.ID, using = "DocumentMode") WebElement DocumentMode;
	@FindBy(how = How.XPATH, using = "//*[@id=\"doclog-section\"]/a") public WebElement docLog;
	@FindBy(how = How.ID, using = "lblworkflownum") WebElement workflownum;
	
	public pf_AnyDocPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}


	public void anyDocument(String sheetName,String scriptname) throws Exception {
		cl_click(AnyDoc);
		log.info("--Online signing page--");
		et.log(LogStatus.PASS,"Upload Document present in left menu is clicked- passed");
		System.out.println("Title of the Page: "+titleOnlneSign.getText());
		String msg=msgBoxBelowReference.getText();
		Utility.comparelogic(msg,sheetName,scriptname);

	}


	public void uploadNonPDF(String path, String sheetName, String scriptname) throws Exception {
		log.info("--Upload NON PDF document--");
		cl_entertext(uploadDoc, path);
		String upldnonPDFMsg=uploadMessage.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Upload NON PDF file- passed");
		Utility.comparelogic(upldnonPDFMsg,sheetName,scriptname);

	}


	public void uploadPDF(String pdfpath, String sheetName) throws Exception {
		log.info("--Upload PDF document--");
		cl_entertext(uploadDoc, pdfpath);
		Thread.sleep(10000);
		et.log(LogStatus.PASS,"Upload PDF file- passed");
		System.out.println("File name and Size: "+uploadDocNameSize.getText());
		/*if(uploaded.isDisplayed()) {
			System.out.println("File got uploaded");
		}else {
			System.out.println("File not uploaded");
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
			log.info("Screenshot taken");
			Assert.fail();
		}*/
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",continueBtn);
		cl_click(continueBtn);
		Thread.sleep(30000);
		et =  es.startTest("Online Signing TC_ID: 7541");
		et.log(LogStatus.PASS,"Continue button is clicked after uploading PDF file- passed");
		cl_click(saveNCntnue);
		System.out.println("without Template/signatory save and continue button: "+saveCntnueMsg.getText());
		et =  es.startTest("Online Signing TC_ID: 7545");
		et.log(LogStatus.PASS,"Save and Continue button without Template/signatory- passed");
		cl_click(okBtn);
		et =  es.startTest("Online Signing TC_ID: 7546");
		et.log(LogStatus.PASS,"Ok button present in alert message is clicked- passed");
		cl_click(chooseTemp);
		et.log(LogStatus.PASS,"Choose template button is clicked- passed");
		if(docTemplate.isDisplayed()) {
			System.out.println("Document Template page is displayed");
		}else {
			System.out.println("Document Template page not displayed");
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
			log.info("Screenshot taken");
			Assert.fail();	
		}
		Thread.sleep(2000);
		cl_click(backBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Back btn present in Choose template page is clicked- passed");
		cl_click(comments);
		et.log(LogStatus.PASS,"Comment button is clicked- passed");
		String com=Utility.getpropertydetails("OnlineSignComment");
		txtcomment.clear();
		cl_entertext(txtcomment, com);
		cl_click(btnpostTraker);
		et.log(LogStatus.PASS,"Post Comment button is clicked- passed");
		Thread.sleep(2000);
		cl_click(editBtn);
		et.log(LogStatus.PASS,"Edit Comment button is clicked- passed");
		String com1=Utility.getpropertydetails("OnlineSignUpdateComment");
		txtcomment.clear();
		cl_entertext(txtcomment, com1);
		cl_click(btnupdate);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Update Edited Comment button is clicked- passed");
		cl_click(deleteBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Delete Comment button is clicked- passed");
		cl_click(closeComment);
		et.log(LogStatus.PASS,"Close Comment button is clicked- passed");
	}


	public void addSignatory(String sheetName, String scriptname) throws Exception {
		Thread.sleep(2000);
		cl_click(addSignatory);
		et.log(LogStatus.PASS,"Add Signatory button is clicked- passed");
		log.info("Add signatory is clicked");
		cl_click(crossBtn);
		String msg=crossBtnMsg.getText();
		cl_click(okBtn);
		Utility.comparelogic(msg, sheetName, scriptname);	
		log.info("Cross button is clicked"+msg);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Cross button present in Signatory 1 is clicked- passed");
		cl_click(addSign);
		/*cl_click(plusIcon);
		if(selectSignTypePage.isDisplayed()) {
			System.out.println("Add new Signer Page is displayed");
		}else {
			System.out.println("Add new Signer Page is not displayed");
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
			log.info("Screenshot taken");
			Assert.fail();
		}
		Thread.sleep(2000);
		cl_click(bckBtnAddNewSigner);*/
		cl_click(radioBtn);
		et =  es.startTest("Online Signing TC_ID: 7733");
		et.log(LogStatus.PASS,"Signatory radio button is clicked- passed");
		cl_click(applyBtn);
		log.info("Apply button clicked after selecting signatory");
		et.log(LogStatus.PASS,"Apply button is clicked after selecting signatory- passed");
		String templateName=Utility.getpropertydetails("AnyDocTemplateName");
		System.out.println("templateName: "+templateName);
		cl_entertext(tempName,templateName);
		et.log(LogStatus.PASS,"Entered template name- passed");
		cl_click(saveNCntnue);
		log.info("Save button clicked after adding template name");
		et.log(LogStatus.PASS,"Save and Continue button is clicked after adding signatory and temp Name- passed");
		Thread.sleep(5000);
		String alrtmsg=alertMsg.getText();
		System.out.println(alrtmsg);
		if(alrtmsg.startsWith("Template name already")) {
			b.getScreenshot();
			System.out.println("Screenshot Taken");
			Assert.fail();
		}	
	}


	public void dsignDoc() throws Exception {
		log.info("--dsign page--");
		Thread.sleep(2000);
		cl_click(dsign);
		Thread.sleep(6000);
		et.log(LogStatus.PASS,"dsign radio button is clicked- passed");
		log.info("dsign radio button is clicked");
		int ss = signs.size();
		Random r = new Random();
		int n = r.nextInt(ss);
		if(n==0) {
			n=n+1;
		}
		cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(5000);
		et.log(LogStatus.PASS,"sign is picked- passed");
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",signbutton);
		cl_click(signbutton);
		Thread.sleep(20000);
		et.log(LogStatus.PASS,"Sign button is clicked after selecting sign- passed");
		log.info("Sign button is clicked");
		b.getScreenshot();
		et.log(LogStatus.PASS,"Websocket screenshot is taken- passed");
		
	}


	public void uploadPaswrdPrctedPDF(String pswdPdfpath, String sheetName,String scriptname) throws Exception {
		log.info("--Upload Password Protected PDF document--");
		cl_entertext(uploadDoc, pswdPdfpath);
		et.log(LogStatus.PASS,"Upload Password Protected PDF document- passed");
		String upldPswdPrctedPDFMsg=uploadPwPrctedMessage.getText();
		System.out.println(upldPswdPrctedPDFMsg);
		cl_click(okBtn);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Upload password protected file msg,ok button is clicked- passed");
		Utility.comparelogic(upldPswdPrctedPDFMsg,sheetName,scriptname);
		
	}


	public void anyDocumentChooseTemp(String pdfpath) throws Exception {
		cl_click(AnyDoc);
		log.info("--Online signing page by choosing existing template--");
		et.log(LogStatus.PASS,"Upload Document present in left menu is clicked- passed");
		cl_entertext(uploadDoc, pdfpath);
		Thread.sleep(10000);
		et.log(LogStatus.PASS,"Upload PDF file- passed");
		System.out.println("File name and Size: "+uploadDocNameSize.getText());
		
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",continueBtn);
		cl_click(continueBtn);
		Thread.sleep(30000);
		et.log(LogStatus.PASS,"Continue button is clicked after Uploading PDF file- passed");
		cl_click(chooseTemp);
		log.info("Choose template is clicked");
		et.log(LogStatus.PASS,"Choose template button is clicked- passed");
		String templateName=Utility.getpropertydetails("AnyDocTemplateName");
		try {
		cl_entertext(templateSearch, templateName);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Searched with template name in Choose template page- passed");
		cl_click(w.findElement(By.xpath(selecttemplateSearch.replace("#DELIM#",String.valueOf(templateName)))));
		Thread.sleep(2000);
		log.info("Searched template name is clicked");
		et =  es.startTest("Online Signing TC_ID: 7748");
		et.log(LogStatus.PASS,"Searched template name is clicked- passed");
		String name=tempName.getAttribute("value");
		System.out.println(name);
		if(templateName.equalsIgnoreCase(name)) {
			cl_click(saveNCntnue);			
			log.info("Save button clicked after selecting template name");
			Thread.sleep(5000);
			dsignDoc();
		}
		}catch(Exception e) {		
			System.out.println("Searched template name is not present");
			log.info("Searched template name is not present");
			b.getScreenshot();
			et =  es.startTest("Online Signing TC_ID: 7749");
			et.log(LogStatus.PASS,"Searched template name is not present- passed");
		}
	}


	public void anyDocumenteSign(String pdfpath) throws Exception {
		cl_click(AnyDoc);
		log.info("--Online signing page by choosing existing template--");
		et.log(LogStatus.PASS,"Upload Document present in left menu is clicked- passed");
		cl_entertext(uploadDoc, pdfpath);
		Thread.sleep(10000);
		et.log(LogStatus.PASS,"Upload PDF file- passed");
		System.out.println("File name and Size: "+uploadDocNameSize.getText());
		
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",continueBtn);
		cl_click(continueBtn);
		Thread.sleep(30000);
		et.log(LogStatus.PASS,"Continue button is clicked after Uploading PDF file- passed");
		cl_click(chooseTemp);
		log.info("Choose template is clicked");
		et.log(LogStatus.PASS,"Choose template button is clicked- passed");
		String templateName=Utility.getpropertydetails("AnyDocTemplateName");
		try {
		cl_entertext(templateSearch, templateName);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Searched with template name in Choose template page- passed");
		cl_click(w.findElement(By.xpath(selecttemplateSearch.replace("#DELIM#",String.valueOf(templateName)))));
		Thread.sleep(2000);
		log.info("Searched template name is clicked");
		et.log(LogStatus.PASS,"Searched template name is clicked- passed");
		String name=tempName.getAttribute("value");
		System.out.println(name);
		if(templateName.equalsIgnoreCase(name)) {
			cl_click(saveNCntnue);			
			log.info("Save button clicked after selecting template name");
			Thread.sleep(5000);
			cl_click(esign);
			Thread.sleep(4000);
			et.log(LogStatus.PASS,"esign radio button is clicked- passed");
			log.info("dsign radio button is clicked");
			int ss = signs.size();
			Random r = new Random();
			int n = r.nextInt(ss);
			if(n==0) {
				n=n+1;
			}
			cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(5000);
			et.log(LogStatus.PASS,"sign is picked- passed");
			JavascriptExecutor js1 = (JavascriptExecutor)w;
			js1.executeScript("arguments[0].scrollIntoView();",signbutton);
			cl_click(signbutton);
			Thread.sleep(20000);
			et.log(LogStatus.PASS,"Sign button is clicked after selecting sign- passed");
			log.info("Sign button is clicked");
			Thread.sleep(3000);
			cl_click(docLog);
			Thread.sleep(3000);
			et.log(LogStatus.PASS,"Doc log is clicked- passed");
			String wfname=workflownum.getText();
			//System.out.println("wfname"+wfname);
			cl_click(btnFinalSend);
			Thread.sleep(6000);
			et.log(LogStatus.PASS,"Send button is clicked- passed");
			String msg=msgcontent.getText();
			System.out.println(msg);
			cl_click(okBtn);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Popup ok button is clicked- passed");
			boolean docPage = DocumentMode.isDisplayed();
			System.out.println("Document page is displayed?: "+docPage);
			Thread.sleep(2000);		
			cl_click(dashboard);
			Thread.sleep(4000);
		}
		}catch(Exception e) {		
			System.out.println("Searched template name is not present");
			log.info("Searched template name is not present");
			b.getScreenshot();
			et =  es.startTest("Online Signing TC_ID: 7749");
			et.log(LogStatus.PASS,"Searched template name is not present- passed");
		}
	}

}
