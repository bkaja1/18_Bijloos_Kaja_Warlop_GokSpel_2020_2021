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
    private Scanner scannerNextLine;
    private PrintWriter printWriter;
    private Map<String, Object> objects;

    public TekstLoadSaveTemplate(String path) {
        if(path == null || path.isEmpty()) throw new IllegalArgumentException("Path is ongeldig");
        this.path = path;
        this.objects = new HashMap<>();
    }

    public final Map<String, Object> load() {
        loadStart();
        while(scanner.hasNextLine()) {
            createScannerNextLine();
            scan(scannerNextLine, objects);
            loadClose();
        }
        return objects;
    }

    public final void save(Object object) {
        saveStart();
        println(printWriter, object);
        saveClose();
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

    private void createScannerNextLine() {
        scannerNextLine = new Scanner(scanner.nextLine());
    }

    protected abstract void scan(Scanner scanner, Map<String, Object> objects);

    protected abstract void println(PrintWriter printWriter, Object object);

    private void loadClose() {
        scannerNextLine.close();
    }

    private void saveClose() {
        printWriter.close();
    }
}
