package javaCore.colectionDemo.enumColectionDemo.enumAndInterface;

/* Пусть есть некоторый интерфейс, в задачу которого будет входить вычисление
 * параметров каких либо фигур (периметр, площадь, объем,...) */
public interface ShapeService {
    double service(double... param);
}
