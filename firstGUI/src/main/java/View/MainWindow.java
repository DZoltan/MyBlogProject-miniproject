package View;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

public class MainWindow extends JFrame{
    public JPanel mainPanel = new JPanel();
    public JPanel menuPanel = new JPanel();


    UIElements.Button login = new UIElements.Button("Login",20, 200, 160, 80);
    UIElements.Button search = new UIElements.Button("Search",20, 400, 160, 80);
    UIElements.Button logout = new UIElements.Button("Logout",20, 600, 160, 80);


    public MainWindow(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setSize(815,800); // sets the x-dimension & y-dimension of frame
        this.setLayout(null);
        this.setVisible(true); //make frame visible
        this.setResizable(false);
        createUIComponents();
    }

    private void createUIComponents() {


        menuPanel.setBounds(0, 0, 200, 800);
        menuPanel.setBackground(new Color(0x028a0f));
        menuPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,5,new Color(0x234f1e)));


        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setPreferredSize(new Dimension(600,1600));
        mainPanel.setAutoscrolls(true);

        mainPanel.add(new UIElements.SlidePanel());
        mainPanel.add(new UIElements.SlidePanel());
        mainPanel.add(new UIElements.SlidePanel());

        JScrollPane scrollFrame = new JScrollPane(mainPanel);
        scrollFrame.setBounds(200, 0, 600, 800);
        scrollFrame.setPreferredSize(new Dimension(600, 800));

        this.add(login);
        this.add(search);
        this.add(logout);


        this.add(scrollFrame);
        this.add(menuPanel);
    }
}
