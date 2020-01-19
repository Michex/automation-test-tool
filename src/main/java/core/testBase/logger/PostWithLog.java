package core.testBase.logger;

import io.vavr.control.Try;

import static io.restassured.RestAssured.given;

public class PostWithLog {

    public final Log log;

    public PostWithLog(Log log) {

        this.log = log;
        this.sendPost(log);
    }

    private void sendPost(Log log) {

        Try.run(() -> {
            given().
                    formParam("runDate", log.date).
                    formParam("stackTrace", log.stackTrace).
                    formParam("status", log.status).
                    formParam("testCaseName", log.testName).
                    when()
                    .post("http://localhost:8080/testRunner/setTestStatus").
                    then().statusCode(200);
        }).onFailure(Throwable::printStackTrace);
    }

}


