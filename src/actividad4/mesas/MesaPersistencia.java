package actividad4.mesas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MesaPersistencia {
    private String pathfile;

    public MesaPersistencia(String pathfile) {
        this.pathfile = pathfile;
    }

    public void guardarMesa(Mesa mesa) throws IOException {
        List<Mesa> mesas = obtenerMesas();
        mesas.add(mesa);
      
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathfile))) {
          out.writeObject(mesas);
        } catch (IOException e) {
          
          System.out.println("Error saving tables to file: " + e.getMessage());
         
        }
      }
    
    @SuppressWarnings("unchecked") //QuickFix
    public List<Mesa> obtenerMesas() {
        List<Mesa> mesas = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(pathfile))) {

            /*

            For large objects or complex object graphs, 
            deserializing objects can be time-consuming. The readObject() method optimizes the process by leveraging 
            he serialization protocol and utilizing efficient data structures for object reconstruction.

            The readObject() method in Java is a higher-level mechanism for deserializing objects from a stream of bytes. 
            It utilizes the serialization protocol and underlying byte reading to reconstruct objects efficiently. While it
            doesn't directly read bytes, it relies on the input stream to access the serialized data. */



            mesas = (List<Mesa>) in.readObject(); //    
        } catch (FileNotFoundException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mesas;
    }
}