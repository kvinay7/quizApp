package com.springboot.quizApp.controller;

import com.springboot.quizApp.model.Questions;
import com.springboot.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("list")
    public String getAllQuestions(Model theModel) {
        theModel.addAttribute("question", questionService.getAllQuestions());
        return "ques-list";
    }

    @GetMapping("add")
    public String addQuestion(Model theModel) {
        theModel.addAttribute("question", new Questions());
        return "ques-form";
    }

    @PostMapping("save")
    public String saveQuestion(@ModelAttribute("question") Questions theQuestions) {
        questionService.save(theQuestions);
        return "redirect:list";
    }

    @GetMapping("update")
    public String updateQuestion(@RequestParam("questionId") int theId, Model theModel){
       theModel.addAttribute("question", questionService.findById(theId));
       return "ques-form";
    }

    @GetMapping("delete")
    public String deleteQuestion(@RequestParam("questionId") int theId) {
        questionService.deleteById(theId);
        return "redirect:list";
    }
}