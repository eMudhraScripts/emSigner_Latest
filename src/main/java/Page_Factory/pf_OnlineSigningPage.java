package Page_Factory;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_OnlineSigningPage extends pf_genericmethods {

	Basefunctions b = new Basefunctions();
	final static Logger log = Logger.getLogger(pf_OnlineSigningPage.class);

	@FindBy(how = How.XPATH, using = "//*[@id=\"main-menu-wrapper\"]/a[3]/span") WebElement onlineSigning;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div[1]/div/h1") WebElement onlineSigningtitle;
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div[1]/div/h1/a/i") WebElement backbtn;
	
	@FindBy(how = How.ID, using = "btnpdfupload") WebElement btnpdfupload;
	@FindBy(how = How.ID, using = "draggableDiv_1_1") public WebElement signatorybox;
	@FindBy(how = How.XPATH, using = "//*[@id=\"spanSignature\"]") public WebElement signbox;
	@FindBy(how = How.ID, using = "signerContainment") public WebElement signercontainment;
	
	@FindBy(how = How.XPATH, using = "//*[@id='Mastersection']/a") WebElement addSign;
	
	@FindBy(how = How.ID, using = "fieldlinkPage_1-1") WebElement sign1; 
	//first Radio button(ME)
	@FindBy(how = How.XPATH, using = "//*[@title='ME']") WebElement radioBtn;
	//apply button
	@FindBy(how = How.ID, using = "btnSignatorySave") WebElement applyBtn; 
	@FindBy(how = How.ID, using = "Signatures-Sign") public WebElement SignaturesSign;
	//configure msg
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please configure')]") WebElement configureMsg;
	@FindBy(how = How.ID, using = "btnmsgok") public WebElement btnmsgok;
	@FindBy(how = How.XPATH, using = "//div[@class='documentContainment']/div/div") public WebElement signtr;
	@FindBy(how = How.XPATH, using = "//*[@id=\"sp_config_1\"]/i") public WebElement signSettng;
	//assigned to
	@FindBy(how = How.ID, using = "ddlSPSignatory") public WebElement asignSignTo;
	@FindBy(how = How.ID, using = "ddlPageSelection") public WebElement selectPage;
	
	@FindBy(how = How.ID, using = "btnConfigSave") public WebElement sapplybtn;
	
	
	@FindBy(how = How.ID, using = "esignature") public WebElement esignature;
	
	@FindBy(how = How.ID, using = "btnradiosignflex") public WebElement btnradiosignflex;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Workflow')]") WebElement WorkflowSucssMsg;
	
	@FindBy(how = How.ID, using = "dsign") public WebElement dsign;
	//sign option
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='sign-font-block']/ul/li")}) public List<WebElement> signs;	
	String sign = "//div[@class='innertab-panel']/div/ul/li[#DELIM#]/span[2]";
	
	public pf_OnlineSigningPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void onlineSignng(String tle,String cfMsg,String sMsg) throws Exception {
		cl_click(onlineSigning);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Online Signing tab is clicked- passed");
		String title=onlineSigningtitle.getText();
		Thread.sleep(1000);
		System.out.println(title);
		if(title.equals(tle)) {
			System.out.println("Actual Result and expected Result matches");
		}else {
			System.out.println("Actual Result and expected Result not matches");
		}
		cl_click(backbtn);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Online Signing back buton is clicked- passed");
		cl_click(onlineSigning);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Online Signing tab is clicked- passed");
		/*String pwpdfDoc=Utility.getpropertydetails("PasswordProtectedPDF");
		cl_entertext(btnpdfupload, pwpdfDoc);
		Thread.sleep(3000);*/
		String pdfDoc=Utility.getpropertydetails("PDF");
		cl_entertext(btnpdfupload, pdfDoc);
		Thread.sleep(5000);
		et.log(LogStatus.PASS,"PDF file is uploaded- passed");
		Actions a = new Actions(w);
		a.dragAndDropBy(signbox, 348,11).build().perform();
		Thread.sleep(5000);
		et.log(LogStatus.PASS,"Signature box is drag and dropped- passed");
		cl_click(addSign);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Add signatory button is clicked- passed");
		cl_click(sign1);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Signatory 1 is clicked- passed");
		cl_click(radioBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Me radio buton is clicked- passed");
		cl_click(applyBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Apply buton is clicked- passed");
		cl_click(SignaturesSign);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Sign buton is clicked- passed");
		String cmsg=configureMsg.getText();
		Thread.sleep(1000);
		System.out.println(cmsg);
		if(cmsg.equals(cfMsg)) {
			System.out.println("Actual Result and expected Result matches");
		}else {
			System.out.println("Actual Result and expected Result not matches");
		}
		cl_click(btnmsgok);
		Thread.sleep(2000);
		
		a.moveToElement(signtr).build().perform();
		cl_click(signSettng);
		et.log(LogStatus.PASS,"Sign setting buton present on signatory box is clicked- passed");
		Thread.sleep(3000);
		cl_click(asignSignTo);
		Select s2=new Select(asignSignTo);
		s2.selectByIndex(1);
		Thread.sleep(2000);
		/*Select s3=new Select(selectPage);
		s3.selectByIndex(3);*/
		cl_click(sapplybtn);
		Thread.sleep(2000);
		cl_click(SignaturesSign);
		Thread.sleep(5000);
		et.log(LogStatus.PASS,"Sign buton is clicked- passed");
		cl_click(esignature);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"eSignature radio buton is clicked- passed");
		cl_click(btnradiosignflex);
		Thread.sleep(6000);
		et.log(LogStatus.PASS,"Sign/Send buton is clicked- passed");
		String smsg=WorkflowSucssMsg.getText();
		System.out.println(smsg);
		cl_click(btnmsgok);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"ok buton is clicked- passed");
		if(smsg.equals(sMsg)) {
			System.out.println("Actual Result and expected Result matches");
		}else {
			System.out.println("Actual Result and expected Result not matches");
		}
		
	}

	public void onlineSignngdsign() throws Exception {	
		cl_click(onlineSigning);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Online Signing tab is clicked- passed");
		String pdfDoc=Utility.getpropertydetails("PDF");
		cl_entertext(btnpdfupload, pdfDoc);
		Thread.sleep(5000);
		et.log(LogStatus.PASS,"PDF file is uploaded- passed");
		Actions a = new Actions(w);
		a.dragAndDropBy(signbox, 348,11).build().perform();
		Thread.sleep(5000);
		et.log(LogStatus.PASS,"Signature box is drag and dropped- passed");
		cl_click(addSign);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Add signatory button is clicked- passed");
		cl_click(sign1);
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Signatory 1 is clicked- passed");
		cl_click(radioBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Me radio buton is clicked- passed");
		cl_click(applyBtn);
		Thread.sleep(2000);	
		et.log(LogStatus.PASS,"Apply buton is clicked- passed");
		a.moveToElement(signtr).build().perform();
		cl_click(signSettng);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Sign setting buton present on signatory box is clicked- passed");
		cl_click(asignSignTo);
		Select s2=new Select(asignSignTo);
		s2.selectByIndex(1);
		Thread.sleep(2000);
		/*Select s3=new Select(selectPage);
		s3.selectByIndex(3);*/
		cl_click(sapplybtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Apply buton is clicked- passed");
		cl_click(SignaturesSign);
		Thread.sleep(5000);
		et.log(LogStatus.PASS,"Sign buton is clicked- passed");
		cl_click(dsign);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"dSign radio buton is clicked- passed");
		int ss = signs.size();
		Random r = new Random();
		int n = r.nextInt(ss);
		if(n==0) {
			n=n+1;
		}
		cl_click(w.findElement(By.xpath(sign.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(7000);
		et.log(LogStatus.PASS,"Random sign radio buton is picked- passed");
		cl_click(btnradiosignflex);
		Thread.sleep(6000);
		et.log(LogStatus.PASS,"Sign/Send buton is clicked- passed");
	}
	
}
