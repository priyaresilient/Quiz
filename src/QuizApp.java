import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuizApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader bf = new BufferedReader(new FileReader(
					"E:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\Quiz\\src\\Quiz"));
			String line = "";
			String question = "";
			String options = "";
			String answer = "";
			int questNum = 1;
			int lineNum = 0;
			Map<Integer, String> answerKey = new HashMap<Integer, String>();
			List<QuestionModel> qList = new ArrayList<>();
			while (line != null) {
				lineNum++;
				line = bf.readLine();
				if (lineNum == 1) {
					question = line;
				}
				if (lineNum == 2) {
					options = line;
				}
				if (lineNum == 3) {
					lineNum = 0;
					QuestionModel quest = new QuestionModel();
					quest.setQid(questNum);
					quest.setQuestion(question);
					List<String> opt = new ArrayList<String>(Arrays.asList(options.split(",")));
					quest.setOptions(opt);
					quest.setAnswer(line);
					answerKey.put(questNum, line);
					qList.add(quest);
					// System.out.println(quest);
					questNum++;
				}

			}
			bf.close();
			Scanner sc = new Scanner(System.in);
			String input = "yes";
			while (input.equalsIgnoreCase("yes")) {
				for (QuestionModel q : qList) {
					System.out.println(q.getQuestion());
					System.out.println(q.getOptions().toString());
					String ans = sc.nextLine();
					if (answerKey.get(q.getQid()).equalsIgnoreCase(ans)) {
						System.out.println("Correct answer!");
					} else {
						System.out.println("Correct answer is " + q.getAnswer());
					}
				}
				System.out.println("Would you like to Play again:(yes/no)");
				input = sc.next();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
