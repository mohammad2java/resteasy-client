package rizvi.rsclient.rscleintresteasy3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rizvi.rsclient.rscleintresteasy3.service.AppnameRestServiceImpl;
import rizvi.rsclient.rscleintresteasy3.service.SHConnector;
import rizvi.rsclient.rscleintresteasy3.service.SHConnectorImpl;

@SpringBootApplication
public class RscleintResteasy3Application implements CommandLineRunner {

	@Autowired
	private AppnameRestServiceImpl restService;
	
	@Autowired
	private SHConnectorImpl shService;
	

	public static void main(String[] args) {
		SpringApplication.run(RscleintResteasy3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*String homePage = restService.getHomePage();
		System.out.println("homepage \n" + homePage);
		String javaPage = restService.getJavaPage();
		System.out.println("java-page \n" + javaPage);
		 */
		
		//calling shService
		
		String status = shService.findShowToken("showToken");
		System.out.println(status);
	}

}
