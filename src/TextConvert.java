import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TextConvert extends JFrame {
    JTextField src=new JTextField(8);

    JTextField dest=new JTextField(8);
    JRadioButton [] button = new JRadioButton [4]; // 라디오박스 배열
    String [] names = {"decimal", "binary", "octal", "hex"}; // 라디오박스 문자열로 사용할 문자열 배열
    TextConvert() {
        setTitle("텍스트필드 만들기  예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        ButtonGroup g = new ButtonGroup();  // 버튼 그룹 객체 생성

        c.add(src);
        c.add(new JLabel("->"));
        c.add(dest);
        MyItemListener listener = new MyItemListener();
        for(int i=0; i<button.length; i++) {
            button[i] = new JRadioButton(names[i]); // names[]의 문자열로 라디오박스 생성
            c.add(button[i]); // 컨텐트팬에 라디오박스 삽입
            g.add(button[i]);// 버튼을 그룹화 합니다.(한개씩만 체크 되도록 하기 위해)
            button[i].addItemListener(listener); // 라디오박스에 Item 리스너 등록
        }
        setSize(300,150);
        setVisible(true);
    }
    class MyItemListener implements ItemListener {
        // 라디오박스의 선택 상태가 변하면 itemStateChanged()가 호출됨
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) { // 라디오박스가 선택된 경우
                int n=Integer.parseInt(src.getText());
                if(e.getItem() == button[0]) // decimal 라디오박스
                    dest.setText(Integer.toString(n));//10진수로 변환(그대로 유지)
                else if(e.getItem() == button[1]) // binary 라디오박스
                    dest.setText(Integer.toBinaryString(n));//2진수로 변환
                else if(e.getItem() == button[2]) // octal 라디오박스
                    dest.setText(Integer.toOctalString(n));//8진수로 변환
                else if(e.getItem() == button[3]) // hex 라디오박스
                    dest.setText(Integer.toHexString(n));//16진수로 변환
            }
        }
    }
    public static void main(String [] args) {
        new TextConvert();
    }
}