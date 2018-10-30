import java.util.ArrayList;

public class Moment {
    final private String _name;
    final private Image _image;
    final private ArrayList<LivingEntity> _participants;
    final private ArrayList<Float> _smileValues;

    public Moment(String name, Image image, ArrayList<LivingEntity> participants, ArrayList<Float> smileValues) {
        _name = name;
        _image = image;
        _participants = participants;
        _smileValues = smileValues;
    }

    public String getName() {
        return _name;
    }

    public boolean equals(Object o){
        Moment moment=(Moment) o;
        return _name.equals(moment.getName());
    }

    public ArrayList<LivingEntity> getParticipants() {
        return _participants;
    }

    public ArrayList<Float> getSmileValues() {
        return _smileValues;
    }
}
