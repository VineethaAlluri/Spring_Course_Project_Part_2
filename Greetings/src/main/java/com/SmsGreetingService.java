public class SmsGreetingService implements GreetingService{
    public String greetUser(String name) {
        return "hello " + name;
    }
}
