/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamofacil.gui.custon;

/**
 *
 * @author Junior
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import prestamofacil.gui.Splash;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class MetroTextBox extends JTextField implements ComponentListener {
 
    private final JButton button = new JButton();//X
    private Color borderColor = Color.black;
    JTextField jTextField1 = new JTextField(); 
    
  
    
    //imagenes X
    private ImageIcon iconBlack = new ImageIcon(getClass().getResource("/prestamofacil/gui/custon/find.png"));
    private ImageIcon iconWhite = null; 
    
    //private ImageIcon iconWhite =new ImageIcon(getClass().getResource("/org/bolivia/resources/metro_x_w.png"));
    private boolean xBlackIcon =true;    
    private Dimension dimension; 
    //la altura del boton
    private int heightBtn;
    
    /**Constructor de clase */
    public MetroTextBox()
    {   
        dimension = new Dimension(300,28);//tamaño del textbox
        heightBtn = dimension.height - 10;
            
        setSize(dimension);        
        setPreferredSize(dimension);
        
        //propiedades del button
        button.setText("");                        
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setMargin(new Insets(2, 2, 2, 2));
        button.setVisible(true);
        button.setFocusPainted(false);
        //button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add( button );
        setVisible(true);
        addComponentListener(this);                
        setSelectionColor(button.getBackground());
        updateButton();        
        //
        button.addMouseListener( new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {                
                //((JTextField) button.getParent()).setText(""); //elimina contenido
            }

            @Override
            public void mousePressed(MouseEvent e) {/*...*/}

            @Override
            public void mouseReleased(MouseEvent e) {/*...*/}

            @Override
            public void mouseEntered(MouseEvent e) {
               // button.setOpaque(true);  
               // button.setIcon( (xBlackIcon)? iconBlack:iconWhite );     
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setOpaque(false);  
                //button.setIcon( null );     
            }
            
        });
        
    }
    //------------
    public boolean isxDarkIcon() {
        return xBlackIcon;
    }

    public void setxDarkIcon(boolean xDarkIcon) {
        this.xBlackIcon = xDarkIcon;        
    }
    
    public Color getBotonColor() {
        return button.getBackground();
    }

    public void setBotonColor(Color botonColor) {
        button.setBackground(botonColor); 
        setSelectionColor(button.getBackground());
    }
    
    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        //updateBorder();
    }
    //------------
    /** Actualiza las propiedades del borde del TextField */
    private void updateBorder()
    {
        Border border = BorderFactory.createLineBorder( borderColor ,2);
        setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(10, 10, 10, button.getSize().width + 5 )));
        
    }
    
    /** Ajusta la dimension y posicion del boton X*/
    private void updateButton()
    {
        //tamaño boton
        heightBtn = this.getSize().height - 10;
        button.setSize( new Dimension(heightBtn, heightBtn));
        button.setIcon(iconBlack);
        button.setPreferredSize( new Dimension(heightBtn, heightBtn) );        
        //posicion
        button.setLocation(getWidth()-button.getWidth()-5, 5);
        //updateBorder();
    }
    
    //------------
    @Override
    public void componentResized(ComponentEvent e) {
        updateButton(); 
    }

    @Override
    public void componentMoved(ComponentEvent e) {/*...*/}

    @Override
    public void componentShown(ComponentEvent e) {/*...*/}

    @Override
    public void componentHidden(ComponentEvent e) {/*...*/}    
    //------------
}
