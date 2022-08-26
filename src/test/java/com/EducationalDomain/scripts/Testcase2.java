package com.EducationalDomain.scripts;

import org.testng.annotations.Test;

import com.EducationalDomain.tcs.genericLib.demo;
import com.EducationalDomain.tcs.pomPages.ContactUspage;
import com.EducationalDomain.tcs.pomPages.LoginPage;



public class Testcase2 extends demo{
	
	@Test(dataProvider ="readExceldata")
	public void tc2(String name,String mail,String sub,String msg) throws InterruptedException {
		test=reports.createTest("tc2");
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(5000);
//		Point loc = lp.getContactus().getLocation();
//		int x = loc.getX();
//		int y=loc.getY();
//		 utilies.scrollBar(driver, x, y);
		ContactUspage cp = lp.contact(driver);
		Thread.sleep(4000);
		cp.sendDetails(name, mail, sub, msg);
	}

}
