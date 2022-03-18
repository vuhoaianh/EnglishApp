/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.gameSelectWordCtl;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 *
 * @author hoaianh_Kyros
 */
public class gameSelectWordFrm extends javax.swing.JFrame {

    /**
     * Creates new form gameSelection
     */
    int score = 0;
    int heart = 3;
    int timeLeft = 300;
    Timer timer;
    String str1 = null;
    ArrayList <String> randomWordList;
    ArrayList <JButton> buttonList = new ArrayList<>();
    gameSelectWordCtl gameCtl = new gameSelectWordCtl();
    public gameSelectWordFrm() {
        initComponents();
        this.setSize(1210, 680); // Kích cỡ
        this.setVisible(true);// Hiển thị Jframe
        this.setTitle("Game select word"); // Tiêu đề
        this.setLocationRelativeTo(null); // Hiển thị ở chính giữa màn hình
        this.setJlable2();
        JlableName.setText(gameCtl.getNamePerson());
        JlableScore.setText("0 point");
        setBtnNoBorder();
        Time();
        randomWordList = gameCtl.getRandomWordList();
        setGame();
        
    }
    public void setJlable2()
    {
        Image image = new ImageIcon(getClass().getResource(
                "/image/HELLO.gif")).getImage();
        Icon icon = new ImageIcon(image.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT));
        jLabel2.setIcon(icon);
    }
    public void setBtnNoBorder() {// Xóa viền button
        btnBack.setOpaque(false);
        btnBack.setFocusPainted(false);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Especially important
    }

    public String displayTime(int timeLeft) // HIển thị thời gian theo phút và giây
    {
        int minutes = 0, seconds = 0;
        minutes = timeLeft / 60;
        seconds = timeLeft%60;
        if(seconds <= 9)
            return minutes + ":0" + seconds;
        return minutes + ":" + seconds;
    }
    public void Time()// Set up thời gian 300s
    { 
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(timeLeft == 0)
                {
                    JOptionPane.showMessageDialog(rootPane, "Overtime. You have " + score + " points");
                    timer.stop();
                    dispose();
                    new GameHomeFrm();
                }
                else
                {
                    lableTime.setText(displayTime(timeLeft));
                    timeLeft--;
                }
            }
        });
        if(heart != 0)
        {
            timer.start();
        }
    }
    public void setTextButton(JButton btn)// Random vị trí các từ vựng vào các button 
    {
        Random general = new Random();
        int randonIndex = general.nextInt(randomWordList.size());
        btn.setText(randomWordList.get(randonIndex));
        randomWordList.remove(randomWordList.get(randonIndex));
    }
   
    public void setGame()
    {
        setTextButton(btn1);
        setTextButton(btn2);
        setTextButton(btn3);
        setTextButton(btn4);
        setTextButton(btn5);
        setTextButton(btn6);
        setTextButton(btn7);
        setTextButton(btn8);
        setTextButton(btn9);
        setTextButton(btn10);
        setTextButton(btn11);
        setTextButton(btn12);
        setTextButton(btn13);
        setTextButton(btn14);
        setTextButton(btn15);
        setTextButton(btn16);
        setTextButton(btn17);
        setTextButton(btn18);
        setTextButton(btn19);
        setTextButton(btn20);
    }
    public void setHeart()// trừ mạng khi chọn cặp sai
    {
        if(heart == 2)
        {
            this.LableHeart1.setVisible(false);
        }
        else if(heart == 1)
        {
            this.LableHeart2.setVisible(false);
        }
        else
        {
             this.LableHeart3.setVisible(false);
             timer.stop();
             JOptionPane.showMessageDialog(null, "You have " + score + " points");
             this.dispose();
             new GameHomeFrm();
        }
    }
    public void check(JButton bt) // Kiểm tra hai lần chọn
    {
        if(buttonList.size() == 0) // Button chọn lần 1
        {
            bt.setBackground(Color.YELLOW);
            buttonList.add(bt);
        }
        else // Button chọn lần 2
        {
            bt.setBackground(Color.YELLOW);
            if(gameCtl.checkCorrectSelection(buttonList.get(0).getText()
                    , bt.getText())) // Nếu chọn đáp án đúng
            {
                buttonList.get(0).setVisible(false);
                bt.setVisible(false);
                score += 10;
                this.JlableScore.setText(score + " points");
                if(score == 100)
                {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Congratulations! You have 100 points");
                    this.dispose();
                    new GameHomeFrm();
                }
            }
            else // Trường hợp chưa đúng
            {
                if(bt.getText().equals(buttonList.get(0).getText())) //Ấn cùng một button
                {
                    bt.setBackground(Color.WHITE);
                }
                else
                {
                    buttonList.get(0).setBackground(Color.WHITE); //Ấn hai button khác nhau
                    bt.setBackground(Color.WHITE);
                    heart--;
                    this.setHeart();
                }
            }
                buttonList.remove(buttonList.get(0)); //Loại button lần chọn 1 ra khỏi listButton
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JlableScore = new javax.swing.JLabel();
        JlableName = new javax.swing.JLabel();
        LableHeart1 = new javax.swing.JLabel();
        LableHeart3 = new javax.swing.JLabel();
        LableHeart2 = new javax.swing.JLabel();
        lableTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 10, 95, 100);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(4, 5));

        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1);

        btn2.setBackground(new java.awt.Color(255, 255, 255));
        btn2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2);

        btn3.setBackground(new java.awt.Color(255, 255, 255));
        btn3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3);

        btn4.setBackground(new java.awt.Color(255, 255, 255));
        btn4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4);

        btn5.setBackground(new java.awt.Color(255, 255, 255));
        btn5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn5);

        btn6.setBackground(new java.awt.Color(255, 255, 255));
        btn6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6);

        btn7.setBackground(new java.awt.Color(255, 255, 255));
        btn7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel2.add(btn7);

        btn8.setBackground(new java.awt.Color(255, 255, 255));
        btn8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel2.add(btn8);

        btn9.setBackground(new java.awt.Color(255, 255, 255));
        btn9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel2.add(btn9);

        btn10.setBackground(new java.awt.Color(255, 255, 255));
        btn10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        jPanel2.add(btn10);

        btn11.setBackground(new java.awt.Color(255, 255, 255));
        btn11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });
        jPanel2.add(btn11);

        btn12.setBackground(new java.awt.Color(255, 255, 255));
        btn12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });
        jPanel2.add(btn12);

        btn13.setBackground(new java.awt.Color(255, 255, 255));
        btn13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });
        jPanel2.add(btn13);

        btn14.setBackground(new java.awt.Color(255, 255, 255));
        btn14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn14ActionPerformed(evt);
            }
        });
        jPanel2.add(btn14);

        btn15.setBackground(new java.awt.Color(255, 255, 255));
        btn15.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn15ActionPerformed(evt);
            }
        });
        jPanel2.add(btn15);

        btn16.setBackground(new java.awt.Color(255, 255, 255));
        btn16.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn16ActionPerformed(evt);
            }
        });
        jPanel2.add(btn16);

        btn17.setBackground(new java.awt.Color(255, 255, 255));
        btn17.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn17ActionPerformed(evt);
            }
        });
        jPanel2.add(btn17);

        btn18.setBackground(new java.awt.Color(255, 255, 255));
        btn18.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn18ActionPerformed(evt);
            }
        });
        jPanel2.add(btn18);

        btn19.setBackground(new java.awt.Color(255, 255, 255));
        btn19.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn19ActionPerformed(evt);
            }
        });
        jPanel2.add(btn19);

        btn20.setBackground(new java.awt.Color(255, 255, 255));
        btn20.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });
        jPanel2.add(btn20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(320, 215, 870, 410);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ys.jpg")));
        jLabel2.setText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(320, 215, 870, 410);

        JlableScore.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getContentPane().add(JlableScore);
        JlableScore.setBounds(130, 180, 180, 40);

        JlableName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getContentPane().add(JlableName);
        JlableName.setBounds(90, 120, 220, 40);

        LableHeart1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        LableHeart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/HEARTICOn.png"))); // NOI18N
        getContentPane().add(LableHeart1);
        LableHeart1.setBounds(230, 230, 60, 40);

        LableHeart3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        LableHeart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/HEARTICOn.png"))); // NOI18N
        getContentPane().add(LableHeart3);
        LableHeart3.setBounds(130, 230, 60, 40);

        LableHeart2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        LableHeart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/HEARTICOn.png"))); // NOI18N
        getContentPane().add(LableHeart2);
        LableHeart2.setBounds(180, 230, 60, 40);

        lableTime.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getContentPane().add(lableTime);
        lableTime.setBounds(1050, 130, 100, 40);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/GAMESELECTWORD123.png"))); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new VocabularyGameFrm();
        timer.stop();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        check(btn1);

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        check(btn2);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
       check(btn3);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        check(btn4);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
       check(btn5);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        check(btn6);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        check(btn7);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        check(btn8);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
       check(btn9);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        check(btn10);
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        check(btn11);
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        check(btn12);
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        check(btn13);
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn14ActionPerformed
       check(btn14);
    }//GEN-LAST:event_btn14ActionPerformed

    private void btn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn15ActionPerformed
        check(btn15);
    }//GEN-LAST:event_btn15ActionPerformed

    private void btn16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn16ActionPerformed
        check(btn16);
    }//GEN-LAST:event_btn16ActionPerformed

    private void btn17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn17ActionPerformed
        check(btn17);
    }//GEN-LAST:event_btn17ActionPerformed

    private void btn18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn18ActionPerformed
        check(btn18);
    }//GEN-LAST:event_btn18ActionPerformed

    private void btn19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn19ActionPerformed
       check(btn19);
    }//GEN-LAST:event_btn19ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        check(btn20);
    }//GEN-LAST:event_btn20ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gameSelectWordFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gameSelectWordFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gameSelectWordFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gameSelectWordFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gameSelectWordFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlableName;
    private javax.swing.JLabel JlableScore;
    private javax.swing.JLabel LableHeart1;
    private javax.swing.JLabel LableHeart2;
    private javax.swing.JLabel LableHeart3;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lableTime;
    // End of variables declaration//GEN-END:variables
}
