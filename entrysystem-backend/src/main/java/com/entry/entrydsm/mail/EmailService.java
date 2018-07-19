package com.entry.entrydsm.mail;

import javax.mail.SendFailedException;

public interface EmailService {
    void sendMessage(String to, String title, String body) throws SendFailedException;
}
