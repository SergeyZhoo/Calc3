import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] operator = {"+", "-", "/", "*"};              //Задаем знаки действий и
        String[] symbol = {"\\+", "-", "/", "\\*"};            //символы, для разделения строки по знакам действий.
        Scanner scan = new Scanner(System.in);                 //Создаем сканер.
        System.out.println("Введите выражение: ");
        String console = scan.nextLine();                      //Для считывания с консоли строки полностью.

        int operatorIndex = 0;
        for (int i = 0; i < operator.length; i++) {            //Определяем знак действия и присваиваем ему значение i.
            if (console.contains(operator[i])) {
                operatorIndex = i;
                break;
            }
        }
        Converter converter = new Converter();
        String[] data = console.split(symbol[operatorIndex]);  //Определяем цифры путем разделения строки по символу.



        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){ //Определяем находятся ли цифры в одном формате.
            int a,b;

            boolean isRoman = converter.isRoman(data[0]);      //Определяем римские ли это цифры.
            if(isRoman){

                a = converter.romanToInt(data[0]);             //Если римские, конвертируем в арабские.
                b = converter.romanToInt(data[1]);

            }else {
                a = Integer.parseInt(data[0]);                 //Если арабские, присваиваем им значение a и b.
                b = Integer.parseInt(data[1]);
            }

            if (a > 10 || b > 10) {
                System.out.println("Некорректное выражение");  //задаем максимально допустимое значение числа.
                return;
            }
            if (a < 1 || b < 1) {
                System.out.println("Некорректное выражение");  //задаем минимально допустимое значение числа.
                return;
            }
            if (data.length != 2) {
                System.out.println("Некорректное выражение");  //задаем максимально допустимое значение чисел в строке.
                return;
            }


            int result;                                       //выполняем арефмитическое действие и выводим результат.
            switch (operator[operatorIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }

            if(isRoman){
                System.out.println(converter.intToRoman(result));
            }
            else{
                System.out.println(result);
            }
            }else{
            System.out.println("Числа должны быть в одном формате");
        }


        }

    }
