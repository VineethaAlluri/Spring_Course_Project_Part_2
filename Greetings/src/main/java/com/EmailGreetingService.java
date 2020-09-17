import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("greetingService")
public class EmailGreetingService implements GreetingService{
    @Value("${name}")
    public String name;
    @Autowired
    private Test test;

    public String greetUser(String name) {
        return "hello " + name;
    }
}
