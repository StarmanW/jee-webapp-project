package com.starmanw.common;

import java.util.Date;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.descriptors.DescriptorEventAdapter;

import com.starmanw.entity.AbstractEntityBase;

public class StarmanWEntityListener extends DescriptorEventAdapter {
	@Override
	public void prePersist(DescriptorEvent event) {
		AbstractEntityBase entity = (AbstractEntityBase) event.getObject();
		entity.setDateCreated(new Date());
		entity.setCreatedBy("system");
	}

	@Override
	public void aboutToUpdate(DescriptorEvent event) {
		AbstractEntityBase entity = (AbstractEntityBase) event.getObject();
		entity.setDateUpdated(new Date());
		entity.setUpdatedBy("system");
	}
}
