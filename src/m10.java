//10.10개의 레이블을 순서대로 클릭하는 간단한 게임을 만들어 보자. 15 x 15 크기로 0에서 9까지 숫자를 가진 레이블 컴포넌트를 10개 만들고 이들을 프레임 내에 랜덤한 위치에 배치한다. 사용자가 0부터 9까지 순서대로 클릭하여 10개를 모두 클릭하면 다시 10개의 레이블을 랜덤한 위치에 배치한다. 클릭된 레이블 컴포넌트는 화면에서 보이지 않게 하며 반드시 번호 순서로 클릭되게 하라.

        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;
        import javax.swing.event.*;

class Frame10 extends JFrame
{
    JPanel p = new JPanel();
    JLabel[] la = new JLabel[10];
    int j = 0;

    Frame10()
    {
        this.setTitle("Focus Practice Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p.setLayout(null);
        for(int i= 0; i <la.length; i++)
        {
            int x = (int)(Math.random()*300);
            int y = (int)(Math.random()*300);
            la[i] = new JLabel();
            la[i].setText(Integer.toString(i));
            la[i].setSize(15, 15);
            la[i].setLocation(x, y);
            la[i].addMouseListener(new MyMouseListener());
            p.add(la[i]);
        }
        this.add(p);
        this.setSize(350, 350);
        this.setVisible(true);
    }

    class MyMouseListener extends MouseAdapter
    {

        public void mouseClicked(MouseEvent e)
        {
            JLabel label = new JLabel();
            label = (JLabel)e.getSource();

            if(Integer.parseInt(label.getText()) <= Integer.parseInt(la[j].getText()))
            {
                label.setVisible(false);
                j++;
                if(Integer.parseInt(label.getText()) == 9)
                {
                    for(int i =0; i < la.length; i++)
                    {
                        int x = (int)(Math.random()*300);
                        int y = (int)(Math.random()*300);
                        la[i].setLocation(x, y);
                        la[i].setVisible(true);
                    }
                }
            }
        }

    }
}

public class m10
{
    public static void main(String[] args)
    {
        new Frame10();
    }

}

