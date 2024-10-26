package lv.venta.demo;

import lv.venta.demo.model.User;
import lv.venta.demo.repo.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    CommandLineRunner init(IUserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel")
                    .map(name -> new User(name, name.toLowerCase() + "@domain.com"))
                    .forEach(userRepository::save);

            userRepository.findAll().forEach(user ->
                    System.out.printf("User{id=%d, name='%s', email='%s'}%n", user.getId(), user.getName(), user.getEmail())
            );
        };
    }

}
