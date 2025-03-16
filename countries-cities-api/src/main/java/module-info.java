module api{
    requires org.slf4j;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires picketbox;
    requires com.google.gson;
    exports com.jlopez.flow;
    exports com.jlopez.entity.dto;
}