package org.jp.passenger.travel.batch.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelDetailDTO {

	private Long id;
	private Date travelDate;
	private String source;
	private String destination;

}
