package com.demo.javamongo.controller;

import com.demo.javamongo.model.Questionnaire;
import com.demo.javamongo.services.QuestionnaireService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest
public class QuestionnaireRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuestionnaireService questionnaireService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Questionnaire qnr1;
    private Questionnaire qnr2;

    private final List<Questionnaire> questionnaires = new ArrayList<>();

    @Before
    public void setup(){
        qnr1 = new Questionnaire();
        qnr1.setOrgId("test_org");
        qnr1.setDisplayName("test_display");
        qnr2.setWelcomeText("test_welcome");

        qnr2 = new Questionnaire();
        qnr2.setOrgId("test_org");
        qnr2.setDisplayName("test_display");
        qnr2.setWelcomeText("test_welcome");

        questionnaires.add(qnr1);
        questionnaires.add(qnr2);
    }

    @Test
    public void givenQuestionnaires_whenGetAllQuestionnaires_thenReturnJsonArray() throws Exception {
        given(questionnaireService.findAll("test_org")).willReturn(questionnaires);

        mvc.perform(get("/Questionnaire/test_org")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(qnr1.getDisplayName())));
    }
}
