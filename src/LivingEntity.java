import java.awt.Image;
import java.util.ArrayList;

public class LivingEntity 
{
// Data
	
	private String name;
	private Image img; 
	private ArrayList<LivingEntity> friends;
	private ArrayList<Moment> moments;
	
// Constructor(s)
	
	public LivingEntity(String friendName, Image friendImage) {
		name = friendName;
		img = friendImage;
	}
// Methods
	
	/**
	 * Returns the entity's name.
	 * @return  the entity's name
	 */
	public String getName() {
		return name;
	}
	
	public ArrayList getFriends() {
		return friends;
	}
	
	public void setFriends(ArrayList<LivingEntity> friendList) {
		friends = friendList;
	}
	
	public void setMoments(ArrayList<Moment> listOfMoment) {
		moments = listOfMoment;
	}
	
	public void addFriend(LivingEntity friend) {
		friends.add(friend);
	}
	
	public int getAverageHappiness(LivingEntity friend) 
	{
		ArrayList<Integer> avgHappiness = null; 
		for (Moment moment : moments) 
		{
			for (LivingEntity le : moment.getParticipants()) 
			{
				for()
			}
		}
		
	}
	
	public LivingEntity getFriendWithWhomIAmHappiest() 
	{
		LivingEntity friend; 
		for(int x=0; x<friends.size(); x++) 
		{
			
		}
		return null;
	}
	
	public Moment getOverallHappiestMoment() 
	{
		return null;
	}
	
}
