package de.telran.printer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@ComponentScan("de.telran.printer")
public class Config {

    @Bean
    public DateTimeProvider getDateTimeProvider(){
        return new DateTimeProvider();
    }

    @Bean
    public OutputPrinter getOutputPrinter(){
        return new OutputPrinter();
    }

    @Bean
    public App app(DateTimeProvider provider, OutputPrinter printer){
        return new App(provider, printer);
    }
}
