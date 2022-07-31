package com.mystore.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class ExtentReportSetup {

    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static void setupReport(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date date = new Date();
        String actualDate = format.format(date);
        String reportPath = System.getProperty("user.dir")+ "/test-results/ExtentReports/Report_"+actualDate+".html";
        extentHtmlReporter = new ExtentHtmlReporter(reportPath);
        extentHtmlReporter.config().setDocumentTitle("My Store Test Results");
        extentHtmlReporter.config().setReportName("Execution Report");
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    public static void closeReport(){
        extentReports.flush();
    }
}
