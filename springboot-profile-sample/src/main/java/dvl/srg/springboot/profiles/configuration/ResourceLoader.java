package dvl.srg.springboot.profiles.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@SuppressWarnings("ConfigurationProperties")
@ConfigurationProperties("spring.myresources")
public class ResourceLoader {

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Profile("dev")
    @Bean
    public String devResourceLoader() {
        System.out.println("Resources for DEV");
        System.out.println(key);
        System.out.println(value);
        return "Resources for DEV";
    }

    @Profile("qa")
    @Bean
    public String qaResourceLoader() {
        System.out.println("Resources for QA");
        System.out.println(key);
        System.out.println(value);
        return "Resources for QA";
    }

    @Profile("prod")
    @Bean
    public String prodResourceLoader() {
        System.out.println("Resources for PROD");
        System.out.println(key);
        System.out.println(value);
        return "Resources for PROD";
    }
}

