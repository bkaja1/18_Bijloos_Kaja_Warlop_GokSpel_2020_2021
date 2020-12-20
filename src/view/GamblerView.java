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
import model.gokstrategies.GokEnum;

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
	private Label spelernaamLabel = new Label("Wat is je spelernaam?");
	private TextField spelernaam = new TextField();
	private Label goksaldo = new Label();
	private Label inzetLabel = new Label("Wat is je inzet?");
	private TextField inzet = new TextField();
	private Button startButton = new Button("Start gokspel");
	private final ToggleGroup gokStrategyGroup = new ToggleGroup();
	private Label gokStrategyLabel = new Label("Kies je gok strategie uit onderstaande lijst");
	private RadioButton EvenStrategyRb = new RadioButton(GokEnum.EVENSTRATEGY.getOmschrijving());
	private Label EvenStrategyLabel = new Label("mogelijke winst is 4x je inzet");
	private RadioButton somIs21StrategyRb = new RadioButton(GokEnum.SOMIS21STRATEGY.getOmschrijving());
	private Label somIs21StrategyLabel = new Label("mogelijke winst is 5x je inzet");
	private RadioButton hogerDanVorigeStrategyRb = new RadioButton(GokEnum.HOGERDANVORIGESTRATEGY.getOmschrijving());
	private Label hogerDanVorigeStrategyLabel = new Label("mogelijke winst is 10x je inzet");
	private RadioButton hogerDanEenStrategyRb = new RadioButton(GokEnum.HOGERDANEENSTRATEGY.getOmschrijving());
	private Label hogerDanEenStrategyLabel = new Label("mogelijke winst is 2x je inzet");
	private RadioButton somIsMin6StrategyRb = new RadioButton(GokEnum.SOMISMINSTENS6STRATEGY.getOmschrijving());
	private Label somIsMin6StrategyLabel = new Label("mogelijke winst is 2x je inzet");
	private Button bevestigKeuzeButton = new Button("Bevestig je keuze");
	private Button werpDobbelsteenButton = new Button("Werp dobbelsteen");
	private Label worp1 = new Label();
	private Label worp2 = new Label();
	private Label worp3 = new Label();
	private Label worp4 = new Label();
	private Label result = new Label();
		
	public GamblerView(GamblerController controller){
		controller.setView(this);
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

		inzet.setEditable(false);
		startButton.setDisable(true);
		EvenStrategyRb.setDisable(true);
		EvenStrategyLabel.setDisable(true);
		somIs21StrategyRb.setDisable(true);
		somIs21StrategyLabel.setDisable(true);
		hogerDanVorigeStrategyRb.setDisable(true);
		hogerDanVorigeStrategyLabel.setDisable(true);
		hogerDanEenStrategyRb.setDisable(true);
		hogerDanEenStrategyLabel.setDisable(true);
		somIsMin6StrategyRb.setDisable(true);
		somIsMin6StrategyLabel.setDisable(true);
		bevestigKeuzeButton.setDisable(true);
		bevestigKeuzeButton.setDisable(true);
		werpDobbelsteenButton.setDisable(true);
		EvenStrategyRb.setToggleGroup(gokStrategyGroup);
		EvenStrategyRb.setSelected(true);
		somIs21StrategyRb.setToggleGroup(gokStrategyGroup);
		hogerDanVorigeStrategyRb.setToggleGroup(gokStrategyGroup);
		hogerDanEenStrategyRb.setToggleGroup(gokStrategyGroup);
		somIsMin6StrategyRb.setToggleGroup(gokStrategyGroup);
		result.setTextFill(Color.RED);

		pane1.add(spelernaamLabel, 0, 0, 1, 1);
		pane1.add(spelernaam, 1, 0, 1, 1);
		pane1.add(goksaldo, 2, 0, 1, 1);

		pane1.add(inzetLabel, 0, 1, 1, 1);
		pane1.add(inzet, 1, 1, 1, 1);
		pane1.add(startButton, 1, 2, 1, 1);

		pane2.add(gokStrategyLabel, 0, 0, 1, 1);
		pane2.add(EvenStrategyRb, 0, 1, 1, 1);
		pane2.add(EvenStrategyLabel, 1, 1, 1, 1);
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

		startButton.setOnAction(event -> {
			try {
				startButton.setDisable(true);
				bevestigKeuzeButton.setDisable(false);
				EvenStrategyRb.setDisable(false);
				EvenStrategyLabel.setDisable(false);
				somIs21StrategyRb.setDisable(false);
				somIs21StrategyLabel.setDisable(false);
				hogerDanVorigeStrategyRb.setDisable(false);
				hogerDanVorigeStrategyLabel.setDisable(false);
				hogerDanEenStrategyRb.setDisable(false);
				hogerDanEenStrategyLabel.setDisable(false);
				somIsMin6StrategyRb.setDisable(false);
				somIsMin6StrategyLabel.setDisable(false);
				bevestigKeuzeButton.setDisable(false);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		});

		bevestigKeuzeButton.setOnAction(event -> {
			try {
				RadioButton gokStrategyRb = (RadioButton) gokStrategyGroup.getSelectedToggle();
				controller.updateGokStrategy(gokStrategyRb.getText());
				EvenStrategyRb.setDisable(true);
				EvenStrategyLabel.setDisable(true);
				somIs21StrategyRb.setDisable(true);
				somIs21StrategyLabel.setDisable(true);
				hogerDanVorigeStrategyRb.setDisable(true);
				hogerDanVorigeStrategyLabel.setDisable(true);
				hogerDanEenStrategyRb.setDisable(true);
				hogerDanEenStrategyLabel.setDisable(true);
				somIsMin6StrategyRb.setDisable(true);
				somIsMin6StrategyLabel.setDisable(true);
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

	public void displayGoksaldo(int i) {
		goksaldo.setText("Je goksaldo is " + i);
		spelernaam.setEditable(false);
		inzet.setEditable(true);
	}

	public void setEditableInzet(boolean b) {
		inzet.setEditable(b);
	}

	public void setDisableStartButton(boolean b) {
		startButton.setDisable(b);
	}

	public void displayResult(boolean gewonnen, int goksaldo) {
		inzet.setEditable(false);
		werpDobbelsteenButton.setDisable(true);
		if(gewonnen) {
			result.setText("GEFELICITEERD, JE HEBT GEWONNEN\nJe nieuwe goksaldo bedraagt " + goksaldo + " €");
		} else {
			result.setText("HELAAS, JE HEBT NIET GEWONNEN\nJe nieuwe goksaldo bedraagt " + goksaldo + " €");
		}
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
		startButton.setDisable(true);
		EvenStrategyRb.setDisable(true);
		EvenStrategyLabel.setDisable(true);
		somIs21StrategyRb.setDisable(true);
		somIs21StrategyLabel.setDisable(true);
		hogerDanVorigeStrategyRb.setDisable(true);
		hogerDanVorigeStrategyLabel.setDisable(true);
		hogerDanEenStrategyRb.setDisable(true);
		hogerDanEenStrategyLabel.setDisable(true);
		somIsMin6StrategyRb.setDisable(true);
		somIsMin6StrategyLabel.setDisable(true);
		bevestigKeuzeButton.setDisable(true);
		bevestigKeuzeButton.setDisable(true);
		werpDobbelsteenButton.setDisable(true);
		EvenStrategyRb.setSelected(true);
	}
}
