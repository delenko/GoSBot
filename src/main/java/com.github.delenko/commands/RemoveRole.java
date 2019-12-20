package com.github.delenko.commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import java.util.ArrayList;
import java.util.List;
import static net.dv8tion.jda.api.Permission.MANAGE_ROLES;


public class RemoveRole extends Command {
    public RemoveRole(){
        this.name="removerole";
        this.aliases= new String[]{"RemoveRole","removeRole","Removerole"};
        this.help = "This will remove a role!\n";
        this.arguments = "[userID],[roleID]";
        this.category = new Command.Category("admin");
        this.userPermissions = new Permission[]{MANAGE_ROLES};
    }
    @Override
    public void execute(CommandEvent e) {
        String[] roles = e.getArgs().split(" ");
        List<Role> guildRoles = e.getGuild().getRoles();
        List<Long> roleID = new ArrayList<Long>();
        String roleNotThere = "";
        for (Role role : guildRoles) {
            String roleIDs = role.toString().replaceAll("\\D", "");
            Long rIDs = Long.parseLong(roleIDs);
            roleID.add(rIDs);

            if (roles.length != 2) {
                e.reply("Your must enter 3 commands! prefix >>command userID roleID");
                return;
            }else if (roleIDs.equalsIgnoreCase(roles[1])) {
                Role guildRole = e.getGuild().getRoleById(roles[1]);
                Member user = e.getGuild().getMemberCache().getElementById(roles[0]);
                e.getGuild().removeRoleFromMember(user, guildRole).queue();
                e.reply("User has had the role "+roles[1]+" removed from them!");
            }
        }

    }
}
