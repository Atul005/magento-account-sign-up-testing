package Utilities;

import com.github.javafaker.Faker;

/*
    This file is used to supply data for new user creation everytime.
 */

public class FakeNameGenerator {

    private final Faker faker = new Faker();

    public String fakeFirstName(){
         return faker.name().firstName();
    }

    public String lastFakeName(){
        return faker.name().lastName();
    }

    public String fakeEmailId(String first, String last){
        return first+last+"_testdummy@fakemail.com";
    }

    public String fakePass(String first, String last){
        return first.substring(0,2).toUpperCase()+last.substring(last.length()-4, last.length()-1)+"123@";
    }

    public String[] fakeProfile(){

        String f = fakeFirstName();
        String l = lastFakeName();
        String eID = fakeEmailId(f,l);
        String p = fakePass(f,l);

        return new String[]{f,l,eID,p,p};
    }

}
