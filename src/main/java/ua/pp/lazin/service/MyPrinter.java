package ua.pp.lazin.service;

import org.springframework.stereotype.Component;

@Component
public class MyPrinter {

    public void printSentence(String sentence) {
        System.out.println(sentence);
    }
}
