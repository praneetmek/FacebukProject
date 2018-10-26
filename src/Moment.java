import java.lang.reflect.Array;
import java.util.ArrayList;

public class Moment {
    private String name;
    private Image image;
    private ArrayList<LivingEntity> participants;
    private ArrayList<Float> smileValues;

    public Moment(String name, Image image, ArrayList<LivingEntity> participants, ArrayList<Float> smileValues) {
        this.name = name;
        this.image = image;
        this.participants = participants;
        this.smileValues = smileValues;
    }
    public boolean equals(Moment moment){
        return name.equals(moment.name);
    }
}
