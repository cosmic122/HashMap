import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Menu {

    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void desplegar() throws IOException {

        AddressBook AddBook = new AddressBook();
        int opcion;


            System.out.println("*************************\n\nAgenda Telefónica\n\n*************************\n");
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Mostrar los contactos en la agenda");
            System.out.println("2. Crear un nuevo contacto");
            System.out.println("3. Borrar un contacto");
            System.out.println("4. Guardar cambios");
            System.out.println("5. Terminar programa");
            System.out.println("0. Mostrar el menú ");
            System.out.println("\n");

        while (true) {
            System.out.println("Indique una opción. Presione 0 para mostrar el menú de nuevo. ");

            opcion = Integer.parseInt(entrada.readLine());

            if (opcion < 0 | opcion > 5) {
                System.out.println("Selección inválida. Intente de nuevo");
                continue;
            }


            switch (opcion) {

                case 1:

                    AddBook.list();
                    continue;


                case 2:
                    AddBook.create();
                    continue;


                case 3:
                    AddBook.delete();
                    continue;


                case 4:
                    AddBook.save();
                    continue;


                case 5:
                    break;

                case 0:
                    desplegar();

            }

            break;

        }

    }

}