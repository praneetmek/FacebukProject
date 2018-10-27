import java.util.ArrayList;
import java.util.Objects;

public class Person extends LivingEntity {
// Data

	private ArrayList<Possession> possessions;
	private ArrayList<Pet> pets;
	
// Constructor
	
	/**
	 * Sets the person's profile information.
	 * @param name
	 * @param img
	 */
	public Person(String name, Image img) 
	{
		super(name, img);

	}
	

    public void setPossessions(ArrayList<Possession> possessions) {
        this.possessions = possessions;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }


    public ArrayList<Pet> getPets() {
        return pets;
    }

    public ArrayList<Possession> getPossessions() {
        return possessions;
    }

    @Override
    public boolean equals(Object o) {
	    if(o instanceof Person) {
            Person personOfObject = (Person) o;
            return _name.equals(personOfObject.getName());
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name);
    }
}
