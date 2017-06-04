package cor.task;

import java.util.Random;

/**
 * Created by Beka on 08.04.17.
 */
public class TeacherHandler extends AbstractHandler {
    protected TeacherHandler(AbstractHandler sucessor) {
        super(sucessor);
    }

    @Override
    public int getAllowable() {
        return 5;
    }

    @Override
    int assessDocument(Document document) {
        System.out.println("This is a "+this.getClass());
        return new Random().nextInt();
    }
}
