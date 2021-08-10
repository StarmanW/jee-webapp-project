package com.starmanw.entity;

import java.io.Serializable;
import java.util.Date;

import com.starmanw.common.StarmanWEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(StarmanWEntityListener.class)
public abstract class AbstractEntityBase implements Serializable {
	@Column(name = "DATE_CREATED", nullable = false)
	private Date dateCreated;

	@Column(name = "CREATED_BY", nullable = false)
	private String createdBy;

	@Column(name = "DATE_UPDATED", nullable = true)
	private Date dateUpdated;

	@Column(name = "UPDATED_BY", nullable = true)
	private String updatedBy;

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
