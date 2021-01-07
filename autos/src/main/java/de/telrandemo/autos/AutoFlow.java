package de.telrandemo.autos;

import de.telrandemo.autos.entity.Auto;
import de.telrandemo.autos.service.AutoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/*

ДЗ:
abstract class Shape{
symbol:char
draw():void
}
наследники:
1.
class Line{
length:int // количество символов, которыми нужно нарисовать Line
}
*new Line (*,5) ->

 *****
2.
class Rectangle{
width:int
height:int
}
*new Rectangle(*,5,3) ->

*****       *****
***** или   *   *
*****       *****

3. class Picture{
shapes:List<Shape>
draw - рисует все фигуры из
}
*new Picture('-', shapes) ->

верхнее ребро: 20 раз -----...
ФИГУРЫ в столбик(с новой строчки)
нижнее ребро: 20 раз -----...
-----------------------------------------
and

ShapeFlow           implements ApplicationRunner
picture:Picture
run():void // запускает picture.draw

configuration file - засовываем туда Picture with Line and Rectangle
 */
@Component
public class AutoFlow implements ApplicationRunner {

    //    @Autowired - только если нет конструктора

    private List<Auto> autos;

    private AutoService autoService;
    private Auto bentley;

    public AutoFlow(@Qualifier("simpleAutos") List<Auto> autos, AutoService autoService,
                    // the name of the argument is important
                    Auto silverBentley) {

        this.autos = autos;
        this.autoService = autoService;
        bentley = silverBentley;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        autoService.printAutos(autos);
        for (Auto auto : autos) {
            if (auto.getMake().equals("Opel")) {
                autoService.repainAuto(auto, "grey");
            }
        }

        System.out.println("Auto repaint Opels:");
        autoService.printAutos(autos);
        System.out.println("And here we have Bentley:");
        autoService.printAuto(bentley);
    }

}
