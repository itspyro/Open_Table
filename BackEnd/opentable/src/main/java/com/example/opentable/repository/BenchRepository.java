package com.example.opentable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.opentable.repository.entity.Bench;

@Repository
public interface BenchRepository extends JpaRepository<Bench, Integer> {

}
