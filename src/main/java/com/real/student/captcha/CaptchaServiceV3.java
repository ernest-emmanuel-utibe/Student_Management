package com.real.student.captcha;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

import java.net.URI;

import com.real.student.exception.ReCaptchaInvalidException;
import com.real.student.exception.ReCaptchaUnavailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service("captchaServiceV3")
public class CaptchaServiceV3 extends AbstractCaptchaService{
    private final static Logger LOGGER = LoggerFactory.getLogger(CaptchaServiceV3.class);

    public static final String REGISTER_ACTION = "register";

    @Override
    public void processResponse(String response, final String action) throws ReCaptchaInvalidException {
        securityCheck(response);

        final URI verifyUri = URI.create(String.format(RECAPTCHA_URL_TEMPLATE, getReCaptchaSecret(), response, getClientIP()));
        try {
            final GoogleResponse googleResponse = restTemplate.getForObject(verifyUri, GoogleResponse.class);
            LOGGER.debug("Google's response: {} ", googleResponse.toString());

            if (!googleResponse.isSuccess() || !googleResponse.getAction().equals(action) || googleResponse.getScore() < captchaSettings.getThreshold()) {
                if (googleResponse.hasClientError()) {
                    reCaptchaAttemptService.reCaptchaFailed(getClientIP());
                }
                throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
            }
        } catch (RestClientException rce) {
            throw new ReCaptchaUnavailableException("Registration unavailable at this time.  Please try again later.", rce);
        }
        reCaptchaAttemptService.reCaptchaSucceeded(getClientIP());
    }
}
