/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package interpret;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import interpret.containers.MainFrame;

public class Index {
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
         JFrame mainFrame = new MainFrame();

         //Windowサイズを調整
         mainFrame.pack();
         mainFrame.setLocationRelativeTo(null);

         //表示
         mainFrame.setVisible(true);
     }
}
