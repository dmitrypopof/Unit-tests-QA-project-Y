
import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;


public class CatTest {


    @Test
    public void getSound() {
        Feline predator = Mockito.mock(Feline.class);
        Cat cat = new Cat(predator);
        String expected = "Мяу";
        String actual = cat.getSound();
        Assert.assertEquals("Error getSound",expected,actual);
    }

    @Test
    public void getFood() throws Exception {
        Feline predator = Mockito.mock(Feline.class);
        Cat cat = new Cat(predator);
        Mockito.when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Error getFood",expected,actual);
    }




}