package ua.pp.lazin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.lazin.greetings.JapanGreeting;
import ua.pp.lazin.greetings.MainGreeting;
import ua.pp.lazin.greetings.UsGreeting;

@Component
public class Selector {
    private Upcaser upcaser;
    private NationalityDetector nationalityDetector;
    private UsGreeting usGreeting;
    private JapanGreeting japanGreeting;
    private MainGreeting mainGreeting;
    private MyPrinter myPrinter;

    @Autowired
    public Selector(Upcaser upcaser, NationalityDetector nationalityDetector, UsGreeting usGreeting,
                    JapanGreeting japanGreeting, MainGreeting mainGreeting, MyPrinter myPrinter) {
        this.upcaser = upcaser;
        this.nationalityDetector = nationalityDetector;
        this.usGreeting = usGreeting;
        this.japanGreeting = japanGreeting;
        this.mainGreeting = mainGreeting;
        this.myPrinter = myPrinter;
    }

    public void prepareAndPrint(String name) {
        name = upcaser.upcaseSentence(name);
        NationalityTypes nationality = nationalityDetector.getNationality(name);
        switch (nationality) {
            case US:
                name = usGreeting.greet(name);
                break;
            case JAPAN:
                name = japanGreeting.greet(name);
                break;
            case UNDEFINED:
                name = mainGreeting.greet(name);
        }
        myPrinter.printSentence(name);
    }
}
