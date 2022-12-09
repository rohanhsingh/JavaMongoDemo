package com.demo.javamongo.service;

import com.demo.javamongo.model.Questionnaire;
import com.demo.javamongo.repository.QuestionnaireRepository;
import com.demo.javamongo.services.QuestionnaireService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class QuestionnaireServiceTest {

    @TestConfiguration
    static class QuestionnaireServiceTestContextConfiguration{
        @Bean
        public QuestionnaireService questionnaireService(){
            return new QuestionnaireService();
        }
    }

    @Autowired
    private QuestionnaireService questionnaireService;
    @MockBean
    private QuestionnaireRepository questionnaireRepository;

    private Questionnaire qnr1;
    private Questionnaire qnr2;

    private final String orgId = "testorg";
    private final String displayName1 = "test1";
    private final String displayName2 = "test2";
    private final String welcomeText1 = "test1";
    private final String welcomeText2 = "test2";
    private final List<Questionnaire> questionnaires = new ArrayList<>();

    @Before
    public void setup(){
        qnr1 = new Questionnaire();
        qnr1.setOrgId(orgId);
        qnr1.setDisplayName(displayName1);
        qnr1.setWelcomeText(welcomeText1);

        qnr2 = new Questionnaire();
        qnr2.setOrgId(orgId);
        qnr2.setWelcomeText(welcomeText2);
        qnr2.setDisplayName(displayName2);

        questionnaires.add(qnr1);
        questionnaires.add(qnr2);

        Mockito.when(questionnaireRepository.findQuestionnairesByOrg(orgId)).thenReturn(questionnaires);
        Mockito.when(questionnaireRepository.save(qnr1)).thenReturn(qnr1);
    }

    @Test
    public void testFindAll_thenQnrListShouldBeReturned(){
        List<Questionnaire> foundQuestionnaires = questionnaireService.findAll(orgId);

        assertNotNull(foundQuestionnaires);
        assertEquals(2, foundQuestionnaires.size());
    }

    @Test
    public void testSaveOrUpdateQuestionnaire_thenQuestionnaireShouldBeReturned(){
        Questionnaire found = questionnaireService.addOrUpdateQuestionnaire(qnr1);

        assertNotNull(found);
        assertEquals(qnr1.getOrgId(), found.getOrgId());
        assertEquals(qnr1.getDisplayName(), found.getDisplayName());
    }
}