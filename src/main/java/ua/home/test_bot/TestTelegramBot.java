package ua.home.test_bot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.home.test_bot.botapi.TelegramFacade;

public class TestTelegramBot extends TelegramWebhookBot {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    private TelegramFacade telegramFacade;

    public TestTelegramBot(DefaultBotOptions options, TelegramFacade telegramFacade) {
        super(options);
        this.telegramFacade = telegramFacade;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
    @Override
    public String getBotUsername() {
        return botUserName;
    }
    @Override
    public String getBotPath() {
        return webHookPath;
    }




    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        SendMessage replyMessageToUser = telegramFacade.handleUpdate(update);
        return null;
    }


    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }
    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }
    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

}
