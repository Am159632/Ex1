package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for assignments.ex1.Ex1.assignments.ex1.Ex1.
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2","1 3b5"," "};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        int n1=1324;
        int b1=5;
        String num1=Ex1.int2Number(n1,b1);
        String num2=Ex1.int2Number(n1,13);
        assertTrue(Ex1.equals(num1,num2));
        String num3=Ex1.int2Number(1241,5);
        assertFalse(Ex1.equals(num3,num1));
    }
    @Test
    void maxIndexTest() {
        String[] array1 ={"01b5","1b2","1",};
       int max1=Ex1.maxIndex(array1);
        assertEquals(0,max1);
        String[] array2 ={"1F65bG","214134","3431GF",};
        int max2=Ex1.maxIndex(array2);
        assertEquals(1,max2);
        String[] array3 ={"1F65bG","214134","3431GF",};
        int max3=Ex1.maxIndex(array2);
        assertFalse(max1==max3);
        assertTrue(max2==max3);
    }
    @Test
    void baseTest(){
        String[] good = {"0b3","12345","GbF","b2","-2bG","1F","G23 bC",""};
        for(int i=0;i<good.length;i++) {
            int ok = Ex1.base(good[i]);
            assertTrue(ok!=-1);
        }
        String[] not_good = {"-2b12","123b-1","0b1"};
        for(int i=0;i<not_good.length;i=i+1) {
            int not_ok = Ex1.base(not_good[i]);
            assertEquals(not_ok,-1);
        }
        assertEquals(10,Ex1.base("12345"));
    }

}
