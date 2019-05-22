package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_PlansNPricingPage;

public class PlansNPricing_Script extends Basefunctions{

	final static Logger log = Logger.getLogger(PlansNPricing_Script.class);
	

	@Test(dataProvider= "plan_price",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void plansPricing(Map hm) throws Exception{	
		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="PlanPricing";
		et =  es.startTest("Pricing: ");
		
		String billFreqncy=hm.get("Bill_Frequency").toString();
		String noOfSigns=hm.get("No_of_Sign").toString();
		String tds=hm.get("TDS").toString();
		String tanNo=hm.get("Tan_No").toString();	
		String name=hm.get("Name").toString();
		String conctNo=hm.get("ContactNo").toString();
		String emailId=hm.get("EmailID").toString();
		String cmpny=hm.get("Company").toString();
		String billAdd=hm.get("BillAdd").toString();
		String billCity=hm.get("BillCity").toString();
		String billState=hm.get("BillState").toString();
		String billPin=hm.get("BillPincode").toString();
		
		String ShipAddReq=hm.get("ShipingAddress").toString();
		String shipAdd=hm.get("ShipAdd").toString();
		String shipCity=hm.get("ShipCity").toString();
		String shipState=hm.get("ShipState").toString();
		String shipPin=hm.get("ShipPincode").toString();
		pf_PlansNPricingPage p=new pf_PlansNPricingPage(w);
		if(scriptname.equalsIgnoreCase("BasicGetNow")) {
			p.planemSigner(billFreqncy,noOfSigns,tds,tanNo,name,conctNo,emailId,cmpny,billAdd,billCity,billState,billPin,ShipAddReq,shipAdd,shipCity,shipState,shipPin,sheetName,scriptname);
		}
		
	}
}
