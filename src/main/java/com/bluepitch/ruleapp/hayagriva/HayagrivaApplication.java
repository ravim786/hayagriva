package com.bluepitch.ruleapp.hayagriva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.bluepitch.ruleapp.hayagriva.**", "org.kie.kogito.**", "http**", "com_46bluepitch_46ruleapp_46hayagriva**"})
public class HayagrivaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HayagrivaApplication.class, args);
    }

}