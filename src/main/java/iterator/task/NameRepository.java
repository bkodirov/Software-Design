package iterator.task;

public class NameRepository implements Aggregate {
    private String names[][] = {{"Rob", "Jon", "-"}, {"Jul", "-", "Lor", "Pat", "-"}, {"-", "-", "Ken"}};

    //other methods of the NameRepository
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {
        int indexX;
        int indexY;

        @Override
        public boolean hasNext() {
            for (int i = indexX; i < names.length; i++) {
                for (int j = indexY; j < names[i].length; j++) {
                    if (isValidData(names[i][j])) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isValidData(String data) {
            return data != null && !data.trim().equals("-");
        }

        @Override
        public String next() {
            for (int i = indexX; i < names.length; i++) {
                for (int j = indexY; j < names[i].length; j++) {
                    if (isValidData(names[i][j])) {
                        return names[i][j];
                    }
                }
            }
            return null;
        }
    }
}