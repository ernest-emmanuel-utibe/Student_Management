package com.real.student.captcha;

import com.real.student.exception.ReCaptchaInvalidException;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

public interface ICaptchaService {
    default void processResponse(final String response) throws ReCaptchaInvalidException {}

    default void processResponse(final String response, String action) throws ReCaptchaInvalidException {}

    String getReCaptchaSite();

    String getReCaptchaSecret();
}
