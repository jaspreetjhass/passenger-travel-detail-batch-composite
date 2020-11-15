package org.jp.passenger.travel.batch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Passenger")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger implements Serializable {

	private static final long serialVersionUID = -6945334058299202354L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "passengerId")
	private Long id;
	@Column(name = "passengerName")
	private String name;

}
