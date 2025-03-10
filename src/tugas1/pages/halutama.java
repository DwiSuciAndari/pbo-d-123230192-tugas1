
package tugas1.pages;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class halutama extends JFrame{
    JTextField namadpn, namablkg;
    JRadioButton rbpria, rbwanita;
    JButton btnsave, btnconvert;
    JTextArea ta;
    ArrayList<String> datalist;

    public halutama(){
        setTitle("Halaman Utama");
        setSize(500, 400);

        JLabel lblnamadpn = new JLabel("Nama Depan:");
        namadpn = new JTextField();
        JLabel lblnamablkg = new JLabel("Nama Belakang:");
        namablkg = new JTextField();
        JLabel lblgender = new JLabel("Jenis Kelamin:");
        rbpria = new JRadioButton("Pria");
        rbwanita = new JRadioButton("Wanita");
        ButtonGroup grupgender = new ButtonGroup();
        btnsave = new JButton("Simpan");
        btnconvert = new JButton("Convert to .txt File");
        ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);

        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        lblnamadpn.setBounds(50, 15, 100, 20);
        namadpn.setBounds(40, 40, 200, 20);
        lblnamablkg.setBounds(250, 15, 100, 20);
        namablkg.setBounds(240, 40, 200, 20);
        lblgender.setBounds(190, 70, 100, 20);
        rbpria.setBounds(165, 90, 60, 20);
        rbwanita.setBounds(250, 90, 80, 20);
        btnsave.setBounds(165, 120, 150, 30);
        sp.setBounds(50, 170, 390, 155);
        btnconvert.setBounds(165, 330, 150, 30);

        
          grupgender.add(rbpria);
        grupgender.add(rbwanita);
        add(lblnamadpn);
        add(namadpn);
        add(lblnamablkg);
        add(namablkg);
        add(lblgender);
        add(rbpria);
        add(rbwanita);
        add(btnsave);
        add(sp);
        add(btnconvert);

        datalist = new ArrayList<>();

        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = namadpn.getText();
                String lastName = namablkg.getText();
                String gender = "";

                if (rbpria.isSelected()) {
                    gender = "Pria";
                } else if (rbwanita.isSelected()) {
                    gender = "Wanita";
                }

                 if (firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(halutama.this, "Data belum lengkap!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String data = firstName + " " + lastName + " | Gender : " + gender;
                    datalist.add(data);
                    ta.append(data + "\n");
                    
                    namadpn.setText("");
                    namablkg.setText("");
                }
            }
        });
 btnconvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (datalist.isEmpty()) {
                    JOptionPane.showMessageDialog(halutama.this, "Belum ada data yang dimasukkan!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try (FileWriter writer = new FileWriter("data_123230192.txt")) {
                        for (int i = 0; i < datalist.size(); i++) {
                            writer.write(datalist.get(i) + "\n");
                        }
                        JOptionPane.showMessageDialog(halutama.this, "Data berhasil disimpan ke data_123230192.txt");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(halutama.this, "Gagal menyimpan data!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
}
}

