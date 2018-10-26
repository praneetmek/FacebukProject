
import java.util.ArrayList;

public class Person extends LivingEntity {
    private String name;
    private Image image;
    private ArrayList<Pet> pets;
    private ArrayList<Possession> possessions;
    public Person (String name, Image image){
        this.name=name;
        this.image=image;
    }

    public void setPossessions(ArrayList<Possession> possessions) {
        this.possessions = possessions;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public ArrayList<Possession> getPossessions() {
        return possessions;
    }
}
