package Scripts;

import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_AdminSettings;
import Page_Factory.pf_WorkflowNew;

public class ManageWrkflwActivity_Script extends Basefunctions {

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{	

		pf_AdminSettings set=new pf_AdminSettings(w);
		et =  es.startTest("My Profile");
		set.settings();
	} 
	
	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void mangeWfActivity() throws Exception{	
		
		pf_AdminSettings a=new pf_AdminSettings(w);
		
		String wfname=Utility.getpropertydetails("WorkflowNameActivity");
		//a.create_manage_workflows(wfname);
		
		pf_WorkflowNew wrkflw=new pf_WorkflowNew(w);
		//wrkflw.wfActivity(w);
		
		a.manage_workflowsActivity();
	}

}
