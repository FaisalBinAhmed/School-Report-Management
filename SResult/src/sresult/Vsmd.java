package sresult;

import java.util.Scanner;
import java.awt.*;

public class Vsmd {

    private static DBconnect db = new DBconnect();
    /*public static void main(String[] args) {
        // TODO code application logic here
        
        DBconnect db = new DBconnect();
        
        Scanner sc = new Scanner(System.in);
        
  /*  JFrame mf = new JFrame("New");
    FlowLayout f = new FlowLayout();
  
    JTextPane jt = new JTextPane();
    JTextArea jta = new JTextArea();
    mf.setSize(300, 300);
    mf.setVisible(true);
   // jta.append("seloo");
    mf.add(jta); */
        
        
       /* System.out.println("----LOGIN------");
        System.out.println("if you're a student press 1 if you're a teacher press 2 if admin press 3");
        int a = sc.nextInt();
        
        if(a==2){
            login();
            T_portal();
            
        } */
        
        //db.showClassInfo("Select * from class");
       // db.insertClass();
       // db.updateClass();
       
       // db.showStudents("select * from students");
       // db.showMarks("select S_ID, Course_name, mark from Grades, courses WHERE grades.course_ID=courses.Course_ID");
        //db.showCourses("SELECT * FROM courses, teachers WHERE courses.T_ID=teachers.T_ID ");
        //
        // db.getStuPass("select * from students");
       // db.changePass();
        //db.suggestCourses();
        
        //db.showResult();
        //db.insertGrades();
       // db.markList();
       // for(int i=0;i<5;i++)
            //db.insertSubject();
       // db.meritList();
   // }*/

    public static boolean doLogin(String id, String pass,int user) 
    {       
            boolean b=false;
            switch(user)
                {
                    case 1: 
                           b=db.matchTeaPass(id, pass);
                           break;
                    case 2: 
                           b=db.matchStuPass(id, pass);
                           break;
                    case 3:
                        System.out.println(" UNDER CONSTRUCTION ");
                }
            return b;
    }    
}
    
    
  
