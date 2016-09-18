package ru.larev.orderapi.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.stereotype.Component;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Component
public class HibernateObjectMapper extends ObjectMapper {

    public HibernateObjectMapper() {
        registerModule(new Hibernate5Module());
    }
}