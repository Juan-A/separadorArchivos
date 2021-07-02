package separadorArchivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class directorio {
   // private File[] archivos;
    private List<File> archivos = new ArrayList<>();

    public directorio(String ruta){
        archivos = obtenerContenido(ruta);
    }
    private List<File> obtenerContenido(String ruta){
        File dir = new File(ruta);
        for(int i = 0; i < dir.listFiles().length; i++){
            if(!dir.listFiles()[i].isDirectory()){
                archivos.add(dir.listFiles()[i]);
            } else{
                ruta = dir.listFiles()[i].getAbsolutePath();
                obtenerContenido(ruta);
            }
        }

        return archivos;

    }
    public List<File> getLista(){
        return archivos;
    }
    @Override
    public String toString(){
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < archivos.size(); i++){
            stb.append(archivos.get(i).getName()+"\n");
        }
        return stb.toString();
    }

    
}
