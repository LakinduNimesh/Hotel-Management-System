import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class manager extends JFrame implements ActionListener {

    JTable managerTable;
    JButton backBtn;

    manager(){
        setBounds(200,150,1100,600);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/manager.jpg"));
        Image Image2 = image1.getImage().getScaledInstance(1100,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(Image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,1100,600);
        add(image);

        JLabel managerDetails = new JLabel("Manager Details");
        managerDetails .setFont(new Font("Stencil",Font.PLAIN,18));
        managerDetails .setBounds(450,0,1100,80);
        managerDetails .setForeground(Color.BLACK);
        managerDetails .setBackground(Color.DARK_GRAY);
        image.add(managerDetails );

        managerTable = new JTable();
        managerTable.setFont(new Font("sans-serif", Font.PLAIN, 14));
        managerTable.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(managerTable);
        scrollPane.setBounds(0, 90, 1100, 300);
        image.add(scrollPane);


        try {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM employee WHERE job IN ('General Manager', 'Assistant Manager', 'Marketing Manager');");


            managerTable.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e){
            e.printStackTrace();
        }

        backBtn = new JButton("Back");
        backBtn .setBounds(450,430,150,40);
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
        new manager();
    }

}
