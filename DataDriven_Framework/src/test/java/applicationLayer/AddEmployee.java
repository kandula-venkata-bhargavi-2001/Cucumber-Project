package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmployee
{
	WebDriver driver;
	public AddEmployee(WebDriver driver)
	{
		this.driver=driver;
	}
//define Repository
	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement clickPim;
	@FindBy(name="btnAdd")
	WebElement clickAdd;
	@FindBy(name="firstName")
	WebElement EnterFname;
	@FindBy(name="middleName")
	WebElement EnterMname;
	@FindBy(name="lastName")
	WebElement EnterLname;
	@FindBy(id="employeeId")
	WebElement Eid;
	@FindBy(id="btnSave")
	WebElement clickSave;
	@FindBy(name="personal[txtEmployeeId]")
	WebElement Employeeid;
	
	//method for add employeee
	public boolean verifyEmp(String Fname,String Mname, String Lname) throws Throwable
	{
	 Actions ac = new Actions(driver);
	 ac.moveToElement(clickPim).click().perform();
	 ac.pause(4000);
	 ac.moveToElement(clickAdd).click().perform();
	 Thread.sleep(2000);
	 EnterFname.sendKeys(Fname);
	 EnterMname.sendKeys(Mname);
	 EnterLname.sendKeys(Lname);
	 
	 //capture Eid
	 String Exp_Data = Eid.getAttribute("value");
	 Thread.sleep(2000);
	 String Act_Data = Eid.getAttribute("value");
	 ac.moveToElement(clickSave).click().perform();
	 if(Act_Data.equals(Exp_Data))
	 {
		 Reporter.log("Add Employee Sucess::"+Exp_Data+"    "+Act_Data,true);
		 return true;
	 }
	 else
	 {
		 Reporter.log("Add Employee Fail::"+Exp_Data+"    "+Act_Data,true);
		 return false;
		 
		 
	 }
	 
	}

}
