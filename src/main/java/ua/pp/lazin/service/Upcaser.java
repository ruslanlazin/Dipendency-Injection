package ua.pp.lazin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Upcaser {

    public Upcaser() {
    }

    public String upcaseSentence(String sentence) {
        return sentence.toUpperCase();
    }
}
