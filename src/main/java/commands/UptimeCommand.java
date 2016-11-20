package commands;

import java.util.Calendar;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import telegramBot.main;


public class UptimeCommand extends BotCommand {
	public UptimeCommand() {
		super("uptime", "작동중인 시간을 보여줍니다");
	}

	@Override
	public void execute(AbsSender abssender, User user, Chat chat, String[] strings) {
		SendMessage message = new SendMessage();
		message.setChatId(chat.getId().toString());
		message.enableHtml(true);
		Calendar c = Calendar.getInstance();
		Calendar s = (Calendar) main.date;

		message.setText("처음 실행된 시간 :\n<b>" + toTime(main.date) + "</b>\n================\n" + toDetatime(c, s));

		try {
			abssender.sendMessage(message);
			
		} catch (TelegramApiException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}


	}

	public static String toDetatime(Calendar a1, Calendar a2) {
		int seconds1;
		seconds1 = a1.get(Calendar.SECOND);
		seconds1 += a1.get(Calendar.MINUTE) * 60;
		seconds1 += a1.get(Calendar.HOUR_OF_DAY) * 60 * 60;
		seconds1 += a1.get(Calendar.DAY_OF_MONTH) * 60 * 60 * a1.getActualMaximum(Calendar.DATE);
		int seconds2;
		seconds2 = a2.get(Calendar.SECOND);
		seconds2 += a2.get(Calendar.MINUTE) * 60;
		seconds2 += a2.get(Calendar.HOUR_OF_DAY) * 60 * 60;
		seconds2 += a2.get(Calendar.DAY_OF_MONTH) * 60 * 60 * a2.getActualMaximum(Calendar.DATE);
		int coun = (seconds1 - seconds2);
		StringBuilder str = new StringBuilder();
		if ((coun / (60 * 60)) > 0) {
			str.append((coun / (60 * 60)) + "시간 ");
			coun -= ((coun / (60 * 60)) * (60 * 60));
		}
		if ((coun / 60) > 0) {
			str.append((coun / 60) + "분 ");
			coun -= ((coun / 60) * 60);
		}

		str.append((coun) + "초 ");
		coun -= (coun);

		str.append("동안 실행 중입니다!");
		return str.toString();

	}

	public static String toTime(Calendar cal) {
		String s = String.format("%02d-%02d-%02d %02d시%02d분%02d초", cal.get(Calendar.YEAR),
				(cal.get(Calendar.MONTH) + 1), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY),
				cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return s;
	}
}
