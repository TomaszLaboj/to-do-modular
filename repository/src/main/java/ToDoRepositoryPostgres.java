import model.ToDoItem;
import model.ToDoItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoRepositoryPostgres implements ToDoRepository {
    private final ToDoJpaRepository toDoJpaRepository;

    public ToDoRepositoryPostgres(ToDoJpaRepository toDoJpaRepository) {
        this.toDoJpaRepository = toDoJpaRepository;
    }

    @Override
    public List<ToDoItem> findByTitle(String title) {
        return toDoJpaRepository.findByTitle(title);
    }

    @Override
    public ToDoItem save(ToDoItem toDoItem) {
        ToDoItemEntity toDoItemEntity = new ToDoItemEntity(toDoItem.getTitle(), toDoItem.isDone());
        ToDoItemEntity createdItem = toDoJpaRepository.save(toDoItemEntity);
        return new ToDoItem(createdItem.getId(), createdItem.getTitle(), createdItem.isDone());
    }

    @Override
    public ToDoItem findById(long id) {
        return null;
    }
}
