package com.ssuriyan.hoa.hoamangaservice.repository;

import com.ssuriyan.hoa.hoamangaservice.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends JpaRepository<Manga, String> {
}
