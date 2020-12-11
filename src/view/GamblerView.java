package view;

import controller.GamblerController;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
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
	private GridPane pane1 = new GridPane();
	private GridPane pane2 = new GridPane();
	private GridPane pane3 = new GridPane();
	private Label spelernaamLabel = new Label("Wat is je spelernaam?");
	private TextField spelernaam = new TextField();
	private Label goksaldo = new Label();
	private Label inzetLabel = new Label("Wat is je inzet?");
	private TextField inzet = new TextField();
	private Button startButton = new Button("Start");
	private final ToggleGroup gokStrategyGroup = new ToggleGroup();
	private Label gokStrategyLabel = new Label("Kies je gok strategie uit onderstaande lijst");
	private RadioButton alleWorpenEvenStrategyRb = new RadioButton(GokEnum.ALLEWORPENEVENSTRATEGY.getOmschrijving());
	private Label alleWorpenEvenStrategyLabel = new Label("mogelijke winst is 4x je inzet");
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
		pane1.add(spelernaamLabel, 0, 0, 1, 1);
		pane1.add(spelernaam, 1, 0, 1, 1);
		pane2.setPadding(new Insets(200, 5, 5, 5));
		pane2.setVgap(5);
		pane2.setHgap(5);
		pane3.setPadding(new Insets(400, 5, 5, 5));
		pane2.setVgap(5);
		pane2.setHgap(5);
		alleWorpenEvenStrategyRb.setToggleGroup(gokStrategyGroup);
		alleWorpenEvenStrategyRb.setSelected(true);
		somIs21StrategyRb.setToggleGroup(gokStrategyGroup);
		hogerDanVorigeStrategyRb.setToggleGroup(gokStrategyGroup);
		hogerDanEenStrategyRb.setToggleGroup(gokStrategyGroup);
		somIsMin6StrategyRb.setToggleGroup(gokStrategyGroup);

		root.getChildren().addAll(pane1, pane2, pane3);
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
			if(event.getCode().equals(KeyCode.ENTER)) {
				try {
					controller.updateInzet(inzet.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});

		startButton.setOnAction(event -> {
			pane2.add(gokStrategyLabel, 0, 0, 1, 1);
			pane2.add(alleWorpenEvenStrategyRb, 0, 1, 1, 1);
			pane2.add(alleWorpenEvenStrategyLabel, 1, 1, 1, 1);
			pane2.add(somIs21StrategyRb, 0, 2, 1, 1);
			pane2.add(somIs21StrategyLabel, 1, 2, 1, 1);
			pane2.add(hogerDanVorigeStrategyRb, 0, 3, 1, 1);
			pane2.add(hogerDanVorigeStrategyLabel, 1, 3, 1, 1);
			pane2.add(hogerDanEenStrategyRb, 0,4,1,1);
			pane2.add(hogerDanEenStrategyLabel, 1,4,1,1);
			pane2.add(somIsMin6StrategyRb, 0,5,1,1);
			pane2.add(somIsMin6StrategyLabel, 1,5,1,1);
			pane2.add(bevestigKeuzeButton, 0, 6, 1, 1);
		});

		bevestigKeuzeButton.setOnAction(event -> {
			RadioButton gokStrategyRb = (RadioButton) gokStrategyGroup.getSelectedToggle();
			controller.updateGokStrategy(gokStrategyRb.getText());
			alleWorpenEvenStrategyRb.setDisable(true);
			alleWorpenEvenStrategyLabel.setDisable(true);
			somIs21StrategyRb.setDisable(true);
			somIs21StrategyLabel.setDisable(true);
			hogerDanVorigeStrategyRb.setDisable(true);
			hogerDanVorigeStrategyLabel.setDisable(true);
			hogerDanEenStrategyRb.setDisable(true);
			hogerDanEenStrategyLabel.setDisable(true);
			somIsMin6StrategyRb.setDisable(true);
			somIsMin6StrategyLabel.setDisable(true);
			bevestigKeuzeButton.setDisable(true);
			pane3.add(werpDobbelsteenButton, 0, 0, 1, 1);
		});
	}

	public void displayGoksaldo(int i) {
		pane1.getChildren().remove(goksaldo);
		pane1.getChildren().remove(inzetLabel);
		pane1.getChildren().remove(inzet);
		spelernaam.setEditable(false);
		goksaldo.setText("Je goksaldo is " + i);
		pane1.add(goksaldo, 2, 0, 1, 1);
		pane1.add(inzetLabel, 0, 1, 1, 1);
		pane1.add(inzet, 1, 1, 1 ,1);
	}

	public void displayStart() {
		pane1.getChildren().remove(startButton);
		inzet.setEditable(false);
		pane1.add(startButton, 0, 2, 1, 1);
	}
}
