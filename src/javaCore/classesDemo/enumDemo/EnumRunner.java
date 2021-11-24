package javaCore.classesDemo.enumDemo;

public class EnumRunner {
    public static void main(String[] args) {
        ProcessorType processorType = ProcessorType.BIT_32;
        System.out.println(processorType);
        System.out.println(processorType.name());
        System.out.println(processorType.toString());
//        System.out.println(ProcessorType.valueOf("BIT_32"));//содержит то что в скобках
//        System.out.println(ProcessorType.values()[1]);//возвращает содержимое по индексу
//        System.out.println(ProcessorType.BIT_32.ordinal());//возвр. порядковый номер обьек.

        System.out.println(ProcessorType.BIT_32.getName());//получаем параметры обьекта.
        System.out.println(processorType.getDescription());//вызываем метод
        ProcessorType[] processorTypes = ProcessorType.values();
        String name = String.valueOf(processorTypes[1]);
        System.out.println(name);
    }
}
