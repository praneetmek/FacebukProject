public class FriendRequest {
    LivingEntity _le1;
    LivingEntity _le2;
    Boolean entity1=false;
    public FriendRequest(LivingEntity a, LivingEntity b) {
        _le1=a;
        _le2=b;
    }
    private void addFriends(){
        _le1.addFriend(_le2);
        _le2.addFriend(_le1);
    }
    public void approve(LivingEntity le) {
        if (le.equals(_le1) || le.equals(_le2)){
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
