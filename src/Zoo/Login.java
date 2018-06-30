package Zoo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login {

    public static JComboBox comboBox;

    private static SuperAdmin superAdmin = new SuperAdmin();
    private static Manager manager = new Manager();
    private static AdminFrame adminFrame;

    private static visiSignUp visiFrame;

    public static void main(String[] args) {

        new Login();

//        Visitor.addVisitor();
//        Visitor.writeVisitor();

//        Visitor.readVisitor();

//        for (int i = 0; i < Visitor.visitors.size(); i++){
//            System.out.println(Visitor.visitors.get(i).toString());
//        }

    }

    public Login() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {

                    BufferedImage img = ImageIO.read(new File("resize2.jpg"));

                    JFrame frame = new JFrame("Testing");
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setContentPane(new JLabel(new ImageIcon(img)));

                    JPanel centerPanel = new JPanel();
                    centerPanel.setMinimumSize(new Dimension(300, 150));
                    frame.add(centerPanel, BorderLayout.CENTER);

                    frame.setLayout(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;

                    Font myFont = new Font("Lato Black", Font.BOLD, 18);

                    JLabel combolabel = new JLabel("You are a:    ");
                    combolabel.setFont(myFont);
                    combolabel.setForeground(Color.MAGENTA);

                    comboBox = new JComboBox();
//                    comboBox.setBackground(Color.MAGENTA);
                    comboBox.addItem("Super Admin");
                    comboBox.addItem("Manager");
                    comboBox.addItem("ZooKeeper");
                    comboBox.addItem("Visitor");

                    comboBox.setMinimumSize(new Dimension(180, 30));
                    comboBox.setPreferredSize(new Dimension(180, 30));

                    final EmptyBorder comboBorder = new EmptyBorder(5, 0, 0, 0);
                    comboBox.setBorder(comboBorder);
                    centerPanel.add(combolabel, gbc);
                    centerPanel.add(comboBox);

                    final JLabel usii = new JLabel("User name: ");
                    usii.setFont(myFont);
                    usii.setForeground(Color.cyan);

                    final JTextField userName = new JTextField();
                    userName.setMinimumSize(new Dimension(180, 30));
                    userName.setPreferredSize(new Dimension(180, 30));
                    userName.setBackground(Color.CYAN);
                    centerPanel.add(usii, gbc);
                    centerPanel.add(userName, gbc);


                    final JLabel passi = new JLabel("Password:   ");
                    passi.setFont(myFont);
                    passi.setForeground(Color.pink);

                    final JPasswordField passWord = new JPasswordField();
                    passWord.setMinimumSize(new Dimension(180, 30));
                    passWord.setPreferredSize(new Dimension(180, 30));
                    passWord.setBackground(Color.PINK);
                    centerPanel.add(passi, gbc);
                    centerPanel.add(passWord, gbc);

                    JButton loginBtn = new JButton("Sign in");
                    centerPanel.add(loginBtn, gbc);

                    final JLabel signUp = new JLabel("No Account?");
                    centerPanel.add(signUp);

                    JButton registerBtn = new JButton("Sign Up");
                    centerPanel.add(registerBtn);

//                    manager.AddManager();
//                    SuperAdmin.readAdmin();
                    Manager.readManager();
                    Visitor.readVisitor();

                    loginBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {

                            String username = userName.getText();
                            String password = passWord.getText();

                            if (comboBox.getSelectedIndex() == 0) {

                                if (superAdmin.getUsername().equals(username)){
                                    if (superAdmin.getPassword().equals(password)){

                                        frame.setVisible(false);

                                        adminFrame = new AdminFrame();

                                        adminFrame.setVisible(true);


                                    }
                                }
                            }

                            else if (comboBox.getSelectedIndex() == 1) {
                                for (int i = 0; i < Manager.managers.size(); i++) {
                                    if (Manager.managers.get(i).getUsername().equals(username)) {
                                        if (Manager.managers.get(i).getPassword().equals(password)){

                                            frame.setVisible(false);

                                            JFrame ff = new JFrame("second page");
                                            ff.setMaximumSize(new Dimension(400, 400));
                                            ff.setPreferredSize(new Dimension(400, 400));
                                            JLabel labii = new JLabel("welcome!");
                                            ff.add(labii);
                                            ff.setVisible(true);

                                        }
                                    }
                                }
                            }

                            else if (comboBox.getSelectedIndex() == 3) {
                                for (int i = 0; i < Visitor.visitors.size(); i++) {
                                    if (Visitor.visitors.get(i).getUsername().equals(username)) {
                                        if (Visitor.visitors.get(i).getPassword().equals(password)) {

                                            frame.setVisible(false);

                                        }
                                    }
                                }
                            }
                        }
                    });


                    registerBtn.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {


                            if (comboBox.getSelectedIndex() == 3) {

                                frame.setVisible(false);

                                visiFrame = new visiSignUp();

                                visiFrame.setVisible(true);

                                //add visitor
                            }
                        }
                    });


                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }
}