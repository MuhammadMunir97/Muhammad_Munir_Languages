package com.muhammad.languages.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.muhammad.languages.modell.Language;



@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	// this method retrieves all the Languages from the database
    List<Language> findAll();
}
