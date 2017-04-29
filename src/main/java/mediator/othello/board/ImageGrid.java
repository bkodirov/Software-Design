package mediator.othello.board;

import javafx.geometry.Dimension2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ImageGrid<T> extends GridPane {

    public ImageGrid() {
        super();
        setFocusTraversable(true);
    }


    private int columns = 0, rows = 0;

    public void setRowCount(int rows) {
        this.rows = rows;
        System.out.println("setRowCount");
        setDimensions(columns, rows);
    }

    public void setColumnCount(int columns) {
        this.columns = columns;
        System.out.println("setColumnCount");
        setDimensions(columns, rows);
    }

    private Dimension2D cellDimension = null;


    private String[][] cellColors = null;


    private ImageView[] imageViews = null;

    public void setDimensions(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        imageViews = new ImageView[columns * rows];
        getChildren().clear();
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return columns;
    }

    private List<Entry<T, String>> imageKeyMapEntries = null;

    public List<Entry<T, String>> getImageKeyMapEntries() {
        if (imageKeyMapEntries == null) {
            imageKeyMapEntries = new ArrayList<>();
        }
        return imageKeyMapEntries;
    }

    private Entry<T, String> lastImageKeyMapEntry = null;
    private Map<T, String> imageKeyMap;

    private Map<T, String> getImageKeyMap() {
        if (imageKeyMap == null) {
            imageKeyMap = new HashMap<T, String>();
        }
        if (imageKeyMapEntries != null) {
            int start = imageKeyMapEntries.indexOf(lastImageKeyMapEntry) + 1;
            for (int i = start; i < imageKeyMapEntries.size(); i++) {
                Entry<T, String> entry = imageKeyMapEntries.get(i);
                imageKeyMap.put(entry.getKey(), entry.getValue());
                lastImageKeyMapEntry = entry;
            }
        }
        return imageKeyMap;
    }

    private Map<Object, Image> images = new HashMap<>();

    private Image getImage(String imageUrl) {
        Image image = images.get(imageUrl);
        if (image == null) {
            URL url = getClass().getResource(imageUrl);
            if (url != null) {
                image = new Image(url.toExternalForm());
                images.put(imageUrl, image);
            }
        }
        return image;
    }

    public void setImage(T imageKey, String imageUrl) {
        Image image = getImage(imageUrl);
        if (image == null) {
            imageException(imageUrl);
        }
        getImageKeyMap().put(imageKey, imageUrl);
        images.put(imageUrl, image);
        images.put(imageKey, image);
    }

    private void imageException(Object imageKey) {
        throw new IllegalArgumentException("Couldn't get image for " + imageKey);
    }

    private Image getImage(T imageKey) {
        return images.get(imageKey);
    }

    ImageView getImageView(T imageKey, int column, int row) {
        int imagePos = row * columns + column;
        ImageView imageView = imageViews[imagePos];
        if (imageView == null) {
            imageView = new ImageView();
            imageViews[imagePos] = imageView;
            Node node = imageView;
            if (cellDimension != null) {
                StackPane pane = new StackPane();
                pane.setPrefSize(cellDimension.getWidth(), cellDimension.getHeight());
                pane.getChildren().add(node);
                if (cellColors != null) {
                    String[] rowColors = cellColors[row % cellColors.length];
                    String color = rowColors[column % rowColors.length];
                    pane.setStyle("-fx-background-color: " + color + ";");
                }
                StackPane.setAlignment(imageView, Pos.CENTER);
                node = pane;
            }
            add(node, column, row);
        }
        return imageView;
    }

    public Image setImage(T imageKey, int column, int row) {
        ImageView imageView = getImageView(imageKey, column, row);
        Image image = getImage(imageKey);
        imageView.setImage(image);
        return image;
    }
}
