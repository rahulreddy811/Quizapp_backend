package com.example.demo.model;

import jakarta.persistence.*;


import java.util.UUID;

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

    public QuestionsModel() {
    }

    public QuestionsModel(UUID id, String question_text, String question_answer, String tag) {
        this.id = id;
        this.question_text = question_text;
        this.question_answer = question_answer;
        this.tag = tag;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(String question_answer) {
        this.question_answer = question_answer;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}