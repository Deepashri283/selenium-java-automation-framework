package com.inetbanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @Override
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp
        String repName = "Test-Report-" + timeStamp + ".html";

        // Updated to use ExtentSparkReporter for Extent Reports v5
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);

        try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        } catch (Exception e) {
            System.out.println("Extent configuration file not found or invalid: " + e.getMessage());
        }

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "pavan");

        htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Title of report
        htmlReporter.config().setReportName("Functional Test Report"); // Name of the report
        htmlReporter.config().setTheme(Theme.DARK);
        // Note: htmlReporter.config().setTestViewChartLocation(...) is removed in v5
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger = extent.createTest(tr.getName()); // create new entry in the report
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed information
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        logger = extent.createTest(tr.getName()); // create new entry in the report
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the failed information
        
        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";
        File f = new File(screenshotPath);
        
        if (f.exists()) {
            try {
                // Modern v5 approach to logging screenshots alongside a message cleanly
                logger.fail("Screenshot is below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger = extent.createTest(tr.getName()); // create new entry in the report
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }
    
    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();
    }
}
