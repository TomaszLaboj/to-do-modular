import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RespositoryConfig {

    @Bean
    public TodoRepository todoRepository(TodoJpaRepository jpaRepository) {
        return new ToDoRepositoryPostgres(jpaRepository);
    }
}
