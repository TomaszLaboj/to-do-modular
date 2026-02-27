import model.ToDoItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private ToDoRepository repository;

    public ToDoItem save(ToDoItem toDoItem) {
        return repository.save(toDoItem);
    }

    public List<ToDoItem> getAll() {
        return repository.getAll();
    }
}
