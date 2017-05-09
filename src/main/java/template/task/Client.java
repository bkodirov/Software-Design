package template.task;

/**
 * Created by Beka on 09.04.17.
 */
public class Client {
    public static void main(String[] args) {
        AbstractCharProcessor processor = new ConcreteCharProcessor1();
        processor.process(VERTICAL);
        processor.process(NONE);
        processor.process(HORIZONTAL);
    }

    private static final String[] VERTICAL = {
            "VERTICAL",
            "5",
            "14",
            "10",
            "20",
            "-----",
            "----+",
            "---++",
            "--++-",
            "--++-",
            "-++--",
            "-++--",
            "-++--",
            "-++++",
            "-++--",
            "-++--",
            "-++--",
            "-++--",
            "-++--"
    };
    private static final String[] HORIZONTAL = {
            "HORIZONTAL",
            "9",
            "8",
            "10",
            "20",
            "---------",
            "---++++--",
            "--++--++-",
            "-++----++",
            "-++------",
            "-++------",
            "-++------",
            "-++------"};


    private static final String[] NONE = {
            "NONE",
            "9",
            "14",
            "10",
            "20",
            "---------",
            "-+++++---",
            "-++--++--",
            "-++---++-",
            "-++---++-",
            "-++---++-",
            "-++--++--",
            "-++++++--",
            "-++---++-",
            "-++----++",
            "-++----++",
            "-++----++",
            "-++---++-",
            "-++++++--"};
}
