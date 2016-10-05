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
        String uncasedName = upcaser.upcaseSentence(name);
        NationalityTypes nationality = nationalityDetector.getNationality(uncasedName);
        switch (nationality) {
            case US:
                uncasedName = usGreeting.greet(uncasedName);
                break;
            case JAPAN:
                uncasedName = japanGreeting.greet(uncasedName);
                break;
            case UNDEFINED:
                uncasedName = mainGreeting.greet(uncasedName);
        }
        myPrinter.printSentence(uncasedName);
    }

}
