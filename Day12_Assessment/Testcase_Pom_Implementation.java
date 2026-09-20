package Day12_PomImplementation;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import BaseClassUtility.Day12_baseclass;
import Day12_Assessment_PomPages.Testcase_MyInfopage;

public class Testcase_Pom_Implementation extends Day12_baseclass
{
    @Test
    public void vacancyTest() throws InterruptedException, IOException, AWTException
    {
        homepage.getmyInfo();
        Thread.sleep(2000);
        String text = infopage.getFirstName();
    	Thread.sleep(2000);
    	
        homepage.getRecruitment();
        Thread.sleep(2000);

        recruit.getVacancies();
        Thread.sleep(2000);

        addvacancy.getAdd();
        Thread.sleep(2000);

        addvacancy.getVacname(data.vacancyname);
        Thread.sleep(1000);

        addvacancy.getSelect();
        Thread.sleep(1000);

        addvacancy.getDescription(data.description);
        Thread.sleep(1000);

        addvacancy.getHiringmgr(text);
        Thread.sleep(1000);

        addvacancy.getPositions(data.no_positions);
        Thread.sleep(1000);

        addvacancy.getSave();
        Thread.sleep(2000);
    }
    
    @Test(priority = 1)
    public void testCase2Test() throws InterruptedException
    {
    	homepage.getmyInfo();
    	Thread.sleep(2000);
    	infopage.getFn(data.ln);
    	Thread.sleep(2000);
    	infopage.getLn(data.fn);
    	Thread.sleep(2000);
    	infopage.getEmpid(data.empid);
    	Thread.sleep(2000);
    	infopage.getSavebutton();
    }
    @Test(priority = 2)
    public void testcase2_verify() throws InterruptedException
    {
    	homepage.getmyInfo();
    	Thread.sleep(2000);
    	infopage.verifyEmpid(data.empid);
    	System.out.println("testcase2 verified");
    }
}
