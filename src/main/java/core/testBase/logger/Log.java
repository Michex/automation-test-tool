package core.testBase.logger;

public class Log {

    public final String testName;
    public final StatusEnum status;
    public final String cause;

    public Log(String testName, StatusEnum status, String cause) {

        this.testName = testName;
        this.status = status;
        this.cause = cause;
    }

}
