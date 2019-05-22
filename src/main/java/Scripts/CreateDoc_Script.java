package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_CreateDocPage;

public class CreateDoc_Script  extends Basefunctions {

	final static Logger log = Logger.getLogger(CreateDoc_Script.class);
	
	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void createDocument() throws Exception{
		et =  es.startTest("Create Document");
		pf_CreateDocPage c=new pf_CreateDocPage(w);
		c.createDoc();
		c.saveToDraftCheck();
	}
}
