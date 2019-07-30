package com.project.project.dao;

import com.project.project.entities.StatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Integer> {
}
