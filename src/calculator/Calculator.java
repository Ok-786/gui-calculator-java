//Made by:  M.Ali Altaf(007) , Muhammad Affan Butt(021, Muhammad Osama Nawaz(027) 



package calculator;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.Toolkit.*;
import javax.swing.JFrame;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OK-786 productions
 */


public class Calculator
{
    public static void main(String[] args) 
    {
         Operations display=new Operations();
         
         display.setSize(235,295);
         display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         display.setVisible(true);
    }
}