package core.testBase.testSuite;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class TestSuiteModel {


    @JsonProperty("appName")
    private String appName;

    @JsonProperty("tests")
    private List<String> tests;


    private TestSuiteModel() {

    }

    public String getAppName() {
        return appName;
    }


    public List<String> getTests() {
        return tests;
    }


}
