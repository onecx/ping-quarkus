package org.tkit.quarkus.hello.domain.daos;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tkit.quarkus.test.WithDBData;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@WithDBData(value = "data/data.xml", deleteBeforeInsert = true, deleteAfterTest = true, rinseAndRepeat = true)
class ThemeDAO2Test {

    @Inject
    ThemeDAO dao;

    @Test
    void methodExceptionTests() {
        Assertions.assertNull(dao.findById("1"));
        Assertions.assertNotNull(dao.findById("11-111"));

        Assertions.assertNull(dao.findById("1"));
    }

}
