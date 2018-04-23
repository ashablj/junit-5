package org.ashabl.junit5.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @see MockitoExtension
 * @since 5.0
 */
@ExtendWith(MockitoExtension.class)
class MockitoExtensionTest {

    @Mock
    private NumberGenerator numberGenerator;

    @BeforeEach
    void initialize(@Mock MyType myType, TestInfo testInfo) {
        when(myType.getName()).thenReturn(testInfo.getDisplayName());
        when(numberGenerator.next()).thenReturn(42);
    }

    @Test
    void firstTestWithInjectedMock(@Mock MyType myType) {
        assertEquals("firstTestWithInjectedMock(MyType)", myType.getName());
        assertEquals(42, numberGenerator.next());
    }

    @Test
    void secondTestWithInjectedMock(@Mock MyType myType) {
        assertEquals("secondTestWithInjectedMock(MyType)", myType.getName());
        assertEquals(42, numberGenerator.next());
    }

    @Test
    void multipleImplicitlyNamedInjectedMocksOfSameTypeAreNotTheSameInstance(@Mock MyType myType1,
                                                                             @Mock MyType myType2) {

        assertNotNull(myType1);
        assertNotNull(myType2);

        assertNotSame(myType1, myType2, "Make sure the project was compiled with -parameters");

        assertTrue(myType1.toString().contains("myType1"));
        assertTrue(myType2.toString().contains("myType2"));
    }

    @Test
    void multipleExplicitlyNamedInjectedMocksOfSameTypeAreNotTheSameInstanceTest(@Mock(name = "one") MyType myType1,
                                                                                 @Mock(name = "two") MyType myType2) {

        assertNotNull(myType1);
        assertNotNull(myType2);
        assertNotSame(myType1, myType2);

        assertTrue(myType1.toString().contains("one"));
        assertTrue(myType2.toString().contains("two"));
    }
}