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
