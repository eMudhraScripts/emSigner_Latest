package Scripts;

import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_BulkDocument;

public class BulkDocAdvnceSetngBlkPwd_Script extends Basefunctions {

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void bulkDocChooseTempAdBlkPwd() throws Exception{	
		
		pf_BulkDocument bulk=new pf_BulkDocument(w);
		et =  es.startTest("Bulk choose template-AdvnceSettingsPwd-Format file");
		bulk.chooseTemplateAdvnceSetBlkPwd();
		
	}


}
