package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_CreateDocPage;

public class CreateDoceSign_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(CreateDoceSign_Script.class);
	
	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void createDocument() throws Exception{
		et =  es.startTest("Create Document");
		pf_CreateDocPage c=new pf_CreateDocPage(w);
		String docCn=Utility.getpropertydetails("CreateDocContenteSign");
		c.createDoc();
		String templateName=Utility.getpropertydetails("createDocTemplateNameeSign");
		c.saveToDraftCheck1(templateName);
	}

}
