package cor.task;

/**
 * Created by Beka on 08.04.17.
 */
public abstract class AbstractHandler {
    private final AbstractHandler sucessor;

    protected AbstractHandler(AbstractHandler sucessor) {
        this.sucessor = sucessor;
    }

    public abstract int getAllowable();
    abstract int assessDocument(Document document);

    public int process(Document document) throws ElligableSuccessorNotFound {
        if (document.getWeight() < getAllowable()) {
            //Here return
            return assessDocument(document);
        }else {
            if (sucessor !=null) {
                sucessor.process(document);
            }
        }
        throw new  ElligableSuccessorNotFound();
    }
}
