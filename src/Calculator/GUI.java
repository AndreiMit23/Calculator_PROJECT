package Tema;
//import java.FUNCTIONALITATE;

import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUI {
	
	void CreareInterfata(JFrame gui) {
		gui.setSize(350,500);
		
		gui.setLayout(null);
		gui.getContentPane().setBackground(Color.black);
		
		
		TextField(gui);	
		Butoane(gui);
	
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	double num1 = 0;
	double num2 = 0;
	char operator;
	FUNCTIONALITATE f = new FUNCTIONALITATE();

	
	void TexturaInterfata(JFrame gui) {
		
	}
	
	void Butoane(JFrame gui) {
		
		// Rândul 0 (C, DEL, ÷)
		JButton bC = new JButton("C");
		bC.setBounds(10, 90, 100, 60);
		gui.add(bC);

		JButton bDel = new JButton("DEL");
		bDel.setBounds(120, 90, 100, 60);
		gui.add(bDel);

		JButton bDiv = new JButton("÷");
		bDiv.setBounds(230, 90, 90, 60);
		gui.add(bDiv);


		// Rândul 1 (7, 8, 9, ×)
		JButton b7 = new JButton("7");
		b7.setBounds(10, 160, 70, 60);
		gui.add(b7);

		JButton b8 = new JButton("8");
		b8.setBounds(90, 160, 70, 60);
		gui.add(b8);

		JButton b9 = new JButton("9");
		b9.setBounds(170, 160, 70, 60);
		gui.add(b9);

		JButton bMul = new JButton("x");
		bMul.setBounds(250, 160, 70, 60);
		gui.add(bMul);


		// Rândul 2 (4, 5, 6, −)
		JButton b4 = new JButton("4");
		b4.setBounds(10, 230, 70, 60);
		gui.add(b4);

		JButton b5 = new JButton("5");
		b5.setBounds(90, 230, 70, 60);
		gui.add(b5);

		JButton b6 = new JButton("6");
		b6.setBounds(170, 230, 70, 60);
		gui.add(b6);

		JButton bMinus = new JButton("-");
		bMinus.setBounds(250, 230, 70, 60);
		gui.add(bMinus);


		// Rândul 3 (1, 2, 3, +)
		JButton b1 = new JButton("1");
		b1.setBounds(10, 300, 70, 60);
		gui.add(b1);

		JButton b2 = new JButton("2");
		b2.setBounds(90, 300, 70, 60);
		gui.add(b2);

		JButton b3 = new JButton("3");
		b3.setBounds(170, 300, 70, 60);
		gui.add(b3);

		JButton bPlus = new JButton("+");
		bPlus.setBounds(250, 300, 70, 60);
		gui.add(bPlus);


		// Rândul 4 (0, ., =)

		JButton b0 = new JButton("0");
		b0.setBounds(90, 370, 70, 60);
		gui.add(b0);

		
		JButton bPunct = new JButton(".");
		bPunct.setBounds(10, 370, 70, 60);
		gui.add(bPunct);
		

		// "=" pe 2 coloane (recomandat)
		JButton bEgal = new JButton("=");
		bEgal.setBounds(170, 370, 150, 60);
		gui.add(bEgal);

		
		ActionListener ascultator = e ->{
			JButton btn = (JButton) e.getSource();
			String text = btn.getText();
		
			if(text.matches("[0-9.]"))
			{
				t.setText(t.getText()+text);
				return;
			}
			
			switch(text) {
		  	case "+":
	        case "-":
	        case "x":
	        case "÷":
	        	try {
	        	num1 = Double.parseDouble(t.getText());
                operator = text.charAt(0);
                t.setText("");
	        	}catch (NumberFormatException ep) {
	        		t.setText("Numar Invalid");
	        	}catch(Exception ex) {
	        		t.setText("Eroare");
	        	}
	        	return;
//                }catch (ArithmeticException Div) {
//                	t.setText("Eroare de operator");
//                }
//
            case "=":
            	try {
            		num2 = Double.parseDouble(t.getText());
            		double result = f.Operatii(num1, num2, operator);
//                t.setText(String.valueOf(result)); vreau sa mi afisez rezultatul de tip int daca fac int + int
            		if(result == (int) result) {
            			t.setText(String.valueOf((int) result));
            		}
            		else {
            			t.setText(String.valueOf(result));
            		}
            		}catch (ArithmeticException ex){
            			t.setText("Eroare matematica");
            		}catch (IllegalArgumentException ex) {
            			t.setText("Eroare de operator");
            		}catch (Exception ex) {
            			t.setText("Eroare"); //pentru alte probleme
            	}
                
                return;

            case "C":
                t.setText("");
                return;

            case "DEL":
                if (!t.getText().isEmpty())
                    t.setText(t.getText().substring(0, t.getText().length() - 1));
                return;
			}
		};
		
		JButton[] butondeBUTOANE = {bC, bDel, bDiv, b7, b8, b9, bMul, b4, b5, b6, bMinus, b1, b2, b3, bPlus, b0, bPunct, bEgal};
		
		
		
		for(int i = 0; i<butondeBUTOANE.length; i++)
		{
			butondeBUTOANE[i].addActionListener(ascultator);
			butondeBUTOANE[i].setFont(new Font("Arial", Font.BOLD, 26));
			butondeBUTOANE[i].setBackground(Color.white);
			butondeBUTOANE[i].setBorder(BorderFactory.createEmptyBorder());
			butondeBUTOANE[i].setFocusPainted(false);
		}
			
	}
	// variabila globala pentru ca altfel nu mi va afisa in calculator (Se pierde referinta)
	JTextField t;
	void TextField(JFrame gui) {
		t = new JTextField();
		t.setBounds(10,20,310,60);
		t.setEditable(false); // utilizatorul nu are voie sa scrie in el (DOAR AFISEAZA)
		t.setFont(new Font("Arial",Font.BOLD,34)); 
		t.setHorizontalAlignment(JTextField.RIGHT);
		t.setForeground(Color.white);
		
		t.setOpaque(false);
		t.setBackground(new Color(0,0,0,0));
		t.setHighlighter(null);
		
		t.setBorder(null);
		gui.add(t);
	}
	
}

