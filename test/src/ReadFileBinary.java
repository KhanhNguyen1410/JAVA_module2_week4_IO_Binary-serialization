import java.io.*;

public class ReadFileBinary {

    public void writeFile(Student student){
        FileOutputStream f;
        {
            try {
                f = new FileOutputStream("student.txt");
                ObjectOutputStream oStream= new ObjectOutputStream(f);
                oStream.writeObject(student);
                oStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("My name is "+ student.name + ". i'm "+ student.age + " year old");
        }
    }
    public void readFile (Student student){
        student = null;
        try {
            FileInputStream file = new FileInputStream("student.txt");
            ObjectInputStream iStream = new ObjectInputStream(file);
            student = (Student) iStream.readObject();
            System.out.println(student);
            iStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
