package ru.nixer.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ru.nixer.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    }
	  }
	
