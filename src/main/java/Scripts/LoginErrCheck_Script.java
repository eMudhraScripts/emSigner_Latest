package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_loginpage;

public class LoginErrCheck_Script extends Basefunctions {
	final static Logger log = Logger.getLogger(LoginErrCheck_Script.class);

	@Test(dataProvider= "login_page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void LoginErrCheck(Map hm) throws Exception{	

		String scriptname=hm.get("Script_Name").toString();
		String sheetName ="LoginErrCheck";
		String uid = hm.get("Uname").toString();
		String pas = hm.get("Pwd").toString();
		
		pf_loginpage pl = new pf_loginpage(w);
		if(scriptname.equals("LoginWithoutEmail")) {
			et =  es.startTest("Email Error Check");
			log.info("Submit button without email");
			pl.EmailErrCheck(scriptname,sheetName);
		}
		else if(scriptname.equals("LoginWithoutPwd")) {
			et =  es.startTest("Passwrd Error Check");
			log.info("Submit button without password");
			pl.pwdErrCheck(scriptname,sheetName);
		} 
		else if(scriptname.equals("InvalidEmail")) {
			et =  es.startTest("Invalid Email Check");
			log.info("Submit button with invalid email");
			pl.invalidEmailCheck(uid,pas,scriptname,sheetName);
		}
		else if(scriptname.equals("InvalidPwd")) {
			et =  es.startTest("Invalid pwd Check");
			log.info("Submit button with invalid password");
			pl.invalidPwdCheck(uid,pas,scriptname,sheetName);
		}

	}
}
