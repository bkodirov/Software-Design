package flyweight;

import java.util.Arrays;

/**
 * Very heavy object
 * Created by Beka on 23.04.17.
 */
public class Image {
    private int[] data = new int[Integer.MAX_VALUE];
    private int hashCode = Integer.MIN_VALUE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        return Arrays.equals(data, image.data);
    }

    @Override
    public synchronized int hashCode() {
        if (hashCode == Integer.MIN_VALUE) {
            hashCode = Arrays.hashCode(data);
        }
        return hashCode;
    }
}
