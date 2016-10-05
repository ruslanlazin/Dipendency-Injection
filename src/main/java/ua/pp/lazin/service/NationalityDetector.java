package ua.pp.lazin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class NationalityDetector {

    private Set<String> usNamesDictionary = new HashSet<>();
    private Set<String> japanNamesDictionary = new HashSet<>();

    {
        usNamesDictionary.add("HILARY");
        usNamesDictionary.add("BILL");
        usNamesDictionary.add("MONIKA");

        japanNamesDictionary.add("TAKASHI");
        japanNamesDictionary.add("CHINEN");
        japanNamesDictionary.add("SHIMABUKURO");
    }

    public NationalityDetector() {
    }

    public NationalityTypes getNationality(String name) {

        if (usNamesDictionary.contains(name)) {
            return NationalityTypes.US;
        }
        if (japanNamesDictionary.contains(name)) {
            return NationalityTypes.JAPAN;
        }
        return NationalityTypes.UNDEFINED;
    }
}
