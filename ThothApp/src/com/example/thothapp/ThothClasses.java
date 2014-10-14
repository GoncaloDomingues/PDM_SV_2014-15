package com.example.thothapp;

import java.util.ArrayList;
import java.util.List;

public class ThothClasses {

	private int id;
	private String uc, turma, prof, sem;

	public ThothClasses(int id, String uc, String turma, String prof,
			String sem) {
		
		this.id = id;
		this.uc = uc;
		this.prof = prof;
		this.turma = turma;
		this.sem = sem;

	}

	public int getId() {
		return id;
	}

	public String getUC() {
		return uc;
	}

	public String getTurma() {
		return turma;
	}

	public String getProf() {
		return prof;
	}

	public String getSem() {
		return sem;
	}

}
