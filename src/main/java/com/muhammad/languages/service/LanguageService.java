package com.muhammad.languages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.muhammad.languages.modell.Language;
import com.muhammad.languages.repository.LanguageRepository;

@Service
public class LanguageService {

	private final LanguageRepository languageRepository;

	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	// return all the Languages
	public List<Language> findAllLanguages() {
		return languageRepository.findAll();
	}
	
	  // creates a Language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a Language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

	
	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}

	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
	
	
}
