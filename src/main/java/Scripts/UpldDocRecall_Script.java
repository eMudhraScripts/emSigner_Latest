package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_UploadDocPage;

public class UpldDocRecall_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(UpldDocRecall_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void uploadDocDecline() throws Exception{
		pf_UploadDocPage anyDoc=new pf_UploadDocPage(w);
		String doc=Utility.getpropertydetails("PDF");
		String intrlUser=Utility.getpropertydetails("InternalUser");
		anyDoc.upldDocTwoSigntry(doc,intrlUser);
	}
}
