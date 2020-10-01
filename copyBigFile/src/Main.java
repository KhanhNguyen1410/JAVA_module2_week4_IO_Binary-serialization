import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {

    private static void copyFileUsingJava7File(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void  copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read()) > 0){
                os.write(buffer,0,length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            is.close();
            os.close();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter source file");
        String sourcePath = sc.nextLine();
        System.out.println("Enter dest file");
        String destPath = sc.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingJava7File(sourceFile,destFile);
            System.out.println("copy completed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

