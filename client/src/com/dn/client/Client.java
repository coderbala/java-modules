package com.dn.client;

import com.dn.service.spi.AreaService;
import com.dn.service.spi.ServiceFactory;
import com.dn.service.spi.SimpleService;
import com.dn.shapes.Square;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

public class Client {

    public static void main(String[] args) {

        String name = "Java 9";

        //Restriction of accessing Impl class. Accessing with factory.
        SimpleService simpleService = ServiceFactory.getSimpleService();
        String output = simpleService.sayHello(name);
        System.out.println(output);

        // Example of using opens
        String message = getMessage(simpleService);
        System.out.println("Message using reflection is:" + message);

        // Demonstration of provides, with and uses
        ServiceLoader<SimpleService> serviceLoader = ServiceLoader.load(SimpleService.class);
        serviceLoader.forEach(service -> System.out.println(service.sayHello(name)));

        // Transitive example
        int area = AreaService.getArea(new Square());
        System.out.println("Area of a sqaure is " + area);

    }

    private static String getMessage(SimpleService simpleService) {
        try {
            Class<?> myClass = simpleService.getClass();
            Field secretField = myClass.getDeclaredField("message");
            secretField.setAccessible(true);
            return  (String) secretField.get(simpleService);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
