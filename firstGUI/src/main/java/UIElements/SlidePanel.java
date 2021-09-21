package UIElements;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SlidePanel extends JPanel {
    public JPanel insideMenu = new JPanel();

    public JButton delete = new JButton();
    public JButton modify = new JButton();
    public JLabel author = new JLabel();

    public JButton expand = new JButton();

    public JLabel title = new JLabel();
    public JLabel description = new JLabel("lsjkadhoasedhasoedhélaosbdéokasbdkbaskdasbdpas\npiaohdsohasohdoasdhasoéd\nOIDőai");

    public SlidePanel(){
        this.setPreferredSize(new Dimension(500,300));
        this.setBackground(Color.blue);
        this.setLayout(new BorderLayout());
        this.add(insideMenu, BorderLayout.NORTH);

        insideMenu.setLayout(new GridLayout(0,3));
        insideMenu.setPreferredSize(new Dimension(500,40));
        insideMenu.setBackground(new Color(0x82eefd));

        author.setPreferredSize(new Dimension(100,40));
        author.setText("Szerző : Kisbéla");
        modify.setPreferredSize(new Dimension( 100, 30));
        modify.setText("Modosítás");
        delete.setPreferredSize(new Dimension( 100, 30));
        delete.setText("Törlés!");

        insideMenu.add(author);
        insideMenu.add(modify);
        insideMenu.add(delete);

        description.setPreferredSize(new Dimension(400, 100));

        this.add(description, BorderLayout.CENTER);




    }
}
