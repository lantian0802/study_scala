/**
 * Created by jianying.wcj on 2015/5/3 0003.
 */
public class Outter {

    public class Inner{}

    public void foo(Inner c) {
        System.out.println(c);
    }

    public static void main(String[] args) throws Exception {
        Outter o1 = new Outter();
        Outter o2 = new Outter();
        Outter.Inner i1 = o1.new Inner();
        Outter.Inner i2 = o2.new Inner();
        o1.foo(i2);
    }
}
