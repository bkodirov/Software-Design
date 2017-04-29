package mediator.othello.board;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class ImageGridGame<T> {

    @FXML
    protected ImageGrid<T> imageGrid;

    @FXML
    protected void initialize() {
        for (Map.Entry<T, String> entry : imageGrid.getImageKeyMapEntries()) {
            imageGrid.setImage(entry.getKey(), entry.getValue());
        }
    }


    private List<T> cells = new ArrayList<T>();

    public boolean isValidXY(int x, int y) {
        return x >= 0 && x < imageGrid.getColumnCount() && y >= 0 && y < imageGrid.getRowCount();
    }

    private int cellPos(int x, int y) {
        return y * imageGrid.getColumnCount() + x;
    }

    public T getCell(int x, int y) {
        if (isValidXY(x, y)) {
            int pos = cellPos(x, y);
            return (pos >= 0 && pos < cells.size() ? cells.get(pos) : null);
        }
        return null;
    }

    public void setCell(int x, int y, T value) {
        if (isValidXY(x, y)) {
            int pos = cellPos(x, y);
            while (pos >= cells.size()) {
                cells.add(null);
            }
            cells.set(pos, value);
            updateCell(x, y);
        }
    }

    // iterate over cells

    public interface CellProcedure {
        void applyCell(int x, int y);
    }

    public void foreachCell(CellProcedure proc, int startX, int startY, int width, int height) {
        for (int x = startX; x < (startX + width) && x < imageGrid.getColumnCount(); x++) {
            for (int y = startY; y < (startY + height) && y < imageGrid.getRowCount(); y++) {
                proc.applyCell(x, y);
            }
        }
    }

    private void updateCell(int x, int y) {
        imageGrid.setImage(getCell(x, y), x, y);
    }

    protected void fillCells(T value, int startX, int startY, int width, int height) {
        foreachCell((x, y) -> setCell(x, y, value), startX, startY, width, height);
    }

    protected void fillGrid(T value) {
        fillCells(value, 0, 0, imageGrid.getColumnCount(), imageGrid.getRowCount());
    }

    // count cells
    public  interface CellFunction<T> {
         T applyCell(int x, int y);
    }

    public int countCells(CellFunction<Integer> fun, int startX, int startY, int width, int height) {
        int accum = 0;
        for (int x = startX; x < (startX + width) && x < imageGrid.getColumnCount(); x++) {
            for (int y = startY; y < (startY + height) && y < imageGrid.getRowCount(); y++) {
                accum += fun.applyCell(x, y);
            }
        }
        return accum;
    }

    public int countCellsIf(CellFunction<Boolean> fun) {
        return countCells((x, y) -> fun.applyCell(x, y) ? 1 : 0, 0, 0, imageGrid.getColumnCount(), imageGrid.getRowCount());
    }

    // mouse and drag and drop
    <R> R applyCell(CellFunction<R> fun, Node child) {
        Integer x = null, y = null;
        for (Node node = child; node != imageGrid; node = node.getParent()) {
            if ((x = GridPane.getColumnIndex(node)) != null) {
                break;
            }
        }
        for (Node node = child; node != imageGrid; node = node.getParent()) {
            if ((y = GridPane.getRowIndex(node)) != null) {
                break;
            }
        }
        if (x != null && y != null) {
            return fun.applyCell(x, y);
        }
        return null;
    }

    @FXML
    protected void mouseClicked(MouseEvent mouseEvent) {
        Node child = mouseEvent.getPickResult().getIntersectedNode();
        Boolean result = applyCell(this::mouseClicked, child);
        if (result != null) {
            mouseEvent.consume();
        }
    }

    protected boolean mouseClicked(int x, int y) {
        return false;
    }
}
