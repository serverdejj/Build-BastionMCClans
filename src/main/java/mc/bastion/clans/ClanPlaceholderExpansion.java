package mc.bastion.clans;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

/** Internal PlaceholderAPI expansion for the live clan data. */
public final class ClanPlaceholderExpansion extends PlaceholderExpansion {
    private final BastionMCClans plugin;
    public ClanPlaceholderExpansion(BastionMCClans plugin) { this.plugin = plugin; }

    @Override public @NotNull String getIdentifier() { return "bastionclans"; }
    @Override public @NotNull String getAuthor() { return "BASTION MC"; }
    @Override public @NotNull String getVersion() { return plugin.getPluginMeta().getVersion(); }
    @Override public boolean persist() { return true; }

    @Override public String onRequest(OfflinePlayer player, @NotNull String params) {
        if (player == null) return "";
        return switch (params.toLowerCase(java.util.Locale.ROOT)) {
            case "name" -> plugin.getClanName(player.getUniqueId());
            case "colored" -> plugin.hasClan(player.getUniqueId()) ? plugin.getClanColored(player.getUniqueId()) : "§8(§cSin Clan§8)";
            case "has_clan" -> Boolean.toString(plugin.hasClan(player.getUniqueId()));
            default -> null;
        };
    }
}
