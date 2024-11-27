import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {

    JTextField nameInput,ageInput,carBrandInput,carType,locationInput;
    JComboBox genderOption,availability;
    JButton addRoomBtn,cancelBtn;

    AddDrivers(){


        setBounds(310,150,980,600);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/car.jpg"));
        Image image2 = image1.getImage().getScaledInstance(980,600,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,980,600);
        add(image);

        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Stencil",Font.PLAIN,20));
        heading.setForeground(Color.BLACK);
        heading.setBounds(400,20,150,30);
        image.add(heading);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Sans-serif",Font.PLAIN,14));
        name.setForeground(Color.BLACK);
        name.setBounds(40,70,150,30);
        image.add(name);

        nameInput = new JTextField();
        nameInput.setBounds(190,70,200,30);
        nameInput.setFont(new Font("Sans-serif",Font.PLAIN,14));
        image.add(nameInput);

        JLabel age = new JLabel("Age");
        age .setFont(new Font("Sans-serif",Font.PLAIN,14));
        age .setForeground(Color.BLACK);
        age.setBounds(40,120,150,30);
        image.add(age );


        ageInput = new JTextField();
        ageInput .setFont(new Font("Sans-serif",Font.PLAIN,14));
        ageInput.setBounds(190,120,200,30);
        image.add(ageInput);

        JLabel gender = new JLabel("Gender");
        gender .setFont(new Font("Sans-serif",Font.PLAIN,14));
        gender .setForeground(Color.BLACK);
        gender .setBounds(40,170,150,30);
        image.add(gender  );

        String[] CleanOptions = {null,"Male", "Female"};
        genderOption = new JComboBox<>(CleanOptions);
        genderOption  .setFont(new Font("Sans-serif",Font.PLAIN,14));
        genderOption .setBackground(Color.WHITE);
        genderOption .setForeground(Color.BLACK);
        genderOption .setBounds(190,170,200,30);
        image.add(genderOption);


        JLabel price = new JLabel("Car Brand");
        price .setFont(new Font("Sans-serif",Font.PLAIN,14));
        price .setForeground(Color.BLACK);
        price.setBounds(40,220,150,30);
        image.add(price);

        carBrandInput = new JTextField();
        carBrandInput.setBounds(190,220,200,30);
        carBrandInput .setFont(new Font("Sans-serif",Font.PLAIN,14));
        image.add(carBrandInput);


        JLabel carmodel = new JLabel("Car Model");
        carmodel .setFont(new Font("Sans-serif",Font.PLAIN,14));
        carmodel .setForeground(Color.BLACK);
        carmodel.setBounds(40,270,150,30);
        image.add(carmodel );

        carType = new JTextField();
        carType .setFont(new Font("Sans-serif",Font.PLAIN,14));
        carType.setBackground(Color.WHITE);
        carType.setForeground(Color.BLACK);
        carType.setBounds(190,270,200,30);
        image.add(carType);

        JLabel carAvailability = new JLabel("Availability");
        carAvailability .setFont(new Font("Sans-serif",Font.PLAIN,14));
        carAvailability .setForeground(Color.BLACK);
        carAvailability .setBounds(40,320,150,30);
        image.add(carAvailability );

        String[] availabilityOptions = {null,"Available", "Unavailable"};
        availability = new JComboBox<>(availabilityOptions);
        availability .setFont(new Font("Sans-serif",Font.PLAIN,14));
        availability.setBackground(Color.WHITE);
        availability.setForeground(Color.BLACK);
        availability.setBounds(190,320,200,30);
        image.add(availability);

        JLabel location = new JLabel("Location");
        location .setFont(new Font("Sans-serif",Font.PLAIN,14));
        location .setForeground(Color.BLACK);
        location .setBounds(40,370,150,30);
        image.add(location);

        locationInput = new JTextField();
        locationInput .setBounds(190,370,200,30);
        locationInput  .setFont(new Font("Sans-serif",Font.PLAIN,14));
        image.add(locationInput );

        addRoomBtn = new JButton("Add Driver");
        addRoomBtn.setBounds(40,420,120,40);
        addRoomBtn.setBackground(Color.BLACK);
        addRoomBtn.setForeground(Color.WHITE);
        addRoomBtn.setFont(new Font("san-serif",Font.PLAIN,14));
        addRoomBtn.addActionListener(this);
        image.add(addRoomBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn .setBounds(190,420,120,40);
        cancelBtn .setBackground(Color.RED);
        cancelBtn .setForeground(Color.BLACK);
        cancelBtn .setFont(new Font("san-serif",Font.PLAIN,14));
        cancelBtn.addActionListener(this);
        image.add(cancelBtn);




        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addRoomBtn){
            String driverName = nameInput.getText();
            String driverAge = ageInput.getText();
            String gender = (String) genderOption.getSelectedItem();
            String carBrand = carBrandInput.getText();
            String carModel = carType.getText();
            String available = (String) availability.getSelectedItem();
            String location = locationInput.getText();

            // validation
            if(driverName.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Name must not be empty!");
                return;
            }

            if(driverAge.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Age must not be empty!");
                return;
            }

            if(gender == null || gender.equals("")){
                JOptionPane.showMessageDialog(null,"Please select a Gender");
                return;
            }

            if(carBrand.trim().equals("")){
                JOptionPane.showMessageDialog(null,"car Brand must not be empty!");
                return;
            }

            if(carModel.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Car Model must not be empty!");
                return;
            }

            if(available == null || available.equals("")){
                JOptionPane.showMessageDialog(null,"Please select a availability Option");
                return;
            }

            if(location.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Location must not be empty!");
                return;
            }




            try{
                Conn conn = new Conn();

                String SqlQeury = "insert into driver values('"+driverName+"','"+driverAge+"','"+gender+"','"+carBrand+"','"+carModel+"','"+available+"','"+location+"')";

                conn.statement.executeUpdate(SqlQeury);

                JOptionPane.showMessageDialog(null,"Driver Added Successfully!");

                setVisible(false);

            }catch (Exception exception){
                exception.printStackTrace();
            }


        } else if (ae.getSource() == cancelBtn) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}
