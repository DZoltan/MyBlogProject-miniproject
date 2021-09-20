package UIElements;


import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

     public Button(String Text, int x, int y, int width, int height){
         this.setBounds(x, y, width, height);
         this.setText(Text);
         this.setBackground(new Color(0x99e5c3));
         this.setForeground(new Color(0x234f1e));
         this.setFont(new Font("Roboto Mono",Font.BOLD, 32));
         this.setBorder(BorderFactory.createEtchedBorder());
     }
}
