package separadorArchivos;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class archivo {

    private String origen;
    private String destino;

    public archivo(String origen) {
        this.origen = origen;

    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void mover() {
        Path origenPath = FileSystems.getDefault().getPath(origen);
        Path destinoPath = FileSystems.getDefault().getPath(destino);

        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void copiar() {
        Path origenPath = FileSystems.getDefault().getPath(origen);
        Path destinoPath = FileSystems.getDefault().getPath(destino);

        try {
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public String toString() {
        return this.origen;
    }
}
