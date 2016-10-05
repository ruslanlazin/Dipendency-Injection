package ua.pp.lazin.greetings;


import org.springframework.stereotype.Component;

@Component
public class MainGreeting {

    public MainGreeting() {
    }

    public String greet(String name) {
        return "Hello " + name;
    }

}


