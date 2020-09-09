package org.kese.listing_service.dao.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@MappedSuperclass
public abstract class BaseEntity {

	@Version
	private long version;

	@Column(name = "LAST_ACTIVITY")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastActivity;

	@Column(name = "CREATION_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date creationDate;

	@Type(type = "uuid-char")
	@Column(name = "UUID")
	protected UUID uuid;

	@PrePersist
	private void prePersist() {
		lastActivity = new Date();
		creationDate = lastActivity;
	}

	@PreUpdate
	private void preUpd() {
		lastActivity = new Date();
	}

}
