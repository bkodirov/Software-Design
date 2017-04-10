package template;

/**
 * Created by Beka on 09.04.17.
 */
public class ConcreteCharProcessor1 extends AbstractCharProcessor {
    public String identifySymmetry(String[] arr) {
        return arr[0];
    }

    public String[][] reconstructLetter(String[] src, String type) {
        int column = Integer.valueOf(src[1]);
        int row = Integer.valueOf(src[2]);
        int finalColumn = Integer.valueOf(src[3]);
        int finalRow = Integer.valueOf(src[4]);
        String[][] result = null;

        switch (type) {
            case "VERTICAL":
                result = new String[column][row * 2];
                for (int a = 0; a < column; a++) {
                    for (int i = 0, j = row * 2 - 1; i < row; i++, j--) {
//                        result[a][i] = result[a][j] = src[a][i];
                    }
                }
                break;
            case "HORIZONTAL":
                break;
            case "NONE":
                break;
        }
        complete(result);
        return result;
    }

    private void complete(String[][] arr) {

    }

    public void print(String[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
