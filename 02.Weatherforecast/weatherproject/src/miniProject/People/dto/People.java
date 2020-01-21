package miniProject.People.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {
	
	private String name;
	private String SSN;
	private String region;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 1. 이름 : ");
		builder.append(name);
		builder.append(" 2. 생년월일 : ");
		builder.append(SSN);
		builder.append(" 3. 지역 : ");
		builder.append(region);
		return builder.toString();
	}
}
