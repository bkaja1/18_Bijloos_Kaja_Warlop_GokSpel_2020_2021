package controller;

import model.Spel;
import model.Speler;
import view.AdminView;

public class AdminController implements Observer {
    private AdminView view;

    public AdminController(Spel spel) {
        spel.addObserver(this);
    }

    public void setView(AdminView view) {
        this.view = view;
    }

    @Override
    public void update(Speler speler) {
    }
}
