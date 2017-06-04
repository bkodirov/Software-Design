package cor.task;

/**
 * Created by Beka on 08.04.17.
 */
public class Client {
    public static void main(String[] args) {
        Document doc = new Document(1, null);
        AbstractHandler hPresident = new PresidentHandler(null);
        AbstractHandler hDirector = new DirectorHandler(hPresident);
        AbstractHandler hTeacher = new TeacherHandler(hDirector);
        AbstractHandler hTa = new TaHandler(hTeacher);
        try {
            System.out.println("We got a mark " + hTa.process(doc));
        } catch (ElligableSuccessorNotFound elligableSuccessorNotFound) {
            System.out.println("There is not a role who can process this document");
        }
    }
}
