package com.github.delenko.commands;

        import com.jagrosh.jdautilities.command.Command;
        import com.jagrosh.jdautilities.command.CommandEvent;
        import net.dv8tion.jda.api.EmbedBuilder;

public class EditText extends Command {
    public EditText(){
        this.name = "edittext";
        this.aliases = new String[]{"EditText","markdown","Edittext"};
        this.category = new Command.Category("game");
        this.help = "Displays how to do mark up text";
    }
    public void execute(CommandEvent e){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(e.getAuthor().getName());
        embed.setColor(e.getMember().getColor());
        embed.setThumbnail(e.getAuthor().getAvatarUrl());
        embed.addField("MarkDown Text","To mark down text you can do the following:",true);
        embed.addField("Italics","" +
                "Italics\t`*italics*` or `_italics_`\tUnderline italics\t`__*underline italics*__`",false);
        embed.addField("Bold","Bold\t`**bold**`\tUnderline bold\t`__**underline bold**__`",false);
        embed.addField("Bold Italics","Bold Italics\t`***bold italics***`\tunderline bold italics\t`__***underline bold italics***__`",false);
        embed.addField("Underline and Strikethrough","Underline\t`__underline__`\tStrikethrough\t `~~Strikethrough~~`",false);
        embed.addField("Code Blocks","` ```        ``` `",false);
        embed.addField("Block Quotes","`> followed by text` or `>>>followed by text`",false);
        embed.addField("Spoiler Tags","`||      ||`",false);
        e.reply(embed.build());
    }

}
