package com.example.question3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.question3.model.Language;
import com.example.question3.repository.LanguageRepository;

@Service
public class LanguageService {
    private LanguageRepository languageRepository;
    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository=languageRepository;
    }

     public Language saveLanguage(Language language){
        return languageRepository.save(language);
    }

    public List<Language> getlistLanguages(){
        return languageRepository.findAll();
    } 

    public Language getLanguageByid(int id){
        return languageRepository.findById(id).orElse(null);
    }

    public boolean updateLanguage(int id, Language language){
        boolean p = languageRepository.existsById(id);
        if(p){
            languageRepository.save(language);
            return true;
        }
        return false;
    }

    public boolean deleteLanguage(int id){
        boolean p = languageRepository.existsById(id);
        if(p){
            languageRepository.deleteById(id);;
            return true;
        }
        return false;
    }
}
