package Scripts;

import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_form16SigningPage;

public class Form16ChooseTemp_Script extends Basefunctions {

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void form16ChooseTemp() throws Exception{	
		
		pf_form16SigningPage form16=new pf_form16SigningPage(w);
		et =  es.startTest("Form16 Choose Template: "+tcid);
		form16.chooseTemplate();
		
	}
	
}
