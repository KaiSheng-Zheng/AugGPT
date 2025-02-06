package com.auggpt.service;

import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.util.ArrayList;
import java.util.HashMap;

public class FailRecordTestListener implements TestExecutionListener {

    private final HashMap<TestIdentifier,TestExecutionResult> testExecutionResultHashMap = new HashMap<>();
    private final HashMap<String, String> testFailedReasonHashMap = new HashMap<String, String>();
    private int failCnt = 0;
    private int successCnt = 0;


    private final ArrayList<String> failedName = new ArrayList<>();

    public FailRecordTestListener() {
    }


    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        switch (testExecutionResult.getStatus()) {
            case SUCCESSFUL: {
                successCnt++;
                break;
            }
            case ABORTED: {
                if (testIdentifier.isTest()) {
                    failCnt++;
                    this.testExecutionResultHashMap.put(testIdentifier, testExecutionResult);
                }
                break;
            }
            case FAILED: {
                if (testIdentifier.isTest()) {
                    failCnt++;
                    this.testExecutionResultHashMap.put(testIdentifier, testExecutionResult);
                    this.failedName.add(testIdentifier.getDisplayName());
                }

                testExecutionResult.getThrowable().ifPresent((throwable) -> {
                    String msg = throwable.toString();
                    if (throwable.getClass().getName().contains("AssertionFailedError")){
                        return;
                    }
                    testFailedReasonHashMap.put(testIdentifier.getDisplayName(), msg);
                });
                break;
            }
            default:
                throw new PreconditionViolationException("Unsupported execution status:" + testExecutionResult.getStatus());
        }

    }

    public HashMap<String, String> getTestFailedReasonHashMap() {
        return testFailedReasonHashMap;
    }

    public HashMap<TestIdentifier, TestExecutionResult> getTestExecutionResultHashMap() {
        return testExecutionResultHashMap;
    }

    public ArrayList<String> getFailedName() {
        return failedName;
    }

    public double getSuccessRatio() {
        return successCnt/(double)(successCnt+failCnt);
    }

    public double getFailedRatio() {
        return failCnt/(double)(successCnt+failCnt);
    }
}