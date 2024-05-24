package com.dn.service.spi;

import com.dn.service.impl.SimpleServiceImpl;

public class ServiceFactory {

    public static SimpleService getSimpleService() {
        return new SimpleServiceImpl();
    }
}
