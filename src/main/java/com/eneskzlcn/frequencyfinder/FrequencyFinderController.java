package com.eneskzlcn.frequencyfinder;

import com.eneskzlcn.frequencyfinder.word_frequency.FileFrequency;
import com.eneskzlcn.frequencyfinder.word_frequency.FrequencyFinder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.PopupWindow;

import java.io.File;
import java.util.List;

public class FrequencyFinderController {
    @FXML
    private TextField searchTextField;
    @FXML
    TextArea searchResultsTextArea;
    @FXML
    private Button searchButton;

    FrequencyFinder frequencyFinder;
    @FXML
    protected void onChooseFileButtonClick() {
        File directory = chooseDirectory();
        File[] frequencySearchableFilesInDirectory = directory.listFiles(new FrequencySearchableFileFilter());
        if (frequencySearchableFilesInDirectory == null) {
            showNotFrequencySearchableDirectoryMessage();
            return;
        }
        this.frequencyFinder = new FrequencyFinder(frequencySearchableFilesInDirectory);
        this.frequencyFinder.findAllFrequencies();
        searchButton.setDisable(false);
        searchTextField.setDisable(false);
    }
    @FXML
    protected void onSearchButtonClick() {
        String searchWord = searchTextField.getText();
        List<FileFrequency> searchWordFileFrequencyList = this.frequencyFinder.findFrequenciesOfGivenWord(searchWord);
        String searchResultText = prepareSearchResultTextByWordFrequencyList(searchWordFileFrequencyList);
        this.searchResultsTextArea.setText(searchResultText);
    }
    private String prepareSearchResultTextByWordFrequencyList(List<FileFrequency> frequencyList) {
        StringBuilder sb = new StringBuilder();
        frequencyList.forEach((fileFrequency) ->{
            sb.append(fileFrequency.toString());
            sb.append("\n");
        });
        return sb.toString();
    }
    private DirectoryChooser createDirectoryChooser() {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Choose a directory... ");
        return dc;
    }
    private File chooseDirectory() {
        DirectoryChooser dc = createDirectoryChooser();
        return dc.showDialog(new PopupWindow() {});
    }
    private void showNotFrequencySearchableDirectoryMessage() {

    }
}