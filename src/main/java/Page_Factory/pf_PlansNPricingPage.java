package Page_Factory;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_PlansNPricingPage extends pf_genericmethods {

	final static Logger log = Logger.getLogger(pf_PlansNPricingPage.class);

	Basefunctions b = new Basefunctions();
	
	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav navbar-right']/li[4]/button") WebElement planNPrice;
	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav navbar-right']/li[4]/div/a[1]") WebElement emSigner;
	@FindBy(how = How.XPATH, using = "//*[@id=\"planTabContent2\"]/div[1]/div/div[2]/a") WebElement basicGetNow;
	@FindBy(how = How.ID, using = "ddlbilling") WebElement billFreqncy;
	@FindBy(how = How.ID, using = "noOfsignaturs") WebElement noOfSigners;
	@FindBy(how = How.ID, using = "msgcontent") WebElement msgcontent;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	
	//TDS 
	@FindBy(how = How.ID, using = "chkTDS") WebElement chkTDS;
	@FindBy(how = How.ID, using = "TanNo") WebElement TanNo;
	
	//Name
	@FindBy(how = How.ID, using = "Name") WebElement Name;	
	@FindBy(how = How.ID, using = "Contact_Number") WebElement contactNumber;	
	@FindBy(how = How.ID, using = "Email_Id") WebElement emailId;	
	@FindBy(how = How.ID, using = "Organization") WebElement organization;
	//Billing address	
	@FindBy(how = How.ID, using = "Address") WebElement address;	
	@FindBy(how = How.ID, using = "City") WebElement city;	
	@FindBy(how = How.ID, using = "ddlBillState") WebElement ddlBillState;
	@FindBy(how = How.ID, using = "Pincode") WebElement pincode;
	
	
	@FindBy(how = How.ID, using = "ChkShipAdress") WebElement chkShipAdress;
	//shipping address
	@FindBy(how = How.ID, using = "ShipAddress") WebElement shipAddress;	
	@FindBy(how = How.ID, using = "ShipCity") WebElement shipCity;	
	@FindBy(how = How.ID, using = "ddlShipState") WebElement ddlShipState;
	@FindBy(how = How.ID, using = "ShipPincode") WebElement shipPincode;
	@FindBy(how = How.ID, using = "Captcha") WebElement Captcha;
	@FindBy(how = How.ID, using = "btnPurchase") WebElement btnPurchase;
	
	public pf_PlansNPricingPage(WebDriver driver){

		PageFactory.initElements(driver, this);
		
	}

	public void planemSigner(String billFreqncy2, String noOfSigns, String tds,String tanNo,String name2, String conctNo,
			String emailId2, String cmpny, String billAdd, String billCity, String billState, String billPin,
			String shipAddReq, String shipAdd, String shipCity2, String shipState, String shipPin, String sheetName,
			String scriptname) throws Exception {
		Actions a = new Actions(w);
		a.moveToElement(planNPrice).build().perform();
		cl_click(emSigner);
		cl_click(basicGetNow);
		Thread.sleep(1000);
		Select s=new Select(billFreqncy);
		s.selectByVisibleText(billFreqncy2);
//		noOfSigners.clear();
//		Thread.sleep(2000);
//		cl_entertext(noOfSigners, noOfSigns);
//		String signNum=noOfSigners.getAttribute("value");
//		System.out.println(signNum);
//		int c=Integer.parseInt(signNum);
//		System.out.println(c);
//		if(c<=10) {
//			String msg=msgcontent.getText();
//			System.out.println(msg);
//			cl_click(okBtn);
//		}
//		else {
		
		Thread.sleep(2000);
		if(tds.equalsIgnoreCase("Y")) {
			cl_click(chkTDS);
			cl_entertext(TanNo, tanNo);
		}
		cl_entertext(Name, name2);
		cl_entertext(contactNumber, conctNo);
		cl_entertext(emailId, emailId2);
		cl_entertext(organization, cmpny);
		cl_entertext(address, billAdd);
		cl_entertext(city, billCity);
		Select s1=new Select(ddlBillState);
		s1.selectByVisibleText(billState);
		JavascriptExecutor js=(JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();", pincode);	
		cl_entertext(pincode, billPin);
		Thread.sleep(3000);
		System.out.println(shipAddReq);
		if(shipAddReq.equalsIgnoreCase("N")) {		
			cl_click(chkShipAdress);
			cl_entertext(shipAddress, shipAdd);
			cl_entertext(shipCity, shipCity2);
			Select s2=new Select(ddlShipState);
			s2.selectByVisibleText(shipState);
			cl_entertext(shipPincode, shipPin);
			Thread.sleep(3000);
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Captcha");
		String cap=sc.nextLine();
		cl_entertext(Captcha, cap);
		Thread.sleep(4000);
		JavascriptExecutor j=(JavascriptExecutor)w;
		j.executeScript("arguments[0].scrollIntoView();", btnPurchase);
		cl_click(btnPurchase);
		Thread.sleep(5000);
		b.getScreenshot();
//		}
	}
}
