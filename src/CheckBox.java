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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//View 종료시에 프로그램도 종료되도록 합니다.
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        MyItemListener listener = new MyItemListener();
        for(int i=0; i<button.length; i++) {
            button[i] = new JCheckBox(names[i]); // names[]의 문자열로 체크박스 생성
//            fruits[i].setBorderPainted(true); // 체크박스의 외곽선이 보이도록 설정
            c.add(button[i]); // 컨텐트팬에 체크박스 삽입
            button[i].addItemListener(listener); // 체크박스에 Item 리스너 등록
        }

        c.add(btn);//컨텐트팬에 버튼 삽입
        setSize(250,200);
        setVisible(true);
    }
    // Item 리스너 구현
    class MyItemListener implements ItemListener {
        // 체크박스의 선택 상태가 변하면 itemStateChanged()가 호출됨
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) { // 체크박스가 선택된 경우
                if(e.getItem() == button[0]) // 0번째 즉 버튼 비활성화 체크시 버튼이 비활성화 됩니다.
                    btn.setEnabled(false);
                else if(e.getItem() == button[1]) // 1번째 즉 버튼 감추기 체크시 버튼이 감추기 됩니다.
                    btn.setVisible(false);
            }
            else { // 체크박스가 해제된 경우
                if(e.getItem() == button[0])  // 0번째 즉 버튼 비활성화 체크가 해지 된 경우 활성화 됩니다.
                    btn.setEnabled(true);
                else if(e.getItem() == button[1]) // 1번째 즉 버튼 감추기 체크가 해지 된 경우 버튼이 보이게 됩니다.
                    btn.setVisible(true);
            }
        }
    }
    public static void main(String [] args) {
        new CheckBox();
    }
}


