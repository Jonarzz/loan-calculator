package io.github.jonarzz.loan.calculator.loan;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.jonarzz.loan.calculator.common.LocaleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

class UnavailabilityReasonSerializer extends JsonSerializer<UnavailabilityReason> {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    private MessageSource messageSource;

    UnavailabilityReasonSerializer() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void serialize(UnavailabilityReason unavailabilityReason, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        String reasonMessage = messageSource.getMessage(unavailabilityReason.getMessageCode(), null, LocaleUtil.get());
        jsonGenerator.writeString(reasonMessage);
    }

}
