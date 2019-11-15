package sresult;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

public class myFrame {
    
    private static TextField idText;
    private static TextField passText;
    
    private static Frame frame; //login
    private static Frame uFrame; //user
    private static Frame teaFrame;
    private static Frame stdFrame;
    
    private static Login log; //loginInterface
    private static WindowList win=new WindowList();;
    private static TextLisnr textL;
    
    private static Button logout=new Button("LOGOUT");
    
    private static FlowLayout layout=new FlowLayout();
    
    public myFrame()
    {
        System.out.println(" CONSTRUCTING ");
    }
    
    public static void closeFrame()
    { 
        frame.setVisible(false); 
        /*teaFrame.setVisible(false);
        stdFrame.setVisible(false);*/
    }
    
    public static void resetUser()
    {
        frame.setVisible(false);
        uFrame.setVisible(true);
    }
    
    public static void doLogin()
    {
        frame.setVisible(true);
        uFrame.setVisible(false);
    }
    
    public static void frameLogin()
    {
        frame=new Frame(" LOGIN ");
        Button btn=new Button(" LOGIN ");
        Button back=new Button(" BACK ");
        Label id=new Label("ENTER YOUR ID      ");
        Label pass=new Label("ENTER PASSWORD ");
        TextField idText=new TextField(20);
        TextField passText=new TextField(20);
        
        textL=new TextLisnr(passText);
        
        frame.setLayout(layout);
        frame.setSize(220,250);
        
        frame.add(id);
        frame.add(idText);
        frame.add(pass);
        frame.add(passText);
        frame.add(btn);
        frame.add(back);
        frame.addWindowListener(win);
        
        log=new Login(idText, passText,btn,back);
        btn.addActionListener(log);
        back.addActionListener(log);
        //passText.addTextListener(textL);
    }
    
    public static void setUser()
    {
        uFrame=new Frame(" USER ");
        
        Button tBtn=new Button(" TEACHER ");
        Button sBtn=new Button(" STUDENT ");
        Button aBtn=new Button(" ADMIN ");
        Label as=new Label("LOGIN AS    ");
        
        
        log=new Login(tBtn,sBtn,aBtn);
        
        uFrame.setLayout(new GridLayout(3, 1));
        uFrame.setSize(220, 250);
        uFrame.setVisible(true);
    
        uFrame.add(as);
        uFrame.add(tBtn);
        uFrame.add(sBtn);
        uFrame.add(aBtn);
        
        uFrame.addWindowListener(win);
        
        tBtn.addActionListener(log);
        sBtn.addActionListener(log);
        aBtn.addActionListener(log);
        
        System.out.println(" USER ");
    }
    
    public static void teachersFrame(String id)
    {
        Teacher teach=new Teacher(teaFrame,logout,id);
    }
    
    public static void studentsFrame(String id)
        {
           Student std=new Student();
           std.makeFrame(stdFrame,logout,id);
        }
}
