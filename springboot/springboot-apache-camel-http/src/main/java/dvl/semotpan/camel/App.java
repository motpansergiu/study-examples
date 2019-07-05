package dvl.semotpan.camel;


import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Component
    class StudentRoute extends RouteBuilder {
        public static final String RESPONSE_CODE = "-x-response-code";

        @Override
        public void configure() {
            onException(CannotPayException.class)
                    .handled(true)
                    .setHeader(Exchange.HTTP_RESPONSE_CODE, header(RESPONSE_CODE))
                    .setBody(body());

            restConfiguration()
                    .component("servlet")
                    .bindingMode(RestBindingMode.json);

            rest("/pay").produces("application/json")
                    .get("/doPay/{name}").to("direct:hello");

            from("direct:hello")
                    .process(exchange -> {
                        if (null == exchange.getIn().getHeader(RESPONSE_CODE)) {
                            exchange.getIn().setHeader(RESPONSE_CODE, 200);
                        }
                        exchange.getIn().setBody(new Student(1, "Jon", "Snow"));
                        throw new CannotPayException();
                    });
        }
    }
}