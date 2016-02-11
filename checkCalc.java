/* Created by Heet ( @heet3727 )
 * See github link: https://github.com/heet3727/java_calculator
 * Feb 11th, 2016
 */
 
 	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Container;
	import java.awt.FlowLayout;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.awt.Font;
	import java.awt.GridBagLayout;
	import java.awt.GridBagConstraints;
	import java.awt.Dimension;

	import javax.swing.*;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;

	import java.io.*; //for fileWriter

    public class checkCalc extends JFrame implements ActionListener,KeyListener
   {

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button0 = new JButton("0");
	JButton button00 = new JButton("00");
	
	JButton buttonAdd = new JButton("+");
	JButton buttonSub = new JButton("-");
	JButton buttonMult = new JButton("*");
	JButton buttonDiv = new JButton("/");
	JButton buttonDot = new JButton(".");
	JButton buttonEquals = new JButton("=");
	JButton buttonClear= new JButton("C");
	JButton buttonBackspace= new JButton("<-");
	JButton buttonPlusMinus= new JButton("+_");
	JButton buttonPercent= new JButton("%");

	JButton buttonLog = new JButton("log");
	JButton buttonPower = new JButton("x^n");
	JButton buttonSin = new JButton("sin");
	JButton buttonCos = new JButton("cos");
	JButton buttonTan = new JButton("tan");

	JPanel jMstr = new JPanel();
	JTextArea his = new JTextArea();//height, length

	JScrollPane scroll = new JScrollPane();
        //scroll.setBounds(10, 11, 455, 249);                     // <-- THIS

	JPanel buttonSpace = new JPanel();
        JLabel output = new JLabel("0");//main screen

	JPanel historyPanel = new JPanel();
	JLabel historyLabel = new JLabel("0");

      double firstNumber, memoryNumber;
      String opera = "0";
      boolean clear;

       public checkCalc()
      {


		//main screen
       		 output.setHorizontalTextPosition(JLabel.RIGHT);
		 output.setBackground(Color.WHITE);
		 output.setOpaque(true);
		 //output.addActionListener(this);
		 output.addKeyListener(this);
		 getContentPane().add(output, BorderLayout.NORTH);
		

		getContentPane().add(his);//, BorderLayout.NORTH);
		makeTextArea();

		//getContentPane().add(scroll);
		//setLocationRelativeTo ( null );


         	getContentPane().add(jMstr, BorderLayout.SOUTH);

		//button space
		 buttonSpace.setLayout(new GridLayout(5, 4, 3, 3));

		 buttonSpace.add(buttonLog); buttonLog.addActionListener(this); buttonLog.addKeyListener(this);
		 buttonSpace.add(buttonBackspace); buttonBackspace.addActionListener(this); buttonBackspace.addKeyListener(this);
		 buttonSpace.add(buttonClear); buttonClear.addActionListener(this); buttonClear.addKeyListener(this);
		 //buttonSpace.add(buttonPlusMinus); buttonPlusMinus.addActionListener(this); buttonPlusMinus.addKeyListener(this);
 		 buttonSpace.add(buttonPercent); buttonPercent.addActionListener(this); buttonPercent.addKeyListener(this);
		 buttonSpace.add(buttonDiv); buttonDiv.addActionListener(this); buttonDiv.addKeyListener(this);

		 buttonSpace.add(buttonPower); buttonPower.addActionListener(this); buttonPower.addKeyListener(this);
		 buttonSpace.add(button7); button7.addActionListener(this); button7.addKeyListener(this);	
		 buttonSpace.add(button8); button8.addActionListener(this); button8.addKeyListener(this);
		 buttonSpace.add(button9); button9.addActionListener(this); button9.addKeyListener(this);
		 buttonSpace.add(buttonMult); buttonMult.addActionListener(this); buttonMult.addKeyListener(this);

		 buttonSpace.add(buttonSin); buttonSin.addActionListener(this); buttonSin.addKeyListener(this);
		 buttonSpace.add(button4); button4.addActionListener(this); button4.addKeyListener(this);
		 buttonSpace.add(button5); button5.addActionListener(this); button5.addKeyListener(this);
		 buttonSpace.add(button6); button6.addActionListener(this); button6.addKeyListener(this);
		 buttonSpace.add(buttonSub); buttonSub.addActionListener(this); buttonSub.addKeyListener(this);

		 buttonSpace.add(buttonCos); buttonCos.addActionListener(this); buttonCos.addKeyListener(this);
		 buttonSpace.add(button1); button1.addActionListener(this); button1.addKeyListener(this);
		 buttonSpace.add(button2); button2.addActionListener(this); button2.addKeyListener(this);
		 buttonSpace.add(button3); button3.addActionListener(this); button3.addKeyListener(this);
		 buttonSpace.add(buttonAdd); buttonAdd.addActionListener(this); buttonAdd.addKeyListener(this);

		 buttonSpace.add(buttonTan); buttonTan.addActionListener(this); buttonTan.addKeyListener(this);
		 buttonSpace.add(button00); button00.addActionListener(this); button00.addKeyListener(this);
		 buttonSpace.add(button0); button0.addActionListener(this); button0.addKeyListener(this);
		 buttonSpace.add(buttonDot); buttonDot.addActionListener(this); buttonDot.addKeyListener(this);
		 buttonSpace.add(buttonEquals); buttonEquals.addActionListener(this); buttonEquals.addKeyListener(this);


		jMstr.setLayout(new BorderLayout());
		jMstr.add(buttonSpace, BorderLayout.SOUTH);


		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch(Exception e){}       

		SwingUtilities.updateComponentTreeUI(jMstr);

		//actionPerformed(buttonClear);

		//updateTextArea();    
	}



	public void actionPerformed(ActionEvent e)
        {
		 updateTextArea();
		 double result = 0;

		 /******* Number Buttons ********/
		 if(e.getSource() == button00)
		 {
		    history+="00";
		    putDigitOnLabel(0);
		    putDigitOnLabel(0);
		 }

		 if(e.getSource() == button0)
		 {
		    history+="0";
		    putDigitOnLabel(0);
		 }

		 if(e.getSource() == button1)
		 {
		    history+="1";
		    putDigitOnLabel(1);
		 }

		 if(e.getSource() == button2)
		 {
		    history+="2";
		    putDigitOnLabel(2);
		 }
		
		 if(e.getSource() == button3)
		 {
		    history+="3";
		    putDigitOnLabel(3);
		 }

		 if(e.getSource() == button4)
		 {
		    history+="4";
		    putDigitOnLabel(4);
		 }

		 if(e.getSource() == button5)
		 {
		    history+="5";
		    putDigitOnLabel(5);
		 }

		 if(e.getSource() == button6)
		 {
		    history+="6";
		    putDigitOnLabel(6);
		 }

		 if(e.getSource() == button7)
		 {
		    history+="7";
		    putDigitOnLabel(7);
		 }

		 if(e.getSource() == button8)
		 {
		    history+="8";
		    putDigitOnLabel(8);
		 }

		 if(e.getSource() == button9)
		 {
		    history+="9";
		    putDigitOnLabel(9);
		 }

		 if(e.getSource() == buttonClear)
		 {
			history="";
			setTextOnOutput("0");
		 }

		/******* operations *******/

		 if(e.getSource() == buttonAdd)
		 {
		    history+=" + ";
		    operation("+");
		 }

		 if(e.getSource() == buttonSub)
		 {
		    history+=" - ";
		    operation("-");
		 }

		 if(e.getSource() == buttonMult)
		 {
		    history+=" * ";
		    operation("*");
		 }

		 if(e.getSource() == buttonDiv)
		 {
		    history+=" / ";
		    operation("/");
		 }

		
		 if(e.getSource() == buttonEquals)
		 {
    		    history+=" = ";
		    processEquals();
		 }

		 if(e.getSource() == buttonPlusMinus)
		 {
		    changeSign();
		 }

		 if(e.getSource() == buttonPercent)
		 {
  		    history+=" % ";
		    operation("%");
		 }

		 if(e.getSource() == buttonDot)
		 {
		    history+=".";
		    addDecimalPoint();
		 }

		 if(e.getSource() == buttonBackspace)
		 {
			backspace();
		 }
		
		 // button functions for additional features
		 if(e.getSource() == buttonLog)
		 {
			log();
		 }

		 if(e.getSource() == buttonSin)
		 {
			sin();
		 }
		
		 if(e.getSource() == buttonCos)
		 {
			cos();
		 }

		 if(e.getSource() == buttonTan)
		 {
			tan();
		 }

		 if(e.getSource() == buttonPower)
		 {
			operation("^");
			history+=" ^ ";
		 }

	}

	// Event Listener to allow the user to enter numbers and operands via their keyboard.
	public void keyTyped(KeyEvent e) {

		//System.out.println(e);
		int ascii = (int)e.getKeyChar();

		switch (e.getKeyChar()){

	            case '9':
			history+="9";
			putDigitOnLabel(9);
                        break;
		
		    case '8':
			history+="8";
			putDigitOnLabel(8);
                        break;

		    case '7':
			history+="7";
			putDigitOnLabel(7);
                        break;
		
		    case '6':
			history+="6";
			putDigitOnLabel(6);
                        break;

		    case '5':
			history+="5";
			putDigitOnLabel(5);
                        break;

		    case '4':
			history+="4";
			putDigitOnLabel(4);
                        break;

		    case '3':
			history+="3";
			putDigitOnLabel(3);
                        break;

		    case '2':
			history+="2";
			putDigitOnLabel(2);
                        break;

		    case '1':
			history+="1";
			putDigitOnLabel(1);
                        break;

		    case '0':
			history+="0";
			putDigitOnLabel(0);
                        break;

		/******* operations *******/

		    case '+':
		    	history+=" + ";
			operation("+");
                        break;

		    case '-':
		    	history+=" - ";
			operation("-");
                        break;

		    case '*':
		    	history+=" * ";
			operation("*");
                        break;

		    case '/':
		    	history+=" / ";
			operation("/");
                        break;

		    case '%':
		    	history+=" % ";
			operation("%");
                        break;

		    case '=':
			history+=" = ";
			processEquals();
                        break;

		    case '.':
		    	history+=".";
			addDecimalPoint();
                        break;

		// math functions
		
		    case 's':
			sin();
                        break;

		    case 'c':
			cos();
                        break;

		    case 't':
			tan();
                        break;

		    case 'l':
			log();
                        break;
		
		    case '^':
			history+=" ^ ";
			operation("^");
                        break;
		}

		switch(ascii)
		{
			case 8:
				backspace();
				break;

			case 127:
				history="";
				setTextOnOutput("0");
				break;
		}

	}

	public void keyPressed(KeyEvent e) {
		 
	}

	public void keyReleased(KeyEvent e) {

		
	}


	public void putDigitOnLabel(int digit)
	      {
		 if(clear == true)
		 {
		    output.setText("");
		 }

		 if(getStringOnDisplay().indexOf("0") == 0)
		 {
		    setTextOnOutput(getStringOnDisplay().substring(1));
		 }

		 output.setText(getStringOnDisplay() + digit);

		 clear = false;
	      }     

	public String getStringOnDisplay()
	      {
		 return output.getText();
	      }

	public void setTextOnOutput(String s)
	      {
		 output.setText(s);
	      }

	public void operation(String s)
	      {      
		 double number = getNumberInDisplay();

		 if(!(opera.equals("0")))
		 {         
		    double result = processOperator();
		    displayResult(result);
		    firstNumber = result;
		 }

		 else
		 {
		    firstNumber = number;
		 }

		 clear = true;
		 opera = s;
	      }


	public void processEquals()
	      {
		 double result;

		 result = processOperator();
		 displayResult(result);

		history+=result;

		System.out.println(history);
		updateHistory(history); // updating history

		history="";


		try{
			File newf=new File("history.txt");			
			if(newf.exists())
			{
				FileReader historyReader=new FileReader("history.txt");  
				int i1;
				printHistory="";
				  while((i1=historyReader.read())!=-1)  
				  {
					printHistory+=(char)i1;
				  }
				  historyReader.close();
				System.out.println(printHistory);
				printHistory="";
			}
			else
			{
				System.out.println("history.txt was not found.");
				// tries to create new file in the system
				boolean bool = newf.createNewFile();
				System.out.println("created new history.txt file for history: "+ bool);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		opera = "0";

		updateTextArea();//updateTextArea();

	      }


	public void updateTextArea()
		{
		
			try{
				File newf=new File("history.txt");
				if(newf.exists())
				{
					FileReader historyReader=new FileReader("history.txt");
					int i1;  
					while((i1=historyReader.read())!=-1)
					{
						printHistory+=(char)i1;
					}
					historyReader.close();
					his.setText(printHistory+"\n");// appending
					// his.setText(); for setting special text
					printHistory="";
				}
				else
				{
					System.out.println("history.txt was not found.");
					// tries to create new file in the system
					boolean bool = newf.createNewFile();
					System.out.println("created new history.txt file for history: "+ bool);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}


		}


	public void makeTextArea()
		{
			his.setColumns(1);
			his.setRows(5);

			his.setFont(new Font("Serif", Font.ITALIC, 14));
			his.setLineWrap(true);
			his.setWrapStyleWord(true);
			his.setEditable(false);
			his.setTabSize(1);
			//scroll.setViewportView(his);
		}


	public double processOperator()
	      {    
		 double answer = 0;
		 double number = getNumberInDisplay();	

		 if(opera.equals("*"))
		 {

		    answer = firstNumber * number;
		 }

		 if(opera.equals("-"))
		 {
		    answer = firstNumber - number;
		 }

		 if(opera.equals("+"))
		 {
		    answer = firstNumber + number;
		 }

		 if(opera.equals("/"))
		 {
		    answer = firstNumber / number;
		 }

		 if(opera.equals("^"))
		 {
		    answer = Math.pow(firstNumber, number);
		 }

		 if(opera.equals("%"))
		 {
		    answer = ( firstNumber / number )*100;
		 }

		 return answer;
	      }

	public double getNumberInDisplay()
	      {
		 String stuff = output.getText();
		 return Double.parseDouble(stuff);
	      }

	public void displayResult(double result)
	      {
		 setTextOnOutput(Double.toString(result));
		 firstNumber = result;
		 clear = true;
	      }

	public void backspace()
		{
			if(history.length()>1)
			{
				history=history.substring(0, history.length()-1);
				setTextOnOutput(getStringOnDisplay().substring(0, getStringOnDisplay().length()-1));
			}
			else
			{
				history="";
				setTextOnOutput("0");
			}
		}

	public void addDecimalPoint()
	      {
		 if(clear == true)
		 {
		    setTextOnOutput("");
		 }

		 if(getStringOnDisplay().indexOf(".") == -1)
		 {
		    setTextOnOutput(new String(getStringOnDisplay() + "."));
		 }
	      }

	public void changeSign()
	      {
		 if(Double.parseDouble(output.getText()) != 0)
		 {
		    setTextOnOutput(Double.toString(getNumberInDisplay() * -1));
		 }    
	      } 

	public void printHistory()
		{	
			try{
				File newf=new File("history.txt");
				if(newf.exists())
				{
					FileReader historyReader=new FileReader("history.txt");
					int i1;  
					while((i1=historyReader.read())!=-1)  
					{
						printHistory+=(char)i1;
					}
					historyReader.close();
					System.out.println(printHistory);
					printHistory="";
				}
				else
				{
					System.out.println("history.txt was not found.");
					// tries to create new file in the system
					boolean bool = newf.createNewFile();
					System.out.println("created new history.txt file for history: "+ bool);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

		}

	public void updateHistory(String history)
		{
			try{
				File newf=new File("history.txt");				
				if(newf.exists())
				{
					FileReader reader=new FileReader("history.txt");
					int i; 
					oldhistory="";
					while((i=reader.read())!=-1)  
					{
						oldhistory+=(char)i;
					}
					reader.close();
					FileWriter writer = new FileWriter("history.txt");
					writer.write(history+"\n"+oldhistory);
					// System.out.println("\n"+history+"\n"+oldhistory);
					writer.flush();
					writer.close();

					history="";oldhistory="";
				}
				else
				{
					System.out.println("history.txt was not found.");
					// tries to create new file in the system
					boolean bool = newf.createNewFile();
					System.out.println("created new history.txt file for history: "+ bool);
				}

			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		

		}

	/* additional functions */
	public void log()//, int base)
		{
			double number = getNumberInDisplay();
			double result = (double) (Math.log(number) / Math.log(10)); //for natural logarithm
			history="log "+ history + " = " + result;
			displayResult(result);
			updateHistory(history); //updating history file
			printHistory();
			updateTextArea();
		}

	public void sin()
		{
			double number = getNumberInDisplay();
			double result = (double) Math.sin(number);
			history="sin "+ history + " = " + result;
			displayResult(result);
			updateHistory(history); //updating history file
			printHistory();
			updateTextArea();
		}

	public void cos()
		{
			double number = getNumberInDisplay();
			double result = (double) Math.cos(number);
			history="cos "+ history + " = " + result;
			displayResult(result);
			updateHistory(history); //updating history file
			printHistory();
			updateTextArea();
		}

	public void tan()
		{
			double number = getNumberInDisplay();
			double result = (double) Math.tan(number);
			history="tan "+ history + " = " + result +"\n";
			displayResult(result);
			updateHistory(history); //updating history file
			printHistory();
			updateTextArea();
		}


	public String history = "";
	public String oldhistory = "";
	public String printHistory = "";


       public static void main(String args[])
      {

         checkCalc f= new checkCalc();
         f.setTitle("Simple Calculator with hostory and keyboard event-handling");
         f.setSize(500, 500);
         //f.getContentPane().add( L );//added
         f.pack();
         f.setVisible(true);
         f.setResizable(true);

      } 
   }


       

