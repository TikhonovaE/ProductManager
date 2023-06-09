import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(11, "Мастер и Маргарита", 670, "М.А. Булгаков");
    Product book2 = new Book(12, "Великий Гэтсби", 700, "Ф.С. Фицджеральд");
    Product smartphone1 = new Smartphone(111, "Redmi 12C", 16_000, "Xiaomi");
    Product smartphone2 = new Smartphone(112, "Galaxy A14", 18_000, "Samsung");
    Product smartphone3 = new Smartphone(113, "Redmi Note 12", 15_990, "Xiaomi");


    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldReturnTrueIfMatches() {
        Assertions.assertEquals(true, manager.matches(book1, "Мастер"));
    }

    @Test
    public void shouldReturnFalseIfDoesNotMatch() {
        Assertions.assertEquals(false, manager.matches(smartphone2, "Мастер"));
    }


}
