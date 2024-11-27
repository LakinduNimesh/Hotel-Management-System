import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField nameInput,numberInput,countryInput,depositInput;
    JRadioButton male , female;
    JComboBox idTypo,bedType;
    JButton addBtn,backBtn;
    Choice choiceRoom;
    JLabel checkingTime;

    AddCustomer(){
        setBounds(350,100,900,650);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(getClass().getResource("/images/customer.jpg"));
        Image image2 = image1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0, 0, 900, 650);
        add(image);

        JLabel heading = new JLabel("New Customer Form");
        heading.setFont(new Font("Stencil",Font.PLAIN,20));
        heading.setForeground(Color.BLACK);
        heading.setBounds(300,20,300,30);
        image.add(heading);

        JLabel idtype = new JLabel("ID");
        idtype.setBounds(40,70,100,30);
        idtype.setFont(new Font("sans-serif",Font.PLAIN,14));
        idtype.setForeground(Color.BLACK);
        image.add(idtype);

        String[] idType = { null,"NIC", "Passport", "Driving License", "Voter ID", "Employee ID" };
        idTypo = new JComboBox<>(idType);
        idTypo.setBounds(180,70,200,30);
        idTypo.setFont(new Font("sans-serif",Font.PLAIN,13));
        idTypo.setForeground(Color.BLACK);
        idTypo.setBackground(Color.white);
        image.add(idTypo);

        JLabel number = new JLabel("Number");
        number .setBounds(40,120,100,30);
        number .setFont(new Font("sans-serif",Font.PLAIN,14));
        number .setForeground(Color.BLACK);
        image.add(number );

        numberInput = new JTextField();
        numberInput.setBounds(180,120,200,30);
        numberInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(numberInput);

        JLabel name = new JLabel("Name");
        name.setBounds(40,170,100,30);
        name.setFont(new Font("sans-serif",Font.PLAIN,14));
        name.setForeground(Color.BLACK);
        image.add(name);

        nameInput = new JTextField();
        nameInput.setBounds(180,170,200,30);
        nameInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(nameInput);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(40,220,100,30);
        gender.setFont(new Font("sans-serif",Font.PLAIN,14));
        gender.setForeground(Color.BLACK);
        image.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(180,220,90,30);
        male.setFont(new Font("sans-serif",Font.PLAIN,13));
        image.add(male);

        female = new JRadioButton("Female");
        female.setBounds(270,220,110,30);
        female.setFont(new Font("sans-serif",Font.PLAIN,13));
        image.add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel country = new JLabel("Country");
        country.setBounds(40,270,100,30);
        country.setFont(new Font("sans-serif",Font.PLAIN,14));
        country.setForeground(Color.BLACK);
        image.add(country);

        countryInput = new JTextField();
        countryInput.setBounds(180,270,200,30);
        countryInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(countryInput);

        JLabel bedOptions = new JLabel("Bed Type");
        bedOptions.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        bedOptions.setForeground(Color.BLACK);
        bedOptions.setBounds(40, 320, 150, 30);
        image.add(bedOptions);

        String[] BedOptions = {null, "Single", "Double", "Triple"};
        bedType = new JComboBox<>(BedOptions);
        bedType.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        bedType.setBackground(Color.WHITE);
        bedType.setForeground(Color.BLACK);
        bedType.setBounds(180, 320, 200, 30);
        image.add(bedType);

        JLabel roomNum = new JLabel("Room Num");
        roomNum.setBounds(40, 370, 100, 30);
        roomNum.setFont(new Font("sans-serif", Font.PLAIN, 14));
        roomNum.setForeground(Color.BLACK);
        image.add(roomNum);

        choiceRoom = new Choice();
        choiceRoom.setBounds(180, 370, 200, 40);
        image.add(choiceRoom);


        bedType.addActionListener(e -> {
            choiceRoom.removeAll();
            String selectedBedType = (String) bedType.getSelectedItem();

            if (selectedBedType != null && !selectedBedType.isEmpty()) {
                try {
                    Conn conn = new Conn();
                    String sqlquery = "SELECT * FROM room WHERE Availability = 'Available' AND bedType = '" + selectedBedType + "'";
                   // System.out.println("Executing Query: " + sqlquery); // Debugging

                    ResultSet resultSet = conn.statement.executeQuery(sqlquery);

                    // Populate room numbers in choiceRoom
                    while (resultSet.next()) {
                        String roomNumber = resultSet.getString("roomNumber");
                       // System.out.println("Available Room: " + roomNumber); // Debugging
                        choiceRoom.add(roomNumber);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            // Revalidate and repaint the choiceRoom to ensure it updates properly
            choiceRoom.revalidate();
            choiceRoom.repaint();
        });



        JLabel checkTime = new JLabel("Checking time");
        checkTime .setBounds(40,420,100,30);
        checkTime .setFont(new Font("sans-serif",Font.PLAIN,14));
        checkTime .setForeground(Color.BLACK);
        image.add(checkTime );

        Date date = new Date();

        checkingTime = new JLabel("" + date);
        checkingTime.setBounds(180,420,300,30);
        checkingTime.setFont(new Font("sans-serif",Font.PLAIN,14));
        checkingTime .setForeground(Color.BLACK);
        image.add(checkingTime );

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(40,470,100,30);
        deposit.setFont(new Font("sans-serif",Font.PLAIN,14));
        deposit.setForeground(Color.BLACK);
        image.add(deposit);

        depositInput = new JTextField();
        depositInput.setBounds(180,470,200,30);
        depositInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(depositInput);

        addBtn = new JButton("Add Room");
        addBtn.setBounds(40,520,150,40);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("san-serif",Font.PLAIN,14));
        addBtn.addActionListener(this);
        image.add(addBtn);

        backBtn = new JButton("Cancel");
        backBtn .setBounds(230,520,150,40);
        backBtn .setBackground(Color.ORANGE);
        backBtn .setForeground(Color.BLACK);
        backBtn .setFont(new Font("san-serif",Font.PLAIN,14));
        backBtn.addActionListener(this);
        image.add(backBtn);

        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == addBtn){
            String id = (String) idTypo.getSelectedItem();
            String number = numberInput.getText();
            String name = nameInput.getText();
            String gender = null;

            // Validate Gender Selection
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else {
                JOptionPane.showMessageDialog(null, "Please select a gender");
                return;
            }

            String country = countryInput.getText();
            String roomNumber = choiceRoom.getSelectedItem();
            String timeDate = checkingTime.getText();
            String deposit = depositInput.getText();
            String bedTypo = (String) bedType.getSelectedItem();

            if(id == null || id.equals("")){
                JOptionPane.showMessageDialog(null,"Please select a ID Type");
                return;
            }
            if (number.trim().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the id Number");
                return;
            }
            if(name.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Name must not be empty!");
                return;
            }
            if(country.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Country must not be empty!");
                return;
            }

            if(roomNumber == null || roomNumber.equals("")){
                JOptionPane.showMessageDialog(null,"Please select a Room Number");
                return;
            }
            if(deposit.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the deposit Value!");
                return;
            }

            if(bedTypo == null || bedTypo.equals("")){
                JOptionPane.showMessageDialog(null,"Please select a Bed Type Option");
                return;
            }



            try {
                Conn conn = new Conn();

                String sqlQuery = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+roomNumber+"','"+timeDate+"','"+deposit+"','"+bedTypo+"')";

                conn.statement.executeUpdate(sqlQuery);

                JOptionPane.showMessageDialog(null,"Customer Added Successfully!");

                setVisible(false);

                new Reception();

            }catch (Exception e){
                e.printStackTrace();
            }



        } else if (ae.getSource() == backBtn) {
            setVisible(false);

            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
