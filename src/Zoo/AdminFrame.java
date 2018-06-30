package Zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminFrame extends JFrame{

    public AdminEditInfo editInfo;
    public AdminManage accessManager;
    public static JPanel centerPanel;

    public AdminFrame(){

        editInfo = new AdminEditInfo();
        accessManager = new AdminManage();


        setMinimumSize(new Dimension(600,400));
        setPreferredSize(new Dimension(600,400));
        setResizable(false);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.cyan);
        rightPanel.setMinimumSize(new Dimension(200, 400));
        rightPanel.setPreferredSize(new Dimension(200, 400));
        add(rightPanel, BorderLayout.EAST);

        add(rightPanel, BorderLayout.EAST);

        centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(editInfo);
        centerPanel.add(accessManager);

        JButton btn1 = new JButton("Admin Edit");
        btn1.setMinimumSize(new Dimension(160,65));
        btn1.setPreferredSize(new Dimension(160,65));
        rightPanel.add(btn1);

        JButton btn2 = new JButton("Manager Options");
        btn2.setMinimumSize(new Dimension(160,65));
        btn2.setPreferredSize(new Dimension(160,65));
        rightPanel.add(btn2);


        JButton btn5 = new JButton("Back");
        btn5.setMinimumSize(new Dimension(160,65));
        btn5.setPreferredSize(new Dimension(160,65));
        rightPanel.add(btn5);


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editInfo.setVisible(true);
                accessManager.setVisible(false);

            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editInfo.setVisible(false);
                accessManager.setVisible(true);

            }
        });




        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                new Login();

            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}


