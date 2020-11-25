package model.database;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Niels Bijloos
 */

public abstract class TekstLoadSaveTemplate<K, V> {
    public final Map<K, V> load(File file) {
        Map<K, V> returnMap = new HashMap<K, V>();
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                V element = maakObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key, element);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return returnMap;
    }

    protected abstract V maakObject(String[] tokens);

    protected abstract K getKey(String[] tokens);
}
