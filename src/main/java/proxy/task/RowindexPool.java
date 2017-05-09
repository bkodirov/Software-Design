package proxy.task;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Beka on 09.04.17.
 */
public class RowindexPool {

    private static final RowindexPool INSTANCE = new RowindexPool();
    private final Map<Integer, Integer> map = new WeakHashMap<Integer, Integer>();


    private RowindexPool() {
    }

    public static RowindexPool getInstance() {
        return INSTANCE;
    }

    public Integer getIndexWrapper(int rowNumber) {
        Integer rowId = rowNumber;
        if (map.containsKey(rowNumber)) {
            for (Integer integer : map.keySet()) {
                if (integer.equals(rowNumber)) return integer;
            }
        } else {
            map.put(rowNumber, null);
            return rowNumber;
        }
        return rowNumber;
    }
}
