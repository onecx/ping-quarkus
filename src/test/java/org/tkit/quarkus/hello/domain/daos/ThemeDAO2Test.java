package org.tkit.quarkus.hello.domain.daos;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tkit.quarkus.test.WithDBData;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@WithDBData(value = "data/data.xml", deleteBeforeInsert = true, deleteAfterTest = true, rinseAndRepeat = true)
public class ThemeDAO2Test {

    @Inject
    ThemeDAO dao;

    @Test
    void methodExceptionTests() {
        Assertions.assertNull(dao.findById("1"));
        Assertions.assertNotNull(dao.findById("11-111"));

        Assertions.assertNull(dao.findById("1"));
        //
        //        } finally {
        //            ApplicationContext.close();
        //        }
        //
        //        methodExceptionTests(() -> dao.findById(null),
        //                ThemeDAO.ErrorKeys.FIND_ENTITY_BY_ID_FAILED);
        //        methodExceptionTests(() -> dao.findThemeByName(null),
        //                ThemeDAO.ErrorKeys.ERROR_FIND_THEME_BY_NAME);
        //        methodExceptionTests(() -> dao.findThemeByNames(null),
        //                ThemeDAO.ErrorKeys.ERROR_FIND_THEME_BY_NAMES);
        //        methodExceptionTests(() -> dao.findAll(0, 2),
        //                ThemeDAO.ErrorKeys.ERROR_FIND_ALL_THEME_PAGE);
    }

}
