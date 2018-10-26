public class FriendRequest {
    Pet pet1;
    Pet pet2;
    Person person1;
    Person person2;
    Boolean entity1=false;
    public FriendRequest(Person a, Person b){
        person1=a;
        person2=b;
    }
    public FriendRequest(Pet b, Person a){
        pet1=b;
        person1=a;
    }
    public FriendRequest(Person a, Pet b){
        person1=a;
        pet1=b;
    }
    public FriendRequest(Pet a, Pet b){
        pet1=a;
        pet2=b;
    }
    private void addFriends(){
        if (person1!=null && person2!=null){
            person1.addFriend(person2);
            person2.addFriend(person1);
        }
        else if (person1!=null && pet1!=null){
            person1.addFriend(pet1);
            pet1.addFriend(person1);
        }
        else{
            pet1.addFriend(pet2);
            pet2.addFriend(pet1);
        }
    }
    public void approve(Person person){
        if (entity1==true){
            addFriends();
        }
        else{
            entity1=true;
        }
    }
    public void approve(Pet pet){
        if (entity1==true){
            addFriends();
        }
        else{
            entity1=true;
        }
    }
}
