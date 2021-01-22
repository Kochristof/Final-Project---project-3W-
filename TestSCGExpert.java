package com.example.model;

/* import java.util.*; */

public class TestSCGExpert {
	public float getResProfil1(int quest1,int quest17,int quest18,int quest19,int quest29) {
		float resProf1;
		
		resProf1 = quest1 + quest17 + quest18 + quest19 + quest29;
		resProf1 = (resProf1 / 5) * 100;
		
		return(resProf1);
	}
	
	public float getResProfil2(int quest5,int quest9,int quest10,int quest11,int quest12,int quest13,int quest14,int quest15,int quest28) {
		float resProf2;

		resProf2 = quest5 + quest9 + quest10 + quest11 + quest12 + quest13 + quest14 + quest15 + quest28;
		resProf2 = (resProf2 / 9) * 100;
		
		return(resProf2);
	}
	
	public float getResProfil3(int quest1,int quest4,int quest16,int quest18,int quest29) {
		float resProf3;

		resProf3 = quest1 + quest4 + quest16 + quest18 + quest29;
		resProf3 = (resProf3 / 5) * 100;
		
		return(resProf3);
	}
	
	public float getResProfil4(int quest3,int quest6,int quest7,int quest17,int quest27,int quest29) {
		float resProf4;

		resProf4 = quest3 + quest6 + quest17 + quest27 + quest29;
		resProf4 = (resProf4 / 6) * 100;
		
		return(resProf4);
	}
	
	public float getResField1(int quest2,int quest4,int quest10,int quest14,int quest15,int quest16,int quest17,int quest24,int quest27,int quest28) {
		float resField1;

		resField1 = quest2 + quest4 + quest10 + quest14 + quest15 + quest16 + quest17 + quest24 + quest27 + quest28;
		resField1 = (resField1 / 10) * 100;
		
		return(resField1);
	}
	
	public float getResField2(int quest5,int quest7,int quest8,int quest10,int quest21,int quest22,int quest23,int quest27) {
		float resField2;

		resField2 = quest5 + quest7 + quest8 + quest10 + quest21 + quest22 + quest23 + quest27;
		resField2 = (resField2 / 8) * 100;
		
		return(resField2);
	}
	
	public float getResField3(int quest5,int quest7,int quest21,int quest25,int quest26,int quest27) {
		float resField3;

		resField3 = quest5 + quest7 + quest21 + quest25 + quest26 + quest27;
		resField3 = (resField3 / 6) * 100;
		
		return(resField3);
	}
	
	public float getResField4(int quest17,int quest20,int quest27,int quest29,int quest30) {
		float resField4;

		resField4 = quest17 + quest20 + quest27 + quest29 + quest30;
		resField4 = (resField4 / 5) * 100;
		
		return(resField4);
	}
}