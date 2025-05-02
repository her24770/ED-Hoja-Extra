/**
 * clase HuffmanNode para representar un nodo en el árbol de Huffman.
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
    private char caracter;
    private int frecuencia;
    private HuffmanNode left, right;

    
    
    public HuffmanNode(char caracter, int frecuencia) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
    }
    
    public HuffmanNode(char caracter, int frecuencia, HuffmanNode left, HuffmanNode right) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
        this.left = left;
        this.right = right;
    }
    
    public boolean isLeaf() {
        return left == null && right == null;
    }
    
    @Override
    public int compareTo(HuffmanNode other) {
        return this.frecuencia - other.frecuencia;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }
}