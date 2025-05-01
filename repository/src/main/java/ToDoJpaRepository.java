import model.ToDoItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoJpaRepository extends CrudRepository<ToDoItemEntity, Long> {

    List<ToDoItemEntity> findByTitle(String title);

    ToDoItemEntity findById(long id);
}
