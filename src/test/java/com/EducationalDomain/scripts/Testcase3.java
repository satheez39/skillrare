package com.EducationalDomain.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EducationalDomain.tcs.genericLib.BaseClass;
import com.EducationalDomain.tcs.pomPages.CorejavaPage;
import com.EducationalDomain.tcs.pomPages.LoginPage;
import com.EducationalDomain.tcs.pomPages.WishlistPage;


public class Testcase3 extends BaseClass{
	@Test
	public void tc3() throws FileNotFoundException, IOException, InterruptedException {
	test=reports.createTest("tc3");
	
	LoginPage lp=new LoginPage(driver);
	CorejavaPage c = lp.searchcourse(driver,fu.getPropertyFile("cn"));
	WishlistPage ad = c.corejavaselenium(driver);
	utilies.switchframe(driver);
	ad.playvideo();
	
	utilies.switchBackfromFrame(driver);
	ad.addtowishist();
	
	//Assert.assertEquals(driver.getTitle(),fu.getPropertyFile("title"));
	}

}
