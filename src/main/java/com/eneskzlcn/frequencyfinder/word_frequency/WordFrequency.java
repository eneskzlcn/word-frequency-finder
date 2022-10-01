package com.eneskzlcn.frequencyfinder.word_frequency;

import com.eneskzlcn.frequencyfinder.StringUtil;

public class WordFrequency {
    public String word;
    public String fileName;

    /* Each space seperated token read from file should recover from punctuation and capitalization
    to accepted as a word.
     */
    public WordFrequency(String word, String fileName) {
        this.word = StringUtil.recoverPunctuationAndCapitalization(word);
        this.fileName = fileName;
    }
}
