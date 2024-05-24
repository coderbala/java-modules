package com.dn.service.impl;

import com.dn.service.spi.SimpleService;

public class SimpleServiceImpl implements SimpleService {

    private String message = "Hello";

    @Override
    public String sayHello(String name) {
        return String.format("Hello %s. how are you? This is service one", name) ;
    }
}
