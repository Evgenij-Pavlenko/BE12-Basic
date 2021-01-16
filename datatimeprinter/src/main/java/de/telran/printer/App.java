package de.telran.printer;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class App {
    private DateTimeProvider provider = new DateTimeProvider();
    private OutputPrinter printer = new OutputPrinter();

    public App(DateTimeProvider provider, OutputPrinter printer) {
        this.provider = provider;
        this.printer = printer;
    }

    public void execute(){
        String currentDateTime = provider.getCurrentDateTime();
        printer.print("Hello World " + currentDateTime);
    }

    public static void main(String[] args) {
//        DateTimeProvider provider = new DateTimeProvider();
//        OutputPrinter printer = new OutputPrinter();
//        App app = new App(provider, printer);
//        app.execute();

//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
         App app = context.getBean("app", App.class);
         app.execute();

    }
}
