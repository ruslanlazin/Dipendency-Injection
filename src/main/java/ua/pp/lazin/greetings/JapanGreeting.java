package ua.pp.lazin.greetings;


import org.springframework.stereotype.Component;

@Component
public class JapanGreeting {

    public JapanGreeting() {
    }

    public String greet(String name) {
        return "Hajimemashite " + name;
    }

}


