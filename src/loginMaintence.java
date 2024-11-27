import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class loginMaintence extends JFrame implements ActionListener {

    JTextField userInput;
    JPasswordField passwordInput;
    JButton loginBtn,cancelBtn;

    loginMaintence(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/AddEmployee.jpg"));
        Image image3 = image2.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon image4 = new ImageIcon(image3);
        JLabel image = new JLabel(image4);
        image.setBounds(0,0,600,300);
        add(image);

        JLabel userNameMaintance = new JLabel("Username");
        userNameMaintance.setBounds(40,40,100,30);
        userNameMaintance.setFont(new Font("sans-serif",Font.PLAIN,14
        ));
        image.add(userNameMaintance);

        JLabel password = new JLabel("Password");
        password.setBounds(40,90,100,30);
        password.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(password);

        userInput = new JTextField();
        userInput.setBounds(150,40,200,30);
        image.add(userInput);

        passwordInput = new JPasswordField();
        passwordInput.setBounds(150,90,200,30);
        image.add(passwordInput);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(40,150,120,40);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("san-serif",Font.PLAIN,14));
        loginBtn.addActionListener(this);
        image.add(loginBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn .setBounds(180,150,120,40);
        cancelBtn .setBackground(Color.RED);
        cancelBtn .setForeground(Color.BLACK);
        cancelBtn .setFont(new Font("san-serif",Font.PLAIN,14));
        cancelBtn.addActionListener(this);
        image.add(cancelBtn);

        setBounds(500,200,600,300);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == loginBtn){
            String user =   userInput.getText();
            String password = passwordInput.getText();

            try {
                Conn conn = new Conn();

                String sqlQuery = "select * from addMaintence where user = '" + user + "' and password = '" + password + "'";

                ResultSet resultSet = conn.statement.executeQuery(sqlQuery);

                if(resultSet.next()){
                    setVisible(false);
                    new addAdmin();

                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password.");
                    setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == cancelBtn){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new loginMaintence();
    }
}