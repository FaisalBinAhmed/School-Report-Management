package sresult;

//public final class Person{
//public abstract class Person{
public class Person {
    
	private static String name;
        private static String id;
        private String pass;
	
	public void setName(String n)
        {	
            name=n;
        }
        
	public String getName()
        {
            return name;
        }
        
	public void setID(String n)
        {	
            id=n;
        }
        
	public String getID()
        {
            return id;
        }
	public void setPass(String n)
        {	
            pass=n;
        }
        
	public String getPass()
        {
            return pass;
        }
        
	public final String getDetails()
        {
		return "Name : "+this.name+" /n id : "+id;
	}
}