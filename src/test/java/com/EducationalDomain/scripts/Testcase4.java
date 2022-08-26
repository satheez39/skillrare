package com.EducationalDomain.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.EducationalDomain.tcs.genericLib.BaseClass;
import com.EducationalDomain.tcs.pomPages.LoginPage;
import com.EducationalDomain.tcs.pomPages.SkillraryDemoLoginPage;
import com.EducationalDomain.tcs.pomPages.Testing;



public class Testcase4 extends BaseClass{
	@Test
	public void tc4() throws FileNotFoundException, IOException, SQLException {
	test=reports.createTest("tc4");
	LoginPage lp=new LoginPage(driver);
	SkillraryDemoLoginPage hp = lp.demoApp(driver);
	utilies.switchTabs(driver);
	utilies.dropdown(hp.getCoursedd(),fu.getPropertyFile("dd"));
	Testing t=new Testing(driver);
	String query="select * from price";
	String data = fu.queryExecution(query,1,"INR 19.00");
	
	
	}

}
