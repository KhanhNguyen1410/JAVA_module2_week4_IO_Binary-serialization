import management.ProductManager;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    private static void  display(List list){
        Iterator<Product> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    public static void main(String[] args) throws IOException {
        ProductManager productManager = new ProductManager();
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        Product newPro = new Product(6,"ok","ss",84);
        productManager.add(newPro);

        products = productManager.show();
        display(products);
        File file = new File("product.dat");
        if (file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        InputStream fis = new FileInputStream("product.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);


        products = productManager.show();
        oos.writeObject(products);
        oos.close();
        try {
          products = (ArrayList) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(products );


//        while ((i = fis.read(bytes)) != -1){
//            String s = new String(bytes, 0, i);
//            System.out.print(s);
//        }
//        fis.close();




    }
}
