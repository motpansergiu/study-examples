package dvl.srg.springboot.profiles.controller;

import dvl.srg.springboot.profiles.configuration.UserProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${app.message}")
    private String welcomeMessage;

    @Autowired
    private UserProps userProps;

    @GetMapping("/welcome")
    public String getDataBaseConnectionDetails() {
        System.out.println(userProps);
        return welcomeMessage;
    }
}
