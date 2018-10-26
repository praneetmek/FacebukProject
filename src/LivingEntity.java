import java.util.ArrayList;

public class LivingEntity {
    private ArrayList friends;
    private ArrayList<Moment> moments;
    public void setFriends(ArrayList friends) {
        this.friends = friends;
    }

    public void setMoments(ArrayList<Moment> moments) {
        this.moments = moments;
    }

    public ArrayList getFriends() {
        return friends;
    }

    public void addFriend(LivingEntity le){
        friends.add(le);
    }
}
