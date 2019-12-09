package ru.unn.agile.huffman.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import ru.unn.agile.huffman.model.node.*;

public class Huffman {
    private String encodedString;
    private String decodedString;

    public static final String CODE_0 = "0";
    public static final String CODE_1 = "1";

    private static Map<Character, Node> buildAlphabet() {
        Map<Character, Integer> numberOfAppearances = new HashMap<>();
        Map<Character, Node> alphabet = new HashMap<>();

        decodedString.chars().forEach(charElem -> {
            if (numberOfAppearances.containsKey((char) charElem)) {
                numberOfAppearances.put((char) charElem,
                        numberOfAppearances.get((char) charElem) + 1);
            } else {
                numberOfAppearances.put((char) charElem, 1);
            }
        });

        numberOfAppearances.entrySet().forEach(entry -> {
            alphabet.put(entry.getKey(), new Node(entry.getValue()));
        });

        return alphabet;
    }

    public static void encodString(final String str)
    {
        decodedString = str;
        if ("".equals(decodedString)) {
            encodedString = "";
            return;
        }

        Map<Character, Node> alphabet = buildAlphabet();

        PriorityQueue<Node> sortedAlphabet = new PriorityQueue<>();

        sortedAlphabet.addAll(alphabet.values().stream().collect(Collectors.toList()));

        while (sortedAlphabet.size() > 1) {
            Node first = sortedAlphabet.poll();
            Node second = sortedAlphabet.poll();
            sortedAlphabet.add(new InternalNode(first, second));
        }

        if (alphabet.size() == 1) {
            sortedAlphabet.poll().buildCode(CODE_0);
        } else {
            sortedAlphabet.poll().buildCode("");
        }

        encodedString = decodedString
                .chars()
                .mapToObj(ch -> alphabet.get((char) ch).getCode())
                .collect(Collectors.joining(""));
    }

    @Override
    public static int hashCode() {
        return Objects.hashCode(encodedString);
    }

    @Override
    public static boolean equals(final Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof Huffman)) {
            return false;
        }
        Huffman huffmanCode = (Huffman) object;
        return this.decodedString.equals(huffmanCode.getDecodedString());
    }

    public static String getEncodedString() {
        return this.encodedString;
    }

    public static String getDecodedString() {
        return this.decodedString;
    }

    @Override
    public static String toString() {
        return this.encodedString + " -> " + this.decodedString;
    }
}
