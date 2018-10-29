import java.util.ArrayList;
import java.util.Objects;

public class LivingEntity 
{
// Data
	
	protected String _name;
	private Image _img;
	private ArrayList<LivingEntity> _friends;
	private ArrayList<Moment> _moments;
	
// Constructor(s)
	
	public LivingEntity(String friendName, Image friendImage) {
		_name = friendName;
		_img = friendImage;
	}
// Methods
	
	/**
	 * Returns the entity's _name.
	 * @return  the entity's _name
	 */
	public String getName() {
		return _name;
	}
	
	public ArrayList<LivingEntity> getFriends() {
		return _friends;
	}
	
	public void setFriends(ArrayList<LivingEntity> friendList) {
		_friends = friendList;
	}
	
	public void setMoments(ArrayList<Moment> listOfMoment) {
		_moments = listOfMoment;
	}
	
	public void addFriend(LivingEntity friend) {
		_friends.add(friend);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof LivingEntity) {
			LivingEntity oToLivingEntity=(LivingEntity) o;
			if(_name==oToLivingEntity.getName()){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(_name);
	}

	/**
	 * Takes in a living entity and finds the average happiness with that living entity
	 * @param livingEntity
	 * @return
	 */
	public float getAverageHappiness(LivingEntity livingEntity)
	{
		ArrayList<Float> happinessValues = new ArrayList<Float>();
		float sum=0;
		for (Moment moment : _moments)
		{
		    int myIndex=moment.getParticipants().indexOf(this);
			for (LivingEntity livingEntity1: moment.getParticipants()){
			    if(livingEntity.equals(livingEntity1)){
			        happinessValues.add(moment.getSmileValues().get(myIndex));
                }
            }
		}
		for (Float f:happinessValues) {
			sum+=f;
		}
		if(happinessValues.size()==0){
            return 0;
		}
		else {
            return sum / (float) happinessValues.size();
        }
	}
	
	public LivingEntity getFriendWithWhomIAmHappiest() 
	{
		LivingEntity friendIAmHappiestWith=null;
		float highestAverageHappiness=-Float.MAX_VALUE;

		for(LivingEntity livingEntity:_friends){
			if(getAverageHappiness(livingEntity)>highestAverageHappiness){
				friendIAmHappiestWith=livingEntity;
				highestAverageHappiness=getAverageHappiness(livingEntity);
			}
		}
		return friendIAmHappiestWith;
	}
	
	public Moment getOverallHappiestMoment() 
	{
		Moment happiestMoment=null;
		float highestAverageHappiness=-Float.MAX_VALUE;
		for (Moment moment:_moments) {
			float sum=0;
			for (Float f: moment.getSmileValues()) {
				sum+=f;
			}
			if ((sum/(float) moment.getSmileValues().size())>highestAverageHappiness){
				highestAverageHappiness=sum/(float) moment.getSmileValues().size();
				happiestMoment=moment;
			}
		}
		return happiestMoment;
	}
	public ArrayList findMaximumCliqueOfFriends(){
		ArrayList<MaximalClique> allMaximalCliques = new ArrayList<MaximalClique>();
		MaximalClique maximumClique=new MaximalClique();
		int largestClique=0;
		for(LivingEntity livingEntity:_friends){
			allMaximalCliques.add(createMaximalClique(livingEntity));
		}
		for(MaximalClique maximalClique: allMaximalCliques){
			if(maximalClique.size()>largestClique){
				maximumClique=maximalClique;
				largestClique=maximalClique.size();
			}
		}
		System.out.println(maximumClique.toString());
		return maximumClique.get_listOfMembers();


	}
	public MaximalClique createMaximalClique(LivingEntity friend){
		MaximalClique maximalClique=new MaximalClique();
		maximalClique.add(friend);
		ArrayList<LivingEntity> temporaryClique;
		for(LivingEntity possibleMemberOfClique: _friends){
//            System.out.println("Tests "+ this.getName()+" "+ friend.getName()+":"+maximalClique.toString());
                temporaryClique = (ArrayList<LivingEntity>)maximalClique.get_listOfMembers().clone();
//                System.out.println("maximal clique before add is" +maximalClique.toString());
			temporaryClique.add(this);
			if(!possibleMemberOfClique.equals(friend)){
				temporaryClique.add(possibleMemberOfClique);
				if(isClique(temporaryClique)){
					maximalClique.add(possibleMemberOfClique);
//					System.out.println("added "+possibleMemberOfClique.getName());
//					System.out.println("maximal clique is " +maximalClique.toString());
				}
			}
		}
//		System.out.println(this.getName()+" "+ friend.getName()+":"+maximalClique.toString());
//		System.out.println("done");
        return maximalClique;
	}
	public static boolean isClique(ArrayList<LivingEntity> listOfPossibleCliqueMembers){
		boolean isClique=true;
		while(isClique){
			for (LivingEntity cliqueMember : listOfPossibleCliqueMembers) {
				ArrayList<LivingEntity> friendsOfCliqueMember=cliqueMember.getFriends();
				for(LivingEntity possibleFriendOfCliqueMember: listOfPossibleCliqueMembers){
					if(!possibleFriendOfCliqueMember.equals(cliqueMember)){
						if(friendsOfCliqueMember==null){
							isClique = false;
						}
						else if(!friendsOfCliqueMember.contains(possibleFriendOfCliqueMember)) {
							isClique = false;
						}
						else{
						}
					}
				}

			}
			break;
		}

		return isClique;
	}
}
