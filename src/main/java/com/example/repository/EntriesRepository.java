package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Entries;
import org.springframework.stereotype.Repository;

@Repository
public interface EntriesRepository extends JpaRepository<Entries, Integer>{

}
