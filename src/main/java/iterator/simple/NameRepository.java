package iterator.simple;

/**
 * Concreate aggregate class with a nested concreate iterator class
 */
public class NameRepository implements Aggregate {
    private String names[] = {"Rob", "Jon", "Jul", "Lor", "Pat", "Ken"};


    //other methods of the NameRepository
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}