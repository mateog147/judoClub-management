package modelos;

import java.nio.file.Path;

public interface Constantes {
    String ruta_a = Path.of("").toAbsolutePath().toString();
    String RUTA = ruta_a + "/src/appdata/dbclub.db";


}
