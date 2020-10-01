package management;

import java.util.List;

public interface MyManager<T> {
    void add(T o);
    T findByID (int id);
    T findByBrand (String brand);
    T findByName (String name);
    List<T> show();
    boolean isExisted(int id);
}
