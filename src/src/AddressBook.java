import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;


public class AddressBook {

    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    String inputFilename = "D:\\Actividad4\\src\\src\\contacts.csv";
    String outputFilename = "D:\\Actividad4\\src\\src\\contacts.csv";

    public static HashMap<String, String> contactMap = new HashMap<>();

    //inicializacion de hashmap
    public HashMap<String, String> load()throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(inputFilename));

        String line;

        while((line = in.readLine()) !=null) {

            String str[] = line.split(", ");
            for(int i=0;i< str.length;i++){
                String arr[] = str[i].split(" : ");
                contactMap.put(arr[0], arr[1]);
            }

        }

    System.out.println("Se ha cargado la información de sus contactos");
    System.out.println("\n");

    return contactMap;

    }

    // metodo para listar las entradas
    public void list() {

        for (Map.Entry<String,String> entry : contactMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + "\t : \t" + value);

        }

    }

    // crear una nueva entrada
    public void create () throws IOException{

        String a, b;

        System.out.println("Introduzca el número del contacto");
        a = entrada.readLine();

        int lngth = a.length();

        if(lngth !=10 || a.isEmpty()) {

            System.out.println("Entrada inválida, intente de nuevo");
            create();
        }

        System.out.println("Introduzca el nombre del usuario");
        b = entrada.readLine();

        contactMap.put(a, b);

        System.out.println("Sus datos han sido guardados!");

    }


    // borrar entrada
    public void delete () throws IOException {

        String toDelete;

        System.out.println("Introduzca el número que desea eliminar:");

        toDelete = entrada.readLine();

        int lngth = toDelete.length();

        if(lngth !=10 || toDelete.isEmpty()) {

            System.out.println("Entrada inválida, intente de nuevo");
            delete();
        }

        if(contactMap.containsKey(toDelete)){
            contactMap.remove(toDelete);
            System.out.println("El contacto con número " + toDelete + " ha sido eliminado.");

        }

        else {
            System.out.println("Número no encontrado, intente de nuevo.");
            delete();
        }

    }

    File file = new File(outputFilename);

    BufferedWriter bf = null;

    // guardar a archivo
    public void save() throws IOException{

        bf = new BufferedWriter(new FileWriter(file));

        for (Map.Entry<String,String> entry : contactMap.entrySet()) {

            try {

                String key = entry.getKey();
                String value = entry.getValue();

                bf.write(key + " : " + value + ", ");



            } catch (IOException e) {
                System.out.println("Ha ocurrido un error.");
            }

        }

        bf.flush();

        System.out.println("Sus datos han sido guardados!");

    }

}
