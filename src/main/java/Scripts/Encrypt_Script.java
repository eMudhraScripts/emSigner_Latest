package Scripts;


import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_EncryptPage;
import Page_Factory.pf_Settings;
import Page_Factory.pf_loginpage;

public class Encrypt_Script extends Basefunctions {
	
	final static Logger log = Logger.getLogger(Encrypt_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{
		pf_Settings set=new pf_Settings(w);
		et =  es.startTest("Settings Page");
		set.settings();
	}
	
	@Test(dataProvider= "Encrypt_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=2,groups={"SMK","REG"})
	public void EncryptPage(Map hm) throws Exception{	
		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="Encrypt";

		pf_EncryptPage encrypt=new pf_EncryptPage(w);
		
		if(scriptname.equals("CancelBtnLndngPage")){
			//click on Encrypt button and Verify cancel button
			et =  es.startTest("Encrypt CancelBtn: "+tcid);
			encrypt.verifyEncryptCancelBtn(sheetName,scriptname);
			pf_Settings set=new pf_Settings(w);
			set.settings();
			
		}

		 if(scriptname.equals("EncryptNowBtnMsg")){
			et =  es.startTest("Encrypt: "+tcid);
			encrypt.verifyEncrypt(sheetName,scriptname);
		}

		else if(scriptname.equals("EncryptNowBtnDestMsg")){
			et =  es.startTest("Encrypt SingleFile: "+tcid);
			//verifying browse document by passing source
			encrypt.encryptNow(sheetName,scriptname);
		}

		else if(scriptname.equals("EncryptNowBtnCMsg")){
			et =  es.startTest("Encrypt SingleFile: "+tcid);
			//verifying browse document by passing source,dest path
			encrypt.encryptNowSourceDest(sheetName,scriptname);
		}

		else if(scriptname.equals("EncryptNowSuccess")){
			et =  es.startTest("Encrypt SingleFile: "+tcid);
			//verifying browse document by passing source,dest,certificate folder path
			encrypt.encryptNowSourceDestCert(sheetName,scriptname);
		}
		 
		else if(scriptname.equals("MltpleCancelBtnLndngPage")){
				//click on Encrypt button and Verify cancel button
				et =  es.startTest("Encrypt: "+tcid);
				encrypt.mulverifyEncryptCancelBtn(sheetName,scriptname);
				pf_Settings set=new pf_Settings(w);
				set.settings();
				
			}

			 if(scriptname.equals("MltpleEncryptNowBtnMsg")){
				et =  es.startTest("Encrypt MultipleFile: "+tcid);
				encrypt.mlpleverifyEncrypt(sheetName,scriptname);
			}

			else if(scriptname.equals("MltpleEncryptNowBtnDestMsg")){
				et =  es.startTest("Encrypt MultipleFile: "+tcid);
				//verifying browse document by passing source
				encrypt.multpleEncryptNow(sheetName,scriptname);
			}

			else if(scriptname.equals("MltpleEncryptNowBtnCMsg")){
				et =  es.startTest("Encrypt MultipleFile: "+tcid);
				//verifying browse document by passing source,dest path
				encrypt.mulpleEncryptNowSourceDest(sheetName,scriptname);
			}

			else if(scriptname.equals("MltpleEncryptNowSuccess")){
				et =  es.startTest("Encrypt MultipleFile: "+tcid);
				//verifying browse document by passing source,dest,certificate folder path
				encrypt.encryptNowSourceDestCert(sheetName,scriptname);
			}


	}
}
