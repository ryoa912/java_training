/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret.todo;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingAppMain {
	/**
     * アプリケーションの起動
     */
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowTodoList();
             }
         });
     }
     /**
     * ToDoリストの生成と表示を行います。
     */
     private static void createAndShowTodoList() {
         JFrame mainFrame = new JFrame("ToDoリスト");
         mainFrame.setDefaultCloseOperation
         (JFrame.EXIT_ON_CLOSE);
         Container contentPane = mainFrame.getContentPane();
         // ToDoリストを生成
         JComponent newContentPane = new ToDoListPane();
         contentPane.add(newContentPane, BorderLayout.CENTER);
         // Windowサイズを調整
         mainFrame.pack();
         // 表示
         mainFrame.setVisible(true);
     }
}
