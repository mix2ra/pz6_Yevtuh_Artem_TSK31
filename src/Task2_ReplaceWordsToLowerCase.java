import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2_ReplaceWordsToLowerCase {

    public static void main(String[] args) {
        // Коректний приклад
        String input = "The user with the nickname koala757677 this month wrote 3 times more "
                + "comments than the user with the nickname croco181dile920 4 months ago";

        System.out.println(replaceWords(input));

        // Інші приклади
        System.out.println(replaceWords("HELLO world TEST123"));
        System.out.println(replaceWords("a1B2c3D4"));

        // Некоректні приклади
        try {
            System.out.println(replaceWords(null));
        } catch (Exception e) {
            System.out.println("Помилка (null): " + e);
        }

        try {
            System.out.println(replaceWords(""));
        } catch (Exception e) {
            System.out.println("Помилка (empty): " + e);
        }
    }

    public static String replaceWords(String sentence) {
        if (sentence == null)
            throw new NullPointerException("Аргумент не може бути null");

        if (sentence.isEmpty())
            throw new IllegalArgumentException("Рядок не може бути порожнім");

        Pattern pattern = Pattern.compile("[A-Za-z0-9]+");
        Matcher matcher = pattern.matcher(sentence);

        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group().toLowerCase());
        }

        matcher.appendTail(sb);
        return sb.toString();
    }
}
