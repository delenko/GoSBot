package com.github.delenko.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class Intimacy extends Command {
    public Intimacy(){
        this.help ="Guide for using intimacy/soldier rush";
        this.name = "intimacy";
        this.aliases = new String[]{"Intimacy","Soldier","soldier"};
        this.category = new Command.Category("game");
    }
    public void execute(CommandEvent e){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(e.getAuthor().getName());
        embed.setColor(e.getMember().getColor());
        embed.setThumbnail(e.getAuthor().getAvatarUrl());
        embed.addField("Intimacy/Soldier","This is a basic guide to what to use on intimacy/soldier rush",true);
        embed.addField("Soldiers","Dump your soldiers in campaign if it doesn't take two days to kill the boss." +
                "If not, dump rest in Vanquish for the tokens. The tokens are worth it later on.",true);
        embed.addField("Amulets","Spend these on your masquerade place to increase fortune.",true);
        embed.addField("Energy Orbs","Spend all these to increase your intimacy. Don't drop below 100 fortune or" +
                " there is a chance to receive nothing for it.",true);
        embed.addField("Tribute Seals","Dump these on the fortune guy(I pick this guy to keep energy orbs going." +
                "If not, pick the highest charm guy.",true);
        embed.addField("Silver/Gold earring","Spend all these on your consort that your best vizier is attached " +
                "to.",true);
        embed.addField("Agate/Emerald ring","Spend all these on your consort that your best vizier is attached to",true);

        e.reply(embed.build());
    }
}
