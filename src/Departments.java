import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Departments extends JFrame implements ActionListener {

    JTable departmentTable;
    JButton backBtn;

    Departments(){
        setBounds(300,150,900,600);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/departments.jpg"));
        Image Image2 = image1.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(Image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,900,600);
        add(image);

        JLabel departdetails = new JLabel("Department Details");
        departdetails.setFont(new Font("Stencil",Font.PLAIN,18));
        departdetails.setBounds(350,0,900,80);
        departdetails.setForeground(Color.BLACK);
        departdetails.setBackground(Color.DARK_GRAY);
        image.add(departdetails);

        departmentTable = new JTable();
        departmentTable.setBounds(0,110,900,300);
        departmentTable.setFont(new Font("sans-serif",Font.PLAIN,14));
        departmentTable.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(departmentTable);
        scrollPane.setBounds(0, 90, 900, 300);
        image.add(scrollPane);

        try {
            Conn conn = new Conn();
            ResultSet resultSet =conn.statement.executeQuery( "SELECT * FROM department");
            departmentTable.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e){
            e.printStackTrace();
        }

        backBtn = new JButton("Back");
        backBtn .setBounds(370,430,150,40);
        backBtn .setBackground(Color.BLACK);
        backBtn .setForeground(Color.WHITE);
        backBtn .setFont(new Font("san-serif",Font.PLAIN,14));
        backBtn.addActionListener(this);
        image.add(backBtn);




        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == backBtn){
            new Reception();
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new Departments();
    }
}
