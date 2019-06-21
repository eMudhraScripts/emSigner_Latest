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

public class pf_CreateDocPage  extends pf_genericmethods  {

	Basefunctions b = new Basefunctions();
	final static Logger log = Logger.getLogger(pf_CreateDocPage.class);

	@FindBy(how = How.XPATH, using = "//*[@id=\"TopMenu\"]/ul/li[1]/a/span") public WebElement dashboard;
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-menu-wrapper\"]/a[2]/span") WebElement createDoc;
	//@FindBy(how = How.ID, using = "tinymce") WebElement createDocContent;
	@FindBy(how = How.XPATH, using = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders ICE-Tracking']") WebElement createDocContent;
	@FindBy(how = How.XPATH, using = "//div[@id='signatoryDelete_1']/i") WebElement reviewCrossButton;
	@FindBy(how = How.ID, using = "msgcontent") WebElement msgcontent;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Document Reviewed')]") WebElement msgcontent1;

	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	@FindBy(how = How.ID, using = "sigdocument") WebElement sigdocument;

	@FindBy(how = How.XPATH, using = "//*[@id='docNameBlock']/span[2]/a") WebElement editDocNameBtn;
	@FindBy(how = How.ID, using = "txtdocument") WebElement txtdocument;
	@FindBy(how = How.XPATH, using = "//div[@class='document-details']/div[2]/div/input[1]") WebElement applyBtn;
	@FindBy(how = How.XPATH, using = "//ul[@id='signdocument']/li/a") WebElement setReviewer;

	@FindAll({@FindBy(how = How.XPATH, using = "//*[@id=\"profileListScroll\"]/li")}) public List<WebElement> reviewerList;
	String reviewer="//*[@id=\"profileListScroll\"]/li[#DELIM#]/span[1]/input";
	@FindBy(how = How.ID, using = "btnReviewerSave") WebElement btnReviewerSave;
	@FindBy(how = How.ID, using = "btnRadioUpdate") WebElement saveToDraft;
	@FindBy(how = How.ID, using = "btnstep1Documents") WebElement sendReviewer;

	//Draft
	@FindBy(how = How.ID, using = "status-notstarted") WebElement draftBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form[1]/div[5]/section/header/div/a[1]") WebElement searchDraftBtn;
	@FindBy(how = How.ID, using = "workflowName") WebElement searchCatgry;
	@FindBy(how = How.ID, using = "btnSearch") WebElement btnSearch;
	@FindBy(how = How.ID, using = "btnClear") WebElement btnClear;
	@FindBy(how = How.XPATH, using = "//li[text()='Create Document']") WebElement createDocSearch;
	@FindBy(how = How.ID, using = "btnExport") WebElement btnExport;

	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='tblDrafts']/tbody/tr")}) public List<WebElement> createDocList;
	String draftStatus="//*[@id=\"tblDrafts\"]/tbody/tr[#DELIM#]/td[8]/span";
	String action="//*[@id=\"tblDrafts\"]/tbody/tr[#DELIM#]/td[9]/ul/li/a/i";
	//send for review again
	@FindBy(how = How.ID, using = "btnRadioUpdate1") WebElement sendforReview;
	//publish
	@FindBy(how = How.ID, using = "btnStep1Continue") WebElement publish;
	//save and continue button
	@FindBy(how = How.ID, using = "btnstep1") WebElement saveCntnueBtn;
	@FindBy(how = How.XPATH, using = "//span[text()='Add Signatory']") WebElement addSignatory;
	@FindBy(how = How.XPATH, using = "//a[text()='Signatory  1']") WebElement addSign;
	//first Radio button(ME)
	@FindBy(how = How.XPATH, using = "//*[@title='ME']") WebElement radioBtn;
	//apply button
	@FindBy(how = How.ID, using = "btnSignatorySave") WebElement signapplyBtn;

	@FindBy(how = How.XPATH, using = "//div[@id='docSignerRight']/div[1]/ul/li/ul/li/span/span/div/input") WebElement tempName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[1]/div/div/h1") WebElement header;
	@FindBy(how = How.ID, using = "dsign") public WebElement dsign; 
	@FindBy(how = How.ID, using = "esignature") public WebElement esignature;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='sign-font-block']/ul/li")}) public List<WebElement> signs;
	String si = "//div[@class='innertab-panel']/div/ul/li[#DELIM#]/span[2]";
	@FindBy(how = How.ID, using = "btnradiosign") WebElement signbutton;
	@FindBy(how = How.ID, using = "rbtSerial") WebElement rbtSerial;
	
	@FindBy(how = How.ID, using = "btnFinalSend") public WebElement btnFinalSend;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'successfully')]") public WebElement finalSendMsg;
	//Download all button
	@FindBy(how = How.ID, using = "btnDownload") WebElement btnDownloadAll;
	
	public pf_CreateDocPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void createDoc() throws Exception {

		cl_click(createDoc);	
		Thread.sleep(4000);
		log.info("Create Document is clicked");
		et.log(LogStatus.PASS,"Create Doc button is clicked- passed");
		w.switchTo().frame(0);
		String docCn=Utility.getpropertydetails("CreateDocContent");
		cl_entertext(createDocContent,docCn);
		Thread.sleep(2000);
		w.switchTo().defaultContent();
		cl_click(reviewCrossButton);
		String msg=msgcontent.getText();
		cl_click(okBtn);
		System.out.println("Msg when we click on cross button of Reviewer1: "+msg);
		Thread.sleep(2000);
		cl_click(sigdocument);
		cl_click(reviewCrossButton);
		Thread.sleep(2000);
		String msg1=msgcontent.getText();
		cl_click(okBtn);
		System.out.println("Add Reviewer and remove that reviewer msg: "+msg1);
		Thread.sleep(2000);
		cl_click(editDocNameBtn);
		Thread.sleep(2000);
		String name=txtdocument.getAttribute("value");
		System.out.println("Name of the created doc: "+name);
		cl_click(applyBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Apply button present in Doc name edit is clicked- passed");
		cl_click(setReviewer);
		log.info("Send Review button is clicked");

		/*int size=reviewerList.size();
		Random r=new Random();
		int n=r.nextInt(size);
		System.out.println(n);
		if(n==0) {
			n=n+1;
		}
		cl_click(b.w.findElement(By.xpath(reviewer.replace("#DELIM#",String.valueOf(n)))));*/
		cl_click(radioBtn);
		cl_click(btnReviewerSave);
		Thread.sleep(2000);
		cl_click(sendReviewer);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Send Review button is clicked- passed");
		String msg2=msgcontent1.getText();
		cl_click(okBtn);
		System.out.println("Document review success msg: "+msg2);
	}

	public void saveToDraftCheck(String templateName) throws Exception {

		cl_click(draftBtn);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Drafts tab in dashboard page is clicked- passed");
		log.info("Draft tab is clicked");
		cl_click(searchDraftBtn);
		log.info("Search button in Draft tab is clicked");
		et.log(LogStatus.PASS,"Search button in drafts is clicked- passed");
		cl_click(btnClear);
		Thread.sleep(2000);
		cl_entertext(searchCatgry, "Create");
		cl_click(createDocSearch);
		Thread.sleep(2000);
		cl_click(btnSearch);
		Thread.sleep(4000);
		cl_click(btnExport);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Create doc category Exported to Excel in drafts- passed");
		int dsize=createDocList.size();
		System.out.println("dsize"+dsize);
		Random r1=new Random();
		int n1=r1.nextInt(dsize);
		if(n1==0) {
			n1=n1+1;
		}
		WebElement status = b.w.findElement(By.xpath(draftStatus.replace("#DELIM#",String.valueOf(n1))));
		String dstatus=status.getText();
		cl_click(b.w.findElement(By.xpath(action.replace("#DELIM#",String.valueOf(n1)))));

		if(dstatus.contains("Edit")) {			
			et.log(LogStatus.PASS,"Picked record is of status 'Edits Completed by all'- passed");
			JavascriptExecutor j1 = (JavascriptExecutor)w;
			j1.executeScript("arguments[0].scrollIntoView();",publish);
			cl_click(publish);
			Thread.sleep(7000);
			et.log(LogStatus.PASS,"Publish the Document is clicked- passed");
			cl_click(saveCntnueBtn);
			String msg=msgcontent.getText();
			Thread.sleep(2000);
			System.out.println(msg);
			cl_click(okBtn);
			JavascriptExecutor j2 = (JavascriptExecutor)w;
			j2.executeScript("arguments[0].scrollIntoView();",rbtSerial);
			cl_click(addSignatory);
			Thread.sleep(2000);
			log.info("Add signatory is clicked");
			cl_click(addSign);
			cl_click(radioBtn);
			Thread.sleep(2000);
			cl_click(signapplyBtn);
			//			String templateName=Utility.getpropertydetails("createDocTemplateName");
			System.out.println("templateName: "+templateName);
			cl_entertext(tempName,templateName);
			cl_click(saveCntnueBtn);
			log.info("Save button clicked after adding template name");
			Thread.sleep(5000);
			if(msgcontent.isDisplayed()) {
				String alrtmsg=msgcontent.getText();
				Thread.sleep(2000);
				System.out.println(alrtmsg);
				cl_click(okBtn);
				Thread.sleep(2000);
				System.out.println("Screenshot Taken");
			}
			/*String alrtmsg=msgcontent.getText();
			Thread.sleep(2000);
			System.out.println(alrtmsg);
			try {
			if(alrtmsg.startsWith("Template name already")) {
				b.getScreenshot();
				System.out.println("Template name already exists");
				System.out.println("Screenshot Taken");
				//Assert.fail();
			}
			}catch(Exception e) {*/
			else {
			log.info("--dsign page--");
			//Thread.sleep(6000);
			JavascriptExecutor js1 = (JavascriptExecutor)w;
			//js1.executeScript("window.scrollBy(5000,0)");
			js1.executeScript("arguments[0].scrollIntoView();",header);
			Thread.sleep(2000);
			cl_click(dsign);
			Thread.sleep(2000);
			log.info("dsign radio button is clicked");
			et.log(LogStatus.PASS,"dsign radio button is clicked- passed");
			int ss = signs.size();
			Random r = new Random();
			int n = r.nextInt(ss);
			if(n==0) {
				n=n+1;
			}
			cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor)w;
			js.executeScript("arguments[0].scrollIntoView();",signbutton);
			cl_click(signbutton);
			Thread.sleep(20000);
			log.info("Sign button is clicked");
			et.log(LogStatus.PASS,"Sign button is clicked- passed");
			b.getScreenshot();
		}
				}
		else /*if(dstatus.contains("New Version"))*/ {
			et.log(LogStatus.PASS,"Picked record is of status 'New Version'- passed");
			cl_click(saveToDraft);
			et.log(LogStatus.PASS,"Save To Drafts button is clicked- passed");
			String msg=msgcontent.getText();
			Thread.sleep(2000);
			System.out.println(msg);
			cl_click(okBtn);
		}

	}

	public void saveToDraftCheck1(String templateName) throws Exception {
		cl_click(draftBtn);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Drafts tab in dashboard page is clicked- passed");
		log.info("Draft tab is clicked");
		cl_click(searchDraftBtn);
		log.info("Search button in Draft tab is clicked");
		et.log(LogStatus.PASS,"Search button in drafts is clicked- passed");
		cl_click(btnClear);
		Thread.sleep(2000);
		cl_entertext(searchCatgry, "Create");
		cl_click(createDocSearch);
		Thread.sleep(2000);
		cl_click(btnSearch);
		Thread.sleep(4000);
		cl_click(btnExport);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Create doc category Exported to Excel in drafts- passed");
		int dsize=createDocList.size();
		System.out.println("dsize"+dsize);
		Random r1=new Random();
		int n1=r1.nextInt(dsize);
		if(n1==0) {
			n1=n1+1;
		}
		WebElement status = b.w.findElement(By.xpath(draftStatus.replace("#DELIM#",String.valueOf(n1))));
		String dstatus=status.getText();
		cl_click(b.w.findElement(By.xpath(action.replace("#DELIM#",String.valueOf(n1)))));

		if(dstatus.contains("Edit")) {			
			et.log(LogStatus.PASS,"Picked record is of status 'Edits Completed by all'- passed");
			JavascriptExecutor j1 = (JavascriptExecutor)w;
			j1.executeScript("arguments[0].scrollIntoView();",publish);
			cl_click(publish);
			Thread.sleep(7000);
			et.log(LogStatus.PASS,"Publish the Document is clicked- passed");
			cl_click(saveCntnueBtn);
			String msg=msgcontent.getText();
			Thread.sleep(2000);
			System.out.println(msg);
			cl_click(okBtn);
			JavascriptExecutor j2 = (JavascriptExecutor)w;
			j2.executeScript("arguments[0].scrollIntoView();",rbtSerial);
			cl_click(addSignatory);
			Thread.sleep(2000);
			log.info("Add signatory is clicked");
			cl_click(addSign);
			cl_click(radioBtn);
			Thread.sleep(2000);
			cl_click(signapplyBtn);
			//			String templateName=Utility.getpropertydetails("createDocTemplateName");
			System.out.println("templateName: "+templateName);
			cl_entertext(tempName,templateName);
			cl_click(saveCntnueBtn);
			log.info("Save button clicked after adding template name");
			Thread.sleep(5000);
			if(msgcontent.isDisplayed()) {
				String alrtmsg=msgcontent.getText();
				Thread.sleep(2000);
				System.out.println(alrtmsg);
				cl_click(okBtn);
				Thread.sleep(2000);
				System.out.println("Screenshot Taken");
			}
			/*String alrtmsg=msgcontent.getText();
			Thread.sleep(2000);
			System.out.println(alrtmsg);
			try {
			if(alrtmsg.startsWith("Template name already")) {
				b.getScreenshot();
				System.out.println("Template name already exists");
				System.out.println("Screenshot Taken");
				//Assert.fail();
			}
			}catch(Exception e) {*/
			else {
			log.info("--dsign page--");
			//Thread.sleep(6000);
			JavascriptExecutor js1 = (JavascriptExecutor)w;
			//js1.executeScript("window.scrollBy(5000,0)");
			js1.executeScript("arguments[0].scrollIntoView();",header);
			Thread.sleep(2000);
			cl_click(esignature);
			Thread.sleep(2000);
			log.info("esignature radio button is clicked");
			et.log(LogStatus.PASS,"dsign radio button is clicked- passed");
			int ss = signs.size();
			Random r = new Random();
			int n = r.nextInt(ss);
			if(n==0) {
				n=n+1;
			}
			cl_click(w.findElement(By.xpath(si.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor)w;
			js.executeScript("arguments[0].scrollIntoView();",signbutton);
			cl_click(signbutton);
			Thread.sleep(20000);
			log.info("Sign button is clicked");
			et.log(LogStatus.PASS,"Sign button is clicked- passed");
			cl_click(btnFinalSend);
			Thread.sleep(2000);
			String msg1=finalSendMsg.getText();
			Thread.sleep(1000);
			System.out.println("Success message: "+msg1);
			cl_click(okBtn);
			Thread.sleep(6000);
			cl_click(btnDownloadAll);
			Thread.sleep(2000);
			cl_click(dashboard);
			Thread.sleep(3000);
		}
				}
		else /*if(dstatus.contains("New Version"))*/ {
			et.log(LogStatus.PASS,"Picked record is of status 'New Version'- passed");
			cl_click(saveToDraft);
			et.log(LogStatus.PASS,"Save To Drafts button is clicked- passed");
			String msg=msgcontent.getText();
			Thread.sleep(2000);
			System.out.println(msg);
			cl_click(okBtn);
		}

	}

}



