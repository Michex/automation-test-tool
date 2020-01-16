package core.testBase.testSuite;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TestSuiteModel {


    @JsonProperty("name")
    private String name;

    @JsonProperty("tests")
    private List<String> tests;


}
