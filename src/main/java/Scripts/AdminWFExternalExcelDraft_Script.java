package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_AdminSettings;
import Page_Factory.pf_WorkflowNew;

public class AdminWFExternalExcelDraft_Script extends Basefunctions {
	final static Logger log = Logger.getLogger(AdminWFExternalExcelDraft_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{	

		pf_AdminSettings set=new pf_AdminSettings(w);
		et =  es.startTest("Settings");
		set.settings();
	}

	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void createmanageWorkflowExcel() throws Exception{
		pf_AdminSettings set=new pf_AdminSettings(w);
		String wfname=Utility.getpropertydetails("WorkflowNameExcelDrafts");
		String nme=Utility.getpropertydetails("WorkflowNameExcelColumn1");
		String loctn=Utility.getpropertydetails("WorkflowNameExcelColumn2");
		et =  es.startTest("Create workflow -ExcelDrafts");
		set.CreateWFExcel(wfname,nme,loctn);
	}

	@Test(dataProvider= "WrkFlwExternalFile",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=3,groups={"SMK","REG"})
	public void manageWorkflowExcelDrafts(Map hm) throws Exception{
		pf_WorkflowNew set=new pf_WorkflowNew(w);
		String scriptname=hm.get("Script_Name").toString();
		String sheetName ="WFExternalFile";
		String wfname=Utility.getpropertydetails("WorkflowNameExcelDrafts");
		if(scriptname.equals("EFileInvalid")) {
			set.wfExtrnlInvalidFile(wfname,sheetName,scriptname);
		}
		else if(scriptname.equals("EFileInvalidExcel")) {
			set.wfExcelInvalid(wfname,sheetName,scriptname);
		}
		else if(scriptname.equals("EFileValidExcel")) {
			set.wfExcelDrafts(wfname);
		}
	}
}
