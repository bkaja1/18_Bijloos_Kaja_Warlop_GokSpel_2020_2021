package view;

import controller.GamblerController;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Spel;
import model.gokstrategies.GokEnum;
import model.gokstrategies.GokStrategy;

import javax.swing.*;

/**
 * @Author Blenda Kaja
 * 		   Niels Bijloos
 */

public class GamblerView {
	private Stage stage = new Stage();
	private BorderPane pane = new BorderPane();
	private GridPane pane1 = new GridPane();
	private GridPane pane2 = new GridPane();
	private GridPane pane3 = new GridPane();
	private TextField spelernaam = new TextField();
	private Label goksaldo = new Label();
	private TextField inzet = new TextField();
	private Button startGokspelButton = new Button("Start gokspel");
	private ToggleGroup gokStrategyGroup;
	private RadioButton evenStrategyRb = new RadioButton(GokEnum.EVENSTRATEGY.getOmschrijving());
	private Label evenStrategyLabel = new Label();
	private RadioButton somIs21StrategyRb = new RadioButton(GokEnum.SOMIS21STRATEGY.getOmschrijving());
	private Label somIs21StrategyLabel = new Label();
	private RadioButton hogerDanVorigeStrategyRb = new RadioButton(GokEnum.HOGERDANVORIGESTRATEGY.getOmschrijving());
	private Label hogerDanVorigeStrategyLabel = new Label();
	private RadioButton hogerDanEenStrategyRb = new RadioButton(GokEnum.HOGERDANEENSTRATEGY.getOmschrijving());
	private Label hogerDanEenStrategyLabel = new Label();
	private RadioButton somIsMin6StrategyRb = new RadioButton(GokEnum.SOMISMINSTENS6STRATEGY.getOmschrijving());
	private Label somIsMin6StrategyLabel = new Label();
	private Button bevestigKeuzeButton = new Button("Bevestig je keuze");
	private Button werpDobbelsteenButton = new Button("Werp dobbelsteen");
	private Label worp1 = new Label();
	private Label worp2 = new Label();
	private Label worp3 = new Label();
	private Label worp4 = new Label();
	private Label result = new Label();
		
	public GamblerView(GamblerController controller){
		stage.setTitle("GAMBLER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();

		pane1.setPadding(new Insets(5, 5, 5, 5));
		pane1.setVgap(5);
		pane1.setHgap(5);
		pane2.setPadding(new Insets(5, 5, 5, 5));
		pane2.setVgap(5);
		pane2.setHgap(5);
		pane3.setPadding(new Insets(5, 5, 5, 5));
		pane3.setVgap(5);
		pane3.setHgap(5);

		result.setTextFill(Color.RED);

		pane1.add(new Label("Wat is je spelernaam?"), 0, 0, 1, 1);
		pane1.add(spelernaam, 1, 0, 1, 1);
		pane1.add(goksaldo, 2, 0, 1, 1);

		pane1.add(new Label("Wat is je inzet?"), 0, 1, 1, 1);
		pane1.add(inzet, 1, 1, 1, 1);
		pane1.add(startGokspelButton, 0, 2, 1, 1);

		pane2.add(new Label("Kies je gok strategie uit onderstaande lijst"), 0, 0, 1, 1);
		pane2.add(evenStrategyRb, 0, 1, 1, 1);
		pane2.add(evenStrategyLabel, 1, 1, 1, 1);
		pane2.add(somIs21StrategyRb, 0, 2, 1, 1);
		pane2.add(somIs21StrategyLabel, 1, 2, 1, 1);
		pane2.add(hogerDanVorigeStrategyRb, 0, 3, 1, 1);
		pane2.add(hogerDanVorigeStrategyLabel, 1, 3, 1, 1);
		pane2.add(hogerDanEenStrategyRb, 0,4,1,1);
		pane2.add(hogerDanEenStrategyLabel, 1,4,1,1);
		pane2.add(somIsMin6StrategyRb, 0,5,1,1);
		pane2.add(somIsMin6StrategyLabel, 1,5,1,1);
		pane2.add(bevestigKeuzeButton, 0, 6, 1, 1);

		pane3.add(werpDobbelsteenButton, 0, 0, 1, 1);
		pane3.add(worp1, 0, 1, 1, 1);
		pane3.add(worp2, 0, 2, 1, 1);
		pane3.add(worp3, 0, 3, 1, 1);
		pane3.add(worp4, 0, 4, 1, 1);
		pane3.add(result, 0, 5, 1, 1);

		pane.setTop(pane1);
		pane.setCenter(pane2);
		pane.setBottom(pane3);

		root.getChildren().addAll(pane);

		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();
		refresh();
		controller.setView(this);

		spelernaam.setOnKeyPressed(event -> {
			if(event.getCode().equals(KeyCode.ENTER)) {
				try {
					controller.updateSpelernaam(spelernaam.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});

		inzet.setOnKeyPressed(event -> {
			if (event.getCode().equals(KeyCode.ENTER)) {
				try {
					controller.updateInzet(inzet.getText());
					inzet.setEditable(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});

		startGokspelButton.setOnAction(event -> {
			try {
				startGokspelButton.setDisable(true);
				for(Toggle toggle: gokStrategyGroup.getToggles()) {
					RadioButton rb = (RadioButton) toggle;
					rb.setDisable(false);
				}
				bevestigKeuzeButton.setDisable(false);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		});

		bevestigKeuzeButton.setOnAction(event -> {
			try {
				if(gokStrategyGroup.getSelectedToggle() == null) {
					throw new IllegalArgumentException("Kies gok strategie in de gamblerview");
				}
				for(Toggle toggle: gokStrategyGroup.getToggles()) {
					RadioButton rb = (RadioButton) toggle;
					rb.setDisable(true);
				}
				RadioButton gokStrategyRb = (RadioButton) gokStrategyGroup.getSelectedToggle();
				controller.updateGokStrategy(gokStrategyRb.getText());
				bevestigKeuzeButton.setDisable(true);
				werpDobbelsteenButton.setDisable(false);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		});

		werpDobbelsteenButton.setOnAction(event -> {
			try {
				int i = (int)(Math.random() * 6 + 1);
				if(worp1.getText().trim().isEmpty()) {
					worp1.setText("Worp1: " + i);
				} else if(worp2.getText().trim().isEmpty()) {
					worp2.setText("Worp2: " + i);
				} else if(worp3.getText().trim().isEmpty()) {
					worp3.setText("Worp3: " + i);
				} else if(worp4.getText().trim().isEmpty()) {
					worp4.setText("Worp4: " + i);
				}
				controller.throwDice(i);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		});
	}

	public void refresh() {
		spelernaam.clear();
		goksaldo.setText("");
		inzet.clear();
		worp1.setText("");
		worp2.setText("");
		worp3.setText("");
		worp4.setText("");
		result.setText("");
		spelernaam.setEditable(true);
		inzet.setEditable(false);
		startGokspelButton.setDisable(true);
		evenStrategyRb.setDisable(true);
		evenStrategyRb.setSelected(false);
		somIs21StrategyRb.setDisable(true);
		somIs21StrategyRb.setSelected(false);
		hogerDanVorigeStrategyRb.setDisable(true);
		hogerDanVorigeStrategyRb.setSelected(false);
		hogerDanEenStrategyRb.setDisable(true);
		hogerDanEenStrategyRb.setSelected(false);
		somIsMin6StrategyRb.setDisable(true);
		somIsMin6StrategyRb.setSelected(false);
		bevestigKeuzeButton.setDisable(true);
		bevestigKeuzeButton.setDisable(true);
		werpDobbelsteenButton.setDisable(true);
	}

	public void displayGokStrategies(Spel spel) {
		gokStrategyGroup = new ToggleGroup();
		evenStrategyLabel.setText("");
		somIs21StrategyLabel.setText("");
		hogerDanVorigeStrategyLabel.setText("");
		hogerDanEenStrategyLabel.setText("");
		somIsMin6StrategyLabel.setText("");
		for(GokStrategy gokStrategy : spel.getSelectedGokStrategies()) {
			if(gokStrategy.getOmschrijving().equals(evenStrategyRb.getText())) {
				evenStrategyRb.setToggleGroup(gokStrategyGroup);
				evenStrategyLabel.setText("mogelijke winst is " + gokStrategy.getWinstfactor() + "x je inzet");
			}
			if(gokStrategy.getOmschrijving().equals(somIs21StrategyRb.getText())) {
				somIs21StrategyRb.setToggleGroup(gokStrategyGroup);
				somIs21StrategyLabel.setText("mogelijke winst is " + gokStrategy.getWinstfactor() + "x je inzet");
			}
			if(gokStrategy.getOmschrijving().equals(hogerDanVorigeStrategyRb.getText())) {
				hogerDanVorigeStrategyRb.setToggleGroup(gokStrategyGroup);
				hogerDanVorigeStrategyLabel.setText("mogelijke winst is " + gokStrategy.getWinstfactor() + "x je inzet");
			}
			if(gokStrategy.getOmschrijving().equals(hogerDanEenStrategyRb.getText())) {
				hogerDanEenStrategyRb.setToggleGroup(gokStrategyGroup);
				hogerDanEenStrategyLabel.setText("mogelijke winst is " + gokStrategy.getWinstfactor() + "x je inzet");
			}
			if(gokStrategy.getOmschrijving().equals(somIsMin6StrategyRb.getText())) {
				somIsMin6StrategyRb.setToggleGroup(gokStrategyGroup);
				somIsMin6StrategyLabel.setText("mogelijke winst is " + gokStrategy.getWinstfactor() + "x je inzet");
			}
		}
	}

	public void displayGoksaldo(int i) {
		goksaldo.setText("Je goksaldo is " + i);
		spelernaam.setEditable(false);
		inzet.setEditable(true);
	}

	public void setEditableInzet(boolean b) {
		inzet.setEditable(b);
	}

	public void setDisableStartButton(boolean b) {
		startGokspelButton.setDisable(b);
	}

	public void displayResult(boolean gewonnen, int goksaldo) {
		inzet.setEditable(false);
		werpDobbelsteenButton.setDisable(true);
		if(gewonnen) {
			result.setText("GEFELICITEERD, JE HEBT GEWONNEN\nJe nieuw goksaldo bedraagt " + goksaldo + " €");
		} else {
			result.setText("HELAAS, JE HEBT NIET GEWONNEN\nJe nieuw goksaldo bedraagt " + goksaldo + " €");
		}
	}
}
