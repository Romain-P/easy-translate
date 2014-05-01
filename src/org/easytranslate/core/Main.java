package org.easytranslate.core;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private Data data;

    @Override
    public void onEnable() {
        this.data = new Data().initialize();
        super.getServer().getPluginManager().registerEvents(new ChatListener(data), this);
    }

    @Override
    public void onDisable() {
        this.data.getTranslations().clear();
    }
}
