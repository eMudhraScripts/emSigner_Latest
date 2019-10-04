package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_UploadDocPage;
import Page_Factory.pf_loginpage;

public class UpldDocIntrnlUser_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(UpldDocIntrnlUser_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void uploadDocIntrnlUser() throws Exception{
		pf_UploadDocPage anyDoc=new pf_UploadDocPage(w);
		String doc=Utility.getpropertydetails("PDF");
		String intrlUser=Utility.getpropertydetails("InternalUser");
		anyDoc.upldDocInternlUser(doc,intrlUser);
	}
	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void Logout() throws Exception{	
		et =  es.startTest("Logout");
		pf_loginpage pl = new pf_loginpage(w);
		pl.logout();
		log.info("Logged out successfully");
	}
	
	@Test(enabled=true,priority=3,groups={"SMK","REG"})
	public void IntnlLogin() throws Exception{	
		pf_loginpage pl = new pf_loginpage(w);

		String uid=Utility.getpropertydetails("InternalUser");
		String pas=Utility.getpropertydetails("InternalUserPwd");
		pl.logincredentials(uid,pas);
	}
	
	@Test(enabled=true,priority=4,groups={"SMK","REG"})
	public void mySignDecline() throws Exception{	
		pf_UploadDocPage anyDoc=new pf_UploadDocPage(w);
		anyDoc.mySigndocDecline();
	}
}
