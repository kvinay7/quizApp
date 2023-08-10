package com.springboot.quizApp.service;

import com.springboot.quizApp.dao.QuestionDao;
import com.springboot.quizApp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private static QuestionDao questionDao;

    @Autowired
    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public static List<Questions> getAllQuestions() {
        try {
            return questionDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void save(Questions question) {
        questionDao.save(question);
    }

    public void deleteById(int theId){
        questionDao.deleteById(theId);
    }

    public Questions findById(int theId) {
        Optional<Questions> result = questionDao.findById(theId);
        Questions theQuestions = null;
        if (result.isPresent()) {
            theQuestions = result.get();
        }
        else {
            throw new RuntimeException("Did not find question id - " + theId);
        }
        return theQuestions;
    }

}