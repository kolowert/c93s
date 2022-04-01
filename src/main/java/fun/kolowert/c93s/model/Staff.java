package fun.kolowert.c93s.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Staff {
	private String id;
	private String firstName;
	private String secondName;
	private String email;
	private String role;
	private String passHash;
}
