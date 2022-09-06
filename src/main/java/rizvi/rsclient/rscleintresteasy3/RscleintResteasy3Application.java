package rizvi.rsclient.rscleintresteasy3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rizvi.rsclient.rscleintresteasy3.service.integ.GoUser;
import rizvi.rsclient.rscleintresteasy3.service.integ.GorestClient;
import rizvi.rsclient.rscleintresteasy3.service.integ.QuraanConnector;

@SpringBootApplication
public class RscleintResteasy3Application implements CommandLineRunner {

	@Autowired
	private QuraanConnector quraanConnector;

	@Autowired
	private GorestClient gorestClient;

	public static void main(String[] args) {
		SpringApplication.run(RscleintResteasy3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String chapterList = quraanConnector.chapterList("ur");
		System.out.println(chapterList);
		double random = Math.random();
		GoUser user = GoUser.builder().name("Amir"+random).email(+random+"email@email.com").gender("male").status("Active").build();
		gorestClient.createUser(user);
		String userList = gorestClient.userList();
		System.out.println(userList);
	}

}
