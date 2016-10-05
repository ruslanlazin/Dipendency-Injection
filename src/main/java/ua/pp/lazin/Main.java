package ua.pp.lazin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import ua.pp.lazin.service.ConsoleInputReader;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        ConsoleInputReader consoleInputReader = context.getBean(ConsoleInputReader.class);
        consoleInputReader.readAndGo();
    }
}
