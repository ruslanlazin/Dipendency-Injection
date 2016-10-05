package ua.pp.lazin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class ConsoleInputReader {

    private Selector output;

    @Autowired
    public ConsoleInputReader(Selector output) {
        this.output = output;
    }

    public void readAndGo(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name");
        String input = "";
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        output.prepareAndPrint(input);
    }
}