package view.panels;

import controller.InstellingenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class InstellingenPane extends GridPane {
    private ComboBox loadSaveComboBox = new ComboBox<>();
    private Button saveButton = new Button("Save");

    public InstellingenPane(InstellingenController controller) {
        controller.setView(this);

        ObservableList<String> loadSave = FXCollections.observableList(controller.getLoadSaveLijst());
        loadSaveComboBox.setItems(loadSave);
        loadSaveComboBox.setValue(loadSave.get(0));

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Instellingen:"), 0, 0, 1, 1);
        this.add(new Label("Formaat:"), 0, 1, 1, 1);
        this.add(loadSaveComboBox, 0, 2, 1, 1);
        this.add(new Label("Gokstrategieën:"), 0, 3, 1, 1);
        this.add(saveButton, 0, 9, 1, 1);

        saveButton.setOnAction(event -> {
            try {
                controller.setProperty("loadSave", loadSaveComboBox.getSelectionModel().getSelectedItem().toString());
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        });
    }

    public void setDisableSaveButton(boolean b) {
        saveButton.setDisable(b);
    }
}
