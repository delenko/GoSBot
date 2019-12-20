package com.github.delenko.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class Talent extends Command {
    public Talent(){
        this.name = "talent";
        this.help = "this tells you what to use on talent rush.";
        this.category = new Command.Category("game");
        this.aliases = new String[]{"Talent"};
    }
    public void execute(CommandEvent e){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(e.getAuthor().getName());
        embed.setColor(e.getMember().getColor());
        embed.setThumbnail(e.getAuthor().getAvatarUrl());
        embed.addField("Talent","This is a basic guide to what to use on talent rush",true);
        embed.addField("Military Badges","The military you'll use on your military vizier of choice." +
                "This will be at the military 2 or 3 star military talent. ",true);
        embed.addField("Political/Prestige/Research badges","spend these on your arena vizier or whatever vizier you dump your " +
                "research/political/prestige attribute books on normally.",true);
        embed.addField("Almighty Badges","This you will want to use on 6 star first. If not a 6 star, 5 star will work.",true);
        embed.addField("Book xp","Book Xp you will use on your 5 or 6 star military talent. You will use it only on your " +
                "military star talents.",true);
        e.reply(embed.build());
    }
}
