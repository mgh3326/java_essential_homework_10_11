import java.awt.*;  import javax.swing.*;

public class RandomNumber_Game extends JFrame {
    RandomNumber_Game(){
        setTitle("Random Labels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane(); // 컨텐트팬 알아내기
        contentPane.setLayout(null);
        for(int i=0;i<10;i++){
            JLabel label = new JLabel();//레이블 컴포넌트 생성
            int x = (int)(Math.random()*200) + 50;//50~200의 랜덤 x
            int y = (int)(Math.random()*200) + 50;//50~200의 랜덤 y
            label.setLocation(x,y);//label을 (x,y)에 배치
            label.setSize(10,10);//label 크기를 10x10으로 설정
            label.setOpaque(true);//label의 배경색이 보이게함
            label.setText(Integer.toString(i));
//            label.setForeground(Color.PINK);
//            label.setBackground(Color.BLUE);//색 파랑
            contentPane.add(label);//컨테이너에 라벨을 담음
        };
        setSize(300,300);// 프레임 크기 500x200 설정
        setVisible(true);//프레임을 화면에 출력
    }
    public static void main(String[] args){
        new RandomNumber_Game();
    }
}