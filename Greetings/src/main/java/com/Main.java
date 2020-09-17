import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main{
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        EmailGreetingService service = (EmailGreetingService) context.getBean("greetingService");
        System.out.println(service.greetUser("Vineetha"));
        System.out.println(service.name);
    }
}
