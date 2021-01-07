package de.telrandemo.autos.service;

import de.telrandemo.autos.entity.Auto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {

    public void printAutos(List<Auto> autos) {
        for (Auto auto : autos) {
            printAuto(auto);
        }
    }

    public void printAuto(Auto auto) {
        System.out.println(auto);
    }

    public void repainAuto(Auto auto, String newColor){
        auto.setColor(newColor);
    }
}
