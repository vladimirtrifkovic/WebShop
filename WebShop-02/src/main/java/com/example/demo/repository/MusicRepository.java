package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

}
