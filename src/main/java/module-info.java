module com.eneskzlcn.frequencyfinder {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires junit;

    opens com.eneskzlcn.frequencyfinder to javafx.fxml;
    exports com.eneskzlcn.frequencyfinder;
    exports com.eneskzlcn.frequencyfinder.word_frequency;
    opens com.eneskzlcn.frequencyfinder.word_frequency to javafx.fxml;
}