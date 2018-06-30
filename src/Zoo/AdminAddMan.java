package Zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddMan extends JPanel{

    public AdminManage adminManage;


    public AdminAddMan(){

        setMinimumSize(new Dimension(350,350));
        setPreferredSize(new Dimension(350, 350));
        BoxLayout centerLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(centerLayout);

        final JLabel firstName = new JLabel("first name :");
        final JTextField firstNameText = new JTextField();
        firstNameText.setMinimumSize(new Dimension(50,20));
        firstNameText.setPreferredSize(new Dimension(50, 20));

        final JLabel lastName = new JLabel("last name :");
        final JTextField lastNameText = new JTextField();
        lastNameText.setMinimumSize(new Dimension(50,20));
        lastNameText.setPreferredSize(new Dimension(50, 20));

        final JLabel username = new JLabel("username :");
        final JTextField userText = new JTextField();
        userText.setMinimumSize(new Dimension(50, 20));
        userText.setPreferredSize(new Dimension(50, 20));

        JLabel password = new JLabel("password :");
        final JTextField passText = new JTextField();
        passText.setMinimumSize(new Dimension(50, 20));
        passText.setPreferredSize(new Dimension(50, 20));

        JLabel ID = new JLabel("ID :");
        final JTextField idText = new JTextField();
        idText.setMinimumSize(new Dimension(50, 20));
        idText.setPreferredSize(new Dimension(50, 20));

        final JLabel pNumber = new JLabel("Phone Number :");
        final JTextField numberText = new JTextField();
        numberText.setMinimumSize(new Dimension(50, 20));
        numberText.setPreferredSize(new Dimension(50, 20));

        final JLabel address = new JLabel("Address :");
        final JTextField addreText = new JTextField();
        addreText.setMinimumSize(new Dimension(50, 20));
        addreText.setPreferredSize(new Dimension(50, 20));

        final JLabel eMail = new JLabel("EMail :");
        final JTextField mailText = new JTextField();
        mailText.setMinimumSize(new Dimension(50, 20));
        mailText.setPreferredSize(new Dimension(50, 20));

        final JLabel salary = new JLabel("Salary :");
        final JTextField salText = new JTextField();
        salText.setMinimumSize(new Dimension(50, 20));
        salText.setPreferredSize(new Dimension(50, 20));

        add(firstName);
        add(firstNameText);
        add(lastName);
        add(lastNameText);
        add(username);
        add(userText);
        add(password);
        add(passText);
        add(ID);
        add(idText);
        add(pNumber);
        add(numberText);
        add(address);
        add(addreText);
        add(eMail);
        add(mailText);
        add(salary);
        add(salText);

        JButton btnAdd = new JButton("Add");
        final JButton btnBack = new JButton("Back");

        JPanel btnPanel = new JPanel();
        btnPanel.setMinimumSize(new Dimension(400,50));
        btnPanel.setPreferredSize(new Dimension(400, 50));

        add(btnPanel);
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
                String ad = addreText.getText();
                String em = mailText.getText();
                String sal = salText.getText();
                long sa = Long.parseLong(sal);

                Manager man = new Manager(fn, ln, un, ps, id, nu, ad, em, sa);

                Manager.AddManager(man);

                for (int i = 0; i < Manager.managers.size(); i++){

                    System.out.println(Manager.managers.get(i).toString());
                }

                btnAdd.setEnabled(false);

                setVisible(false);

                //write to file

                Manager.writeManager();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                setVisible(false);
                adminManage = new AdminManage();
                AdminFrame.centerPanel.add(adminManage);

            }
        });

    }
}
