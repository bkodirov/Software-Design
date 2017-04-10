package cor;

import java.util.Random;

/**
 * Created by Beka on 08.04.17.
 */
public class DirectorHandler extends Handler {
    protected DirectorHandler(Handler sucessor) {
        super(sucessor);
    }

    @Override
    public int getAllowable() {
        return 7;
    }

    @Override
    int assessDocument(Document document) {
        System.out.println("This is a "+this.getClass());
        return new Random().nextInt();
    }
}
