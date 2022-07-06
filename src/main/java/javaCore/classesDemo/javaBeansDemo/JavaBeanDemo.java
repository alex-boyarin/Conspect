package javaCore.classesDemo.javaBeansDemo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Таким образом выглядит java Bean class
 * 1- public class, он должен быть доступен вне пакета для того чтобы с ним можно было работать.
 * 2-Он должен иметь конструктор по умолчанию так же public.
 * 3-Он должен содержать не статические поля, и для соблюдения инкопсуляции поля должны быть privat.
 * 4-Для доступа к полям должны быть корректные Getter&Setter.
 * 5-Возможность сохраняемости, это Serializable, позже появилась  xml, json.
 * 6-Так же корректная реализация equals, hashcode, toString.
 */
public class JavaBeanDemo implements Serializable {
    private long orderId;
    private int yearOld;

    public JavaBeanDemo() {
    }

    public JavaBeanDemo(long orderId, int yearOld) {
        this.orderId = orderId;
        this.yearOld = yearOld;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaBeanDemo that = (JavaBeanDemo) o;
        return orderId == that.orderId && yearOld == that.yearOld;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, yearOld);
    }

    @Override
    public String toString() {
        return "JavaBeanDemo{" +
               "orderId=" + orderId +
               ", yearOld=" + yearOld +
               '}';
    }
}
