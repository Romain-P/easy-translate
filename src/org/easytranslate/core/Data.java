package org.easytranslate.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Data {
    private Map<String, String> translations;

    public Data() {
        this.translations = new HashMap<>();
    }

    public Data initialize() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("easy-translate\\translations.txt"));

            while (in.ready()) {
                try {
                    String[] split = in.readLine().trim().split(":");
                    this.translations.put(split[0], split[1]);
                } catch(Exception e) {}
            }
        } catch (Exception e) {}
        return this;
    }

    public Map<String, String> getTranslations() {
        return this.translations;
    }
}
