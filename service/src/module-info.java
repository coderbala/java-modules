module service {
    requires transitive shapes;
    exports com.dn.service.spi to client;
    opens com.dn.service.impl to client;
    provides com.dn.service.spi.SimpleService with com.dn.service.impl.SimpleServiceImpl;
}