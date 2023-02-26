
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Error eatMeat",expected,actual);
    }

    @Test
    public void getFamily() throws Exception {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        Assert.assertEquals("Error getFamily",expected, actual);
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 1;
        Assert.assertEquals("Error getKittens", expected,actual);

    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens(3);
        int expected = 3;
        Assert.assertEquals("Error testGetKittens", expected,actual);

    }
}