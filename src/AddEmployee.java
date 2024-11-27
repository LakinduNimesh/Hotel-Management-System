import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField nameInput,ageInput,salleryInput,phoneInput,emailInput,nicInput;
    JRadioButton male , female;
    JComboBox jobSelection;
    JButton submitBtn;


    AddEmployee(){
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,550);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/Employee.jpg"));
        Image Image2 = image1.getImage().getScaledInstance(850,550,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(Image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,850,550);
        add(image);


        JLabel name = new JLabel("Name");
        name.setBounds(40,40,100,30);
        name.setFont(new Font("sans-serif",Font.PLAIN,14));
        name.setForeground(Color.BLACK);
        image.add(name);

        nameInput = new JTextField();
        nameInput.setBounds(120,40,200,30);
        nameInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(nameInput);

        JLabel age = new JLabel("Age");
        age.setBounds(40,90,100,30);
        age.setFont(new Font("sans-serif",Font.PLAIN,14));
        age.setForeground(Color.BLACK);
        image.add(age);

        ageInput = new JTextField();
        ageInput.setBounds(120,90,200,30);
        ageInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(ageInput);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(40,140,100,30);
        gender.setFont(new Font("sans-serif",Font.PLAIN,14));
        gender.setForeground(Color.BLACK);
        image.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(120,140,90,30);
        male.setFont(new Font("sans-serif",Font.PLAIN,13));
        image.add(male);

        female = new JRadioButton("Female");
        female.setBounds(210,140,110,30);
        female.setFont(new Font("sans-serif",Font.PLAIN,13));
        image.add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel job = new JLabel("Job");
        job.setBounds(40,190,100,30);
        job.setFont(new Font("sans-serif",Font.PLAIN,14));
        job.setForeground(Color.BLACK);
        image.add(job);

        String hotelCrew[] = {
                null,
                "General Manager",
                "Assistant Manager",
                "Front Desk Receptionist",
                "Concierge",
                "Housekeeping Supervisor",
                "Housekeeping Staff",
                "Laundry Attendant",
                "Chef",
                "Sous Chef",
                "Pastry Chef",
                "Waiter/Waitress",
                "Bartender",
                "Barista",
                "Bellhop",
                "Porter",
                "Pool Attendant",
                "Lifeguard",
                "Spa Therapist",
                "Fitness Trainer",
                "Valet",
                "Maintenance Technician",
                "Security Guard",
                "Beach Activities Coordinator",
                "Event Planner",
                "Entertainment Staff",
                "Groundskeeper",
                "IT Support",
                "Reservations Agent",
                "Gift Shop Attendant",
                "Marketing Manager"
        };

        jobSelection = new JComboBox<>(hotelCrew);
        jobSelection.setBounds(120,190,200,30);
        jobSelection.setFont(new Font("sans-serif",Font.PLAIN,13));
        jobSelection.setForeground(Color.BLACK);
        jobSelection.setBackground(Color.white);
        image.add(jobSelection);

        JLabel sallery = new JLabel("Sallery");
        sallery.setBounds(40,240,100,30);
        sallery.setFont(new Font("sans-serif",Font.PLAIN,14));
        sallery.setForeground(Color.BLACK);
        image.add(sallery);

        salleryInput = new JTextField();
        salleryInput.setBounds(120,240,200,30);
        salleryInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(salleryInput);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(40,290,100,30);
        phone.setFont(new Font("sans-serif",Font.PLAIN,14));
        phone.setForeground(Color.BLACK);
        image.add(phone);

        phoneInput = new JTextField();
        phoneInput.setBounds(120,290,200,30);
        phoneInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(phoneInput);

        JLabel email = new JLabel("Email");
        email.setBounds(40,340,100,30);
        email.setFont(new Font("sans-serif",Font.PLAIN,14));
        email.setForeground(Color.BLACK);
        image.add(email);

        emailInput = new JTextField();
        emailInput.setBounds(120,340,200,30);
        emailInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(emailInput);

        JLabel nic = new JLabel("NIC");
        nic.setBounds(40,390,100,30);
        nic.setFont(new Font("sans-serif",Font.PLAIN,14));
        nic.setForeground(Color.BLACK);
        image.add(nic);

        nicInput = new JTextField();
        nicInput.setBounds(120,390,200,30);
        nicInput.setFont(new Font("sans-serif",Font.PLAIN,14));
        image.add(nicInput);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(120,440,200,40);
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFont(new Font("san-serif",Font.PLAIN,14));
        submitBtn.addActionListener(this);
        image.add(submitBtn);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name = nameInput.getText();
        String age = ageInput.getText();
        String salary = salleryInput.getText();
        String phoneNum = phoneInput.getText();
        String email = emailInput.getText();
        String nic = nicInput.getText();

        String gender = null;


    // Validate Name
        if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return; // Exit the method if validation fails
        }

    // Validate Age
        try {
            int parsedAge = Integer.parseInt(age);
            if (parsedAge <= 0) {
                JOptionPane.showMessageDialog(null, "Age should be a positive number");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age should be a valid number");
            return;
        }

    // Validate Salary
        try {
            double parsedSalary = Double.parseDouble(salary);
            if (parsedSalary < 0) {
                JOptionPane.showMessageDialog(null, "Salary should be a positive number");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Salary should be a valid number");
            return;
        }

    // Validate Phone Number (basic length check)
        if (phoneNum.trim().isEmpty() || phoneNum.length() != 10) {
            JOptionPane.showMessageDialog(null, "Phone number should be 10 digits long");
            return;
        }

    // Validate Email
        if (email.trim().isEmpty() || !email.contains("@") || !email.endsWith(".com")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email (should contain '@' and end with '.com')");
            return;
        }

    // Validate NIC (basic length check)
        if (nic.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the NIC");
            return;
        }

    // Validate Gender Selection
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else {
            JOptionPane.showMessageDialog(null, "Please select a gender");
            return;
        }

    // Validate Job Selection
        String job = (String) jobSelection.getSelectedItem();
        if (job == null || job.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a job");
            return;
        }


        try {
            Conn conn = new Conn();

            String sqlQuery = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phoneNum+"','"+email+"','"+nic+"')";

            conn.statement.executeUpdate(sqlQuery);

            JOptionPane.showMessageDialog(null,"Employee added succesfully!");

            setVisible(false);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
