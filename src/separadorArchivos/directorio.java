package separadorArchivos;

import java.io.File;


public class directorio {
    private File[] archivos;

    public directorio(String ruta){
        archivos = obtenerContenido(ruta);
    }
    private File[] obtenerContenido(String ruta){
        File dir = new File(ruta);
        return dir.listFiles();
    }
    public File[] getLista(){
        return archivos;
    }
    @Override
    public String toString(){
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < archivos.length; i++){
            stb.append(archivos[i].getName()+"\n");
        }
        return stb.toString();
    }

    
}
