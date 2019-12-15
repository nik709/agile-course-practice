package ru.unn.agile.huffman.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanTest {
    @Test
    public void canCreateHuffmanWithEmptyString() {
        Huffman.encodString("");
        assertNotNull(Huffman.getDecodedString());
    }

    @Test
    public void decodedStringIsEmptyIfHuffmanCreatedWithEmptyString() {
        Huffman.encodString("");
        assertTrue(Huffman.getDecodedString().equals(""));
    }

    @Test
    public void encodedStringIsEmptyIfHuffmanCreatedWithEmptyString() {
        Huffman.encodString("");
        assertTrue(Huffman.getEncodedString().equals(""));
    }

    @Test
    public void decodedStringIsCorrectWith1AlphabeticSymbolInput() {
        Huffman.encodString("a");
        assertEquals(Huffman.getDecodedString(), "a");
    }

    @Test
    public void encodedStringIsCorrectWith1AlphabeticSymbolInput() {
        Huffman.encodString("a");
        assertEquals(Huffman.getEncodedString(), "0");
    }

    @Test
    public void encodedStringIsCorrectWith2NumericSymbolsInput() {
        Huffman.encodString("ab");
        assertEquals(Huffman.getDecodedString(), "ab");
    }

    @Test
    public void encodedStringIsCorrectWith2AlphabeticSymbolsInput() {
        Huffman.encodString("ab");
        assertEquals(Huffman.getEncodedString(), "01");
    }

    @Test
    public void encodedStringIsCorrectWithRepeatedAlphabeticSymbolInput() {
        Huffman.encodString("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        assertEquals(Huffman.getEncodedString(), "000000000000000000000000000000");
    }

    @Test
    public void encodedStringIsCorrectWith10DifferentAlphabeticSymbolsInput() {
        Huffman.encodString("abhfklopmn");
        assertEquals(Huffman.getEncodedString(), "0010111011110010100110111001111000");
    }

    @Test
    public void encodedStringIsCorrectWith10CoupleSymbolsInput() {
        Huffman.encodString("ababababab");
        assertEquals(Huffman.getEncodedString(), "0101010101");
    }

    @Test
    public void encodedStringIsCorrectWith10TripletSymbolsInput() {
        Huffman.encodString("abcabcabcabcabc");
        assertEquals(Huffman.getEncodedString(), "1001110011100111001110011");
    }

    @Test
    public void encodedStringIsCorrectWithAlphabeticSymbolsAndWhitespaceInput() {
        Huffman.encodString("hello world");
        assertEquals(Huffman.getEncodedString(), "01011101010110000111111000110011");
    }

    @Test
    public void encodedStringIsCorrectWithTheSameUpperAndLowerSymbolsInput() {
        Huffman.encodString("Ww");
        assertEquals(Huffman.getEncodedString(), "01");
    }

    @Test
    public void encodedStringIsCorrectWithNumericSymbolsInput() {
        Huffman.encodString("1029384756");
        assertEquals(Huffman.getEncodedString(), "0011100011110111100001011111010100");
    }

    @Test
    public void encodedStringIsCorrectWithNumericAndAlphabeticSymbolsInput() {
        Huffman.encodString("111aaa 9e9e9dm  ke3mm 2333 004040404");
        assertEquals(Huffman.getEncodedString(), "111011101110000000000101110011111100111111001101"
                + "00011011011101111111011001001101110110011011011101100100010100010100010100010");
    }

    @Test
    public void encodedStringIsCorrectWithNumericAndAlphabeticAndSpecialSymbolsInput() {
        Huffman.encodString("!!! dddd ?? dd ? !! ddd333 99999UUUUUcwqdfjdkpw");
        assertEquals(Huffman.getEncodedString(), "0100100101101010101011001110111110101011001111100"
                + "100101101010100110011001101100010010010010010000000000000001"
                + "1110011101111001101111011111101011111111100011101");
    }

    @Test
    public void canCompareTwoTheSameStringsWithTheSameAlphabets() {
        Huffman.encodString("170995o0unn");
        String str1 = Huffman.getEncodedString();
        Huffman.encodString("170995o0unn");
        String str2 = Huffman.getEncodedString(); 
        assertTrue(str1.equals(str2));
    }

    @Test
    public void encodedStringsAreEqualForTwoDifferentStringsWithTheSimilarAlphabets() {
        Huffman.encodString("abbb");
        String str1 = Huffman.getEncodedString();
        Huffman.encodString("baaa");
        String str2 = Huffman.getEncodedString();
        assertTrue(str1.equals(str2));
    }

    @Test
    public void equalsIsFalseForTwoDifferentStringsWithTheSameAlphabets() {
        Huffman.encodString("abbb");
        String str1 = Huffman.getEncodedString();
        Huffman.encodString("baaa");
        String str2 = Huffman.getEncodedString();
        assertFalse(str1.equals(str2));
    }

    @Test
    public void decodedStringsAreDifferentForTwoDifferentStringsWithDifferentAlphabets() {
        Huffman.encodString("abbb");
        String str1 = Huffman.getEncodedString();
        Huffman.encodString("cabbb");
        String str2 = Huffman.getEncodedString();
        assertFalse(str1.equals(str2));
    }

    @Test
    public void canCompareWithNullObject() {
        Huffman.encodString("100");
        assertFalse(Huffman.getEncodedString().equals(null));
    }

    @Test
    public void canCompareWithAnotherObject() {;
        Integer num = Integer.valueOf(100);
        Huffman.encodString("100");
        assertFalse(Huffman.getEncodedString().equals(num));
    }
}
