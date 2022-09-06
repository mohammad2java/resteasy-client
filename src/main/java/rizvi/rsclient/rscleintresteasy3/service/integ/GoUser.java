
package rizvi.rsclient.rscleintresteasy3.service.integ;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoUser {

	private String name;
	private String gender;
	private String email;
	private String status;
	
	
}
