package exceptionDemo.ownExceptions;

/*
 * Собственные исключения
 */
public class ResourceMain {
    public static void main(String[] args) {
        Resource resource = new Resource();
        try {
            ResourceAction.load(resource);
        } catch (ResourceException e) {
            e.printStackTrace();
        }
    }
}
