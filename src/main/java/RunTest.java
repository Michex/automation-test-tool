import core.testBase.TestRunner;
import io.vavr.collection.List;

public class RunTest {

    public static void main(String[] args) {

        //TODO get list of strings

        List<String> testSuites = List.of(args);

        List<String> testSuitesWithoutDate = testSuites.drop(0);

        TestRunner testRunner = new TestRunner(testSuitesWithoutDate, testSuites.get(0));

        testRunner.runTests();

    }


}
