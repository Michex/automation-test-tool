package core.testBase.logger;

public class Log {

    public final String testName;
    public final StatusEnum status;
    public final String stackTrace;
    public final String date;


    public Log(String testName, StatusEnum status, String stackTrace, String date) {

        this.testName = testName;
        this.status = status;
        this.stackTrace = stackTrace;
        this.date = date;

    }

}
