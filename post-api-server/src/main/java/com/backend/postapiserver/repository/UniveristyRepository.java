package com.backend.postapiserver.repository;

import com.backend.postapiserver.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniveristyRepository extends JpaRepository<University,Long> {
}
