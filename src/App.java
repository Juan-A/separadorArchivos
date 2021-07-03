import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

import separadorArchivos.*;

public class App {
    private final static List<archivo> archivos = new ArrayList<>();
    private static List<File> listaArchivos = new ArrayList<>();
    private final static List<String> extensiones = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("No se introdujeron suficientes parámetros");
            return;
        }

        final var ORIGEN = args[0];
        final var DESTINO = args[1];

        // Origen
        listaArchivos = new directorio(ORIGEN).getLista();

        // Destino (compruebo existencia y si no ex. lo creo)
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
