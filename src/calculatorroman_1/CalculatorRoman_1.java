
package calculatorroman_1;

import java.util.*;

public class CalculatorRoman_1 {
      static Scanner console = new Scanner(System.in);
      static int last=2000;
    
      public static void main(String[] args) {
      System.out.println("Консольный калькулятор совершает арифметические операции над арабскими либо римскими числами \n"+ 
            "в интервале от 1 до 10 включительно.\n\n"+
            "При вводе чисел нужно следовать правилу:\n"+ "оба вводимых числа должны быть в одном формате либо в арабском, "
           +"либо в римском.\n\n"+
            "Пожалуйста, введите данные для консольного калькулятора в следующем виде: \n" +
           "[число], [пробел], [операция (+,-,*,/)], [пробел], [(число]: \n");
    
      System.out.println("Введите соответствующие данные для вычисления:");
  
      String value1 = console.next(); //программа будет ждать пока пользователь введет данные через пробел 
                                     //(число1, операция, число2) и нажмет клавишу enter
    
   try { //определяет блок кода, в котором может произойти исключение;
      
      console.hasNext();
      String value2 = console.next();
      
      console.hasNext();
      String value3 = console.next();
      
      char a = value1.charAt( 0 ); //возвращает символ, стоящий на определенном индексе.
      char b = value3.charAt( 0 ); //возвращает символ, стоящий на определенном индексе.
      
      if ( Character.isDigit( a ) | Character.isDigit( b )) //Character -это класс (char).Проверяет, является ли символы 
                                                            // a, b символом цифрой
	{
	int int_value1 = Integer.parseInt( value1 );//Integer -это класс (int).Возвращает число, полученное из строки
        int int_value3 = Integer.parseInt( value3 );//Integer -это класс (int).Возвращает число, полученное из строки
      
        System.out.println("Ответ арабское число = " + calc(value2, int_value1, int_value3));//ответ в арабских цифрах
        //int result = calc(value2, int_value1, int_value3);//вызываю метод -calc
        } 
        else {
	int int_value1 = convertRomanToInt(value1); //Конвертирует в арабские 
        int int_value3 = convertRomanToInt(value3); //Конвертирует в арабские
        int result = calc(value2, int_value1, int_value3);//вызываю метод -calc
        String roman = roman(result);
        System.out.println("Ответ римское число = " + ( roman ));//ответ в римских цифрах
	//System.out.println("Ответ римское число = " + Numeral.convertRomanToInt(value));//считает в римских цифрах
	}   
      }
      catch( NumberFormatException e) //определяет блок кода, в котором происходит обработка исключения;
	{
	System.out.println("Проблема: неверный формат");
	 
	}
     }
      
      
     public static int calc(String value2, int int_value1, int int_value3) {
     int result = 0;
     if (value2.equals("+")) {result=int_value1+int_value3;}
     if (value2.equals("-")) {result=int_value1-int_value3;}
     if (value2.equals("*")) {result=int_value1*int_value3;}
     if (value2.equals("/")) {result=int_value1/int_value3;}
     //System.out.println(result);
     return result;
     }
 
     public static String roman(int input){ //присваивает арабской цифре соответствующий римский символ цифры 
  String s = "";
  if (input <1 ||input > 100)
    System.out.println("отрицательное значение римской цифры ");
  while (input >= 100) {
    s += "C";
    input -= 100;
  }
  while (input >= 90) {
    s += "XC";
    input -= 90;
  }
  while (input >= 50) {
    s += "L";
    input -= 50;
  }				
  while (input >= 40) {
    s += "XL";
    input -= 40;
  }
  while (input >= 10) {
    s += "X";
    input -= 10;
  }
  while (input >= 9) {
    s += "IX";
    input -= 9;
  }
  while (input >= 5) {
    s += "V";
    input -= 5;
  }
  while (input >= 4) {
    s += "IV";
    input -= 4;
  }
  while (input >= 1) {
    s += "I";
    input -= 1;
  } 
  return s;
   }
     
     public static int convertRomanToInt(String romanNumeral) //Конвертирует в арабские 
            throws NumberFormatException //– используется для возбуждения исключения;
		{
			int integerValue = 0;
	 
	 romanNumeral = romanNumeral.toUpperCase(); // метод котоый делает все буквы в строке заглавными
			for (int i = 0; i < romanNumeral.length(); i++) //для всех римскихчисел в строке 
			{
				char ch = romanNumeral.charAt( i );
	 
				int number = letterToNumber( ch );
	 
				if ( number == -1)
				{
					//throw new NumberFormatException("Invalid format");//– используется для возбуждения исключения;
				}
 				//integerValue += number;
                                if (last<number)
                                    number= number-last-1;
                                integerValue += number;
                                last=number;
                                //
			}
	 
			return integerValue;
		}
     private static int letterToNumber(char letter) //присваивает римскому символу цифры соответствующую арабскую цифру
		{
	 
			switch (letter) {
				case 'I':  return 1;
				case 'V':  return 5;
	 			case 'X':  return 10;
				case 'L':  return 50;
				case 'C':  return 100;
				case 'D':  return 500;
				case 'M':  return 1000;
				default:   return -1;
			}
				}
    
     
}