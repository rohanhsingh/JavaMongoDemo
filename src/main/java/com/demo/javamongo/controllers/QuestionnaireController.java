package com.demo.javamongo.controllers;

import com.demo.javamongo.interfaces.IQuestionnaireService;
import com.demo.javamongo.model.Questionnaire;
import com.demo.javamongo.model.QuestionnaireDTO;
import com.demo.javamongo.services.QuestionnaireService;
import com.demo.javamongo.utils.ObjectMapperUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Questionnaire")
public class QuestionnaireController {

    @Autowired
    private IQuestionnaireService questionnaireService;

    @GetMapping(value = "/{orgId}")
    public List<QuestionnaireDTO> getAllQuestionnairesByOrg(@PathVariable("orgId") String orgId){
        return ObjectMapperUtils.mapAll(questionnaireService.findAll(orgId), QuestionnaireDTO.class);
    }
    @GetMapping(value = "/{orgId}/{questionnaireId}")
    public QuestionnaireDTO getQuestionnairesById(@PathVariable("orgId") String orgId, @PathVariable("questionnaireId") String questionnaireId){
        return ObjectMapperUtils.map(questionnaireService.findByQuestionnaireId(questionnaireId), QuestionnaireDTO.class);
    }
    @PostMapping(value = "/{orgId}")
    public ResponseEntity<?> getQuestionnairesById(@PathVariable("orgId") String orgId, @RequestBody QuestionnaireDTO questionnaireDTO){
        questionnaireService.addOrUpdateQuestionnaire(ObjectMapperUtils.map(questionnaireDTO, Questionnaire.class));
        return new ResponseEntity("Questionnaire added successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/{orgId}/{questionnaireId}")
    public ResponseEntity<?> deleteQuestionnaireById(@PathVariable("orgId") String orgId, @PathVariable String questionnaireId) {
        questionnaireService.deleteQuestionnaireById(questionnaireId);
        return new ResponseEntity("Questionnaire deleted successfully", HttpStatus.OK);
    }
}