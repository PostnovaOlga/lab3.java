
import java.util.Scanner;
import java.util.regex.*;

public class lab3 {
    public static void main(String[] args) {
        String stroka = null;
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the date in dd/mm/yyyy format");
            stroka = in.nextLine();
            in.close();
        System.out.println(stroka);
        String regul = "[1-2][0-9]/[0]{1}[1-9]{1}/[1-9]{1}[0-9]{3}"; //тут предусмотрены числа с 10 по 29 для месяцев с 1 по 9
        Pattern pat = Pattern.compile(regul);
        Matcher m = pat.matcher(stroka);

        String regul2 = "[1-2][0-9]/[1]{1}[0-2]{1}/[1-9]{1}[0-9]{3}"; //тут предусмотрены числа с 10 по 29 для месяцев с 10 по 12
        Pattern pat2 = Pattern.compile(regul2);
        Matcher m2 = pat2.matcher(stroka);
        //разделяя месяцы с 1 по 9 и с 10 по 12, мы исключаем возможность ввести количество месяцев от 13 до 19 и 00

        String regul12 = "[0][1-9]/[0]{1}[1-9]{1}/[1-9]{1}[0-9]{3}"; //тут предусмотрены числа с 1 по 9 для месяцев с 1 по 9
        Pattern pat12 = Pattern.compile(regul12);
        Matcher m12 = pat12.matcher(stroka);

        String regul22 = "[0][1-9]/[1]{1}[0-2]{1}/[1-9]{1}[0-9]{3}"; //тут предусмотрены числа с 1 по 9 для месяцев с 10 по 12
        Pattern pat22 = Pattern.compile(regul22);
        Matcher m22 = pat22.matcher(stroka);
        //разделяя числа с 1 по 9 и с 10 до 29, мы исключаем возможность ввести число 00

        String regul31 = "[3][0]/[4|6|9]/[1-9]{1}[0-9]{3}"; //тут предусмотрено число 30 для месяцев 4,6,9
        Pattern pat31 = Pattern.compile(regul31);
        Matcher m31 = pat31.matcher(stroka);

        String regul32 = "[3][0]/[1][1]/[1-9]{1}[0-9]{3}"; //тут предусмотрено число 30 для месяца 11
        Pattern pat32 = Pattern.compile(regul32);
        Matcher m32 = pat32.matcher(stroka);

        String regul33 = "[3][0|1]/[1|3|5|7|8]/[1-9]{1}[0-9]{3}"; //тут предусмотрены числа 30 и 31 для месяцев 1, 3, 5, 7, 8
        Pattern pat33 = Pattern.compile(regul33);
        Matcher m33 = pat33.matcher(stroka);

        String regul34 = "[3][0|1]/[1][0|2]/[1-9]{1}[0-9]{3}"; //тут предусмотрены числа 30 и 31 для месяцев 10 и 12
        Pattern pat34 = Pattern.compile(regul34);
        Matcher m34 = pat34.matcher(stroka);

        String regul41 = "[0-9]{2}/[0-9]{2}/[1]{1}[0-8][0-9]{2}"; //тут предусмотрено отстутствие лет с 1000 по 1900
        Pattern pat41 = Pattern.compile(regul41);
        Matcher m41 = pat41.matcher(stroka);

        if (m41.find()) {
            System.out.println("Incorrect_data");
        } else {
            if ((m.find()) | (m2.find()) | (m12.find()) | (m22.find()) | (m31.find()) | (m32.find()) | (m33.find()) | (m34.find())) {
                System.out.println("Correct_data");
            } else {
                System.out.println("Incorrect_data");
            }
        }
    }
}