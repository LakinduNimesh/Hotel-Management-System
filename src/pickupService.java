import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class pickupService extends JFrame implements ActionListener {

    JTable driverTable;
    JButton backBtn,submitBtn;
    Choice carType;
    JCheckBox availble;

    pickupService(){
        setBounds(200,150,1100,600);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/car.jpg"));
        Image Image2 = image1.getImage().getScaledInstance(1100,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(Image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,1100,600);
        add(image);

        JLabel heading = new JLabel("PickUp Service");
        heading.setFont(new Font("Stencil",Font.PLAIN,18));
        heading.setBounds(420,0,1100,80);
        heading.setForeground(Color.BLACK);
        heading.setBackground(Color.DARK_GRAY);
        image.add(heading);

        JLabel CarOptions = new JLabel("Car Type");
        CarOptions .setFont(new Font("Sans-serif",Font.PLAIN,14));
        CarOptions .setForeground(Color.BLACK);
        CarOptions.setBounds(40,100,150,30);
        image.add(CarOptions);


        carType = new Choice();
        carType .setFont(new Font("Sans-serif",Font.PLAIN,14));
        carType .setBackground(Color.WHITE);
        carType .setForeground(Color.BLACK);
        carType .setBounds(190,100,200,30);
        image.add(carType );

        try {
            Conn conn = new Conn();
            ResultSet resultSet =conn.statement.executeQuery( "SELECT * FROM driver");
            while (resultSet.next()){

                carType.add(resultSet.getString("carmodel"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        availble = new JCheckBox("Only Display Available");
        availble  .setFont(new Font("Sans-serif",Font.PLAIN,14));
        availble .setBackground(Color.LIGHT_GRAY);
        availble .setForeground(Color.BLACK);
        availble .setBounds(700,100,300,30);
        image.add(availble );

        driverTable = new JTable();
        driverTable.setFont(new Font("sans-serif",Font.PLAIN,14));
        driverTable.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(driverTable);
        scrollPane.setBounds(0, 150, 1100, 300);
        image.add(scrollPane);

        try {
            Conn conn = new Conn();
            ResultSet resultSet =conn.statement.executeQuery( "SELECT * FROM driver");
            driverTable.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e){
            e.printStackTrace();
        }

        submitBtn = new JButton("Submit");
        submitBtn .setBounds(350,500,150,40);
        submitBtn .setBackground(Color.BLACK);
        submitBtn .setForeground(Color.WHITE);
        submitBtn .setFont(new Font("san-serif",Font.PLAIN,14));
        submitBtn.addActionListener(this);
        image.add(submitBtn);

        backBtn = new JButton("Back");
        backBtn .setBounds(600,500,150,40);
        backBtn .setBackground(Color.ORANGE);
        backBtn .setForeground(Color.BLACK);
        backBtn .setFont(new Font("san-serif",Font.PLAIN,14));
        backBtn.addActionListener(this);
        image.add(backBtn);




        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submitBtn){

            try {

                String sqlQuery1 = "SELECT * FROM driver WHERE carmodel = '"+carType.getSelectedItem()+"'";
                String sqlQuery2 = "SELECT * FROM driver WHERE  available = 'Available' AND carmodel = '"+carType.getSelectedItem()+"'";

                Conn conn = new Conn();
                ResultSet resultSet;
                if (availble.isSelected()){

                    resultSet = conn.statement.executeQuery(sqlQuery2);

                }else {

                    resultSet = conn.statement.executeQuery(sqlQuery1);

                }
                driverTable.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == backBtn) {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {

        new pickupService();
    }

}

