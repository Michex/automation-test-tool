package base.testSuite;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TestSuiteModel {

    @JsonProperty("tests")
    private List<String> tests;


    private TestSuiteModel() {

    }


}
