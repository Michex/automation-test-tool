import core.testBase.TestRunner;
import io.vavr.collection.List;

public class RunTest {

    public static void main(String[] args) {


        String currentTime = args[0];

        List<String> testSuites = List.of(args).drop(1);
        TestRunner testRunner = new TestRunner(testSuites, currentTime);
        testRunner.runTests();

    }


}
