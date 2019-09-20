package Scripts;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_UploadDocPage;

public class UpldDoceSigntreTmplte_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(UpldDoceSigntreTmplte_Script.class);
	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void uploadDoceSignTmp() throws Exception{
		pf_UploadDocPage anyDoc=new pf_UploadDocPage(w);
		File f3=new File(Utility.getpropertydetails("PDF"));
		String pdfpath=f3.getAbsolutePath();
		anyDoc.uploadanyPDF(pdfpath);
		anyDoc.dSgntrwithQRCode();
		anyDoc.dsignDoc();


	}

}
