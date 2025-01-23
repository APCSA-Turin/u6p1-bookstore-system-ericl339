package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    //requires 1 private attribute String currentId. You must initialize it to 99
    private static String currentId = "99";

    //requires one empty constructor
    public IdGenerate() {}

    // returns the id
    public static String getCurrentId(){
        return currentId;
    }

    // resets the id to 99
    public static void reset(){
        currentId = "99";
    } //must reset the currentId back to 99


    public static void generateID(){
        // converts the string id to a int
        int newId = Integer.valueOf(currentId) + 1; //i learned this from https://algocademy.com/link/?problem=static-arrays&lang=java&solution=1
        // converts the int id to a string id
        currentId = "" + newId;
    } //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
}