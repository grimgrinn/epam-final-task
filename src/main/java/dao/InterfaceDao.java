package dao;

import java.util.List;

/**
 * Created by Admin on 08.08.2016.
 */
public interface InterfaceDao<T> {
    List<T> get();
    T getById (final int id);
    T create (final T item);
    void update(final T item);
    void delete(final int id);
}
