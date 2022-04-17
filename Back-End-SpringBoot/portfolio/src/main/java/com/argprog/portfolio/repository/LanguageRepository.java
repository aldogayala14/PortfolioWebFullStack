package com.argprog.portfolio.repository;

import com.argprog.portfolio.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity,Long> {
}
