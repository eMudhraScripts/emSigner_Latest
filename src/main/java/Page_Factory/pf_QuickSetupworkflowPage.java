package Page_Factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic_Library.Basefunctions;

public class pf_QuickSetupworkflowPage extends pf_genericmethods {
	Basefunctions b = new Basefunctions();
	final static Logger log = Logger.getLogger(pf_QuickSetupworkflowPage.class);

	@FindBy(how = How.XPATH, using = "//span[@id='quickSetup']/i") public WebElement qckSetupqustnMark;
	@FindBy(how = How.ID, using = "quickSetupContent") public WebElement quickSetupContent;
	@FindBy(how = How.ID, using = "quickSetupClose") public WebElement quickSetupClose;
	@FindBy(how = How.ID, using = "btnquicksetup") public WebElement btnquicksetup;
	@FindBy(how = How.ID, using = "btnaddgroup") public WebElement btnaddgroup;
	@FindBy(how = How.ID, using = "btnPowerFrom") public WebElement btnPowerFrom;
	@FindBy(how = How.ID, using = "btnStep1Continue") public WebElement btnStep1Continue;

	@FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/section/form/div[1]/div/div[1]/h1/a") public WebElement backBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='page-container row-fluid container-fluid']") public WebElement settingsPage;

	//dashboard
	@FindBy(how = How.XPATH, using = "//span[@class='lnk-storyboard']/i") public WebElement dashboardqustnMark;
	
	public pf_QuickSetupworkflowPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void quicksetup() throws Exception {
		cl_click(qckSetupqustnMark);
		Thread.sleep(2000);
		boolean result = quickSetupContent.isDisplayed();
		if(result==true) {
			System.out.println("Actual and expected matches");
		}else {
			System.out.println("Actual and expected not matches");
		}
		cl_click(quickSetupClose);
		Thread.sleep(2000);
		boolean result1 = quickSetupContent.isDisplayed();
		if(result1==false) {
			System.out.println("Actual and expected matches");
		}else {
			System.out.println("Actual and expected not matches");
		}
		cl_click(qckSetupqustnMark);
		Thread.sleep(2000);
		cl_click(btnquicksetup);
		Thread.sleep(3000);
		if(btnaddgroup.isDisplayed()==true && btnPowerFrom.isDisplayed()==true  && btnStep1Continue.isDisplayed()==true) {
			System.out.println("Actual and expected matches");
		}else {
			System.out.println("Actual and expected not matches");
		}

		cl_click(backBtn);
		Thread.sleep(3000);
		if(settingsPage.isDisplayed()) {
			System.out.println("Actual and expected matches");
		}else {
			System.out.println("Actual and expected not matches");
		}
	}

}
