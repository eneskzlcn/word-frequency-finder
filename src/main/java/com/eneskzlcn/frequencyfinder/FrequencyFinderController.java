package com.eneskzlcn.frequencyfinder;

import com.eneskzlcn.frequencyfinder.word_frequency.FrequencyFinder;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.PopupWindow;

import java.io.File;

public class FrequencyFinderController {
    @FXML
    private Label directoryName;
    @FXML
    protected void onChooseFileButtonClick() {
        File directory = chooseDirectory();
        File[] frequencySearchableFilesInDirectory = directory.listFiles(new FrequencySearchableFileFilter());
        if (frequencySearchableFilesInDirectory == null) {
            showNotFrequencySearchableDirectoryMessage();
            return;
        }
        FrequencyFinder frequencyFinder = new FrequencyFinder(frequencySearchableFilesInDirectory);
        frequencySearchableFilesInDirectory.clone();

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