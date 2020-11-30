package view;

import controller.GamblerController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Speler;

public class GamblerView {
	private Stage stage = new Stage();
	private VBox vBox = new VBox(8);
	private Label spelernaamLabel = new Label("Wat is je spelernaam?");
	private TextField spelernaam = new TextField();
	private Label gokSaldo = new Label();
	private Label foutboodschap = new Label();
	private Label inzetLabel = new Label("Wat is je inzet?");
	private TextField inzet = new TextField();
		
	public GamblerView(GamblerController controller){
		controller.setView(this);
		stage.setTitle("GAMBLER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();

		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(new Insets(10));
		vBox.getChildren().addAll(spelernaamLabel, spelernaam);
		root.getChildren().addAll(vBox);
		Scene scene = new Scene(root, 600, 600);			
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();
		spelernaam.setOnKeyPressed(e -> {
			if(e.getCode().equals(KeyCode.ENTER)) {
				try{
					controller.updateSpelernaam(spelernaam.getText());
				} catch (Exception exc) {
					vBox.getChildren().add(foutboodschap);
					foutboodschap.setText(exc.getMessage());
				}
			}
		});
		inzet.setOnKeyPressed(e -> {
			if(e.getCode().equals(KeyCode.ENTER)) {
			}
		});
	}

	public void displaySpelernaam(Speler speler) {
		gokSaldo.setText("Je goksaldo is " + speler.getGoksaldo());
		spelernaam.setEditable(false);
		vBox.getChildren().add(gokSaldo);
		vBox.getChildren().add(inzetLabel);
		vBox.getChildren().add(inzet);
	}
}
