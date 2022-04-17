package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<TechnologyEntity, Long> {
}
