import javax.persistence.Persistence;

public class Run {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("escolaPU");
	}
}
