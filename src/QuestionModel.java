import java.util.List;

public class QuestionModel {
	private int qid;
	private String question;
	private List<String> options;
	private String answer;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}	
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "QuestionModel [qid=" + qid + ", question=" + question + ", options=" + options + ", answer=" + answer
				+ "]";
	}
	
}
