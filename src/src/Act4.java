import java.io.IOException;

public class Act4 {

    public static void main (String[]args) throws IOException{

        Menu menu = new Menu();
        AddressBook AddBook = new AddressBook();

        AddBook.load();

        menu.desplegar();

    }

}

