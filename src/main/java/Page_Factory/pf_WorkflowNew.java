package Page_Factory;

import java.util.List;
import java.util.Random;

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

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_WorkflowNew extends pf_genericmethods {
	final static Logger log = Logger.getLogger(pf_WorkflowNew.class);

	Basefunctions b = new Basefunctions();

	@FindBy(how = How.XPATH, using = "//*[@id=\"TopMenu\"]/ul/li[1]/a/span") public WebElement dashboard;
	//select the workflow
	String selectWf ="//ul[@id='adminWorkflowMenu']/li[2]/ul/li/a/span[text()='#DELIM#']";

	@FindBy(how = How.XPATH, using = "//span[@class='arrow open']") public WebElement arrowOpen;
	@FindBy(how = How.ID, using = "frmSign") WebElement uploadDocPage;

	@FindBy(how = How.XPATH, using = "//div[@class='workflow-section row ']") WebElement spcfyParticipantsPage;
	//document list 
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='tblDocDetails']/tbody/tr")}) public List<WebElement> docNamelist;

	//Choose file button
	@FindBy(how = How.XPATH, using = "//table[@id='tblDocDetails']/tbody/tr/td[3]/input") public WebElement chooseFile;
	//without selecting file press continue button
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please upload document')]") WebElement withoutFileCBtn;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;

	//without signatory save and continue button
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please map user')]") WebElement withoutSignSaveBtn;

	@FindBy(how = How.ID, using = "btnstep1") WebElement saveNContinueBtn;
	//signatory other than me
	//@FindBy(how = How.XPATH, using = "//*[not(@title='ME')]") WebElement signradioBtn;
	//signatory 1
	@FindBy(how = How.XPATH, using = "//div[@class='signerwrapper']/ul/li/ul/li/a") WebElement signatoryBtn;

	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='signerwrapper']/ul/li")}) public List<WebElement> docmtList;
	String documentList="//div[@class='signerwrapper']/ul/li[#DELIM#]";
	//Signatory list
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='signerwrapper']/ul/li/ul/li")}) public List<WebElement> signatoryList;
	String signatory="//div[@class='signerwrapper']/ul/li/ul/li[#DELIM#]/a";
	String signradioBtn="//div[@class='signatories-section']/ul/li[not(@text()='ME')]/following-sibling::li[#DELIM#]/span/input";
	//signatory radio button
	String signatoryRButton="//div[@class='signatories-section']/ul/li[#DELIM#]/span/input";
	//radio button  
	@FindBy(how = How.XPATH, using = "//span[@class='chk-signer']/input") WebElement radioBtn;
	//apply button
	@FindBy(how = How.ID, using = "btnSignatorySave") WebElement applyBtn; 
	//continue button
	@FindBy(how = How.ID, using = "btnValue") WebElement continueBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"div-dsign\"]/label") public WebElement dsign;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='sign-font-block']/ul/li")}) public List<WebElement> signs;

	String si = "//div[@class='innertab-panel']/div/ul/li[#DELIM#]/span[2]";
	@FindBy(how = How.ID, using = "btnradiosign") WebElement signbutton;
	@FindBy(how = How.ID, using = "btnFinalSend") WebElement btnFinalSend;
	@FindBy(how = How.ID, using = "msgcontent") WebElement msgcontent;
	@FindBy(how = How.ID, using = "DocumentMode") WebElement DocumentMode;

	//browse button for external file
	@FindBy(how = How.ID, using = "upload") WebElement brwseExternlFile;
	@FindBy(how = How.ID, using = "previewdata") WebElement previewdata;
	@FindBy(how = How.ID, using = "closePopUp1") WebElement previewdataClseBtn;
	@FindBy(how = How.ID, using = "BulkUploadmsgcontent") WebElement BulkUploadmsgcontent;
	@FindBy(how = How.ID, using = "btnUploadContinue") WebElement btnUploadContinue;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement yesBtn;
	@FindBy(how = How.ID, using = "btnmsgcancel") WebElement NoBtn;
	@FindBy(how = How.ID, using = "success") WebElement successMsg;
	@FindBy(how = How.ID, using = "btnInitiatesign") WebElement btnInitiatesign;
	
	//NOTE: Only XLS, XLSX and CSV files can be uploaded
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'NOTE')]") public WebElement msgcontent1;
	//Atleast one tagname should match
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Atleast')]") public WebElement msgcontent2;
	public pf_WorkflowNew(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void selectWorkflow(WebDriver driver) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		String wfname=Utility.getpropertydetails("FlexiWorkflowName");
		WebElement fe = w.findElement(By.xpath(selectWf.replace("#DELIM#",String.valueOf(wfname))));		
		js.executeScript("arguments[0].scrollIntoView();",fe);
		cl_click(fe);
		Thread.sleep(50000);

		String url=w.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(2000);

		cl_click(saveNContinueBtn);
		System.out.println("Without Signatory,press save and continue button: "+withoutSignSaveBtn.getText());
		Thread.sleep(1000);
		cl_click(okBtn);
		int signatorysize=signatoryList.size();

		System.out.println("signatory: "+signatoryList.size());

		//for having only one doc --Signatory
		for(int k=1;k<=signatorysize;k++) {
			cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
			cl_click(w.findElement(By.xpath(signatoryRButton.replace("#DELIM#",String.valueOf(k)))));
			Thread.sleep(2000);
			cl_click(applyBtn);
			Thread.sleep(1000);
		}
		Thread.sleep(4000);
		cl_click(saveNContinueBtn);
		Thread.sleep(10000);
		cl_click(dsign);
		Thread.sleep(4000);
		int ss = signs.size();
		Random r = new Random();
		int n = r.nextInt(ss);
		if(n == 0) {
			n=n+1;
		}
		Thread.sleep(3000);
		cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(3000);
		cl_click(signbutton);
		Thread.sleep(20000);
		b.getScreenshot();

	}


	public void selectWorkflow1(WebDriver driver) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String wfname=Utility.getpropertydetails("WorkflowName");
		WebElement fe = w.findElement(By.xpath(selectWf.replace("#DELIM#",String.valueOf(wfname))));	
		js.executeScript("arguments[0].scrollIntoView();",fe);
		cl_click(fe);
		Thread.sleep(10000);
		String file=Utility.getpropertydetails("PDF");
		cl_entertext(chooseFile, file);
		Thread.sleep(5000);
		cl_click(continueBtn);
		Thread.sleep(5000);
		log.info("Continue button is clicked");
		cl_click(saveNContinueBtn);
		System.out.println("Without Signatory,press save and continue button: "+withoutSignSaveBtn.getText());
		Thread.sleep(1000);
		cl_click(okBtn);
		int signatorysize=signatoryList.size();

		//for having only one doc --Signatory
		for(int k=1;k<=signatorysize;k++) {
			cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
			cl_click(w.findElement(By.xpath(signatoryRButton.replace("#DELIM#",String.valueOf(k)))));
			Thread.sleep(2000);
			cl_click(applyBtn);
			Thread.sleep(3000);
			Thread.sleep(4000);
			cl_click(saveNContinueBtn);
			Thread.sleep(10000);
			cl_click(dsign);
			log.info("dsign button is clicked");
			int ss = signs.size();
			Random r = new Random();
			int n = r.nextInt(ss);
			Thread.sleep(3000);
			if(n==0) {
				n=n+1;
			}
			cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(3000);
			cl_click(signbutton);
			Thread.sleep(50000);
			log.info("Sign button is picked");
			b.getScreenshot();
		}
	}

	public void wfActivity(WebDriver driver) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String wfname=Utility.getpropertydetails("FlexiWorkflowName");
		WebElement fe = w.findElement(By.xpath(selectWf.replace("#DELIM#",String.valueOf(wfname))));		
		js.executeScript("arguments[0].scrollIntoView();",fe);
		cl_click(fe);
		Thread.sleep(50000);

		int signatorysize=signatoryList.size();

		System.out.println("signatory: "+signatoryList.size());

		//for having only one doc --Signatory
		for(int k=1;k<=signatorysize;k++) {
			cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
			cl_click(w.findElement(By.xpath(signradioBtn.replace("#DELIM#",String.valueOf(k)))));
			//cl_click(signradioBtn);
			Thread.sleep(2000);
			cl_click(applyBtn);
			Thread.sleep(1000);
		}
		Thread.sleep(4000);
		cl_click(saveNContinueBtn);
		Thread.sleep(3000);
		cl_click(btnFinalSend);
		Thread.sleep(6000);
		String msg=msgcontent.getText();
		System.out.println(msg);
		cl_click(okBtn);
		Thread.sleep(1000);
//		boolean docPage = DocumentMode.isDisplayed();
//		System.out.println("Document page is displayed?: "+docPage);
//		Thread.sleep(2000);
		cl_click(dashboard);
		Thread.sleep(4000);
	}

	public void wfExcel(String wfname) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor)w;	
		WebElement fe = w.findElement(By.xpath(selectWf.replace("#DELIM#",String.valueOf(wfname))));		
		js.executeScript("arguments[0].scrollIntoView();",fe);
		cl_click(fe);
		Thread.sleep(50000);

		String url=w.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(2000);

		cl_click(saveNContinueBtn);
		System.out.println("Without Signatory,press save and continue button: "+withoutSignSaveBtn.getText());
		Thread.sleep(1000);
		cl_click(okBtn);
		int signatorysize=signatoryList.size();

		System.out.println("signatory: "+signatoryList.size());

		//for having only one doc --Signatory
		for(int k=1;k<=signatorysize;k++) {
			cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
			cl_click(w.findElement(By.xpath(signatoryRButton.replace("#DELIM#",String.valueOf(k)))));
			Thread.sleep(2000);
			cl_click(applyBtn);
			Thread.sleep(1000);
		}
		JavascriptExecutor executor = (JavascriptExecutor)w;
		executor.executeScript("arguments[0].click();", brwseExternlFile);
		//cl_click(brwseExternlFile);
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\ExcelFile\\excelBrowse.exe");
		cl_click(previewdata);
		Thread.sleep(2000);
		cl_click(previewdataClseBtn);
		Thread.sleep(2000);
		cl_click(saveNContinueBtn);
		Thread.sleep(2000);
		if(BulkUploadmsgcontent.isDisplayed()) {
			cl_click(btnUploadContinue);
			Thread.sleep(1000);
		}
		String msg=msgcontent.getText();
		System.out.println("Message: "+msg);
	
		cl_click(NoBtn);
		Thread.sleep(4000);
		int ss = signs.size();
		Random r = new Random();
		int n = r.nextInt(ss);
		if(n == 0) {
			n=n+1;
		}
		Thread.sleep(3000);
		cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(3000);
//		
//		JavascriptExecutor executor1 = (JavascriptExecutor)w;
//		executor.executeScript("arguments[0].click();", signbutton);
//		//((JavascriptExecutor)w).executeScript("arguments[0].scrollIntoView();", signbutton);
		//cl_click(signbutton);
		Thread.sleep(4000);
		((JavascriptExecutor)w).executeScript("arguments[0].scrollIntoView();", btnInitiatesign);
		cl_click(btnInitiatesign);
		Thread.sleep(20000);
		String msg1=successMsg.getText();
		System.out.println("Message: "+msg1);
	}

	public void wfExcelDrafts(String wfname) throws Exception{
			cl_click(dashboard);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)w;	
			WebElement fe = w.findElement(By.xpath(selectWf.replace("#DELIM#",String.valueOf(wfname))));		
			js.executeScript("arguments[0].scrollIntoView();",fe);
			cl_click(fe);
			Thread.sleep(50000);

			String url=w.getCurrentUrl();
			System.out.println(url);
			Thread.sleep(2000);

			cl_click(saveNContinueBtn);
			System.out.println("Without Signatory,press save and continue button: "+withoutSignSaveBtn.getText());
			Thread.sleep(1000);
			cl_click(okBtn);
			int signatorysize=signatoryList.size();

			System.out.println("signatory: "+signatoryList.size());

			//for having only one doc --Signatory
			for(int k=1;k<=signatorysize;k++) {
				cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
				cl_click(w.findElement(By.xpath(signatoryRButton.replace("#DELIM#",String.valueOf(k)))));
				Thread.sleep(2000);
				cl_click(applyBtn);
				Thread.sleep(1000);
			}
			JavascriptExecutor executor = (JavascriptExecutor)w;
			executor.executeScript("arguments[0].click();", brwseExternlFile);
			//cl_click(brwseExternlFile);
			Thread.sleep(2000);
			Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\ExcelFile\\excelBrowse.exe");
			cl_click(previewdata);
			Thread.sleep(2000);
			cl_click(previewdataClseBtn);
			Thread.sleep(2000);
			cl_click(saveNContinueBtn);
			Thread.sleep(2000);
			if(BulkUploadmsgcontent.isDisplayed()) {
				cl_click(btnUploadContinue);
				Thread.sleep(1000);
			}
			String msg=msgcontent.getText();
			System.out.println("Message: "+msg);
			
			cl_click(yesBtn);
			Thread.sleep(40000);
			String msg1=successMsg.getText();
			System.out.println("Message: "+msg1);
	}

	public void wfExtrnlInvalidFile(String wfname,String sheetname,String scrptName) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)w;	
		WebElement fe = w.findElement(By.xpath(selectWf.replace("#DELIM#",String.valueOf(wfname))));		
		js.executeScript("arguments[0].scrollIntoView();",fe);
		cl_click(fe);
		Thread.sleep(50000);

		String url=w.getCurrentUrl();
		
		Thread.sleep(2000);
		int signatorysize=signatoryList.size();

		System.out.println("signatory: "+signatoryList.size());

		//for having only one doc --Signatory
		for(int k=1;k<=signatorysize;k++) {
			cl_click(w.findElement(By.xpath(signatory.replace("#DELIM#",String.valueOf(k)))));					
			cl_click(w.findElement(By.xpath(signatoryRButton.replace("#DELIM#",String.valueOf(k)))));
			Thread.sleep(2000);
			cl_click(applyBtn);
			Thread.sleep(1000);
		}
		JavascriptExecutor executor = (JavascriptExecutor)w;
		executor.executeScript("arguments[0].click();", brwseExternlFile);
//		cl_click(brwseExternlFile);
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\ExcelFile\\InvalidFile.exe");
		String msg=msgcontent1.getText();
		Thread.sleep(2000);
		cl_click(okBtn);
		Thread.sleep(2000);
		Utility.comparelogic(msg, sheetname, scrptName);
	}

	public void wfExcelInvalid(String wfname,String sheetname,String scrptName) throws Exception {
		
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)w;
		executor.executeScript("arguments[0].click();", brwseExternlFile);
//		cl_click(brwseExternlFile);
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\ExcelFile\\InvalidExcel.exe");
		Thread.sleep(2000);
		cl_click(saveNContinueBtn);
		Thread.sleep(3000);
		String msg=msgcontent2.getText();
		Thread.sleep(2000);
		System.out.println(msg);
		cl_click(okBtn);
		Thread.sleep(2000);
		Utility.comparelogic(msg, sheetname, scrptName);
		
	}

	
}

