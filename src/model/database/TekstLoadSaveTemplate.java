package model.database;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Niels Bijloos
 */

public abstract class TekstLoadSaveTemplate  {
    private String path;
    private File file;
    private FileWriter fileWriter;
    private Scanner scanner;
    private PrintWriter printWriter;
    protected Map<String, Object> objects;

    public TekstLoadSaveTemplate(String path) {
        if(path == null || path.isEmpty()) throw new IllegalArgumentException("Path is ongeldig");
        this.path = path;
        this.objects = new HashMap<>();
    }

    public final Map<String, Object> load() {
        loadStart();
        scan(scanner);
        return objects;
    }

    public final void save(Object object) {
        saveStart();
        println(printWriter, object);
    }

    private void loadStart() {
        try{
            this.file = new File(path);
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
    }

    private void saveStart() {
        try {
            this.fileWriter = new FileWriter(path, true);
            this.printWriter = new PrintWriter(fileWriter);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    protected abstract void scan(Scanner scanner);

    protected abstract void println(PrintWriter printWriter, Object object);
}
