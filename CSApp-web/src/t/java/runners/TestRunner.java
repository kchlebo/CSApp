
package runners;
/*
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ConfigurableReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cornerstone.framework.BrowserFactory;
import com.cornerstone.utilities.Log;

@CucumberOptions(features = { "src/test/resources/cucumber/features/authentication" }, glue = { "stepDefinitions", "com.cornerstone.framework", "stepDefinitions.authentication" }, 
	tags = { "not @Ignore" }, plugin = { "pretty",
				"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports/CucumberTestReport.json" })
public class TestRunner extends AbstractTestNGCucumberTests {
	
	 * private TestNGCucumberRunner testNGCucumberRunner;
	 * 
	 * @BeforeClass(alwaysRun = true) public void setUpClass() throws Exception {
	 * testNGCucumberRunner = new TestNGCucumberRunner(this.getClass()); }
	 * 
	 * @Test(groups = "cucumber", description = "Runs Cucumber Scenarios",
	 * dataProvider = "scenarios") public void scenario(PickleEventWrapper
	 * pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
	 * testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent()); }
	 * 
	 * @DataProvider public Object[][] scenarios() { return
	 * testNGCucumberRunner.provideScenarios(); }
	 * 
	 * @AfterClass(alwaysRun = true) public void tearDownClass() throws Exception {
	 * this.teardown(); }
	 

	@BeforeSuite(alwaysRun = true)
	public void initialize() {
		Log.start();
		/*
		 * ExtentHtmlReporter html = new ExtentHtmlReporter("test-output/HtmlReport");
		 * ExtentReports extent = new ExtentReports();
		 * html.loadXMLConfig("src/test/resources/v3html-config.xml");
		 * extent.attachReporter(html);
		 
	}

	@AfterSuite(alwaysRun = true)
	public void teardown() {
		BrowserFactory.closeAllDriver();
		Log.end();
	}
	/*
	 * @AfterClass public static void writeExtentReport() {
	 * Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	 * Reporter.setSystemInfo("user", System.getProperty("user.name"));
	 * Reporter.setSystemInfo("os", "Win 10");
	 * Reporter.setTestRunnerOutput("Sample test runner output message"); }
	 */
}
*/
