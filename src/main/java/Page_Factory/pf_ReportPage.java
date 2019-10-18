package Page_Factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_ReportPage extends pf_genericmethods
{
           Basefunctions b = new Basefunctions();
           final static Logger log=Logger.getLogger(pf_ReportPage.class);
          
          
          
       @FindBy(id="Reports") WebElement ReportLink;
       @FindBy(id="MyScheduleReport")WebElement MyScheduleReportLink;
       @FindBy(xpath="//*[@id='TopMenu']/ul/li[3]/ul/li[1]/a")WebElement ProductiveReportLink;
       @FindBy(xpath="//*[@id='TopMenu']/ul/li[3]/ul/li[2]/a")WebElement WorkflowReportLink;
       
       
       @FindBy(id="ByUser") WebElement PR_byUser;
       @FindBy(id="ByDepartment") WebElement PR_bydeptaptment;
       @FindBy(id="ByCategory") WebElement PR_byCatagory;
       
       @FindBy(xpath="//li[@class='dropdown open']/ul[1]/li[2]/ul/li[1]/a") WebElement WR_byUser;
       @FindBy(xpath="//li[@class='dropdown open']/ul[1]/li[2]/ul/li[2]/a") WebElement WR_bydeptaptment;
       @FindBy(xpath="//li[@class='dropdown open']/ul[1]/li[2]/ul/li[3]/a") WebElement WR_byCatagory;
       
       @FindBy(id="prepfromdate") WebElement FromDate;
       @FindBy(id="preptodate") WebElement ToDate;
       @FindBy(id="repfromdate") WebElement WFromDate;
       @FindBy(id="reptodate") WebElement WToDate;
       @FindBy(id="ddlViewBy") WebElement StatusDropDown;
       @FindBy(id="pbtnReportsubmit") WebElement PSearch;
       @FindBy(id="btnReportsubmit") WebElement WSearch;
       @FindBy(id="btnExport")WebElement ExportToExcel; 
       
       public pf_ReportPage(WebDriver driver)
       {
    	   PageFactory.initElements(driver, this);
    	   
       }
          
        public void MyScheduleReportPage() throws InterruptedException
        {
        	
        	cl_click(ReportLink);
        	Thread.sleep(3000);
        	cl_click(MyScheduleReportLink);
        	Thread.sleep(3000);
        	log.info("MySchedule Report Page is open");
        }
          
        public void ProductiveReportByUser() throws Exception
        {
        	cl_click(ReportLink);
        	Thread.sleep(1000);
        	cl_click(ProductiveReportLink);
        	Thread.sleep(1000);
        	cl_click(PR_byUser);
        	log.info("Productive Report By User page is open");
        	Thread.sleep(2000);
        FromDate.clear();
        ToDate.clear();
        String ReportFromDate=Utility.getpropertydetails("ReportFromDate");
        cl_entertext(FromDate, ReportFromDate);
        Thread.sleep(1000);
        String ReportToDate=Utility.getpropertydetails("ReportToDate");
        cl_entertext(ToDate, ReportToDate);
        Thread.sleep(1000);
        new Select(StatusDropDown).selectByVisibleText("Select All");
        Thread.sleep(1000);
        cl_click(PSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);
        
        new Select(StatusDropDown).selectByVisibleText("Completed");
        Thread.sleep(1000);
        cl_click(PSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);
        
        new Select(StatusDropDown).selectByVisibleText("Pending");
        Thread.sleep(1000);
        cl_click(PSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);
        
        new Select(StatusDropDown).selectByVisibleText("Declined");
        Thread.sleep(1000);
        cl_click(PSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);
        
        new Select(StatusDropDown).selectByVisibleText("Recalled");
        Thread.sleep(1000);
        cl_click(PSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);
        }
        
        
        
        public void ProductiveReportBydepartment() throws Exception
        {
        cl_click(ReportLink);
    	Thread.sleep(1000);
    	cl_click(ProductiveReportLink);
    	
    	Thread.sleep(1000);
    	cl_click(PR_bydeptaptment);
    	log.info("Productive Report By department page is open");
    	Thread.sleep(2000);
    FromDate.clear();
    ToDate.clear();
    String ReportFromDate1=Utility.getpropertydetails("ReportFromDate");
    cl_entertext(FromDate, ReportFromDate1);
    Thread.sleep(1000);
    String ReportToDate1=Utility.getpropertydetails("ReportToDate");
    cl_entertext(ToDate, ReportToDate1);
    Thread.sleep(1000);
    new Select(StatusDropDown).selectByVisibleText("Select All");
    Thread.sleep(1000);
    cl_click(PSearch);
    Thread.sleep(3000);
    cl_click(ExportToExcel);
    Thread.sleep(3000);
    new Select(StatusDropDown).selectByVisibleText("Completed");
    Thread.sleep(1000);
    cl_click(PSearch);
    Thread.sleep(2000);
    cl_click(ExportToExcel);
    Thread.sleep(2000);
    
    new Select(StatusDropDown).selectByVisibleText("Pending");
    Thread.sleep(1000);
    cl_click(PSearch);
    Thread.sleep(2000);
    cl_click(ExportToExcel);
    Thread.sleep(2000);
    
    new Select(StatusDropDown).selectByVisibleText("Declined");
    Thread.sleep(1000);
    cl_click(PSearch);
    Thread.sleep(2000);
    cl_click(ExportToExcel);
    Thread.sleep(2000);
    
    new Select(StatusDropDown).selectByVisibleText("Recalled");
    Thread.sleep(1000);
    cl_click(PSearch);
    Thread.sleep(2000);
    cl_click(ExportToExcel);
    Thread.sleep(3000);
        
        }
        
            public void ProductiveReportByCatagory() throws Exception
            {
            	
            	cl_click(ReportLink);
            	Thread.sleep(1000);
            	cl_click(ProductiveReportLink);
            	Thread.sleep(1000);
            	cl_click(PR_byCatagory);
            	log.info("Productive Report By Category page is open");
            	Thread.sleep(2000);
            FromDate.clear();
            ToDate.clear();
            String ReportFromDate1=Utility.getpropertydetails("ReportFromDate");
            cl_entertext(FromDate, ReportFromDate1);
            Thread.sleep(1000);
            String ReportToDate1=Utility.getpropertydetails("ReportToDate");
            cl_entertext(ToDate, ReportToDate1);
            Thread.sleep(1000);
            new Select(StatusDropDown).selectByVisibleText("Select All");
            Thread.sleep(1000);
            cl_click(PSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(3000);
            
            new Select(StatusDropDown).selectByVisibleText("Completed");
            Thread.sleep(1000);
            cl_click(PSearch);
            Thread.sleep(2000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Pending");
            Thread.sleep(1000);
            cl_click(PSearch);
            Thread.sleep(2000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Declined");
            Thread.sleep(1000);
            cl_click(PSearch);
            Thread.sleep(2000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Recalled");
            Thread.sleep(1000);
            cl_click(PSearch);
            Thread.sleep(2000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            }    
            	
            public void WorkflowReportByUser() throws Exception   	
            	
            {
            	cl_click(ReportLink);
            	Thread.sleep(1000);
            	cl_click(WorkflowReportLink);
            	
            	Thread.sleep(1000);
            	cl_click(WR_byUser);
            	log.info("Workflow Report By User page is open");
            	Thread.sleep(2000);
            WFromDate.clear();
           WToDate.clear();
            String ReportFromDate=Utility.getpropertydetails("ReportFromDate");
            cl_entertext(WFromDate, ReportFromDate);
            Thread.sleep(1000);
            String ReportToDate=Utility.getpropertydetails("ReportToDate");
            cl_entertext(WToDate, ReportToDate);
            Thread.sleep(1000);
            new Select(StatusDropDown).selectByVisibleText("Select All");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Completed");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Pending");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Declined");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Recalled");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            }	
            public void WorkflowReportByDepartment() throws Exception   	
            {
            	
            	cl_click(ReportLink);
            	Thread.sleep(1000);
            	cl_click(WorkflowReportLink);
            	Thread.sleep(1000);
            	cl_click(WR_bydeptaptment);
            	log.info("Workflow Report by deptaptment page is open");
            	Thread.sleep(2000);
            WFromDate.clear();
            WToDate.clear();
            String ReportFromDate=Utility.getpropertydetails("ReportFromDate");
            cl_entertext(WFromDate, ReportFromDate);
            Thread.sleep(1000);
            String ReportToDate=Utility.getpropertydetails("ReportToDate");
            cl_entertext(WToDate, ReportToDate);
            Thread.sleep(1000);
            new Select(StatusDropDown).selectByVisibleText("Select All");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Completed");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Pending");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Declined");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            
            new Select(StatusDropDown).selectByVisibleText("Recalled");
            Thread.sleep(1000);
            cl_click(WSearch);
            Thread.sleep(3000);
            cl_click(ExportToExcel);
            Thread.sleep(2000);
            }	
            	
            public void WorkflowReportByCatogory() throws Exception
            {
            cl_click(ReportLink);
        	Thread.sleep(1000);
        	cl_click(WorkflowReportLink);
        	Thread.sleep(1000);
        	cl_click(WR_byCatagory);
        	log.info("Workflow Report by Category page is open");
        	Thread.sleep(2000);
        WFromDate.clear();
        WToDate.clear();
        String ReportFromDate=Utility.getpropertydetails("ReportFromDate");
        cl_entertext(WFromDate, ReportFromDate);
        Thread.sleep(1000);
        String ReportToDate=Utility.getpropertydetails("ReportToDate");
        cl_entertext(WToDate, ReportToDate);
        Thread.sleep(1000);
        new Select(StatusDropDown).selectByVisibleText("Select All");
        Thread.sleep(1000);
        cl_click(WSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);
        
        new Select(StatusDropDown).selectByVisibleText("Completed");
        Thread.sleep(1000);
        cl_click(WSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);
        
        new Select(StatusDropDown).selectByVisibleText("Pending");
        Thread.sleep(1000);
        cl_click(WSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);
        
        new Select(StatusDropDown).selectByVisibleText("Declined");
        Thread.sleep(1000);
        cl_click(WSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);
        
        new Select(StatusDropDown).selectByVisibleText("Recalled");
        Thread.sleep(1000);
        cl_click(WSearch);
        Thread.sleep(3000);
        cl_click(ExportToExcel);
        Thread.sleep(2000);	
            }  	
            
        
        
        
        }
          
          
          
          
          
          
          
          

