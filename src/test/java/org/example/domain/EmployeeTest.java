package org.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.Table;

class EmployeeTest {

    private static final String TABLE_NAME = "employee";

    @Test
    void testEntity() {
        Entity entity = Employee.class.getAnnotation(Entity.class);
        Assertions.assertNotNull(entity);
    }

    @Test
    void testTable() {
        Table table = Employee.class.getAnnotation(Table.class);
        Assertions.assertNotNull(table);
        Assertions.assertEquals(TABLE_NAME, table.name());
    }
}