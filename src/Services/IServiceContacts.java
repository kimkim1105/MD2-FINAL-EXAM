package Services;

import java.util.List;

public interface IServiceContacts<T> {
    List<T> findAll();
    void add(T t);
}
