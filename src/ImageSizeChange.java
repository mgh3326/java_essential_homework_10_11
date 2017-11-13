import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageSizeChange extends JFrame {
    ImageIcon icon = new ImageIcon("img.jpg");// 이미지 로딩
    Image img = icon.getImage(); // 이미지 객체
    int width = img.getWidth(this);//이미지의 폭, 픽셀 단위
    int height = img.getHeight(this);//이미지의 높이, 픽셀 단위

    ImageSizeChange() {
        setTitle("그래픽 이미지 10% 확대 축소");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//View 종료시에 프로그램도 종료되도록 합니다.
        setContentPane(new MyPanel());
        setSize(400, 400);//사이즈는 400*400으로 하였습니다.
        setVisible(true);
        //getContentPane().requestFocus();
    }
    class MyPanel extends JPanel
    {
        public MyPanel()
        {
            addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent e)
                {
                    if(e.getKeyChar() == '+')//+키를 입력하면 이미지를 10% 확대합니다.
                    {
                        width = (int)(width+(width*0.1));
                        height = (int)(height+(height*0.1));
                        repaint();
                    }
                    else if(e.getKeyChar() == '-')//-키를 입력하면 이미지를 10% 축소합니다.
                    {
                        width = (int)(width-(width*0.1));
                        height = (int)(height-(height*0.1));
                        repaint();
                    }
                }
            });
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 이미지를 패널의(10,10)에 원래의 크기로 그린다.
            g.drawImage(img, 10, 10,width,height, this);//10,10 위치에 원본 크기로 출력합니다.
            super.requestFocus();	// 컨텐트팬이 키 입력을 받을 수 있도록 포커스 강제 지정
        }
    }
    public static void main(String [] args) {
        new ImageSizeChange();
    }
}