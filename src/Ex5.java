/*
 * "apple.jpg" 이미지를 로딩하여 그래픽으로 패널상의 (10, 10) 위치에 원본 크기로
 * 이미지를 그리고 + 키를 입력하면 이미지를 10% 확대하고 - 키를 입력하면 10% 축소
 * 시키는 스윙 응용프로그램을 작성하라.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex5 extends JFrame {
    Container contentPane;
    AppleLabel appleLabel;
    ImageIcon appleIco = new ImageIcon("images/apple.jpg");
    Image appleImg = appleIco.getImage();
    int width = appleIco.getIconWidth();
    int height = appleIco.getIconHeight();
    Ex5 () {
        setTitle("Ex5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        contentPane = getContentPane();
        contentPane.setLayout(null);
        appleLabel = new AppleLabel();
        appleLabel.setBounds(10, 10, width, height);
        contentPane.addKeyListener(new ImgSizeControl());
        contentPane.add(appleLabel);
        setVisible(true);
        contentPane.requestFocus();
    }
    class AppleLabel extends JLabel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(appleImg, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    class ImgSizeControl extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if(e.getKeyChar() == '+') {
                width = width + (int)(width * 0.1);
                height = height + (int)(height * 0.1);
                appleLabel.setBounds(10, 10, width, height);
            }
            else if(e.getKeyChar() == '-') {
                width = width - (int)(width * 0.1);
                height = height - (int)(height * 0.1);
                appleLabel.setBounds(10, 10, width, height);
            }
        }
    }
    public static void main(String [] args) {
        new Ex5 ();
    }
}