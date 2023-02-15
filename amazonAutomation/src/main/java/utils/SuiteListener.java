package main.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import test.Java.BaseTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {

    @Override
    public void onTestStart(ITestResult iTestResult){

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult){

    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + iTestResult.getMethod().getMethodName();
        File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(f, new File(fileName + " .png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult){

    }

    @Override
    public void onStart(ITestContext iTestContext){

    }

    @Override
    public void onFinish(ITestContext iTestContext){

    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method){
        iTestAnnotation.setRetryAnalyzer(RetryAnalyser.class);
    }


}
