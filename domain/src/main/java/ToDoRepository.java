
import model.ToDoItem;

import java.util.List;

public interface ToDoRepository {

    List<ToDoItem> findByTitle(String title);
    ToDoItem save(ToDoItem toDoItem);
    ToDoItem findById(long id);
}