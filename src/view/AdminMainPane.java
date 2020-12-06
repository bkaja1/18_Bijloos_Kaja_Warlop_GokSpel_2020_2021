package view;


import controller.SpelverloopController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.Spel;
import view.panels.GamblerOverviewPane;
import view.panels.SpelverloopPane;

public class AdminMainPane extends BorderPane {
    public AdminMainPane(Spel spel){
        TabPane tabPane = new TabPane();
        SpelverloopController spelverloopController = new SpelverloopController(spel);
        SpelverloopPane spelverloopPane = new SpelverloopPane(spelverloopController);
        Tab spelVerloopTab = new Tab("Spelverloop", spelverloopPane);
        GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane();
        Tab spelerTab = new Tab("Spelers",gamblerOverviewPane);
        Tab instellingTab = new Tab("Instellingen");
        Tab statistiekTab = new Tab("Staitieken");
        tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(spelerTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
    }
}
