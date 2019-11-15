package sresult;

import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener{
    
    private String id[]={"13-1","14-1","15-1"}; //user id & pass database
    private String pass[]={"123","1234","12345"};
    private int idPos;
    private static int user;
    private String userID;
    
    private Frame frame;
    private TextField iText;
    private TextField pText;
    private Button btn;
    private Button tbtn;
    private Button sbtn;
    private Button abtn;
    private Button back, tback;
    private Button logout;
    private List cls,sub;
    
    public Login(Frame frame, Button logout)
    {
        this.frame=frame;
        this.logout=logout;
    }
    
    public Login(Frame frame, Button logout,Button tback)
    {
        this.frame=frame;
        this.logout=logout;
        this.tback=tback;
    }
    
    public Login(Button tbtn,Button sbtn,Button abtn)//user
    {
        this.tbtn=tbtn;
        this.sbtn=sbtn;
        this.abtn=abtn;
    }
    
    public Login(TextField iText,TextField pText,Button btn,Button back)//login
    {
        this.iText=iText;
        this.pText=pText;
        this.btn=btn;
        this.back=back;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // SResult sr=new SResult();
        Object obj=e.getSource();
        if(btn==obj)//loginButton
        {
            System.out.println("Login is WORKING");
            doCheck();
            System.out.println("User Entry ===> "+user+" "+doCheck());
            
            if(doCheck())
            {
                myFrame.closeFrame();
                switch(user)
                {
                    case 1: System.out.println("TEACHER's FRAME");
                        myFrame.teachersFrame(userID);
                        break;
                    case 2: System.out.println("STUDENT's FRAME");
                        myFrame.studentsFrame(userID);
                        break;
                    case 3:
                        myFrame.teachersFrame(userID);
                }
            }
            
        }
        else if(back==obj)
        {
            myFrame.resetUser();
        }
        else if(tbtn==obj)
        {
           this.user=1;
            myFrame.doLogin();
        }
        else if(sbtn==obj)
        {
            this.user=2;
            myFrame.doLogin();
        }
        else if(abtn==obj)
        { 
            this.user=3;
            myFrame.doLogin();
        }
        else if(logout==obj)
        {
            System.out.println("LOGING OUT");
            frame.setVisible(false);
            myFrame.resetUser();
        }
        else if(tback==obj)
        {
            Teacher t=new Teacher();
            //t.option();
        }
    }
    
    public boolean doCheck()
    {
        //id checking
       
        boolean go = Vsmd.doLogin(iText.getText(),pText.getText(),user);
       
        return go;
    }
    
}
