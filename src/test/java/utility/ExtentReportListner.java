package utility;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentReportListner implements ITestListener {

    protected static ExtentReports reports;
    protected static ExtentTest test;

    private static String resultPath = getResultPath();

    public static void deleteDirectory(File directory) {

        if(directory.exists()) {
            File[] files = directory.listFiles();
            if(null!=files) {
                for(int i=0;i<files.length;i++) {
                    System.out.println(files[i].getName());
                    if(files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    } else {
                        files[i].delete();
                    }
                }
            }
        }
    }

    private static String getResultPath() {
        resultPath = "testReport";
        if(!new File(resultPath).isDirectory()) {
            new File(resultPath);
        }
        return resultPath;
    }

    String reportLocation = "test-output/Report/" + resultPath +"/";

    public void onTestStart(ITestResult result) {
        test = reports.startTest(result.getMethod().getMethodName());
        System.out.println(result.getTestClass().getTestName());
        System.out.println(result.getMethod().getMethodName());
    }
/*
    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, "Test Suite pass");
    }

    public void onTestFail(ITestResult result) {
        test.log(LogStatus.FAIL, "Test case Fail");
    }

    public void onTestSkip(ITestResult result) {
        test.log(LogStatus.SKIP, "Test case Skip");
    }
*/
    public void onStart(ITestContext context) {
        System.out.println(reportLocation + "ReportLocation");
        reports = new ExtentReports(reportLocation + "ExtentReport.html");
        test = reports.startTest("");
    }

    public void onFinish(ITestContext context) {
        reports.endTest(test);
        reports.flush();
    }
}
