import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TextConvert extends JFrame {
    JTextField src=new JTextField(8);

    JTextField dest=new JTextField(8);
    JRadioButton [] button = new JRadioButton [4]; // 체크박스 배열
    String [] names = {"decimal", "binary", "octal", "hex"}; // 체크박스 문자열로 사용할 문자열 배열
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
            button[i] = new JRadioButton(names[i]); // names[]의 문자열로 체크박스 생성
//            button[i].setBorderPainted(true); // 체크박스의 외곽선이 보이도록 설정
            c.add(button[i]); // 컨텐트팬에 체크박스 삽입
            g.add(button[i]);
            button[i].addItemListener(listener); // 체크박스에 Item 리스너 등록
        }
        // 라디오버튼 3 개 생성
//        JRadioButton decimal = new JRadioButton("decimal", true);
//        JRadioButton binary = new JRadioButton("binary");
//        JRadioButton octal = new JRadioButton("octal");
//        JRadioButton hex = new JRadioButton("hex");
//
//        // 버튼 그룹에 3개의 라디오버튼 삽입
//        g.add(decimal);
//        g.add(binary);
//        g.add(octal);
//        g.add(hex);
//        c.add(decimal); c.add(binary); c.add(octal); c.add(hex);

//        int n=Integer.parseInt(src.getText());
//        dest.setText(Integer.toBinaryString(n));

        /*c.add(new JLabel("이름  "));
        c.add(new JTextField(20)); // 창의 열 개수 20
        c.add(new JLabel("학과  "));
        c.add(new JTextField("컴퓨터공학과", 20)); // 창의 열 개수 20
        c.add(new JLabel("주소  "));
        c.add(new JTextField("서울시 ...", 20)); // 창의 열 개수 20*/

        setSize(300,150);
        setVisible(true);
    }
//     Item 리스너 구현
    class MyItemListener implements ItemListener {
        int sum = 0; // 가격의 합

        // 체크박스의 선택 상태가 변하면 itemStateChanged()가 호출됨
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) { // 체크박스가 선택된 경우
                int n=Integer.parseInt(src.getText());
                if(e.getItem() == button[0]) // 사과 체크박스
                    dest.setText(Integer.toString(n));
                else if(e.getItem() == button[1]) // 배 체크박스
                    dest.setText(Integer.toBinaryString(n));
                else if(e.getItem() == button[2]) // 배 체크박스
                    dest.setText(Integer.toOctalString(n));
                else if(e.getItem() == button[3]) // 배 체크박스
                    dest.setText(Integer.toHexString(n));
            }

//            sumLabel.setText("현재 "+sum+"원 입니다."); // 합 출력
        }
    }
    public static void main(String [] args) {
        new TextConvert();
    }
}