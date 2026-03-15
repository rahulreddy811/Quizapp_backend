package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "quizques")
public class QuestionsModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String question_text;
    private String question_answer;
    private String tag;
    @Column(name = "options",columnDefinition = "text[]")
    private String[] options;

    public QuestionsModel() {
    }

    public QuestionsModel(UUID id, String question_text, String question_answer, String tag,String[] options) {
        this.id = id;
        this.question_text = question_text;
        this.question_answer = question_answer;
        this.tag = tag;
        this.options = options;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public void setQuestion_answer(String question_answer) {
        this.question_answer = question_answer;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}