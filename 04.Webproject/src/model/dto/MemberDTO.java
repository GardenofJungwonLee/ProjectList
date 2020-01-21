package model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String age;
	private String sex;
	private String birthday;
	private String address;
	private String job;
	private String height;

}
