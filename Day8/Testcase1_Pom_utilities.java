package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testcase1PomUtilities 
{
    // initialization
    WebDriver driver;
    public Testcase1PomUtilities(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    //Login 
    @FindBy(xpath="//input[@name='username']")
    private WebElement username;
    
    @FindBy(xpath="//input[@name='password']")
    private WebElement password;
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElement login;
    
    
    //RECRUITMENT 
    // click on Recruitment link
    @FindBy(xpath="//span[text()='Recruitment']")
    private WebElement Recruitment;

    // click on + Add button
    @FindBy(xpath="//button[normalize-space()='Add']")
    private WebElement Add;

    // enter firstname
    @FindBy(xpath="//input[@name='firstName']")
    private WebElement firstname;

    // enter middlename
    @FindBy(xpath="//input[@name='middleName']")
    private WebElement middlename;

    // enter lastname
    @FindBy(xpath="//input[@name='lastName']")
    private WebElement lastname;

    // select any option for vacancy
    @FindBy(xpath="//div[text()='-- Select --']")
    private WebElement vacancy;

    // enter email
    @FindBy(xpath="(//input[@placeholder='Type here'])[1]")
    private WebElement email;

    // enter mobile number
    @FindBy(xpath="(//input[@placeholder='Type here'])[2]")
    private WebElement mobileno;

    // upload file
    @FindBy(xpath="//input[@type='file']")
    private WebElement uploadfile;

    // select date of application
    @FindBy(xpath="//label[text()='Date of Application']/following::input[1]")
    private WebElement doa;

    // click on save
    @FindBy(xpath="//button[normalize-space()='Save']")
    private WebElement save;


    //CANDIDATES

    // click on Candidates
    @FindBy(xpath="//a[text()='Candidates']")
    private WebElement candidates;

    @FindBy(xpath="(//div[contains(@class,'oxd-select-text')])[1]")
    private WebElement jobtitle;

    @FindBy(xpath="(//div[contains(@class,'oxd-select-text')])[2]")
    private WebElement candidatevacancy;

    @FindBy(xpath="(//div[contains(@class,'oxd-select-text')])[3]")
    private WebElement hiringmanager;

    @FindBy(xpath="(//div[contains(@class,'oxd-select-text')])[4]")
    private WebElement status;

    // enter candidate name
    @FindBy(xpath="//input[@placeholder='Type for hints...']")
    private WebElement candidatename;

    // Application Date - From
    @FindBy(xpath="//input[@placeholder='From']")
    private WebElement fromDate;
    
 // Application Date - To
    @FindBy(xpath="//input[@placeholder='To']")
    private WebElement toDate;

    // click on search
    @FindBy(xpath="//button[@type='submit']")
    private WebElement search;
    
    // verify candidate in records found
    @FindBy(xpath="//span[contains(text(),'Records Found')]")
    private WebElement recordsFound;

    @FindBy(xpath="//div[@role='row']//div[contains(text(),'N bhanu priya')]")
    private WebElement candidateRecord;

    // logout
    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
    private WebElement userDropdown;

    @FindBy(xpath="//a[text()='Logout']")
    private WebElement logout;


    //METHODS 

    // click Recruitment
    public void getRecruitment() throws InterruptedException
    {
        Recruitment.click();
        Thread.sleep(1000);
    }

    // click Add
    public void getAdd() throws InterruptedException
    {
        Add.click();
        Thread.sleep(1000);
    }

    // enter Firstname
    public void getFirstname(String value) throws InterruptedException
    {
        firstname.sendKeys(value);
        Thread.sleep(1000);
    }

    // enter Middlename
    public void getMiddlename(String value) throws InterruptedException
    {
        middlename.sendKeys(value);
        Thread.sleep(1000);
    }

    // enter Lastname
    public void getLastname(String value) throws InterruptedException
    {
        lastname.sendKeys(value);
        Thread.sleep(1000);
    }

    // select any Vacancy
    public void getVacancy() throws InterruptedException
    {
        vacancy.click();
        Actions a = new Actions(driver);
        a.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        a.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ENTER);
        a.perform();
    }

    // enter Email
    public void getEmail(String value) throws InterruptedException
    {
        email.sendKeys(value);
        Thread.sleep(1000);
    }

    // enter Mobile Number
    public void getMobileNumber(String value) throws InterruptedException
    {
        mobileno.sendKeys(value);
        Thread.sleep(1000);
    }

    // upload File
    public void uploadFile(String filepath) throws InterruptedException
    {
        uploadfile.sendKeys(filepath);
        Thread.sleep(1000);
    }

    // select Date of Application
    public void getDateOfApplication(String date)
    {
        doa.click();
        doa.sendKeys(date);
    }

    public void clickSave()
    {
        save.click();
    }


    //CANDIDATES PAGE 

    // click Candidates
    public void clickCandidates()
    {
        candidates.click();
    }

    //select jobtitle
    public void selectJobTitle() throws InterruptedException
    {
        Actions a = new Actions(driver);

        jobtitle.click();
        a.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ENTER);
        a.perform();
    }
    // select Vacancy
    public void selectCandidateVacancy() throws InterruptedException
    {
        Actions a = new Actions(driver);

        candidatevacancy.click();
        a.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ENTER);
        a.perform();
    }
    // select Hiring Manager
    public void selectHiringManager() throws InterruptedException
    {
        Actions a = new Actions(driver);

        hiringmanager.click();
        a.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ENTER);
        a.perform();
    }

    // select Status
    public void selectStatus() throws InterruptedException
    {
        Actions a = new Actions(driver);

        status.click();
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ARROW_DOWN);
        a.sendKeys(Keys.ENTER);
        a.perform();
    }
    // enter Candidate Name
    public void getCandidateName(String name)
    {
        candidatename.sendKeys(name,Keys.ARROW_DOWN,Keys.ENTER);
    }

    // select Application Date
    public void getApplicationDate(String from, String to)
    {
        fromDate.click();
        fromDate.sendKeys(Keys.CONTROL, "a");
        fromDate.sendKeys(from);
        fromDate.sendKeys(Keys.TAB);

        toDate.click();
        toDate.sendKeys(Keys.CONTROL, "a");
        toDate.sendKeys(to);
        toDate.sendKeys(Keys.TAB);
    }
    // click Search
    public void clickSearch()
    {
        search.click();
    }
    
    public void verifyCandidate(String name)
    {
        WebElement candidateRecord = driver.findElement(
            By.xpath("//div[@role='row']//div[contains(text(),'" + name + "')]")
        );

        if(candidateRecord.isDisplayed())
        {
            System.out.println("Candidate is added successfully");
        }
        else
        {
            System.out.println("Candidate is not added");
        }
    }
    
    public void logout()
    {
        userDropdown.click();
        logout.click();
    }
    
    //close
    
    
}
