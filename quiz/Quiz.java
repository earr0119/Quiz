package quiz;

import java.util.Objects;
import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		final int pointsEarned = 5;
		final int pointsLose = 3;
		String name;
		int user_Score = 0;
		int option_User_Value = 0;
		String user_Option;

		String[] answer_01 = { "He", "Ne", "Ar", "Cl" };
		String[] answer_02 = { "H", "Fe", "Na", "Cl" };
		String[] answer_03 = { "Cs", "Na", "Fr", "Cr" };
		String[] answer_04 = { "Pt", "Au", "Cm", "Le" };
		String[] answer_05 = { "H", "He", "Er", "W" };
		String[] answer_06 = { "S", "Se", "B", "Ne" };
		String[] answer_07 = { "Ag", "Au", "As", "Os" };
		String[] answer_08 = { "He", "Ne", "Hf", "Hg" };
		String[] answer_09 = { "U", "Au", "Pb", "Fe" };
		String[] answer_10 = { "Ba", "Mn", "Ra", "Rf" };

		String[] questions = { "Which of the following is not a gaseous element?",
				"What is the chemical symbol for Sodium?", "Which of the following is not an alkaline element?",
				"What is the chemical symbol for Gold?", "What is the chemical symbol for Helium?",
				"What is the chemical symbol for Sulfur?", "What is the chemical symbol for Arsenic?",
				"What is the chemical symbol for Mercury?", "What is the chemical symbol for Uranium?",
				"What is the chemical symbol for Radium?" };

		String[] correctAnswer = { "Cl", "Na", "Cr", "Au", "He", "S", "As", "Hg", "U", "Ra" };

		String[][] answers = { answer_01, answer_02, answer_03, answer_04, answer_05, answer_06, answer_07, answer_08,
				answer_09, answer_10, };

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

			// Comprobar si nos esta molestando
			if (option_User_Value == -1) {
				continue;
			}

			// Verificar la respuesta del usuario
			if (Objects.equals(answers[pointer][option_User_Value], correctAnswer[pointer])) {
				user_Score += pointsEarned;
				System.out.println("Your Answer is correct... You Are Doing Great...");
			} else {
				user_Score -= pointsLose;
				System.out.println("Oops... Wrong Answer, Don't Give Up ");
			}
			// Preguntar al usuario si desea continuar

			boolean isCorrectValue = true;

			do {
				System.out.println("Would you like to continue? (Y/N): ");
				String user_char = in.nextLine().toUpperCase();
				switch (user_char) {
				case "Y":
					pointer++;
					isCorrectValue = true;
					break;
				case "N":
					// Ejecutar estas instrucciones nates que cierre el while

					System.out.println(name.toUpperCase() + " Your Score is: " + user_Score);
					return;
				default:
					System.out.println("Oops... You Must Write a Valid Option");
					isCorrectValue = false;
				}
			} while (isCorrectValue == false);
		}

	}
	

		static void printQuestionAndAnswers(String question, String[] answers){
			
			System.out.println("Question: " + question);
			

			System.out.println("a. " + answers[0]);
			System.out.println("b. " + answers[1]);
			System.out.println("c. " + answers[2]);
			System.out.println("d. " + answers[3]);
		}
}