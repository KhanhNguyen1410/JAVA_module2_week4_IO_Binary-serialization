package management;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManager implements MyManager<Product>{
    static List<Product> products ;
    static {
        products = new ArrayList<>();
        products.add(new Product(1,"Coca","cocaCola",50));
        products.add(new Product(2,"twist","cocaCola",30));
        products.add(new Product(3,"Cafe","nest",20));
        products.add(new Product(4,"fanTa","pepsi",40));
        products.add(new Product(5,"pepsi","pepsi",60));
    }

    @Override
    public void add(Product o) {
            if (!isExisted(o.getId())){
                products.add(o);
            }
        System.out.println("product with ID is existed");
    }

    @Override
    public Product findByID(int id) {
        if (isExisted(id)){
            for (int i = 0; i < products.size(); i++) {
                if (id == products.get(i).getId()){
                    return products.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public Product findByBrand(String brand) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public List<Product> show() {
        List<Product> productList = new ArrayList<>();
        Iterator iterator = products.iterator();
        while (iterator.hasNext()){
            productList.add((Product) iterator.next());
        }
        return productList;
    }

    @Override
    public boolean isExisted(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()){
                return true;
            }
        }
        return  false;
    }
}
