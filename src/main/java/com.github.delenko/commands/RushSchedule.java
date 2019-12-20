package com.github.delenko.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class RushSchedule extends Command {
    public RushSchedule(){
        this.name = "rushschedule";
        this.arguments = "[currentRush]";
        this.help = "With input from user, displays next rush";
        this.aliases = new String[]{"rushSchedule","RushSchedule","Rushschedule"};
        this.category = new Command.Category("game");
    }
    public void execute(CommandEvent e){

        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(e.getAuthor().getName());
        embed.setColor(e.getMember().getColor());
        embed.setThumbnail(e.getAuthor().getAvatarUrl());
        embed.addField("Schedule","1:Union XP\n2:Power/Gold\n3:Arena/Union Arena\n4:Intimacy/Soldier\n" +
                "5:Talent",true);
        e.reply(embed.build());
    }

}

