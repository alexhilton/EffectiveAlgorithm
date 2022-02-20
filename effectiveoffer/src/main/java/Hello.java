import java.util.Arrays;
import java.util.List;

public class Hello {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("James Bond", "Kevin Durant");
        names.stream().forEach(System.out::println);
    }
}
