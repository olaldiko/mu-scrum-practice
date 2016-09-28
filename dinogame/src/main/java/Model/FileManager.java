package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.security.Principal;
import java.util.stream.Collectors;

/**
 * Created by urko on 26/09/16.
 */
public class FileManager {

    public static ObservableList<Puntuacion> readFile() {
        ObservableList<Puntuacion> ranking = FXCollections.observableArrayList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Principal.class.getResource("/ranking.dat").getFile()));
            String line;
            while ((line = br.readLine()) != null) {
                String [] lines = line.split(";");
                Puntuacion p = new Puntuacion();
                p.nombre.set(lines[0]);
                p.score.set(Integer.parseInt(lines[1]));
                ranking.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creara al finalizar el programa");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ranking;
    }

    public static void writeFile(ObservableList<Puntuacion> ranking) {
        try {
            File file = new File(Principal.class.getResource("/ranking.dat").getFile());
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < 5 || i < ranking.size(); i++) {
                bw.write(ranking.get(i).nombre.get() + ";" + ranking.get(i).score.get() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Puntuacion> sortPuntuacion(ObservableList<Puntuacion> ranking) {
        return ranking.stream()
                .sorted()
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
    }



}
