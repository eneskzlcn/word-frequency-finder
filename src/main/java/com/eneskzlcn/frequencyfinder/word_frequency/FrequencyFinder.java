package com.eneskzlcn.frequencyfinder.word_frequency;

import com.eneskzlcn.frequencyfinder.StringUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
public class FrequencyFinder {
    private File[] frequencySearchableFiles;
    private WordFrequencyMapper wordFrequencyMapper;
    public FrequencyFinder(File[] frequencySearchableFiles) {
        this.frequencySearchableFiles = frequencySearchableFiles;
        this.wordFrequencyMapper = new WordFrequencyMapper();
    }
    public void findAllFrequencies() {
        for(File file: this.frequencySearchableFiles) {
            findFrequenciesOnFile(file);
        }
    }
    public void findFrequenciesOnFile(File file) {
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                WordFrequency wordFrequency = new WordFrequency(scan.next(),file.getName());
                this.wordFrequencyMapper.addWordFrequency(wordFrequency);
            }
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<FileFrequency> findFrequenciesOfGivenWord(String word) {
        return this.wordFrequencyMapper.getFileFrequencyListOfGivenWord(word);
    }
}
