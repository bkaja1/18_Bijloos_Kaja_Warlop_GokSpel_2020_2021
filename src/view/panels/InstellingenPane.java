package view.panels;

import controller.InstellingenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.database.LoadSaveEnum;
import model.gokstrategies.GokEnum;
import model.gokstrategies.GokStrategy;

import javax.swing.*;
import java.util.ArrayList;

public class InstellingenPane extends GridPane {
    private ToggleGroup loadSaveGroup = new ToggleGroup();
    private RadioButton spelerTekstRb = new RadioButton(LoadSaveEnum.SPELERTEKST.toString());
    private RadioButton spelerExcelRb = new RadioButton(LoadSaveEnum.SPELEREXCEL.toString());
    private CheckBox evenStrategyCb = new CheckBox(GokEnum.EVENSTRATEGY.getOmschrijving());
    private CheckBox somIs21StrategyCb = new CheckBox(GokEnum.SOMIS21STRATEGY.getOmschrijving());
    private CheckBox hogerDanVorigeStrategyCb = new CheckBox(GokEnum.HOGERDANVORIGESTRATEGY.getOmschrijving());
    private CheckBox hogerDanEenStrategyCb = new CheckBox(GokEnum.HOGERDANEENSTRATEGY.getOmschrijving());
    private CheckBox somIsMin6StrategyCb = new CheckBox(GokEnum.SOMISMINSTENS6STRATEGY.getOmschrijving());
    private Button saveButton = new Button("Save");

    public InstellingenPane(InstellingenController controller) {
        controller.setView(this);

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        spelerTekstRb.setToggleGroup(loadSaveGroup);
        spelerExcelRb.setToggleGroup(loadSaveGroup);

        this.add(new Label("Instellingen:"), 0, 0, 1, 1);
        this.add(new Label("Formaat:"), 0, 1, 1, 1);
        this.add(spelerTekstRb, 0, 2, 1, 1);
        this.add(spelerExcelRb, 0, 3, 1, 1);
        this.add(new Label("Gokstrategieën:"), 0, 4, 1, 1);
        this.add(evenStrategyCb, 0, 5, 1, 1);
        this.add(somIs21StrategyCb, 0, 6, 1, 1);
        this.add(hogerDanVorigeStrategyCb, 0, 7, 1, 1);
        this.add(hogerDanEenStrategyCb, 0, 8, 1, 1);
        this.add(somIsMin6StrategyCb, 0, 9, 1, 1);
        this.add(saveButton, 0, 10, 1, 1);

        saveButton.setOnAction(event -> {
            try {
                if(loadSaveGroup.getSelectedToggle() == null) {
                    throw new IllegalArgumentException("Kies formaat in de instellingen tab");
                }
                RadioButton loadSaveRb = (RadioButton) loadSaveGroup.getSelectedToggle();
                controller.setLoadSaveProperty(loadSaveRb.getText());
                String gokstrategies = "";
                if(evenStrategyCb.isSelected()) gokstrategies += evenStrategyCb.getText() + ",";
                if(somIs21StrategyCb.isSelected()) gokstrategies += somIs21StrategyCb.getText() + ",";
                if(hogerDanVorigeStrategyCb.isSelected()) gokstrategies += hogerDanVorigeStrategyCb.getText() + ",";
                if(hogerDanEenStrategyCb.isSelected()) gokstrategies += hogerDanEenStrategyCb.getText() + ",";
                if(somIsMin6StrategyCb.isSelected()) gokstrategies += somIsMin6StrategyCb.getText() + ",";
                controller.setGokStrategiesProperty(gokstrategies);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        });
    }

    public void setSelectedLoadSave(String type) {
        if(spelerTekstRb.getText().equals(type)) {
            spelerTekstRb.setSelected(true);
        }
        if(spelerExcelRb.getText().equals(type)) {
            spelerExcelRb.setSelected(true);
        }
    }

    public void setSelectedGokStrategies(ArrayList<GokStrategy> selectedGokStrategies) {
        for(GokStrategy gokStrategy : selectedGokStrategies) {
            if(gokStrategy.getOmschrijving().equals(evenStrategyCb.getText())) {
                evenStrategyCb.setSelected(true);
            }
            if(gokStrategy.getOmschrijving().equals(somIs21StrategyCb.getText())) {
                somIs21StrategyCb.setSelected(true);
            }
            if(gokStrategy.getOmschrijving().equals(hogerDanVorigeStrategyCb.getText())) {
                hogerDanVorigeStrategyCb.setSelected(true);
            }
            if(gokStrategy.getOmschrijving().equals(hogerDanEenStrategyCb.getText())) {
                hogerDanEenStrategyCb.setSelected(true);
            }
            if(gokStrategy.getOmschrijving().equals(somIsMin6StrategyCb.getText())) {
                somIsMin6StrategyCb.setSelected(true);
            }
        }
    }

    public void setDisableSaveButton(boolean b) {
        saveButton.setDisable(b);
    }
}
