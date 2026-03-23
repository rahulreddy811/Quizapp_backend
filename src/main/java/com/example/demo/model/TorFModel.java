package com.example.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "trueorfalse")
public class TorFModel {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID id;
    private String question;
    private String answer;

    public TorFModel() {
    }

    public TorFModel(UUID id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
