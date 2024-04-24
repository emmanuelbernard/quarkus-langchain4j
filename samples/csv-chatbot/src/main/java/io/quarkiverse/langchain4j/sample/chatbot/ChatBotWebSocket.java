package io.quarkiverse.langchain4j.sample.chatbot;

import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;

@WebSocket(path = "/chatbot")
public class ChatBotWebSocket {

    private final MovieMuse bot;

    public ChatBotWebSocket(MovieMuse bot) {
        this.bot = bot;
    }

    @OnOpen
    public String onOpen() {
        return "Hello, I'm MovieMuse, how can I help you?";
    }

    @OnTextMessage
    public String onMessage(String message) {
        return bot.chat(message);
    }

}
