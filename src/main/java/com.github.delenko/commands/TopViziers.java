package com.github.delenko.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.File;

public class TopViziers extends Command {
    public TopViziers(){
        this.name = "topviziers";
        this.help = "Displays top viziers pic";
        this.aliases = new String[]{"TopViziers","Topviziers","topViziers","topvizier"};
        this.category = new Command.Category("game");
    }
    public void execute(CommandEvent e){
        e.reply("https://imgur.com/Ta4gNto");
    }
}
