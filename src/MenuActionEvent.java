import javax.swing.*;//10장 2번 문제
import java.awt.event.*;
import java.awt.*;

public class MenuActionEvent extends JFrame {
    JLabel imgLabel = new JLabel(); // 빈 이미지를 가진 레이블
    MenuActionEvent() {
        setTitle("메뉴 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//View 종료시에 프로그램도 종료되도록 합니다.
        createMenu();
        getContentPane().add(imgLabel, BorderLayout.CENTER);
        setSize(350,300); setVisible(true);//350 300으로 크기 지정하였습니다.
    }

    void createMenu() {
        JMenuBar mb = new JMenuBar(); // 메뉴바 생성
        // 메뉴바에 메뉴 삽입
        mb.add(new JMenu("파일")); // 파일 메뉴 생성 삽입
        mb.add(new JMenu("편집")); // 편집 메뉴 생성 삽입
        JMenu viewer = new JMenu("보기"); // 보기 메뉴 생성
        viewer.add(new JMenuItem("확면확대"));// 화면 메뉴에 메뉴아이템 화면확대 생성 삽입
        viewer.addSeparator(); // 분리선 삽입
        viewer.add(new JMenuItem("쪽윤곽"));// 화면 메뉴에 메뉴아이템 화면 쪽윤곽 삽입
        mb.add(viewer); // viewer 메뉴 삽입
        mb.add(new JMenu("입력")); // 입력 메뉴 생성 삽입
        // 메뉴바를 프레임에 부착
        setJMenuBar(mb);
    }
//
//    class MenuActionListener implements ActionListener { // 메뉴아이템 처리 Action 리스너
//        public void actionPerformed(ActionEvent e) {
//            String cmd = e.getActionCommand(); // 사용자가 선택한 메뉴아이템의 문자열 리턴
//            switch(cmd) { // 메뉴 아이템의 종류 구분
//                case "Load" :
//                    if(imgLabel.getIcon() != null) return; // 이미 로딩되었으면 리턴
//                    imgLabel.setIcon(new ImageIcon("images/img.jpg")); break;
//                case "Hide" :
//                    imgLabel.setVisible(false); break;
//                case "ReShow" :
//                    imgLabel.setVisible(true); break;
//                case "Exit" :
//                    System.exit(0); break;
//            }
//        }
//    }
    public static void main(String [] args) {
        new MenuActionEvent();
    }
}