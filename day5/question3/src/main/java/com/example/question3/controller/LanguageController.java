package com.example.question3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question3.model.Language;
import com.example.question3.service.LanguageService;

@RestController
@RequestMapping("/language")
public class LanguageController {
    private LanguageService languageService;
    public LanguageController(LanguageService languageService){
        this.languageService=languageService;
    }

    @PostMapping
    public ResponseEntity<Language> createLanguage(@RequestBody Language language){
        Language l = languageService.saveLanguage(language);
        if(l==null){
            return new ResponseEntity<>(language,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(language,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Language>> getLanguages() {
         List<Language> lan = languageService.getlistLanguages();
        if(lan==null){
            return new ResponseEntity<>(lan,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(lan,HttpStatus.OK);
    }


    @GetMapping("/{languageId}")
    public ResponseEntity<Language> displaybyId(@PathVariable ("languageId") int id){
        Language l = languageService.getLanguageByid(id);
        if(l==null){
            return new ResponseEntity<>(l,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(l,HttpStatus.OK);  
     }

      @PutMapping("/{languageId}")
    public ResponseEntity<Language> updateLanguagebyid(@PathVariable ("languageId") int id, @RequestBody Language language){
        if(languageService.updateLanguage(id,language)){
            return new ResponseEntity<>(language,HttpStatus.OK);
        }
        return new ResponseEntity<>(language,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @DeleteMapping("/{languageId}")
    public ResponseEntity<Boolean> deleteProductbyid(@PathVariable ("languageId") int id){
        if(languageService.deleteLanguage(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
