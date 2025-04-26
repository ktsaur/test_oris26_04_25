package ru.kpfu.test_oris26_04.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.kpfu.test_oris26_04.model.User;
import ru.kpfu.test_oris26_04.repository.UserRepository;
import ru.kpfu.test_oris26_04.services.CurrencyService;
import ru.kpfu.test_oris26_04.services.EmailService;

import java.util.List;

@Component
public class DailyEmailScheduler {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    public void sendDailyExchangeRateEmails() {
        String exchangeRate;
        try {
            exchangeRate = currencyService.getUsdToRubExchangeRate();
        } catch (Exception e) {
            exchangeRate = "Курс валют недоступен";
        }

        List<User> users = userRepository.findAll();
        for (User user : users) {
            emailService.sendEMail(user.getEmail(), exchangeRate);
        }
    }
}