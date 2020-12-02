package view;

import controller.GamblerController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Speler;

import javax.swing.*;

public class GamblerView {
	private Stage stage = new Stage();
	private GridPane pane1 = new GridPane();
	private Label spelernaamLabel = new Label("Wat is je spelernaam?");
	private TextField spelernaam = new TextField();
	private Label goksaldo = new Label();
	private Label inzetLabel = new Label("Wat is je inzet?");
	private TextField inzet = new TextField();
	private Button startButton = new Button("Start");
		
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

		root.getChildren().addAll(pane1);
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
					controller.updateInzet(spelernaam.getText(), inzet.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	public void displaySpelernaam(Object object) {
		Speler speler = (Speler)object;
		spelernaam.setEditable(false);
		goksaldo.setText("Je goksaldo is " + speler.getGoksaldo());
		pane1.add(goksaldo, 2, 0, 1, 1);
		pane1.add(inzetLabel, 0, 1, 1, 1);
		pane1.add(inzet, 1, 1, 1 ,1);
	}

	public void displayInzet() {
		inzet.setEditable(false);
		pane1.add(startButton, 0, 2, 1, 1);
	}
}
