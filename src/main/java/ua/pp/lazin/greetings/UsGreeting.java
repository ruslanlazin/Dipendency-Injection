package ua.pp.lazin.greetings;

import org.springframework.stereotype.Component;

@Component
public class UsGreeting {


    public UsGreeting() {
    }

    public String greet(String name) {
        return "Hi " + name;
    }

}


