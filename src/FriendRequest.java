public class FriendRequest {
    LivingEntity le1;
    LivingEntity le2;
    Boolean entity1=false;
    public FriendRequest(LivingEntity a, LivingEntity b) {
        le1=a;
        le2=b;
    }
    private void addFriends(){
        le1.addFriend(le2);
        le2.addFriend(le1);
    }
    public void approve(LivingEntity le) {
        if (le.equals(le1) || le.equals(le2)){
            if (entity1 == true) {
                addFriends();
            } else {
                entity1 = true;
            }
        }
        else{
            throw new IllegalArgumentException("Can't approve friend request if not one of the two entities in the friend request!");
        }
    }
}
