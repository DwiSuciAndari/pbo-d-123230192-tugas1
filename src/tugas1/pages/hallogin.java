
package tugas1.pages;

import javax.swing.*;
import java.awt.event.*;

public class hallogin extends JFrame {
    JTextField user;
    JPasswordField pass;
    JButton btnlogin;

    public hallogin() {
        setTitle("Halaman Login");
        setSize(400, 200); 
        
        JLabel lbluser = new JLabel("Username:");
        user = new JTextField();
        JLabel lblpass = new JLabel("Password:");
        pass = new JPasswordField();
        btnlogin = new JButton("Login");
        
        lbluser.setBounds(20, 20, 80, 20);
        user.setBounds(100, 20, 200, 20);
        lblpass.setBounds(20, 50, 80, 20);
        pass.setBounds(100, 50, 200, 20);
        btnlogin.setBounds(150, 100, 100, 40);

        add(lbluser);
        add(user);
        add(lblpass);
        add(pass);
        add(btnlogin);

btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = user.getText();
                String password = new String(pass.getPassword());

                if (username.equalsIgnoreCase("pbo") && password.equalsIgnoreCase("if-d")) {
                    JOptionPane.showMessageDialog(hallogin.this, "Login Berhasil!");
                    new halutama().setVisible(true);
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(hallogin.this, "Gagal Login", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setLayout(null);
                setVisible(true);

}
}
