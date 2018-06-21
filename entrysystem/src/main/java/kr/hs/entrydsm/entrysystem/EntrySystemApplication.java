package kr.hs.entrydsm.entrysystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EntrySystemApplication {

    private static final String APPLICATION_YML_LOCATIONS = "spring.config.location=" +
            "classpath:application.yml," +
            "/app/config/entrysystem/application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(EntrySystemApplication.class)
                .properties(APPLICATION_YML_LOCATIONS).run(args);
    }
}
