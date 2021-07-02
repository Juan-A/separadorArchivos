import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

import separadorArchivos.*;

public class App {
    private static List<archivo> archivos = new ArrayList<>();
    private static List<File> listaArchivos = new ArrayList<>();
    private static List<String> extensiones = new ArrayList<>();
    private final static String DESTINO = "F://testeando//";
    private final static String ORIGEN = "F://Software//";

    public static void main(String[] args) throws Exception {
        // Origen
        listaArchivos = new directorio(ORIGEN).getLista();

        // Destino (chequeo existencia y si no ex. lo creo)
        File destino = new File(DESTINO);
        if (!destino.exists()) {
            System.out.println("El directorio destino será creado.");
            destino.mkdir();
        }
        //
        for (int i = 0; i < listaArchivos.size(); i++) {
            archivo archTemp = new archivo(listaArchivos.get(i).getAbsolutePath());
            archivos.add(archTemp);
        }
        Scanner entrada = new Scanner(System.in);
        System.out.println("Son en total " + archivos.size() + " archivos; ¿Continuar? (Y/N):");
        String respuesta = entrada.nextLine();
        entrada.close();
        if (new String("Y").equals(respuesta) || new String("y").equals(respuesta)) {
            for (int i = 0; i < archivos.size(); i++) {
                // Elemento por elemento, examino su extensión
                String ext = FilenameUtils.getExtension(listaArchivos.get(i).getName());
                if (!extensiones.contains(ext)) {
                    extensiones.add(ext);

                    File extDestino = new File(DESTINO + "//" + ext);
                    if (!extDestino.mkdir()) {
                        System.out.println("El directorio de la extensión ya existía.");
                    }
                }
                String nombre = DESTINO + "//" + ext + "//" + listaArchivos.get(i).getName();
                archivos.get(i).setDestino(nombre);
                archivos.get(i).mover();
                // archivos.get(i).copy();
            }
        }

    }
}
