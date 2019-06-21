package Scripts;

import java.io.File;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_AnyDocPage;

public class AnyDocChooseTemp_Script extends Basefunctions {
	final static Logger log = Logger.getLogger(AnyDoc_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void anyDoc() throws Exception{


		pf_AnyDocPage anyDoc=new pf_AnyDocPage(w);
		et =  es.startTest("Upload Document choose Template");
		File f3=new File(Utility.getpropertydetails("PDF"));
		String pdfpath=f3.getAbsolutePath();
		anyDoc.anyDocumentChooseTemp(pdfpath);
	}

}
