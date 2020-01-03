package core.testBase.logger;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.config.Config;
import io.vavr.control.Try;

import java.io.File;
import java.util.List;

public class LogToJson {


    public static void makeLogFile(List<Log> logs){

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        Try.run(() -> mapper.writeValue(new File(Config.getConfig().getTestStatusPath()), logs)).onFailure(Throwable::printStackTrace);

    }

}
