import java.awt.event.*;
import javax.swing.*;
public class randomLabels extends JFrame
{
    int ci = 0;
    JLabel[] jl = new JLabel[10];
    randomLabels()
    {
        setTitle("Ten 레이블 클릭");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        setSize(300, 300);
        setVisible(true);
        for (int i = 0; i < jl.length; i++)
        {
            jl[i] = new JLabel("" + i + "");
            jl[i].setSize(15, 15);
            int x = (int) (Math.random() * 250);
            int y = (int) (Math.random() * 250);
            jl[i].setLocation(x, y);
            jl[i].addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    System.out.println(ci);
                    JLabel la = (JLabel) e.getSource();
                    if ( ci < 10 &&la == jl[ci])
                    {
                        jl[ci].setVisible(false);
                        ci++;
                    }
                    if(ci > 9)
                    {
                        ci = 0;
                        for(int i = 0; i < jl.length; i++)
                        {
                            jl[i].setVisible(true);
                            int x = (int) (Math.random() * 250);
                            int y = (int) (Math.random() * 250);
                            jl[i].setLocation(x, y);
                        }
                    }
                }
            });
            add(jl[i]);
        }
    }
    public static void main(String[] args)
    {
        new randomLabels();

    }
}