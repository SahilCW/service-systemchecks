package com.service.systemchecks.repository.notification;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.systemchecks.domain.notification.NotificationLog;

public interface NotificationLogRepo extends JpaRepository<NotificationLog, Long>{

	public NotificationLog findFirstBySessionKeyAndStatusOrderByIdDesc(String mobile,String status);
	
}
