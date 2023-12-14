
package Proyecto_Web_Patrones.service;

 import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "keji-f6452.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "Keji";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "keji-f6452-firebase-adminsdk-lnsu2-94a2702ddc.json";
}

