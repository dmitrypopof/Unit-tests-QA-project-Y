import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean EXPECTED_DOES_HAVE_MANE;
    private final int KITTENS_VALUE;
    private final String sexThrow;

    public LionTest(String sex, boolean expectedDoesHaveMane, int kittensValue, String sexThrow) {
        this.sex = sex;
        this.EXPECTED_DOES_HAVE_MANE = expectedDoesHaveMane;
        this.KITTENS_VALUE = kittensValue;
        this.sexThrow = sexThrow;

    }

    @Parameterized.Parameters
    public static Object[][] getInput(){
        return new Object[][]{
                {"Самец", true,1,null},
                {"Самка", false,2,"Нечто"}
        };
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testLionCheckSex() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex,feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals("Error testLionMale", EXPECTED_DOES_HAVE_MANE,actual);
    }

    @Test
    public void testLionCheckThrow() {
        Feline feline = Mockito.mock(Feline.class);
        Exception exception = null;
        try {
            Lion lion = new Lion(sexThrow,feline);
        } catch (Exception ex) {
            exception = ex;
        }

        String actual = exception != null ? exception.getMessage() : null;
        String excepted = "Используйте допустимые значения пола животного - самец или самка";
        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void getKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion (sex,feline);
        Mockito.when(feline.getKittens()).thenReturn(KITTENS_VALUE);
        int actual = lion.getKittens();
        Assert.assertEquals("Error getKittens",KITTENS_VALUE,actual);
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