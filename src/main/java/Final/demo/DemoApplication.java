package Final.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // .headless(false) é o que faz a janela aparecer
        new SpringApplicationBuilder(DemoApplication.class)
            .headless(false) 
            .run(args);
    }

    // Isso aqui diz: "Spring, quando terminar de subir, abra o Menu"
    @Bean
    public CommandLineRunner commandLineRunner(MenuPrincipal menu) {
        return args -> {
            menu.setVisible(true);
        };
    }
}