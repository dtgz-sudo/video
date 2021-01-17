package cn.tx.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SwingGetPath extends JFrame implements ActionListener
{

    private static final long serialVersionUID = 1L;
    private String path;

    JButton btn = null;

    JTextField textField = null;
    //设置文本区域来显示控制台命令
    private TextArea ta;

    public SwingGetPath()
    {
        this.setTitle("选择文件窗口");
        FlowLayout layout = new FlowLayout();// 布局
        JLabel label = new JLabel("请选择文件：");// 标签
        textField = new JTextField(30);// 文本域
        btn = new JButton("浏览");// 钮1
        ta = new TextArea();//文本域


        // 设置布局
        layout.setAlignment(FlowLayout.CENTER);// 左对齐
        this.setLayout(layout);
        this.setBounds(400, 200, 600, 700);
        ta.setBounds(400,500,600,500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(this);
        this.add(label);
        this.add(textField);
        this.add(btn);
        this.add(ta);

    }

    public static void main(String[] args)
    {
        SwingGetPath swingGetPath = new SwingGetPath();

        System.out.println();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showDialog(new JLabel(), "选择");
        File file = chooser.getSelectedFile();
        String s = file.getAbsoluteFile().toString();
        path =s ;
        textField.setText(s);
       // System.out.println(path);


    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}