import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    JButton newCustomer,rooms,department,allEmployee,customers,managerinfo,checkOut,updateStatus,roomStatus,pickUp,searchRoom,logOut;

    Reception() {
        setBounds(300, 100, 900, 700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        ImageIcon image1 = new ImageIcon(getClass().getResource("/images/reception.jpg"));
        Image image2 = image1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(40,30,200,40);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setFont(new Font("san-serif",Font.PLAIN,14));
        newCustomer.addActionListener(this);
        image.add(newCustomer);

        rooms = new JButton("Rooms");
        rooms .setBounds(40,80,200,40);
        rooms .setBackground(Color.BLACK);
        rooms .setForeground(Color.WHITE);
        rooms .setFont(new Font("san-serif",Font.PLAIN,14));
        rooms .addActionListener(this);
        image .add(rooms );

        department = new JButton("Department");
        department.setBounds(40,130,200,40);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department .setFont(new Font("san-serif",Font.PLAIN,14));
        department.addActionListener(this);
        image.add(department);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(40,180,200,40);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee .setFont(new Font("san-serif",Font.PLAIN,14));
        allEmployee.addActionListener(this);
        image.add(allEmployee);

        customers = new JButton("Cusomer info");
        customers.setBounds(40,230,200,40);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers .setFont(new Font("san-serif",Font.PLAIN,14));
        customers.addActionListener(this);
        image.add(customers);

        managerinfo = new JButton("Manager info");
        managerinfo.setBounds(40,280,200,40);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo .setFont(new Font("san-serif",Font.PLAIN,14));
        managerinfo.addActionListener(this);
        image.add(managerinfo);

        checkOut = new JButton("CheckOut");
        checkOut.setBounds(40,330,200,40);
        checkOut.setBackground(Color.BLACK);
        checkOut.setForeground(Color.WHITE);
        checkOut .setFont(new Font("san-serif",Font.PLAIN,14));
        checkOut.addActionListener(this);
        image.add(checkOut);

        updateStatus = new JButton("Update Status");
        updateStatus.setBounds(40,380,200,40);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.setFont(new Font("san-serif",Font.PLAIN,14));
        updateStatus.addActionListener(this);
        image.add(updateStatus);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(40,430,200,40);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.setFont(new Font("san-serif",Font.PLAIN,14));
        roomStatus.addActionListener(this);
        image.add(roomStatus);

        pickUp = new JButton("PickUp Service");
        pickUp.setBounds(40,480,200,40);
        pickUp.setBackground(Color.BLACK);
        pickUp.setForeground(Color.WHITE);
        pickUp.setFont(new Font("san-serif",Font.PLAIN,14));
        pickUp.addActionListener(this);
        image.add(pickUp);

        searchRoom = new JButton("Search Room");
        searchRoom .setBounds(40,530,200,40);
        searchRoom .setBackground(Color.BLACK);
        searchRoom .setForeground(Color.WHITE);
        searchRoom .setFont(new Font("san-serif",Font.PLAIN,14));
        searchRoom.addActionListener(this);
        image.add(searchRoom );

        logOut = new JButton("LogOut");
        logOut .setBounds(40,580,200,40);
        logOut .setBackground(Color.BLACK);
        logOut .setForeground(Color.WHITE);
        logOut.setFont(new Font("san-serif",Font.PLAIN,14));
        logOut.addActionListener(this);
        image.add(logOut);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new room();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Departments();
        } else if (ae.getSource() == allEmployee) {
            setVisible(false);
            new employee();
        }else if (ae.getSource() == managerinfo) {
            setVisible(false);
            new manager();
        }else if (ae.getSource() == customers) {
            setVisible(false);
            new customer();
        }else if (ae.getSource() == searchRoom) {
        setVisible(false);
        new searchRoom();
        }
        else if (ae.getSource() == updateStatus) {
            setVisible(false);
            new UpdateCheckOut();
        }
        else if (ae.getSource() == roomStatus) {
            setVisible(false);
            new updateRoom();
        }else if (ae.getSource() == pickUp) {
            setVisible(false);
            new pickupService();
        }else if (ae.getSource() == checkOut) {
            setVisible(false);
            new checkOut();
        }else if (ae.getSource() == logOut) {
            setVisible(false);
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new Reception();
    }
}
