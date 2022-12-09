package com.demo.javamongo.interfaces;

import com.demo.javamongo.model.Questionnaire;

import java.util.List;

public interface IQuestionnaireService {

    List<Questionnaire> findAll(String orgId);
    Questionnaire findByQuestionnaireId(String id);
    Questionnaire addOrUpdateQuestionnaire(Questionnaire item);
    void deleteQuestionnaireById(String id);
}