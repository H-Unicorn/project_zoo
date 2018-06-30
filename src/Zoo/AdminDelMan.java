package Zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDelMan extends JPanel{

    public AdminManage adminManage;

    public AdminDelMan(){

        setMaximumSize(new Dimension(350, 350));
        setPreferredSize(new Dimension(350, 350));
        BoxLayout centerLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(centerLayout);


        final JLabel id = new JLabel("ID of Manager: ");
        JTextField idText = new JTextField();
        idText.setMinimumSize(new Dimension(50,20));
        idText.setPreferredSize(new Dimension(50, 20));

        add(id);
        add(idText);


        JButton btnDelete = new JButton("Delete");
        final JButton btnBack = new JButton("Back");

        JPanel btnPanel = new JPanel();
        btnPanel.setMinimumSize(new Dimension(400,50));
        btnPanel.setPreferredSize(new Dimension(400, 50));

        add(btnPanel);
        btnPanel.add(btnDelete);
        btnPanel.add(btnBack);

        btnDelete.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String idFind = idText.getText();

                System.out.println(idText);

                for(int i = 0; i < Manager.managers.size(); i++){

                    if (Manager.managers.get(i).getID().equals(idFind)){

                        System.out.println(Manager.managers.get(i).toString());

                        Manager.managers.remove(i);
                    }
                }

                for (int i = 0; i < Manager.managers.size(); i++){

                    System.out.println(Manager.managers.get(i).toString());
                }

                //write to file

                Manager.writeManager();

                btnDelete.setEnabled(false);

                setVisible(false);

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
