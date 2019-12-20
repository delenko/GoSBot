package com.github.delenko.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class Empire extends Command {
    public Empire(){
        this.name = "empire";
        this.aliases = new String[]{"Empire"};
        this.help = "displays what you need to use for empire rush";
        this.category = new Command.Category("game");
    }
    public void execute(CommandEvent e){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(e.getAuthor().getName());
        embed.setColor(e.getMember().getColor());
        embed.setThumbnail(e.getAuthor().getAvatarUrl());
        embed.addField("Empire/Gold Rush","This is a basic guide to what to use on empire/gold",true);
        embed.addField("Level Heirs","You will use all your vitality orbs and raise heirs till your out.",true);
        embed.addField("Consort XP","Spend all Consort Xp",true);
        embed.addField("Pearl XP","Use Pearls next on your main viziers consort. If not him, your second and so on. ",true);
        embed.addField("Military attribute books","Grab Military attribute books and apply those to your vizier of choice." +
                "Military on your war viziers(mine's yavuz)",true);
        embed.addField("Random attribute books","Place these on your vizier of choice. I normally place them " +
                "on my main vizier I'm leveling due to chance of military success.",true);
        embed.addField("Political/Prestige/Research attribute books","Put those on whoever your wanting, too." +
                "You can either place them on the respective vizier who your wanting to help boost, your main for arena " +
                "or lastly, on your main arena viziers.",true);
        embed.addField("Mag5/Outstanding 4 badges","Spend these on your vizier that is your main of the mag5, " +
                "outstanding4, or get one of the new viziers.",true);
        embed.addField("Gold","Use gold on your vizier that your wanting to boost. It is what really increases " +
                "the viziers damage. You will also use clothes or fearless medals here ",true);
        e.reply(embed.build());
    }
}
