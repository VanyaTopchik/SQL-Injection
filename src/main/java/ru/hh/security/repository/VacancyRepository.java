package ru.hh.security.repository;

import java.util.List;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class VacancyRepository {

  private final EntityManager entityManager;

  public VacancyRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List getVacanciesByTitle(String title) {
    return entityManager
        .createNativeQuery("SELECT * FROM vacancies WHERE title ILIKE '%" + title + "%'")
        .getResultList();
  }
}
