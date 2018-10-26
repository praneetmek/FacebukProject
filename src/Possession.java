import java.awt.Image;

public class Possession {
//Data
    private String name;
    private Person owner;
    private Image img;
    private float price;

//Constructor

    /**
     * Sets the specifications of the possession
     * @param name
     * @param itemImg
     * @param itemPrice
     */
    public Possession(String name, Image itemImg, float itemPrice) {
        this.name = name;
        img = itemImg;
        price = itemPrice;
    }

//Methods

    /**
     * Returns the price of the possession
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the owner of the possession
     * @param person
     */
    public void setOwner(Person person) {
        owner = person;
    }

    public boolean equals(Possession possession){
        return possession.getName().equals(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}