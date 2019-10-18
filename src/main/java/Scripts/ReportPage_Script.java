package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_ReportPage;


public class ReportPage_Script extends Basefunctions
{
          final static Logger log= Logger.getLogger(ReportPage_Script.class);
          
          
         @Test(enabled=true,priority=1,groups={"SMK","REG"})
      	public void ProductiveReportpage() throws Exception 
      	{
      		pf_ReportPage a =  new pf_ReportPage(w);
      		   et=es.startTest("Productive Report page");
      		 //  a.MyScheduleReportPage();
      		   a.ProductiveReportByUser();
      		   a.ProductiveReportBydepartment();
      		   a.ProductiveReportByCatagory();
      		      
      	}

          @Test(enabled=true,priority=2,groups={"SMK","REG"})
        	public void workflowReportpage() throws Exception 
        	{
        	  pf_ReportPage b =  new pf_ReportPage(w);
     		   et=es.startTest("workflow Report page");
        	    b.WorkflowReportByUser();
        	    b.WorkflowReportByDepartment();
        	    b.WorkflowReportByCatogory();
        	  
        	  
        	}
          
          
          
          
        	}
          
          
          
          
          

