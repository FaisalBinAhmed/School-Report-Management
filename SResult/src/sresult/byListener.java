package sresult;

import java.awt.Button;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class byListener implements ActionListener{

    private Button btn,back,save,pro;
    private Button om,oml,ob,cng;
    private String c,s;
    private List cls,sub;
    private Teacher teach;
    private TextField txt;
    
    public byListener(Button b, TextField txt)//back from opt
    {
        this.cng=b;
        this.txt=txt;
    }
    
    public byListener(Teacher t,Button b)//back from opt
    {
        this.back=b;
        this.teach=t;
    }
    
    public byListener(Teacher teach,String c,String s,Button m,Button ml,Button ob)
    {
        this.teach=teach;
        this.ob=ob;
        this.om=m;
        this.oml=ml;
        this.c=c;
        this.s=s;   
        System.out.println(" COnStruCT OPTION ");
    }
    
    
    public byListener(Teacher teach,List c,List s,Button btn,Button back,Button save,Button pro) //TEACHER 
    {
        this.pro=pro;
        this.cls=c;
        this.sub=s;
        this.btn=btn;
        this.teach=teach;
        this.back=back;
        this.save=save;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       Object obj=e.getSource();
       if(btn==obj)
       {
           String clss=null;
           String subject=null;
           clss=cls.getSelectedItem();
           subject=sub.getSelectedItem();
           System.out.println("cls: "+clss+" sub: "+subject);
           teach.option(clss, subject);
       }
       else if(om==obj)
       {
           teach.setMarks(c, s);
           System.out.println("setMarks cls: "+c+" sub: "+s);
       }
       else if(oml==obj)
       {
           teach.MarkList(c, s);
       }
       else if(ob==obj)
       {
           teach.backOpt();
       }
       else if(back==obj)
       {
           System.out.println(" BACK ");
           teach.resetFrame();
       }
       else if(save==obj)
       {
           teach.setMark();
       }
       else if(pro==obj)
       {
           System.out.println(" PASS CHANGE ");
           teach.passCng();
       }
       else if(cng==obj)
       {
           Teacher t=new Teacher();
           t.setPass(Integer.parseInt(txt.getText()));
       }
    }
    
}
