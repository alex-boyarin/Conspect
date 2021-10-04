package reGex.task;

/**
 * Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у которых есть
 * параметры, например <p id="p1">, и замену их на простые теги абзацев <p>
 */
public class Task3 {
    public static void main(String[] args) {
        String regex = "(<p .+?>)(.+?</p>)";
        String input = "<p>bgblglb b lgbl</p> <b> dfgdf </b> dfeff <p id=\"p1\">fvrtg</p>" +
                "mgbkmgkbm<p>fvvvfv <p id=\"pfff1\">fdggr</p>";
        System.out.println(input.replaceAll(regex, "<p>$2"));
    }
}
