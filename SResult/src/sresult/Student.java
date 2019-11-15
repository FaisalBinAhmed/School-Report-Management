package sresult;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;

public class Student extends Person{
    
    private static Frame S;
    private Frame result;
    private WindowList win=new WindowList();
    private Button res;
    private Button pro;
    private Button opt;
    
    public void getResult()
    {
      //  S.
        DBconnect data=new DBconnect();
        data.showResult(getID());
    }
    public void printResult(){
    DBconnect data = new DBconnect();
    data.printResult(getID());
    
    
    
    }
    
    public void getSug(){
    DBconnect data = new DBconnect();
    data.suggestCourses(getID());
    
    }
    public void makeFrame(Frame f,Button l,String id)
    {
            S=new Frame(" STUDENT: "+getID()+" "+getName());
            List sub=new List(12);
            //list giveMarks(/showInfo) setClass setSubject 
            res=new Button(" SHOW RESULT ");
            pro=new Button(" PRINT RESULT ");
            opt=new Button(" SUGGEST DIVISION ");
            
            //stdFrame.add();
            S.add(res);
            S.add(pro);
            S.add(opt);
            WindowList win=new WindowList();
            S.addWindowListener(win);
            S.setLayout(new FlowLayout());
            S.setSize(600, 800);
            S.add(l);
            S.setVisible(true);
            
            Login log=new Login(S,l);
            l.addActionListener(log);
            
            StdListener sL=new StdListener(res, pro, opt);
            res.addActionListener(sL);
            pro.addActionListener(sL);
            opt.addActionListener(sL);
    }
}
