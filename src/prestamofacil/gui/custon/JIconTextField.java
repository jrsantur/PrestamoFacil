/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamofacil.gui.custon;


import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Junior
 */

 

public class JIconTextField extends JTextField{

    private Icon icon;
    private Insets dummyInsets;

    public JIconTextField(){
        super();
        this.icon = createImageIcon("find-16x16.png");
        setIcon(createImageIcon("find-16x16.png"));
        javax.swing.border.Border border = UIManager.getBorder("TextField.border");
        JTextField dummy = new JTextField();
        this.dummyInsets = border.getBorderInsets(dummy);
        setMargin(new Insets(2, 2, 2, 2));
    }

    public void setIcon(Icon icon){
        this.icon = icon;
    }

    public Icon getIcon(){
        return this.icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(this.icon!=null){
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            int x = this.getWidth() - dummyInsets.right - iconWidth; //this x is our icon's x
            int y = (this.getHeight() - iconHeight)/2;
            icon.paintIcon(this, g, x, y);
        }

    }
    
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = this.getClass().getClassLoader().getResource(path);
        if (imgURL != null)
            return new ImageIcon(imgURL);
        else
        	return null;
    }

}
