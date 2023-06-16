package com.mycompany.mavenproject1;

import java.util.Properties;

public class NamedEntityRecognitionPropertiesJ {
    public static Properties NerProperties(String lang) {
        Properties props = new Properties();
        if (lang.equals("en")) {
            props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
            props.setProperty("ner.applyFineGrained", "false");
            props.setProperty("ner.useSUTime", "false");
        } else if (lang.equals("es")) {
            props.put("annotators", "tokenize, ssplit, pos, lemma, ner");
            props.setProperty("tokenize.language", "es");
            props.setProperty("pos.language", "es");
            props.setProperty("ner.model", "edu/stanford/nlp/models/ner/spanish.ancora.distsim.s512.crf.ser.gz");
            props.setProperty("ner.applyFineGrained", "false");
            props.setProperty("ner.useSUTime", "false");
        }
        return props;
    }
}
