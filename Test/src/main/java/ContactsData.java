import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ContactsData {

    List<Contacts> contactsList;

    public void run(){
        contactsList = readContactsCSV_in_memory("contacts.csv");

    }

    private List<Contacts> readContactsCSV_in_memory(String fileName) {
        List<Contacts> contacts = new ArrayList<>();

        try {
            // Creates a FileReader
            FileReader file = new FileReader(fileName);

            // Creates a BufferedReader
            BufferedReader br = new BufferedReader(file);

            //skip column names
            br.readLine();
            String line = null;

            // loop until all lines are read to memory
            while ((line = br.readLine()) != null) {

                //Ignore the double quotes for strings
                //line = line.replaceAll("\"", "");

                // use string.split to populate string array
                String[] attributes = line.split(",");

                //create contacts object
                Contacts contact = createContacts(attributes);
                // adding contact into ArrayList
                contacts.add(contact);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

            // Closes the reader
            br.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return contacts;
    }

    private static Contacts createContacts(String[] metadata){
        int listing_id = Integer.parseInt(metadata[0]);
        int contact_date = Integer.parseInt(metadata[0]);

        return new Contacts(listing_id, contact_date);
    }

    public List<Contacts> getContactsData(){
        return contactsList;
    }
}
