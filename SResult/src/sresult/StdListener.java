package sresult;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StdListener implements ActionListener{

    private Button result;
    private Button pro;
    private Button opt;
    
    public StdListener(Button result,Button pro,Button opt)
    {
        this.opt=opt;
        this.pro=pro;
        this.result=result;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object obj=e.getSource();
        
        if(obj==result)
        {
            System.out.println(" RESULT ");
            Student std=new Student();
            std.getResult();
        }
        else if(obj==pro)
        {
            System.out.println(" pr ");
            Student std=new Student();
            std.printResult();
        }
        else if(obj==opt)
        {
        System.out.println(" suggest course");
        Student std = new Student();
        std.getSug();
        
        }
    }
    
}
