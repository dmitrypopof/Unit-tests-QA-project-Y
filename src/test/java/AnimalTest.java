import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalTest {

    @Test
    public void getFood() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        List<String> excepted = List.of("Трава", "Различные растения");
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void getFoodCheckThrow(){
        Exception exception = null;
        try {
            Animal animal = new Animal();
            animal.getFood("Нечто");
        } catch (Exception ex) {
            exception = ex;
        }
        String actual = exception.getMessage();
        String excepted = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void getFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        Assert.assertEquals(expected,actual);
    }
}