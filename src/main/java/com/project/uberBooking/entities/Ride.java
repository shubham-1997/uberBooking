package com.project.uberBooking.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;
import org.springframework.data.geo.Point;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "RIDES")
public class Ride {
	@Column(name = "RDS_ID")
	private @Id @GeneratedValue Long id;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "RDS_RIDER_ID", nullable = false)
	private User riderId;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "RDS_DRIVER_ID", nullable = false)
	private Driver driverId;

	@Column(name = "RDS_PROMOTION")
	private Long promotion;

	@Column(name = "RDS_TOTAL_DISTANCE")
	private Long totalDistance;
	
	@Basic(optional = false)
	@Column(name = "DC_CREATED_DATE", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "DC_COMPLETED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date completedDate;

	@Column(name = "RDS_TXN_ID")
	private String transactionId;

	@Column(name = "RDS_FARE")
	private String fare;
	
	@Column(name = "RDS_START_LAT_LONG")
	@Type(type = "org.hibernate.spatial.GeometryType")
	private Point startLatitudeLongitude;
	
	@Column(name = "RDS_END_LAT_LONG")
	@Type(type = "org.hibernate.spatial.GeometryType")
	private Point endLatitudeLongitude;

	@Basic(optional = false)
	@Column(name = "RDS_START_TIME", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTimestamp;
	
	@Basic(optional = false)
	@Column(name = "RDS_END_TIME", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTimestamp;
	
	@Column(name = "RDS_DELETED")
	@ColumnDefault("false") 
	private Boolean deleted;
	
	public Ride() {

	}
                               

}