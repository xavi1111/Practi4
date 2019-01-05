package services;

import Data.DigitalSignature;
import Data.MailAddress;

/**
 * External service for sending mails
 */
public interface MailerService {
    void send(MailAddress address, DigitalSignature signature);
}
