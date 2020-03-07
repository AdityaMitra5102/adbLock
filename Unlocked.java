import javax.swing.*;
import java.awt.event.*;
class Unlocked implements ActionListener
{
    Icon icon=new ImageIcon(getClass().getResource("unlocked.png"));
    JLabel li=new JLabel(icon);
    JPanel p=new JPanel();
    JFrame fr=new JFrame("UNLOCKED");
    JButton lo=new JButton("LOCK");
    JButton st=new JButton("START OPERATION");
    JButton ex=new JButton("EXIT");
    Unlocked()
    {
        p.add(li);
        p.add(lo);
        p.add(st);
        p.add(ex);

        lo.addActionListener(this);
        st.addActionListener(this);
        ex.addActionListener(this);
        fr.add(p);
        fr.setSize(512,285);
        fr.setResizable(true);
        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==st)
        {
            try{
                Process ec=Runtime.getRuntime().exec("notepad mySecretFile.sls");
                fr.setVisible(false);
            }catch(Exception e){}
        }
        else if(evt.getSource()==lo)
        {
            fr.setVisible(false);
            new HomeScreen();
        }
        else
        {
            fr.setVisible(false);
        }
        
    }
}
