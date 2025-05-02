/**
 * HuffmanTree.java clase para construir un árbol de Huffman y generar códigos de Huffman.
 * COdigo basado de https://www.techiedelight.com/huffman-coding/
 */
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanTree {
    private HuffmanNode root;
    private HashMap<Character, String> codeMap;
    private HashMap<String, Character> reverseCodeMap;
    
    public HuffmanTree(HashMap<Character, Integer> frequencyMap) {
        buildTree(frequencyMap);
        codeMap = new HashMap<>();
        reverseCodeMap = new HashMap<>();
        buildCodeMap(root, "");
    }
    
    private void buildTree(HashMap<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        
        for (char c : frequencyMap.keySet()) {
            priorityQueue.add(new HuffmanNode(c, frequencyMap.get(c)));
        }
        
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            
            HuffmanNode parent = new HuffmanNode('\0', left.getFrecuencia() + right.getFrecuencia(), left, right);
            priorityQueue.add(parent);
        }
        
        root = priorityQueue.poll();
    }
    
    private void buildCodeMap(HuffmanNode node, String code) {
        if (node.isLeaf()) {
            codeMap.put(node.getCaracter(), code);
            reverseCodeMap.put(code, node.getCaracter());
            return;
        }
        
        buildCodeMap(node.getLeft(), code + "0");
        buildCodeMap(node.getRight(), code + "1");
    }
    
    public String getCode(char caracter) {
        return codeMap.get(caracter);
    }
    
    public Character getCharacter(String code) {
        return reverseCodeMap.get(code);
    }
}