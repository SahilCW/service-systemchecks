package com.service.systemchecks.repository.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.systemchecks.domain.notification.NotificationConfig;

public interface NotificationConfigRepo extends JpaRepository<NotificationConfig, Long>{

	public NotificationConfig findBySequenceAndTypeAndIsActive(Integer sequence,Integer type, Boolean isActive);
}
