package BLL;

import models.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FunctionTest {

    Function func;
    double EXP = 0.0001;
    @BeforeEach
    void setUp() {
        double a = 0;
        double b = Math.PI/3;
        int h = 1000000;
        func = new Function(a,b, h, m->Math.cos(m));
    }

    @Test
    void calculateTest() {
        double expected = 0.866025;

        assertEquals(expected, func.calculate(), EXP);
    }
}