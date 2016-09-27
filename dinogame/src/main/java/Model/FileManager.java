package Model;

import java.io.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by urko on 26/09/16.
 */
public class FileManager {

    public static ArrayList<Puntuacion> readFile() {
        ArrayList<Puntuacion> ranking = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Principal.class.getResource("/ranking.dat").getFile()));
            String line;
            while ((line = br.readLine()) != null) {
                String [] lines = line.split(";");
                Puntuacion p = new Puntuacion();
                p.nombre.set(lines[0]);
                p.puntuacion.set(Integer.parseInt(lines[1]));
                ranking.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creara al finalizar el programa");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ranking;
    }

    public static void writeFile(ArrayList<Puntuacion> ranking) {
        try {
            File file = new File(Principal.class.getResource("/ranking.dat").getFile());
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < 5 || i < ranking.size(); i++) {
                bw.write(ranking.get(i).nombre.get() + ";" + ranking.get(i).puntuacion.get() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Puntuacion> shortPuntuacion(ArrayList<Puntuacion> p) {
        Collections.sort(p, new Comparator<Puntuacion>() {
            @Override
            public int compare(Puntuacion o1, Puntuacion o2) {
                if (o1.puntuacion.get() > o2.puntuacion.get()) {
                    return -1;
                } else if (o1.puntuacion.get() == o2.puntuacion.get()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        return p;
    }

}
