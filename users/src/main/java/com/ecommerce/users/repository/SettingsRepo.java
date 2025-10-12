package com.ecommerce.users.repository;

import com.ecommerce.users.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsRepo extends JpaRepository<Settings,Long> {
}
