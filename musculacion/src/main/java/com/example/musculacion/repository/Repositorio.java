package com.example.musculacion.repository;

import com.example.musculacion.entities.MusculacionDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends JpaRepository<MusculacionDB, Long> {
}
