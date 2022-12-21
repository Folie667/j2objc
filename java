import java.util.ArrayList;
import java.util.Scanner;

public class RouletteProbability {  
  // Liste des chiffres qui ont déjà été tirés
  private ArrayList<Integer> previousNumbers;

  public RouletteProbability() {
    previousNumbers = new ArrayList<Integer>();
  }

  // Ajouter un nouveau chiffre à la liste des chiffres déjà tirés
  public void addNumber(int number) {
    previousNumbers.add(number);
  }

  // Calculer la probabilité de gagner en pariant sur un chiffre précis
  public double probabilityOfWinningOnNumber(int number) {
    // S'il n'y a aucun chiffre précédemment tiré, la probabilité de gagner
    // en pariant sur un chiffre précis est de 1/37 (la roulette a 37 chiffres)
    if (previousNumbers.size() == 0) {
      return 1.0 / 37.0;
    }

    // Compter le nombre de fois où le chiffre a été tiré précédemment
    int count = 0;
    for (int previousNumber : previousNumbers) {
      if (previousNumber == number) {
        count++;
      } }
    return count;
    }

    // Calculer la probabilité en utilisant la formule suivante :
    // probabilité = (1 - (nombre de fois où le chiffre a été
  // Retourner une liste de chiffres sur lesquels vous pouvez parier
  public ArrayList<Integer> getNumbersToBetOn() {
    ArrayList<Integer> numbersToBetOn = new ArrayList<Integer>();
    
    // Pour chaque chiffre de la roulette (de 0 à 36)
    for (int i = 0; i <= 36; i++) {
      // Si le chiffre n'a pas encore été tiré, ajouter à la liste des chiffres sur lesquels vous pouvez parier
      if (!previousNumbers.contains(i)) {
        numbersToBetOn.add(i);
      }
    }
    
    return numbersToBetOn;
  }
  
  public static void main(String[] args) {
    RouletteProbability probabilityCalculator = new RouletteProbability();
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
      System.out.println("Entrez le prochain chiffre tiré à la roulette (ou tapez 'q' pour quitter) :");
      String input = scanner.nextLine();
      
      // Si l'utilisateur tape 'q', quitter le programme
      if (input.equalsIgnoreCase("q")) {
        break;
      }
      
      // Si l'utilisateur a saisi un chiffre valide, l'ajouter à la liste des chiffres déjà tirés
      try {
        int number = Integer.parseInt(input);
        if (number >= 0 && number <= 36) {
          probabilityCalculator.addNumber(number);
        }
      } catch (NumberFormatException e) {
        // Si l'utilisateur n'a pas saisi un chiffre valide, ignorer l'entrée et continuer la boucle
        continue;
      }
      
      // Afficher la liste des chiffres sur lesquels vous pouvez parier
      ArrayList<Integer> numbersToBetOn = probabilityCalculator.getNumbersToBetOn();
      System.out.println("Chiffres sur lesquels vous pouvez parier : " + numbersToBetOn);
    }
    
    scanner.close();
  }
    

  
  public static void main(String args) {
    RouletteProbability probabilityCalculator = new RouletteProbability();
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
      System.out.println("Entrez le prochain chiffre tiré à la roulette (ou tapez 'q' pour quitter) :");
      String input = scanner.nextLine();
      
      // Si l'utilisateur tape 'q', quitter le programme
      if (input.equalsIgnoreCase("q")) {
        break;
      }
      
      // Si l'utilisateur a saisi un chiffre valide, l'ajouter à la liste des chiffres déjà tirés
      try {
        int number = Integer.parseInt(input);
        if (number >= 0 && number <= 36) {
          probabilityCalculator.addNumber(number);
        }
      } catch (NumberFormatException e) {
        // Si l'utilisateur n'a pas saisi un chiffre valide, ignorer l'entrée et continuer la boucle
        continue;
      }
      
      // Afficher la liste des chiffres sur lesquels vous pouvez parier
      ArrayList<Integer> numbersToBetOn = probabilityCalculator.getNumbersToBetOn();
      System.out.println("Chiffres sur lesquels vous pouvez parier : " + numbersToBetOn);
    }
    
    scanner.close();
  }

  public ArrayList<Integer> getPreviousNumbers() {
    return previousNumbers;
  }

  public void setPreviousNumbers(ArrayList<Integer> previousNumbers) {
    this.previousNumbers = previousNumbers;
  }
}
