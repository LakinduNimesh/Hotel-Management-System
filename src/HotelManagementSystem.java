import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){


        setBounds(160,100,1280,565);
        setLayout(null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/Cover.png"));
        JLabel image = new JLabel(image1);
        image.setBounds(0,0,1280,565);
        add(image);

        JLabel text = new JLabel("Hotel Management System ...");
        text.setBounds(30,400,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Forte",Font.PLAIN,60
        ));
        image.add(text);

        JLabel text1 = new JLabel("WELCOME");
        text1.setBounds(30,20,1000,90);
        text1.setForeground(Color.BLACK);
        text1.setFont(new Font("Forte",Font.BOLD,80
        ));
        image.add(text1);

        JLabel text2 = new JLabel("to");
        text2.setBounds(100,120,1000,90);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("Forte",Font.ITALIC,40
        ));
        image.add(text2);

        JLabel text3 = new JLabel("SANDYBAY Beach Hotel");
        text3.setBounds(30,220,1000,90);
        text3.setForeground(Color.BLACK);
        text3.setFont(new Font("Forte",Font.ITALIC,60
        ));
        image.add(text3);

        JButton next = new JButton("Next");
        next.setBounds(1000,430,150,40);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("san-serif",Font.PLAIN,14));
        image.add(next);

        setVisible(true);

        while (true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e) {
                e.printStackTrace();
            }

            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        Login login = new Login();
    }

    public static void main(String[] args) {

        new HotelManagementSystem();
    }
}