package com.eneskzlcn.frequencyfinder.word_frequency;

public class FrequencyList {
    private int size = 0;
    private FrequencyNode head = null;
    private FrequencyNode tail = null;

    public void Add(FrequencyNode node) {
        if(isEmpty()){
            return;
        }
        FrequencyNode tempNode = head;
        FrequencyNode previousNode = null;
        while(tempNode != null) {
            if(tempNode.getFrequency() <= node.getFrequency() && tempNode == head) {
                this.AddFirst(node);
                return;
            }else if(tempNode.getFrequency() <= node.getFrequency() && previousNode != null) {
                this.AddMiddle(node, previousNode);
                return;
            }
            previousNode = tempNode;
            tempNode = tempNode.nextNode;
        }
        this.AddLast(node);
    }
    public void AddFirst(FrequencyNode node) {
        node.nextNode = head;
        this.head = node;
        this.size += 1;
    }
    public void AddMiddle(FrequencyNode node, FrequencyNode previousNode) {
        node.nextNode = previousNode.nextNode;
        previousNode.nextNode = node;
        this.size += 1;
    }
    public void AddLast(FrequencyNode node) {
        tail.nextNode = node;
        this.tail = tail.nextNode;
        this.size += 1;
    }
    private boolean isEmpty() {
        return size == 0;
    }
}
