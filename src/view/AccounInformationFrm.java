/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.registerCtl;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import model.person;

/**
 *
 * @author Admin
 */
public class AccounInformationFrm extends javax.swing.JFrame {

    /**
     * Creates new form AccounInformationFrm
     */
    registerCtl rg = registerCtl.getinstance();
    public AccounInformationFrm() {
        initComponents();
        this.setSize(1215, 730);
        this.setTitle("Register");
        this.setLocationRelativeTo(null);
        setBtn();
    }
    
    public boolean checkBlankField() // Kiểm tra các trường nhập có rỗng hay không?
    {
        return txtName.getText().trim().equals("") || txtAddress.getText().trim().equals("") || txtTelephone.getText().trim().equals("")
                || txtEmail.getText().trim().equals(""); 
    }
    
        public boolean checkPhone(String str){
        // Bieu thuc chinh quy mo ta dinh dang so dien thoai
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";   
        return str.matches(reg);
    }
    
    public void announcement(String str) // Thông báo
    {
        JOptionPane.showMessageDialog(null, str);
    }
    public void setBtnNoBorder(JToggleButton button)
    {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // Especially important
    }
    
    public void setBtn()
    {
        setBtnNoBorder(btnBack);
        setBtnNoBorder(btnRegister);
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnBack = new javax.swing.JToggleButton();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtTelephone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnRegister = new javax.swing.JToggleButton();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(0, 20, 90, 70);

        txtName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(txtName);
        txtName.setBounds(210, 120, 380, 70);

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(txtAddress);
        txtAddress.setBounds(210, 300, 380, 70);

        txtTelephone.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(txtTelephone);
        txtTelephone.setBounds(210, 410, 380, 70);

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(txtEmail);
        txtEmail.setBounds(210, 510, 380, 70);

        btnRegister.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister);
        btnRegister.setBounds(260, 610, 190, 60);

        rdNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdNam);
        rdNam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(rdNam);
        rdNam.setBounds(230, 230, 25, 40);

        rdNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdNu);
        rdNu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(rdNu);
        rdNu.setBounds(395, 230, 25, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ACCOUNT'S INFORMATION (1).png"))); // NOI18N
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        RegisterFrm a = new RegisterFrm();
        a.setVisible(true);
        a.setTitle("Register");
        a.setLocationRelativeTo(null);
        a.setField(rg.getPerson().getUusername(), rg.getPerson().getUpassword());
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if(!checkBlankField())  
        {
            String name = txtName.getText();
            String gender = rdNam.isSelected()?"Nam":"Nữ";
            String address = txtAddress.getText();
            String telephone = txtTelephone.getText();
            String email = txtEmail.getText();
            if(checkPhone(telephone))
            {
                rg.setInfo(name, gender, address, telephone, email);
                rg.addPerson();
                announcement("Sucessfully");
                this.dispose();
                new LoginFrm();
            }
            else
            {
                announcement("Wrong format of phone number");
                txtTelephone.setText("");
            }
        }
        else
        {
            announcement("Must have complete all fields ");
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(AccounInformationFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccounInformationFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccounInformationFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccounInformationFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccounInformationFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JToggleButton btnRegister;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
