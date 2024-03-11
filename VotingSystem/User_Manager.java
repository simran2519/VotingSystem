package Weekly_Assignment.VotingSystem;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User_Manager
{
    // Admin_Manager adminManager = new Admin_Manager();
    List<User> loginUsers ;
    Scanner sc = new Scanner(System.in);
    public User_Manager() {
        loginUsers= new ArrayList<>();
    }
    // for register user
    public void Register(Admin_Manager adminManager) {
        //this.adminManager = adminManager;
    }
    public void Login() throws LoginException, FileNotFoundException {
        System.out.println("enter user id :");
        String userid = sc.nextLine();
        System.out.println("enter user password :");
        String userPassword = sc.nextLine();
        boolean userFound = false;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("users.csv"))){
            String line;
            while((line = bufferedReader.readLine())!= null){
                String[] userData = line.split(",");
                if(userData.length == 5){
                    String csvUserId = userData[0];
                    String csvUserName = userData[1];
                    String csvUserAge = userData[2];
                    String csvUserPhoneNumber = userData[3];
                    String csvUserPassword = userData[4];
                    if(userid.equals(csvUserId) && userPassword.equals(csvUserPassword)){
                        //match found
                        userFound = true;
                        System.out.println("login successfully");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            // handle file reading error
            e.printStackTrace();
        }
        if(!userFound)
        {
            throw new LoginException("User not found or invalid information provides");

        }
    }

    public void LogOut() {

    }
    public void View_Profile() {

    }
    public void changePassword() {

    }

}
