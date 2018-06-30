package Zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminManage extends JPanel{

    public AdminAddMan addManPanel;
    public AdminDelMan delManPanel;
    public AdminEditMan editManPanel;
    public AdminShowMan showManPanel;

    public AdminManage(){

        setMaximumSize(new Dimension(600, 400));
        setPreferredSize(new Dimension(600, 400));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.pink);
        rightPanel.setMinimumSize(new Dimension(200, 400));
        rightPanel.setPreferredSize(new Dimension(200, 400));
        add(rightPanel, BorderLayout.EAST);

        add(rightPanel, BorderLayout.EAST);

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);

        JButton btn1 = new JButton("Add Manager");
        btn1.setMinimumSize(new Dimension(160,65));
        btn1.setPreferredSize(new Dimension(160,65));
        rightPanel.add(btn1);

        JButton btn2 = new JButton("Delete Manager");
        btn2.setMinimumSize(new Dimension(160,65));
        btn2.setPreferredSize(new Dimension(160,65));
        rightPanel.add(btn2);

        JButton btn3 = new JButton("Edit Manager");
        btn3.setMinimumSize(new Dimension(160,65));
        btn3.setPreferredSize(new Dimension(160,65));
        rightPanel.add(btn3);

        JButton btn4 = new JButton("Show Manager");
        btn4.setMinimumSize(new Dimension(160,65));
        btn4.setPreferredSize(new Dimension(160,65));
        rightPanel.add(btn4);

        JButton btn5 = new JButton("Close");
        btn5.setMinimumSize(new Dimension(160,65));
        btn5.setPreferredSize(new Dimension(160,65));
        rightPanel.add(btn5);



        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                addManPanel = new AdminAddMan();
                setVisible(false);
                AdminFrame.centerPanel.add(addManPanel);

            }
        });

        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                delManPanel = new AdminDelMan();
                AdminFrame.centerPanel.add(delManPanel);

            }
        });

        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                setVisible(false);
                editManPanel = new AdminEditMan();
                AdminFrame.centerPanel.add(editManPanel);

            }
        });

        btn4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                showManPanel = new AdminShowMan();
                AdminFrame.centerPanel.add(showManPanel);

            }
        });


        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);

            }
        });

//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
