package cor.task;

/**
 * Created by Beka on 08.04.17.
 */
public class Document {
    private final int weight;
    private final String content;

    public Document(int weight, String content) {
        this.weight = weight;
        this.content = content;
    }

    public int getWeight() {
        return weight;
    }
}
