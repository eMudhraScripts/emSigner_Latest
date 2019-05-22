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

public class pf_BulkDocument extends pf_genericmethods {
	Basefunctions b = new Basefunctions();
	final static Logger log = Logger.getLogger(pf_BulkDocument.class);


	@FindBy(how = How.ID, using = "Offline") WebElement bulkDoc;

	@FindBy(how = How.ID, using = "btncontinue") WebElement continuebutton;

	@FindBy(how = How.ID, using = "btnpdfupload") WebElement createTempbutton;
	@FindBy(how = How.XPATH, using = "//div[@class='info']") WebElement continueMsg;
	//message while uploading doc other than pdf
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'NOTE:Only .PDF document(s)')]") WebElement uploadMessage;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	//check progress bar
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Preparing your document for')]") WebElement progressMsg;
	//save button
	@FindBy(how = How.ID, using = "btnSave") WebElement saveBtn;
	@FindBy(how = How.XPATH, using ="//div[contains(text(),'Please Enter Document')]") WebElement saveBtnMsg;
	
	@FindBy(how = How.ID, using = "msgcontent") WebElement successMsg;
	//select page dropdown
	@FindBy(how = How.ID, using = "ddlSelectpage") WebElement selectPage;

	//cross button in select drop down page

	@FindBy(how = How.ID, using = "DeleteSigners_1") WebElement crossSign;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Atleast one signatory')]") WebElement signatryMsg;

	//doc successfully created
	@FindBy(how = How.ID, using = "objpdfconfigviewmodel_Profile") WebElement docName;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Congrats! Document template')]") WebElement docCreated;
	//browse doc page	
	@FindBy(how = How.ID, using = "frmSign") WebElement browseDocPage;
	//browse doc continue btn  
	@FindBy(how = How.ID, using = "btncontinuenext") WebElement browseContinueBtn;
	@FindBy(how = How.XPATH, using = "//div[text()='Please select Source']") WebElement browseContinueMsg;
	
	//source folder
	@FindBy(how = How.ID, using = "btnsource") WebElement sourceFolder;
	@FindBy(how = How.XPATH, using = "//div[text()='Please select Destination']") WebElement sourceContinueMsg;
	
	//dest Folder
	@FindBy(how = How.ID, using = "btnDest") WebElement destFolder;
	
	//sign button
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='sign-font-block']/ul/li")}) public List<WebElement> signs;	
	String sign = "//div[@class='innertab-panel']/div/ul/li[#DELIM#]/span[2]";
	@FindBy(how = How.ID, using = "btnProcess") WebElement signBtn;
	
	public pf_BulkDocument(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}


	public void bulkSigning(String sheetName, String scriptname) throws Exception {
		log.info("--Bulk signing page--");
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",bulkDoc);
		cl_click(bulkDoc);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Bulk Document present in left menu is clicked- passed");
		cl_click(continuebutton);
		log.info("Continue button is clicked without selecting/creating template");
		String msg= continueMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Continue button without selecting/Creating template- passed");
		Utility.comparelogic(msg,sheetName,scriptname);
	}

	public void uploadNonPDF(String path, String sheetName, String scriptname) throws Exception {
		log.info("--Upload NON PDF document--");
		cl_entertext(createTempbutton,path);
		String uploadMsg=uploadMessage.getText();
		Thread.sleep(2000);
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Upload NonPDF File- passed");
		Utility.comparelogic(uploadMsg,sheetName,scriptname);
	}

	public void uploadPDF(String pdfpath, String sheetName, String scriptname) throws Exception {
		log.info("--Upload PDF document--");
		cl_entertext(createTempbutton,pdfpath);
		Thread.sleep(8000);
		et.log(LogStatus.PASS,"Upload PDF File- passed");
		/*Boolean b=progressMsg.isDisplayed();
		System.out.println("progress bar displayed: "+b);
		if(b == false) {
			Basefunctions.getScreenshot();
			Assert.fail();
		}
		Thread.sleep(30000);*/		

		cl_click(saveBtn);
		Thread.sleep(2000);
		String saveMsg=saveBtnMsg.getText();
		System.out.println("saveMsg"+saveMsg);
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Save Button in template setting page without temp Name- passed");
		Utility.comparelogic(saveMsg,sheetName,scriptname);
		log.info("Save button clicked after adding pdf doc without template name"+saveMsg);

	}

	public void verifySelectPage(String sheetName, String scriptname) throws Exception {
		Select slctPge=new Select(selectPage);
		slctPge.selectByIndex(6);
		et.log(LogStatus.PASS,"Select page dropdown 'PAGE level'- passed");
		cl_click(crossSign);
		log.info("Cross button is clicked");
		String msg=signatryMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Cross button  present in Signatory 1 is clicked- passed");
		Utility.comparelogic(msg,sheetName,scriptname);
	}


	public void uploadDocument() throws Exception {
		String name=Utility.getpropertydetails("bulkdocTemplateName");
		System.out.println("name: "+name);
		cl_entertext(docName,name);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Document template name is entered- passed");
		cl_click(saveBtn);
		Thread.sleep(2000);
		//String exp="Congrats! Document template "+name+" has been successfully created";
		String exp=successMsg.getText();
		System.out.println("docCreationMsg"+exp);
		Thread.sleep(2000);
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Save button is clicked after entering doc template name- passed");
		if(exp.startsWith("Sorry!Template name")) {
			System.out.println("Screenshot Taken");
			b.getScreenshot();
			Assert.fail();
		}	

	}


	public void browseDocIsDisplayed() throws Exception {
		log.info("--Browse page --");
		if(browseDocPage.isDisplayed()) {
			System.out.println("Browse documents is displayed");
		}else {
			Basefunctions.getScreenshot();
			Assert.fail();			
		}

	}


	public void browseContinue(String sheetName, String scriptname) throws Exception {
		Thread.sleep(2000);
		cl_click(browseContinueBtn);	
		String browseCtnMsg=browseContinueMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Continue button of Browse documents page wihtout selecting folder- passed");
		log.info("Browse continue btn without selecting Source and Destination folder: "+browseCtnMsg);
		Utility.comparelogic(browseCtnMsg,sheetName,scriptname);
		
	}


	public void browseSourceContinue(String sheetName, String scriptname) throws Exception {
		cl_click(sourceFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\Bulk\\bulksource\\source.exe");
		Thread.sleep(8000);
		cl_click(browseContinueBtn);	
		String browseCMsg=sourceContinueMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Continue button of Browse documents page by selecting only source folder- passed");
		log.info("Browse continue btn without selecting Destination folder: "+browseCMsg);
		Utility.comparelogic(browseCMsg,sheetName,scriptname);
		Thread.sleep(2000);
		cl_click(destFolder);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\Bulk\\bulkDest\\dest.exe");
		Thread.sleep(8000);
		cl_click(browseContinueBtn);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Continue button of Browse documents page by selecting Source and Destination folder- passed");
		log.info("Browse continue btn by selecting Source and Destination folder");
		int ss = signs.size();
		Random r = new Random();
		int n = r.nextInt(ss);
		if(n==0) {
			n=n+1;
		}
		cl_click(w.findElement(By.xpath(sign.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(7000);
		et.log(LogStatus.PASS,"Sign is picked- passed");
		cl_click(signBtn);
		log.info("Sign button is clicked");
		Thread.sleep(20000);
		et.log(LogStatus.PASS,"Sign button is clicked- passed");
		b.getScreenshot();
	}


}
