import java.util.ArrayList;
import java.util.Objects;

public class Pet extends LivingEntity {

    private Person _owner;
    public Pet (String name, Image image){
        super(name, image);
    }
    public void setOwner(Person owner)
    {
        _owner = owner;
    }



}
