package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.ResidenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceRepositoy extends JpaRepository<ResidenceEntity, Long> {
}
