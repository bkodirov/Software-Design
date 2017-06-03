package abstract_factory.task;

/**
 * Created by Beka on 03.06.17.
 */
public abstract class AbstractGift {
    protected String giftName;
    protected String description;

    public AbstractGift( String giftName, String description) {
        this.giftName = giftName;
        this.description = description;
    }
    public abstract float getCost();

    public String  getName() {
        return giftName;
    }
}
