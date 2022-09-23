package com.HOSPITAL.MANAGEMENT.Exception;

public class IdExists extends Exception {
@Override
public String getMessage() {
	return "Doctor-Id Already Exists in The DataBase!! Try Diffrent Doctor-Id";
}
}
