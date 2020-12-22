package view.panels;

import controller.InstellingenController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.database.LoadSaveEnum;
import model.gokstrategies.GokEnum;
import model.gokstrategies.GokStrategy;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @Author Blenda Kaja
 */

public class InstellingenPane extends GridPane {
    private ToggleGroup loadSaveGroup = new ToggleGroup();
    private RadioButton spelerTekstRb = new RadioButton(LoadSaveEnum.SPELERTEKST.toString());
    private RadioButton spelerExcelRb = new RadioButton(LoadSaveEnum.SPELEREXCEL.toString());
    private CheckBox evenStrategyCb = new CheckBox(GokEnum.EVENSTRATEGY.getOmschrijving());
    private TextField evenStrategyTextField = new TextField();
    private CheckBox somIs21StrategyCb = new CheckBox(GokEnum.SOMIS21STRATEGY.getOmschrijving());
    private TextField somIs21StrategyTextField = new TextField();
    private CheckBox hogerDanVorigeStrategyCb = new CheckBox(GokEnum.HOGERDANVORIGESTRATEGY.getOmschrijving());
    private TextField hogerDanVorigeStrategyTextField = new TextField();
    private CheckBox hogerDanEenStrategyCb = new CheckBox(GokEnum.HOGERDANEENSTRATEGY.getOmschrijving());
    private TextField hogerDanEenStrategyTextField = new TextField();
    private CheckBox somIsMin6StrategyCb = new CheckBox(GokEnum.SOMISMINSTENS6STRATEGY.getOmschrijving());
    private TextField somIsMin6StrategyTextField = new TextField();
    private Button saveButton = new Button("Save");

    public InstellingenPane(InstellingenController controller) {
        controller.setView(this);

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        spelerTekstRb.setToggleGroup(loadSaveGroup);
        spelerExcelRb.setToggleGroup(loadSaveGroup);
        evenStrategyTextField.setEditable(evenStrategyCb.isSelected());
        somIs21StrategyTextField.setEditable(somIs21StrategyCb.isSelected());
        hogerDanVorigeStrategyTextField.setEditable(hogerDanVorigeStrategyCb.isSelected());
        hogerDanEenStrategyTextField.setEditable(hogerDanEenStrategyCb.isSelected());
        somIsMin6StrategyTextField.setEditable(somIsMin6StrategyCb.isSelected());

        this.add(new Label("Instellingen:"), 0, 0, 1, 1);
        this.add(new Label("Formaat:"), 0, 1, 1, 1);
        this.add(spelerTekstRb, 0, 2, 1, 1);
        this.add(spelerExcelRb, 0, 3, 1, 1);
        this.add(new Label("Gokstrategieën:"), 0, 4, 1, 1);
        this.add(new Label("Winstfactor:"), 1, 4, 1, 1);
        this.add(evenStrategyCb, 0, 5, 1, 1);
        this.add(evenStrategyTextField, 1, 5, 1, 1);
        this.add(somIs21StrategyCb, 0, 6, 1, 1);
        this.add(somIs21StrategyTextField, 1, 6, 1, 1);
        this.add(hogerDanVorigeStrategyCb, 0, 7, 1, 1);
        this.add(hogerDanVorigeStrategyTextField, 1, 7, 1, 1);
        this.add(hogerDanEenStrategyCb, 0, 8, 1, 1);
        this.add(hogerDanEenStrategyTextField, 1, 8, 1, 1);
        this.add(somIsMin6StrategyCb, 0, 9, 1, 1);
        this.add(somIsMin6StrategyTextField, 1, 9, 1, 1);
        this.add(saveButton, 0, 10, 1, 1);
        this.add(new Label("Als je geen formaat/gokstrategieën/geldige winstfactor"), 0, 11, 1, 1);
        this.add(new Label("invoert worden deze instellingen niet opgeslagen!"), 0,12, 1, 1);

        evenStrategyCb.setOnAction(event -> {
            if(!evenStrategyCb.isSelected()) {
                evenStrategyTextField.clear();
            }
            evenStrategyTextField.setEditable(evenStrategyCb.isSelected());
        });

        somIs21StrategyCb.setOnAction(event -> {
            if(!somIs21StrategyCb.isSelected()) {
                somIs21StrategyTextField.clear();
            }
            somIs21StrategyTextField.setEditable(somIs21StrategyCb.isSelected());
        });

        hogerDanVorigeStrategyCb.setOnAction(event -> {
            if(!hogerDanVorigeStrategyCb.isSelected()) {
                hogerDanVorigeStrategyTextField.clear();
            }
            hogerDanVorigeStrategyTextField.setEditable(hogerDanVorigeStrategyCb.isSelected());
        });

        hogerDanEenStrategyCb.setOnAction(event -> {
            if(!hogerDanEenStrategyCb.isSelected()) {
                hogerDanEenStrategyTextField.clear();
            }
            hogerDanEenStrategyTextField.setEditable(hogerDanEenStrategyCb.isSelected());
        });

        somIsMin6StrategyCb.setOnAction(event -> {
            if(!somIsMin6StrategyCb.isSelected()) {
                somIsMin6StrategyTextField.clear();
            }
            somIsMin6StrategyTextField.setEditable(somIsMin6StrategyCb.isSelected());
        });

        saveButton.setOnAction(event -> {
            try {
                if (loadSaveGroup.getSelectedToggle() == null) {
                    throw new IllegalArgumentException("Selecteer formaat in de instellingen tab");
                }
                RadioButton loadSaveRb = (RadioButton) loadSaveGroup.getSelectedToggle();
                controller.setLoadSaveProperty(loadSaveRb.getText());
                String gokstrategies = "";
                if (evenStrategyCb.isSelected()) {
                    if(Integer.parseInt(evenStrategyTextField.getText()) <= 1) {
                        throw new IllegalArgumentException("Winstfactor moet groter zijn dan 1");
                    }
                    gokstrategies += evenStrategyCb.getText() + "," + Integer.parseInt(evenStrategyTextField.getText()) + "!";
                }
                if (somIs21StrategyCb.isSelected()) {
                    if(Integer.parseInt(somIs21StrategyTextField.getText()) <= 1) {
                        throw new IllegalArgumentException("Winstfactor moet groter zijn dan 1");
                    }
                    gokstrategies += somIs21StrategyCb.getText() + "," + Integer.parseInt(somIs21StrategyTextField.getText()) + "!";
                }
                if (hogerDanVorigeStrategyCb.isSelected()) {
                    if(Integer.parseInt(hogerDanVorigeStrategyTextField.getText()) <= 1) {
                        throw new IllegalArgumentException("Winstfactor moet groter zijn dan 1");
                    }
                    gokstrategies += hogerDanVorigeStrategyCb.getText() + "," + Integer.parseInt(hogerDanVorigeStrategyTextField.getText()) + "!";
                }
                if (hogerDanEenStrategyCb.isSelected()) {
                    if(Integer.parseInt(hogerDanEenStrategyTextField.getText()) <= 1) {
                        throw new IllegalArgumentException("Winstfactor moet groter zijn dan 1");
                    }
                    gokstrategies += hogerDanEenStrategyCb.getText() + "," + Integer.parseInt(hogerDanEenStrategyTextField.getText()) + "!";
                }
                if (somIsMin6StrategyCb.isSelected()) {
                    if(Integer.parseInt(somIsMin6StrategyTextField.getText()) <= 1) {
                        throw new IllegalArgumentException("Winstfactor moet groter zijn dan 1");
                    }
                    gokstrategies += somIsMin6StrategyCb.getText() + "," + Integer.parseInt(somIsMin6StrategyTextField.getText()) + "!";
                }
                controller.setGokStrategiesProperty(gokstrategies);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Winstfactor mag niet leeg of een niet-integer zijn");
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
                evenStrategyTextField.setText(Integer.toString(gokStrategy.getWinstfactor()));
            }
            if(gokStrategy.getOmschrijving().equals(somIs21StrategyCb.getText())) {
                somIs21StrategyCb.setSelected(true);
                somIs21StrategyTextField.setText(Integer.toString(gokStrategy.getWinstfactor()));
            }
            if(gokStrategy.getOmschrijving().equals(hogerDanVorigeStrategyCb.getText())) {
                hogerDanVorigeStrategyCb.setSelected(true);
                hogerDanVorigeStrategyTextField.setText(Integer.toString(gokStrategy.getWinstfactor()));
            }
            if(gokStrategy.getOmschrijving().equals(hogerDanEenStrategyCb.getText())) {
                hogerDanEenStrategyCb.setSelected(true);
                hogerDanEenStrategyTextField.setText(Integer.toString(gokStrategy.getWinstfactor()));
            }
            if(gokStrategy.getOmschrijving().equals(somIsMin6StrategyCb.getText())) {
                somIsMin6StrategyCb.setSelected(true);
                somIsMin6StrategyTextField.setText(Integer.toString(gokStrategy.getWinstfactor()));
            }
        }
    }
}
