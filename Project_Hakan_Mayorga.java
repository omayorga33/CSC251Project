import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Project_Hakan_Mayorga
{
   public static void main(String[] args) throws IOException
   {
      Locale.setDefault(Locale.US);

      ArrayList<Policy> policies = new ArrayList<Policy>();

      File file = new File("PolicyInformation.txt");
      Scanner inputFile = new Scanner(file);
      inputFile.useLocale(Locale.US);

      while(inputFile.hasNext())
      {
         int policyNumber = inputFile.nextInt();
         inputFile.nextLine(); // consume endline

         String providerName = inputFile.nextLine();
         String firstName = inputFile.nextLine();
         String lastName = inputFile.nextLine();

         int age = inputFile.nextInt();
         inputFile.nextLine(); // consume endline

         String smokingStatus = inputFile.nextLine();

         double height = inputFile.nextDouble();
         double weight = inputFile.nextDouble();

         if(inputFile.hasNextLine())
            inputFile.nextLine(); // move to next line after weight

         Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                    age, smokingStatus, height, weight);

         policies.add(policy);
      }

      inputFile.close();

      int smokerCount = 0;
      int nonSmokerCount = 0;

      for(int i = 0; i < policies.size(); i++)
      {
         Policy p = policies.get(i);

         displayPolicy(p);
         System.out.println();

         if(p.getSmokingStatus().equalsIgnoreCase("smoker"))
            smokerCount++;
         else
            nonSmokerCount++;
      }

      System.out.println("The number of policies with a smoker is: " + smokerCount);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
   }

   public static void displayPolicy(Policy p)
   {
      System.out.println("Policy Number: " + p.getPolicyNumber());
      System.out.println("Provider Name: " + p.getProviderName());
      System.out.println("Policyholder's First Name: " + p.getFirstName());
      System.out.println("Policyholder's Last Name: " + p.getLastName());
      System.out.println("Policyholder's Age: " + p.getAge());
      System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
      System.out.printf("Policyholder's Height: %.1f inches\n", p.getHeight());
      System.out.printf("Policyholder's Weight: %.1f pounds\n", p.getWeight());
      System.out.printf("Policyholder's BMI: %.2f\n", p.calculateBMI());
      System.out.printf("Policy Price: $%.2f\n", p.calculatePolicyPrice());
   }
}

