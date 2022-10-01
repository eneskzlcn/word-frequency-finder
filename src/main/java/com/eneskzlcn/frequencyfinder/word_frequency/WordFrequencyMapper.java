package com.eneskzlcn.frequencyfinder.word_frequency;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyMapper {
    private HashMap<String, FileFrequencyMapper> wordFrequencyMap;

    public WordFrequencyMapper() {
        this.wordFrequencyMap = new HashMap();
    }
    public void addWordFrequency(WordFrequency wordFrequency) {
        if (!this.wordFrequencyMap.containsKey(wordFrequency.word)) {
            this.wordFrequencyMap.put(wordFrequency.word,
                    new FileFrequencyMapper(new FileFrequency(wordFrequency.fileName, 1)));
            return;
        }
        this.wordFrequencyMap.get(wordFrequency.word).
                addFileFrequency(new FileFrequency(wordFrequency.fileName, 1));
    }
    public void print() {
        System.out.printf("---All Word Frequencies---\n");
        for (Map.Entry<String, FileFrequencyMapper> set: this.wordFrequencyMap.entrySet()) {
            System.out.println(set.getKey());
            set.getValue().print();
        }
        System.out.println();
    }
}
