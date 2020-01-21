package model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
		private int weather_number;
		private String region;
		private String day;
		private double avgTemp;
		private double maxTemp;
		private double minTemp;
		private double clouds;
		private double precipitation;
		
}
