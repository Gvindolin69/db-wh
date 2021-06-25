import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

public class Requestions {
    private static EntityManager manager;

    public static List<Mountain> allMountains(){
        Query query = manager.createQuery("SELECT m FROM Mountain m");
        return (List<Mountain>)query.getResultList();
    }

    public static List<Mountain> notAllMountains(int min, int max){
        Query query = manager.createQuery("SELECT m FROM Mountain m WHERE m.height BETWEEN " + min
                                            + " and " + max);
        return (List<Mountain>)query.getResultList();
    }

    public static List<Group> notAllMountains(){
        LocalDateTime now = LocalDateTime.now();
        Query query = manager.createQuery("SELECT g FROM Climbing_tb g WHERE g.start < " + now);
        return (List<Group>)query.getResultList();
    }

    public static Climber climberByNameAndEmail(String name, String email){
        Query query = manager.createQuery("SELECT c FROM Climber c WHERE c.fullname = " + name + " AND c.email = " +
                                            email);
        return (Climber) query.getSingleResult();
    }

    public static Mountain mountainByName(String name){
        Query query = manager.createQuery("SELECT m FROM Mountain m WHERE m.name = " + name);
        return (Mountain) query.getSingleResult();
    }
}
