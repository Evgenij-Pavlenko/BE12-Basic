package de.telrandemo.autos.config;

import de.telrandemo.autos.entity.Auto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


// The annotation notifies Spring to use this class as a config class
@Configuration
public class AutoConfiguration {

    // create here a bean of the type Auto with the implicit name "redMazda"
    @Bean
    @Order(2)
    @Qualifier("simpleAutos")
    public Auto redMazda(){
        return new Auto("Mazda", "5","red", 2018, 25000);
    }

    // emerald -  изумрудный
    @Bean
    @Order(1)
    @Qualifier("simpleAutos")
    public Auto emeraldOpel(){
        return new Auto("Opel", "some","emerald", 2015, 75000);
    }
    // expensive - дорогой
    @Bean
    public Auto silverBentley(){
        return new Auto("Bentley", "expensive","silver", 2015, 1350);
    }

}
