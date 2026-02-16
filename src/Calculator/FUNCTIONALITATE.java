package Tema;
//import java.util.Scanner;

public class FUNCTIONALITATE {
	
	double Operatii(Double num1, Double num2, char operator) {
	
		
		switch(operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case 'x':
			return num1 * num2;
		case '÷':
			if(num2 == 0) {
				throw new ArithmeticException("Impartire la 0");
			}
			return num1 / num2;
		default: //posibil sa o fac ca si exceptie dar vad mai incolo
			System.out.println("Operator invalid!");
			throw new IllegalArgumentException("ILLEGAL" + operator);
		}
	}
}
