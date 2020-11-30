package model.database;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public interface LoadSaveStrategy {
    Map load(File file);
    void save(File file, ArrayList<Object> objects);
}
