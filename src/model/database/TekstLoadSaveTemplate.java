package model.database;

import model.Speler;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Niels Bijloos
 */

public abstract class TekstLoadSaveTemplate  {

    private String path;
    private File file;
    private ArrayList<Object> list;
    private Scanner fileScanner;
    private Map<String, String> objectValues;
    private Speler objectToAdd;
    private FileWriter writer;

    public TekstLoadSaveTemplate(String path) {
        if(path.isEmpty()) throw new IllegalArgumentException("Path can't be empty");
        this.path = path;
        this.list = new ArrayList<>();
    }

    public final ArrayList<Object> load() {
        loadSetup();
        while(fileScanner.hasNextLine()) {
            Scanner rowScanner = new Scanner(fileScanner.nextLine());
            objectValues = readLine(rowScanner);
            objectToAdd = parseListToObject(objectValues);
            list.add(objectToAdd);
        }
        return list;
    }

    public final void save(ArrayList<Object> list) {
        saveSetup();
        try{
            for(Object o : list) {
                writer.write(convertToString(o));
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract Map<String, String> readLine(Scanner rowScanner);
    protected abstract Speler parseListToObject(Map<String, String> objectValues);
    protected abstract String convertToString(Object o);

    private void loadSetup() {
        file = new File(path);
        try{
            this.fileScanner = new Scanner(file);
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
    }

    private void saveSetup() {
        try {
            file = new File(path);
            file.createNewFile();
            writer = new FileWriter(file);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }


}
