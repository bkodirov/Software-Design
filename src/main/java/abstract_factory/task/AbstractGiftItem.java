package abstract_factory.task;

import java.util.UUID;

public abstract class AbstractGiftItem {
    private String giftId;
    private String giftName;
    private String description;
    private PackType packagingType; //"bag", "box", or "wrap".
    private double  packagingCost;

    public AbstractGiftItem(PackType packagingType, String  giftName, double packagingCost) {
        giftId = UUID.randomUUID().toString();
        this.packagingCost =  packagingCost;
        this.giftName = giftName;
        this.packagingType=packagingType;
        description = "";
    }
    //Here might be some abstract behaviour

    public String getGiftId() {
        return giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public String getDescription() {
        return description;
    }

    public PackType getPackagingType() {
        return packagingType;
    }

    public double getPackagingCost() {
        return packagingCost;
    }
}