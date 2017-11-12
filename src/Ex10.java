/*
 * 10. 10개의 레이블을 순서대로 클릭하는 간단한 게임을 만들어보자. 15 * 15 크기로
 * 0에서 9까지 숫자를 가진 레이블 컴포넌트를 10개 만들고 이들을 프레임 내의 랜덤한
 * 위치에 배치한다. 사용자가 0부터 9까지 순서대로 클릭하여 10개를 모두 클릭하면
 * 다시 10개의 레이블을 랜덤한 위치에 배치한다. 클릭된 레이블 컴포넌트는 화면에서
 * 보이지 않게 하며 반드시 번호 순서로 클릭되게 하라.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ex10 extends JFrame {
    JLabel [] numLab = new JLabel[10];
    Container contentPane;
    Random ran = new Random();
    int x, y;
    boolean [] clickState = new boolean[10];

    Ex10 () {
        setTitle("Ten 레이블 클릭");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i = 0; i < clickState.length; i++)
            clickState[i] = false;

        contentPane = getContentPane();
        contentPane.setLayout(null);

        for(Integer i = 0; i < 10; i++) {
            numLab[i] = new JLabel(i.toString());
            x = randomX();
            y = randomY();
            numLab[i].setBounds(x, y, 15, 15);
            numLab[i].setForeground(Color.MAGENTA);
            numLab[i].addMouseListener(new LabelListener());
            contentPane.add(numLab[i]);
        }

        setVisible(true);
    }
    class LabelListener extends MouseAdapter {
        public void mousePressed (MouseEvent e) {
            int i;
            for(i = 0; i < clickState.length; i++)
                if(!clickState[i])
                    break;
            if(e.getSource().equals(numLab[i])) {
                numLab[i].setVisible(false);
                clickState[i] = true;
            }
            if(i == 9)
                for(int j = 0; j < clickState.length; j++) {
                    x = randomX();
                    y = randomY();
                    numLab[j].setLocation(x, y);
                    numLab[j].setVisible(true);
                    clickState[j] = false;
                }
        }
    }
    public int randomX () { int x = ran.nextInt(370); return x; }
    public int randomY () { int y = ran.nextInt(350); return y; }

    public static void main(String [] args) {
        new Ex10 ();
    }
}