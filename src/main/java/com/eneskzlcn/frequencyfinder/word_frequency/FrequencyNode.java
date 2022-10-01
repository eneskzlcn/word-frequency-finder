package com.eneskzlcn.frequencyfinder.word_frequency;

public class FrequencyNode {

    private int frequency;
    private String filename;

    public FrequencyNode nextNode;

    public FrequencyNode(String filename) {
        this.filename = filename;
        this.frequency = 1;
    }
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Filename = "+filename+ "\tFrequency= "+frequency+"\n";
    }
}
