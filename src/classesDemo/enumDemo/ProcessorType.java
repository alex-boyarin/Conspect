package classesDemo.enumDemo;

public enum ProcessorType implements Describable {
    BIT_32("BIT-3"),
    BIT_64("BIT-64");
    private final String name;

    ProcessorType(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return name + " description";
    }

    public String getName() {
        return name;
    }
}
