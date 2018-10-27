import java.util.ArrayList;

public class LivingEntity 
{
// Data
	
	private String _name;
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
	 * Takes in a living entity and finds the overall happiness with that living entity
	 * @param livingEntity
	 * @return
	 */
	public float getAverageHappiness(LivingEntity livingEntity)
	{
		ArrayList<Float> happinessValues = new ArrayList<Float>();
		float sum=0;
		for (Moment moment : _moments)
		{
			for (int i=0; i<moment.getParticipants().size(); i++){
				if (moment.getParticipants().get(i).equals(livingEntity)){
					happinessValues.add(moment.getSmileValues().get(i));
				}
			}
		}
		for (Float f:happinessValues) {
			sum+=f;
		}
		return sum/(float)happinessValues.size();

	}
	
	public LivingEntity getFriendWithWhomIAmHappiest() 
	{
		LivingEntity friend; 
		for(int x = 0; x< _friends.size(); x++)
		{
			
		}
		return null;
	}
	
	public Moment getOverallHappiestMoment() 
	{
		return null;
	}
	
}
