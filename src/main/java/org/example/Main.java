package org.example;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.example.Listeners.Wish;


import javax.security.auth.login.LoginException;



public class Main  {
    public static JDA builder;
    public static void main(String[] args) throws LoginException{

        builder = JDABuilder.createLight(System.getenv("token"))
                .setActivity(Activity.listening(".help"))
                .addEventListeners(new Wish())
                .build();
    }
}