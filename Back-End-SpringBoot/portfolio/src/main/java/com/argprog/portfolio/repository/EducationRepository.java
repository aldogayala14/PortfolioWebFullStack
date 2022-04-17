package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity,Long> {
}
