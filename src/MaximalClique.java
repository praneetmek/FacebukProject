import java.util.ArrayList;

public class MaximalClique {
    private ArrayList<LivingEntity> _listOfMembers=new ArrayList<LivingEntity>();

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
    public String toString(){
        String string="";
        for (LivingEntity livingEntity:_listOfMembers) {
            string+=livingEntity.getName()+" ";
        }
        return string;
    }
}
