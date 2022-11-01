package quiz;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Quiz {

	static Random random = new Random();
	static int count_question = 1;

	static String[] answer_01 = { "He", "Ne", "Ar", "Cl" };
	static String[] answer_02 = { "H", "Fe", "Na", "Cl" };
	static String[] answer_03 = { "Cs", "Na", "Fr", "Cr" };
	static String[] answer_04 = { "Pt", "Au", "Cm", "Le" };
	static String[] answer_05 = { "H", "He", "Er", "W" };
	static String[] answer_06 = { "S", "Se", "B", "Ne" };
	static String[] answer_07 = { "Ag", "Au", "As", "Os" };
	static String[] answer_08 = { "He", "Ne", "Hf", "Hg" };
	static String[] answer_09 = { "U", "Au", "Pb", "Fe" };
	static String[] answer_10 = { "Ba", "Mn", "Ra", "Rf" };

	static String[] questions = { "Which of the following is not a gaseous element?",
			"What is the chemical symbol for Sodium?", "Which of the following is not an alkaline element?",
			"What is the chemical symbol for Gold?", "What is the chemical symbol for Helium?",
			"What is the chemical symbol for Sulfur?", "What is the chemical symbol for Arsenic?",
			"What is the chemical symbol for Mercury?", "What is the chemical symbol for Uranium?",
			"What is the chemical symbol for Radium?" };

	static String[] correctAnswer = { "Cl", "Na", "Cr", "Au", "He", "S", "As", "Hg", "U", "Ra" };

	static String[][] answers = { answer_01, answer_02, answer_03, answer_04, answer_05, answer_06, answer_07,
			answer_08, answer_09, answer_10, };

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		final int POINTSEARNED = 5;
		final int POINTLOSE = 3;
		String name;
		int user_Score = 0;
		int option_User_Value = 0;
		String user_Option;

		System.out.println("***********************************************************");
		System.out.println("****************Welcome to Chemistry Quiz******************");
		System.out.println("***********************************************************\n");

		System.out.println("What Is Your Name?: ");
		name = in.nextLine();

		System.out.println("OK, " + name.toUpperCase() + " Let's Started \n");

		int pointer = 0;

		while (pointer < questions.length) {
			int copy_pointer = pointer;

			printQuestionAndAnswers(questions[pointer], answers[pointer]);
			System.out.println("Write an Option: ");
			user_Option = in.nextLine();

			switch (user_Option) {
			case "a":
				option_User_Value = 0;
				break;
			case "b":
				option_User_Value = 1;
				break;
			case "c":
				option_User_Value = 2;
				break;
			case "d":
				option_User_Value = 3;
				break;
			default:
				System.out.println("Error!!!, Check Your Options, Please!");
				option_User_Value = -1;
			}

			// make sure user type the right options
			if (option_User_Value == -1) {
				continue;
			}

			// verifying user answer
			if (Objects.equals(answers[pointer][option_User_Value], correctAnswer[pointer])) {
				user_Score += POINTSEARNED;
				System.out.println("Your Answer is correct... You Are Doing Great...");
			} else {
				user_Score -= POINTLOSE;
				System.out.println("Oops... Wrong Answer, Don't Give Up ");
			}
			// ask user if wants to continue

			boolean isCorrectValue = true;

			do {

				if (pointer < questions.length - 1) {
					System.out.println("Would You Like Try With Next Question? (Y/N): ");
				} else {

					System.out.println(name.toUpperCase() + " Your Score Is: " + user_Score);
					System.out.println("Would You Like to Continue Practicing? (Y/N): ");
				}

				String user_Char = in.nextLine().toUpperCase();
				switch (user_Char) {
				case "Y":
					if (pointer >= questions.length - 1) {
						generateRandomQuestions();
						pointer = 0;
					} else {
						pointer++;
					}
					isCorrectValue = true;
					break;
				case "N":

					// Executing instructions before while close

					System.out.println(name.toUpperCase() + " Your Score is: " + user_Score);
					return;
				default:
					System.out.println("Oops... You Must Write a Valid Option");
					isCorrectValue = false;
				}
			} while (isCorrectValue == false);
		}

	}

	static void printQuestionAndAnswers(String question, String[] answers) {
		System.out.println("Question " + count_question +": " + question);
		if (count_question >= questions.length) {
			count_question = 1;
		} else {
			count_question++;
		}

		System.out.println("a. " + answers[0]);
		System.out.println("b. " + answers[1]);
		System.out.println("c. " + answers[2]);
		System.out.println("d. " + answers[3]);
	}

	static void generateRandomAnswers(String[] answers) {

		int first_random = random.nextInt(answer_01.length);
		int second_random = random.nextInt(answer_01.length);

		var aux = answers[first_random];

		answers[first_random] = answers[answers.length - (second_random + 1)];

		answers[answers.length - (second_random + 1)] = aux;
	}

	static void generateRandomQuestions() {
		for (int i = 0; i < 50; i++) {
			int first_random = random.nextInt(questions.length);
			int second_random = random.nextInt(questions.length);

			String aux_questions = questions[first_random];
			String[] aux_answers = answers[first_random];
			String aux_correct_answers = correctAnswer[first_random];

			questions[first_random] = questions[questions.length - (second_random + 1)];
			answers[first_random] = answers[answers.length - (second_random + 1)];
			correctAnswer[first_random] = correctAnswer[correctAnswer.length - (second_random + 1)];

			questions[questions.length - (second_random + 1)] = aux_questions;
			answers[answers.length - (second_random + 1)] = aux_answers;
			correctAnswer[correctAnswer.length - (second_random + 1)] = aux_correct_answers;

			generateRandomAnswers(answers[first_random]);
		}
	}

}