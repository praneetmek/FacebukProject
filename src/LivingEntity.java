import java.util.ArrayList;

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
	
	public ArrayList getFriends() {
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
	
}
