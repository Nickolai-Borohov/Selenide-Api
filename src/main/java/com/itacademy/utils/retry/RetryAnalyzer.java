package com.itacademy.utils.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int retryLimit=0;
    int counter=4;
    @Override
    public boolean retry (ITestResult iTestResult) {
        if (counter<retryLimit)
        {
            counter++;
            return true;
        }
        return false;
    }
}
