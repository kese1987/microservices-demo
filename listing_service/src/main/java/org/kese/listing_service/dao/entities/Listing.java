package org.kese.listing_service.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "LISTING")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Listing extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4409742838207490616L;

	@Column(name = "USER_ID")
	private String userId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LISTING_ID", updatable = false)
	private long listingId;

	@Column(name = "DESCR")
	private String description;

}
