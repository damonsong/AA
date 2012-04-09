package Brain;
import java.io.Serializable;


public class Person implements Serializable{
	private String name;
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
}
