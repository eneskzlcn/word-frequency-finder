package com.eneskzlcn.frequencyfinder;

import com.eneskzlcn.frequencyfinder.word_frequency.Tree;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FrequencyFinder {
    private File[] frequencySearchableFiles;
    private Tree<String> wordFrequencyTree;
    public FrequencyFinder(File[] frequencySearchableFiles) {
        this.frequencySearchableFiles = frequencySearchableFiles;
        this.wordFrequencyTree = new Tree<String>();
    }
    public void searchAllFrequencies() {
        for(File file: this.frequencySearchableFiles) {
            searchFrequenciesOnFile(file);
        }
    }
    /* Each space seperated token read from file should recover from punctuation and capitalization
    to accepted as a word.
     */
    public void searchFrequenciesOnFile(File file) {
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String token = scan.next();
                String word = StringUtil.recoverPunctuationAndCapitalization(token);
//                this.wordFrequencyTree.insert
            }
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
