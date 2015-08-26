package serviceloader.impl;

import serviceloader.IService;

/**
 * Created by jianying.wcj on 2015/8/26 0026.
 */
public class LocalService implements IService {
    public LocalService() {
        super();
    }

    @Override
    public String sayHello() {
        return "local say hello";
    }

    @Override
    public String getSchema() {
        return "local fs";
    }
}
