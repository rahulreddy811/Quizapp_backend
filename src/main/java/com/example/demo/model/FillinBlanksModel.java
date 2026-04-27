package com.example.demo.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "fillinblanks")
public class FillinBlanksModel {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 500)
    private String questions;

    @Column(length = 500)
    private String answers;

    @Column(length = 500)
    private String options; // Comma-separated options stored in DB

    @Transient
    private String[] optionsArray; // Computed for frontend


    public FillinBlanksModel() {}


    public FillinBlanksModel(String questions, String answers, String options) {
        this.questions = questions;
        this.answers = answers;
        this.options = options;
    }


    public FillinBlanksModel(UUID id, String questions, String answers, String options, String[] optionsArray) {
        this.id = id;
        this.questions = questions;
        this.answers = answers;
        this.options = options;
        this.optionsArray = optionsArray;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getQuestions() { return questions; }
    public void setQuestions(String questions) { this.questions = questions; }

    public String getAnswers() { return answers; }
    public void setAnswers(String answers) { this.answers = answers; }

    public String getOptions() { return options; }
    public void setOptions(String options) {
        this.options = options;
        this.optionsArray = options != null ? options.split(",") : null;
    }

    public String[] getOptionsArray() {

        if (optionsArray == null && options != null) {
            optionsArray = options.split(",");
        }
        return optionsArray;
    }

    public void setOptionsArray(String[] optionsArray) {
        this.optionsArray = optionsArray;
        this.options = optionsArray != null ? String.join(",", optionsArray) : null;
    }
}