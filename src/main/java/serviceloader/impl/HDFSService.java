package serviceloader.impl;

import serviceloader.IService;

/**
 * Created by jianying.wcj on 2015/8/26 0026.
 */
public class HDFSService implements IService {
    @Override
    public String sayHello() {
        return "hdfs say hello";
    }

    @Override
    public String getSchema() {
        return "hdfs";
    }
}
