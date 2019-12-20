package com.github.delenko.commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.requests.restaction.RoleAction;
import static net.dv8tion.jda.api.Permission.MANAGE_ROLES;


public class CreateRole extends Command {
    public CreateRole(){
        this.name = "createrole";
        this.aliases = new String[]{"CreateRole","createRole","Createrole"};
        this.help = "This creates a role.";
        this.category = new Command.Category("admin");
        this.userPermissions = new Permission[]{MANAGE_ROLES};
        this.arguments ="[color]";
    }
    @Override
    public void execute(CommandEvent e){
        String[] roleQualities =  e.getArgs().split("");
        Integer colors = Integer.parseInt(roleQualities[0]);
        RoleAction roleCreation = e.getGuild().createRole().setColor(colors).setName(roleQualities[1])
                .setMentionable(false);
    }
}
