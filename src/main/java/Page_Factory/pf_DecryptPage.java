package Page_Factory;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_DecryptPage extends pf_genericmethods {

	final static Logger log = Logger.getLogger(pf_DecryptPage.class);
	
	@FindBy(how = How.XPATH, using = "//div/h1[@class='title']") WebElement decyptTitle;
	//@FindBy(how = How.XPATH, using = "//span[text()='Encrypt & Decrypt']") WebElement encryptDecrypt;
	@FindBy(how = How.XPATH, using = "//*[@id=\"frmappSettings\"]/div/div[3]/div[8]/a") WebElement decryptBtn;
	@FindBy(how = How.ID, using = "frmDecrypt") WebElement decryptPage;
	@FindBy(how = How.ID, using = "rdSingle") WebElement singleRdBtn;
	@FindBy(how = How.ID, using = "rdMultiple") WebElement multpleRdBtn;
	@FindBy(how = How.ID, using = "btnProcess") WebElement decryptNow;
	@FindBy(how = How.ID, using = "btnCancel") WebElement cancelBtn;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please upload')]") WebElement decryptNowMsg;	
	//source folder
	@FindBy(how = How.ID, using = "btnSingle") WebElement souceFoldr;
	//dest folder
	@FindBy(how = How.ID, using = "btnMultiple") WebElement destFoldr;
	//without dest folder decrypt now 
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Please choose')]") WebElement destencryptNowMsg;

	//success msg
	@FindBy(how = How.XPATH, using = "//div[text()='Decryption successfully done.']") WebElement decyptSucccessMsg;

	public pf_DecryptPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void verifyDecryptCancelBtn(String sheetname,String scriptname) throws Exception {
		cl_click(decryptBtn);
		et.log(LogStatus.PASS,"Decrypt button present in Settings page is clicked- passed");
		System.out.println("Decrypt page title: "+decyptTitle.getText());
		
		if(singleRdBtn.isSelected()) {
			System.out.println("single radio button is selected");
		}else {
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
		}

		cl_click(cancelBtn);
		et.log(LogStatus.PASS,"Cancel button is clicked when single radio button- passed");
		String url=w.getCurrentUrl();
		Utility.comparelogic(url,sheetname,scriptname);		
	}

	public void verifyDecrypt(String sheetname,String scriptname) throws Exception {

		log.info("--Decrypt page--");
		cl_click(decryptBtn);
		et.log(LogStatus.PASS,"Decrypt button present in Settings page is clicked- passed");
		if(decryptPage.isDisplayed()) {
			System.out.println("Decrypt page is displayed");
		}else {
			Basefunctions.getScreenshot();
			System.out.println("Screenshot taken");
		}
		cl_click(decryptNow);
		Thread.sleep(2000);
		String msg=decryptNowMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Decrypt Now button without source & Dest path- passed");
		Utility.comparelogic(msg,sheetname,scriptname);
	}

	public void decryptNow(String sheetname,String scriptname) throws Exception {
		cl_click(souceFoldr);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\sourceFolder\\source.exe");
		Thread.sleep(6000);
		cl_click(decryptNow);
		Thread.sleep(2000);
		String destMsg=destencryptNowMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"DecryptNow button is clicked only with Source path- passed");
		Utility.comparelogic(destMsg,sheetname,scriptname);
		cl_click(destFoldr);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\destFolder\\destfolder.exe");
		Thread.sleep(4000);
		cl_click(decryptNow);
		Thread.sleep(20000);
		et.log(LogStatus.PASS,"DecryptNow button is clicked with Source & Dest path- passed");
		Basefunctions.getScreenshot();
		System.out.println("Screenshot of Decrypt WebSocket is taken");
	}

	public void MultpleverifyDecryptCancelBtn(String sheetname, String scriptname) throws Exception {
		cl_click(decryptBtn);
		et.log(LogStatus.PASS,"Decrypt button present in Settings page is clicked- passed");
		Thread.sleep(3000);
		cl_click(multpleRdBtn);
		et.log(LogStatus.PASS,"Mutliple Radio button is clicked- passed");
		cl_click(cancelBtn);
		et.log(LogStatus.PASS,"Cancel button is clicked when multiple radio button- passed");
		String url=w.getCurrentUrl();
		Utility.comparelogic(url,sheetname,scriptname);	
		
	}

	public void MultpleverifyDecrypt(String sheetname, String scriptname) throws Exception  {
		log.info("--Decrypt page--");
		cl_click(decryptBtn);
		Thread.sleep(2000);
		cl_click(multpleRdBtn);
		Thread.sleep(2000);
		cl_click(decryptNow);
		Thread.sleep(2000);
		String msg=decryptNowMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"Decrypt Now button without source & Dest path- passed");
		Utility.comparelogic(msg,sheetname,scriptname);
		
	}

	public void MultpledecryptNow(String sheetname, String scriptname) throws Exception  {
		cl_click(souceFoldr);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\MultipleEncrypt\\dcryptSource.exe");
		Thread.sleep(6000);
		cl_click(decryptNow);
		Thread.sleep(2000);
		String destMsg=destencryptNowMsg.getText();
		cl_click(okBtn);
		et.log(LogStatus.PASS,"DecryptNow button is clicked only with Source path- passed");
		Utility.comparelogic(destMsg,sheetname,scriptname);

		cl_click(destFoldr);
		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\MultipleEncrypt\\decyptDest.exe");
		Thread.sleep(4000);
		cl_click(decryptNow);
		Thread.sleep(20000);
		et.log(LogStatus.PASS,"DecryptNow button is clicked with Source & Dest path- passed");
		Basefunctions.getScreenshot();
		System.out.println("Screenshot of Decrypt WebSocket is taken");
		
	}


}
