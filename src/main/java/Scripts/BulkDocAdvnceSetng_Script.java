package Scripts;

import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_BulkDocument;

public class BulkDocAdvnceSetng_Script extends Basefunctions {

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void bulkDocChooseTempAd() throws Exception{	
		
		pf_BulkDocument bulk=new pf_BulkDocument(w);
		et =  es.startTest("Bulk choose template-AdvnceSettingsPwd");
		bulk.chooseTemplateAdvnceSetPwd();
		
	}

}
