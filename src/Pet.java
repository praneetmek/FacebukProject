import java.util.ArrayList;

public class Pet extends LivingEntity {

    private final String _name;
    private final Image _image;
    private Person _owner;
    public Pet (String name, Image image){
        super(name, image);
        _name=name;
        _image=image;
    }
    public void setOwner(Person owner)
    {
        _owner = owner;
    }
    public boolean equals(Pet pet){
        return _name.equals(pet.getName());
    }


}
