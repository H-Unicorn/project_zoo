package Zoo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminEditInfo extends JPanel {

    private static SuperAdmin superAdmin = new SuperAdmin();

    int flage = 0;

    public AdminEditInfo(){

        setMinimumSize(new Dimension(350,350));
        setPreferredSize(new Dimension(350, 350));
        BoxLayout centerLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(centerLayout);

        final JLabel username = new JLabel("Username :");
        final JTextField usernameText = new JTextField(superAdmin.getUsername());
        usernameText.setMinimumSize(new Dimension(50,20));
        usernameText.setPreferredSize(new Dimension(50, 20));
        usernameText.setEditable(false);

        JLabel password = new JLabel("Password :");
        final JTextField passwordText = new JTextField(superAdmin.getPassword());
        passwordText.setMinimumSize(new Dimension(200,30));
        passwordText.setPreferredSize(new Dimension(200, 30));
        passwordText.setEditable(false);

        final JLabel email = new JLabel("Email :");
        final JTextField emailText = new JTextField(superAdmin.getEmail());
        emailText.setMinimumSize(new Dimension(200,30));
        emailText.setPreferredSize(new Dimension(200, 30));
        emailText.setEditable(false);

        add(username);
        add(usernameText);
        add(password);
        add(passwordText);
        add(email);
        add(emailText);

        JButton btnSave = new JButton("Save");
        final JButton btnEdit = new JButton("Edit");

        JPanel btnPanel = new JPanel();
        btnPanel.setMinimumSize(new Dimension(400,50));
        btnPanel.setPreferredSize(new Dimension(400, 50));

        add(btnPanel);
        btnPanel.add(btnSave);
        btnPanel.add(btnEdit);

        btnEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(flage == 0){

                    usernameText.setEditable(true);
                    passwordText.setEditable(true);
                    emailText.setEditable(true);

                    btnEdit.setText("Cancel");
                }
                if(flage == 1){
                    usernameText.setEditable(false);
                    passwordText.setEditable(false);
                    emailText.setEditable(false);

                    btnEdit.setText("Edit");
                }

                if(btnEdit.getText().equals("Cancel"))
                    flage=1;
                else flage=0;
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String un = usernameText.getText();
                String p = passwordText.getText();
                String em = emailText.getText();

                SuperAdmin.writeAdmin(un, p, em);

            }
        });

    }
}

