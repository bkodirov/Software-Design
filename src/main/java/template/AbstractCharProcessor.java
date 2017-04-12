package template;

/**
 * Created by Beka on 09.04.17.
 */
public abstract class AbstractCharProcessor {


    public final void process(String[] arr) {
        SymmetryType type = identifySymmetry(arr);
        String[][] result = reconstructLetter(arr, type);
        print(result);
    }

    public abstract SymmetryType identifySymmetry(String[] arr);

    public abstract String [][] reconstructLetter(String [] src, SymmetryType type);

    public abstract void print(String[][] result);

    public enum SymmetryType{
        VERTICAL, HORIZONTAL, NONE
    }
}
