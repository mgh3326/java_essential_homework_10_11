import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ImageSizeChange extends JFrame {
    ImageIcon icon = new ImageIcon("images/image0.jpg");// 이미지 로딩
    Image img = icon.getImage(); // 이미지 객체
    int width = img.getWidth(this);//이미지의 폭, 픽셀 단위
    int height = img.getWidth(this);//이미지의 높이, 픽셀 단위
    ImageSizeChange() {
        setTitle("원본 크기로 원하는 위치에 이미지 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(300, 400);
        setVisible(true);
    }

    class MyPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 이미지를 패널의(10,10)에 원래의 크기로 그린다.
            g.drawImage(img, 10, 10, this);
            super.addKeyListener(new MyKeyListener());
            super.requestFocus();	// 컨텐트팬이 키 입력을 받을 수 있도록 포커스 강제 지정




        }
    }
    class MyKeyListener extends KeyAdapter { // Key 리스너 구현
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode(); // 입력된 키의 키코드를 알아낸다.

            switch (keyCode) { // 키 코드에 따라 상,하,좌,우 키 판별, 레이블의 위치 이동
                case KeyEvent.VK_UP:  //UP 키
                    repaint(10, 10, 5, 5);
                    break;
                case KeyEvent.VK_DOWN:  //UP 키
                    repaint(10, 10, width / 2, height / 2);
                    break;
            }
        }
    }
    public static void main(String [] args) {
        new ImageSizeChange();
    }
}