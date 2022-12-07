package com.backend.postapiserver.repository;

import com.backend.postapiserver.entity.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Long> {
}
