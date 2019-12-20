package com.github.delenko;

import com.github.delenko.commands.*;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class Bot extends ListenerAdapter
{
    public static void main(String[] args) throws LoginException
    {
        Dotenv dotenv = Dotenv.configure().directory("./target/classes/").filename("configenv").load();
        CommandClientBuilder builder = new CommandClientBuilder();
        String token = dotenv.get("token");
        String client_id = dotenv.get("client_id");
        builder.setPrefix(">>");
        builder.setHelpWord("help");
        builder.addCommands(new XPBooks(),new AddRole(),new Roles(),new RemoveRole(),new CreateRole(),new RushSchedule(),
                new RemoveMessages(),new EditText(), new viewdiscorddate(), new Arena(),new Empire(),new Intimacy(),new Talent(),
                new Union(),new TopViziers());
        builder.setOwnerId(client_id );
        builder.setAlternativePrefix(">");
        CommandClient client = builder.build();
        JDA api= new JDABuilder(AccountType.BOT)
                .setToken(token).build();
        api.addEventListener(client);
    }
}
