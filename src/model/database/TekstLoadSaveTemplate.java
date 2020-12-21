package model.database;

import java.io.*;
import java.util.*;

/**
 * @Author Niels Bijloos
 */

public abstract class TekstLoadSaveTemplate<K, V> {
    public final Map<K, V> load(File file) {
        Map<K, V> returnMap = new LinkedHashMap<K, V>();
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                V element = maakObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key, element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnMap;
    }

    public final void save(File file, ArrayList<Object> objects) {
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for(Object object : objects) {
                printWriter.println(objectToString(object));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract V maakObject(String[] tokens);

    protected abstract K getKey(String[] tokens);

    protected abstract String objectToString(Object object);
}
