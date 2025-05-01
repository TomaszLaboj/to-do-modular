import model.ToDoItem;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/todo")
    public ToDoItemDto createToDoItem(@RequestBody ToDoItemDto toDoItemDto) {
        ToDoItem toDoItem = new ToDoItem(toDoItemDto.getTitle(), toDoItemDto.isDone());
        ToDoItem createdToDoItem = toDoService.save(toDoItem);
        return new ToDoItemDto(createdToDoItem.getId(), createdToDoItem.getTitle(), createdToDoItem.isDone());
    }

    @GetMapping("/todo")
    public List<ToDoItem> getToDoItems() {
        List<ToDoItem> todos = toDoService.getAll();
        List<ToDoItemDto> todosDto = todos.stream().map((todo) -> new ToDoItemDto(todo.getId(), todo.getTitle(), todo.isDone())).collect(Collectors.toList());
        return todos;
    }
}
