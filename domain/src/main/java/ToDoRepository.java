
import model.ToDoItem;

import java.util.List;

public interface ToDoRepository {

    List<ToDoItem> findByTitle(String title);
    ToDoItem save(ToDoItem toDoItem);
    List<ToDoItem> getAll();
    ToDoItem findById(long id);
}