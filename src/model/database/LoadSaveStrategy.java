package model.database;

import java.util.ArrayList;

public interface LoadSaveStrategy {

    ArrayList<Object> load();
    void save(ArrayList<Object> spelers);
}
