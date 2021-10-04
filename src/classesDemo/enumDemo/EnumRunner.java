package classesDemo.enumDemo;

public class EnumRunner {
    public static void main(String[] args) {
        ProcessorType processorType = ProcessorType.BIT_32;
//        System.out.println(processorType);
//        System.out.println(processorType.name());
//        System.out.println(processorType.toString());
        System.out.println(ProcessorType.valueOf("BIT_32"));
        System.out.println(ProcessorType.values()[1]);
        System.out.println(ProcessorType.BIT_32.ordinal());

        System.out.println(ProcessorType.BIT_32.getName());
        System.out.println(processorType.getDescription());
        ProcessorType[] processorTypes = ProcessorType.values();
        String name = String.valueOf(processorTypes[1]);
        System.out.println(name);
    }
}
