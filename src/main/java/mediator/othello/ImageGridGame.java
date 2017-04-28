package mediator.othello;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public abstract class ImageGridGame<T> {

	// fxml loading on startup
	
	@FXML
	protected ImageGrid<T> imageGrid;

	@FXML
	protected void initialize() {
		ensureKeyboardFocus();
		for (Map.Entry<T, String> entry : imageGrid.getImageKeyMapEntries()) {
			imageGrid.setImage(entry.getKey(), entry.getValue(), this);
		}
	}

	protected void ensureKeyboardFocus() {
	}

	// fields and methods for managing the grid

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
	
	public static interface CellProcedure {
		public void applyCell(int x, int y);
	}
	
	public void foreachCell(CellProcedure proc, int startX, int startY, int width, int height) {
		for (int x = startX; x < (startX + width) && x < imageGrid.getColumnCount(); x++) {
			for (int y = startY; y < (startY + height) && y < imageGrid.getRowCount(); y++) {
				proc.applyCell(x, y);
			}
		}
	}
	public void foreachCell(CellProcedure proc) {
		foreachCell(proc, 0, 0, imageGrid.getColumnCount(), imageGrid.getRowCount());
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
	
	public static interface CellFunction<T> {
		public T applyCell(int x, int y);
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
	public int countCells(CellFunction<Integer> fun) {
		return countCells(fun, 0, 0, imageGrid.getColumnCount(), imageGrid.getRowCount());
	}

	public int countCellsIf(CellFunction<Boolean> fun) {
		return countCells((x, y) -> fun.applyCell(x, y) ? 1 : 0, 0, 0, imageGrid.getColumnCount(), imageGrid.getRowCount());
	}


	// cursor
	
	protected void setCursor(Cursor cursor) {
		imageGrid.setCursor(cursor);
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
	protected  boolean mouseClicked(int x, int y) {
		return false;
	}
	
	private Point2D dragStart = null;
	private ImageView dragNode = null, feedbackNode = null;

	@FXML
	protected void mouseMoved(MouseEvent mouseEvent) {
		Node child = mouseEvent.getPickResult().getIntersectedNode();
		applyCell((x, y) -> {
			Boolean result = mouseMoved(x, y);
			if (result != null) {
				mouseEvent.consume();
			}
			return dragNode;
		} , child);
	}
	protected Boolean mouseMoved(int x, int y) {
		return null;
	}
	
	@FXML
	protected void mousePressed(MouseEvent mouseEvent) {
		Node child = mouseEvent.getPickResult().getIntersectedNode();
		applyCell((x, y) -> {
			Boolean result = mousePressed(x, y);
			if (result != null) {
				if (result) {
					dragNode = imageGrid.getImageView(getCell(x, y), x, y);
					feedbackNode = createFeedbackImageView(dragNode);
					dragNode.setVisible(false);
					dragStart = new Point2D(mouseEvent.getX(), mouseEvent.getY());
				}
				mouseEvent.consume();
			}
			return dragNode;
		} , child);
	}
	protected Boolean mousePressed(int x, int y) {
		return null;
	}

	private ImageView createFeedbackImageView(ImageView dragNode) {
		ImageView imageView = new ImageView(dragNode.getImage());
		imageView.setManaged(false);
		imageView.setMouseTransparent(true);
		Bounds bounds = dragNode.getLayoutBounds();
		Node node = dragNode;
		while (node != imageGrid) {
			bounds = node.localToParent(bounds);
			node = node.getParent();
		}
		imageView.setLayoutX(bounds.getMinX());
		imageView.setLayoutY(bounds.getMinY());
		imageGrid.getChildren().add(imageView);
		return imageView;
	}
	
	@FXML
	protected void mouseDragged(MouseEvent mouseEvent) {
		Node child = mouseEvent.getPickResult().getIntersectedNode();
		Boolean result = applyCell((x, y) -> mouseDragged(x, y), child);
		if (result != null) {
			if (dragStart != null && dragNode != null) {
				relocateDragNode(mouseEvent);
			}
			mouseEvent.consume();
		}
	}

	private void relocateDragNode(MouseEvent mouseEvent) {
		feedbackNode.setTranslateX(dragStart != null ? mouseEvent.getX() - dragStart.getX() : 0);
		feedbackNode.setTranslateY(dragStart != null ? mouseEvent.getY() - dragStart.getY() : 0);
	}

	protected boolean mouseDragged(int x, int y) {
		return false;
	}
	
	@FXML
	protected void mouseReleased(MouseEvent mouseEvent) {
//		if (dragStart != null && dragNode != null) {
			Node child = mouseEvent.getPickResult().getIntersectedNode();
			applyCell((x, y) -> mouseReleased(x, y), child);
//		}
		dragStart = null;
		if (dragNode != null) {
			relocateDragNode(mouseEvent);
			dragNode.setVisible(true);
		}
		if (feedbackNode != null) {
			imageGrid.getChildren().remove(feedbackNode);
		}
		dragNode = null;
		mouseEvent.consume();
	}
	protected boolean mouseReleased(int x, int y) {
		return false;
	}

	//

}
