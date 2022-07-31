package com.mystore.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryManager implements IRetryAnalyzer {
    int count = 0;

    //Count for which the failed method will be re-tried
    int retryCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        while(count <retryCount){
            count ++;
            return true;
        }
        return false;
    }
}
