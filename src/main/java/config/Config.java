package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Try;
import lombok.Getter;

import java.io.File;

@Getter
public class Config {

    private final static String yamlSource = "/home/msasin/www/tosterApp/automation-test-tool/src/main/resources/selenium-config.yaml";

    @JsonProperty("url")
    String url;

    @JsonProperty("window size")
    String windowSize;

    @JsonProperty("implicitly wait")
    int waitTime;

    private static final Config INSTANCE = new Config();

    public static Config getConfig() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return Try.of(() -> {
            return mapper.readValue(new File(yamlSource), Config.class);
        }).onFailure(Throwable::printStackTrace).get();
    }

    private Config() {

    }

}
