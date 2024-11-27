import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class searchRoom extends JFrame implements ActionListener {

    JTable roomTable;
    JButton backBtn,submitBtn;
    JComboBox bedType;
    JCheckBox availble;

    searchRoom(){
        setBounds(200,150,1100,600);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/roomWallpaper.jpg"));
        Image Image2 = image1.getImage().getScaledInstance(1100,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(Image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,1100,600);
        add(image);

        JLabel roomdetails = new JLabel("Search For Rooms");
        roomdetails.setFont(new Font("Stencil",Font.PLAIN,18));
        roomdetails.setBounds(450,0,1100,80);
        roomdetails.setForeground(Color.BLACK);
        roomdetails.setBackground(Color.DARK_GRAY);
        image.add(roomdetails);

        JLabel bedOptions = new JLabel("Bed Type");
        bedOptions .setFont(new Font("Sans-serif",Font.PLAIN,14));
        bedOptions .setForeground(Color.BLACK);
        bedOptions.setBounds(40,100,150,30);
        image.add(bedOptions );

        String[] BedOptions = {null,"Single", "Double","Triple"};
        bedType = new JComboBox<>(BedOptions);
        bedType  .setFont(new Font("Sans-serif",Font.PLAIN,14));
        bedType.setBackground(Color.WHITE);
        bedType.setForeground(Color.BLACK);
        bedType.setBounds(190,100,200,30);
        image.add(bedType);

        availble = new JCheckBox("Only Display Available");
        availble  .setFont(new Font("Sans-serif",Font.PLAIN,14));
        availble .setBackground(Color.LIGHT_GRAY);
        availble .setForeground(Color.BLACK);
        availble .setBounds(700,100,300,30);
        image.add(availble );

        roomTable = new JTable();
        roomTable.setFont(new Font("sans-serif",Font.PLAIN,14));
        roomTable.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(roomTable);
        scrollPane.setBounds(0, 150, 1100, 300);
        image.add(scrollPane);

        try {
            Conn conn = new Conn();
            ResultSet resultSet =conn.statement.executeQuery( "SELECT * FROM room");
            roomTable.setModel(DbUtils.resultSetToTableModel(resultSet));

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

                String sqlQuery1 = "SELECT * FROM room WHERE bedType = '"+bedType.getSelectedItem()+"'";
                String sqlQuery2 = "SELECT * FROM room WHERE  Availability = 'Available' AND bedType = '"+bedType.getSelectedItem()+"'";

                Conn conn = new Conn();
                ResultSet resultSet;
                if (availble.isSelected()){

                    resultSet = conn.statement.executeQuery(sqlQuery2);

                }else {

                    resultSet = conn.statement.executeQuery(sqlQuery1);

                }
                roomTable.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == backBtn) {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new searchRoom();
    }

}
