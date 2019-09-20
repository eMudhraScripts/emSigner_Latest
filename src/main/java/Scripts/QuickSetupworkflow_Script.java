package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_QuickSetupworkflowPage;


public class QuickSetupworkflow_Script extends Basefunctions {
	final static Logger log = Logger.getLogger(QuickSetupworkflow_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{	

		pf_QuickSetupworkflowPage setup=new pf_QuickSetupworkflowPage(w);
		et =  es.startTest("QuickSetup Workflow");
		setup.quicksetup();
	} 
}
