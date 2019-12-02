package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.CommonActions;

public class ATS_JobPage extends Base_CommonComponent {
	
	@FindBy (xpath ="//*[@id='job_datatable_filter']/label/input")
	private WebElement search;
	
	@FindBy(xpath = "//li//span[@class='sub-sidebar-txt']")
	private List<WebElement> homeBtnList;
	
	@FindBy (xpath ="//*[@id='preventClose']")
	private WebElement add_job;
	
	@FindBy (xpath ="//*[@id='job_datatable_previous']")
	private WebElement previous;
	
	@FindBy (xpath ="//*[@id='job_datatable_next']")
	private WebElement dashboard_next;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']/a/i")
	private WebElement back_arrow;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']//following-sibling::li[1]/a")
	private WebElement all;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']//following-sibling::li[2]/a")
	private WebElement open;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']//following-sibling::li[3]/a")
	private WebElement closed;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']//following-sibling::li[4]/a")
	private WebElement published;
	
	
	//------------------ BASICS --------------------
	
	@FindBy (xpath="//*[@class='modal-header']//following-sibling::div/div/div/div/div/div/input")
	private WebElement job_title;
	
	@FindBy (xpath="//*[@id='id_application_form']")
	private WebElement application_form;
	
	@FindBy (xpath="//select[@name='application_form']/option")
	private List<WebElement> application_Form_List;
	
	
	@FindBy (xpath="//*[@id='id_request_id']")
	private WebElement req_id;
	
	@FindBy (xpath="//*[@id='id_job_type']")
	private WebElement job_type;
	
	@FindBy (xpath="//select[@name='job_type']/option")
	private List<WebElement> job_Type_List;
	
	
	@FindBy (xpath="//*[@id='id_job_time']")
	private WebElement job_time;
	
	@FindBy (xpath="//select[@name='job_time']/option")
	private List<WebElement> job_Time_List;
	
	@FindBy (xpath="//*[@id='id_location']")
	private WebElement location_address;
	
	@FindBy (xpath="//*[@id='id_salary']")
	private WebElement salary;
	
	@FindBy (xpath="//*[@id='id_salary_type']")
	private WebElement salary_type;
	
	@FindBy (xpath="//select[@name='salary_type']/option")
	private List<WebElement> salary_Type_List;
	
	
	@FindBy (xpath="//*[@id='id_department']")
	private WebElement department;
	
	@FindBy (xpath = "//select[@name='department']/option")
	private List <WebElement> options;
	
	@FindBy (xpath="//*[@class='modal-footer']/button[2]")
	private WebElement basics_next_button;
	
	
	// ------------ ADDITIONAL DETAILS AND DESCRIPTION ---------------
	
	@FindBy (xpath="//*[@class='tabbed-content']/div[2]/div[1]/div[1]/div/div//following-sibling::input[1]")
	private WebElement client_manager;
	
	@FindBy (xpath="//*[@class='tabbed-content']/div[2]/div[1]/div[2]/div[1]/div//following-sibling::input[1]")
	private WebElement no_of_resources;
	
	@FindBy (xpath ="//*[@id='input']")
	private WebElement date_opened;
	
	// Calender webelements
	@FindBy (xpath ="//*[text()='event']")
	private WebElement calender_icon;
	
	@FindBy (xpath ="//*[@class ='gj-modal']/div/div/div/div[1]/i")
	private WebElement calender_previous;
	
	@FindBy (xpath ="//*[@role='period']//following-sibling::div/i")
	private WebElement calender_next;
	
	@FindBy (xpath ="//*[@role='period']")
	private WebElement calender_monthyear;
	
	@FindBy (xpath ="//*[@role='calendar']")
	private WebElement outer_Calender;
	
	@FindBy(xpath="//*[text()='Ok']")
	private WebElement calender_Ok;
	//--------------------------------------------------
	
	@FindBy (xpath ="//*[text()='Additional Details & Description']")
	private WebElement add_dtl_n_desc;
	
	@FindBy (xpath="//*[@class='tabbed-content']/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]")
	private WebElement textarea;
	
	@FindBy ( xpath="//*[text()='Back']")
	private WebElement basics_back_button;
	

	//-------------- HIRING TEAM AND STAGES ----------------------------
	
	@FindBy (xpath="//*[@id='id_Hiring_Manager']")
	private WebElement hiring_managers;
	
	@FindBy (xpath="//select[@name='Hiring_Manager']/option")
	private List<WebElement> hiring_Managers_List;
	
	
	
	@FindBy (xpath ="//*[@class='tabbed-content']/div[3]/div[2]/div/div/input")
	private WebElement coordinators;
	
	
	@FindBy (xpath="//*[@id='id_Recruiter']")
	private WebElement recruiters;
	
	@FindBy (xpath="//select[@name='Recruiter']/option")
	private List<WebElement> recruiters_List;
	
	@FindBy (xpath="//*[@class='tabbed-content']/div[3]/div[2]/div[2]/div/select")
	private WebElement hiring_process;
	
	@FindBy (xpath="//select[@class='form-control input-style']/option")
	private List<WebElement> hiring_Process_List;
	
	
	@FindBy (xpath="(//button[contains(text(),'Add Job')])[1]")   // find a new xpath for this
	private WebElement job_submit;
	
//Constructor
	public ATS_JobPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
//Actions
	public void select(String moduleName) {
		CommonActions.waitTime(3000);
		CommonActions.selectListComponent(homeBtnList, moduleName);
	}
	
	public void click_AddJob()
	{
		CommonActions.waitTime(2000);
		add_job.click();
	}
	
	public void get_JobTitle(String jb_title)
	{
		CommonActions.waitTime(2000);
		job_title.sendKeys(jb_title);
	}
	
	public void get_ApplicationForm(String option)
	{
		CommonActions.waitTime(2000);
		application_form.click();
		CommonActions.selectListComponent(application_Form_List, option);
	}
	
	public void get_ReqId(String reqid)
	{
		CommonActions.waitTime(2000);
		req_id.sendKeys(reqid);
	}
	
	public void get_JobType(String type)
	{
		CommonActions.waitTime(2000);
		job_type.click();
		CommonActions.selectListComponent(job_Type_List, type);
	}
	
	
	public void get_JobTime(String time)
	{
		CommonActions.waitTime(2000);
		job_time.click();
		CommonActions.selectListComponent(job_Time_List, time);
	}
	
	
	public void get_Location_Address(String location)
	{
		CommonActions.waitTime(2000);
		location_address.sendKeys(location);
	}
	
	public void get_Salary(String sal)
	{
		CommonActions.waitTime(2000);
		salary.sendKeys(sal);
	}
	
	public void get_SalaryType(String salary)
	{
		CommonActions.waitTime(2000);
		salary_type.click();
		CommonActions.selectListComponent(options, salary);
		CommonActions.waitTime(2000);
	}
	
	public void get_Department(String dept)
	{
		CommonActions.waitTime(2000);
		department.click();
		CommonActions.selectListComponent(options, dept );
	}
	
	public void click_BasicsNext()
	{
		CommonActions.waitTime(2000);
		basics_next_button.click();
	}
	
	public void get_ClientManager(String manager)
	{
		CommonActions.waitTime(2000);
		client_manager.sendKeys(manager);
	}
	
	public void get_Number_Of_Resources(String resc)
	{
		CommonActions.waitTime(2000);
		no_of_resources.sendKeys(resc);
	}
	
	public void click_CalenderIcon()
	{
		CommonActions.waitTime(2000);
		calender_icon.click();
	}
	
	public WebElement get_FullCalender()
	{
		CommonActions.waitTime(2000);
		return outer_Calender;
	}
	
	
	public void get_Date(String input_date)  // In format : 30/December/2019
	{
		CommonActions.waitTime(2000);
		String input_day,input_month,input_year,input_monthyear,combined_monthyear; // splited content of user inputted date
		String cal_date,retrieved_calendarmonthyear;    // retrieved from website
		String dateArray[] = input_date.split("/");   // aplitting the date
		input_day = dateArray[0].trim();  // assigining date
		input_month = dateArray[1].trim();  // assigning month
		input_year = dateArray[2].trim();  // assigning year
		combined_monthyear =input_month+" "+input_year;  // combining user inputed month and year together
		input_monthyear = combined_monthyear.trim();
		
		System.out.println(input_day);
		System.out.println(input_month);
		System.out.println(input_year);

		System.out.println("The input month year is :"+input_monthyear);		
		retrieved_calendarmonthyear = calender_monthyear.getText().trim();
		System.out.println("The rtrvd month year is : "+retrieved_calendarmonthyear);
		
		while(!input_monthyear.contains(calender_monthyear.getText()))
		{
			
			calender_next.click();
		}
		List<WebElement> rows,columns;
		rows = outer_Calender.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++)
		{
			columns = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<columns.size();j++)
			{
				cal_date = columns.get(j).getText();
				if(cal_date.equals(input_day))
				{
					columns.get(j).click();
					break;
				}
			}
		}
		
		calender_Ok.click();
		
	}


	public void get_Description(String text)
	{
		CommonActions.waitTime(2000);
		textarea.sendKeys(text);
	}
	
	public void get_HiringManagers(String managerName)
	{
		CommonActions.waitTime(2000);
		hiring_managers.click();
		CommonActions.selectListComponent(hiring_Managers_List, "admin2");
	}
	
	public void get_Recruiters(String recruiterslist)
	{
		CommonActions.waitTime(2000);
		recruiters.click();
		CommonActions.selectListComponent(recruiters_List, recruiterslist);
		
	}
	
	public void get_Coordinators(String cordinatorName)
	{
		CommonActions.waitTime(2000);
		coordinators.sendKeys(cordinatorName);
	}
	
	public void get_HiringProcess(String hiringProcessType)
	{
		CommonActions.waitTime(2000);
		hiring_process.click();
		CommonActions.selectListComponent(hiring_Process_List, hiringProcessType);
	}
	
	public void click_addJob_on_Popup()
	{
		CommonActions.waitTime(2000);
		job_submit.click();
		CommonActions.waitTime(4000);
	}

}
	