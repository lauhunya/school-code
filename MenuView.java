
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@SessionScoped
public class MenuView {

    private TriviaHelper th = new TriviaHelper();
    private MenuModel model;
    private String category;
    private int questionIndex;
    private String question;
    private ArrayList triviaList;
    private int possAnsValue1;
    private int possAnsValue2;
    private int possAnsValue3;
    private String possAnsText1;
    private String possAnsText2;
    private String possAnsText3;
    private int selectedAnsValue;
    private int corrAnsValue;
    private String corrAnsText;
    private boolean displayAnsValue = false;
    private String corrAnsTextDisplay = "";
    private int totalCorrAns = 0;
    private int totalWrongAns = 0;
    private boolean testResultsDisplay = false;
    private boolean questionDisplay = false;
    private boolean welcomeDisplay = true;

    public boolean isWelcomeDisplay() {
        return welcomeDisplay;
    }

    public void setWelcomeDisplay(boolean welcomeDisplay) {
        this.welcomeDisplay = welcomeDisplay;
    }

    public int getTotalCorrAns() {
        return totalCorrAns;
    }

    public void setTotalCorrAns(int totalCorrAns) {
        this.totalCorrAns = totalCorrAns;
    }

    public int getTotalWrongAns() {
        return totalWrongAns;
    }

    public void setTotalWrongAns(int totalWrongAns) {
        this.totalWrongAns = totalWrongAns;
    }

    public boolean isTestResultsDisplay() {
        return testResultsDisplay;
    }

    public void setTestResultsDisplay(boolean testResultsDisplay) {
        this.testResultsDisplay = testResultsDisplay;
    }

    public boolean isQuestionDisplay() {
        return questionDisplay;
    }

    public void setQuestionDisplay(boolean questionDisplay) {
        this.questionDisplay = questionDisplay;
    }

    public String getCorrAnsTextDisplay() {
        return corrAnsTextDisplay;
    }

    public void setCorrAnsTextDisplay(String corrAnsTextDisplay) {
        this.corrAnsTextDisplay = corrAnsTextDisplay;
    }

    public boolean getDisplayAnsValue() {
        return displayAnsValue;
    }

    public void setDisplayAnsValue(boolean isAnsCorr) {
        this.displayAnsValue = isAnsCorr;
    }

    public String getCorrAnsText() {
        return corrAnsText;
    }

    public void setCorrAnsText(String corrAnsText) {
        this.corrAnsText = corrAnsText;
    }

    public int getSelectedAnsValue() {
        return selectedAnsValue;
    }

    public void setSelectedAnsValue(int selectedAnsValue) {
        this.selectedAnsValue = selectedAnsValue;
    }

    public int getPossAnsValue1() {
        return possAnsValue1;
    }

    public void setPossAnsValue1(int possAnsValue1) {
        this.possAnsValue1 = possAnsValue1;
    }

    public int getPossAnsValue2() {
        return possAnsValue2;
    }

    public void setPossAnsValue2(int possAnsValue2) {
        this.possAnsValue2 = possAnsValue2;
    }

    public int getPossAnsValue3() {
        return possAnsValue3;
    }

    public void setPossAnsValue3(int possAnsValue3) {
        this.possAnsValue3 = possAnsValue3;
    }

    public String getPossAnsText1() {
        return possAnsText1;
    }

    public void setPossAnsText1(String possAnsText1) {
        this.possAnsText1 = possAnsText1;
    }

    public String getPossAnsText2() {
        return possAnsText2;
    }

    public void setPossAnsText2(String possAnsText2) {
        this.possAnsText2 = possAnsText2;
    }

    public String getPossAnsText3() {
        return possAnsText3;
    }

    public void setPossAnsText3(String possAnsText3) {
        this.possAnsText3 = possAnsText3;
    }

    public String getQuestion() {

        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

    }

    public MenuModel getModel() {
        return model;
    }

    public void chooseHistory() throws FileNotFoundException {
        triviaList = th.readFile("History");
        questionIndex = 0;
        Trivia t = (Trivia) triviaList.get(questionIndex);
        corrAnsValue = new Integer(t.getCorrAnsValue());
        corrAnsText = t.getCorrAnsText();
        this.setQuestion(t.getQuestionNum() + ". " + t.getQuestion());
        setAnswers(t);
        testResultsDisplay = false;
        questionDisplay = true;
        welcomeDisplay = false;
    }

    public void chooseScience() throws FileNotFoundException {
        triviaList = th.readFile("Science");
        questionIndex = 0;
        Trivia t = (Trivia) triviaList.get(questionIndex);
        corrAnsValue = new Integer(t.getCorrAnsValue());
        corrAnsText = t.getCorrAnsText();
        this.setQuestion(t.getQuestionNum() + ". " + t.getQuestion());
        setAnswers(t);
        testResultsDisplay = false;
        questionDisplay = true;
        welcomeDisplay = false;
    }

    public void chooseArt() throws FileNotFoundException {
        triviaList = th.readFile("Art");
        questionIndex = 0;
        Trivia t = (Trivia) triviaList.get(questionIndex);
        corrAnsValue = new Integer(t.getCorrAnsValue());
        corrAnsText = t.getCorrAnsText();
        this.setQuestion(t.getQuestionNum() + ". " + t.getQuestion());
        setAnswers(t);
        testResultsDisplay = false;
        questionDisplay = true;
        welcomeDisplay = false;
    }

    public void getNextQuestion() {
        if (questionIndex + 1 == triviaList.size()) {
            testResultsDisplay = true;
            questionDisplay = false;
            welcomeDisplay = false;

        } else {
            questionIndex++;
            Trivia t = (Trivia) triviaList.get(questionIndex);
            corrAnsValue = new Integer(t.getCorrAnsValue());
            corrAnsText = t.getCorrAnsText();
            this.setQuestion(t.getQuestionNum() + ". " + t.getQuestion());
            setAnswers(t);
            displayAnsValue = false;
        }
    }

    public void getPrevQuestion() {
        questionIndex--;
        Trivia t = (Trivia) triviaList.get(questionIndex);
        corrAnsValue = new Integer(t.getCorrAnsValue());
        corrAnsText = t.getCorrAnsText();
        this.setQuestion(t.getQuestion());
        setAnswers(t);
        displayAnsValue = false;
    }

    public void setAnswers(Trivia t) {
        this.setPossAnsText1(t.getPossAnsText1());
        this.setPossAnsValue1(Integer.parseInt(t.getPossAnsValue1()));
        this.setPossAnsText2(t.getPossAnsText2());
        this.setPossAnsValue2(Integer.parseInt(t.getPossAnsValue2()));
        this.setPossAnsText3(t.getPossAnsText3());
        this.setPossAnsValue3(Integer.parseInt(t.getPossAnsValue3()));
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void checkAnswer() {
        displayAnsValue = true;
        if (corrAnsValue == selectedAnsValue) {
            corrAnsTextDisplay = "You've selected the correct answer!";
            totalCorrAns++;
        } else {
            corrAnsTextDisplay = "The answer that you have selected is incorrect. The correct answer is " + corrAnsText;
            totalWrongAns++;
        }
        selectedAnsValue = 0;
    }
}
