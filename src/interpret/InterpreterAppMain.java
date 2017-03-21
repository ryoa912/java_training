/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class InterpreterAppMain {
	/**
     * アプリケーションの起動
     */
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
            	 createAndShowWindow();
             }
         });
     }
     /**
     * ウィンドウの生成と表示を行う。
     */
     private static void createAndShowWindow() {
         JFrame mainFrame = new JFrame("InterpreterApp");

         mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Container contentPane = mainFrame.getContentPane();

         //ウィンドウを生成
         JComponent newContentPane = new InterpreterAppPane();
         contentPane.add(newContentPane, BorderLayout.CENTER);

         //Windowサイズを調整
         mainFrame.pack();

         //表示
         mainFrame.setVisible(true);
     }
}