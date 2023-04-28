import java.io.*;
public class Main {
    public static void listtofile(Person[] listperson)
    {
        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            writer.write("Name                |Subname             |Age");
            writer.append("\n");
            writer.write("--------------------|--------------------|-----------------------");
            writer.write("\n");
            for (int i = 0 ; i < listperson.length; i++)
            {
                writer.write(listperson[i].toArr());
                writer.append("\n");
            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
    public static void main(String[] args)
    {
        Person[] list_person = new Person[3];
        list_person[0] = new Person("notes.txt");
        list_person[1] = new Person("nikita","ruba", 20);
        list_person[2] = new Person("nika","fii", 20);
        listtofile(list_person);
    }
}