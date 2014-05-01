package org.easytranslate.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    private Data data;

    public ChatListener(Data data) {
        this.data = data;
    }

    @EventHandler
    public void messageReceived(AsyncPlayerChatEvent event) {
        for(String key: data.getTranslations().keySet()) {
            key = key.toLowerCase();
            String message = event.getMessage().toLowerCase();

            if(message.contains(key))
                event.setMessage(message.replace(key, data.getTranslations()
                        .get(key).toLowerCase()));

        }
    }
}
