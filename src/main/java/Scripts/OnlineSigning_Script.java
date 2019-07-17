package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_OnlineSigningPage;


public class OnlineSigning_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(OnlineSigning_Script.class);

	@Test(dataProvider= "OnlineSign_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void onlineSign(Map hm) throws Exception{
		pf_OnlineSigningPage onlneSign=new pf_OnlineSigningPage(w);
		et =  es.startTest("Online signing-esign");

		String tle=hm.get("Title").toString();
		String cfMsg=hm.get("ConfigMsg").toString();
		String sMsg=hm.get("SucessMsg").toString();
		String scriptname=hm.get("Script_Name").toString();
		if(scriptname.equals("esign")) {
			onlneSign.onlineSignng(tle,cfMsg,sMsg);
		}
	}

	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void onlineSigndsign() throws Exception{
		pf_OnlineSigningPage onlneSign=new pf_OnlineSigningPage(w);
		et =  es.startTest("Online signing-dsign");
		onlneSign.onlineSignngdsign();
	}
}
