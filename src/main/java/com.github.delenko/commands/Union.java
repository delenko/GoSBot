package com.github.delenko.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class Union extends Command {
    public Union()
    {
        this.name= "union";
        this.aliases = new String[]{"Union","consort","Consort"};
        this.category = new Command.Category("game");
        this.help = "explains the Union/Consort rush";
    }
    public void execute(CommandEvent e){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(e.getAuthor().getName());
        embed.setColor(e.getMember().getColor());
        embed.setThumbnail(e.getAuthor().getAvatarUrl());
        embed.addField("Union/Consort Xp Rush","This is a basic guide to what to use on union/consort rush",true);
        embed.addField("Contributions","For your daily contributions, you will spend your 200 diamonds" +
                ", use the 400 contributions tokens, or lastly use the 1200 contribution tokens.",true);
        embed.addField("Voyages","Join voyages based on the chart we provide, or what your union provides.",true);
        embed.addField("Union boxes","If you have any from spending money, you would use them now.",true);
        embed.addField("Vigor Orbs","You will spend all you have saved up here.",true);
        e.reply(embed.build());
    }
}
