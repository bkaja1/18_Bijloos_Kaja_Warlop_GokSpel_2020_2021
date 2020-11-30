package application;
	
import controller.AdminController;
import controller.GamblerController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Spel;
import view.AdminView;
import view.GamblerView;

public class GokSpelMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		Spel spel = new Spel();
		AdminController adminController = new AdminController(spel);
		AdminView adminView = new AdminView();
		GamblerController gamblerController = new GamblerController(spel);
		GamblerView gamblerView = new GamblerView(gamblerController);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
