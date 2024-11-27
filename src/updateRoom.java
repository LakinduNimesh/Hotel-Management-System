import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateRoom extends JFrame implements ActionListener {

    Choice customer;
    JTextField numberInput ;
    JButton checkBtn,UpdateBtn,backBtn;
    JComboBox availabilityInput,RoomStatus;

    updateRoom(){
        setBounds(200,150,1100,600);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/uproom.jpg"));
        Image Image2 = image1.getImage().getScaledInstance(1100,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(Image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,1100,600);
        add(image);

        JLabel heading = new JLabel("Update Room Status");
        heading.setFont(new Font("Stencil",Font.PLAIN,18));
        heading.setBounds(420,0,1100,80);
        heading.setForeground(Color.BLACK);
        heading.setBackground(Color.DARK_GRAY);
        image.add(heading);

        JLabel number = new JLabel("Number");
        number .setBounds(40,100,100,30);
        number .setFont(new Font("sans-serif",Font.PLAIN,14));
        number .setForeground(Color.BLACK);
        image.add(number );

        customer = new Choice();
        customer .setBounds(200,100,200,30);
        customer .setFont(new Font("sans-serif",Font.PLAIN,14));
        customer .setForeground(Color.BLACK);
        customer.setBackground(Color.WHITE);
        image.add(customer);

        try {

            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM customer");

            while (resultSet.next()){

                customer.add(resultSet.getString("id"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel roomNum = new JLabel("Room Number");
        roomNum.setBounds(40, 150, 150, 30);
        roomNum.setFont(new Font("sans-serif", Font.PLAIN, 14));
        roomNum.setForeground(Color.BLACK);
        image.add(roomNum);

        numberInput = new JTextField();
        numberInput.setBounds(200,150,200,30);
        numberInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(numberInput);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(40,200,150,30);
        availability.setFont(new Font("sans-serif",Font.PLAIN,14));
        availability.setForeground(Color.BLACK);
        image.add(availability);

        String[] availableType = { null,"Available","Occupied"};
        availabilityInput = new JComboBox<>(availableType);
        availabilityInput.setBounds(200,200,200,30);
        availabilityInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(availabilityInput);

        JLabel roomStatus = new JLabel("Room Status");
        roomStatus .setBounds(40,250,100,30);
        roomStatus .setFont(new Font("sans-serif",Font.PLAIN,14));
        roomStatus .setForeground(Color.BLACK);
        image.add(roomStatus );

        String[] statusType = { null,"Cleaned","Dirty"};
        RoomStatus = new JComboBox(statusType);
        RoomStatus.setBounds(200,250,200,30);
        RoomStatus.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(RoomStatus);



        checkBtn = new JButton("Check");
        checkBtn  .setBounds(40,320,150,40);
        checkBtn  .setBackground(Color.BLUE);
        checkBtn  .setForeground(Color.WHITE);
        checkBtn  .setFont(new Font("san-serif",Font.PLAIN,14));
        checkBtn .addActionListener(this);
        image.add(checkBtn );

        UpdateBtn = new JButton("Submit");
        UpdateBtn  .setBounds(230,320,150,40);
        UpdateBtn .setBackground(Color.BLACK);
        UpdateBtn  .setForeground(Color.WHITE);
        UpdateBtn  .setFont(new Font("san-serif",Font.PLAIN,14));
        UpdateBtn .addActionListener(this);
        image.add(UpdateBtn );

        backBtn = new JButton("Back");
        backBtn .setBounds(430,320,150,40);
        backBtn .setBackground(Color.ORANGE);
        backBtn .setForeground(Color.BLACK);
        backBtn .setFont(new Font("san-serif",Font.PLAIN,14));
        backBtn.addActionListener(this);
        image.add(backBtn);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == checkBtn){

            String id = customer.getSelectedItem();
            String sqlQuery = "SELECT * FROM customer where id = '"+id+"'";

            try {

                Conn conn = new Conn();
                ResultSet resultSet = conn.statement.executeQuery(sqlQuery);

                while (resultSet.next()){
                    numberInput.setText(resultSet.getString("roomNum"));


                }

                ResultSet resultSet1 = conn.statement.executeQuery("SELECT * FROM room WHERE roomNumber = '"+numberInput.getText()+"'");

                while (resultSet1.next()){
                    availabilityInput.setSelectedItem(resultSet1.getString("Availability"));
                    RoomStatus.setSelectedItem(resultSet1.getString("CleanStatus"));
                }



            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == UpdateBtn) {

            String roomnumber = numberInput.getText();
            String availbility = availabilityInput.getSelectedItem().toString();
            String roomStatus = RoomStatus.getSelectedItem().toString();

            try {

                Conn conn = new Conn();

                conn.statement.executeUpdate(
                        "UPDATE room SET CleanStatus = '"+roomStatus+"', Availability = '"+availbility+"' WHERE roomNumber = '" + roomnumber + "';"
                );

                JOptionPane.showMessageDialog(null,"Status Updated successfully");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == backBtn) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new updateRoom();
    }
}
