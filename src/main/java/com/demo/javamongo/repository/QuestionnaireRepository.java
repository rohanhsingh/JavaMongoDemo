package com.demo.javamongo.repository;

import com.demo.javamongo.model.Questionnaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {

    @Query("{OrgId:'?0'}")
    List<Questionnaire> findQuestionnairesByOrg(String OrgId);

    @Query(value="{displayName:'?0', orgId:'?1'}", fields="{'WelcomeText' : 1, 'DisplayName' : 1}")
    Questionnaire findQuestionnaireByDisplayAndOrg(String displayName, String orgId);

    public long count();
}
