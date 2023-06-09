import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.ProductRepository;
import ru.netology.Smartphone;


public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product book1 = new Book(11, "Мастер и Маргарита", 670, "М.А. Булгаков");
    Product book2 = new Book(12, "Великий Гэтсби", 700, "Ф.С. Фицджеральд");
    Product smartphone1 = new Smartphone(111, "Redmi 12C", 16_000, "Xiaomi");
    Product smartphone2 = new Smartphone(112, "Galaxy A14", 18_000, "Samsung");
    Product smartphone3 = new Smartphone(113, "Redmi Note 12", 15_990, "Xiaomi");

    @BeforeEach
    public void setup() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
    }

    @Test
    public void shouldFindAllProducts() {
        Product[] expected = {book1, book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductById() {
        repo.removeById(smartphone1.getId());

        Product[] expected = {book1, book2, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
