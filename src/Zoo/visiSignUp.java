package Zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class visiSignUp extends JFrame {

    public static JPanel centerPanel;


    public visiSignUp(){

        setMinimumSize(new Dimension(350,350));
        setPreferredSize(new Dimension(350, 350));
        setResizable(false);

        centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);

        final JLabel firstName = new JLabel("first name :");
        JTextField firstNameText = new JTextField();
        firstNameText.setMinimumSize(new Dimension(100,20));
        firstNameText.setPreferredSize(new Dimension(100, 20));

        final JLabel lastName = new JLabel("last name :");
        JTextField lastNameText = new JTextField();
        lastNameText.setMinimumSize(new Dimension(100,20));
        lastNameText.setPreferredSize(new Dimension(100, 20));

        final JLabel username = new JLabel("username :");
        JTextField userText = new JTextField();
        userText.setMinimumSize(new Dimension(100, 20));
        userText.setPreferredSize(new Dimension(100, 20));

        final JLabel password = new JLabel("password :");
        JTextField passText = new JTextField();
        passText.setMinimumSize(new Dimension(100, 20));
        passText.setPreferredSize(new Dimension(100, 20));

        final JLabel ID = new JLabel("ID :");
        JTextField idText = new JTextField();
        idText.setMinimumSize(new Dimension(100, 20));
        idText.setPreferredSize(new Dimension(100, 20));

        final JLabel pNumber = new JLabel("Phone Number :");
        JTextField numberText = new JTextField();
        numberText.setMinimumSize(new Dimension(200, 20));
        numberText.setPreferredSize(new Dimension(200, 20));

        final JLabel reputation = new JLabel("Reputation :");
        JTextField repText = new JTextField();
        repText.setMinimumSize(new Dimension(100, 20));
        repText.setPreferredSize(new Dimension(100, 20));

        final JLabel eMail = new JLabel("EMail :");
        JTextField mailText = new JTextField();
        mailText.setMinimumSize(new Dimension(200, 20));
        mailText.setPreferredSize(new Dimension(200, 20));


        centerPanel.add(firstName);
        centerPanel.add(firstNameText);
        centerPanel.add(lastName);
        centerPanel.add(lastNameText);
        centerPanel.add(username);
        centerPanel.add(userText);
        centerPanel.add(password);
        centerPanel.add(passText);
        centerPanel.add(ID);
        centerPanel.add(idText);
        centerPanel.add(pNumber);
        centerPanel.add(numberText);
        centerPanel.add(reputation);
        centerPanel.add(repText);
        centerPanel.add(eMail);
        centerPanel.add(mailText);


        JButton btnAdd = new JButton("Register");
        final JButton btnBack = new JButton("Back");

        JPanel btnPanel = new JPanel();
        btnPanel.setMinimumSize(new Dimension(400,50));
        btnPanel.setPreferredSize(new Dimension(400, 50));

        centerPanel.add(btnPanel);
        btnPanel.add(btnAdd);
        btnPanel.add(btnBack);

        btnAdd.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                btnAdd.setText("Save");


                String fn = firstNameText.getText();
                String ln = lastNameText.getText();
                String un = userText.getText();
                String ps = passText.getText();
                String id = idText.getText();
                String num = numberText.getText();
                long nu = Long.parseLong(num);
                String rep = repText.getText();
                int sa = Integer.parseInt(rep);
                String em = mailText.getText();



                Visitor visi = new Visitor(fn, ln, un, ps, id, nu, sa, em);


                Visitor.AddVisitor(visi);

                for (int i = 0; i < Visitor.visitors.size(); i++){

                    System.out.println(Visitor.visitors.get(i).toString());
                }

                btnAdd.setEnabled(false);

                setVisible(false);

                //write to file

                Visitor.writeVisitor();

            }
        });

        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                new Login();

            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
