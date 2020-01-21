package miniProject.People.dto;

import lombok.Data;

	@Data
	public class ClientDTO extends People{
		private int client_id;
		private String registerDay;
		private String grade;
		
		public ClientDTO() {}

		public ClientDTO(int client_id,String name, String SSN, String region,  String registerDay, String grade) {
			super(name, SSN, region);
			this.client_id = client_id;
			this.registerDay = registerDay;
			this.grade = grade;
		}


		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(super.toString());
			builder.append(" 4. ������ : ");
			builder.append(registerDay);		
			builder.append(" 5. ��� : ");
			builder.append(grade);
			builder.append(" 6. ����ȣ : ");
			builder.append(client_id);
			return builder.toString();
		}
}
