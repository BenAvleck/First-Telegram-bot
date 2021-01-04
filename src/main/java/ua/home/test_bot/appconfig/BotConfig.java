package ua.home.test_bot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import ua.home.test_bot.TestTelegramBot;
import ua.home.test_bot.botapi.TelegramFacade;


@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;


    @Bean
    public TestTelegramBot testTelegramBot(TelegramFacade telegramFacade) {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);

        TestTelegramBot testTelegramBot = new TestTelegramBot(options,telegramFacade);
        testTelegramBot.setBotUserName(botUserName);
        testTelegramBot.setBotToken(botToken);
        testTelegramBot.setWebHookPath(webHookPath);

        return testTelegramBot;
    }


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
