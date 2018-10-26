import java.util.ArrayList;

public class Pet extends LivingEntity {

    private String name;
    private Image image;
    private ArrayList friends;
    private ArrayList<Moment> moments;
    private Person owner;
    public Pet (String name, Image image){
        this.name=name;
        this.image=image;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
