package ru.unn.agile.huffman.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanTest {
    @Test
    public void canCreateHuffmanWithEmptyString() {
        assertNotNull(Huffman.encodString(""));
    }

    @Test
    public void decodedStringIsEmptyIfHuffmanCreatedWithEmptyString() {
        assertTrue(Huffman.encodString("").getDecodedString().equals(""));
    }

    @Test
    public void encodedStringIsEmptyIfHuffmanCreatedWithEmptyString() {
        assertTrue(Huffman.encodString("").getEncodedString().equals(""));
    }

    @Test
    public void decodedStringIsCorrectWith1AlphabeticSymbolInput() {
        assertEquals(Huffman.encodString("a").getDecodedString(), "a");
    }

    @Test
    public void encodedStringIsCorrectWith1AlphabeticSymbolInput() {
        assertEquals(Huffman.encodString("a").getEncodedString(), "0");
    }

    @Test
    public void encodedStringIsCorrectWith2NumericSymbolsInput() {
        assertEquals(Huffman.encodString("ab").getDecodedString(), "ab");
    }

    @Test
    public void encodedStringIsCorrectWith2AlphabeticSymbolsInput() {
        assertEquals(Huffman.encodString("ab").getEncodedString(), "01");
    }

    @Test
    public void encodedStringIsCorrectWithRepeatedAlphabeticSymbolInput() {
        assertEquals(Huffman.encodString("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz").getEncodedString(), "000000000000000000000000000000");
    }

    @Test
    public void encodedStringIsCorrectWith10DifferentAlphabeticSymbolsInput() {
        assertEquals(Huffman.encodString("abhfklopmn").getEncodedString(), "0010111011110010100110111001111000");
    }

    @Test
    public void encodedStringIsCorrectWith10CoupleSymbolsInput() {
        assertEquals(Huffman.encodString("ababababab").getEncodedString(), "0101010101");
    }

    @Test
    public void encodedStringIsCorrectWith10TripletSymbolsInput() {
        assertEquals(Huffman.encodString("abcabcabcabcabc").getEncodedString(), "1001110011100111001110011");
    }

    @Test
    public void encodedStringIsCorrectWithAlphabeticSymbolsAndWhitespaceInput() {
        assertEquals(Huffman.encodString("hello world").getEncodedString(), "01011101010110000111111000110011");
    }

    @Test
    public void encodedStringIsCorrectWithTheSameUpperAndLowerSymbolsInput() {
        assertEquals(Huffman.encodString("Ww").getEncodedString(), "01");
    }

    @Test
    public void encodedStringIsCorrectWithNumericSymbolsInput() {
        assertEquals(Huffman.encodString("1029384756").getEncodedString(), "0011100011110111100001011111010100");
    }

    @Test
    public void encodedStringIsCorrectWithNumericAndAlphabeticSymbolsInput() {
        assertEquals(Huffman.encodString("111aaa 9e9e9dm  ke3mm 2333 004040404"), "111011101110000000000101110011111100111111001101"
                + "00011011011101111111011001001101110110011011011101100100010100010100010100010");
    }

    @Test
    public void encodedStringIsCorrectWithNumericAndAlphabeticAndSpecialSymbolsInput() {
        assertEquals(Huffman.encodString("!!! dddd ?? dd ? !! ddd333 99999UUUUUcwqdfjdkpw").getEncodedString(), "0100100101101010101011001110111110101011001111100"
                + "100101101010100110011001101100010010010010010000000000000001"
                + "1110011101111001101111011111101011111111100011101");
    }

    @Test
    public void canCompareTwoTheSameStringsWithTheSameAlphabets() {
        assertTrue(Huffman.encodString("170995o0unn").equals(Huffman.encodString("170995o0unn")));
    }

    @Test
    public void encodedStringsAreEqualForTwoDifferentStringsWithTheSimilarAlphabets() {
        assertTrue(Huffman.encodString("abbb").getEncodedString().equals(Huffman.encodString("baaa").getEncodedString()));
    }

    @Test
    public void equalsIsFalseForTwoDifferentStringsWithTheSameAlphabets() {
        assertFalse(Huffman.encodString("abbb").equals(Huffman.encodString("baaa")));
    }

    @Test
    public void decodedStringsAreDifferentForTwoDifferentStringsWithDifferentAlphabets() {
        assertFalse(Huffman.encodString("abbb").getEncodedString().equals(Huffman.encodString("cabbb").getEncodedString()));
    }

    @Test
    public void canCompareWithNullObject() {
        assertFalse(Huffman.encodString("100").equals(null));
    }

    @Test
    public void canCompareWithAnotherObject() {;
        Integer num = Integer.valueOf(100);
        assertFalse(Huffman.encodString("100").equals(num));
    }
}
