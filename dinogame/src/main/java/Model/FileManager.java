package Model;

import java.io.*;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by urko on 26/09/16.
 */
public class FileManager {

    public static Map<String, Integer> readFile() {
        Map<String, Integer> ranking = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Principal.class.getResource("/ranking.dat").getFile()));
            String line;
            while ((line = br.readLine()) != null) {
                String [] lines = line.split(";");
                ranking.put(lines[0], Integer.parseInt(lines[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creara al finalizar el programa");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ranking;
    }

    public static void writeFile(Map<String, Integer> ranking) {
        ranking = ranking.entrySet()
                         .stream()
                         .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                         .collect(Collectors.toMap(
                                 Map.Entry::getKey,
                                 Map.Entry::getValue,
                                 (e1, e2) -> e1,
                                 LinkedHashMap::new
                         ));
        Iterator it = ranking.entrySet().iterator();
        try {
            File file = new File(Principal.class.getResource("/ranking.dat").getFile());
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            int i = 0;
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                bw.write(pair.getKey() + ";" + pair.getValue() + "\n");
                it.remove();
                i++;
                if (i >= 5) break;
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
