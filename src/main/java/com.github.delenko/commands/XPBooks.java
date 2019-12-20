package com.github.delenko.commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class XPBooks extends Command {

    public XPBooks(){
        this.aliases = new String[]{"Attributes","attribute","Attribute"};
        this.help = "Gives your total of attribute books. You will need the prefix, command, how many books for 100," +
                "500,1000,5000, and Almighty books\n";
        this.name = "attributes";
        this.arguments = "[100 attribute books][500 attribute books][1000 attribute books][5000 attribute books]" +
                "[almighty book]\n";
        this.category = new Command.Category("game");

    }
    @Override
    protected void execute(CommandEvent event){

        String[] books = event.getArgs().split(" ");
        if(event.getArgs().equalsIgnoreCase(" ")){
            event.replySuccess("Did you mean to type in numbers and letters?");
            event.replySuccess("You must enter the prefix >> and attributes followed by number of attribute books of 100,500,1000," +
                    "5000, and almighty books. If you do not have any, place a 0");
        }else if(books.length!= 5){
            event.replySuccess("Must enter 5 sets of numbers!");
        }else{
            long smallBooks = Long.parseLong(books[0]) * 100;
            long mediumBooks = Long.parseLong(books[1]) * 500;
            long largeBooks = Long.parseLong(books[2])*1000;
            long xlBooks = Long.parseLong(books[3]) * 5000;
            long almighty = Long.parseLong(books[4])*40000;
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(event.getMember().getColor());
            embed.setThumbnail(event.getAuthor().getAvatarUrl());
            embed.setAuthor(event.getAuthor().getName());
            embed.setDescription("User's empire power gain from books!");
            embed.addField("User:", event.getAuthor().getName(), true);
            embed.addField("Empire Power",Long.toString(smallBooks+mediumBooks+largeBooks+xlBooks+almighty),true);
            event.reply(embed.build());
        }
    }
}