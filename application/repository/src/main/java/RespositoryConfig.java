import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RespositoryConfig {

    @Bean
    public ToDoRepository todoRepository(ToDoJpaRepository jpaRepository) {
        ToDoJpaRepository repository = jpaRepository;
        return new ToDoRepositoryPostgres(repository);
    }
}
