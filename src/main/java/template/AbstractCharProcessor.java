package template;

/**
 * Created by Beka on 09.04.17.
 */
public abstract class AbstractCharProcessor {


    public final void process(String[] arr) {
        if (arr.length < 5) {
            throw new IllegalArgumentException("Array size should at least 5");
        }
        String type = identifySymmetry(arr);
        String[][] result = reconstructLetter(arr, type);
        print(result);
    }

    public abstract String identifySymmetry(String[] arr);

    public abstract String [][] reconstructLetter(String [] src, String type);

    public abstract void print(String[][] result);

}
