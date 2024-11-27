import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheckOut extends JFrame implements ActionListener {

    Choice customer;
    JTextField nameInput,numberInput,checkingTime,amountPaidPrice,amountpendingPrice ;
    JButton checkBtn,UpdateBtn,backBtn;

    UpdateCheckOut(){
        setBounds(200,150,1100,600);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/checkin.jpg"));
        Image Image2 = image1.getImage().getScaledInstance(1100,900,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(Image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,1100,600);
        add(image);

        JLabel updateStatus = new JLabel("Update Status");
        updateStatus.setFont(new Font("Stencil",Font.PLAIN,18));
        updateStatus.setBounds(450,0,1100,80);
        updateStatus.setForeground(Color.BLACK);
        updateStatus.setBackground(Color.DARK_GRAY);
        image.add(updateStatus);

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

        JLabel name = new JLabel("Customer Name");
        name.setBounds(40,200,150,30);
        name.setFont(new Font("sans-serif",Font.PLAIN,14));
        name.setForeground(Color.BLACK);
        image.add(name);

        nameInput = new JTextField();
        nameInput.setBounds(200,200,200,30);
        nameInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(nameInput);

        JLabel checkTime = new JLabel("Checking Time");
        checkTime .setBounds(40,250,100,30);
        checkTime .setFont(new Font("sans-serif",Font.PLAIN,14));
        checkTime .setForeground(Color.BLACK);
        image.add(checkTime );

        checkingTime = new JTextField();
        checkingTime.setBounds(200,250,200,30);
        checkingTime.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(checkingTime);

        JLabel amountPaid = new JLabel("Paid Amount");
        amountPaid .setBounds(40,300,100,30);
        amountPaid .setFont(new Font("sans-serif",Font.PLAIN,14));
        amountPaid .setForeground(Color.BLACK);
        image.add(amountPaid );

        amountPaidPrice = new JTextField();
        amountPaidPrice .setBounds(200,300,200,30);
        amountPaidPrice .setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(amountPaidPrice );

        JLabel amountPending = new JLabel("Pending Amount");
        amountPending  .setBounds(40,350,150,30);
        amountPending  .setFont(new Font("sans-serif",Font.PLAIN,14));
        amountPending .setForeground(Color.BLACK);
        image.add(amountPending  );

        amountpendingPrice = new JTextField();
        amountpendingPrice .setBounds(200,350,200,30);
        amountpendingPrice .setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(amountpendingPrice);

        checkBtn = new JButton("Check");
        checkBtn  .setBounds(40,420,150,40);
        checkBtn  .setBackground(Color.BLUE);
        checkBtn  .setForeground(Color.WHITE);
        checkBtn  .setFont(new Font("san-serif",Font.PLAIN,14));
        checkBtn .addActionListener(this);
        image.add(checkBtn );

        UpdateBtn = new JButton("Submit");
        UpdateBtn  .setBounds(230,420,150,40);
        UpdateBtn .setBackground(Color.BLACK);
        UpdateBtn  .setForeground(Color.WHITE);
        UpdateBtn  .setFont(new Font("san-serif",Font.PLAIN,14));
        UpdateBtn .addActionListener(this);
        image.add(UpdateBtn );

        backBtn = new JButton("Back");
        backBtn .setBounds(430,420,150,40);
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
                    nameInput.setText(resultSet.getString("customerName"));
                    checkingTime.setText(resultSet.getString("time_and_date"));
                    amountPaidPrice.setText(resultSet.getString("deposit"));
                }

                ResultSet resultSet1 = conn.statement.executeQuery("SELECT * FROM room WHERE roomNumber = '"+numberInput.getText()+"'");

                while (resultSet1.next()){
                    String price = resultSet1.getString("price");

                    Integer amountpaid = Integer.parseInt(price) - Integer.parseInt(amountPaidPrice.getText());
                    amountpendingPrice.setText("" + amountpaid);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == UpdateBtn) {

            String id = customer.getSelectedItem();
            String room = numberInput.getText();
            String name = nameInput.getText();
            String checkIn = checkingTime.getText();
            String deposit = amountPaidPrice.getText();

            try {

                Conn conn = new Conn();

                conn.statement.executeUpdate(
                        "UPDATE customer SET customerName = '" + name + "', roomNum = '" + room + "', time_and_date = '" + checkIn + "', deposit = '" + deposit + "' WHERE id = '" + id + "';"
                );

                JOptionPane.showMessageDialog(null,"Data added successfully");
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
        new UpdateCheckOut();
    }
}
