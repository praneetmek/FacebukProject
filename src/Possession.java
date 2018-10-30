
public class Possession {
//Data
    private String _name;
    private Person _owner;
    private Image _img;
    private float _price;

//Constructor

    /**
     * Sets the specifications of the possession
     * @param name
     * @param itemImg
     * @param itemPrice
     */
    public Possession(String name, Image itemImg, float itemPrice) {
        _name = name;
        _img = itemImg;
        _price = itemPrice;
    }

//Methods

    /**
     * Returns the price of the possession
     * @return price
     */
    public float getPrice() {
        return _price;
    }

    /**
     * Sets the owner of the possession
     * @param person
     */
    public void setOwner(Person person) {
        _owner = person;
    }

    public boolean equals(Object o){
        Possession possession=(Possession) o;
        return possession.getName().equals(_name);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Person getOwner() {
        return _owner;
    }

    public Image getImg() {
        return _img;
    }

    public void setImg(Image img) {
        _img = img;
    }

    public void setPrice(float price) {
        _price = price;
    }
}