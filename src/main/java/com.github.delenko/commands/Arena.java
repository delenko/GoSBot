package com.github.delenko.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class Arena extends Command {
    public Arena(){
        this.name = "arena";
        this.help = "arena macro that gives helpful info to spend on arena";
        this.aliases = new String[]{"Arena"};
        this.category = new Command.Category("game");
    }
    public void execute(CommandEvent e){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(e.getAuthor().getName());
        embed.setColor(e.getMember().getColor());
        embed.setThumbnail(e.getAuthor().getAvatarUrl());
        embed.addField("Arena","This is a basic guide to what to use on arena/union rush",true);
        embed.addField("Arena Attempts","You will basically do the normal 4 everyday pvp attempts",true);
        embed.addField("PVP Tokens","spend these after the above have been complete.",true);
        embed.addField("Challenge letters","You will use these when you get raided or when someone has enraged" +
                " and killed 20+ viziers.",true);
        embed.addField("Challenge Edicts","You will use your weaker viziers on less than 1.5M(or anyone you can handle)" +
                "Then you will use your stronger viziers on members that you will struggle with, such as DS members or whoever.",true);
        e.reply(embed.build());
    }
}
