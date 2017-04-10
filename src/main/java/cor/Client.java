package cor;

/**
 * Created by Beka on 08.04.17.
 */
public class Client {
    public static void main(String[] args) {
        Document doc = new Document(1, null);
        Handler hPresident = new PresidentHandler(null);
        Handler hDirector = new DirectorHandler(hPresident);
        Handler hTeacher = new TeacherHandler(hDirector);
        Handler hTa = new TaHandler(hTeacher);
        try {
            System.out.println("We got a mark " + hTa.process(doc));
        } catch (ElligableSuccessorNotFound elligableSuccessorNotFound) {
            System.out.println("There is not a role who can process this document");
        }
    }
}
