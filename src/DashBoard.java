import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame implements ActionListener {

    JMenuItem reception,addEmployees,addRooms,addDrivers,addAdmin;

    DashBoard(){
        setBounds(0,0,1550,1000);
        setLayout(null);

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/HotelBg.jpg"));
        Image image3 = image2.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon image4 = new ImageIcon(image3);
        JLabel image = new JLabel(image4);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("THE SANDYBAY WELCOMES YOU");
        text.setBounds(330,130,1000,50);
        text.setForeground(Color.DARK_GRAY);
        text.setFont(new Font("Stencil",Font.PLAIN,60));
        image.add(text);

        JMenuBar dashboardMenu = new JMenuBar();
        dashboardMenu.setBounds(0, 0, 1550,80);
        dashboardMenu.setBackground(Color.DARK_GRAY);
        image.add(dashboardMenu);

        JMenu menuLinks1 = new JMenu("HOTEL MANAGEMENT");
        menuLinks1.setForeground(Color.WHITE);
        menuLinks1.setFont(new Font("sans-serif",Font.PLAIN,14));
        dashboardMenu.add(menuLinks1);

        reception = new JMenuItem("Reception");
        reception.setFont(new Font("sans-serif",Font.PLAIN,14));
        reception.addActionListener(this);
        menuLinks1.add(reception);

        JMenu menuLinks2 = new JMenu("ADMIN");
        menuLinks2.setForeground(Color.ORANGE);
        menuLinks2.setFont(new Font("sans-serif",Font.PLAIN,14));
        dashboardMenu.add(menuLinks2);

        addEmployees = new JMenuItem("Add Employee");
        addEmployees.setFont(new Font("sans-serif",Font.PLAIN,14));
        addEmployees.addActionListener(this);
        menuLinks2.add(addEmployees);

        addRooms = new JMenuItem("Add Rooms");
        addRooms.setFont(new Font("sans-serif",Font.PLAIN,14));
        addRooms.addActionListener(this);
        menuLinks2.add(addRooms);

        addDrivers = new JMenuItem("Add Drivers");
        addDrivers.setFont(new Font("sans-serif",Font.PLAIN,14));
        addDrivers.addActionListener(this);
        menuLinks2.add(addDrivers);

        JMenu menuLinks3 = new JMenu("MAINTENANCE");
        menuLinks3.setForeground(Color.RED);
        menuLinks3.setFont(new Font("sans-serif",Font.PLAIN,14));
        dashboardMenu.add(menuLinks3);

        addAdmin = new JMenuItem("Add Admin");
        addAdmin.setFont(new Font("sans-serif",Font.PLAIN,14));
        addAdmin.addActionListener(this);
        menuLinks3.add(addAdmin);




        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getActionCommand().equals("Reception") ){
            new Reception();
        } else if (ae.getActionCommand().equals("Add Employee") ) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("Add Rooms")) {
            new AddRoom();
        } else if (ae.getActionCommand().equals("Add Drivers")) {
            new AddDrivers();
        }else if (ae.getActionCommand().equals("Add Admin")){
            new loginMaintence();
        }
    }

    public static void main(String[] args) {
        new DashBoard();
    }

}
