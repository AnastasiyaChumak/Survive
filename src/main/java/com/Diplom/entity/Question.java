package com.Diplom.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String text;
	private String weather;
	private String enviroment;
	
 	@OneToMany
	@JoinColumn(name = "question_id")
	private Set<Answer> answers;
	
	@OneToOne
	@JoinColumn(name = "next_question_id")
	private Question nextQuestion; 

	public Set<Answer> getAnswers() {
		return answers;
	}
	
	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}

	public Question getNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(Question nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Question(Integer id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public Question() {
		// TODO Auto-generated constructor stub
	} 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
