package core.testBase.logger;

import io.vavr.control.Try;
import okhttp3.*;


public class PostWithLog {

    public final Log log;

    public PostWithLog(Log log) {

        this.log = log;
        this.sendPost(log);
    }

    private void sendPost(Log log) {

        final OkHttpClient httpClient = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("runDate", log.date)
                .add("stackTrace", log.stackTrace)
                .add("status", log.status.getStatusName())
                .add("testCaseName", log.testName)
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:8080/testRunner/setTestStatus")
                .post(formBody)
                .build();

        Response response = Try.of(() -> httpClient.newCall(request).execute()).onFailure(Throwable::printStackTrace).get();

        if(!response.isSuccessful()) {
            Try.run(() -> System.out.println(response.body().string())).onFailure(Throwable::printStackTrace);
        }

}


}


