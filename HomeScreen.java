import javax.swing.*;
import java.awt.event.*;
class HomeScreen implements ActionListener
{
    Icon icon=new ImageIcon(getClass().getResource("connectDevice.png"));
    JLabel li=new JLabel(icon);
    JPanel p=new JPanel();
    JFrame fr=new JFrame("WELCOME");
    JButton ul=new JButton("UNLOCK");
    JButton ex=new JButton("EXIT");
    HomeScreen()
    {
        setDesign();
        p.add(li);
        p.add(ul);
        p.add(ex);
        
        ul.addActionListener(this);
        ex.addActionListener(this);
        fr.add(p);
        fr.setSize(512,285);
        fr.setResizable(true);
        fr.setVisible(true);
    }

    public final void setDesign() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {  
        }
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==ul)
        {
            try{
                if(DeviceChecker.isConnected())
                {
                    fr.setVisible(false);
                    new Unlocked();
                }
                else
                {
                    fr.setVisible(false);
                    new NotConnected();
                }
            }catch(Exception e){}
        }
        else
        {
            fr.setVisible(false);
        }
    }
}
