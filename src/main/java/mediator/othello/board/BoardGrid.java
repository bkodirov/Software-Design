package mediator.othello.board;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BoardGrid extends GridPane {

    private ImageView[] imageViews = null;
    private int columns = 0, rows = 0;

    public BoardGrid() {
        super();
        setFocusTraversable(true);
    }


    public void setRowCount(int rows) {
        this.rows = rows;
        System.out.println("setRowCount " + rows);
        setDimensions(columns, rows);
    }

    public void setColumnCount(int columns) {
        this.columns = columns;
        System.out.println("setColumnCount " + columns);
        setDimensions(columns, rows);
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return columns;
    }


    public void setDimensions(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        if (columns > 0 && rows > 0) {
            getChildren().clear();
            imageViews = new ImageView[columns * rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int imagePos = i * columns + j;
                    imageViews[imagePos] = new ImageView();
                    add(imageViews[imagePos], j, i);
                }
            }
        }
    }

    public ImageView[] getCells() {
        return imageViews;
    }

    public ImageView getImageView(int column, int row) {
        int imagePos = row * columns + column;
        return imageViews[imagePos];
    }
}
