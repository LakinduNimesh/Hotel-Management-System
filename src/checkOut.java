import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class checkOut extends JFrame implements ActionListener {

    Choice customer;
    JLabel nameInput,checkingTime,numberInput,checkOutT;
    JButton backBtn,checkBtn;

    checkOut(){

        setBounds(200,150,1100,600);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/checkin.jpg"));
        Image Image2 = image1.getImage().getScaledInstance(1100,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(Image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,1100,600);
        add(image);

        JLabel heading = new JLabel("CheckOut");
        heading.setFont(new Font("Stencil",Font.PLAIN,18));
        heading.setBounds(420,0,1100,80);
        heading.setForeground(Color.BLACK);
        heading.setBackground(Color.DARK_GRAY);
        image.add(heading);

        JLabel number = new JLabel("Customer ID");
        number .setBounds(40,100,100,30);
        number .setFont(new Font("sans-serif",Font.PLAIN,14));
        number .setForeground(Color.BLACK);
        image.add(number);


        customer = new Choice();
        customer .setBounds(200,100,200,30);
        customer .setFont(new Font("sans-serif",Font.PLAIN,14));
        customer .setForeground(Color.BLACK);
        customer.setBackground(Color.WHITE);
        image.add(customer);

        JLabel roomNum = new JLabel("Room Number");
        roomNum.setBounds(40, 150, 150, 30);
        roomNum.setFont(new Font("sans-serif", Font.PLAIN, 14));
        roomNum.setForeground(Color.BLACK);
        image.add(roomNum);

        numberInput = new JLabel();
        numberInput.setBounds(200,150,250,30);
        numberInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(numberInput);

        JLabel name = new JLabel("Customer Name");
        name.setBounds(40,200,150,30);
        name.setFont(new Font("sans-serif",Font.PLAIN,14));
        name.setForeground(Color.BLACK);
        image.add(name);

        nameInput = new JLabel();
        nameInput.setBounds(200,200,250,30);
        nameInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(nameInput);

        JLabel checkTime = new JLabel("CheckIn Time");
        checkTime .setBounds(40,250,100,30);
        checkTime .setFont(new Font("sans-serif",Font.PLAIN,14));
        checkTime .setForeground(Color.BLACK);
        image.add(checkTime );

        checkingTime = new JLabel();
        checkingTime.setBounds(200,250,200,30);
        checkingTime.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(checkingTime);

        JLabel checkOutTime = new JLabel("CheckOut Time");
        checkOutTime .setBounds(40,300,100,30);
        checkOutTime .setFont(new Font("sans-serif",Font.PLAIN,14));
        checkOutTime .setForeground(Color.BLACK);
        image.add(checkOutTime);

        java.util.Date date = new Date();

        checkOutT = new JLabel("" + date);
        checkOutT.setBounds(200,300,300,30);
        checkOutT.setFont(new Font("sans-serif",Font.PLAIN,14));
        checkOutT .setForeground(Color.BLACK);
        image.add(checkOutT);



        checkBtn = new JButton("CheckOut");
        checkBtn  .setBounds(40,370,150,40);
        checkBtn  .setBackground(Color.BLUE);
        checkBtn  .setForeground(Color.WHITE);
        checkBtn  .setFont(new Font("san-serif",Font.PLAIN,14));
        checkBtn .addActionListener(this);
        image.add(checkBtn );


        backBtn = new JButton("Back");
        backBtn .setBounds(200,370,150,40);
        backBtn .setBackground(Color.ORANGE);
        backBtn .setForeground(Color.BLACK);
        backBtn .setFont(new Font("san-serif",Font.PLAIN,14));
        backBtn.addActionListener(this);
        image.add(backBtn);

        try {

            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM customer");

            while (resultSet.next()){

                customer.add(resultSet.getString("id"));
                numberInput.setText(resultSet.getString("roomNum"));
                nameInput.setText(resultSet.getString("customerName"));
                checkingTime.setText(resultSet.getString("time_and_date"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkBtn){
            String sqlQuery1 = "DELETE FROM customer WHERE id = '"+customer.getSelectedItem()+"'";
            String sqlQuery2 = "UPDATE room SET Availability = 'Available' WHERE roomNumber = '"+numberInput.getText()+"' ";

            try {

                Conn conn = new Conn();
                conn.statement.executeQuery(sqlQuery1);
                conn.statement.executeQuery(sqlQuery2);

                JOptionPane.showMessageDialog(null,"CheckOut successful");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new checkOut();
    }
}
