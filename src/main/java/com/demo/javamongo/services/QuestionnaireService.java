package com.demo.javamongo.services;

import com.demo.javamongo.interfaces.IQuestionnaireService;
import com.demo.javamongo.model.Questionnaire;
import com.demo.javamongo.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService implements IQuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Override
    public List<Questionnaire> findAll(String orgId) {
        return questionnaireRepository.findQuestionnairesByOrg(orgId);
    }

    @Override
    public Questionnaire findByQuestionnaireId(String id) {
        var q = questionnaireRepository.findById(id);
        return q.isPresent() ? q.get() : null;
    }

    @Override
    public Questionnaire addOrUpdateQuestionnaire(Questionnaire item) {
        return questionnaireRepository.save(item);
    }

    @Override
    public void deleteQuestionnaireById(String id) {
        questionnaireRepository.deleteById(id);
    }
}