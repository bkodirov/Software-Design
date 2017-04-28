package mediator.othello;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ImageGrid<T> extends GridPane {

	public ImageGrid() {
		super();
		setFocusTraversable(true);
	}

	//
	
	private EventHandler<ActionEvent> onTick = null;
	
	public void setOnTick(EventHandler<ActionEvent> onTick) {
		this.onTick = onTick;
	}
	
	public EventHandler<ActionEvent> getOnTick() {
		return onTick;
	}

	//
	
	private int columns = 0, rows = 0;

	public void setRowCount(int rows) {
		this.rows = rows;
		setDimensions(columns, rows);
	}

	public void setColumnCount(int columns) {
		this.columns = columns;
		setDimensions(columns, rows);
	}

	private Dimension2D cellDimension = null;
	
	public void setCellSize(int size) {
		cellDimension = new Dimension2D(size, size);
	}

	public int getCellSize() {
		return (int) ((cellDimension.getWidth() + cellDimension.getHeight()) / 2);
	}

	//

	private String[][] cellColors = null;
//	{
//		{"white", "grey"},
//		{"grey", "white"}
//	};
	
	public void setCellColors(int colCount, String... colors) {
		cellColors = new String[colors.length / colCount][];
		for (int row = 0; row < colors.length / colCount; row++) {
			cellColors[row] = new String[colCount];
			for (int col = 0; col < colCount; col++) {
				cellColors[row][col] = colors[row * colCount + col];
			}
		}
	}
	
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

	//
	
	private List<Entry<T, String>> imageKeyMapEntries = null;
	
	public List<Entry<T, String>> getImageKeyMapEntries() {
		if (imageKeyMapEntries == null) {
			imageKeyMapEntries = new ArrayList<Entry<T,String>>();
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
	
	public List<T> getImageKeys() {
		return new ArrayList<T>(getImageKeyMap().keySet());
	}

	private Map<Object, Image> images = new HashMap<Object, Image>();

	private Image getImage(String imageUrl, Object... contexts) {
		Image image = images.get(imageUrl);
		if (image == null) {
			URL url = null;
			if (imageUrlFormat != null) {
				imageUrl = formatUrl(imageUrl);
			}
			try {
				url = new URL(imageUrl);
			} catch (MalformedURLException e) {
			}
			int i = 0;
			while (url == null && i < contexts.length) {
				url = contexts[i++].getClass().getResource(imageUrl);
			}
			if (url == null) {
				url = getClass().getResource(imageUrl);
			}
			if (url == null) {
				try {
					url = new URL("file:" + imageUrl);
				} catch (MalformedURLException e) {
				}
			}
			if (url != null) {
				image = new Image(url.toExternalForm());
				images.put(imageUrl, image);
			}
		}
		return image;
	}

	private String formatUrl(String imageUrl) {
		return imageUrlFormat.replace("${key}", String.valueOf(imageUrl));
	}
	
	public void setImage(T imageKey, Image image) {
		images.put(imageKey, image);
	}

	public void setImage(T imageKey, String imageUrl, Object... contexts) {
		Image image = getImage(imageUrl, contexts);
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

	private String imageUrlFormat = null;

	public String getImageUrlFormat() {
		return imageUrlFormat;
	}

	public void setImageUrlFormat(String imageUrlFormat) {
		this.imageUrlFormat = imageUrlFormat;
	}
	
	private Image getImage(T imageKey) {
		Image image = images.get(imageKey);
		if (image == null && imageUrlFormat != null) {
			String imageKey2 = formatUrl(String.valueOf(imageKey));
			image = getImage(imageKey2);
			if (image != null) {
				images.put(imageKey, image);
				images.put(imageKey2, image);
			}
		}
		return image;
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
