package sresult;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JTextPane;
import java.io.*;
public class DBconnect {
    
     Connection conn;
     String JDBC_DRIVER, DB_URL, USER, PASS;
     Statement stmt;
     
    private String name;
    private JFrame mf;
     
     public DBconnect(){
         
         JDBC_DRIVER = "com.mysql.jdbc.Driver";
         DB_URL = "jdbc:mysql://localhost:3306/vsmd";
         
         USER = "root";
         PASS = "";
        
         
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database..");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
     }
     
     public void showClassInfo(String query){
     
         try{
                System.out.println("creating statement");
                stmt=conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
         
         while(rs.next())
            {
                 int cID = rs.getInt("Class_ID");
                 String cName = rs.getString("Class_name");
                 System.out.println("Class name of "+cID+" is "+cName);
             
            }
         
         rs.close();
         stmt.close();;
         
         }
     catch(Exception ex)
         {
             System.out.println(ex);
         }
     }
     
     public void insertClass(String query){
         Scanner s = new Scanner(System.in);
         String CN;
         int CID;
         
         System.out.println("Enter Class ID: ");
         CID=s.nextInt();
         System.out.println("Enter class name: ");
         CN = s.next();
         
         
         try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         StringBuffer sql = new StringBuffer();
         sql.append("insert into class (Class_ID, Class_name) values("+CID+",'"+CN+"')");
         int n = stmt.executeUpdate(sql.toString());
         System.out.println(n+"rows updated");
         stmt.close();
         
         }
     catch(Exception ex){
         System.out.println(ex);
     }
     
     }
     
     public void updateClass(){
     
         Scanner sc  = new Scanner(System.in);
         String CN="";
         int CID;
         
         System.out.println("enter class ID: ");
         CID = sc.nextInt();
         System.out.println("enter class name: ");
         CN=sc.next();
         
         try{
             stmt = conn.createStatement();
             StringBuffer sql = new StringBuffer();
             sql.append("update class set Class_name='"+CN+"' where Class_ID='"+CID+"'");
             int n = stmt.executeUpdate(sql.toString());
             System.out.println(n+" rows updated");
             stmt.close();
             conn.close();
             
             
             
         }
     catch(Exception ex){System.out.println(ex);}
     }
     
     public void showMarks(String query){
         
         try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         
         while(rs.next()){
             //int g = rs.getInt("grade_ID");
             int s = rs.getInt("S_ID");
             //String n = rs.getNString("S_name");
             int m = rs.getInt("mark");
             String c = rs.getString("course_name");
             
             System.out.println("mark of student ID: "+s+" is: "+m+" in course "+c);
             
         }
         rs.close();
         stmt.close();;
         
         }
     catch(Exception ex){
         System.out.println(ex);
     }
     
     }
     
     
     public void showStudents(String query){
         
         try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         
         while(rs.next()){
             //int g = rs.getInt("grade_ID");
             int s = rs.getInt("S_ID");
             String n = rs.getString("S_name");
             System.out.println(" student ID: "+s+" name is: "+n);
         }
         rs.close();
         stmt.close();;
         
         }
     catch(Exception ex){
         System.out.println(ex);
     }
     
    }
     
     public void showCourses(String query){
         
         try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         JFrame mf = new JFrame("Courses");
    
    JTextPane jt = new JTextPane();
    JTextArea jta = new JTextArea();
    mf.setSize(500, 500);
    mf.setVisible(true);
         while(rs.next()){
             //int g = rs.getInt("grade_ID");
             int cid = rs.getInt("Course_ID");
             String cn = rs.getString("Course_name");
             int t = rs.getInt("T_ID");
             String tn = rs.getString("T_name");
             
             jta.append("\nCourse ID : "+cid+"'s name is: "+cn+" is assigned to Mr. "+tn+" whose ID is: "+t);
             mf.add(jta);
         }
         rs.close();
         stmt.close();;
         
         }
     catch(Exception ex){
         System.out.println(ex);
     }
     
     }
     
     public void changePass(String id, int p){
     
         String s;
         System.out.println("ID: "+id);
         
         if(Integer.parseInt(id)<100)
         {
             s="update teachers set T_pass='"+p+"' where T_ID ='"+id+"'";
         }
         
         else
             s=" update students set S_pass='"+p+"' where S_ID = '"+id+"'";
         
         try{
             stmt = conn.createStatement();
             StringBuffer sql = new StringBuffer();
             sql.append(s);
             int n = stmt.executeUpdate(sql.toString());
             System.out.println(n+" rows updated");
             stmt.close();
             conn.close();         
         }
     catch(Exception ex){System.out.println(ex);}
     
     
     
    }
     
    public boolean matchStuPass(String id, String pass){
            boolean b=false;
            String query="select * from students where S_ID like "+id;
         try
        {
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         
         while(rs.next())
        {
             String sp = rs.getString("S_pass");
             name=rs.getString("S_name");
             
             if(pass.equals(sp))
             {
                 System.out.println("you've successfully logged in");
                 Student std=new Student();
                 std.setID(id);
                 std.setName(name);
                 b=true;
             }
             else
                 System.out.println("enter again");
                 
        }
         rs.close();
         stmt.close();;
         
        }
     catch(Exception ex)
     {
         System.out.println(ex);
        }
    return b;
} 
     
    
    public boolean matchTeaPass(String id, String pass){
        String p = pass;
        String i = id;
        String query="select * from teachers where T_ID like "+i;
        String sp=null;
        boolean a = false;
    try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         
         while(rs.next())
         {
             sp = rs.getString("T_pass"); 
             name=rs.getString("T_name");
         }
         rs.close();
         stmt.close();;
         
         if(p.equals(sp)){
                 System.out.println("you've successfully logged in");
                 Teacher tc=new Teacher(id,name);
                 a = true;
         }
         else{
                 System.out.println("wrong pass! Enter again");
             }
         }
     catch(Exception ex){
         System.out.println(ex);
     }
        return a;    
    }
     

     
    public void suggestCourses(String id){
     //   Scanner sc = new Scanner(System.in);
       // System.out.println("Enter ID: ");
     //   int id = sc.nextInt();
        int t= 0;
        int counter = 0;
        String s = "select course_name, mark from grades, courses where grades.course_ID=courses.Course_ID and S_ID like "+id;
        JFrame mf = new JFrame("Course suggestion");
        FlowLayout f = new FlowLayout();
    
    JTextPane jt = new JTextPane();
    JTextArea jta = new JTextArea();
    mf.setSize(500, 500);
    mf.setVisible(true);
    try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(s);
         
         while(rs.next()){
             String c = rs.getString("course_name");
             int m = rs.getInt("mark");
             
             jta.append("\nyour mark for course: "+c+" is: "+m);
             mf.add(jta);
             t=t+m;
             counter++; 
             
             
         }
         rs.close();
         stmt.close();;
         
         if(t/counter>80){
                 
                 jta.append("\n\nyou should take: Science");
                 jta.append("\nyour average is: "+t/counter);
                 //showCourses("select * from courses where course_ID < 100");
             }
         else{
                 jta.append("\n\nyou should take: Commerce");
                 jta.append("\nyour average is: "+t/counter);}
         }
     catch(Exception ex){
         System.out.println(ex);
     }
    
    
    }
    
    public void showResult(String id){
    
    System.out.println("student ID: "+id);
    int t= 0;
    int counter = 0;
    String s = "select course_ID, mark from grades where S_ID like "+id;
    
    JFrame mf = new JFrame("RESULT: "+id);
    FlowLayout f = new FlowLayout();
    
    JTextPane jt = new JTextPane();
    JTextArea jta = new JTextArea();
    mf.setSize(500, 500);
    mf.setVisible(true);
    
    try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(s);
         
         while(rs.next()){
             System.out.println("count: "+counter);
             int c = rs.getInt("course_ID");
             int m = rs.getInt("mark");
             
             jta.append("\nyour mark for course: "+c+" is: "+m);
             t=t+m;
             counter++; 
             mf.add(jta);  
         }
         rs.close();
         stmt.close();
     
                 jta.append("\nyour tolat mark is: "+t);
                 try
                 {
                 jta.append("\nyour average is: "+t/counter);
                 //showCourses("select * from courses where course_ID < 100");
                 //mf.add(jta);
                 }
                 catch(ArithmeticException e)
                 {
                     System.out.println(e+"EXCEPTION MAIRALaISE!!");
                 }
    }
   
     catch(Exception ex){
         System.out.println(ex);
     }
    
    }
    
    public void markList(String id)
    { 
        
    System.out.println("class ID: "+id);
    int t= 0;
    int counter = 1;
    String s = "SELECT * FROM students, grades WHERE students.S_ID=grades.S_ID ";
    JFrame mf = new JFrame("mark list of class"+id);
    FlowLayout f = new FlowLayout();
    
    JTextPane jt = new JTextPane();
    JTextArea jta = new JTextArea();
    mf.setSize(500, 500);
    mf.setVisible(true);
    try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(s);
         
         while(rs.next()){
             String c = rs.getString("S_name");
             int m = rs.getInt("mark");
             int co = rs.getInt("course_ID");
             jta.append("\n"+counter+") "+c+" his/her mark in "+co+" is: "+m);
             mf.add(jta);
             t=t+m;
             counter++; 
             
             
         }
         rs.close();
         stmt.close();
     
                 //System.out.println("your tolatl mark is: "+t);
                 //System.out.println("your average is: "+t/counter);
                 //showCourses("select * from courses where course_ID < 100");
    }
   
     catch(Exception ex){
         System.out.println(ex);
     }
    
    
    
    }
    
 public void insertGrades(){
     Scanner s = new Scanner(System.in);
         int m, sid;
         int CID;
         
         System.out.println("Enter Course ID: ");
         CID=s.nextInt();
         System.out.println("Enter student ID");
         sid =s.nextInt();
         System.out.println("Enter mark: ");
         m = s.nextInt();
         
         
         try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         StringBuffer sql = new StringBuffer();
         sql.append("insert into grades (course_ID, S_ID, mark) values("+CID+","+sid+","+m+")");
         int n = stmt.executeUpdate(sql.toString());
         System.out.println(n+"rows updated");
         stmt.close();
         
         }
     catch(Exception ex){
         System.out.println(ex);
     }
 }   
    
 public void insertSubject(){
 Scanner s = new Scanner(System.in);
         int cid, sid;
         String sn;
         
         System.out.println("Enter subject ID: ");
         sid=s.nextInt();
         System.out.println("Enter subject name: ");
         sn =s.next();
         System.out.println("Enter class ID : ");
         cid = s.nextInt();
         try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         StringBuffer sql = new StringBuffer();
         sql.append("insert into subjects (sub_ID, Sub_name, Class_ID) values("+sid+",'"+sn+"',"+cid+")");
         int n = stmt.executeUpdate(sql.toString());
         System.out.println(n+"rows updated");
         stmt.close();
         
         }
     catch(Exception ex){
         System.out.println(ex);
     }
 
 
 }
 
 public void meritList(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter class ID: ");
    int id = sc.nextInt();
    int counter=1;
    String s = "SELECT s_name , sum(mark) FROM grades, students where grades.S_ID=students.S_ID group BY s_name order by sum(mark) desc";
        mf = new JFrame("Merit List");
    FlowLayout f = new FlowLayout();
    
    JTextPane jt = new JTextPane();
    JTextArea jta = new JTextArea();
    mf.setSize(500, 500);
    mf.setVisible(true);
    try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(s);
         
         while(rs.next()){
             String c = rs.getString("S_name");
             int m = rs.getInt("sum(mark)");
             
             jta.append("\n"+counter+") total mark of "+c+" is: "+m);
             mf.add(jta);
             counter++;
             
         }
         rs.close();
         stmt.close();
     
    }
   
     catch(Exception ex){
         System.out.println(ex);
     }
 
 }
    
 public void printResult(String id){
 
 
    
   // Scanner sc = new Scanner(System.in);
   // System.out.println("Enter student ID: ");
    //int id = sc.nextInt();
    int t= 0;
    int counter = 0;
    String s = "SELECT course_name, mark FROM `grades`, courses WHERE grades.course_ID=courses.Course_ID and S_ID like "+id;
    File f = new File("Result of ID "+id+".txt");
    
    try{
    
    
    
    }
    catch(Exception ex)
            {System.out.println(ex);}
    
    try{
         System.out.println("creating statement");
         stmt=conn.createStatement();
         ResultSet rs = stmt.executeQuery(s);
         FileOutputStream fos = new FileOutputStream(f);
             PrintStream ps = new PrintStream(fos);
             System.setOut(ps);
             System.out.println("------Your Result------");
         while(rs.next()){
             
             String c = rs.getString("course_name");
             int m = rs.getInt("mark");
             //System.setOut(ps);
             System.out.println("\nmark for course: "+c+" is: "+m);
            // System.setOut(ps);
             t=t+m;
             counter++; 
             
             
         }
         rs.close();
         stmt.close();
                 
                 System.out.println("\nyour tolat mark is: "+t);
                 System.out.println("\nyour average is: "+t/counter);
                 
    }
   
     catch(Exception ex){
         System.out.println(ex);
     }
 
 
 }
 
 
 
 
 
 
 
 
 
 
 
 
     
    
     }
     
    
    
    
    
    
    
    
    
    
    
    
    
    

