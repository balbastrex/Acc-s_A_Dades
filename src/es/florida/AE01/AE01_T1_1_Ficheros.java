package es.florida.AE01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AE01_T1_1_Ficheros {
	
	static void getInformacio(String[] args) {
		File fitxer = new File(args[0]);
		System.out.println("Nombre del archivo: " + fitxer.getName());	
		long modified = fitxer.lastModified();
		String datePattern = "dd-MM-yyyy hh:mm";
		SimpleDateFormat pattern = new SimpleDateFormat(datePattern);
		Date mDate = new Date(modified);
		System.out.println("Ultima modificació del fitxer: " + pattern.format(mDate));
		System.out.println("Fitxer ocult: " + fitxer.isHidden());
		
		
		if (fitxer.isDirectory()) {
			
			File[] listaArxius = fitxer.listFiles();
			System.out.println(fitxer + " is a directory");
			int j = 0;
			for (int i = 0; i<listaArxius.length; i++) {
				j++;
			}
			
			long espaiTotal = fitxer.getTotalSpace();
			long espaiLliure = fitxer.getFreeSpace();
			long espaiOcupat = espaiTotal - espaiLliure;
			System.out.println("Hi ha " + j + " elements al directori.");
			System.out.println("Tamany del directori: " + espaiTotal + " bytes.");
			System.out.println("Espai lliure al directori: " + espaiLliure + " bytes.");
			System.out.println("Espai ocupat al directori: " + espaiOcupat + " bytes.");
		}else if (fitxer.isFile()){
					System.out.println("Tipo d'arxiu: File");
					System.out.println("Tamany de l'arxiu en bytes: " + fitxer.length());
				} 
		
		
		
		System.out.println("Ruta absoluta: " + fitxer.getAbsolutePath());
	}
	

	static void creaCarpeta() {
		File directorio = new File("mainDirectory/newDirectory");
		try { 
			directorio.mkdir();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void creaFitxer() {
		File fichero = new File("mainDirectory/newFile.txt");
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void elimina() {
		
		try {
			File removeFile = new File("mainDirectory/removeFile");
			removeFile.delete();
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	static void renomena() {
		Path original = Paths.get("mainDirectory/originalFile.txt");
		Path renomenat = Paths.get("mainDirectory/renamedFile.txt");

		  try{

		    Files.move(original, renomenat);

		  } catch (IOException e) {
		    e.printStackTrace();
		  }
	}
	
	public static void main(String[] args) {
		getInformacio(args);
		creaFitxer();
		creaCarpeta();
		elimina();
		renomena();
	}
}
