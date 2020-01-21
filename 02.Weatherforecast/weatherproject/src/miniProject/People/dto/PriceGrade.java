package miniProject.People.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceGrade {
	private String grade;
	private int price;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 1. ��� : ");
		builder.append(grade);
		builder.append(" 2. ��� : ");
		builder.append(price);
		return builder.toString();
	}
}
