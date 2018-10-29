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
		ArrayList<MaximalClique> allMaximalcliques = new ArrayList<MaximalClique>();
		MaximalClique maximumClique=new MaximalClique();
		int largestClique=0;
		for(LivingEntity livingEntity:_friends){
			allMaximalcliques.add(createMaximalClique(livingEntity));
		}
		for(MaximalClique maximalClique: allMaximalcliques){
			if(maximalClique.size()>largestClique){
				maximumClique=maximalClique;
				largestClique=maximalClique.size();
			}
		}
		return maximumClique.get_listOfMembers();


	}
	private MaximalClique createMaximalClique(LivingEntity friend){
		MaximalClique maximalClique=new MaximalClique();
		ArrayList<LivingEntity> temporaryCliqueAdd;
		for(LivingEntity possibleMemberOfClique:_friends){
			temporaryCliqueAdd=maximalClique.get_listOfMembers();
			temporaryCliqueAdd.add(this);
			if(!possibleMemberOfClique.equals(friend)){
				temporaryCliqueAdd.add(possibleMemberOfClique);
				if(isClique(temporaryCliqueAdd)){
					maximalClique.add(possibleMemberOfClique);
				}
			}
		}
		return maximalClique;
	}
	public static boolean isClique(ArrayList<LivingEntity> listOfPossibleCliqueMembers){
		boolean isClique=true;
		while(isClique){
			for (LivingEntity cliqueMember : listOfPossibleCliqueMembers) {
				ArrayList<LivingEntity> friendsOfCliqueMember=cliqueMember.getFriends();
				for(LivingEntity possibleFriendOfCliqueMember: listOfPossibleCliqueMembers){
					if(!possibleFriendOfCliqueMember.equals(cliqueMember)){
						System.out.println("CliqueMember:"+cliqueMember.getName()+" PossibleFriend: "+possibleFriendOfCliqueMember.getName());
						if(friendsOfCliqueMember==null){
							isClique = false;
						}
						else if(!friendsOfCliqueMember.contains(possibleFriendOfCliqueMember)) {
							System.out.println(false);
							isClique = false;
						}
						else{
							System.out.println(true);
						}
					}
				}

			}
			break;
		}

		return isClique;
	}
}
