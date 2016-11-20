package handlers;


import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;

import commands.htmlCommand;
import commands.HelloCommand;
import commands.UptimeCommand;
import telegramBot.botConfig;

public class CommandsHandler extends TelegramLongPollingCommandBot{
	public CommandsHandler(){
		register(new HelloCommand());
		register(new UptimeCommand());
		register(new HtmlCommand());
	}

	public String getBotUsername() {
		return botConfig.USER;
	}

	@Override
	public void processNonCommandUpdate(Update arg0) {
	return;
	}

	@Override
	public String getBotToken() {
		return botConfig.TOKEN;
	}

}
