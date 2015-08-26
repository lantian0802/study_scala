package serviceloader;

import java.util.ServiceLoader;

/**
 * Created by jianying.wcj on 2015/8/26 0026.
 */
public class Driver {
    public static void main(String[] args) {
        ServiceLoader<IService> serviceLoader  = ServiceLoader.load(IService.class);
        for (IService service : serviceLoader) {
            System.out.println(service.getSchema()+"="+service.sayHello());
        }
    }
}
