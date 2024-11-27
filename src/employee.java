import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class employee extends JFrame implements ActionListener {

    JTable roomTable;
    JButton backBtn;

    employee(){
        setBounds(200,150,1100,620);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/Employee.jpg"));
        Image Image2 = image1.getImage().getScaledInstance(1100,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(Image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,1100,620);
        add(image);

        JLabel employeeDetails = new JLabel("Employee Details");
        employeeDetails.setFont(new Font("Stencil",Font.PLAIN,18));
        employeeDetails.setBounds(450,0,1100,80);
        employeeDetails.setForeground(Color.BLACK);
        employeeDetails.setBackground(Color.DARK_GRAY);
        image.add(employeeDetails);

        roomTable = new JTable();
        roomTable.setFont(new Font("sans-serif", Font.PLAIN, 14));
        roomTable.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(roomTable);
        scrollPane.setBounds(0, 110, 1100, 400);
        image.add(scrollPane);


        try {
            Conn conn = new Conn();
            ResultSet resultSet =conn.statement.executeQuery( "SELECT * FROM employee");
            roomTable.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e){
            e.printStackTrace();
        }

        backBtn = new JButton("Back");
        backBtn .setBounds(450,520,150,40);
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
        new employee();
    }

}
