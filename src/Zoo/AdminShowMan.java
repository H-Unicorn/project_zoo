package Zoo;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminShowMan extends JPanel {

    public AdminManage adminManage;


    public AdminShowMan(){

        setMinimumSize(new Dimension(350,350));
        setPreferredSize(new Dimension(350,350));
        EmptyBorder showInfoBorder = new EmptyBorder(40,70,0,0);
        BoxLayout centerLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(centerLayout);

        final JLabel id = new JLabel("ID of Manager: ");
        JTextField idText = new JTextField();
        idText.setMinimumSize(new Dimension(50,20));
        idText.setPreferredSize(new Dimension(50, 20));

        add(id);
        add(idText);

        JButton btnShow = new JButton("Show");
        final JButton btnBack = new JButton("Back");

        JPanel btnPanel = new JPanel();
        btnPanel.setMinimumSize(new Dimension(400,50));
        btnPanel.setPreferredSize(new Dimension(400, 50));

        add(btnPanel);
        btnPanel.add(btnShow);
        btnPanel.add(btnBack);

        btnShow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String idFind = idText.getText();

                for (int i = 0; i < Manager.managers.size(); i++){

                    if (Manager.managers.get(i).getID().equals(idFind)){

                        setVisible(false);


                        JLabel firstName = new JLabel("first name :" + Manager.managers.get(i).getName());
                        firstName.setFont(new Font("arial",Font.BOLD,12));
                        firstName.setBorder(showInfoBorder);
                        AdminFrame.centerPanel.add(firstName);

                        JLabel lastName = new JLabel("last name :" + Manager.managers.get(i).getLastName());
                        lastName.setFont(new Font("arial",Font.BOLD,12));
                        lastName.setBorder(showInfoBorder);
                        AdminFrame.centerPanel.add(lastName);

                        JLabel userName = new JLabel("user name :"+Manager.managers.get(i).getUsername());
                        userName.setFont(new Font("arial", Font.BOLD, 12));
                        userName.setBorder(showInfoBorder);
                        AdminFrame.centerPanel.add(userName);

                        JLabel password = new JLabel("password :"+Manager.managers.get(i).getPassword());
                        password.setFont(new Font("arial", Font.BOLD, 12));
                        password.setBorder(showInfoBorder);
                        AdminFrame.centerPanel.add(password);

                        JLabel ID = new JLabel("ID :" + Manager.managers.get(i).getID());
                        ID.setFont(new Font("arial", Font.BOLD, 12));
                        ID.setBorder(showInfoBorder);
                        AdminFrame.centerPanel.add(ID);

                        JLabel phoneNumber = new JLabel("Phone Number :" + Manager.managers.get(i).getPhoneNumber());
                        phoneNumber.setFont(new Font("arial", Font.BOLD, 12));
                        phoneNumber.setBorder(showInfoBorder);
                        AdminFrame.centerPanel.add(phoneNumber);

                        JLabel address = new JLabel("Address :" + Manager.managers.get(i).getAddress());
                        address.setFont(new Font("arial", Font.BOLD, 12));
                        address.setBorder(showInfoBorder);
                        AdminFrame.centerPanel.add(address);

                        JLabel eMail = new JLabel("EMail :" + Manager.managers.get(i).geteMail());
                        eMail.setFont(new Font("arial", Font.BOLD, 12));
                        eMail.setBorder(showInfoBorder);
                        AdminFrame.centerPanel.add(eMail);

                        JLabel salary = new JLabel("Salary :" + Manager.managers.get(i).getSalary());
                        salary.setFont(new Font("arial", Font.BOLD, 12));
                        salary.setBorder(showInfoBorder);
                        AdminFrame.centerPanel.add(salary);
                    }
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                setVisible(false);
                adminManage = new AdminManage();
                AdminFrame.centerPanel.add(adminManage);

            }
        });

    }
}
