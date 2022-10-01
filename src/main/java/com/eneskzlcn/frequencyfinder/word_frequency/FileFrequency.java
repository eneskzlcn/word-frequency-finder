package com.eneskzlcn.frequencyfinder.word_frequency;

public class FileFrequency {
    public String fileName;
    public int frequency;

    public FileFrequency(String fileName, int frequency) {
        this.fileName = fileName;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return this.frequency + " times in "+ this.fileName;
    }
}
