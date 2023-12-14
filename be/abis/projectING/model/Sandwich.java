package model;

import java.util.HashMap;
import java.util.Map;

public class Sandwich {
    private String name;
    private double price;
    private Map<Language, String> namesInLanguages;

    public Sandwich(String langp, String type, String name, String description, Double price) {

    }

    public enum Language {
        ENGLISH,
        SPANISH,
        FRENCH
    }

    public Sandwich(String name, double price) {
        this.name = name;
        this.price = price;
        this.namesInLanguages = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setNameInLanguage(Language language, String translatedName) {
        namesInLanguages.put(language, translatedName);
    }

    public String getNameInLanguage(Language language) {
        return namesInLanguages.get(language);
    }
}



}
