package ua.home.test_bot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import ua.home.test_bot.TestTelegramBot;


@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;


    @Bean
    public TestTelegramBot TestTelegramBot() {
        DefaultBotOptions options = ApiContext
                .getInstance(DefaultBotOptions.class);

        TestTelegramBot testTelegramBot = new TestTelegramBot(options);
        testTelegramBot.setBotUserName(botUserName);
        testTelegramBot.setBotToken(botToken);
        testTelegramBot.setWebHookPath(webHookPath);

        return testTelegramBot;
    }
}
