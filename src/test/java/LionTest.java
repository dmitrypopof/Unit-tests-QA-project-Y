import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean EXPECTED_DOES_HAVE_MANE;
    private final int KITTENS_VALUE;

    public LionTest(String sex, boolean expectedDoesHaveMane, int kittensValue) {
        this.sex = sex;
        EXPECTED_DOES_HAVE_MANE = expectedDoesHaveMane;
        KITTENS_VALUE = kittensValue;
    }

    @Parameterized.Parameters
    public static Object[][] getInput(){
        return new Object[][]{
                {"Самец", true,1},
                {"Самка", false,2}
        };
    }
    @Test
    public void testLionCheckSex() throws Exception {
        Lion lion = new Lion(sex);
        boolean actual = lion.doesHaveMane();
        boolean expected = EXPECTED_DOES_HAVE_MANE;
        Assert.assertEquals("Error testLionMale", expected,actual);
    }


    @Test
    public void testLionCheckThrow() {
        Exception exception = null;
        try {
            Lion lion = new Lion("Нечто");
        } catch (Exception ex) {
            exception = ex;
        }
        String actual = exception.getMessage();
        String excepted = "Используйте допустимые значения пола животного - самец или самка";
        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void getKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion (sex,feline);
        Mockito.when(feline.getKittens()).thenReturn(KITTENS_VALUE);
        int excepted = KITTENS_VALUE;
        int actual = lion.getKittens();
        Assert.assertEquals("Error getKittens",excepted,actual);
    }

    @Test
    public void getFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex,feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> excepted = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        Assert.assertEquals("Error getFood",excepted,actual);
    }


}