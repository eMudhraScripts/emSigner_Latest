package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_WorkflowNew;

public class WrkflwsDocUpld_Script extends Basefunctions  {

	final static Logger log = Logger.getLogger(Workflows_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void workFlows() throws Exception{

		//pf_workflows wrkflw=new pf_workflows(w);
		pf_WorkflowNew wrkflw=new pf_WorkflowNew(w);

		wrkflw.selectWorkflow1(w);
	}
}
