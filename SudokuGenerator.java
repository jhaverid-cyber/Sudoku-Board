import java.util.ArrayList;
public class SudokuGenerator extends ConsoleProgram{
    public void run(){
        int[][] sudoku = new int[9][9];
        makeBoard(sudoku);
        printBoard(sudoku);
    }
    
    private void printBoard(int[][] board){
        for (int row = 0; row < board.length; row++) {
            if (row % 3 == 0){
                System.out.println("+-------+-------+-------+");
            }
            for (int col = 0; col < board[0].length; col++) {
                if (col % 3 == 0){
                    System.out.print("| ");
                }
                int value = board[row][col];
                System.out.print(value + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }

    private void makeBoard(int[][] board){
        for (int row = 0; row < board.length; row++){
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= 9; i++){
                nums.add(i);
            }
            randomnessSudukoThing(nums);

            for (int col = 0; col < board[0].length; col++){
                int attempts = nums.size(); 
                while (attempts > 0){
                    int num = nums.get(0);
                    if (checkRow(board[row], num) && checkCol(board, col, num) && checkBox(board, row, col, num)){
                        board[row][col] = num;
                        nums.remove(0);
                        break;
                    } else {
                        nums.add(nums.remove(0)); //this checks if the number works, and if it doesnt work, put it at the end of the list and try it later.
                        attempts--;
                    }
                }
            }
        }
    }

    private void randomnessSudukoThing(ArrayList<Integer> list){
        for (int i = list.size() - 1; i > 0; i--){
            int randIndex = (int)(Math.random()*(i + 1));
            int temp = list.get(i);
            list.set(i, list.get(randIndex));
            list.set(randIndex, temp);
        }
    }

    private boolean checkRow(int[] nums, int value){
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == value){
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int[][] nums, int col, int value){
        for (int i = 0; i < nums.length; i++){
            if (nums[i][col] == value){
                return false;
            }
        }
        return true;
    }

    private boolean checkBox(int[][] nums, int row, int col, int value){
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        int endRow = startRow + 3;
        int endCol = startCol + 3;

        for (int i = startRow; i < endRow; i++){
            for (int j = startCol; j < endCol; j++){
                if (nums[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }
}ConsoleProgram.java:
----
import java.util.*;

public class ConsoleProgram{

    private Scanner scanner;
    private ArrayList<String> inputs;
    private int curInputIndex = 0;

    public static void main(String[] args){
        // Assume the class name is passed in as the first argument.

        if(args.length == 0){
            System.out.println("Please provide the name of the main class as an argument.");
            return;
        }

        String mainClassName = args[0];

        try{
            Class mainClass = Class.forName(mainClassName);
            Object obj = mainClass.newInstance();
            ConsoleProgram program = (ConsoleProgram)obj;
            program.run();
        } catch (IllegalAccessException ex) {
            System.out.println("Error in program. Make sure you extend ConsoleProgram");
        } catch (InstantiationException ex) {
            System.out.println("Error in program. Make sure you extend ConsoleProgram");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error in program. Make sure you extend ConsoleProgram");
        }
    }

    public void run(){
        /* Overridden by subclass */
    }

    public ConsoleProgram(){
        scanner = new Scanner(System.in);

    }

    /**
     * Allows you to set all inputs at once as strings.
     * @param inputStrings Array of strings to be inputs
     */
    public void setInputs(String[] inputStrings)
    {
        inputs = new ArrayList<String>(Arrays.asList(inputStrings));
    }

    /**
     * Allows you to add an input to your inputs.
     * @param s String to add
     */
    public void addInput(String s)
    {
        if (inputs == null)
        {
            inputs = new ArrayList<String>();
        }
        inputs.add(s);
    }

    public String readLine(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public boolean readBoolean(String prompt){

        while(true){
            String input = readLine(prompt);

            if(input.equalsIgnoreCase("true")){
                return true;
            }

            if(input.equalsIgnoreCase("false")){
                return false;
            }
        }
    }

    public double readDouble(String prompt){

        while(true){
            String input = readLine(prompt);
            try {
                double n = Double.valueOf(input).doubleValue();
                return n;
            } catch (NumberFormatException e){

            }
        }
    }

    // Allow the user to get an integer.
    public int readInt(String prompt){

        while(true){
            String input = readLine(prompt);
            try {
                int n = Integer.parseInt(input);
                return n;
            } catch (NumberFormatException e){

            }
        }
    }

    /**
     * Allows us to use a shorthand version for System.out.println()
     */
    public void println() {
        System.out.println();
    }

    /**
     * Allows us to use a shorthand version for System.out.println(String s)
     */
    public void println(String s) {
        System.out.println(s);
    }

    /**
     * Allows us to use a shorthand version for System.out.println(boolean x)
     */
    public void println(boolean x) {
        System.out.println(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.println(char x)
     */
    public void println(char x) {
        System.out.println(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.println(char[] x)
     */
    public void println(char[] x) {
        System.out.println(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.println(int x)
     */
    public void println(int x) {
        System.out.println(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.println(long x)
     */
    public void println(long x) {
        System.out.println(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.println(float x)
     */
    public void println(float x) {
        System.out.println(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.println(double x)
     */
    public void println(double x) {
        System.out.println(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.println(Object o)
     */
    public void println(Object o) {
        System.out.println(o);
    }

    /**
     * Allows us to use a shorthand version for System.out.print()
     */
    public void print() {
        System.out.print("");
    }

    /**
     * Allows us to use a shorthand version for System.out.print(String s)
     */
    public void print(String s) {
        System.out.print(s);
    }

    /**
     * Allows us to use a shorthand version for System.out.print(boolean x)
     */
    public void print(boolean x) {
        System.out.print(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.print(char x)
     */
    public void print(char x) {
        System.out.print(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.print(char[] x)
     */
    public void print(char[] x) {
        System.out.print(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.print(int x)
     */
    public void print(int x) {
        System.out.print(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.print(long x)
     */
    public void print(long x) {
        System.out.print(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.print(float x)
     */
    public void print(float x) {
        System.out.print(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.print(double x)
     */
    public void print(double x) {
        System.out.print(x);
    }

    /**
     * Allows us to use a shorthand version for System.out.print(Object o)
     */
    public void print(Object o) {
        System.out.print(o);
    }
}


\
