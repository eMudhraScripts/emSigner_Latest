package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_AdminSettings;
import Page_Factory.pf_WorkflowNew;

public class AdminWFExternalExcel_Script  extends Basefunctions {
	final static Logger log = Logger.getLogger(AdminWFExternalExcel_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{	

		pf_AdminSettings set=new pf_AdminSettings(w);
		et =  es.startTest("Settings");
		set.settings();
	}
	
	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void createmanageWorkflowExcel() throws Exception{
		pf_AdminSettings set=new pf_AdminSettings(w);
		String wfname=Utility.getpropertydetails("WorkflowNameExcel");
		String nme=Utility.getpropertydetails("WorkflowNameExcelColumn1");
		String loctn=Utility.getpropertydetails("WorkflowNameExcelColumn2");
		set.CreateWFExcel(wfname,nme,loctn);
	}
	
	
	@Test(enabled=true,priority=3,groups={"SMK","REG"})
	public void manageWorkflowExcel() throws Exception{
		pf_WorkflowNew set=new pf_WorkflowNew(w);
		String wfname=Utility.getpropertydetails("WorkflowNameExcel");
		set.wfExcel(wfname);
	}

}
