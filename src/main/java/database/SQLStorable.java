package database;

public interface SQLStorable {
    String insert(String... args);
    String select(String... args);
    String delete(String... args);
    String update(String... args);
}
