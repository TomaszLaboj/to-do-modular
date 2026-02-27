import model.ToDoItem;
import model.ToDoItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ToDoRepositoryPostgres implements ToDoRepository {
    private final ToDoJpaRepository toDoJpaRepository;

    public ToDoRepositoryPostgres(ToDoJpaRepository toDoJpaRepository) {
        this.toDoJpaRepository = toDoJpaRepository;
    }

    @Override
    public ToDoItem findByTitle(String title) {
        ToDoItemEntity toDoItemEntity = toDoJpaRepository.findByTitle(title);
        return new ToDoItem(toDoItemEntity.getId(), toDoItemEntity.getTitle(), toDoItemEntity.isDone());
    }

    @Override
    public ToDoItem save(ToDoItem toDoItem) {
        ToDoItemEntity toDoItemEntity = new ToDoItemEntity(toDoItem.getTitle(), toDoItem.isDone());
        ToDoItemEntity createdItem = toDoJpaRepository.save(toDoItemEntity);
        return new ToDoItem(createdItem.getId(), createdItem.getTitle(), createdItem.isDone());
    }

    @Override
    public List<ToDoItem> getAll() {
        List<ToDoItemEntity> todos = toDoJpaRepository.getAll();
        List<ToDoItem> listToReturn = todos.stream().map((todo) ->
                new ToDoItem(todo.getId(), todo.getTitle(), todo.isDone())).collect(Collectors.toList());
        return listToReturn;
    }

    @Override
    public ToDoItem findById(long id) {
        return null;
    }
}
