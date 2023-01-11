package verschluesselung;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DB {
    private ArrayList<User> users = new ArrayList<>();


    public ArrayList<User> getUsers() {
        return users;
    }

    public User getSpecificUser(String username){
        for (User user : users
             ) {
            if (username.equals(user.getUsername()) ){
                return user;
            }
        }
        return null;
    }

    public void safe() throws IOException {
        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter("./data.json");
        gson.toJson(users, fileWriter);
        fileWriter.close();
    }

    public void load() throws FileNotFoundException {
        Gson gson = new Gson();
        Type listOfMyClassObject = new TypeToken<ArrayList<User>>() {}.getType();
        users = gson.fromJson(new FileReader("./data.json"), listOfMyClassObject);

    }

    public void addUser(User user){
        users.add(user);
    }

    public String newUserPassword(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an index: ");
        String  password = scanner.nextLine();

       return password;

    }



}

//{"Username": "username", "Password" : "password",
// "key": [
// {"password": "awd", "username": "name", "site": "https://google.com"},
// {"password": "awd2", "username": "name2", "site": "https://reddit.com"}
// ] }