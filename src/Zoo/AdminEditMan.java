package Zoo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminEditMan extends JPanel {

    public AdminManage adminManage;

    int index;


    public AdminEditMan(){


        setMinimumSize(new Dimension(350,350));
        setPreferredSize(new Dimension(350, 350));
        BoxLayout centerLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(centerLayout);


        final JLabel id = new JLabel("ID of Manager: ");
        JTextField idText = new JTextField();
        idText.setMinimumSize(new Dimension(50,20));
        idText.setPreferredSize(new Dimension(50, 20));

        add(id);
        add(idText);

        JButton btnFind = new JButton("Find");
        final JButton btnBack = new JButton("Back");

        JPanel btnPanel = new JPanel();
        btnPanel.setMinimumSize(new Dimension(400,50));
        btnPanel.setPreferredSize(new Dimension(400, 50));

        add(btnPanel);
        btnPanel.add(btnFind);
        btnPanel.add(btnBack);





        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String idFind = idText.getText();

                System.out.println(idText);

                for(int i = 0; i < Manager.managers.size(); i++){

                    if (Manager.managers.get(i).getID().equals(idFind)){

                        index = i;

                        System.out.println(Manager.managers.get(i).toString());

                        setVisible(false);


                        final JLabel firstName = new JLabel("first name :");
                        JTextField firstNameText = new JTextField(Manager.managers.get(i).getName());
                        firstNameText.setMinimumSize(new Dimension(100,20));
                        firstNameText.setPreferredSize(new Dimension(100, 20));

                        final JLabel lastName = new JLabel("last name :");
                        JTextField lastNameText = new JTextField(Manager.managers.get(i).getLastName());
                        lastNameText.setMinimumSize(new Dimension(100,20));
                        lastNameText.setPreferredSize(new Dimension(100, 20));

                        final JLabel username = new JLabel("username :");
                        JTextField userText = new JTextField(Manager.managers.get(i).getUsername());
                        userText.setMinimumSize(new Dimension(100, 20));
                        userText.setPreferredSize(new Dimension(100, 20));

                        final JLabel password = new JLabel("password :");
                        JTextField passText = new JTextField(Manager.managers.get(i).getPassword());
                        passText.setMinimumSize(new Dimension(100, 20));
                        passText.setPreferredSize(new Dimension(100, 20));

                        final JLabel ID = new JLabel("ID :");
                        JTextField idText = new JTextField(Manager.managers.get(i).getID());
                        idText.setMinimumSize(new Dimension(100, 20));
                        idText.setPreferredSize(new Dimension(100, 20));

                        final JLabel pNumber = new JLabel("Phone Number :");
                        JTextField numberText = new JTextField(Manager.managers.get(i).getPhoneNumber() + "");
                        numberText.setMinimumSize(new Dimension(200, 20));
                        numberText.setPreferredSize(new Dimension(200, 20));

                        final JLabel address = new JLabel("Address :");
                        JTextField addreText = new JTextField(Manager.managers.get(i).getAddress());
                        addreText.setMinimumSize(new Dimension(300, 20));
                        addreText.setPreferredSize(new Dimension(300, 20));

                        final JLabel eMail = new JLabel("EMail :");
                        JTextField mailText = new JTextField(Manager.managers.get(i).geteMail());
                        mailText.setMinimumSize(new Dimension(200, 20));
                        mailText.setPreferredSize(new Dimension(200, 20));

                        final JLabel salary = new JLabel("Salary :");
                        JTextField salText = new JTextField(Manager.managers.get(i).getSalary() + "");
                        salText.setMinimumSize(new Dimension(100, 20));
                        salText.setPreferredSize(new Dimension(100, 20));


                        firstNameText.setEditable(false);
                        lastNameText.setEditable(false);
                        userText.setEditable(false);
                        passText.setEditable(false);
                        idText.setEditable(false);
                        numberText.setEditable(false);
                        addreText.setEditable(false);
                        mailText.setEditable(false);
                        salText.setEditable(false);


                        AdminFrame.centerPanel.add(firstName);
                        AdminFrame.centerPanel.add(firstNameText);
                        AdminFrame.centerPanel.add(lastName);
                        AdminFrame.centerPanel.add(lastNameText);
                        AdminFrame.centerPanel.add(username);
                        AdminFrame.centerPanel.add(userText);
                        AdminFrame.centerPanel.add(password);
                        AdminFrame.centerPanel.add(passText);
                        AdminFrame.centerPanel.add(ID);
                        AdminFrame.centerPanel.add(idText);
                        AdminFrame.centerPanel.add(pNumber);
                        AdminFrame.centerPanel.add(numberText);
                        AdminFrame.centerPanel.add(address);
                        AdminFrame.centerPanel.add(addreText);
                        AdminFrame.centerPanel.add(eMail);
                        AdminFrame.centerPanel.add(mailText);
                        AdminFrame.centerPanel.add(salary);
                        AdminFrame.centerPanel.add(salText);


                        JButton btnEdit = new JButton("Edit");
                        final JButton btnBack = new JButton("Back");

                        JPanel btnPanel = new JPanel();
                        btnPanel.setMinimumSize(new Dimension(400,50));
                        btnPanel.setPreferredSize(new Dimension(400, 50));

                        AdminFrame.centerPanel.add(btnPanel);
                        btnPanel.add(btnEdit);
                        btnPanel.add(btnBack);


                        btnEdit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {

                                firstNameText.setEditable(true);
                                lastNameText.setEditable(true);
                                userText.setEditable(true);
                                passText.setEditable(true);
                                idText.setEditable(true);
                                numberText.setEditable(true);
                                addreText.setEditable(true);
                                mailText.setEditable(true);
                                salText.setEditable(true);



                                Manager.managers.get(index).setName(firstNameText.getText());
                                Manager.managers.get(index).setLastName(lastNameText.getText());
                                Manager.managers.get(index).setUsername(userText.getText());
                                Manager.managers.get(index).setPassword(passText.getText());
                                Manager.managers.get(index).setID(idText.getText());

                                String num = numberText.getText();
                                Manager.managers.get(index).setPhoneNumber(Long.parseLong(num));
                                Manager.managers.get(index).setAddress(addreText.getText());
                                Manager.managers.get(index).seteMail(mailText.getText());

                                String sal = salText.getText();
                                Manager.managers.get(index).setSalary(Long.parseLong(sal));

                                System.out.println(Manager.managers.get(index).toString());


                                //write to file

                                Manager.writeManager();

                            }
                        });

                    }
                }

            }
        });

        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                adminManage = new AdminManage();
                setVisible(false);

                AdminFrame.centerPanel.add(adminManage);

            }
        });

    }
}
