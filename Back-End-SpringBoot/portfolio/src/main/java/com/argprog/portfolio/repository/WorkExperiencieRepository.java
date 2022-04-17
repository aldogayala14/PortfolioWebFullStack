package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.WorkExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperiencieRepository extends JpaRepository<WorkExperienceEntity, Long> {
}
