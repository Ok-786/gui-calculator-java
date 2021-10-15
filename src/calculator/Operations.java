//Made by: M.Ali Altaf(007) , Muhammad Affan Butt(021), Muhammad Osama Nawaz(027) 


package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templateswhatsapp web

 * and open the template in the editor.
 */

/**
 *
 * @author OK-786 productions
 */

class Stack
{
    int top = -1;
    int size;
    char arr[];
    
    public Stack(int size)
    {
        this.size = size;
        arr = new char[size];
    }
    
    public void push(char c)
    {
        arr[++top] = c;
    }
    
    public char pop()
    {
        
            return arr[top--];
            
    }
    
    public char peek()
    {
        return arr[top];
    }
    
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    public boolean isFull()
    {
        return top == size-1;
    }
}


class IntStack
{
    int top = -1;
    int size;
    int arr[];
    
    public IntStack(int size)
    {
        this.size = size;
        arr = new int[size];
    }
    
    public void push(int c)
    {
        arr[++top] = c;
    }
    
    public int pop()
    {
        return arr[top--];        
    }
    
    public int peek()
    {
        return arr[top];
    }
    
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    public boolean isFull()
    {
        return top == size-1;
    }
    
}



class StackOperations
{
    Stack stack;
    IntStack intStack;
    String output = "";
    int result;
    
    
    public void inToPost(String input)
    {
        stack = new Stack(input.length());
        
        for(int i=0; i<input.length(); i++)
        {
            
            switch(input.charAt(i))
            {
                case '(':
                    stack.push('(');
                    break;
                case '+':
                case '-':
                    getOp(input.charAt(i), 1);
                    break;
                case '*':
                case '/':
                    getOp(input.charAt(i), 2);
                    break;
                case '^':
                    getOp(input.charAt(i), 3);
                    break;
                case ')':
                    getPrenth();
                    break;
                default:
                    output += input.charAt(i);
            }
            
        }
        
        
        while(!stack.isEmpty())
        {
            output += stack.pop();
        }
        
    }
    
    
    
    public void getOp(char ch, int precd)
    {
        
        while(!stack.isEmpty())
        {
            char chx = stack.pop();
            
            if(chx == '(')
            {
                stack.push(chx);
                break;
            }
            else
            {
                int pprec;
                
                if(chx =='-' || chx =='+')
                    pprec = 1;
                else if(chx =='*' || chx =='/')
                    pprec = 2;
                else
                    pprec = 3;
                
                if(pprec < precd)
                {
                    stack.push(chx);
                    break;
                }
                else
                    output += chx;
            }
            
        }
        
        stack.push(ch);
    }
    
    
    public void getPrenth()
    {
        char ch;
        
        while(!stack.isEmpty())
        {
            ch = stack.pop();
            
            if(ch == '(')
                break;
            else
                output += ch;
        }
    }
    
    
    
    public void calculateResult(String output)
    {
        intStack = new IntStack(output.length());
        int operand1;
        int operand2;
        for(int i=0; i<output.length(); i++)
        {
            switch (output.charAt(i))
            {
                case '+':
                    operand2 = intStack.pop();
                    operand1 = intStack.pop();
                    result = operand1 + operand2;
                    intStack.push(result);
                    break;
                case '-':
                    operand2 = intStack.pop();
                    operand1 = intStack.pop();
                    result = operand1 - operand2;
                    intStack.push(result);
                    break;
                case '*':
                    operand2 = intStack.pop();
                    operand1 = intStack.pop();
                    result = operand1 * operand2;
                    intStack.push(result);
                    break;
                case '/':
                    operand2 = intStack.pop();
                    operand1 = intStack.pop();
                    result = operand1 / operand2;
                    intStack.push(result);
                    break;
                case '^':
                    operand2 = intStack.pop();
                    operand1 = intStack.pop();
                    int temp1 =operand1;
                    for(int j=1; j<operand2; j++)
                    {
                        temp1 = temp1 * operand1;
                    }
                    result = temp1;
                    intStack.push(result);
                    break;
                    
                default:
                    String temp = ""+output.charAt(i);
                    intStack.push((Integer.parseInt(temp)));
            }
        }
    }
    
}


class Operations extends JFrame 
{
    
    private JButton buttonZero;
    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonFour;
    private JButton buttonFive;
    private JButton buttonSix;
    private JButton buttonSeven;
    private JButton buttonEight;
    private JButton buttonNine;

    private JButton opButtonPlus;
    private JButton opButtonMinus;
    private JButton opButtonDivide;
    private JButton opButtonMultiply;
    private JButton opButtonEquals;
    private JButton opButtonClear;
    private JButton opButtonPower;
    private JButton opBracketOpen;
    private JButton empty;
    private JButton empty1;
    private JButton opBracketClose;
            
    private TextField tf;
    private JTextField status;

    private JPanel numButtonPanel;
    private JPanel opButtonPanel;
    private JPanel opButtonPanel2;
    private JPanel basePanel;

    
    
    public Operations()
    {
        
        super("Scientific Calculator");
        
        basePanel = new JPanel();
        numButtonPanel = new JPanel(new GridLayout(3,4));
        opButtonPanel = new JPanel(new GridLayout(5,1));
        opButtonPanel2=new JPanel (new GridLayout(1,4));
        
        
        
        JLabel txt00 = new JLabel("<");
        JLabel txt01 = new JLabel("<");
        JLabel txt20 = new JLabel("<");
        JLabel txt21 = new JLabel(">");
        JLabel txt2=new JLabel("KalKULATOR");
        JLabel txt10 = new JLabel(">");
        JLabel txt11 = new JLabel(">");
        
        
        txt2.setFont(txt2.getFont().deriveFont(Font.BOLD, 14f));
        txt00.setForeground(Color.red);
        txt01.setForeground(Color.blue);
        txt10.setForeground(Color.red);
        txt11.setForeground(Color.blue);
        txt20.setForeground(Color.GREEN);
        txt21.setForeground(Color.GREEN);
        
        
        tf = new TextField(18);
        tf.setEditable(false);
        tf.setFocusable(false);
        tf.setBackground(Color.LIGHT_GRAY);
        tf.setFont(new Font("Arial",  Font.BOLD, 16));
        
        
        status = new JTextField(18);
        status.setEditable(false);
        status.setBackground(Color.LIGHT_GRAY);
        status.setHorizontalAlignment(JTextField.CENTER);
        status.setForeground(Color.red);
        status.setFont(new Font("Arial",  Font.BOLD, 14));
        
        
        basePanel.add(txt20);
        basePanel.add(txt01);
        basePanel.add(txt00);
        basePanel.add(txt2);
        basePanel.add(txt10);
        basePanel.add(txt11);
        basePanel.add(txt21);
        basePanel.add(tf);
        
        
        buttonZero = new JButton("0");
        buttonZero.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonZero);
        
        buttonOne = new JButton("1");
        buttonOne.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonOne);
        
        buttonTwo = new JButton("2");
        buttonTwo.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonTwo);
        
        buttonThree = new JButton("3");
        buttonThree.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonThree);
        
        buttonFour = new JButton("4");
        buttonFour.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonFour);
        
        buttonFive = new JButton("5");
        buttonFive.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonFive);
        
        buttonSix = new JButton("6");
        buttonSix.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonSix);
        
        buttonSeven = new JButton("7");
        buttonSeven.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonSeven);
        
        buttonEight = new JButton("8");
        buttonEight.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonEight);
        
        buttonNine = new JButton("9");
        buttonNine.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
        numButtonPanel.add(buttonNine);
        
        
        opButtonClear = new JButton("C");
        opButtonClear.setForeground(Color.white);
        opButtonClear.setBackground(Color.DARK_GRAY);
        numButtonPanel.add(opButtonClear);
        
        opButtonEquals = new JButton("=");
        opButtonEquals.setBorder(BorderFactory.createLineBorder(Color.GRAY, 15));
        opButtonEquals.setForeground(Color.white);
        opButtonEquals.setBackground(Color.GRAY);
        numButtonPanel.add(opButtonEquals);
         
        
        opButtonPlus = new JButton("+");
        opButtonMinus = new JButton("-");
        opButtonDivide = new JButton("/");
        opButtonMultiply = new JButton("*");
        opButtonPower = new JButton("^");
        
        opBracketOpen = new JButton("(");
        opBracketOpen.setForeground(Color.white);
        opBracketOpen.setBackground(Color.getHSBColor(0.7f, 0.7f, 0.2f));
        
        empty = new JButton("        ");
        empty.setForeground(Color.white);
        empty.setBackground(Color.black);
        
        empty1 = new JButton("       ");
        empty1.setForeground(Color.white);
        empty1.setBackground(Color.black);
        
        opBracketClose = new JButton(")");
        opBracketClose.setForeground(Color.white);
        opBracketClose.setBackground(Color.getHSBColor(0.7f, 0.7f, 0.2f));
        

        opButtonPanel.add(opButtonPlus);
        opButtonPanel.add(opButtonMinus);
        opButtonPanel.add(opButtonDivide);
        opButtonPanel.add(opButtonMultiply);
        opButtonPanel.add(opButtonPower);
        
        opButtonPanel2.add(opBracketOpen);
        opButtonPanel2.add(empty);
        opButtonPanel2.add(empty1);
        opButtonPanel2.add(opBracketClose);
        
        
        basePanel.add(numButtonPanel);
        basePanel.add(opButtonPanel);
        basePanel.add(opButtonPanel2);
        basePanel.add(status);
        add(basePanel);
        
        
        HandlerClass handler = new HandlerClass();

        buttonZero.addActionListener(handler);
        buttonOne.addActionListener(handler);
        buttonTwo.addActionListener(handler);
        buttonThree.addActionListener(handler);
        buttonFour.addActionListener(handler);
        buttonFive.addActionListener(handler);
        buttonSix.addActionListener(handler);
        buttonSeven.addActionListener(handler);
        buttonEight.addActionListener(handler);
        buttonNine.addActionListener(handler);

        opButtonPlus.addActionListener(handler);
        opButtonMinus.addActionListener(handler);
        opButtonDivide.addActionListener(handler);
        opButtonMultiply.addActionListener(handler);
        opButtonEquals.addActionListener(handler);
        opButtonClear.addActionListener(handler);
        opBracketOpen.addActionListener(handler);
        opButtonPower.addActionListener(handler);
        opBracketClose.addActionListener(handler);
    }


    private class HandlerClass implements ActionListener
    {
        
        StackOperations stackop = new StackOperations();
        
        public void actionPerformed(ActionEvent e)
        { 
            
            String alreadyDisplayed = tf.getText();
            
            if(e.getSource()==buttonZero)
            {
                String buttonZeroText = alreadyDisplayed + buttonZero.getText();
                tf.setText(buttonZeroText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==buttonOne)
            {
                String buttonOneText = alreadyDisplayed + buttonOne.getText();
                tf.setText(buttonOneText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==buttonTwo)
            {
                String buttonTwoText = alreadyDisplayed + buttonTwo.getText();
                tf.setText(buttonTwoText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==buttonThree)
            {
                String buttonThreeText = alreadyDisplayed + buttonThree.getText();
                tf.setText(buttonThreeText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==buttonFour)
            {
                String buttonFourText = alreadyDisplayed + buttonFour.getText();
                tf.setText(buttonFourText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==buttonFive)
            {
                String buttonFiveText = alreadyDisplayed + buttonFive.getText();
                tf.setText(buttonFiveText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==buttonSix)
            {
                String buttonSixText = alreadyDisplayed + buttonSix.getText();
                tf.setText(buttonSixText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==buttonSeven)
            {
                String buttonSevenText = alreadyDisplayed + buttonSeven.getText();
                tf.setText(buttonSevenText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==buttonEight)
            {
                String buttonEightText = alreadyDisplayed + buttonEight.getText();
                tf.setText(buttonEightText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==buttonNine)
            {
                String buttonNineText = alreadyDisplayed + buttonNine.getText();
                tf.setText(buttonNineText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==opButtonPlus)
            {
                String opButtonPlusText = alreadyDisplayed + opButtonPlus.getText();
                tf.setText(opButtonPlusText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==opButtonMinus)
            {
                String opButtonMinusText = alreadyDisplayed + opButtonMinus.getText();
                tf.setText(opButtonMinusText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==opButtonMultiply)
            {
                String opButtonMultiplyText = alreadyDisplayed + opButtonMultiply.getText();
                tf.setText(opButtonMultiplyText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==opButtonDivide)
            {
                String opButtonDivideText = alreadyDisplayed + opButtonDivide.getText();
                tf.setText(opButtonDivideText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if(e.getSource()==opButtonClear)
            {
                String opButtonClearText = "";
                tf.setText(opButtonClearText);
                alreadyDisplayed = tf.getText();
                status.setText("Screen Cleared");
            }
            else if (e.getSource()==opButtonPower)
            {
                String opButtonPowerText = alreadyDisplayed + opButtonPower.getText();
                tf.setText(opButtonPowerText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if (e.getSource()==opBracketOpen)
            {
                String opButtonCosText = alreadyDisplayed + opBracketOpen.getText();
                tf.setText(opButtonCosText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }
            else if (e.getSource()==opBracketClose)
            {
                String opButtonSquareRootText = alreadyDisplayed + opBracketClose.getText();
                tf.setText(opButtonSquareRootText);
                alreadyDisplayed = tf.getText();
                status.setText(alreadyDisplayed);
            }


            try
            {
                if(e.getSource()==opButtonEquals)
                {

                    int result=0;

                    stackop.inToPost(tf.getText());
                    System.out.println(stackop.output);
                    stackop.calculateResult(stackop.output);

                    result = stackop.result;

                    tf.setText(""+result);
                    status.setText(alreadyDisplayed+" = "+result);
                    stackop.output="";
                    alreadyDisplayed = result+"";
                }
            }
            
            catch(Exception ex)
            {
                tf.setText("");
                status.setText("Enter valid expression!!!");
                
                alreadyDisplayed = "";
                stackop.output="";
            }

        }
    }
}