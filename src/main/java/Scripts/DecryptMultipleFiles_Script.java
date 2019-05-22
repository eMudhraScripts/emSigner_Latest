package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_DecryptPage;
import Page_Factory.pf_Settings;

public class DecryptMultipleFiles_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(Decrypt_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{
		pf_Settings set=new pf_Settings(w);
		et =  es.startTest("Settings Page");
		set.settings();
	}
	@Test(dataProvider= "Decrypt_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=2,groups={"SMK","REG"})
	public void mltpleFilesDecryptPage(Map hm) throws Exception{

		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetname="Decrypt";

		pf_DecryptPage decrypt=new pf_DecryptPage(w);
		if(scriptname.equals("MultpleCancelBtnLndngPage")){
			et =  es.startTest("Decrypt: "+tcid);
			//click on Decrypt button and Verify cancel button
			decrypt.MultpleverifyDecryptCancelBtn(sheetname,scriptname);
			pf_Settings set=new pf_Settings(w);
			set.settings();
			}

			if(scriptname.equals("MultpleDecryptNowBtnMsg")){
				et =  es.startTest("Decrypt MultipleFile: "+tcid);
				decrypt.MultpleverifyDecrypt(sheetname,scriptname);
			}
			//verifying browse document by passing source,dest folder path
			else if(scriptname.equals("MultpleDecryptNowBtnDestMsg")){
				et =  es.startTest("Decrypt MultipleFile: "+tcid);
				decrypt.MultpledecryptNow(sheetname,scriptname);
			}
	}

}
