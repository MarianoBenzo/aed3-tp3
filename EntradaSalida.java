import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class EntradaSalida {
	
    public static void escribirTiempos(List<Long> tiempos, String nombreArchivo) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo);
            pw = new PrintWriter(fichero);
            
            for (Long tiempo : tiempos) {
                pw.println(tiempo);	
			}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }




public static void escribirAciertos(List<Float> tiempos, String nombreArchivo) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo);
            pw = new PrintWriter(fichero);
            
            for (Float tiempo : tiempos) {
                pw.println(tiempo); 
      }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
}
