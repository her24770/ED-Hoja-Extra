/**
 * Josue Hernández González - 24770
 * Huffman Compression
 * Hoja extra
 * Compresión y descompresión de texto usando el algoritmo de Huffman.
 * Este programa lee un archivo de texto, lo comprime usando Huffman, guarda el resultado en un archivo comprimido,
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Configuración de archivos
            String inputFile = "entrada.txt";
            String compressedFile = "comprimido.txt";
            String outputFile = "salida.txt";
            
            // 1. Leer archivo de entrada a Stack
            Stack<Character> inputStack = readFileToStack(inputFile);
            System.out.println("Texto original leído (" + inputStack.size() + " caracteres)");
            
            // 2. Comprimir
            Stack<String> compressedStack = HuffmanCompressor.compress(inputStack);
            writeCompressedFile(compressedFile, compressedStack);
            System.out.println("Texto comprimido guardado (" + compressedStack.size() + " códigos)");
            
            // 3. Leer archivo comprimido
            Stack<String> compressedFromFile = readCompressedFile(compressedFile);
            
            // 4. Descomprimir
            Stack<Character> outputStack = HuffmanCompressor.decompress(compressedFromFile);
            writeOutputFile(outputFile, outputStack);
            System.out.println("Texto descomprimido guardado (" + outputStack.size() + " caracteres)");
            
            // 5. Verificación
            System.out.println("Proceso completado.");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static Stack<Character> readFileToStack(String filename) throws IOException {
        Stack<Character> stack = new Stack<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int c;
            while ((c = reader.read()) != -1) {
                stack.push((char) c);
            }
        }
        return stack;
    }
    
    private static Stack<String> readCompressedFile(String filename) throws IOException {
        Stack<String> stack = new Stack<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Leer todo el contenido como una sola línea
            String line = reader.readLine();
            if (line != null) {
                // Dividir por espacios (asumiendo que los códigos están separados por espacios)
                String[] codes = line.split(" ");
                for (String code : codes) {
                    if (!code.isEmpty()) {
                        stack.push(code);
                    }
                }
            }
        }
        return stack;
    }
    
    private static void writeCompressedFile(String filename, Stack<String> stack) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Escribir todos los códigos en una sola línea separados por espacios
            for (String code : stack) {
                writer.write(code + " ");
            }
        }
    }
    
    private static void writeOutputFile(String filename, Stack<Character> stack) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Escribir todos los caracteres juntos
            for (Character c : stack) {
                writer.write(c);
            }
        }
    }
}