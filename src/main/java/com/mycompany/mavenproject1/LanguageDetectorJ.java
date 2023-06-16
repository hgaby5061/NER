package com.mycompany.mavenproject1;

import org.apache.tika.langdetect.optimaize.OptimaizeLangDetector;

public class LanguageDetectorJ {
    public static String languageDetector(String text) {
        OptimaizeLangDetector lang = (OptimaizeLangDetector) new OptimaizeLangDetector().loadModels();
        lang.addText(text);
        String langString = lang.detect().getLanguage();
        return langString;
    }
}
