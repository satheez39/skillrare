package com.EducationalDomain.scripts;

import org.testng.annotations.Test;

import com.EducationalDomain.tcs.genericLib.BaseClass;
import com.EducationalDomain.tcs.pomPages.AddtocartPage;
import com.EducationalDomain.tcs.pomPages.LoginPage;
import com.EducationalDomain.tcs.pomPages.SkillraryDemoLoginPage;

public class Testcase1 extends BaseClass{ 
	@Test 
	public void tc1() { 
		test=reports.createTest("tc1");
		LoginPage l=new LoginPage(driver); 
		SkillraryDemoLoginPage hp = l.demoApp(driver); 
		utilies. switchTabs(driver);
		utilies.mouseHover(driver,hp.getCoursebtn()); 
		AddtocartPage cart = hp.course(driver); 
		utilies.doubleclick(driver,cart.getAddbtn()); 
		cart.getAddtocartbtn().click(); 
		utilies.alertPopupok(driver); 
}


}
