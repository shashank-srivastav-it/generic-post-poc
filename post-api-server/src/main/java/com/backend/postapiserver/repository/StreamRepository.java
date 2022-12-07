package com.backend.postapiserver.repository;

import com.backend.postapiserver.entity.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StreamRepository extends JpaRepository<Stream, Long> {
}
