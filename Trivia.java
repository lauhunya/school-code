
public class Trivia {

    private String questionNum;
    private String question;
    private String corrAnsText;
    private String corrAnsValue;
    private String possAnsText1;
    private String possAnsValue1;
    private String possAnsText2;
    private String possAnsValue2;
    private String possAnsText3;
    private String possAnsValue3;
    
    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum;
    }

    public String getPossAnsText2() {
        return possAnsText2;
    }

    public void setPossAnsText2(String possAnsText2) {
        this.possAnsText2 = possAnsText2;
    }

    public String getPossAnsValue2() {
        return possAnsValue2;
    }

    public void setPossAnsValue2(String possAnsValue2) {
        this.possAnsValue2 = possAnsValue2;
    }

    public String getPossAnsText3() {
        return possAnsText3;
    }

    public void setPossAnsText3(String possAnsText3) {
        this.possAnsText3 = possAnsText3;
    }

    public String getPossAnsValue3() {
        return possAnsValue3;
    }

    public void setPossAnsValue3(String possAnsValue3) {
        this.possAnsValue3 = possAnsValue3;
    }

    public Trivia() {
    }

    public Trivia(String question, String corrAnsText,String corrAnsValue, String possAnsText1, String possAnsValue1) {
        this.question = question;
        this.corrAnsText = corrAnsText;
        this.corrAnsValue = corrAnsValue;
        this.possAnsText1 = possAnsText1;
        this.possAnsValue1 = possAnsValue1;

    }

    public String getPossAnsText1() {
        return possAnsText1;
    }

    public void setPossAnsText1(String possAnsText1) {
        this.possAnsText1 = possAnsText1;
    }

    public String getPossAnsValue1() {
        return possAnsValue1;
    }

    public void setPossAnsValue1(String possAnsValue1) {
        this.possAnsValue1 = possAnsValue1;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrAnsText() {
        return corrAnsText;
    }

    public void setCorrAnsText(String corrAnsText) {
        this.corrAnsText = corrAnsText;
    }

    public String getCorrAnsValue() {
        return corrAnsValue;
    }

    public void setCorrAnsValue(String corrAnsValue) {
        this.corrAnsValue = corrAnsValue;
    }

}
