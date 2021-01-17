package cn.tx.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

class MyMenuDemo<openDia> implements ActionListener
{
    private Frame f;
    private MenuBar bar;
    private Menu fileMenu,subMenu;
    private MenuItem closeItem;
    private MenuItem openItem,saveItem;
    private String path ;

    //定义打开和保存对话框
    JTextField  openDia;

    //设置文本区域来保存打开的数据
    private TextArea ta;

    private File file;

    MyMenuDemo()
    {
        init();
    }

    public void init()
    {
        f = new Frame("my window");
        f.setBounds(300,100,500,600);
        //f.setLayout(new FlowLayout());

        bar = new MenuBar();

        ta = new TextArea();

        fileMenu = new Menu("File");
        subMenu = new Menu("Submenu");

        openItem = new MenuItem("Open");
        saveItem = new MenuItem("Save");
        closeItem = new MenuItem("Exit");



        fileMenu.add(openItem);
//        fileMenu.add(saveItem);
//        fileMenu.add(subMenu);
        fileMenu.add(closeItem);
        bar.add(fileMenu);

        f.setMenuBar(bar);

        //默认模式为 FileDialog.LOAD
        openDia = new JTextField(30);// 文本域
      //  openDia = new FileDialog(f,"我的打开",FileDialog.LOAD);

        f.add(ta);

        myEvent();

        f.setVisible(true);


    }

    private void myEvent()
    {

     //   openItem.addActionListener(new ActionListener()
//        {
//            //设置打开文件功能
//            public void actionPerformed(ActionEvent e)
//            {
//                openDia.setVisible(true);
//                String dirPath = openDia.getDirectory();//获取文件路径
//                String fileName = openDia.getFile();//获取文件名称
//                //System.out.println(dirPath +"++"+ fileName);
//
//                //如果打开路径 或 目录为空 则返回空
//                if(dirPath == null || fileName == null)
//                    return ;
//
//                ta.setText("");//清空文本
//
//
//
//
//            }
//        });

        closeItem.addActionListener(new ActionListener()
        {
            //设置退出功能
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    public static void main(String []args)
    {
        new MyMenuDemo();
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
        System.out.println(s);
       // textField.setText(s);
        // System.out.println(path)this.setDefaultCloseOperation(2);


    }
}