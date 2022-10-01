package com.eneskzlcn.frequencyfinder.word_frequency;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileFrequencyMapper{
    HashMap<String, Integer> fileFrequencyMap;

    public FileFrequencyMapper() {
        this.fileFrequencyMap = new HashMap();
    }
    public FileFrequencyMapper(FileFrequency frequency) {
        this.fileFrequencyMap = new HashMap();
        this.addFileFrequency(frequency);
    }
    public void addFileFrequency(FileFrequency frequency) {
        if (!fileFrequencyMap.containsKey(frequency.fileName)) {
            fileFrequencyMap.put(frequency.fileName, frequency.frequency);
            return;
        }
        Integer totalFrequency = fileFrequencyMap.get(frequency.fileName) + frequency.frequency;
        fileFrequencyMap.put(frequency.fileName, totalFrequency);
    }
    public void print() {
        for (Map.Entry<String, Integer> set: this.fileFrequencyMap.entrySet()) {
            System.out.printf("\t Filename %s, Frequency: %d\n", set.getKey(), set.getValue());
        }
    }
}
