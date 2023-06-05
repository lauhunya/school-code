package triviaquizapplet;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class TriviaHelper {

    public TriviaHelper() {

    }

    private String category;

    public static ArrayList readFile(String category) throws FileNotFoundException {

        ArrayList myList = new ArrayList();

        try {
            String fileName = category + "Trivia.txt";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            String[] questions;

            while (str != null ) {

                System.out.println(str);

                //Read in the next line
                str = br.readLine();
                questions = str.split("\\|");
                Trivia triv = new Trivia();
                triv.setQuestionNum(questions[0]);
                triv.setQuestion(questions[1]);
                triv.setCorrAnsText(questions[9]);
                triv.setCorrAnsValue(questions[8]);
                triv.setPossAnsText1(questions[3]);
                triv.setPossAnsText2(questions[5]);
                triv.setPossAnsText3(questions[7]);
                triv.setPossAnsValue1(questions[2]);
                triv.setPossAnsValue2(questions[4]);
                triv.setPossAnsValue3(questions[6]);
                myList.add(triv);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return myList;
    }

    public static void main(String[] args) {

        try {
            readFile("History");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
