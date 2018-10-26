
import java.awt.Image;
import java.util.ArrayList;

public class Person extends LivingEntity {
// Data

	private String name;
	private Image img; 
	private ArrayList<Possession> possessions;
	private ArrayList<Pet> pets;
	private ArrayList<Moment> moments;
	
// Constructor
	
	/**
	 * Sets the person's profile information.
	 * @param name
	 * @param img
	 */
	public Person(String name, Image img) 
	{
		super(name, img);
		this.name = name; 
		this.img = img;
	}
	

    public void setPossessions(ArrayList<Possession> possessions) {
        this.possessions = possessions;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return img;
    }

    public void setImage(Image image) {
        img = image;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public ArrayList<Possession> getPossessions() {
        return possessions;
    }
    public boolean equals(Person person){
        return name.equals(person.name);
    }
}
