package com.example.quizappriinvest;

public class Answers {
    private int oA,oB,oC,oD,qID,aID;
    public Answers(int optionA,int optionB,int optionC, int optionD, int questionID, int answerID){
        oA=optionA;
        oB=optionB;
        oC=optionC;
        oD=optionD;
        qID=questionID;
        aID=answerID;
    }

    public int getoA() {
        return oA;
    }

    public int getoB() {
        return oB;
    }

    public int getoC() {
        return oC;
    }

    public int getoD() {
        return oD;
    }

    public int getqID() {
        return qID;
    }

    public int getaID() {
        return aID;
    }
}
