package cor;

import java.util.Random;

/**
 * Created by Beka on 08.04.17.
 */
public class TaHandler extends Handler {
    protected TaHandler(Handler sucessor) {
        super(sucessor);
    }

    @Override
    public int getAllowable() {
        return 2;
    }

    @Override
    int assessDocument(Document document) {
        System.out.println("This is a "+this.getClass());
        return new Random().nextInt();
    }
}
