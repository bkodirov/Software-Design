package abstract_factory.task;

/**
 * Created by Beka on 10.04.17.
 */
public interface AbstractFactory {
    AbstractGiftItem  getGiftItem(PackType packType);
}
