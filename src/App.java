import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.io.FilenameUtils;

import separadorArchivos.*;

public class App {
    private static List<archivo> archivos = new ArrayList<>();
    private static List<String> extensiones = new ArrayList<>();
    private static String DESTINO = "F://testeando";
    private static String ORIGEN = "F://justatest//Crucero 2018//";
    public static void main(String[] args) throws Exception {
        //Origen
        directorio dir = new directorio(ORIGEN);
        
        System.out.println(dir.getLista().length);
        System.out.println(dir.toString());

        //Añado todos los archivos del directorio origen a una lista.
        for(int i =0; i < dir.getLista().length; i++){
            archivo arch = new archivo(dir.getLista()[i].getAbsolutePath());
            archivos.add(arch);
        }

        //Chequeo la existencia y creo el directorio destino raíz.
        File destino = new File(DESTINO);
             if(!destino.exists()){
                System.out.println("El directorio destino será creado.");
                 destino.mkdir();
             }
        
        for(int i = 0; i < archivos.size(); i++){
            //Elemento por elemento, examino su extensión
            String ext = FilenameUtils.getExtension(dir.getLista()[i].getName());
            
            //Existe la extension? -> Si no está contenida, creo su directorio destino.
            if(!extensiones.contains(ext)){
                extensiones.add(ext);

                File extDestino = new File(DESTINO+"//"+ext);
                if(!extDestino.mkdir()){
                    System.out.println("El directorio de la extensión ya existía.");
                }
            }
            String nombre = DESTINO+"//"+ext+"//"+dir.getLista()[i].getName();
            archivos.get(i).setDestino(nombre);
            archivos.get(i).mover();
            
        }

    }
}
