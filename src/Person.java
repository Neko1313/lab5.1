import java.io.*;
public class Person {
    String name;
    String surname;
    Integer age;
    Person(String n, String s, Integer a)
    {
        name = n;
        surname = s;
        age = a;
    }

    Person(String filename)
    {
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            String[] ary = line.split(",");
            name = ary[0];
            surname = ary[1];
            age = Integer.parseInt(ary[2]);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString()
    {
        return "" + name + "," + surname + "," + age;
    }

    public  String toArr()
    {
        String n = name;
        if(name.length() != 20)
        {
            for(int i = 0 ; i < 20-name.length(); i++)
            {
                n = n + " ";
            }
        }
        String s = surname;
        if(surname.length() != 20)
        {
            for(int i = 0 ; i < 20-surname.length(); i++)
            {
                s = s + " ";
            }
        }
        String a = Integer.toString(age);
        if(a.length() != 20)
        {
            for(int i = 0 ; i < 20-Integer.toString(age).length(); i++)
            {
                a = a + " ";
            }
        }
        return  n + "|" + s + "|" + a;
    }

    void WriteFile()
    {
        try(FileWriter writer = new FileWriter("notes.txt", true))
        {
            writer.write(toString());
            writer.append('\n');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
