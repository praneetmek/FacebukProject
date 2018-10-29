import java.util.ArrayList;

public class MaximalClique {
    private ArrayList<LivingEntity> _listOfMembers;

    public MaximalClique() {

    }
    public void add(LivingEntity livingEntity){
        _listOfMembers.add(livingEntity);
    }
    public int size(){
       return _listOfMembers.size();
    }
    public ArrayList<LivingEntity> get_listOfMembers(){
        return _listOfMembers;
    }
}
