import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addAdmin extends JFrame implements ActionListener {

    JTextField userInput;
    JPasswordField passwordInput;
    JButton addBtn;

    addAdmin(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/addAdmin.jpg"));
        Image image3 = image2.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon image4 = new ImageIcon(image3);
        JLabel image = new JLabel(image4);
        image.setBounds(0,0,500,300);
        add(image);

        JLabel AddUserName = new JLabel("Add Username");
        AddUserName.setBounds(40,40,150,30);
        AddUserName.setFont(new Font("sans-serif",Font.PLAIN,14
        ));
        image.add(AddUserName);

        JLabel password = new JLabel("Password");
        password.setBounds(40,90,150,30);
        password.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(password);

        userInput = new JTextField();
        userInput.setBounds(200,40,200,30);
        image.add(userInput);

        passwordInput = new JPasswordField();
        passwordInput.setBounds(200,90,200,30);
        image.add(passwordInput);

        addBtn = new JButton("Add");
        addBtn.setBounds(40,150,120,40);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("san-serif",Font.PLAIN,14));
        addBtn.addActionListener(this);
        image.add(addBtn);


        setBounds(500,200,500,300);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addBtn){
            String user =   userInput.getText();
            String password = passwordInput.getText();

            try {
                Conn conn = new Conn();

                String sqlQuery = "insert into login values('"+user+"','"+password+"')";

                conn.statement.executeUpdate(sqlQuery);

                JOptionPane.showMessageDialog(null,"Admin added successfully!");

                setVisible(false);


            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new addAdmin();
    }
}
