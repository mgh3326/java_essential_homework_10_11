import javax.swing.*;//10장 4번 문제
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBox extends JFrame {
    JCheckBox [] button = new JCheckBox [2]; // 체크박스 배열
    String [] names = {"버튼 비활성화", "버튼 감추기"}; // 체크박스 문자열로 사용할 문자열 배열
    JButton btn = new JButton("test button");
    CheckBox() {
        setTitle("CheckBox와 Item Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // 3 개의 체크박스를 생성한다.
//        JCheckBox button_unvisialbe = new JCheckBox("버튼 비활성화");
//        JCheckBox button_hide = new JCheckBox("버튼 감추기");



        MyItemListener listener = new MyItemListener();
        for(int i=0; i<button.length; i++) {
            button[i] = new JCheckBox(names[i]); // names[]의 문자열로 체크박스 생성
//            fruits[i].setBorderPainted(true); // 체크박스의 외곽선이 보이도록 설정
            c.add(button[i]); // 컨텐트팬에 체크박스 삽입
            button[i].addItemListener(listener); // 체크박스에 Item 리스너 등록
        }

        // 컨텐트팬에 3개의 체크박스 삽입
//        c.add(button_unvisialbe);
//        c.add(button_hide);
        c.add(btn);
//        btn.setEnabled(false);
        setSize(250,200);
        setVisible(true);
    }
    // Item 리스너 구현
    class MyItemListener implements ItemListener {
//        int sum = 0; // 가격의 합

        // 체크박스의 선택 상태가 변하면 itemStateChanged()가 호출됨
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) { // 체크박스가 선택된 경우
                if(e.getItem() == button[0]) // 사과 체크박스
                    btn.setEnabled(false);
                else if(e.getItem() == button[1]) // 배 체크박스
                    btn.setVisible(false);
            }
            else { // 체크박스가 해제된 경우
                if(e.getItem() == button[0]) // 사과 체크박스
                    btn.setEnabled(true);
                else if(e.getItem() == button[1]) // 배 체크박스
                    btn.setVisible(true);
            }
            //sumLabel.setText("현재 "+sum+"원 입니다."); // 합 출력
        }
    }
    public static void main(String [] args) {
        new CheckBox();
    }
}
//https://m.blog.naver.com/PostView.nhn?blogId=woncaesar&logNo=70142173324&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
//


