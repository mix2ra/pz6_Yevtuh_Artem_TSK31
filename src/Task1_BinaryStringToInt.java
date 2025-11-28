public class Task1_BinaryStringToInt {

    public static void main(String[] args) {
        // Коректні приклади
        System.out.println(binaryStringToInt("10101")); // 21
        System.out.println(binaryStringToInt("0"));      // 0
        System.out.println(binaryStringToInt("1111"));   // 15

        // Некоректні приклади
        try {
            System.out.println(binaryStringToInt(null));
        } catch (Exception e) {
            System.out.println("Помилка (null): " + e);
        }

        try {
            System.out.println(binaryStringToInt(""));
        } catch (Exception e) {
            System.out.println("Помилка (empty): " + e);
        }

        try {
            System.out.println(binaryStringToInt("10a01"));
        } catch (Exception e) {
            System.out.println("Помилка (not binary): " + e);
        }
    }

    public static int binaryStringToInt(String s) {
        if (s == null)
            throw new NullPointerException("Аргумент не може бути null");

        if (s.isEmpty())
            throw new IllegalArgumentException("Рядок порожній");

        if (!s.matches("[01]+"))
            throw new IllegalArgumentException("Допустимі лише символи '0' та '1'");

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 2 + (s.charAt(i) - '0');
        }

        return result;
    }
}
