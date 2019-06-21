package Scripts;

import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_BulkDocument;
import Page_Factory.pf_form16SigningPage;

public class BulkDocChooseTemp_Script extends Basefunctions {

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void bulkDocChooseTemp() throws Exception{	
		
		pf_BulkDocument bulk=new pf_BulkDocument(w);
		et =  es.startTest("bulk Choose Template: "+tcid);
		bulk.chooseTemplate();
		
	}

}
