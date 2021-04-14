package com.tyss.springCoreProjecto.dao;

import java.util.Date;

import com.tyss.springCoreProject.dto.QuizQuestions;
import com.tyss.springCoreProject.dto.Register;
import com.tyss.springCoreProject.dto.Results;

public interface Quiz {

	abstract Register login(String username, String Password);

	abstract Register register(Register register);

	abstract QuizQuestions questions(int id);

	abstract void results(Results results);

	abstract Results getResults(Date date);

}
