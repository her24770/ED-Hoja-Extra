/**
 * clase HuffmanCompressor para comprimir y descomprimir texto usando el algoritmo de Huffman
 * codigo basado de https://www.techiedelight.com/huffman-coding/.
 */
import java.util.*;

public class HuffmanCompressor {
    private static HuffmanTree tree;
    
    public static Stack<String> compress(Stack<Character> inputStack) {
        // 1. Calcular frecuencias
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputStack) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // 2. Construir árbol
        tree = new HuffmanTree(frequencyMap);
        
        // 3. Codificar contenido
        Stack<String> compressedStack = new Stack<>();
        for (char c : inputStack) {
            compressedStack.push(tree.getCode(c));
        }
        
        return compressedStack;
    }
    
    public static Stack<Character> decompress(Stack<String> compressedStack) {
        Stack<Character> decompressedStack = new Stack<>();
        
        for (String code : compressedStack) {
            decompressedStack.push(tree.getCharacter(code));
        }
        
        return decompressedStack;
    }
}