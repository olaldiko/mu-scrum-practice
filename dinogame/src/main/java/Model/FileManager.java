package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.stream.Collectors;

/**
 * Created by urko on 26/09/16.
 */
public class FileManager {

    public static ObservableList<Puntuacion> readFile() {
        ObservableList<Puntuacion> ranking = FXCollections.observableArrayList();
        File file = new File("ranking.dat");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String [] lines = line.split(";");
                Puntuacion p = new Puntuacion();
                p.nombre.set(lines[0]);
                p.score.set(Integer.parseInt(lines[1]));
                ranking.add(p);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Archivo no encontrado, se creara al finalizar el programa");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ranking;
    }

    public static void writeFile(ObservableList<Puntuacion> ranking) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        File file = new File("ranking.dat");
        if (ranking.size() > 0) {
            try {
                if (!file.isFile()) {
                    file.createNewFile();
                }
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                ranking = ranking.sorted();
                for (int i = (ranking.size() - 1); i >= (ranking.size() - 5) && i >= 0; i--) {
                    bw.write(ranking.get(i).nombre.get() + ";" + ranking.get(i).score.get() + "\n");
                }
                bw.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static ObservableList<Puntuacion> sortPuntuacion(ObservableList<Puntuacion> ranking) {
        return ranking.stream()
                .sorted()
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
    }



}
