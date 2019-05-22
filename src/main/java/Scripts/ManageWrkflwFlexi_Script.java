package Scripts;

import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_AdminSettings;

public class ManageWrkflwFlexi_Script extends Basefunctions {

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{	

		pf_AdminSettings set=new pf_AdminSettings(w);
		et =  es.startTest("My Profile");
		set.settings();
	} 
	
	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void mangeWfFlexi() throws Exception{	
		
		pf_AdminSettings a=new pf_AdminSettings(w);
		String wfname=Utility.getpropertydetails("FlexiWorkflowName");
		a.create_manage_workflows(wfname);		
		a.manage_workflowsFlexiform();
	}
}
