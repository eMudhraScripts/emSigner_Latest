package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_UploadDocPage;

public class UploadDocParallel_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(UploadDocParallel_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void uploadDocparallelSign() throws Exception{
		pf_UploadDocPage anyDoc=new pf_UploadDocPage(w);
		String doc=Utility.getpropertydetails("PDF");
		String intrlUser=Utility.getpropertydetails("InternalUser");
		String adhocUser=Utility.getpropertydetails("AdhocUser");
		anyDoc.upldDocPSigning(doc,intrlUser,adhocUser);
	}
}
