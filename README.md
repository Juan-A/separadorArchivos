## Funcionalidad

En esta versión preliminar, mueve los archivos desde un directorio origen (no recursivo) hasta un directorio destino (dados en App.java), depositándolos a su vez en directorios según extensión del archivo.

## Librerías

The workspace contains two folders by default, where:

- `libreriasExternas`: Contiene la libreria Apache Commons, de la que utilizamos `FilenameUtils.getExtension` para obtener las extensiones de un archivo.


