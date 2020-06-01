package main.java.jdk8.Lamada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class LamadaTest extends JFrame {

    private JButton jButton;

    public static void main(String[] args) {
        new LamadaTest();
    }

    public LamadaTest() {
        this.setBounds(200,200, 400, 200);
        this.setTitle("lamada测试");

        jButton = new JButton("click");
        this.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });

        jButton.addActionListener(e -> System.out.println("Hello"));
        String output = "点击成功";
        List<String> list = Collections.singletonList(output);
        jButton.addActionListener(e -> list.forEach(System.out::println));
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
