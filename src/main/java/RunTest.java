import core.testBase.TestRunner;


public class RunTest {



    public static void main(String[] args) {

        TestRunner testRunner = new TestRunner(args[0]);

        testRunner.runTests();
        testRunner.printLogs();
        testRunner.makeJsonFileFromLogs();


    }


}
