package cz.czechitas.lesson3;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionExamples {

    @Test
    public void testSuccess() {
        String actual = whoJumpsOverWhom("fox", "dog");

        assertEquals("brown fox jumps over the lazy dog", actual);
        assertNotEquals("brown dog jumps over the lazy fox", actual);
        assertTrue(actual.contains("fox jumps"));
        assertFalse(actual.contains("dog jumps"));
        assertNotNull(actual);
    }

    @Test
    public void testFailure() {
        String actual = whoJumpsOverWhom("dog", "fox");
        assertEquals("brown fox jumps over the lazy dog", actual);
    }

    @Test
    public void testFailureWithMessage() {
        String expected = "brown fox jumps over the lazy dog";
        String actual = whoJumpsOverWhom("dog", "fox");
        assertEquals(expected, actual, "Test that fox jumps over dog and not the other way around");
    }

    static String whoJumpsOverWhom(String who, String overWhom) {
        return "brown " + who + " jumps over the lazy " + overWhom;
    }

}
