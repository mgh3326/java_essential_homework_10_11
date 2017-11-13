import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RandomNumber_Game extends JFrame {
    JLabel [] numLab = new JLabel[10];
    Random ran = new Random();
    int x, y;
    boolean [] selectState = new boolean[10];
    RandomNumber_Game(){

        setTitle("Ten 레이블 클릭");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i = 0; i < selectState.length; i++)
            selectState[i] = false;//선택이 되면 false가 되도록 하였습니다.
       Container contentPane = getContentPane(); // 컨텐트팬 알아내기
        contentPane.setLayout(null);
        for(Integer i=0;i<10;i++){
            // 15 * 15 크기로  0에서 9까지 숫자를 가진 레이블 컴포넌트를 10개 만들고 이들을 프레임 내의 랜덤한 위치에 배치한다.
            numLab[i] = new JLabel(i.toString());
            x = (int)(Math.random()*350);//0~350의 랜덤 x
            y = (int)(Math.random()*270);//0~270의 랜덤 y
            numLab[i].setBounds(x, y, 15, 15);//크기를 15 * 15로 하였습니다.
            numLab[i].setForeground(Color.MAGENTA);//색상은 마젠타로 하였습니다.
            numLab[i].addMouseListener(new MyMouseListener());
            contentPane.add(numLab[i]);
        }
        setSize(400,400);// 프레임 크기 500x200 설정
        setVisible(true);//프레임을 화면에 출력
    }
    class MyMouseListener extends MouseAdapter {
        public void mousePressed (MouseEvent e) {
            int i;
            for(i = 0; i < selectState.length; i++)//차례대로 클릭되기 위해 사용하였습니다.
                if(!selectState[i])//selectState[i]==false
                    break;
            if(e.getSource().equals(numLab[i])) {//클릭 되어진다면 숫자가 안보여지도록 하였습니다.
                numLab[i].setVisible(false);
                selectState[i] = true;
            }
            if(i == 9)//9개의 숫자를 모두 맞힌 경우 처음처럼 새로 숫자를 만들도록 하였습니다.
                for(int j = 0; j < selectState.length; j++) {
                    x = (int)(Math.random()*350);//0~350의 랜덤 x
                    y = (int)(Math.random()*270);//0~270의 랜덤 y
                    numLab[j].setLocation(x, y);
                    numLab[j].setVisible(true);
                    selectState[j] = false;
                }
        }
    }
    public static void main(String[] args){
        new RandomNumber_Game();
    }
}