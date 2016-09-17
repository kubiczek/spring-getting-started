package pl.kubiczek.spring.gs.consumerest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mkubiczek on 9/17/2016.
 */
@SpringBootApplication
public class Application {

    public static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            String url = "http://gturnquist-quoters.cfapps.io/api/random";
            log.info("GET " + url);
            Quote quote = restTemplate.getForObject(url, Quote.class);
            log.info(quote.toString());
        };
    }
}
