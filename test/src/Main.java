public class Main {
    public static void main(String[] args) {
        ReadFileBinary  readFileBinary = new ReadFileBinary();
        Student student = new Student();
        readFileBinary.writeFile(student);
        readFileBinary.readFile(student);
    }

}
