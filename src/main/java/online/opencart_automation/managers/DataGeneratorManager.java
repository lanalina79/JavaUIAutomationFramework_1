package online.opencart_automation.managers;

import com.github.javafaker.Faker;

public class DataGeneratorManager {
    private static Faker faker = new Faker();

    public static String getRundomEmail (){
        return faker.internet().emailAddress();
    }

    public static String getRandomUsername(){
        return faker.name().username();
    }

    public static String getRandomPass(int min, int max){
        return faker.internet().password(min,max);
    }


}
