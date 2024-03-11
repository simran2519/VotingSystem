package Weekly_Assignment.VotingSystem;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Candidate_Manage
{
    Scanner sc = new Scanner(System.in);
    public void LoginCandidate() throws LoginException, FileNotFoundException {
        System.out.println("enter candidate id :");
        String candidate_id = sc.nextLine();
        System.out.println("enter password :");
        String candidate_password= sc.nextLine();
        System.out.println("enter partysymbol");
        String candidate_partySymbol = sc.nextLine();
        boolean candidateFound = false;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("candidate.csv"))){
            String line;
            while((line = bufferedReader.readLine())!= null){
                String[] candidateData = line.split(",");
                if(candidateData.length == 5){
                    String csvCandidate_Id = candidateData[0];
                    String csvCandidate_Name = candidateData[1];
                    String csvCandidate_partySymbol = candidateData[2];
                    String csvCandidate_age = candidateData[3];
                    String csvCandidate_Password = candidateData[4];
                    if(csvCandidate_Id.equals(candidate_id) && candidate_password.equals(csvCandidate_Password) && candidate_partySymbol.equals(csvCandidate_partySymbol))
                    {
                        //match found
                        candidateFound= true;
                        System.out.println("login successfully");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            // handle file reading error
            e.printStackTrace();
        }
        if(!candidateFound)
        {
            throw new LoginException("User not found or invalid information provides");

        }
    }
    public void deleteCandidate()
    {

    }
    public void viewCandidate()
    {

    }
    public void editCandidate()
    {

    }
}