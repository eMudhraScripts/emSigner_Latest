package Scripts;

import java.io.File;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_AnyDocPage;

public class AnyDoceSign_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(AnyDoc_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void anyDoceSign() throws Exception{
		
		pf_AnyDocPage anyDoc=new pf_AnyDocPage(w);		
			et =  es.startTest("Upload Document eSign");
			File f3=new File(Utility.getpropertydetails("PDF"));
			String pdfpath=f3.getAbsolutePath();
			anyDoc.anyDocumenteSign(pdfpath);
		}

}
