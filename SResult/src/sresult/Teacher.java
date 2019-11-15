package sresult;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

public class Teacher extends Person{
   
    private Frame F,FT,opt;
    private String cls,sub;
    private Button back;
    private byListener by;
    private Button save=new Button(" SAVE ");
    private Button select=new Button(" GIVE MARKS ");
    private WindowList win=new WindowList();
    private DBconnect db = new DBconnect();
    private Frame fc=new Frame(" CHANGE PASS of "+getID());
    
    public Teacher()
    {
        
    }
    
    public Teacher(String id, String name)
    {
        setID(id);
        setName(name);
    }
    public Teacher(Frame f,Button l,String id)
    {
        back=new Button(" BACK ");
        f=new Frame(" TEACHER: "+getID()+" "+getName());
        this.F=f;
        Label cls=new Label("Select Class ");
        Label sub=new Label("Select Subject");
        
        List clsList=new List(5);
        clsList.add("1");
        clsList.add("2");
        clsList.add("3");
        
        List subList=new List(5);
        subList.add("BANGLA",2);
        subList.add("MATH",1);
        subList.add("ENGLISH",3);
        //list giveMarks(/showInfo) setClass setSubject 
        
        Button pro=new Button(" CHANGE PASSWORD ");
        Button ot=new Button(" OPTION ");
        
 //       teaFrame.add();
        f.add(cls);
        f.add(clsList);
        f.add(sub);
        f.add(subList);
        //f.add(select);
        f.add(l);
        f.add(pro);
        f.add(ot);
        
        f.setSize(600,800);
        f.setVisible(true);
        f.setLayout(new FlowLayout());
        
        f.addWindowListener(win);
        
        Login log=new Login(f,l,ot);
        l.addActionListener(log);
        //clsList.addActionListener(log);
        //subList.addActionListener(log);
        
        by=new byListener(this,clsList,subList,ot,back,save,pro);
        ot.addActionListener(by);
        pro.addActionListener(by);
    }//END OF CONSTRUCTOR
    
    public void passCng()
    {
        System.out.println("enter new password : ");
        
        Label l=new Label("ENTER NEW PASSWORD: ");
        TextField txt=new TextField(10);
        Button ok=new Button("OK");
         
        fc.add(l);
        fc.add(txt);
        fc.add(ok);
        fc.setLayout(new FlowLayout());
        fc.setSize(400,300);
        fc.setVisible(true);
        fc.addWindowListener(win);
        by=new byListener(ok,txt);
        ok.addActionListener(by);
        
    }
    
    public void setPass(int i)
    {
        fc.setVisible(false);
        db.changePass(getID(),i);
    }
    public void option(String cl, String sb)
    {
        F.setVisible(false);

        opt=new Frame(" Teacher Panel "+cl+" "+sb);
        
        Button m,mList,info,cng,bk;
        mList=new Button(" MARK-LIST ");
        cng=new Button(" CHANGE PASSORD ");
        bk=new Button(" BACK ");
        
        opt.add(select);
        opt.add(mList);
        //opt.add(cng);
        opt.add(bk);
        
        by=new byListener(this,cl,sub,select,mList,bk);
        select.addActionListener(by);
        mList.addActionListener(by);
        bk.addActionListener(by);
        opt.addWindowListener(win);
        
        opt.setSize(400, 200);
        opt.setLayout(new FlowLayout());
        opt.setVisible(true);
    }
    
    public void backOpt()
    {
        opt.setVisible(false);
        F.setVisible(true);
    }
    
    public void setMarks(String cl, String sb)
    {
        opt.setVisible(false);
        cls=cl;
        sub=sb;
        FT = new Frame("SUBJECT- "+sub+"  "+cls);
        
        Label roll[] = new Label[10];
        TextField mark[] = new TextField[10];
        for(int student=0;student<roll.length;student++)
        {
            roll[student]=new Label("ROLL "+(student+1));
            mark[student]=new TextField(8);
            FT.add(roll[student]);
            FT.add(mark[student]);
        }
        FT.add(save);
        FT.add(back);
        by=new byListener(this,back);
        back.addActionListener(by);
        FT.setSize(500, 300);
        FT.setLayout(new FlowLayout());
        FT.setVisible(true);
        FT.addWindowListener(win);
    }

    public void resetFrame()
    {
        FT.setVisible(false);
        opt.setVisible(true);
    }
    
    public void setMark()
    {
        System.out.println(" SAVING MARKS ");
    }
    
    public void MarkList(String cl, String sb)
    {
        db.markList(cl);
        System.out.println(" MARKS LISt ");
    }
}
