package facade;

public class JDBCDemoWithFacade {
    public static void main(String[] arg) {
        DataFetcherFacade dataFetcher = new DataFetcherFacadeImpl();
        try {
            System.out.println(dataFetcher.getImportantValue());
        } catch (DataFetchException e) {
            e.printStackTrace();
        }
    }
}