package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_AdminSettings;
import Page_Factory.pf_Settings;
import Page_Factory.pf_loginpage;

public class AdminSettings_Script extends Basefunctions {
	final static Logger log = Logger.getLogger(AdminSettings_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void settingPage() throws Exception{	

		pf_AdminSettings set=new pf_AdminSettings(w);
		et =  es.startTest("Settings");
		set.settings();
	} 

	@Test(dataProvider= "admin_setting",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=3,groups={"SMK","REG"})
	public void manageDept(Map hm) throws Exception{
		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="AdminSettings";
		pf_AdminSettings set=new pf_AdminSettings(w);
		if(scriptname.equals("cancelBtnDept")) {
			et =  es.startTest("Manage Department: "+tcid);
			set.manageDeptcnclBtn(scriptname,sheetName);
		}
		else if(scriptname.equals("saveBtnWithoutDept")) {
			et =  es.startTest("Manage Department: "+tcid);
			set.saveBtnWithoutDept(scriptname,sheetName);		
		}
		else if(scriptname.equals("saveBtnWithoutWF")) {
			et =  es.startTest("Manage Department: "+tcid);
			set.saveBtnWithoutWF(scriptname,sheetName);		
		}
		else if(scriptname.equals("withoutEditSaveBtn")) {
			et =  es.startTest("Manage Department: "+tcid);
			set.withoutEditSaveBtn(scriptname,sheetName); 
		}
		else if(scriptname.equals("changeDNameSaveBtn")) {
			et =  es.startTest("Manage Department: "+tcid);
			set.changeDNameSaveBtn(scriptname,sheetName); 
		}
		else if(scriptname.equals("deleteDeptBtn")) {
			et =  es.startTest("Manage Department: "+tcid);
			set.deleteDeptBtn(scriptname,sheetName); 
		}
	}
	
	@Test(dataProvider= "admin_setting",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=4,groups={"SMK","REG"})
	public void manageUsers(Map hm) throws Exception{
		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="AdminSettings";
		pf_AdminSettings set=new pf_AdminSettings(w); 
		if(scriptname.equals("UserWFSuccessMsg")) {
		set.createNewUser(scriptname,sheetName);
		}
		else if(scriptname.equals("editsaveBtnUser")) {
			et =  es.startTest("Manage Users: "+tcid);
			set.editsaveBtnUser(scriptname,sheetName);
			}
		else if(scriptname.equals("deleteuser")) {
			et =  es.startTest("Manage Users: "+tcid);
			set.deleteuser(scriptname,sheetName);
			}
	}
	
	@Test(enabled=true,priority=5,groups={"SMK","REG"})
	public void activityLog() throws Exception{
		
		pf_AdminSettings set=new pf_AdminSettings(w);
		et =  es.startTest("Manage Users: "+tcid);
		set.activity_log();
	}
	
	@Test(enabled=true,priority=6,groups={"SMK","REG"})
	public void createmanageWorkflow() throws Exception{
		pf_AdminSettings set=new pf_AdminSettings(w);
		String wfname=Utility.getpropertydetails("WorkflowName");
		set.create_manage_workflows(wfname);
		set.manage_workflows();
	}
	
//	@Test(enabled=true,priority=7,groups={"SMK","REG"})
//	public void manageWorkflow() throws Exception{
//		pf_AdminSettings set=new pf_AdminSettings(w);
//		String wfname=Utility.getpropertydetails("WorkflowName");
//		set.create_manage_workflows(wfname);
//		set.manage_workflows();
//	}
	
	/*@Test(enabled=true,priority=7,groups={"SMK","REG"})
	public void subscription() throws Exception{
		
		pf_AdminSettings set=new pf_AdminSettings(w);
		set.renew_subscription();
	}*/
	
	
	/*@Test(dataProvider= "admin_setting",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=8,groups={"SMK","REG"})
	public void customStatus(Map hm) throws Exception{
		String scriptname=hm.get("Script_Name").toString();
		
		pf_AdminSettings set=new pf_AdminSettings(w);
		String sheetName ="AdminSettings";
		if(scriptname.equals("CSCancelBtn")) {	
			et =  es.startTest("Custom status Cancel check");
		set.CustmStatusCancelCheck(sheetName,scriptname);
		}
		else if(scriptname.equals("CSsaveBtn")) {
			et =  es.startTest("Custom status Save check");
			set.CustmStatusSaveCheck(sheetName,scriptname);
		}
		else if(scriptname.equals("CSeditBtn")) {
			et =  es.startTest("Custom status Edit check");
			set.CustmStatuseditCheck(sheetName,scriptname);
		}
		else if(scriptname.equals("CSdeleteBtn")) {
			et =  es.startTest("Custom status Delete check");
			set.CustmStatusdeleteCheck(sheetName,scriptname);
		}
	}
	
	@Test(dataProvider= "admin_setting",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=9,groups={"SMK","REG"})
	public void advancedSettings(Map hm) throws Exception{
		String scriptname=hm.get("Script_Name").toString();
		
		pf_AdminSettings set=new pf_AdminSettings(w);
		String sheetName ="AdminSettings";
		if(scriptname.equals("ASAddBtn")) {	
			et =  es.startTest("Advance Settings Cancel check");
		set.AdvnceSetngAddCheck(sheetName,scriptname);
		}
		else if(scriptname.equals("ASEditBtn")) {
			et =  es.startTest("Advance Settings edit check");
			set.AdvnceSetngEditCheck(sheetName,scriptname);
		}
		else if(scriptname.equals("ASDeleteBtn")) {
			et =  es.startTest("Advance Settings delete check");
			set.AdvnceSetngDeleteCheck(sheetName,scriptname);
		}
	}*/

}

