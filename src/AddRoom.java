import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    JTextField roomNumInput,priceofRoom;
    JComboBox availability,cleaningStatus,bedType;
    JButton addRoomBtn,cancelBtn;

    AddRoom(){


        setBounds(310,200,950,500);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/hotelroom .jpg"));
        Image image2 = image1.getImage().getScaledInstance(950,500,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,950,500);
        add(image);

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Stencil",Font.PLAIN,20));
        heading.setForeground(Color.BLACK);
        heading.setBounds(400,20,150,30);
        image.add(heading);

        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setFont(new Font("Sans-serif",Font.PLAIN,14));
        roomNumber.setForeground(Color.BLACK);
        roomNumber.setBounds(40,70,150,30);
        image.add(roomNumber);

        roomNumInput = new JTextField();
        roomNumInput.setBounds(190,70,200,30);
        roomNumInput .setFont(new Font("Sans-serif",Font.PLAIN,14));
        image.add(roomNumInput);

        JLabel roomAvailability = new JLabel("Availability");
        roomAvailability .setFont(new Font("Sans-serif",Font.PLAIN,14));
        roomAvailability .setForeground(Color.BLACK);
        roomAvailability .setBounds(40,120,150,30);
        image.add(roomAvailability );

        String[] availabilityOptions = {null,"Available", "Occupied"};
        availability = new JComboBox<>(availabilityOptions);
        availability .setFont(new Font("Sans-serif",Font.PLAIN,14));
        availability.setBackground(Color.WHITE);
        availability.setForeground(Color.BLACK);
        availability.setBounds(190,120,200,30);
        image.add(availability);

        JLabel cleanOptions = new JLabel("Cleaning Status");
        cleanOptions .setFont(new Font("Sans-serif",Font.PLAIN,14));
        cleanOptions .setForeground(Color.BLACK);
        cleanOptions .setBounds(40,170,150,30);
        image.add(cleanOptions );

        String[] CleanOptions = {null,"Cleaned", "Dirty"};
        cleaningStatus = new JComboBox<>(CleanOptions);
        cleaningStatus  .setFont(new Font("Sans-serif",Font.PLAIN,14));
        cleaningStatus .setBackground(Color.WHITE);
        cleaningStatus .setForeground(Color.BLACK);
        cleaningStatus .setBounds(190,170,200,30);
        image.add(cleaningStatus);

        JLabel bedOptions = new JLabel("Bed Type");
        bedOptions .setFont(new Font("Sans-serif",Font.PLAIN,14));
        bedOptions .setForeground(Color.BLACK);
        bedOptions.setBounds(40,220,150,30);
        image.add(bedOptions );

        String[] BedOptions = {null,"Single", "Double","Triple"};
        bedType = new JComboBox<>(BedOptions);
        bedType  .setFont(new Font("Sans-serif",Font.PLAIN,14));
        bedType.setBackground(Color.WHITE);
        bedType.setForeground(Color.BLACK);
        bedType.setBounds(190,220,200,30);
        image.add(bedType);

        JLabel price = new JLabel("Price");
        price .setFont(new Font("Sans-serif",Font.PLAIN,14));
        price .setForeground(Color.BLACK);
        price.setBounds(40,270,150,30);
        image.add(price);

        priceofRoom = new JTextField();
        priceofRoom.setBounds(190,270,200,30);
        priceofRoom .setFont(new Font("Sans-serif",Font.PLAIN,14));
        image.add(priceofRoom);

        addRoomBtn = new JButton("Add Room");
        addRoomBtn.setBounds(40,320,120,40);
        addRoomBtn.setBackground(Color.BLACK);
        addRoomBtn.setForeground(Color.WHITE);
        addRoomBtn.setFont(new Font("san-serif",Font.PLAIN,14));
        addRoomBtn.addActionListener(this);
        image.add(addRoomBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn .setBounds(190,320,120,40);
        cancelBtn .setBackground(Color.RED);
        cancelBtn .setForeground(Color.BLACK);
        cancelBtn .setFont(new Font("san-serif",Font.PLAIN,14));
        cancelBtn.addActionListener(this);
        image.add(cancelBtn);




        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addRoomBtn){
            String roomNumber = roomNumInput.getText();
            String available = (String) availability.getSelectedItem();
            String cleanStatus = (String) cleaningStatus.getSelectedItem();
            String roomPrice = priceofRoom.getText();
            String bedTypo = (String) bedType.getSelectedItem();

            // validation
            if(roomNumber.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Room Number must not be empty!");
                return;
            }

            if(available == null || available.equals("")){
                JOptionPane.showMessageDialog(null,"Please select a availability Option");
                return;
            }

            if(cleanStatus == null || cleanStatus.equals("")){
                JOptionPane.showMessageDialog(null,"Please select a Clean Option");
                return;
            }

            //Price Validation
            try {
                double parsedPrice = Double.parseDouble(roomPrice);
                if (parsedPrice < 0) {
                    JOptionPane.showMessageDialog(null, "Price should be a positive number");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price should be a valid number");
                return;
            }

            //beDtypo
            if(bedTypo == null || bedTypo.equals("")){
                JOptionPane.showMessageDialog(null,"Please select a Bed Type Option");
                return;
            }



            try{
                Conn conn = new Conn();

                String SqlQeury = "insert into room values('"+roomNumber+"','"+available+"','"+cleanStatus+"','"+bedTypo+"','"+roomPrice+"')";

                conn.statement.executeUpdate(SqlQeury);

                JOptionPane.showMessageDialog(null,"Room Added Successfully!");

                setVisible(false);

            }catch (Exception exception){
                exception.printStackTrace();
            }


        } else if (ae.getSource() == cancelBtn) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
       new AddRoom();
    }
}
