import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianying.wcj on 2015/5/3 0003.
 */
public class TypeTest {
    //类型擦除，使用Type接口可以表达泛型的类型。
    public static void main(String[] args) {
        typeTest02();
    }

    public static void typeTest01() {
        List<Integer> intTestList = new ArrayList<Integer>();
        List<String> strTestList = new ArrayList<String>();
        Type[] a = intTestList.getClass().getGenericInterfaces();
        Type[] b = strTestList.getClass().getGenericInterfaces();
        System.out.println(a.equals(b));
        System.out.println(intTestList.getClass().equals(strTestList.getClass()));
        System.out.println(intTestList.getClass()+" "+strTestList.getClass());
    }

    public static void typeTest02() {
        String[] a = new String[]{};
        if(a instanceof Object[]) {
            System.out.println("bingo");
        } else {
            System.out.println("no correct");
        }
    }
}
